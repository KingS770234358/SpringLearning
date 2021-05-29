import com.wq.service.UserService;
import com.wq.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*
             动态代理 代理的是接口, 所以这里要返回接口
             xml配置的是一个具体的接口实现对象
             但是取出返回的时候要给他转成接口

             取得真实角色(房东) === 接口的实现对象
             这里的接口实现对象[这里的接口实现对象是被增强环绕之后的]
         */
        UserService userService = context.getBean("userServiceImpl",UserService.class);
        userService.add();
    }
}
