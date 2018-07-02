package part3;

import org.jooq.impl.DSL;
import org.junit.Test;
import tools.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static jooq.db.Tables.AUTHOR;
import static tools.Tools.connection;

public class Ex_3_1_CheckedExceptions {

  @Test
  public void run() throws SQLException {
    Connection connection = connection();

    Tools.title("JDBC throws lots of checked exceptions");

    // These two calls can throw a SQLException
    try (PreparedStatement stmt = connection.prepareStatement("SELECT FIRST_NAME FROM AUTHOR");
         ResultSet rs = stmt.executeQuery()) {

      // This can throw a SQLException
      while (rs.next()) {

        // This can throw a SQLException
        System.out.println(rs.getString(1));
      }
    }

    Tools.title("jOOQ doesn't throw any checked exceptions");
    DSL.using(connection)
        .select(AUTHOR.FIRST_NAME)
        .from(AUTHOR)
        .fetch()
        .forEach(record -> System.out.println(record.get(AUTHOR.FIRST_NAME)));
  }

}
