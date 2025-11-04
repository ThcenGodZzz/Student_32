package student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.service.IStudentService;
import student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class UpdateLoginPwdServlet
 */
public class UpdateLoginPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String ID = request.getParameter("UID");
		String pwd = request.getParameter("upwd");
		String pwd1 = request.getParameter("upwd1");
		IStudentService service = new StudentServiceImpl();
		boolean result = service.checkLoginID(ID,pwd);
		response.setContentType("text/html;charest=UTF-8");
		response.setCharacterEncoding("utf-8");
		if(!result) {
			request.setAttribute("error0", "loginError");
			request.getRequestDispatcher("UpdateLoginPwd.jsp").forward(request, response);
		}else {
			request.setAttribute("error0", "nologinError");
			boolean result1 = service.updateLoginPwd(ID,pwd1);
			if(!result1) {
				request.getRequestDispatcher("UpdateLoginPwd.jsp").forward(request, response);
			}else {
				request.setAttribute("error1", "noupdateError");
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
