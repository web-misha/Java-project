package com.nure.animals.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.nure.animals.entities.Client;

public class ClientDescription extends Util implements ClientDAO {

    

    @Override
    public void add(Client client) throws SQLException {
    	Connection conn = getConnection();
        PreparedStatement prep = null;
        String sql = "INSERT INTO Client (Name) VALUES(?)";
        try{
            prep = conn.prepareStatement(sql);
            prep.setString(1, client.getName());

            prep.executeUpdate();
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
        prep.close();
        conn.close();
    }

    @Override
    public List<Client> getAll() throws SQLException {
    	Connection conn = getConnection();
        List<Client> clientList = new ArrayList<>();

        String sql = "SELECT idClient, Name FROM Client";

        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Client client = new Client();
                client.setIdClient(resultSet.getInt(1));
                client.setName(resultSet.getString(2));

                clientList.add(client);
            }
            resultSet.close();
        }   catch (SQLException ex) {
            ex.printStackTrace();
        }
        statement.close();
        conn.close();
        return clientList;
    }

    @Override
    public Client getById(int id) throws SQLException {
    	Connection conn = getConnection();
        PreparedStatement prep = null;

        String sql = "SELECT idClient, Name FROM Client WHERE idClient=?";

        Client client = new Client();
        try {
            prep = conn.prepareStatement(sql);
            prep.setInt(1, id);

            ResultSet resultSet = prep.executeQuery();

            resultSet.next();
            client.setIdClient(resultSet.getInt(1));
            client.setName(resultSet.getString(2));

            resultSet.close();
            prep.close();
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
        conn.close();
        return client;
    }

    @Override
    public void update(Client client) throws SQLException {
    	Connection conn = getConnection();
        PreparedStatement prep = null;

        String sql = "UPDATE Client SET Name=? WHERE idClient=?";

        try {
            prep = conn.prepareStatement(sql);

            prep.setString(1, client.getName());
            prep.setInt(2, client.getIdClient());
            
            prep.executeUpdate();
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
        prep.close();
        conn.close();
    }

    @Override
    public void delete(Client client) throws SQLException {
    	Connection conn = getConnection();
        PreparedStatement prep = null;

        String sql = "DELETE FROM Client WHERE idClient=?";

        try {
            prep = conn.prepareStatement(sql);
            prep.setLong(1, client.getIdClient());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        prep.close();
        conn.close();

    }
}
