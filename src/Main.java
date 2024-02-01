import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entity.Department;
import model.entity.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        /*
        DAO - Data access object
         */

        Department obj = new Department(1, "Library");

        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.00, obj);

        // isola a implementação, o programa só conhece a interface
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(obj);

        System.out.println(seller);

    }
}