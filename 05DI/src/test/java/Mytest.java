import com.wq.pojo.Student;
import com.wq.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String args[]){
//        <!-- 如果没有传入xml文件路径会有如下报错:
//        BeanFactory not initialized or already closed - call 'refresh' before accessing beans via the ApplicationContext
//        -->
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student stu = (Student) context.getBean("stu");
        Student stu2 = (Student) context.getBean("stu");
        // 只能获取在xml文件中注入的值 没注入的属性不能使用
        System.out.println(stu.toString());
        stu.setWife("xq");
        System.out.println(stu.toString());
        // stu的改变不影响stu2
        // 这就是在xml bean中将scope设置为prototype的效果
        // 每次getBean都会产生一个新的对象
        System.out.println(stu2.toString());
        // 两者的hashcode不一样也可以说明他们不是同一个对象
        System.out.println(stu.hashCode());
        System.out.println(stu2.hashCode());

        /*
        Student{
            name='王强',
            address=Address{address='福建'},
            books=[《红楼》, 《西游》],
            hobbies=[游泳, 跑步],
            card={key1=value1, key2=value2},
            games=[LOL, BOB],
            info={prop2=prop2_value, prop1=prop1_value},
            wife='null'
        }
         */
    }
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userpc.xml");
        // 普通注入方式
        User u = context.getBean("user", User.class);
        System.out.println(u.toString());
        // p命名空间注入方式
        User u2 = context.getBean("user2", User.class);
        System.out.println(u2.toString());
        // c命名空间注入方式
        User u3 = context.getBean("user3", User.class);
        System.out.println(u3.toString());

    }
}
