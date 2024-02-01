package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
    // classe que faz a instância dos Daos

    //
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC();
    }
}
