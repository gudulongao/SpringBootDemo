package demo.base.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("demo.base.aop")
@EnableAspectJAutoProxy//开启Aspect支持
public class AopConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext accontext = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoService service = accontext.getBean(DemoService.class);
        service.say();
    }
}
