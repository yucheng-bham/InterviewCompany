package threadcoreknowledge.createthreads;

/**
 * The class is to create the thread using the class Thread.
 *
 * @author YuCheng
 * @version 2019/12/14 9:41
 */
public class RunnableStyle implements Runnable {

    public static void main(String[] args) {
        Thread runnable = new Thread(new RunnableStyle());
        runnable.start();
    }
    @Override
    public void run() {
        System.out.println("使用Runnable方式实现一个线程");
    }

}
