package threadcoreknowledge.createthreads;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * The class is to test 到底在创建一个线程时，到底时使用了哪种方法。
 * 结论是本质上都是使用了Thread的run方法。
 * 不过runnable接口是实现的run方法，再让Thread执行。而thread类直接重写run方法。
 *
 * @author YuCheng
 * @version 2019/12/14 10:44
 */
public class BothRunnableThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自runnable");
            }
        }
        ){
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();
    }
}
