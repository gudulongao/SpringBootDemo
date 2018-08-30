package demo.base;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * 注解@Value样例
 * @author gudulongao
 */
@Configuration
@ComponentScan("demo.base")
@PropertySource("valuedemo.properties")
public class ValueAnnDemo {

    /**
     * 加载配置文件中配置
     */
    @Value("${demo.name}")
    private String name;

    @Value("${demo.age}")
    private int age;

    /**
     * 自定义注入
     */
    @Value("abc")
    private String str;

    /**
     * 读取系统参数
     */
    @Value("#{systemProperties['os.name']}")
    private String osName;

    /**
     * 注入网络资源
     */
    @Value("http://www.baidu.com")
    private Resource resource;

    /**
     * 注入文件
     */
    @Value("classpath:valuedemo.properties")
    private Resource file;

    /**
     * 如果使用value注解加载配置文件内容，必须要有该bean
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }                                                 

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ValueAnnDemo.class);
        ValueAnnDemo demo = context.getBean(ValueAnnDemo.class);
        System.out.println(demo.name);
        System.out.println(demo.str);
        System.out.println(demo.age);
        System.out.println(demo.osName);
        System.out.println(demo.resource);
        System.out.println(IOUtils.toString(demo.file.getInputStream()));
        //关闭
        context.close();
    }
}
