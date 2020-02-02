package javaBasic;

import java.util.Arrays;
import java.util.Comparator;

public class CharacterTest {
    public static void main(String[] args) {
        /*String s = "//\\--ABCabc";
        for (char c : s.toCharArray()) {
            System.out.print((int)c + " ");
        }
        char c = 'a';
        Character character = Character.valueOf(c);*/

        Character[] chs = {'d', 'c','e', 'b', 'a'};
        Arrays.sort(chs);
        System.out.println(Arrays.toString(chs));

        Arrays.sort(chs, new Comparator<Character>(){

            @Override
            public int compare(Character o1, Character o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(chs));
    }
}
