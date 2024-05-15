package main.com.batsworks.interfaces.config.database;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T, ID> {


    T findById(ID id) throws SQLException;

    List<T> findAll() throws SQLException;

    void add(T t) throws SQLException;

    void update(T t, ID id) throws SQLException;

    Boolean delete(ID id) throws SQLException;

    void flush() throws SQLException;
}
