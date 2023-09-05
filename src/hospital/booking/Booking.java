package hospital.booking;

/**
 * @ClassName booking
 * @Description
 * @Author Administrator
 * @Date 2023/4/19 15:04
 * @Version V1.0
 * 预约
 */
public class Booking {
    private int id;
    private String state;
    private String name;
    private String appnumber;
    private int cost;
    private String time;
    private String department;
    private String doctor;

    public Booking(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppnumber() {
        return appnumber;
    }

    public void setAppnumber(String appnumber) {
        this.appnumber = appnumber;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Booking(int id, String state, String name, String appnumber, int cost, String time, String department, String doctor) {
        this.id = id;
        this.state = state;
        this.name = name;
        this.appnumber = appnumber;
        this.cost = cost;
        this.time = time;
        this.department = department;
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "预约订单信息" + '\n' +
                "预约状态:" + state +  '\n' +
                "姓名:" + name +  '\n' +
                "预约编号:" + appnumber  + '\n' +
                "费用:" + cost + '\n' +
                "预约时间:" + time +  '\n' +
                "预约科室:" + department + '\n' +
                "预约专家医生:" + doctor
                ;
    }
}
