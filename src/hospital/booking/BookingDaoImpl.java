package hospital.booking;

import hospital.DBUtil;
import hospital.User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName BookingDaoImpl
 * @Description
 * @Author Administrator
 * @Date 2023/4/19 15:09
 * @Version V1.0
 */
public class BookingDaoImpl implements BookingDao{
    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet resultSet = null;
    public Scanner scanner = new Scanner(System.in);

    @Override
    public Booking getBookingById(int id) {
        Booking bookings = null;
        connection = DBUtil.getConnection();
        String sql = "select * from hello.booking where id=?";
        Object[] objects = {id};
        resultSet = DBUtil.getResult(sql,objects,connection);
        try {
            while (resultSet.next()){
                Booking booking = new Booking(
                        resultSet.getInt("id"),
                        resultSet.getString("state"),
                        resultSet.getString("name"),
                        resultSet.getString("appnumber"),
                        resultSet.getInt("cost"),
                        resultSet.getString("time"),
                        resultSet.getString("department"),
                        resultSet.getString("doctor")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookings;
    }

    @Override
    public List<Booking> getBookingList(String name) {
        List<Booking> bookings = new ArrayList<>();
        connection = DBUtil.getConnection();
        String sql = "select b.* from hospitaluser h INNER JOIN booking b ON h.name = b.name where b.name=?";
        Object[] obj = {name};
        resultSet = DBUtil.getResult(sql,obj,connection);
        try {
            while (resultSet.next()){
                Booking booking = new Booking(
                        resultSet.getInt("id"),
                        resultSet.getString("state"),
                        resultSet.getString("name"),
                        resultSet.getString("appnumber"),
                        resultSet.getInt("cost"),
                        resultSet.getString("time"),
                        resultSet.getString("department"),
                        resultSet.getString("doctor")
                );
                bookings.add(booking);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return bookings;
    }

    @Override
    public int addBooking(Booking booking) {
        connection = DBUtil.getConnection();
        String sql = "insert into hello.booking(state,name,appnumber,cost,time,department,doctor) values(?,?,?,?,?,?,?)";
        Object[] objects = {booking.getState(),booking.getName(),booking.getAppnumber(),booking.getCost(),booking.getTime(),booking.getDepartment(),booking.getDoctor()};
        int count = DBUtil.executeUpdate(sql,objects,connection);
        return count;
    }


}
