package threadcoreknowledge.wrongways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The class is to 使用一个线程池去创建线程。
 *
 * @author YuCheng
 * @version 2019/12/14 11:24
 */
public class ThreadPool5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Task());
        }
    }
}
class Task implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}

