import com.wq.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 因为没有指明 id 所以 id默认是类名的全小写
        User u = context.getBean("user", User.class);
        System.out.println(u.name);
    }
}
