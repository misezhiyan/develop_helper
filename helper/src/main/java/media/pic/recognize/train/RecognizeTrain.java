package media.pic.recognize.train;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * @description: 图片识别web
 * @author: liyq
 * @createtime: 2023-04-07 17:30
 */
// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
//         DataSourceTransactionManagerAutoConfiguration.class,
//         DruidDataSourceAutoConfigure.class ,
//         HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class RecognizeTrain {

    public static void main(String[] args) {
        SpringApplication.run(RecognizeTrain.class, args);
    }
}
