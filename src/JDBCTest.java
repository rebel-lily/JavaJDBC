import java.sql.*;

/**
 * @ClassName JDBCTest
 * @Description JDBC连接
 * @Author Administrator
 * @Date 2023/3/15 15:20
 * @Version V1.0
 */
public class JDBCTest {
    public static void main(String[] args) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = null;
        try {
            System.out.println("开始执行");

            //mysql8.0 com.mysql.cj.jdbc.Driver
            //mysql5.0 com.mysql.jdbc.Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello", "root", "200816");
            System.out.println("connection=" + connection);

            //创建Statement
            statement = connection.createStatement();

            //发送sql语句，并且获取返回结果
            String sql = "select * from hello.people";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
               System.out.println(resultSet.getObject(1) +" " + resultSet.getObject(2));
            }
            System.out.println("结束……");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源:从后往前关
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
