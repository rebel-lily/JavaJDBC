package hospital.Department;

import hospital.DBUtil;
import hospital.User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName DepartmentDaoImpl
 * @Description
 * @Author Administrator
 * @Date 2023/4/19 16:39
 * @Version V1.0
 */
public class DepartmentDaoImpl implements DepartmentDao{
    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet resultSet = null;
    public Scanner scanner = new Scanner(System.in);

    @Override
    public List<Department> getDepartmentList() {
        List<Department> departments = new ArrayList<>();
        connection = DBUtil.getConnection();
        String sql = "select * from hello.department";
        resultSet = DBUtil.getResult(sql,null,connection);
        try {
            while (resultSet.next()){
                Department department = new Department(
                        resultSet.getInt("id"),
                        resultSet.getString("DName")
                );
                departments.add(department);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return departments;
    }
}
