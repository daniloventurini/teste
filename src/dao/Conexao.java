/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author jaime
 */
public class Conexao {

    private static Connection con = null;

	public static Connection getConnection() {
		if (con == null) {
			try {
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://127.0.0.1:3306/jaimediasapp";
				String usuario = "root";
				String senha = "admin";
				Class.forName(driver);
				con = DriverManager.getConnection(url, usuario, senha);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}

	public static void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
