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

    public static SqlSession getSqlSession(String driver, String url, String username, String password, String mapperXmlPattern) throws Exception {

        if (null == sqlSessionFactory) {
            DataSource dataSource = new PooledDataSource(driver, url, username, password);
            return getSqlSession(dataSource, mapperXmlPattern);
        }

        return sqlSessionFactory.openSession();
    }

    public static SqlSession getSqlSession(DataSource dataSource, String mapperXmlPattern) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //设置mybatis配置，这里设置了驼峰命名配置
        Configuration config = new Configuration();
        config.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(config);
        //设置Mapper.xml所在的位置
        // sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperXmlPattern));
        sqlSessionFactory = sqlSessionFactoryBean.getObject();
        return sqlSessionFactory.openSession();
    }
}
