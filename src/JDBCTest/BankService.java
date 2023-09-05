package JDBCTest;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @ClassName Account
 * @Description
 * @Author Administrator
 * @Date 2023/3/31 14:15
 * @Version V1.0
 * 事务添加是在业务方法中
 * 利用try catch代码块，开启事务和事务提交、事务回滚
 * 将connection传入dao层即可，dao层不需要close()
 */
public class BankService {
   public void Service(String addAccount,String subAccount,int money) throws Exception{
       Bank bank = new Bank();
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello?rewriteBatchedStatements=true","root","200816");
       try {
           //开启事务
            connection.setAutoCommit(false);

           //执行数据库操作
           bank.add(addAccount,money,connection);
           System.out.println("--------");
           bank.sub(subAccount,money,connection);

           //事务提交
           connection.commit();
       }catch (Exception e){
           //事务结束，回滚
           connection.rollback();
           throw e;
       }

   }

   @Test
   public void test() throws Exception {
       Service("lily","mike",500);
   }
}
