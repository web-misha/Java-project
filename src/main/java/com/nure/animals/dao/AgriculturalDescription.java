package com.nure.animals.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.nure.animals.entities.Agricultural;

public class AgriculturalDescription extends Util implements AgriculturalDAO {

    


    @Override
    public void add(Agricultural agricultural) throws SQLException {
    	Connection conn = getConnection();
        PreparedStatement prep = null;
        String sql = "INSERT INTO Agricultural (Quantity, idAnimals) VALUES(?, ?)";
        try{
            prep = conn.prepareStatement(sql);
            prep.setInt(1, agricultural.getQuantity());
            prep.setInt(2, agricultural.getIdAnimals());

            prep.executeUpdate();
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
        prep.close();
        conn.close();
    }

    @Override
    public List<Agricultural> getAll() throws SQLException {
    	Connection conn = getConnection();
        List<Agricultural> agriculturalList = new ArrayList<>();

        String sql = "SELECT idAgricultural, Quantity, idAnimals FROM Agricultural";

        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Agricultural agricultural = new Agricultural();
                agricultural.setIdAgricultural(resultSet.getInt(1));
                agricultural.setQuantity(resultSet.getInt(2));
                agricultural.setIdAnimals(resultSet.getInt(3));

                agriculturalList.add(agricultural);
            }
            
            resultSet.close();
        }   catch (SQLException ex) {
            ex.printStackTrace();
        }
        statement.close();
        conn.close();
        return agriculturalList;
    }

    @Override
    public Agricultural getById(int id) throws SQLException {
    	Connection conn = getConnection();
        PreparedStatement prep = null;

        String sql = "SELECT idAgricultural, Quantity, idAnimals FROM Agricultural WHERE idAgricultural=?";

        Agricultural agricultural = new Agricultural();
        try {
            prep = conn.prepareStatement(sql);
            prep.setInt(1, id);

            ResultSet resultSet = prep.executeQuery();

            resultSet.next();
            agricultural.setIdAgricultural(resultSet.getInt(1));
            agricultural.setQuantity(resultSet.getInt(2));
            agricultural.setIdAnimals(resultSet.getInt(3));

            resultSet.close();
            prep.close();
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
        conn.close();
        return agricultural;
    }

    @Override
    public void update(Agricultural agricultural) throws SQLException {
    	Connection conn = getConnection();
        PreparedStatement prep = null;

        String sql = "UPDATE Agricultural SET Quantity=?, idAnimals=? WHERE idAgricultural=?";

        try {
            prep = conn.prepareStatement(sql);

            prep.setInt(3, agricultural.getIdAgricultural());
            prep.setInt(1, agricultural.getQuantity());
            prep.setInt(2, agricultural.getIdAnimals());
            prep.executeUpdate();
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
        prep.close();
        conn.close();
    }

    @Override
    public void delete(Agricultural agricultural) throws SQLException {
    	Connection conn = getConnection();
        PreparedStatement prep = null;
        String sql = "DELETE FROM Client WHERE idAgricultural=?";

        try {
            prep = conn.prepareStatement(sql);
            prep.setLong(1, agricultural.getIdAnimals());
            prep.executeUpdate();
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
        prep.close();
        conn.close();
    }
}
