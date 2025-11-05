package student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.service.IStudentService;
import student.service.impl.StudentServiceImpl;


public class CheckLoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String ID = request.getParameter("UID");
        String pwd = request.getParameter("upwd");
        IStudentService service = new StudentServiceImpl();
        boolean result = service.checkLoginID(ID, pwd);
        response.setContentType("text/html;charest=UTF-8");
        response.setCharacterEncoding("utf-8");
        if (!result) {
            request.setAttribute("error", "loginError");
        } else {
            request.setAttribute("error", "nologinError");
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
