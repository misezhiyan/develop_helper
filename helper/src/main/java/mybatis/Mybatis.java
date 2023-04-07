package mybatis;

import mybatis.mapper.TestMapper;
import mybatis.sqlutil.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @description: mybatis
 * @author: liyq
 * @createtime: 2023-04-03 17:26
 */
public class Mybatis {

    static String url = "jdbc:mysql://localhost:3306/datadeal?serverTimezone=GMT%2B8";
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String username = "root";
    static String password = "root";
    static String mapperXmlPattern = "classpath:mapper/*.xml";

    public static void main(String[] args) throws Exception {

        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(driver, url, username, password, mapperXmlPattern);
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);

        int a = mapper.testSelect();
        System.out.println(a);

        sqlSession.close();
    }
}
