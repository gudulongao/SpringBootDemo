package demo.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;

/**
 * 注解@Value样例
 * @author gudulongao
 */
@Configuration
@ComponentScan("demo.base")
@PropertySource("valuedemo.properties")
public class ValueAnnDemo {

    @Value("${demo.name}")
    private String name;

    @Value("${demo.age}")
    private int age;

    @Value("abc")
    private String str;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("http://www.baidu.com")
    private Resource resource;
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ValueAnnDemo.class);
        ValueAnnDemo demo = context.getBean(ValueAnnDemo.class);
        System.out.println(demo.name);
        System.out.println(demo.str);
        System.out.println(demo.age);
        System.out.println(demo.osName);
        System.out.println(demo.resource);
        //关闭
        context.close();
    }
}
