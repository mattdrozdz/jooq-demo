package part2;

import jooq.db.tables.records.BookRecord;
import org.jooq.DSLContext;
import org.jooq.conf.Settings;
import org.jooq.exception.DataChangedException;
import org.jooq.impl.DSL;
import org.junit.Test;
import tools.Tools;

import java.sql.Connection;
import java.sql.SQLException;

import static jooq.db.Tables.BOOK;
import static tools.Tools.connection;

public class Ex_2_2_OptimisticLocking {

  @Test
  public void run() throws SQLException {
    Connection connection = connection();
    DSLContext dsl = DSL.using(connection, new Settings().withExecuteWithOptimisticLocking(true));

    try {
      Tools.title("Applying optimistic locking");

      BookRecord book1 = dsl.selectFrom(BOOK).where(BOOK.ID.eq(1)).fetchOne();
      BookRecord book2 = dsl.selectFrom(BOOK).where(BOOK.ID.eq(1)).fetchOne();

      book1.setTitle("New Title");
      book1.store();

      book2.setTitle("Another Title");
      book2.store();
    }

    catch (DataChangedException expected) {
      expected.printStackTrace();
    }

    // Don't store the changes
    finally {
      connection.rollback();
    }
  }

}
