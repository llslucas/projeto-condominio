package br.llslucas.condominio.persistence.instance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLInstance {
  private static MySQLInstance instance;
  private Connection connection;

  private final String url = "jdbc:mysql://localhost:3306/main_condominio";
  private final String username = "root";
  private final String password = "root";

  private MySQLInstance() throws SQLException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      this.connection = DriverManager.getConnection(url, username, password);
    } catch (ClassNotFoundException ex) {
      throw new SQLException(ex);
    }
  }

  public static MySQLInstance getInstance() throws SQLException {
    if (instance == null || instance.getConnection().isClosed()) {
      instance = new MySQLInstance();
    }
    return instance;
  }

  public Connection getConnection() {
    return connection;
  }

  public static void main(String[] args) {
    try {
      MySQLInstance instance = MySQLInstance.getInstance();
      instance.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
