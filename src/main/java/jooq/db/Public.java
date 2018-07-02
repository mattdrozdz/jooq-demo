/*
 * This file is generated by jOOQ.
*/
package jooq.db;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jooq.db.tables.Author;
import jooq.db.tables.Book;
import jooq.db.tables.BookStore;
import jooq.db.tables.BookToBookStore;
import jooq.db.tables.Language;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 335001223;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.author</code>.
     */
    public final Author AUTHOR = jooq.db.tables.Author.AUTHOR;

    /**
     * The table <code>public.book</code>.
     */
    public final Book BOOK = jooq.db.tables.Book.BOOK;

    /**
     * The table <code>public.book_store</code>.
     */
    public final BookStore BOOK_STORE = jooq.db.tables.BookStore.BOOK_STORE;

    /**
     * The table <code>public.book_to_book_store</code>.
     */
    public final BookToBookStore BOOK_TO_BOOK_STORE = jooq.db.tables.BookToBookStore.BOOK_TO_BOOK_STORE;

    /**
     * The table <code>public.language</code>.
     */
    public final Language LANGUAGE = jooq.db.tables.Language.LANGUAGE;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
            Sequences.AUTHOR_ID_SEQ,
            Sequences.BOOK_ID_SEQ,
            Sequences.LANGUAGE_ID_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Author.AUTHOR,
            Book.BOOK,
            BookStore.BOOK_STORE,
            BookToBookStore.BOOK_TO_BOOK_STORE,
            Language.LANGUAGE);
    }
}