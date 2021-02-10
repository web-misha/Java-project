package com.nure.animals.dao;

import java.sql.SQLException;
import java.util.List;

import com.nure.animals.entities.Animals;

public interface AnimalsDAO {
	void add(Animals animals) throws SQLException;

    List<Animals> getAll() throws SQLException;
    Animals getById(int id) throws SQLException;

    void update(Animals animals) throws  SQLException;

    void delete(Animals animals) throws SQLException;

}
