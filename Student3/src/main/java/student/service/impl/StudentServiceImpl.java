package student.service.impl;

import java.util.List;

import student.dao.IStudentDao;
import student.dao.impl.StudentDaoImpl;
import student.entity.Student;
import student.service.IStudentService;

//业务逻辑层：逻辑性的增删改查（增：查+增），对dao层进行的组装
public class StudentServiceImpl implements IStudentService {
    IStudentDao studentDao = new StudentDaoImpl();

    //查询全部学生信息
    public List<Student> queryAllStudents() {
        return studentDao.queryAllStudents();
    }

    //按照学号查询学生信息
    public Student queryStudentBySno(int sno) {
        return studentDao.queryStudentBySno(sno);

    }

    //删除学生信息
    public boolean deleteStudentBySno(int sno) {
        if (studentDao.isExist(sno)) {
            return studentDao.deleteStudentBySno(sno);
        }
        return false;
    }


    //更改学生信息
    public boolean updateStudentBySno(int sno, Student student) {
        return studentDao.updateStudentBySno(sno, student);
    }


    //增加学生信息
    public boolean addStudent(Student student) {
        if (!studentDao.isExist(student.getSno())) {
            studentDao.addStudent(student);
            return true;
        } else {
            System.out.println("学号重复！");
            return false;
        }
    }

    //查询总条数
    @Override
    public int getTotalCount() {
        return studentDao.getTotalCount();
    }

    //查询当前页的数据集合
    @Override
    public List<Student> queryStudentsByPage(int current, int pageSize) {
        return studentDao.queryStudentByPage(current, pageSize);
    }


    @Override
    public boolean checkLoginID(String ID, String pwd) {
        return studentDao.checkLoginID(ID, pwd);
    }

    @Override
    public boolean addLoginID(String ID, String pwd) {
        return studentDao.addLoginID(ID, pwd);

    }

    @Override
    public boolean updateLoginPwd(String ID, String pwd1) {
        return studentDao.updateLoginPwd(ID, pwd1);
    }

    @Override
    public boolean deleteLoginID(String ID) {
        return studentDao.deleteLoginID(ID);
    }

    @Override
    public boolean IDExist(String ID) {
        return studentDao.IDExist(ID);
    }

    @Override
    public boolean upLoadWork(int sno, String name) {
        return studentDao.upLoadWork(sno, name);
    }


}
