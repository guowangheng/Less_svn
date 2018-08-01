package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication  //相当于Configuration + EnableAutoConfiguration + ComponentScan
public class SpringBootApp {

    @RequestMapping("testRun")
    @ResponseBody
    public String testRun(String username){

        return username;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class);
    }

}
