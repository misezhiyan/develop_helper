package lowcode.entity.table;

import util.StringUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @discription 表结构
 * @author kimmy
 * @date 2018年9月29日 下午3:34:52
 */
public class Table {

    private String TABLE_NAME;
    private String TABLE_COMMENT;
    private List<Field> fieldList;
    private Field prikey;

    public void setTABLE_NAME(String tABLE_NAME) {
        TABLE_NAME = tABLE_NAME;
    }

    public String getTABLE_COMMENT() {
        return TABLE_COMMENT;
    }

    public void setTABLE_COMMENT(String tABLE_COMMENT) {
        TABLE_COMMENT = tABLE_COMMENT;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;

        for (Field field : fieldList) {
            String COLUMN_KEY = field.getCOLUMN_KEY();
            if (COLUMN_KEY.equals("PRI"))
                this.prikey = field;
        }
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public Field getPrikey() {
        return prikey;
    }

    public void setPrikey(Field prikey) {
        this.prikey = prikey;
    }

    public String getParamName() {

        String className = TABLE_NAME;
        while (className.indexOf("_") > 0) {
            int index = className.indexOf("_");
            className = className.substring(0, index) + StringUtil.headUppercase(className.substring(index + 1));
        }

        return StringUtil.headLowercase(className);
    }

    public String getClassName() {

        String className = TABLE_NAME;
        while (className.indexOf("_") > 0) {
            int index = className.indexOf("_");
            className = className.substring(0, index) + StringUtil.headUppercase(className.substring(index + 1));
        }

        return StringUtil.headUppercase(className);
    }

}
