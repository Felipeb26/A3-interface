package com.batsworks.interfaces.config.database;

import com.batsworks.interfaces.utils.FormatString;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public final class CustomRepository<T> implements Repository<T, Long>, Serializable {

    private static Connection connection = ConexaoDb.conecta();
    private static PreparedStatement pst;
    private static ResultSet rs;
    private static String dbEntity;

    Function<ResultSet, T> rowMapper;

    public CustomRepository(Class<T> t, Function<ResultSet, T> function) {
        dbEntity = FormatString.forDb(t);
        rowMapper = function;
    }

    public CustomRepository() {
    }


    @Override
    public T findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<T> findAll() throws SQLException {
        List<T> ts = new ArrayList<>();
        pst = connection.prepareStatement(String.format("select * from %s", dbEntity));
        rs = pst.executeQuery();
        while (rs.next()) {
            ts.add(rowMapper.apply(rs));
        }
        return ts;
    }

    @Override
    public void add(T t) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {

    }

    @Override
    public void flush() throws SQLException {

    }
}
