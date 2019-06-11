package demo.base.schedul;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("demo.base.schedul")
@EnableScheduling
public class DemoConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoSchedul schedul = context.getBean(DemoSchedul.class);

        schedul.printTimebyFiexedDelay();
    }
}
