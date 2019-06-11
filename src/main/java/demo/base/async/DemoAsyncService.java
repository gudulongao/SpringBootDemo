package demo.base.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async
public class DemoAsyncService {
    public void test() {
        System.out.println("ThreadID:" + Thread.currentThread().getId() + " tmie: " + System.currentTimeMillis());
    }
}
