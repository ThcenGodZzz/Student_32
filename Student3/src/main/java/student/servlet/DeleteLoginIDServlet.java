package student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.service.IStudentService;
import student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class DeleteLoginIDServlet
 */
public class DeleteLoginIDServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String ID = request.getParameter("UID");
        String pwd = request.getParameter("upwd");
        IStudentService service = new StudentServiceImpl();
        boolean result = service.checkLoginID(ID, pwd);
        boolean result1 = service.deleteLoginID(ID);
        response.setContentType("text/html;charest=UTF-8");
        response.setCharacterEncoding("utf-8");
        if (!result) {
            request.setAttribute("error2", "loginError");
            request.getRequestDispatcher("DeleteLoginID.jsp").forward(request, response);
        } else {
            request.setAttribute("error2", "nologinError");
            if (!result1) {
                request.setAttribute("error3", "deleteError");
                request.getRequestDispatcher("DeleteLoginID.jsp").forward(request, response);
            } else {
                request.setAttribute("error3", "nodeleteError");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
