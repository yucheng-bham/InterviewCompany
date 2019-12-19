package javaBasic;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        /**
         * 比较器Comparator,
         * 注意点一：
         * 只能转包装类型如Integer,Character or TreeNode 这类数据结构,如果是int,char
         * 就会报错.
         * 注意点二：
         * 泛型<>必须要填写。
         */
        Comparator<Integer> cmp = new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        };
        Integer[] temp = {2, 1,3, 6, 4, 7};
//        int[] temp = {2, 1,3, 6, 4, 7};
        Arrays.sort(temp);
        System.out.println(Arrays.toString(temp));
        Arrays.sort(temp, cmp);
        System.out.println(Arrays.toString(temp));


        Comparator<Character> charcmp = new Comparator<Character>(){
            @Override
            public int compare(Character a, Character b) {
                return b - a;
            }
        };
        Character[] chartemp = {'a', 'g', 'e', 'h', 'c', 'b'};
//        char[] chartemp = {'a', 'g', 'e', 'h', 'c', 'b'};
        Arrays.sort(chartemp);
        System.out.println(Arrays.toString(chartemp));
        Arrays.sort(chartemp, charcmp);
        System.out.println(Arrays.toString(chartemp));
    }
}
