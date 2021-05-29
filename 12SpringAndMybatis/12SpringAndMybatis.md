12.Spring整合Mybatis
步骤:
1.导入相关的jar包
junit mybatis mysql(jdbc) spring相关 aop织入包 
mybatis-spring[新包====有很多类似这种的整合用包]
lombok log4j ehcache slf4j-log4j
2.编写配置文件
3.测试

2.1 回忆mybatis
2.1.1 编写实体类
2.1.2 编写实体类的接口Mapper.java
2.1.3 编写接口实现的Mapper.xml
2.1.4 编写核心配置文件(注册xml)
2.1.5 获得SqlSession
      SqlSessionFactoryBuilder
      SqlSessionFactory(核心配置文件)
      SqlSession
 private static SqlSessionFactory sqlSessionFactory;
 static {
     String resource = "mybatis-config.xml";
     InputStream inputStream = null;
     try{
         // Resources.getResourceAsStream一定要写在静态代码块里 否则无法识别
         inputStream = Resources.getResourceAsStream(resource);
     }catch (IOException e) {
         e.printStackTrace();
     }
     sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
 }
2.1.6 SqlSession获取Mapper,执行语句
2.1.7 关闭SqlSession

2.2 mybatis-spring
2.2.1 什么是mybatis-spring
可以将Mybatis无缝的整合到Spring中,它允许Mybatis参与
到Spring的食物管理之中,创建映射器Mapper和SqlSession
并注入到bean中,以及将Mybatis的异常转为Spring的DataAccessException
做到应用代码不依赖于MyBatis,Spring或Mybatis-Spring
2.2.2 基础知识
注意版本要求:
mybatis-spring2.0 Mybatis3.5+ Spring5.0+
mybatis-spring1.3 Mybatis3.4+ Spring3.2.2+

2.2.3 Spring5的配置文件spring-mybatis.xml详细介绍
①[如何在Spring5中加载properties文件]

②报错:Exception encountered during context initialization - 
cancelling refresh attempt: org.springframework.beans.factory.BeanDefinitionStoreException: 
Invalid bean definition with name 'datasource' defined in class path resource [spring-mybatis.xml]: 
Could not resolve placeholder 'jdbc.username' in value "${jdbc.username}"; 
nested exception is java.lang.IllegalArgumentException: Could not resolve placeholder 'jdbc.username' in value "${jdbc.username}"
一般是因为包含[not resolve placeholder 'jdbc.username']这个的properties文件没有配置进Sprin容器或者没有成功加载

[${username}取出windows用户名原因分析
 username在windows下默认取值为电脑的账号，一般电脑账号为administrator，如果你的电脑账号是自己设置的，那就为设置的账号。
 数据库连接时数据库中没有administrator用户或者跟你电脑账号一样名字的用户，就会报错
 一般为了避免和Windows基本配置冲突，数据库连接名常常写的较长如{jdbc.username} 这样就可以唯一识别用户名]

################################
#       2.3.4 步骤
################################
1 编写实体类
2 编写实体类的接口Mapper.java
3 编写接口实现的Mapper.xml [具体的Sql语句]
#############################################
# 4 编写使用接口的MapperImpl.java类
# 这个接口实现类其实也可以不写
# 但是写了之后 使用注入的方式进入Spring容器
# 更加符合Spring的思想
#############################################
5 注入数据源dataSource
<bean id="datasource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="${jdbc.driver}"/>
    <property name="url" value="${jdbc.url}"/>
    <property name="username" value="${jdbc.username}"/>
    <property name="password" value="${jdbc.password}"/>
</bean>
6 由数据源得到SqlSessionFactory,并注入(编写/加载核心配置文件(注册xml))
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="datasource"/>
    <property name="configLocation" value="classpath:mybatis-config.xml"/>
    <property name="mapperLocations" value="classpath:com/wq/mapper/*Mapper.xml"/>
</bean>
7 注入SqlSession
<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
    <constructor-arg index="0" ref="sqlSessionFactory"/>
</bean>
8 注入MapperImpl.java接口实现类,将SqlSession注入到接口实现类中
9 在test中直接从applicationContext中获取接口实现类 
  调用接口实现类的方法 进行相应的查询 得到相应的结果
  
#############################################
# mybatis 和 spring 整合之后不需要手动关闭
#############################################
点进org.mybatis.spring.SqlSessionTemplate源码查看 在finally中有关闭了sqlSession
SqlSessionTemplate采用动态代理 使用sqlSessionProxy属性来执行相关的Sql语句
执行完毕后 在finally中将SqlSession关闭 因此 我们不需要手动关闭sqlSession

##############################################################################################
# 创建一个总的Spring配置文件 applicationContext.xml 点击IDEA右上角config application context即可
# 创建一个mybatis-spring的核配置文件 spring-mybatis.xml
# 总配置文件通过import resource来引入mybatis-spring的核心配置文件
# 之前学习mybatis的时候使用的mybatis核心配置文件mybatis-config.xml
# 除了在mybatis-spring的核配置文件工厂部分使用 差不多就没什么用了
# 记得 ApplicationContext applicationContext = \
# new ClassPathXmlApplicationContext("applicationContext.xml");
# 这边的路径一定要改(报错报了很久)
###############################################################################################


