package threadcoreknowledge.createthreads;

/**
 * The class is to create the thread using the class Thread.
 *
 * @author YuCheng
 * @version 2019/12/14 10:29
 */
public class ThreadStyle extends Thread{
    public static void main(String[] args) {
        new ThreadStyle().start();
    }

    @Override
    public void run() {
        System.out.println("使用Thread方式来实现一个线程");
    }
}
