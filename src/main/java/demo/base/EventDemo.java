package demo.base;

import demo.base.event.DemoPublish;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("demo.base")
public class EventDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventDemo.class);
        DemoPublish publish = context.getBean(DemoPublish.class);
        publish.publish("hello");
        context.close();
    }
}
