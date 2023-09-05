package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @ClassName Bank
 * @Description
 * @Author Administrator
 * @Date 2023/3/31 14:10
 * @Version V1.0
 */
public class Bank {
    public void add(String account,int money,Connection connection) throws Exception{

        String sql = "update hello.bank set money = money + ? where account = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setObject(1,money);
        statement.setObject(2,account);

        statement.executeUpdate();

        statement.close();
        connection.close();

        System.out.println("加钱成功");
    }

    public void sub(String account,int money,Connection connection) throws Exception{

        String sql = "update hello.bank set money = money - ? where account = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setObject(1,money);
        statement.setObject(2,account);

        statement.executeUpdate();

        statement.close();
        connection.close();

        System.out.println("减钱成功");
    }
}
