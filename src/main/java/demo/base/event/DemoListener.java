package demo.base.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义监听器
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        System.out.println("i accept a msg from " + demoEvent.getClass().getSimpleName() + ",msg: " + demoEvent.getMsg() + "!");
    }
}
