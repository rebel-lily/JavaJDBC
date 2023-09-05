package hospital;

import hospital.Department.Department;
import hospital.Department.DepartmentDao;
import hospital.Department.DepartmentDaoImpl;
import hospital.User.User;
import hospital.User.UserDaoImpl;
import hospital.booking.Booking;
import hospital.booking.BookingDaoImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName HospitalTest
 * @Description 医院诊断系统
 * @Author Administrator
 * @Date 2023/4/19 13:42
 * @Version V1.0
 */
public class HospitalTest {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        UserDaoImpl userDao = new UserDaoImpl();
        System.out.print("输入手机号:");
        String phone = scan.nextLine();
        List<User> user = userDao.getUserList(phone);
        System.out.print("输入密码:");
        String password = scan.nextLine();
        if(userDao.select(phone,password)){
            System.out.println("登录成功");
        }else {
            System.out.println("账号或密码错误，请检查");
        }
        showBooking(user);
    }

    public static void showBooking(List<User> user){
        String name = user.get(0).getName();
        BookingDaoImpl bookingDao = new BookingDaoImpl();
        List<Booking> bookings = bookingDao.getBookingList(name);
        if (bookings!=null && !bookings.isEmpty()){
            if (bookings.get(0).getState().equals("有效")){
                System.out.println("-------------预约订单信息-------------");
                System.out.println("预约状态:" + bookings.get(0).getState());
                System.out.println("姓名:" + bookings.get(0).getName());
                System.out.println("预约编号:" + bookings.get(0).getAppnumber());
                System.out.println("费用:" + bookings.get(0).getCost());
                System.out.println("预约时间:" + bookings.get(0).getTime());
                System.out.println("预约科室:" + bookings.get(0).getDepartment());
                System.out.println("预约专家医生:" + bookings.get(0).getDoctor());
                System.out.println("------------------------------------");
            } else if (bookings.get(0).getState().equals("失效")){
                System.out.println("你的预约失效");
            }
        }else {
            System.out.println("没有您的预约信息,请预约");
            Appointment(name);
        }
    }

    public static void Appointment(String name){
        DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();
        List<Department> departments = departmentDao.getDepartmentList();
        int count = 0;
        System.out.println("总共科室:");
        System.out.println("----------------------------------------------------------------------------------");
        for (int i = 0;i < departments.size();i++){
            System.out.print((i+1) + ":");
            System.out.format("%-15s",departments.get(i).getDName());
            count++;
            if (count % 5 == 0){
                System.out.println();
            }
        }
        System.out.println("----------------------------------------------------------------------------------");
        System.out.print("请选择科室:");
        int number = scan.nextInt();
        //将所选的科室编号-1,把值赋值给department
        String department = departments.get(number-1).getDName();

    }
}
