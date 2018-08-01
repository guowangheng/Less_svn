package springboot;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public class UserService {

    @Autowired
    private UserDao userDao;

    private User user;

    @Resource
    private UserDao userDao1;

    public void selectUserList(){
        List<User> users = userDao1.queryUserList();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

}
