package lowcode.entity.table;

import lowcode.enums.JDBCTypeEnum;
import util.StringUtil;

/**
 * @discription 表字段结构
 * @author kimmy
 * @date 2018年9月29日 下午3:34:52
 */
public class Field {

    // 属性名称
    private String COLUMN_NAME;
    // 数据类型
    private String DATA_TYPE;
    // 数据长度
    private Integer CHARACTER_MAXIMUM_LENGTH;
    // 整数位数 - 1
    private Integer NUMERIC_PRECISION;
    // 小数位数
    private Integer NUMERIC_SCALE;
    // 字段关联键 主键:PRI
    private String COLUMN_KEY;
    // 自动增长
    private String EXTRA;
    // 字段注释
    private String COLUMN_COMMENT;

    public String getCOLUMN_NAME() {
        return COLUMN_NAME;
    }

    public void setCOLUMN_NAME(String cOLUMN_NAME) {
        COLUMN_NAME = cOLUMN_NAME;
    }

    public String getDATA_TYPE() {
        return DATA_TYPE;
    }

    public void setDATA_TYPE(String dATA_TYPE) {
        DATA_TYPE = dATA_TYPE;
    }

    public Integer getCHARACTER_MAXIMUM_LENGTH() {
        return CHARACTER_MAXIMUM_LENGTH;
    }

    public void setCHARACTER_MAXIMUM_LENGTH(Integer cHARACTER_MAXIMUM_LENGTH) {
        CHARACTER_MAXIMUM_LENGTH = cHARACTER_MAXIMUM_LENGTH;
    }

    public Integer getNUMERIC_PRECISION() {
        return NUMERIC_PRECISION;
    }

    public void setNUMERIC_PRECISION(Integer nUMERIC_PRECISION) {
        NUMERIC_PRECISION = nUMERIC_PRECISION;
    }

    public Integer getNUMERIC_SCALE() {
        return NUMERIC_SCALE;
    }

    public void setNUMERIC_SCALE(Integer nUMERIC_SCALE) {
        NUMERIC_SCALE = nUMERIC_SCALE;
    }

    public String getCOLUMN_KEY() {
        return COLUMN_KEY;
    }

    public void setCOLUMN_KEY(String cOLUMN_KEY) {
        COLUMN_KEY = cOLUMN_KEY;
    }

    public String getEXTRA() {
        return EXTRA;
    }

    public void setEXTRA(String eXTRA) {
        EXTRA = eXTRA;
    }

    public String getCOLUMN_COMMENT() {
        return COLUMN_COMMENT;
    }

    public void setCOLUMN_COMMENT(String cOLUMN_COMMENT) {
        COLUMN_COMMENT = cOLUMN_COMMENT;
    }

    public String getJdbcType() {
        String jdbcType = JDBCTypeEnum.matchByDbType(DATA_TYPE).getJdbcType();
        if (StringUtil.isEmpty(jdbcType))
            return DATA_TYPE;
        return jdbcType;
    }

    public String getJavaType() {
        String javaType = JDBCTypeEnum.matchByDbType(DATA_TYPE).getJavaType();
        if (StringUtil.isEmpty(javaType))
            return DATA_TYPE;
        return javaType;
    }

    public String getJavaTypeShort() {
        String javaTypeShort = JDBCTypeEnum.matchByDbType(DATA_TYPE).getJavaTypeShort();
        if (StringUtil.isEmpty(javaTypeShort))
            return DATA_TYPE;
        return javaTypeShort;
    }

    public String getFieldName() {
        String fieldName = COLUMN_NAME;
        while (fieldName.indexOf("_") > 0) {
            int index = fieldName.indexOf("_");
            fieldName = fieldName.substring(0, index) + StringUtil.headUppercase(fieldName.substring(index + 1));
        }
        return fieldName;
    }

    public String getMethodName() {
        String fieldName = COLUMN_NAME;
        while (fieldName.indexOf("_") > 0) {
            int index = fieldName.indexOf("_");
            fieldName = fieldName.substring(0, index) + StringUtil.headUppercase(fieldName.substring(index + 1));
        }
        return StringUtil.headUppercase(fieldName);
    }
}
