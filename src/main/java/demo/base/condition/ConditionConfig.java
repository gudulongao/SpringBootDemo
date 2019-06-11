package demo.base.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(WindowsCondition.class)
    public ICommand windowCommand() {
        return new WindowsCommand();
    }

    @Bean
    @Conditional(MacCondition.class)
    public ICommand macCommand() {
        return new MacCommand();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ICommand command = context.getBean(ICommand.class);
        System.out.println(command.showListCommand());
    }
}
