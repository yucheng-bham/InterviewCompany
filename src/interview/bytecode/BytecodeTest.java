package interview.bytecode;

public class BytecodeTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        b += a;
        a = b - a;
        b = b - a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
