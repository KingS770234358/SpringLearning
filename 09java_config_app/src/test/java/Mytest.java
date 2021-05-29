import com.wq.config.MyConfig;
import com.wq.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/*
* 测试类
* */
public class Mytest {
    @Test
    public void test(){
        /*
        * 如果完全使用了配置了方式配置, 只能通过AnnotationConfig上下文来获取容器
        * 通过配置类的.class对象加载 一定要.class
        * */
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        // context.getBean(返回Bean的方法名, Bean类.class)
        // 因为getUser返回的就是一个user对象(Bean)
        User u = context.getBean("getUser", User.class);
        System.out.println(u.toString());
    }
}
