package demo.base.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 自定义事件发不器
 */
@Component
public class DemoPublish {
    @Autowired
    private ApplicationContext context;

    /**
     * 发布事件
     * @param msg
     */
    public void publish(String msg) {
        context.publishEvent(new DemoEvent(this, msg));
    }
}
