package lowcode.mapper;

import lowcode.entity.table.Field;
import lowcode.entity.table.Table;

import java.util.List;
import java.util.Map;

public interface TableCreateMapper {

    /**
     * @description: 所有表
     * @author: liyq
     * @createtime: 2023-04-08 17:01:13
     * @return String
     */
    List<String> allTables();

    /**
     * @description: 建表sql
     * @author: liyq
     * @createtime: 2023-04-08 17:01:44
     * @param: tableName
     * @return String
     */
    Map<String, String> createSql(String tableName);

    /**
     * @description: 执行建表Sql
     * @author: liyq
     * @createtime: 2023-04-08 18:48:14
     * @param: creatSql
     * @return String
     */
    String createOneTable(String creatSql);

    /**
     * @description: 当前链接schema
     * @author: liyq
     * @createtime: 2023-04-08 21:28:06
     * @return String
     */
    String schema();

    /**
     * @description: 查看数据库是否存在
     * @author: liyq
     * @createtime: 2023-04-08 22:53:11
     * @param: schema
     * @return String
     */
    String searchDatabase(String schema);

    /**
     * @description: 删库
     * @author: liyq
     * @createtime: 2023-04-08 22:55:20
     * @param: database
     * @return int
     */
    int dropDatabase(String database);

    /**
     * @description: 建库
     * @author: liyq
     * @createtime: 2023-04-08 22:58:02
     * @param: database
     * @return int
     */
    int createDatabase(String database);

    /**
     * 切库
     * @author: liyq
     * @createtime: 2023-04-08 22:58:02
     * @param: database
     * @return int
     */
    int useDatabase(String database);
}
