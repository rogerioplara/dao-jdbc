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

        System.out.println(obj);

        System.out.println(seller);

    }
}