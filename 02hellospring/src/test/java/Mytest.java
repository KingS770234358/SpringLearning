import com.wq.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String args[]){
        // 获取spring的上下文对象
        // 使用xml文件进行配置,可以传入多个xml文件进行配置
        // 参数 xml文件路径从resource开始算起
        // 源码:ClassPathXmlApplicationContext 继承于 AbstractXmlApplicationContext
        // AbstractXmlApplicationContext 继承于 AbstractRefreshableConfigApplicationContext
        // AbstractRefreshableConfigApplicationContext 继承于 AbstractRefreshableApplicationContext
        // AbstractRefreshableApplicationContext 继承于 AbstractApplicationContext
        //AbstractApplicationContext 实现了 ConfigurableApplicationContext 接口
        // ConfigurableApplicationContext 接口 继承于 ApplicationContext
        // 在接口 ApplicationContext 中点击行号旁边的点就可以看到接口的实现有哪些
        // ClassPathXmlApplicationContext是它的其中一种实现
        // AnnotationConfigApplicationContext是它的其中一种实现
        // FileSystemXmlApplicationContext是它的其中一种实现
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello hello = (Hello)context.getBean("hello");
        System.out.println(hello.toString());

    }
}
