package lowcode.enums;

import java.util.Arrays;
import java.util.Locale;

/**
 * @description: 数据类型没据
 * @author: liyq
 * @createtime: 2023-04-07 14:18
 */
public enum JDBCTypeEnum {

    MYSQL_INT("MYSQL", "INT", "INTEGER","Integer","java.lang.Integer"),
    MYSQL_INTEGER("MYSQL", "INTEGER", "INTEGER","Integer","java.lang.Integer"),
    MYSQL_DATETIME("MYSQL", "DATETIME", "TIMESTAMP","Date","java.util.Date"),
    MYSQL_VARCHAR("MYSQL", "VARCHAR", "VARCHAR","String","java.lang.String"),
    MYSQL_TINYINT("MYSQL", "TINYINT", "TINYINT","boolean","java.lang.Boolean"),
    ;

    JDBCTypeEnum(String databaseType, String dbType, String jdbcType, String javaTypeShort, String javaType) {
        this.databaseType = databaseType;
        this.dbType = dbType;
        this.jdbcType = jdbcType;
        this.javaTypeShort = javaTypeShort;
        this.javaType = javaType;
    }

    private String  databaseType;
    private String  dbType;
    private String  jdbcType;
    private String  javaTypeShort;
    private String  javaType;

    public static JDBCTypeEnum matchByDbType(String dbType) {
        return Arrays.stream(values()).filter(enumT -> enumT.getDbType().equals(dbType.toUpperCase(Locale.ROOT))).findFirst().orElse(null);
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public String getDbType() {
        return dbType;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public String getJavaType() {
        return javaType;
    }

    public String getJavaTypeShort() {
        return javaTypeShort;
    }
}
