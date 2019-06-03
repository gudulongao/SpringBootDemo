package demo.base.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public void say() {
        System.out.println("hello world!");
    }
}
