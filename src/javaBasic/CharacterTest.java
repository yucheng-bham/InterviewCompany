package javaBasic;

public class CharacterTest {
    public static void main(String[] args) {
        String s = "//\\--ABCabc";
        for (char c : s.toCharArray()) {
            System.out.print((int)c + " ");
        }
    }
}
