import com.wq.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String args[]){
        //User user = new User();
        // 在获得ApplicationContext的时候
        // 就已经创建了beans.xml文件中配置的对象 调用他们的构造函数
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User)context.getBean("user");
        user.show();
        User user1 = (User)context.getBean("user1");
        user1.show();
        User user2 = (User)context.getBean("user2");
        User user22 = (User)context.getBean("user2");
        // user2 和 user22完全相等(地址也一样)
        // 说明在IoC中只有一个User实例, user2 和 user22指向同一个User实例
        // 单例！
        System.out.println(user2 == user22);
        user2.show();
        // user2作出的改变 会影响到user22
        user2.setName("新名字");
        System.out.println(user22.getName());
    }
}
