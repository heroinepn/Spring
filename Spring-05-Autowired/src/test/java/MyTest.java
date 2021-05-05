import com.pn.entity.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        People people = context.getBean("people", People.class);
        people.getCat().shout();
        people.getDog().shout();


    }



}
