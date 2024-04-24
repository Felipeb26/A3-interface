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

    private static final Connection connection = ConexaoDb.conecta();
    private final String dbEntity;

    transient Function<ResultSet, T> rowMapper;

    public CustomRepository(Class<T> t, Function<ResultSet, T> function) {
        dbEntity = FormatString.findEntityByClassName(t);
        rowMapper = function;
    }

    public T custom(String query) throws SQLException {
        T t = null;
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                t = rowMapper.apply(rs);
            }
            return t;
        }
    }

    @Override
    public T findById(Long id) throws SQLException {
        T t = null;
        try (PreparedStatement pst = connection.prepareStatement(String.format("select * from %s where id=%s", dbEntity, id))) {
            ResultSet rs = pst.executeQuery();
            while ((rs.next())) {
                t = rowMapper.apply(rs);
            }
            return t;
        }
    }

    @Override
    public List<T> findAll() throws SQLException {
        List<T> ts = new ArrayList<>();
        try (PreparedStatement pst = connection.prepareStatement(String.format("select * from %s", dbEntity))) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ts.add(rowMapper.apply(rs));
            }
            ConexaoDb.desconecta(pst, rs);
            return ts;
        }
    }

    @Override
    public void add(T t) throws SQLException {
        var insert = FormatString.formatStringToInsert(t.toString());
        String query = String.format("insert into %s (%s) values (%s)", dbEntity, insert.get("chave"), insert.get("valor"));
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();
            ConexaoDb.desconecta(pst, rs);
        }
    }

    @Override
    public void update(T t, Long aLong) throws SQLException {
        var update = FormatString.formatStringToUpdate(t.toString());
        try (PreparedStatement pst = connection.prepareStatement(String.format("update %s set %s where id=%d", dbEntity, update, aLong))) {
            ResultSet rs = pst.executeQuery();
            ConexaoDb.desconecta(pst, rs);
        }
    }

    @Override
    public Boolean delete(Long id) throws SQLException {
        try (PreparedStatement pst = connection.prepareStatement(String.format("delete from %s where id=%s", dbEntity, id))) {
            ResultSet rs = pst.executeQuery();
            return rs.rowDeleted();
        }
    }

    @Override
    public void flush() throws SQLException {
        connection.commit();
        ConexaoDb.desconecta();
    }
}
