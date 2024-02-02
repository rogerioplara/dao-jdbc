package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entity.Department;
import model.entity.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// métodos da classe Seller
public class SellerDaoJDBC implements SellerDao {

    // dependência com a conexão do banco de dados
    private Connection conn;

    // construtor da conexão
    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }


    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Seller> findByDepartment(Department department){
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                "SELECT seller.*, department.Name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE DepartmentId = ? "
                    + "ORDER BY Name"
            );

            st.setInt(1, department.getId());
            rs = st.executeQuery();

            List<Seller> sellersByDepartment = new ArrayList<>();
            // mapa de controle da instância dos departamentos - serve para não instanciar um novo departamento a cada objeto da lista
            // dessa forma, todos os sellers apontarão para o mesmo objeto department
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()){
                // reaproveitamento da instancia do departamento
                // teste se o departamento já existe na lista
                Department dep = map.get(rs.getInt("DepartmentId"));
                // instancia do departamento se o map for nulo
                if (dep == null){
                    dep = instantiateDepartmet(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                // populando o objeto seller - passa para a função o resultSet e o objeto department (dependência)
                Seller obj = instantiateSeller(rs, dep);
                // adicionando o vendedor na lista
                sellersByDepartment.add(obj);
            }

            return sellersByDepartment;


        } catch (SQLException e){
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public Seller findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                "SELECT seller.*, department.Name as DepName "
                + "FROM seller INNER JOIN department "
                + "ON seller.DepartmentId = department.Id "
                + "WHERE seller.Id = ?"
            );

            st.setInt(1, id);
            rs = st.executeQuery();

            // instanciação do objeto da consulta
            // teste se tem resultado
            if (rs.next()){
                // populando o objeto department - utilizando o resultado da consulta
                Department dep = instantiateDepartmet(rs);
                // populando o objeto seller - passa para a função o resultSet e o objeto department (dependência)
                Seller obj = instantiateSeller(rs, dep);

                return obj;
            }
            // se a validação der false, retorna nulo
            return null;

        } catch (SQLException e){
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    // método de instanciação para reuso do objeto
    // o erro não será tratado aqui mas sim no try do método
    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
        Seller obj = new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBirthDate(rs.getDate("BirthDate"));
        obj.setDepartment(dep);
        return obj;
    }

    // método de instanciação para reuso do objeto
    private Department instantiateDepartmet(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                "SELECT seller.*, department.Name as DepName "
                + "FROM seller INNER JOIN department "
                + "ON seller.DepartmentId = department.Id "
                + "ORDER BY Name "
            );

            rs = st.executeQuery();

            List<Seller> sellers = new ArrayList<>();

            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()){

                Department dep = map.get(rs.getInt("DepartmentId"));

                if (dep == null){
                    dep = instantiateDepartmet(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                // populando o objeto seller - passa para a função o resultSet e o objeto department (dependência)
                Seller obj = instantiateSeller(rs, dep);
                // adicionando o vendedor na lista

                sellers.add(obj);
            }

            return sellers;


        } catch (SQLException e){
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
