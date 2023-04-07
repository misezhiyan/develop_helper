package lowcode.service;

import lowcode.entity.table.Table;
import org.apache.ibatis.session.SqlSession;

/**
 * @description: 表结构抽取
 * @author: liyq
 * @createtime: 2023-04-06 09:36:36
 */
public interface TableStruct {

    /**
     * @description: 抽取表结构
     * @author: liyq
     * @createtime: 2023-04-06 11:17:04
     * @param: sqlSession
 * @param: tableName
     * @return Table
     */
    Table tableStruct(SqlSession sqlSession, String tableName);

    /**
     * @description: 生成项目文件
     * @author: liyq
     * @createtime: 2023-04-06 11:17:21
     * @param: table
     */
    void projCreate(Table table) throws Exception;
}
