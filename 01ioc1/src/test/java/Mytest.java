import com.wq.dao.UserDao;
import com.wq.dao.UserDaoImpl;
import com.wq.dao.UserDaoMysqlImpl;
import com.wq.dao.UserDaoOracleImpl;
import com.wq.service.UserService;
import com.wq.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args){
        /*
        // 在bean.xml文件中配置好之后,就不需要手动new对象了
        // 用户实际使用的是业务层的接口 不能直接使用DAO层
        // 【服务层】接口类型声明 = new 【服务层】接口具体的接口实现类构造函数
        UserService userService = new UserServiceImpl();

        // 先用服务层的接口实现声明服务层的接口
        // 用具体的DAO层接口实现类 new UserDaoMysqlImpl()
        // 来设置 业务层中使用的 DAO层的接口实现类
        ((UserServiceImpl) userService).setUserDao(new UserDaoOracleImpl());
        userService.getUser();
         */
        // 获取ApplicationContext 拿到Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //需要什么取什么
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
        // 要修改打印出来的东西的话 |只需要在bean.xml配置文件中修改|
        userServiceImpl.getUser();
    }
}
