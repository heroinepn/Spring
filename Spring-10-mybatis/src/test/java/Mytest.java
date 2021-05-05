import com.pn.mapper.UserMapper;
import com.pn.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mytest {
//    @Test
//    public void selectUser() throws IOException {
//
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//
//        List<User> userList = mapper.selectUser();
//        for (User user: userList){
//            System.out.println(user);
//        }
//
//        sqlSession.close();
//    }

//    @Test
//    public void test () throws IOException {
//
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
//
//        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
//        for (User user : userMapper.selectUser()) {
//            System.out.println(user);
//        }
//    }

//第二种
@Test
public void test () throws IOException {

    ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");

    UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
    for (User user : userMapper.selectUser()) {
        System.out.println(user);
    }
}



}
