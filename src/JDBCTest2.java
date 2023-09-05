import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @ClassName JDBCTest2
 * @Description
 * @Author Administrator
 * @Date 2023/3/17 10:06
 * @Version V1.0
 */
public class JDBCTest2 {
    /*
    1.明确jdbc的使用流程 和 详细讲解内部api方法
    2.发现问题，引用prepareStatement

    T000
        输入账号和密码
        进行数据库信息查询
        反馈登录成功还是登录失败

    T000
        1.键盘输入事件，手机账号和密码信息
        2.注册驱动
        3.获取连接
        4.创建statement
        5.发送查询SQL访问，并获取返回结果
        6.结果判断，显示登录成功还是失败
        7.关闭资源
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //获取账号和密码
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入账号：");
        String account = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        //注册驱动
        /*
        会注册两次驱动
            1.DriverManager.registerDriver()本身
            2.Driver.static{DriverManager.registerDriver()} 静态代码块也会注册一次
            解决：只想注册一次驱动
                 只触发静态代码块即可
            触发静态代码块：
                 类加载机制：类加载的时刻，会触发静态代码块
                           加载{class文件 -> jvm虚拟机的class对象）
                           连接
                           初始化
            触发类加载：
                 1.new关键字
                 2.调用静态方法
                 3.调用静态属性
                 4.接口
                 5.反射
                 6.子类触发父类
                 7.程序的入口main
         */

        //DriverManager.registerDriver(new Driver());

        //字符串 -> 提取到外部的配置文件 -> 可以在不改变代码的情况下，安装数据库的驱动
        Class.forName("com.mysql.cj.jdbc.Driver");


    }
}
