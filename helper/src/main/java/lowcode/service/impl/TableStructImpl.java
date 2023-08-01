package lowcode.service.impl;

import lowcode.CreateConfig;
import lowcode.entity.table.Table;
import lowcode.mapper.TableMapper;
import lowcode.service.TableStruct;
import lowcode.service.impl.projcreate.*;
import org.apache.ibatis.session.SqlSession;
import util.PathUtil;

/**
 * @description: 表结构抽取
 * @author: liyq
 * @createtime: 2023-04-06 09:36:36
 */
public class TableStructImpl implements TableStruct {

    /**
     * @description: 抽取表结构
     * @author: liyq
     * @createtime: 2023-04-06 11:17:57
     * @param: sqlSession
     * @param: tableName
     * @return Table
     */
    @Override
    public Table tableStruct(SqlSession sqlSession, String tableName) {
        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);
        Table table = tableMapper.tableConstruct(tableName);
        return table;
    }

    /**
     * @description: 生成项目文件
     * @author: liyq
     * @createtime: 2023-04-06 11:18:08
     * @param: table
     */
    @Override
    public void projCreate(Table table) throws Exception {

        // EntityCreateManager.createFile(table);
        // MapperCreateManager.createFile(table);
        // MapperXmlCreateManager.createFile(table);
        ServiceCreateManager.createFile(table);
        ControllerCreateManager.createFile(table);
    }
}
