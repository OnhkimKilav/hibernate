package lesson4.service;

import lesson4.DAO.HotelDAO;
import lesson4.model.Hotel;

import java.util.ArrayList;

public class HotelService {
    public HotelService() {
    }

    public ArrayList<Hotel> findHotelByName(String name) {
        HotelDAO hotelDAO = new HotelDAO();
        //Validate.validateUserLogIn();

        ArrayList<Hotel> hotels = new ArrayList<>();
        for (Hotel hotel : hotelDAO.findHotelByName(name)) {
            if (hotel.getName().equals(name))
                hotels.add(hotel);
        }
        return hotels;
    }

    public ArrayList<Hotel> findHotelByCity(String city){
        HotelDAO hotelDAO = new HotelDAO();
        //Validate.validateUserLogIn();

        ArrayList<Hotel> hotels = new ArrayList<>();

        for (Hotel hotel : hotelDAO.findHotelByCity(city)) {
            if (hotel.getCity().equals(city))
                hotels.add(hotel);
        }
        return hotels;
    }
}
