package lowcode;

import lowcode.entity.table.Table;
import lowcode.service.TableStruct;
import lowcode.service.impl.TableStructImpl;
import mybatis.sqlutil.SqlSessionFactoryUtil;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSession;

import javax.sql.DataSource;

/**
 * @description: 低代码生成
 * @author: liyq
 * @createtime: 2023-04-03 15:08
 */
public class LowCode {

    static String url = "jdbc:mysql://localhost:3306/lowcode?serverTimezone=GMT%2B8";
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String username = "root";
    static String password = "root";
    static String mapperXmlPattern = "classpath:mapper/lowcode/*.xml";

    public static void main(String[] args) throws Exception {

        DataSource dataSource = new PooledDataSource(driver, url, username, password);
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.getSqlSession(dataSource, mapperXmlPattern);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // 抽取表结构
        TableStruct tableStruct = new TableStructImpl();
        Table table = tableStruct.tableStruct(sqlSession, "pic_recognize_log");

        // 生成对应文件
        tableStruct.projCreate(table);

        sqlSession.close();
    }
}
