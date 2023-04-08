package lowcode.service;

import mybatis.sqlutil.SqlSessionFactoryUtil;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSession;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @description: 表转移
 * @author: liyq
 * @createtime: 2023-04-08 18:49
 */
public interface TableTransferService {

    /**
     * @description: 数据库抽取到文件
     * @author: liyq
     * @createtime: 2023-04-08 22:19:51
     * @param: dbName
     * @param: sqlSession
     * @param: username
     * @param: password
     */
    void transferDbToFile(String dbName, SqlSession sqlSession, String username, String password) throws Exception;

    /**
     * @description: 根据文件建库
     * @author: liyq
     * @createtime: 2023-04-08 22:20:09
     * @param: sqlSession
     */
    void transferTableToDb(String schema,SqlSession sqlSession, String username, String password) throws IOException, InterruptedException;
}
