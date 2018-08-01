package springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

public class TestUser {

    private Annotation annotation;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserConfig.class);
        //applicationContext.scan("springboot1");
        UserDao userDao = applicationContext.getBean("UserDao", UserDao.class);
        List<User> users = userDao.queryUserList();
        /*for (User user : users) {
            System.out.println(user.toString());
        }*/
        Class<UserService> userServiceClass = UserService.class;
        try {
            /*Field dao = userServiceClass.getDeclaredField("userDao");*/
            Field[] declaredFields = userServiceClass.getDeclaredFields();
            UserService userService = userServiceClass.newInstance();
            for (Field declaredField : declaredFields) {
                boolean annotationPresent = declaredField.isAnnotationPresent(Resource.class);
                if (annotationPresent){
                    declaredField.setAccessible(true);
                    declaredField.set(userService, userDao);
                    userService.selectUserList();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            applicationContext.destroy();
        }

    }
}
