import com.wq.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String args[]){

    }
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = context.getBean("people", People.class);
        // System.out.println(people.toString());
        people.getCat().shout();
        people.getDog().shout();

        People people_auto = context.getBean("people_auto", People.class);
        people_auto.getCat().shout();
        people_auto.getDog().shout();

        People people_auto2 = context.getBean("people_auto2", People.class);
        people_auto2.getCat().shout();
        people_auto2.getDog().shout();
    }
}
