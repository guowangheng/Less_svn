package springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "springboot")
public class UserConfig {

    @Bean(name = "UserDao")
    public UserDao getUserDao(){
        return new UserDao();
    }

}
