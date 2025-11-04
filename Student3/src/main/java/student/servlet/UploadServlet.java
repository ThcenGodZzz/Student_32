package student.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import student.service.IStudentService;
import student.service.impl.StudentServiceImpl;


public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String name = null;
		int sno = -1;
		
		boolean isMutipart = ServletFileUpload.isMultipartContent(request);
		if(isMutipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			factory.setRepository(new File("D:\\uploadtemp"));
			List<FileItem> items = null;
				try {
					items = upload.parseRequest(request);
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			Iterator<FileItem> iter = items.iterator();
			while(iter.hasNext()) {
				FileItem item= iter.next();
				String fileName = item.getName();
				String itemName = item.getFieldName();
				if(item.isFormField()) {
					if(itemName.equals("name")){
						name = item.getString("utf-8");
					}else if(itemName.equals("sno")) {
						sno =Integer.parseInt(item.getString("utf-8"));
					}else {
						
					}
				}else {
					//定义上传路径：指定上传的位置
					String path = "D:\\upload";
					File file = new File(path,fileName);
						try {
							item.write(file);
							} catch (Exception e) {
							e.printStackTrace();
							}
			}
		}
		IStudentService studentService = new StudentServiceImpl();
		boolean result = studentService.upLoadWork(sno,name);
		
		System.out.println(name+sno);
		System.out.println(result);
		if(!result) {
			request.setAttribute("error3", "uploadError");
			request.getRequestDispatcher("QueryStudentByPageServlet").forward(request, response);
			
		}else{
			request.setAttribute("error3", "nouploadError");
			request.getRequestDispatcher("QueryStudentByPageServlet").forward(request, response);
			
		}
		}
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
