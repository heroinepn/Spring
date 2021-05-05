import com.pn.entity.User;
import com.pn.entity.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //只new user走无参构造
       // User user = new User();
       //总配置拿到
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");
        UserT userT = (UserT) context.getBean("user2");
        user.show();
        userT.show();
    }
}
