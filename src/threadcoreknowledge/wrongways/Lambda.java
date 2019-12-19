package threadcoreknowledge.wrongways;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

/**
 * The class is 使用lambda方式创建一个线程。
 *
 * @author YuCheng
 * @version 2019/12/17 15:04
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
