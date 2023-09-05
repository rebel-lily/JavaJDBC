import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName JDBCTest3
 * @Description
 * @Author Administrator
 * @Date 2023/3/22 13:49
 * @Version V1.0
 */
public class JDBCTest3 {
   @Test
   public void testInsert() throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost","root","200816");
       String sql = "insert into hello.people(id,name) values(?,?)";
       PreparedStatement preparedStatement = connection.prepareStatement(sql);
       preparedStatement.setObject(1,4);
       preparedStatement.setObject(2,"王洪");
       int rows = preparedStatement.executeUpdate();
       if(rows > 0){
           System.out.println("插入成功");
       }else {
           System.out.println("插入失败");
       }
       preparedStatement.close();
       connection.close();
   }

   @Test
   public void testUpdate() throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost","root","200816");
       String sql = "update hello.people set name=? where id=?";
       PreparedStatement preparedStatement = connection.prepareStatement(sql);
       preparedStatement.setObject(1,"建元");
       preparedStatement.setObject(2,1);
       int rows = preparedStatement.executeUpdate();
       if(rows > 0){
           System.out.println("修改成功");
       }else {
           System.out.println("修改失败");
       }
       preparedStatement.close();
       connection.close();
   }

   @Test
   public void testDelete() throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost","root","200816");
       String sql = "Delete from hello.people where id=?";
       PreparedStatement preparedStatement = connection.prepareStatement(sql);
       preparedStatement.setObject(1,2);
       int rows = preparedStatement.executeUpdate();
       if (rows > 0){
           System.out.println("删除成功");
       }else {
           System.out.println("删除失败");
       }
       preparedStatement.close();
       connection.close();
   }

   @Test
   public void testSelect() throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost","root","200816");
       String sql = "Select * from hello.people";
       PreparedStatement preparedStatement = connection.prepareStatement(sql);
       ResultSet resultSet = preparedStatement.executeQuery();
       /*
       resultSet:有行和有列，获取数据的时候，一行一行数据
                 内部有一个游标，默认指向数据的第一行之前
                 我们可以利用next()方法移动游标
                 获取行中的列的数据
        */
       List<Map> list = new ArrayList<>();

       //获取列的信息对象
       ResultSetMetaData metaData = resultSet.getMetaData();

       int columnCount = metaData.getColumnCount();

       while (resultSet.next()){
           Map map = new HashMap();
//           map.put("id",resultSet.getInt("id"));
//           map.put("name",resultSet.getString("name"));
           for (int i = 1;i <= columnCount;i++){
               //获取指定列下角标的值
               Object value = resultSet.getObject(i);
               //获取指定列下角标的值 resultSetMetaData
               String columnLabel = metaData.getColumnLabel(i);

               map.put(columnLabel,value);
           }
           list.add(map);
       }
       System.out.println("list =" + list);
       resultSet.close();
       preparedStatement.close();
       connection.close();

   }
}
