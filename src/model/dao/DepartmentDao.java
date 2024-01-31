package model.dao;

import model.entity.Department;

import java.util.List;

public interface DepartmentDao {

    // implementação do dao de department (métodos de interação com o banco de dados)
    void insert(Department obj);
    void update(Department obj);
    void deleteById(Integer id);
    Department findById(Integer id);
    List<Department> findAll();
}
