package part4;

import org.apache.commons.dbcp.BasicDataSource;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.Test;
import tools.Tools;

import java.sql.Connection;

import static jooq.db.Tables.AUTHOR;
import static tools.Tools.connection;

public class Ex_4_1_ConnectionProvider {

  @Test
  public void run() {
    Connection connection = connection();

    Tools.title("Using jOOQ with a standalone connection");
    System.out.println(
        DSL.using(connection)
            .select()
            .from(AUTHOR)
            .fetch()
    );

    Tools.title("Using jOOQ with a DBCP connection pool");
    BasicDataSource ds = new BasicDataSource();
    ds.setDriverClassName(Tools.driver());
    ds.setUrl(Tools.url());
    ds.setUsername(Tools.username());
    ds.setPassword(Tools.password());
    System.out.println(
        DSL.using(ds, SQLDialect.POSTGRES)
            .select()
            .from(AUTHOR)
            .fetch()
    );
  }

}
