
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@EnableAutoConfiguration
@MapperScan("com.mybatis.mapper")
@ComponentScan("com.mybatis.controller")
@ComponentScan("com.mybatis.service")
@ComponentScan("com.mybatis.schedule")
@ComponentScan("com.mybatis.utils")
//@EnableScheduling
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}