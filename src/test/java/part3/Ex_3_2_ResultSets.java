package part3;

import org.jooq.Record;
import org.jooq.impl.DSL;
import org.junit.Test;
import tools.Tools;

import java.sql.Connection;
import java.util.Arrays;

import static jooq.db.Tables.AUTHOR;
import static tools.Tools.connection;

public class Ex_3_2_ResultSets {

  @Test
  public void run() {
    Connection connection = connection();

    Tools.title("Using jOOQ Results in foreach loops");
    for (Record record : DSL.using(connection)
        .select()
        .from(AUTHOR)
        .fetch()) {
      System.out.println(record);
    }

    Tools.title("Using jOOQ Results with Java 8 streams");
    DSL.using(connection)
        .select()
        .from(AUTHOR)
        .fetch()
        .stream()
        .flatMap(record -> Arrays.stream(record.intoArray()))
        .forEach(System.out::println);
  }

}
