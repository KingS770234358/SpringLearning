import com.wq.mapper.UserMapper;
import com.wq.pojo.User;
import com.wq.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Mytest {

    // 这里测试纯粹的Mybatis是否可行判断环境是否搭好了
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            UserMapper umapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = umapper.selectUsers();
            for(User u:userList){
                System.out.println(u);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }


    }

    @Test
    public void test_SpringMybatis(){
        // 加载Spring配置文件,得到容器上下文对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        User driver = applicationContext.getBean("driver",User.class);
//        System.out.println(driver);
        // 获取UserMapperImpl对象,
        // 也就是原来学习Mybatis时候的测试文件,只不过现在测试文件功能要更加规范
        // 配合UserMapper.xml实现UserMapper定义的接口 完成特定的pojo的增删改查等功能
        // 注意第二个参数 UserMapper.class 是接口.class 而不是接口实现类.class
        UserMapper userMapper = applicationContext.getBean("userMapperImpl2",UserMapper.class);
        List<User> userList = userMapper.selectUsers();
        for(User u:userList){
            System.out.println(u);
        }
    }


}
