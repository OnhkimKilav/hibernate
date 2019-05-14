package lesson4.demo;

import lesson4.DAO.HotelDAO;

/**
 * Created by Valik on 05.11.2018.
 */
public class DemoHotel {
    public static void main(String[] args) throws Exception {
        /*HotelController hotelController = new HotelController();
        DemoUser.main(args);
        System.out.println("find hotel by name");
        System.out.println(hotelController.findHotelByName("Ug"));
        System.out.println("find hotel by city");
        System.out.println(hotelController.findHotelByCity("Kiev"));*/
        HotelDAO hotelDAO = new HotelDAO();
    }
}
