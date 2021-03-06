/*
 * This file is generated by jOOQ.
*/
package jooq.db;


import javax.annotation.Generated;

import jooq.db.tables.Author;
import jooq.db.tables.Book;
import jooq.db.tables.BookStore;
import jooq.db.tables.BookToBookStore;
import jooq.db.tables.Language;
import jooq.db.tables.records.AuthorRecord;
import jooq.db.tables.records.BookRecord;
import jooq.db.tables.records.BookStoreRecord;
import jooq.db.tables.records.BookToBookStoreRecord;
import jooq.db.tables.records.LanguageRecord;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<AuthorRecord, Integer> IDENTITY_AUTHOR = Identities0.IDENTITY_AUTHOR;
    public static final Identity<BookRecord, Integer> IDENTITY_BOOK = Identities0.IDENTITY_BOOK;
    public static final Identity<LanguageRecord, Integer> IDENTITY_LANGUAGE = Identities0.IDENTITY_LANGUAGE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AuthorRecord> AUTHOR_PKEY = UniqueKeys0.AUTHOR_PKEY;
    public static final UniqueKey<BookRecord> BOOK_PKEY = UniqueKeys0.BOOK_PKEY;
    public static final UniqueKey<BookStoreRecord> BOOK_STORE_NAME_KEY = UniqueKeys0.BOOK_STORE_NAME_KEY;
    public static final UniqueKey<BookToBookStoreRecord> BOOK_TO_BOOK_STORE_PKEY = UniqueKeys0.BOOK_TO_BOOK_STORE_PKEY;
    public static final UniqueKey<LanguageRecord> LANGUAGE_PKEY = UniqueKeys0.LANGUAGE_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<BookRecord, AuthorRecord> BOOK__FK_BOOK_AUTHOR = ForeignKeys0.BOOK__FK_BOOK_AUTHOR;
    public static final ForeignKey<BookRecord, LanguageRecord> BOOK__FK_BOOK_LANGUAGE = ForeignKeys0.BOOK__FK_BOOK_LANGUAGE;
    public static final ForeignKey<BookToBookStoreRecord, BookStoreRecord> BOOK_TO_BOOK_STORE__FK_B2BS_BOOK_STORE = ForeignKeys0.BOOK_TO_BOOK_STORE__FK_B2BS_BOOK_STORE;
    public static final ForeignKey<BookToBookStoreRecord, BookRecord> BOOK_TO_BOOK_STORE__FK_B2BS_BOOK = ForeignKeys0.BOOK_TO_BOOK_STORE__FK_B2BS_BOOK;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<AuthorRecord, Integer> IDENTITY_AUTHOR = createIdentity(Author.AUTHOR, Author.AUTHOR.ID);
        public static Identity<BookRecord, Integer> IDENTITY_BOOK = createIdentity(Book.BOOK, Book.BOOK.ID);
        public static Identity<LanguageRecord, Integer> IDENTITY_LANGUAGE = createIdentity(Language.LANGUAGE, Language.LANGUAGE.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<AuthorRecord> AUTHOR_PKEY = createUniqueKey(Author.AUTHOR, "author_pkey", Author.AUTHOR.ID);
        public static final UniqueKey<BookRecord> BOOK_PKEY = createUniqueKey(Book.BOOK, "book_pkey", Book.BOOK.ID);
        public static final UniqueKey<BookStoreRecord> BOOK_STORE_NAME_KEY = createUniqueKey(BookStore.BOOK_STORE, "book_store_name_key", BookStore.BOOK_STORE.NAME);
        public static final UniqueKey<BookToBookStoreRecord> BOOK_TO_BOOK_STORE_PKEY = createUniqueKey(BookToBookStore.BOOK_TO_BOOK_STORE, "book_to_book_store_pkey", BookToBookStore.BOOK_TO_BOOK_STORE.NAME, BookToBookStore.BOOK_TO_BOOK_STORE.BOOK_ID);
        public static final UniqueKey<LanguageRecord> LANGUAGE_PKEY = createUniqueKey(Language.LANGUAGE, "language_pkey", Language.LANGUAGE.ID);
    }

    private static class ForeignKeys0 extends AbstractKeys {
        public static final ForeignKey<BookRecord, AuthorRecord> BOOK__FK_BOOK_AUTHOR = createForeignKey(jooq.db.Keys.AUTHOR_PKEY, Book.BOOK, "book__fk_book_author", Book.BOOK.AUTHOR_ID);
        public static final ForeignKey<BookRecord, LanguageRecord> BOOK__FK_BOOK_LANGUAGE = createForeignKey(jooq.db.Keys.LANGUAGE_PKEY, Book.BOOK, "book__fk_book_language", Book.BOOK.LANGUAGE_ID);
        public static final ForeignKey<BookToBookStoreRecord, BookStoreRecord> BOOK_TO_BOOK_STORE__FK_B2BS_BOOK_STORE = createForeignKey(jooq.db.Keys.BOOK_STORE_NAME_KEY, BookToBookStore.BOOK_TO_BOOK_STORE, "book_to_book_store__fk_b2bs_book_store", BookToBookStore.BOOK_TO_BOOK_STORE.NAME);
        public static final ForeignKey<BookToBookStoreRecord, BookRecord> BOOK_TO_BOOK_STORE__FK_B2BS_BOOK = createForeignKey(jooq.db.Keys.BOOK_PKEY, BookToBookStore.BOOK_TO_BOOK_STORE, "book_to_book_store__fk_b2bs_book", BookToBookStore.BOOK_TO_BOOK_STORE.BOOK_ID);
    }
}
