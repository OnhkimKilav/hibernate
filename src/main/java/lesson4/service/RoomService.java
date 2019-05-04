package lesson4.service;

import lesson4.DAO.RoomDAO;
import lesson4.model.Filter;
import lesson4.model.Room;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Valik on 05.11.2018.
 */
public class RoomService {
    private RoomDAO roomDAO = new RoomDAO();

    public RoomService() {
    }

    public List<Room> findRoom(Filter filter) {
        List<Room> rooms = new ArrayList<>();
        for (Room room : roomDAO.findRooms(filter)) {
            if (room.getDateAvailableFrom().equals(filter.getDateAvailableFrom()) && room.getPrice() == filter.getPrice() &&
                    room.isBreakfastIncluded() == filter.isBreakfastIncluded() && room.isPetsAllowed() == filter.isPetsAllowed() &&
                    room.getHotel().getName().equals(filter.getName()) && room.getHotel().getCountry().equals(filter.getCountry()) &&
                    room.getHotel().getCity().equals(filter.getCity()) && room.getHotel().getStreet().equals(filter.getStreet())) {
                rooms.add(room);
            }
        }
        return rooms;
    }

    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception {
        roomDAO.bookRoom(roomId, userId, dateFrom, dateTo);
    }

    public void cancelReservation(long roomId, long userId) {
        roomDAO.cancelReservation(roomId, userId);
    }
}
