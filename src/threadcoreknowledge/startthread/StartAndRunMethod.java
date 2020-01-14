package threadcoreknowledge.startthread;

/**
 * The class is 启动一个线程。run 方法 和start 方法。
 *
 * @author YuCheng
 * @version 2020/1/1 23:05
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        /*Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };*/
        Runnable runnable = () ->{
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();

        new Thread(runnable).start();
    }
}
