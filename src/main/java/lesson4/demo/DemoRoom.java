package lesson4.demo;


import lesson4.DAO.RoomDAO;
import lesson4.model.Hotel;
import lesson4.model.Room;
import lesson4.service.RoomService;

import java.util.Date;

/**
 * Created by Valik on 05.11.2018.
 */
public class DemoRoom {
    public static void main(String[] args) throws Exception {
        RoomDAO roomDAO = new RoomDAO();
        RoomService roomService = new RoomService();
        //Room room = new Room(2, 1500, true, false, new Date(), new Hotel("Ug", "Ukraine", "Kiev", "test"));
        //System.out.println(room.getDateAvailableFrom());

    }
}
