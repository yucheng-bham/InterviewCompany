package LeetCode_381_InsertDeleteGetRandomDuplicatesallowed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/3/5 8:10
 */
public class Duplicatesallowed {
    public static void main(String[] args) {
        /**
         * Your RandomizedCollection object will be instantiated and called as such:*/
        RandomizedCollection obj = new RandomizedCollection();
        boolean param_1 = obj.insert(0);
        System.out.println(param_1);
        boolean param_2 = obj.insert(1);
        System.out.println(param_2);
        boolean param_3 = obj.remove(0);
        System.out.println(param_3);
        boolean param_4 = obj.insert(2);
        System.out.println(param_4);
        boolean param_5 = obj.remove(1);
        System.out.println(param_5);
//        boolean param_4 = obj.remove(1);
        int param_6 = obj.getRandom();
        System.out.println(param_6);
        System.out.println(obj.insert(2));
    }
}

class RandomizedCollection {
    ArrayList<Integer> lst;
    HashMap<Integer, Set<Integer>> idx;
    java.util.Random rand = new java.util.Random();

    /**
     * Initialize your data structure here.
     */

    public RandomizedCollection() {
        lst = new ArrayList<Integer>();
        idx = new HashMap<Integer, Set<Integer>>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!idx.containsKey(val)) idx.put(val, new LinkedHashSet<Integer>());
        idx.get(val).add(lst.size());
        lst.add(val);
        return idx.get(val).size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!idx.containsKey(val) || idx.get(val).size() == 0) return false;
        int remove_idx = idx.get(val).iterator().next();
        idx.get(val).remove(remove_idx);
        int last = lst.get(lst.size() - 1);
        lst.set(remove_idx, last);
        idx.get(last).add(remove_idx);
        idx.get(last).remove(lst.size() - 1);

        lst.remove(lst.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return lst.get(rand.nextInt(lst.size()));
    }
}


/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
