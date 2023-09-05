package hospital.User;

import hospital.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName UserDaoImpl
 * @Description
 * @Author Administrator
 * @Date 2023/4/19 13:56
 * @Version V1.0
 */
public class UserDaoImpl implements UserDao{
    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet resultSet = null;
    public Scanner scanner = new Scanner(System.in);

    @Override
    public User getUserById(int id) {
        User users = null;
        connection = DBUtil.getConnection();
        String sql = "select * from hello.hospitaluser where id=?";
        Object[] objects = {id};
        resultSet = DBUtil.getResult(sql,objects,connection);
        try {
            while (resultSet.next()){
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getString("phone")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<User> getUserList(String phone) {
        List<User> users = new ArrayList<>();
        connection = DBUtil.getConnection();
        String sql = "select * from hello.hospitaluser where phone=?";
        Object[] obj = {phone};
        resultSet = DBUtil.getResult(sql,obj,connection);
        try {
            while (resultSet.next()){
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getString("phone")
                );
                users.add(user);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public boolean select(String phone,String password) throws SQLException {
        boolean flag = false;
        connection = DBUtil.getConnection();
        String sql = "select * from hello.hospitaluser where password=? and phone=?";
        Object[] objects = {password,phone};
        resultSet = DBUtil.getResult(sql,objects,connection);
        int rowCount = 0;
        if (resultSet.next()){
            rowCount++;
        }
        if (rowCount == 1){
            flag = true;
        }
        return flag;
    }
}
