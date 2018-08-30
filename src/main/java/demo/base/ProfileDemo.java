package demo.base;

import demo.base.bean.BaseBean;
import demo.base.bean.DevBean;
import demo.base.bean.ProBean;
import org.springframework.context.annotation.*;

/**
 * 配置类
 */
@Configuration
@ComponentScan("demo.base")
public class ProfileDemo {

    @Bean
    @Profile("dev")
    public BaseBean getDevBean(){
        return new DevBean();
    }

    @Bean
    @Profile("pro")
    public BaseBean getProBean(){
        return new ProBean();
    }

    public static void main(String[] args) {
        //构建注解上下文的时候没有注入配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注入环境的profile 注入profile之后再注入配置类，否则会报类未定义
        context.getEnvironment().setActiveProfiles("pro");
        //注册配置类
        context.register(ProfileDemo.class);
        //刷新
        context.refresh();
        //获取bean
        BaseBean bean = context.getBean(BaseBean.class);
        bean.hello();
        //关闭上下文
        context.close();
    }
}
