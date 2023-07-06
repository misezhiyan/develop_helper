package lowcode;

import lowcode.entity.table.Table;
import lowcode.service.TableStruct;
import lowcode.service.impl.TableStructImpl;
import mybatis.sqlutil.SqlSessionFactoryUtil;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSession;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 低代码生成
 * @author: liyq
 * @createtime: 2023-04-03 15:08
 */
public class LowCode {

    // static String url = "jdbc:mysql://localhost:3306/lowcode?serverTimezone=GMT%2B8";
    static String url = "jdbc:mysql://localhost:3306/daydayup?serverTimezone=GMT%2B8";
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

        List<String> tableNameList = new ArrayList<>();
        tableNameList.add("student");
        // tableNameList.add("pic_recognize_feature_char");

        // 抽取表结构
        TableStruct tableStruct = new TableStructImpl();

        List<Table> tableList = new ArrayList<>();
        SqlSession finalSqlSession = sqlSession;
        tableNameList.stream().forEach(tableName -> tableList.add(tableStruct.tableStruct(finalSqlSession, tableName)));

        sqlSession.close();

        // 生成对应文件
        tableList.stream().forEach(table -> {
            try {
                tableStruct.projCreate(table);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
