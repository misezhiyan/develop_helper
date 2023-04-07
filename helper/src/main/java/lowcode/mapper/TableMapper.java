package lowcode.mapper;

import lowcode.entity.table.Field;
import lowcode.entity.table.Table;

import java.util.List;

public interface TableMapper {

    /**
     * @description: 表结构
     * @author: liyq
     * @createtime: 2023-04-06 11:04:31
     * @param: tableName
     * @return Table
     */
    Table tableConstruct(String tableName);

    /**
     * @description: 表字段
     * @author: liyq
     * @createtime: 2023-04-06 11:04:43
     * @param: tableName
     * @return Field>
     */
    List<Field> tableFields(String tableName);
}
