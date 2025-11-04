package student.service;

import java.util.List;

import student.entity.Student;

public interface IStudentService {
	//查询全部学生信息
	public List<Student> queryAllStudents();
	//按照学号查询学生信息
	public Student queryStudentBySno(int sno);
	//删除学生信息
	public boolean deleteStudentBySno(int sno) ;
	
	//更改学生信息
	public boolean updateStudentBySno(int sno, Student student) ;
	
	//增加学生信息
	public boolean addStudent(Student student) throws Exception ;
	
	//查询总数据
	public int getTotalCount();
	//分页
	public List<Student> queryStudentsByPage(int current, int pageSize);
	//检查登陆账户和密码
	public boolean checkLoginID(String ID,String pwd);
	//注册账户
	public boolean addLoginID(String ID, String pwd);
	//更改密码
	public boolean updateLoginPwd(String ID,String pwd1);
	//注销账号
	public boolean deleteLoginID(String ID);
	//判断ID是否存在
	public boolean IDExist(String ID);
	//判断上传作业输入的学生信息是否存在
	public boolean upLoadWork(int sno, String name);

}
