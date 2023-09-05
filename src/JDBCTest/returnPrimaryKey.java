package JDBCTest;

import org.junit.Test;

import java.sql.*;

/**
 * @ClassName returnPrimaryKey
 * @Description
 * @Author Administrator
 * @Date 2023/3/31 10:14
 * @Version V1.0
 * 获取返回的主键
 */
public class returnPrimaryKey {
        @Test
        public void test01() throws Exception{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello","root","200816");
            String sql = "insert into hello.seat(name,numbering,remainder,Confirm) values(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setObject(1,"hello");
            statement.setObject(2,"S04");
            statement.setObject(3,"53");
            statement.setObject(4,"选座");

            int count = statement.executeUpdate();
            if(count > 0){
                ResultSet resultSet = statement.getGeneratedKeys();
                resultSet.next();
                int id = resultSet.getInt(1);
                System.out.println("id = " + id);
            }else {
                System.out.println("数据插入失败");
            }
            statement.close();
            connection.close();
    }

    @Test
    public void test02() throws Exception{
        //批量处理
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello?rewriteBatchedStatements=true","root","200816");
        String sql = "delete from hello.seat where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        long start = System.currentTimeMillis();

        for (int i = 1000;i < 10000;i++){
            statement.setObject(1,"hello" + i);

            //不执行,追加到values后面
            statement.addBatch();
        }

        statement.executeBatch();//执行批量操作

        long end = System.currentTimeMillis();

        System.out.println(end - start);
        statement.close();
        connection.close();
    }
}
