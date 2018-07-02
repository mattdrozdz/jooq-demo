package part4;

import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.Test;
import tools.Tools;

import java.util.Arrays;

import static jooq.db.Tables.AUTHOR;

public class Ex_4_2_SQLDialect {

  @Test
  public void run() {
    Tools.title("Generate SELECT 1 FROM DUAL for all SQL dialect families");
    Arrays.stream(SQLDialect.families())
        .map(dialect -> String.format("%15s : ", dialect) + DSL.using(dialect).render(
            DSL.select(DSL.ifnull(AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME))
                .from(AUTHOR)))
        .forEach(System.out::println);
  }

}
