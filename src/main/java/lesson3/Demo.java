package lesson3;

public class Demo {
    public static void main(String[] args) {
        HotelDAO hotelDAO = new HotelDAO();

        Hotel hotel = new Hotel();
        hotel.setCity("Donetsk");
        hotel.setCountry("Ukraine");
        hotel.setName("Ramada");
        hotel.setStreet("Shevchenko");

        hotelDAO.save(hotel);
    }
}
