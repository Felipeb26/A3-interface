package main.com.batsworks.interfaces.config.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.logging.Logger;
import main.com.batsworks.interfaces.utils.FormatString;

public final class CustomRepository<T> implements Repository<T, Long>, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CustomRepository.class.getName());
	private Connection connection = ConexaoDb.conecta();
	private final String dbEntity;

	transient Function<ResultSet, T> rowMapper;

	public CustomRepository(Class<T> t, Function<ResultSet, T> function) {
		dbEntity = FormatString.findEntityByClassName(t);
		rowMapper = function;
	}

	public T custom(String query) throws SQLException {
		T t = null;
		assertDBNotClosed(query);
		try (PreparedStatement pst = connection.prepareStatement(query)) {
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				t = rowMapper.apply(rs);
			}
			ConexaoDb.desconecta(pst, rs);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public T findById(Long id) throws SQLException {
		T t = null;
		String query = String.format("select * from %s where id=%s", dbEntity, id);
		assertDBNotClosed(query);
		try (PreparedStatement pst = connection.prepareStatement(query)) {
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
		String query = String.format("select * from %s", dbEntity);
		assertDBNotClosed(query);
		try (PreparedStatement pst = connection.prepareStatement(query)) {
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
		String query = String.format("insert into %s (%s) values (%s)", dbEntity, insert.get("chave"),
				insert.get("valor"));
		assertDBNotClosed(query);
		try (PreparedStatement pst = connection.prepareStatement(query)) {
			ResultSet rs = pst.executeQuery();
			ConexaoDb.desconecta(pst, rs);
		}
	}

	@Override
	public void update(T t, Long aLong) throws SQLException {
		var update = FormatString.formatStringToUpdate(t.toString());
		String query = String.format("update %s set %s where id=%d", dbEntity, update, aLong);
		assertDBNotClosed(query);
		try (PreparedStatement pst = connection.prepareStatement(query)) {
			ResultSet rs = pst.executeQuery();
			ConexaoDb.desconecta(pst, rs);
		}
	}

	@Override
	public Boolean delete(Long id) throws SQLException {
		String query = String.format("delete from %s where id=%s", dbEntity, id);
		assertDBNotClosed(query);
		try (PreparedStatement pst = connection.prepareStatement(query)) {
			ResultSet rs = pst.executeQuery();
			return rs.rowDeleted();
		}
	}

	@Override
	public void flush() throws SQLException {
		connection.commit();
		ConexaoDb.desconecta();
	}

	private void assertDBNotClosed(String toLog) throws SQLException {
		var executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> {
			try {
				connection = connection.isClosed() ? ConexaoDb.conecta(): connection;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		log.info(toLog);
	}
}
