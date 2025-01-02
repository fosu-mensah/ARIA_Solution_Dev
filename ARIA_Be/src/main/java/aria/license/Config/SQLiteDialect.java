package aria.license.Config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

/**
 * Custom SQLite Dialect for Hibernate
 */
public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();

        // Register functions
        registerFunction("concat", new StandardSQLFunction("concat", StandardBasicTypes.STRING));
        registerFunction("mod", new StandardSQLFunction("mod", StandardBasicTypes.INTEGER));
        registerFunction("substr", new StandardSQLFunction("substr", StandardBasicTypes.STRING));
        registerFunction("length", new StandardSQLFunction("length", StandardBasicTypes.INTEGER));
    }

    @Override
    public boolean dropConstraints() {
        return false;
    }

    @Override
    public boolean supportsSequences() {
        return false;
    }

    @Override
    public String getAddColumnString() {
        return "add column";
    }

    @Override
    public String getForUpdateString() {
        return "";
    }

    @Override
    public boolean supportsUnionAll() {
        return true;
    }

    @Override
    public boolean hasAlterTable() {
        return false;
    }

    @Override
    public String getDropForeignKeyString() {
        throw new UnsupportedOperationException("SQLite does not support dropping foreign keys.");
    }

    @Override
    public String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable, String[] primaryKey, boolean referencesPrimaryKey) {
        throw new UnsupportedOperationException("SQLite does not support adding foreign key constraints.");
    }

    @Override
    public String getAddPrimaryKeyConstraintString(String constraintName) {
        throw new UnsupportedOperationException("SQLite does not support adding primary key constraints.");
    }
}
