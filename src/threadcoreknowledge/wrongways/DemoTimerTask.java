package threadcoreknowledge.wrongways;

import java.util.Timer;
import java.util.TimerTask;

/**
 * The class is 创建一个线程使用计时器类Timer.
 *
 * @author YuCheng
 * @version 2019/12/17 13:20
 */
public class DemoTimerTask {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, 1000,1000 );
    }
}
