import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entity.Department;

import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // isola a implementação, o programa só conhece a interface
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 1: department findById ===");
        Department dep = departmentDao.findById(3);
        System.out.println(dep);
        System.out.println();

        System.out.println("=== Test 2: department findAll ===");
        List<Department> deps = departmentDao.findAll();
        deps.forEach(System.out::println);
        System.out.println();

        System.out.println("=== Test 3: department insert ===");
        Department newDep = new Department(null, "Clothing");
        departmentDao.insert(newDep);
        System.out.println("Inserted! New id = " + newDep.getId());
        System.out.println();

        System.out.println("=== Test 4: department update ===");
        dep = departmentDao.findById(4);
        dep.setName("Furniture");
        departmentDao.update(dep);
        System.out.println("Update completed");
        System.out.println();

        System.out.println("=== Test 5: department delete ===");
        System.out.println("Enter ID for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Department deleted");
        sc.close();
        System.out.println();

    }
}
