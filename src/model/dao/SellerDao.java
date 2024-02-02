package model.dao;

import model.entity.Department;
import model.entity.Seller;

import java.util.List;
import java.util.Map;

public interface SellerDao {

    void insert(Seller obj);
    void update(Seller obj);
    void deleteById(Integer id);

    List<Seller> findByDepartment(Department department);

    Seller findById(Integer id);
    List<Seller> findAll();
}
