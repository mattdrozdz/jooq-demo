package part1;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.junit.Test;
import tools.Tools;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import static jooq.db.Tables.AUTHOR;
import static tools.Tools.connection;

public class Ex_1_3_DMLStatements {

  @Test
  public void run() throws SQLException {
    Connection connection = connection();

    DSLContext dsl = DSL.using(connection);

    try {

      // Inserting is just as easy as selecting
      Tools.title("Inserting a new AUTHOR");
      Tools.print(
          dsl.insertInto(AUTHOR, AUTHOR.ID, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
              .values(3, "Alfred", "Hitchcock")
              .execute()
      );

      // But the Java compiler will actively check your statements. The
      // following statements will not compile:
            /*
            Tools.title("Not enough arguments to the values() method!");
            Tools.print(
                DSL.using(connection())
                   .insertInto(AUTHOR, AUTHOR.ID, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
                   .values(4, "Alfred")
                   .execute()
            );
            */
            /*
            Tools.title("Wrong order of types of arguments to the values() method!");
            Tools.print(
                DSL.using(connection())
                   .insertInto(AUTHOR, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME, AUTHOR.ID)
                   .values(4, "Alfred", "Hitchcock")
                   .execute()
            );
            */
      Tools.title("Check if our latest record was really created");
      Tools.print(
          dsl.select()
              .from(AUTHOR)
              .where(AUTHOR.ID.eq(3))
              .fetch()
      );

      Tools.title("Update the DATE_OF_BIRTH column");
      Tools.print(
          dsl.update(AUTHOR)
              .set(AUTHOR.DATE_OF_BIRTH, Date.valueOf("1899-08-13"))
              .where(AUTHOR.ID.eq(3))
              .execute()
      );

      Tools.title("Check if our latest record was really updated");
      Tools.print(
          dsl.select()
              .from(AUTHOR)
              .where(AUTHOR.ID.eq(3))
              .fetch()
      );

      Tools.title("Delete the new record again");
      Tools.print(
          dsl.delete(AUTHOR)
              .where(AUTHOR.ID.eq(3))
              .execute()
      );

      Tools.title("Check if the record was really deleted");
      Tools.print(
          dsl.select()
              .from(AUTHOR)
              .fetch()
      );
    }

    // Don't keep the new data
    finally {
      connection.rollback();
    }
  }

}
