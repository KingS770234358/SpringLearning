import com.wq.mapper.UserMapper;
import com.wq.mapper.UserMapperImpl;
import com.wq.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Mytest {
    @Test
    public void base_test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapperImpl", UserMapper.class);
        List<User> userList = userMapper.selectUsers();
        for(User u : userList){
            System.out.println(u);
        }
    }

    @Test
    public void test_Transaction(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapperImpl = context.getBean("userMapperImpl", UserMapper.class);
        /**
             1.这组事务 添加成功 但是删除失败 不符合事务的原则
             2.在spring-mybatis.xml文件(也就是spring专门配置mybatis和数据库的配置文件中)
             配置好在方法上的事务通知的织入后 再次进行测试
             ===>由于delete sql语句存在问题,删除仍然报错
             但是transaction方法织入了事务之后,删除失败的同时,新增也失败了
             说明整个操作成功的组成了一个事务
         */

        List<User> userList = userMapperImpl.transaction();
        for(User u : userList){
            System.out.println(u);
        }
    }
}
