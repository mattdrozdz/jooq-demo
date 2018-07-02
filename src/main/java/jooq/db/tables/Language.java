/*
 * This file is generated by jOOQ.
*/
package jooq.db.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jooq.db.Indexes;
import jooq.db.Keys;
import jooq.db.Public;
import jooq.db.tables.records.LanguageRecord;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Language extends TableImpl<LanguageRecord> {

    private static final long serialVersionUID = 1440715521;

    /**
     * The reference instance of <code>public.language</code>
     */
    public static final Language LANGUAGE = new Language();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LanguageRecord> getRecordType() {
        return LanguageRecord.class;
    }

    /**
     * The column <code>public.language.id</code>.
     */
    public final TableField<LanguageRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('language_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.language.cd</code>.
     */
    public final TableField<LanguageRecord, String> CD = createField("cd", org.jooq.impl.SQLDataType.CHAR(2).nullable(false), this, "");

    /**
     * The column <code>public.language.description</code>.
     */
    public final TableField<LanguageRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * Create a <code>public.language</code> table reference
     */
    public Language() {
        this(DSL.name("language"), null);
    }

    /**
     * Create an aliased <code>public.language</code> table reference
     */
    public Language(String alias) {
        this(DSL.name(alias), LANGUAGE);
    }

    /**
     * Create an aliased <code>public.language</code> table reference
     */
    public Language(Name alias) {
        this(alias, LANGUAGE);
    }

    private Language(Name alias, Table<LanguageRecord> aliased) {
        this(alias, aliased, null);
    }

    private Language(Name alias, Table<LanguageRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.LANGUAGE_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<LanguageRecord, Integer> getIdentity() {
        return Keys.IDENTITY_LANGUAGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LanguageRecord> getPrimaryKey() {
        return Keys.LANGUAGE_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LanguageRecord>> getKeys() {
        return Arrays.<UniqueKey<LanguageRecord>>asList(Keys.LANGUAGE_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Language as(String alias) {
        return new Language(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Language as(Name alias) {
        return new Language(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Language rename(String name) {
        return new Language(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Language rename(Name name) {
        return new Language(name, null);
    }
}
