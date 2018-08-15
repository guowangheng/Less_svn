package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;

@Controller
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})  //相当于Configuration + EnableAutoConfiguration + ComponentScan
public class SpringBootApp extends SpringBootServletInitializer implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {


    private static EmbeddedServletContainerInitializedEvent event;

    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
        SpringBootApp.event = event;
    }

    public static int getPort() {
        Assert.notNull(event);
        int port = event.getEmbeddedServletContainer().getPort();
        Assert.state(port != -1, "端口号获取失败");
        return port;
    }

    @RequestMapping("/test/testRun")
    @ResponseBody
    public String testRun(HttpServletRequest request, String username){
        String test = request.getAttribute("test").toString();
        String password = request.getAttribute("password").toString();
        String aaa = request.getParameter("username");
        return aaa + ".." + test + "..." + password;
    }

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootApp.class);
        boolean active = run.isActive();
        if (active){
            Runtime runtime = Runtime.getRuntime();
            String [] cmd={"cmd","/C","start http://localhost:"+getPort()+"/test/testRun"};
            Process exec = runtime.exec(cmd);
            exec.waitFor();
            exec.destroy();
        }

    }

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootApp.class);
    }*/
}
