package test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jcx.service.TestService;

public class TestProxy {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    @Test
    public void test1(){
        TestService service = context.getBean(TestService.class);
        service.biz1();
        service.biz2();
    }
}
