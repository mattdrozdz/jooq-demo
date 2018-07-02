package part4;

import org.jooq.ExecuteListener;
import org.jooq.SQLDialect;
import org.jooq.impl.CallbackExecuteListener;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultConnectionProvider;
import org.jooq.impl.DefaultExecuteListenerProvider;

import org.junit.Test;
import tools.Tools;

import static jooq.db.Tables.AUTHOR;
import static tools.Tools.connection;

public class Ex_4_4_ExecuteListener {

  @Test
  public void run() {
    Tools.title("Displaying execution time using a custom ExecuteListener");

    ExecuteListener listener = new CallbackExecuteListener()
        .onStart(ctx -> {

          // Register the start time to the current context
          ctx.data("time", System.nanoTime());
        })
        .onEnd(ctx -> {
          // Extract the start time from the current context
          Long time = (Long) ctx.data("time");

          System.out.println("Execution time : " + ((System.nanoTime() - time) / 1000 / 1000.0) + "ms. Query : " + ctx.sql());
        });

    DSL.using(new DefaultConfiguration()
        .set(SQLDialect.H2)
        .set(new DefaultConnectionProvider(connection()))
        .set(new DefaultExecuteListenerProvider(listener))
    )
        .select(AUTHOR.ID)
        .from(AUTHOR)
        .fetch();
  }

}
