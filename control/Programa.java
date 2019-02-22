package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Programa {

	/**
	 * exemplo de Javadoc
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		System.out.println("Digite o valor mínimo: ");
		int min = leia.nextInt();
		System.out.println("Digite o valor máximo: ");
		int max = leia.nextInt();
		testeClassesEquivalentes(min, max);
		leia.close();
	}

	public static int[] testeClassesEquivalentes(int min, int max) {
		Random gerador = new Random();
		int valorInferiorInvalido = gerador.nextInt(min);
		int valorValido = gerador.nextInt((max + 1) - min) + min;
		int valorSuperiorInvalido = gerador.nextInt(2147483647 - (max + 1)) + (max + 1);

		int vet[] = { valorInferiorInvalido, valorValido, valorSuperiorInvalido };
		for (int i = 0; i < vet.length; i++) {
			System.out.println("Dado de Teste " + (i + 1) + ": " + vet[i]);
		}
		return vet;
	}

	public static void processRequest()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String user = "user";
		Connection conn = null;
		String url = "jdbc:mysql://192.168.2.128:3306/";
		String dbName = "anvayaV2";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "123";
		String className = System.getProperty("messageClassName");
		Class clazz = Class.forName(className);

		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(url + dbName, userName, password);

		Statement st = conn.createStatement();
		String query = "SELECT * FROM  User where userId=" + user + "";
		System.out.println("Query : " + query);
		System.out.printf(query);
		ResultSet res = st.executeQuery(query);

		System.out.println("Results");
		while (res.next()) {
			String s = res.getString("username");
			System.out.println("\t\t" + s);
		}
		conn.close();

	}
}