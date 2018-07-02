package part3;

import org.jooq.conf.Settings;
import org.jooq.conf.StatementType;
import org.jooq.impl.DSL;
import org.junit.Test;
import tools.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static tools.Tools.connection;

public class Ex_3_3_PreparedStatements {

  @Test
  public void run() throws SQLException {
    Connection connection = connection();

    Tools.title("Distinguishing between static and prepared statements with JDBC");

    // 1% of the time
    try (Statement stmt = connection.createStatement()) {
      stmt.execute("SELECT * FROM AUTHOR");
    }

    // 99% of the time
    try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM AUTHOR")) {
      stmt.execute();
    }

    Tools.title("Distinguishing between static and prepared statements with jOOQ");
    // 1% of the time
    System.out.println(
        DSL.using(connection, new Settings().withStatementType(StatementType.STATIC_STATEMENT))
            .fetch("SELECT * FROM AUTHOR")
    );

    // 99% of the time
    System.out.println(
        DSL.using(connection)
            .fetch("SELECT * FROM AUTHOR")
    );
  }

}
