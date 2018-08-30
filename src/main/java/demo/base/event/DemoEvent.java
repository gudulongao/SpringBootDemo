package demo.base.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 *
 * @author gudulongao
 */
public class DemoEvent extends ApplicationEvent {
    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
