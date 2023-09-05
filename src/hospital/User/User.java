package hospital.User;

/**
 * @ClassName User
 * @Description
 * @Author Administrator
 * @Date 2023/4/19 13:53
 * @Version V1.0
 */
public class User {
    private int id;
    private String name;
    private String password;
    private String phone;

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(int id, String name, String password, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
