package hospital;

import java.sql.*;

/**
 * @ClassName DButil
 * @Description
 * @Author Administrator
 * @Date 2023/4/19 13:44
 * @Version V1.0
 */
public class DBUtil {
    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet resultSet = null;

    public static Connection getConnection(){
        String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/hello";
        String userName = "root";
        String password = "200816";
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url,userName,password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    //三个资源关闭
    public static void close(){
        if (resultSet != null){
            try {
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (preparedStatement != null){
            try {
                preparedStatement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    //公共查询方法
    public static ResultSet getResult(String sql, Object[] objects, Connection connection){
        try {
            preparedStatement = connection.prepareStatement(sql);
            if(objects != null){
                int i = 1;
                for (Object val : objects){
                    preparedStatement.setObject(i++,val);
                }
            }
            resultSet =preparedStatement.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }

    //添加修改删除三个功能的公共方法
    public static int executeUpdate(String sql, Object[] objects, Connection connection){
        int excuteCount = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (objects.length > 0){
                int index = 1;
                for(Object o : objects){
                    preparedStatement.setObject(index++,o);
                }
            }
            excuteCount = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return excuteCount;
    }

}
