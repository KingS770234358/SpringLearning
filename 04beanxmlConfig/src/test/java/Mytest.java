import com.wq.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String args[]){
        //User user = new User();
        // 在获得ApplicationContext的时候
        // 就已经创建了beans.xml文件中配置的对象 调用他们的构造函数
        // 这里读取总的xml配置文件即可.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = (User)context.getBean("user1");
        user1.show();
        // 通过别名取对象
        User user_alias = (User)context.getBean("user1_alias");
        user_alias.show();
        User user_alias1 = (User)context.getBean("user1_alias1");
        user_alias1.show();
        User user_alias2 = (User)context.getBean("user1_alias2");
        user_alias2.show();
        User user_alias3 = (User)context.getBean("user1_alias3");
        user_alias3.show();
        User user_alias4 = (User)context.getBean("user1_alias4");
        user_alias4.show();

    }
}
