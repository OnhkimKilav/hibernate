package lesson2;

public class Demo {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        Product product = new Product();
        product.setName("table new");
        product.setDescription("grey&blue");
        product.setPrice(70);

        productDAO.save(product);

        //System.out.println(productDAO.findById(6));
    }
}
