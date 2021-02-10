package com.nure.animals.dao;

import java.sql.SQLException;
import java.util.List;

import com.nure.animals.entities.Agricultural;

public interface AgriculturalDAO {
	void add(Agricultural agricultural) throws SQLException;

    List<Agricultural> getAll() throws SQLException;
    Agricultural getById(int id) throws SQLException;

    void update(Agricultural agricultural) throws  SQLException;

    void delete(Agricultural agricultural) throws SQLException;

}
