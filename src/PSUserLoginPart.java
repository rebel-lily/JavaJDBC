import java.sql.*;
import java.util.Scanner;

/**
 * @ClassName PSUserLoginPart
 * @Description
 * @Author Administrator
 * @Date 2023/3/17 10:35
 * @Version V1.0
 */
public class PSUserLoginPart {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入账号：");
        String account = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello", "root", "200816");

        /*
        statement
            1.创建statement
            2.拼接sql语句
            3.发送sql语句，并获取返回结果

        preparedstatement
            1.编写sql语句结果 不包含动态部分的语句
            2.创建preparedstatement，并传入动态值
            3.动态值 占位符 赋值 ？ 单独赋值即可
            4.发送sql语句，并获取返回结果
         */
        String sql = "select * from hello.User where account = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //5.单独的占位符进行赋值
        /*
        参数1：index 占位符的位置 从左到右
        参数2 object 占位符的值 可以设置任何类型的数据，避免我们拼接和类型更加丰富
         */
        preparedStatement.setObject(1,account);
        preparedStatement.setObject(2,password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
