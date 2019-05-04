package lesson4.controller;

import lesson4.model.Hotel;
import lesson4.service.HotelService;

import java.util.ArrayList;

public class HotelController {
    private HotelService hotelService = new HotelService();

    public HotelController() throws Exception {
    }

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        return hotelService.findHotelByName(name);
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        return hotelService.findHotelByCity(city);
    }
}
