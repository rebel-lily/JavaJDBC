package hospital.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserDao
 * @Description
 * @Author Administrator
 * @Date 2023/4/19 13:55
 * @Version V1.0
 */
public interface UserDao {
    User getUserById(int id);
    List<User> getUserList(String phone);
    boolean select(String phone,String password) throws SQLException;
}
