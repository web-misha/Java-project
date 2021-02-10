package com.nure.animals.dao;

import java.util.List;

import com.nure.animals.entities.Client;

import java.sql.SQLException;

public interface ClientDAO {
	void add(Client client) throws SQLException;

    List<Client> getAll() throws SQLException;
    Client getById(int id) throws SQLException;

    void update(Client client) throws  SQLException;

    void delete(Client client) throws SQLException;

}
