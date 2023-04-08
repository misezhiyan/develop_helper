package lowcode;

import lowcode.service.TableTransferService;
import lowcode.service.impl.TableTransferServiceImpl;
import mybatis.sqlutil.SqlSessionFactoryUtil;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSession;

import javax.sql.DataSource;

/**
 * @description: TODO
 * @author: liyq
 * @createtime: 2023-04-08 18:49
 */
public class TableTransfer {

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

        TableTransferService transferService = new TableTransferServiceImpl();

        // 抽取数据库到文件
        // transferService.transferDbToFile("lowcode", sqlSession, username, password);

        // 从文件创建数据库
        // transferService.transferTableToDb("lowcodenew", sqlSession, username, password);

        sqlSession.close();
    }

}
