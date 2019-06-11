package demo.base.schedul;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoSchedul {

    @Scheduled(fixedDelay = 5000)
    public void printTimebyFiexedDelay() {
        try {
            System.out.println(System.currentTimeMillis() + " start...");
            Thread.sleep(10000);
            System.out.println(System.currentTimeMillis() + " finished!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
