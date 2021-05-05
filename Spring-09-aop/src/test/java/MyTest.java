import com.pn.service.UserService;
import com.pn.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //动态代理代理的是接口：注意点
        UserService userService = (UserService) context.getBean("userService");
        //不是实现类
        //UserServiceImpl userService = context.getBean("userService", UserServiceImpl.class);

        userService.add();
       // userService.select();
    }
}

