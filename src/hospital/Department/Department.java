package hospital.Department;

/**
 * @ClassName Department
 * @Description 科室
 * @Author Administrator
 * @Date 2023/4/19 16:36
 * @Version V1.0
 */
public class Department {
   private int id;
   private String DName;

   public Department(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDName() {
        return DName;
    }

    public void setDName(String DName) {
        this.DName = DName;
    }

    public Department(int id, String DName) {
        this.id = id;
        this.DName = DName;
    }
}
