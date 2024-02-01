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

        // isola a implementação, o programa só conhece a interface
        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
    }
}