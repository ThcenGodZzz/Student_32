package student.util;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import student.entity.Student;

public class DBCPDBUtils {
    static DBCPDemo DataSourceUtil;
    static int count = 0;

    //增删改操作
    public static boolean update(String sql, Object[] params) {
        QueryRunner runner = new QueryRunner(DBCPDemo.getDataSource());
        try {
            count = runner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    //查询数据数
    public static long getTotalCount(String sql, Object[] params) {
        QueryRunner runner = new QueryRunner(DBCPDemo.getDataSource());
        try {
            long n = runner.query(sql, new ScalarHandler<Long>(), params);
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //查询多条数据
    public static List<Student> queryAll(String sql, Object[] params) {
        QueryRunner runner = new QueryRunner(DBCPDemo.getDataSource());
        try {
            //将查询到的多条数据封装到javabean中
            List<Student> students = runner.query(sql, new BeanListHandler<Student>(Student.class), params);
            return students;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    //查询单条数据
    public static Student query(String sql, Object[] params) {
        QueryRunner runner = new QueryRunner(DBCPDemo.getDataSource());
        try {
            Student student = runner.query(sql, new BeanHandler<Student>(Student.class), params);
            return student;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
