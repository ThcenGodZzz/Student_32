package student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.entity.Page;
import student.entity.Student;
import student.service.IStudentService;
import student.service.impl.StudentServiceImpl;

public class QueryStudentByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public QueryStudentByPageServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService studentService = new StudentServiceImpl();
		int count = studentService.getTotalCount();
		
		Page page = new Page();
		
		
		String cPage = request.getParameter("currentPage");
		
		if(cPage == null) {
			cPage = "0";
		}
		int currentPage = Integer.parseInt(cPage);
		page.setCurrentPage(currentPage);

		int totalCount = studentService.getTotalCount();
		page.setTotalCount(totalCount);
		int pageSize = 4;
		
		page.setPageSize(pageSize);
		
		List<Student> students = studentService.queryStudentsByPage(currentPage, pageSize);
		
		page.setStudents(students);
		request.setAttribute("page1", page);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
