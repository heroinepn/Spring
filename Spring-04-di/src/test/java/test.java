import com.pn.entity.Student;
import com.pn.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userBean.xml");

        User user = context.getBean("user",User.class);
        System.out.println(user);
        User user1 = context.getBean("user",User.class);
        System.out.println(user==user1);

        User user2 = context.getBean("user2",User.class);
        System.out.println(user2);
        User user3 = context.getBean("user2",User.class);
        System.out.println(user3);
        //根据单例模式和原型模式比较
        System.out.println(user2==user3);

    }


}

