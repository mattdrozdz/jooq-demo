package part1;

import jooq.db.tables.records.AuthorRecord;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.junit.Test;
import tools.Tools;

import java.sql.Date;

import static jooq.db.Tables.AUTHOR;
import static org.jooq.impl.DSL.select;
import static tools.Tools.connection;


public class Ex_1_1_PrintTheQuery {

  @Test
  public void run() {
    DSLContext ctx = DSL.using(connection());

    // This creates a simple query without executing it
    // By default, a Query's toString() method will print the SQL string to the console
    Tools.title("Create a simple query without executing it");
    System.out.println(
        select(AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
            .from(AUTHOR)
            .orderBy(AUTHOR.ID)
    );

//    System.out.println(
//        ctx.selectFrom(AUTHOR)
//            .fetch()
//
//    );
    Result<Record3<String, String, Date>> authors = ctx.select(AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME, AUTHOR.DATE_OF_BIRTH)
        .from(AUTHOR)
        .fetch();
    System.out.println(authors);

  }
}
