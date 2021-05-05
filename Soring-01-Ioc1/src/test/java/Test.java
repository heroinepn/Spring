import com.pn.Service.UserServiceImpl;
import com.pn.dao.UserDaoImpl;
import com.pn.dao.UserDaoMysql;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
      /*  UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoMysql());
        //只需要在new出更改对象便可 代码简单
        userService.getUser();*/
        //第二种方法配置文件的测试方式
        //获取ApplicationContext 拿到容器
       ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
         //想要容器哪一个找对应id就行 容器内配置文件ref进行修改即可
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
        userServiceImpl.getUser();
    }
}
