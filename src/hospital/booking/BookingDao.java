package hospital.booking;

import java.util.List;

/**
 * @ClassName bookingDao
 * @Description
 * @Author Administrator
 * @Date 2023/4/19 15:08
 * @Version V1.0
 */
public interface BookingDao {
    Booking getBookingById(int id);
    List<Booking> getBookingList(String name);
    int addBooking(Booking booking);
}
