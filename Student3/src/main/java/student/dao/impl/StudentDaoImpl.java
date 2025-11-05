package student.dao.impl;

import java.util.List;

import student.dao.IStudentDao;
import student.entity.Student;
import student.util.DBCPDBUtils;
import student.util.DBCPDemo;

public class StudentDaoImpl implements IStudentDao {
    static DBCPDemo DataSourceUtil;

    //查询全部学生信息
    public List<Student> queryAllStudents() {
        String sql = "select * from student1";
        return (List<Student>) DBCPDBUtils.queryAll(sql, null);
    }

    //判断此人是否存在
    public boolean isExist(int sno) {
        return queryStudentBySno(sno) == null ? false : true;
    }

    //增加学生信息
    public boolean addStudent(Student student) {
        String sql = "insert into student1(name,sno,age,dept) values(?,?,?,?)";
        Object[] params = {student.getName(), student.getSno(), student.getAge(), student.getDept()};
        return DBCPDBUtils.update(sql, params);
    }

    //删除学生信息
    public boolean deleteStudentBySno(int sno) {
        String sql = "delete from student1 where sno =?";
        Object[] params = {sno};
        return DBCPDBUtils.update(sql, params);
    }

    //根据sno找到要修改的学生，然后再进行修改
    public boolean updateStudentBySno(int sno, Student student) {
        String sql = "update student1 set name =?,age=?,dept=? where sno=?";
        Object[] params = {student.getName(), student.getAge(), student.getDept(), sno};
        return DBCPDBUtils.update(sql, params);
    }

    //根据学号查询学生信息
    public Student queryStudentBySno(int sno) {
        String sql = "select * from student1 where sno = ?";
        Object[] params = {sno};
        return DBCPDBUtils.query(sql, params);
    }


    @Override
    public int getTotalCount() {//查询总数据数
        String sql = "select count(1) from student1";
        return (int) DBCPDBUtils.getTotalCount(sql, null);
    }

    //分页显示
    @Override
    public List<Student> queryStudentByPage(int currentPage, int pageSize) {
        String sql = "select * from student1 order by sno asc limit ?,?";
        Object[] params = {currentPage * pageSize, pageSize};
        return (List<Student>) DBCPDBUtils.queryAll(sql, params);
    }


    @Override
    public boolean checkLoginID(String ID, String pwd) {
        String sql = "select count(*)from login where ID=? and pwd=?";
        Object[] params = {ID, pwd};
        if (DBCPDBUtils.getTotalCount(sql, params) > 0)
            return true;
        else
            return false;
    }


    @Override
    public boolean addLoginID(String ID, String pwd) {
        // TODO Auto-generated method stub
        String sql = "insert into login(ID,pwd) values(?,?)";
        Object[] params = {ID, pwd};
        return DBCPDBUtils.update(sql, params);
    }


    @Override
    public boolean updateLoginPwd(String ID, String pwd1) {
        String sql = "update login set pwd =? where ID=?";
        Object[] params = {pwd1, ID};
        return DBCPDBUtils.update(sql, params);
    }


    @Override
    public boolean deleteLoginID(String ID) {
        String sql = "delete from login where ID =?";
        Object[] params = {ID};
        return DBCPDBUtils.update(sql, params);
    }


    @Override
    public boolean IDExist(String ID) {
        String sql = "select count(*) from login where ID = ?";
        Object[] params = {ID};
        if ((int) DBCPDBUtils.getTotalCount(sql, params) > 0)
            return true;
        else
            return false;
    }


    @Override
    public boolean upLoadWork(int sno, String name) {
        String sql = "select count(*) from student1 where sno = ? and name = ?";
        Object[] params = {sno, name};
        if ((int) DBCPDBUtils.getTotalCount(sql, params) > 0)
            return true;
        else
            return false;
    }
}