package com.nure.animals.dao;

import java.sql.SQLException;
import java.util.List;

import com.nure.animals.entities.Wild;

public interface WildDAO {
	void add(Wild wild) throws SQLException;

    List<Wild> getAll() throws SQLException;
    Wild getById(int id) throws SQLException;

    void update(Wild wild) throws  SQLException;

    void delete(Wild wild) throws SQLException;

}
