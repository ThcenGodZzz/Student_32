package student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.service.IStudentService;
import student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class DeleteStudentServlet
 */
public class DeleteStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int sno = Integer.parseInt(request.getParameter("sno"));
		IStudentService service = new StudentServiceImpl();
		boolean result = service.deleteStudentBySno(sno);
		response.setContentType("text/html;charest=UTF-8");
		response.setCharacterEncoding("utf-8");
		if(!result) {
			request.setAttribute("error1", "deleteError");
		}else {
			request.setAttribute("error1", "nodeleteError");
		}
		request.getRequestDispatcher("QueryStudentByPageServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
