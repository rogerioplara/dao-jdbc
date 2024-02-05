import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entity.Department;
import model.entity.Seller;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
        DAO - Data access object
         */

        // isola a implementação, o programa só conhece a interface
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Test 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println();


        System.out.println("=== Test 2: seller findByDepartment ===");

        Department department = new Department(3, null);
        List<Seller> sellerByDepartment = sellerDao.findByDepartment(department);
        sellerByDepartment.forEach(System.out::println);
        System.out.println();

        System.out.println("=== Test 3: seller findAll ===");
        List<Seller> sellers = sellerDao.findAll();
        sellers.forEach(System.out::println);
        System.out.println();

        System.out.println("=== Test 4: seller insert ===");
        Seller newSeller = new Seller(
            null,
            "Greg",
            "greg@gmail.com",
            new Date(),
            4000.0,
            department
        );
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());
        System.out.println();




    }
}