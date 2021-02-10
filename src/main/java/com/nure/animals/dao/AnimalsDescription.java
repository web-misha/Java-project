package com.nure.animals.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.nure.animals.entities.Animals;

public class AnimalsDescription extends Util implements AnimalsDAO {

    

    @Override
    public void add(Animals animals) throws SQLException {
    	Connection conn = getConnection();
        PreparedStatement prep = null;
        String sql = "INSERT INTO ANIMALS (Price, Name, idClient) VALUES(?, ?, ?)";
        try{
            prep = conn.prepareStatement(sql);
            prep.setInt(1, animals.getPrice());
            prep.setString(2, animals.getName());
            prep.setInt(3, animals.getIdClient());

            prep.executeUpdate();
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
        prep.close();
        conn.close();
    }

    @Override
    public List<Animals> getAll() throws SQLException {
    	Connection conn = getConnection();
        List<Animals> animalsList = new ArrayList<>();

        String sql = "SELECT idAnimals, Price, Name FROM Animals";

        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Animals animals = new Animals();
                animals.setPrice(resultSet.getInt(2));
                animals.setName(resultSet.getString(3));
                animals.setIdAnimals(resultSet.getInt(1));

                animalsList.add(animals);
            }
            
            resultSet.close();
            statement.close();
        }   catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.close();
        return animalsList;
    }

    @Override
    public Animals getById(int id) throws SQLException {
    	Connection conn = getConnection();
        PreparedStatement prep = null;

        String sql = "SELECT idAnimals, Price, Name FROM Animals WHERE idAnimals=?";

        Animals animals = new Animals();
        try {
            prep = conn.prepareStatement(sql);
            prep.setInt(1, id);

            ResultSet resultSet = prep.executeQuery();

            resultSet.next();
            animals.setIdAnimals(resultSet.getInt(1));
            animals.setPrice(resultSet.getInt(2));
            animals.setName(resultSet.getString(3));

            resultSet.close();
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
        prep.close();
        conn.close();
        return animals;
    }

    @Override
    public void update(Animals animals) throws SQLException {
    	Connection conn = getConnection();
        PreparedStatement prep = null;

        String sql = "UPDATE Animals SET Price=?, Name=? WHERE idAnimals=?";

        try {
            prep = conn.prepareStatement(sql);

            prep.setInt(3, animals.getIdAnimals());
            prep.setInt(1, animals.getPrice());
            prep.setString(2, animals.getName());
            
            prep.executeUpdate();
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
        prep.close();
        conn.close();
    }

    @Override
    public void delete(Animals animals) throws SQLException {
    	Connection conn = getConnection();
        PreparedStatement prep = null;
        String sql = "DELETE FROM Animals WHERE idAnimals=?";

        try {
            prep = conn.prepareStatement(sql);
            prep.setLong(1, animals.getIdAnimals());
            prep.executeUpdate();
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
        prep.close();
        conn.close();
    }
}
