package com.nure.animals.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.nure.animals.entities.Wild;

public class WildDescription extends Util implements WildDAO {

    

    @Override
    public void add(Wild wild) throws SQLException {
    	Connection conn = getConnection();
        PreparedStatement prep = null;
        String sql = "INSERT INTO Wild (MaxSpeed, idAnimals) VALUES(?, ?)";
        try{
            prep = conn.prepareStatement(sql);
            prep.setInt(1, wild.getMaxSpeed());
            prep.setInt(2, wild.getIdAnimals());

            prep.executeUpdate();
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
        prep.close();
        conn.close();
    }

    @Override
    public List<Wild> getAll() throws SQLException {
    	Connection conn = getConnection();
        List<Wild> wildlList = new ArrayList<>();

        String sql = "SELECT idWild, MaxSpeed, idAnimals FROM Wild";

        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Wild wild = new Wild();
                wild.setIdWild(resultSet.getInt(1));
                wild.setMaxSpeed(resultSet.getInt(2));
                wild.setIdAnimals(resultSet.getInt(3));

                wildlList.add(wild);
            }
            
            resultSet.close();
        }   catch (SQLException ex) {
            ex.printStackTrace();
        }
        statement.close();
        conn.close();
        return wildlList;
    }

    @Override
    public Wild getById(int id) throws SQLException {
    	Connection conn = getConnection();
        PreparedStatement prep = null;

        String sql = "SELECT idWild, MaxSpeed, idAnimals FROM Wild WHERE idWild=?";

        Wild wild = new Wild();
        try {
            prep = conn.prepareStatement(sql);
            prep.setInt(1, id);

            ResultSet resultSet = prep.executeQuery();

            resultSet.next();
            wild.setIdWild(resultSet.getInt(1));
            wild.setMaxSpeed(resultSet.getInt(2));
            wild.setIdAnimals(resultSet.getInt(3));

            resultSet.close();
            prep.close();
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
        conn.close();
        return wild;
    }

    @Override
    public void update(Wild wild) throws SQLException {
    	Connection conn = getConnection();
        PreparedStatement prep = null;

        String sql = "UPDATE Wild SET MaxSpeed=?, idAnimals=? WHERE idWild=?";

        try {
            prep = conn.prepareStatement(sql);

            prep.setInt(3, wild.getIdWild());
            prep.setInt(1, wild.getMaxSpeed());
            prep.setInt(2, wild.getIdAnimals());
            
            prep.executeUpdate();
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
        prep.close();
        conn.close();
    }

    @Override
    public void delete(Wild wild) throws SQLException {
    	Connection conn = getConnection();
        PreparedStatement prep = null;
        String sql = "DELETE FROM Wild WHERE idWild=?";

        try {
            prep = conn.prepareStatement(sql);
            prep.setLong(1, wild.getIdWild());
            prep.executeUpdate();
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
        prep.close();
        conn.close();
    }
}
