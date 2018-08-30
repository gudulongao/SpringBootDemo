package demo.demo.base;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 注解@Value样例
 */
@Configuration
@ComponentScan("demo.base")
@PropertySource("valuedemo.properties")
public class ValueAnnDemo {
}
