package lesson4.controller;

import lesson4.model.Filter;
import lesson4.model.Room;
import lesson4.service.RoomService;

import java.util.Date;
import java.util.List;

public class RoomController {
    private RoomService roomService = new RoomService();

    public RoomController() throws Exception {
    }

    public List<Room> findRoom(Filter filter){
        return roomService.findRoom(filter);
    }

    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception {
        roomService.bookRoom(roomId, userId, dateFrom, dateTo);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        roomService.cancelReservation(roomId, userId);
    }
}
