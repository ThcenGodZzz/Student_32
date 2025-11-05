package student.dao;

import java.sql.SQLException;
import java.util.List;

import student.entity.Student;

public interface IStudentDao {
    public boolean updateLoginPwd(String ID, String pwd1);


    //查询全部学生信息
    public List<Student> queryAllStudents();


    //判断此人是否存在
    public boolean isExist(int sno);

    //增加学生信息
    public boolean addStudent(Student student);

    //删除学生信息
    public boolean deleteStudentBySno(int sno);

    //根据sno找到要修改的学生，然后再进行修改
    public boolean updateStudentBySno(int sno, Student student);

    //根据学号查询学生信息
    public Student queryStudentBySno(int sno);

    //查询总数据数
    public int getTotalCount();

    //currentPage:当前页（页码）pageSize:页面大小（每页显示的数据条数）
    public List<Student> queryStudentByPage(int currentPage, int pageSize);

    public boolean checkLoginID(String ID, String pwd);


    public boolean addLoginID(String ID, String pwd);


    public boolean deleteLoginID(String ID);


    public boolean IDExist(String ID);


    public boolean upLoadWork(int sno, String name);
}
