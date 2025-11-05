package student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.entity.Student;
import student.service.IStudentService;
import student.service.impl.StudentServiceImpl;

public class UpdateStudentServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int sno = Integer.parseInt(request.getParameter("sno"));
        int age = Integer.parseInt(request.getParameter("age"));
        String dept = request.getParameter("dept");
        Student student = new Student(name, age, dept);

        System.out.println(sno);

        IStudentService service = new StudentServiceImpl();
        boolean result = service.updateStudentBySno(sno, student);

        response.setContentType("text/html;charest=UTF-8");
        response.setCharacterEncoding("utf-8");
        if (!result) {
            request.setAttribute("error2", "updateError");
        } else {
            request.setAttribute("error2", "noupdateError");
        }

        request.getRequestDispatcher("QueryStudentByPageServlet").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
