package main.com.batsworks.interfaces.config.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PreCompile {

	private static final String DB_CONFIG = System.getenv("DB_PROPERTIES");
	private static Connection connection = ConexaoDb.conecta();
	private static final Logger log = Logger.getLogger(PreCompile.class.getName());

	PreCompile() {
		throw new IllegalStateException("Utility class");
	}

	private static List<File> findScripts() throws Exception {
		List<File> files = new ArrayList<>();

		String sqlType = DB_CONFIG.substring(0, DB_CONFIG.indexOf("."));

		File directory = new File("src/resources");
		if (directory.isDirectory()) {
			for (var file : directory.listFiles()) {
				if (file.getName().startsWith("BW") && file.getName().contains(sqlType)) {
					files.add(file);
				}
			}
		}
		return files;
	}

	private static String findQuerys() throws Exception {
		String query = "";

		for (var it : findScripts().stream().sorted(Comparator.comparing(File::getName)).collect(Collectors.toList())) {
			try (BufferedReader reader = new BufferedReader(new FileReader(it))) {
				String line;
				while ((line = reader.readLine()) != null) {
					query += line;
				}
			} catch (FileNotFoundException e) {
				throw e;
			} catch (IOException e) {
				throw e;
			}
		}
		return query;
	}

	public static void executeQuery() throws Exception {
		String[] querys = findQuerys().split(";");
		for (var query : querys) {
			query = query.trim().replace("    ", " ").replace("  ", " ");
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				log.info(query);
				pst.execute();
			}
		}
	}

}
