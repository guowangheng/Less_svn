package springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Guo.WangHeng on 2018/8/17.
 */
@Controller
public class VueController {

    @RequestMapping("/test/testVue1")
    public ModelAndView testVue1(ModelAndView modelAndView){
        modelAndView.setViewName("vueTest");
        System.out.println("9999");
        modelAndView.addObject("testData","哈哈哈哈");
        System.out.println("水水水水和");
        return modelAndView;
    }

    @RequestMapping("/test/testBs")
    public String testVue2(HttpServletRequest request){
        return "TestBootStrap";
    }

}
