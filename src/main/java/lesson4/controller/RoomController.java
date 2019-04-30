package lesson4.controller;

public class RoomController {
    private RoomService roomService = new RoomService();

    public RoomController() throws Exception {
    }

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        roomService.bookRoom(roomId, userId, hotelId);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        roomService.cancelReservation(roomId, userId);
    }
}
