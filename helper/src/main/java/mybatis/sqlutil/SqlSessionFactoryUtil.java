package mybatis.sqlutil;

import mybatis.mapper.TestMapper;
import org.apache.ibatis.builder.xml.XMLStatementBuilder;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import util.StringUtil;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/**
 * @discription 用于单例模式获取sqlSessionFactory
 * @author kimmy
 * @date 2018年9月29日 下午4:38:00
 */
public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory;
    private static String mybatisConfigPath;

    public static void main(String[] args) throws Exception {

        String driver = "com.mysql.jdbc.Driver", url = "root", username = "root", password = "root";

        getSqlSession(driver, url, username, password);
    }

    public static SqlSession getSqlSession(String driver, String url, String username, String password) throws Exception {

        if (null == sqlSessionFactory) {
            // if (StringUtil.isEmpty(mybatisConfigPath)) {
            //     File directory = new File("");// 参数为空
            //     String PROJECTREALPATH = null;
            //     try {
            //         PROJECTREALPATH = directory.getCanonicalPath();
            //     } catch (IOException e) {
            //         e.printStackTrace();
            //     }
            //     String CONFIGREALPATH = PROJECTREALPATH + "/src/main/config";
            //     mybatisConfigPath = CONFIGREALPATH + "/mybatis.xml";
            // }
            // Reader re = null;
            // try {
            //     re = Resources.getResourceAsReader("mybatis.xml");
            // } catch (IOException e) {
            //     e.printStackTrace();
            // }
            DataSource dataSource = new PooledDataSource(driver, url, username, password);

            // Environment environment = new Environment("dev", new JdbcTransactionFactory(), dataSource);
            //
            // Configuration config = new Configuration();
            // // config.setVariables(properties);
            // config.setEnvironment(environment);
            // // config.addMapper(TestMapper.class);
            // config.addMappers("mybatis.mapper");
            //
            //
            // config.setLogImpl(StdOutImpl.class);
            // config.setMapUnderscoreToCamelCase(true);
            // sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);

            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            //设置数据源
            sqlSessionFactoryBean.setDataSource(dataSource);
            //设置mybatis配置，这里设置了驼峰命名配置
            org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
            config.setMapUnderscoreToCamelCase(true);
            sqlSessionFactoryBean.setConfiguration(config);
            //设置Mapper.xml所在的位置
            // sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));

            sqlSessionFactory = sqlSessionFactoryBean.getObject();
        }

        return sqlSessionFactory.openSession();
    }
}
