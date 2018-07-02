package part1;

import org.jooq.DSLContext;
import org.jooq.Select;
import org.jooq.impl.DSL;
import org.junit.Test;
import tools.Tools;

import static jooq.db.Tables.AUTHOR;
import static jooq.db.Tables.BOOK;
import static tools.Tools.connection;
import static org.jooq.impl.DSL.*;


public class Ex_1_2_ExecuteTheQuery {

  @Test
  public void run() {

    DSLContext dsl = DSL.using(connection());

    // All we need to execute a query is provide it with a connection and then
    // call fetch() on it.
    Tools.title("Selecting FIRST_NAME and LAST_NAME from the AUTHOR table");
//    Tools.print(
//        DSL.using(connection())
//            .select(AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
//            .from(AUTHOR)
//            .orderBy(AUTHOR.ID)
//            .fetch()
//    );
//    System.out.println(
//        dsl.insertInto(AUTHOR, AUTHOR.FIRST_NAME)
//        .select(dsl.select(AUTHOR.FIRST_NAME).from(AUTHOR))
//    );

    dsl.select(AUTHOR.LAST_NAME,
        select(AUTHOR.ID).from(AUTHOR).where(AUTHOR.ID.eq(1)).asField()
    ).from(AUTHOR).fetch();

    dsl.select(AUTHOR.LAST_NAME).select(
        select(AUTHOR.FIRST_NAME).from(AUTHOR).where(AUTHOR.ID.eq(1)).asField()
    ).from(AUTHOR).fetch();

    dsl.update(AUTHOR)
        .set(AUTHOR.FIRST_NAME, "bla")
        .where(AUTHOR.ID.eq(2))
        .execute();

  }

}
