package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Tools {

  static Properties properties;
  static Connection connection;

  /**
   * Get a fresh connection from H2.
   */
  public static Connection connection() {
    if (connection == null) {
      try {
        Class.forName(driver());

        connection = DriverManager.getConnection(
            url(),
            username(),
            password());
        connection.setAutoCommit(false);
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    return connection;
  }

//  public static DSLContext DSLContext() {
//    return DSL.using(connection());
//  }

  public static String password() {
    return properties().getProperty("db.password");
  }

  public static String username() {
    return properties().getProperty("db.username");
  }

  public static String url() {
    return properties().getProperty("db.url");
  }

  public static String driver() {
    return properties().getProperty("db.driver");
  }

  /**
   * Get the connection properties
   */
  public static Properties properties() {
    if (properties == null) {
      try {
        properties = new Properties();
        properties.load(Tools.class.getResourceAsStream("/config.properties"));
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    return properties;
  }

  /**
   * Some pretty printing
   */
  public static void title(String title) {
    String dashes = "=============================================================================================";

    System.out.println();
    System.out.println(title);
    System.out.println(dashes);
    System.out.println();
  }

  public static void print(Object o) {
    System.out.println(o);
  }
}
