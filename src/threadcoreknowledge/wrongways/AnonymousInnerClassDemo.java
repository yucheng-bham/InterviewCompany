package threadcoreknowledge.wrongways;

/**
 * The class is 创建线程使用匿名内部类方式。
 *
 * @author YuCheng
 * @version 2019/12/17 13:32
 */
public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }){
        }.start();
    }
}
