import java.util.HashMap;
import java.util.Map;

public class practice_lru {
    public static void main(String[] args) {
        Lru_Cache cache = new Lru_Cache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
class Lru_Cache {
    
    class Dlnode{
        int key;
        int value;
        Dlnode pre;
        Dlnode next;
    }
    private Map<Integer, Dlnode> cache;
    private Dlnode head;
    private Dlnode tail;
    private int capacity;
    public Lru_Cache(int num) {
        capacity = num;
        cache = new HashMap<>();
        head = new Dlnode();
        tail = new Dlnode();
        
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value) {
        Dlnode node = cache.get(key);
        if (node == null) {
            Dlnode newNode = new Dlnode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addNode(newNode);
            if (cache.size() > capacity) {
                Dlnode tailNode = popTail();
                cache.remove(tailNode.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(Dlnode node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNode(Dlnode node) {
        Dlnode pre = node.pre;
        Dlnode next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    private Dlnode popTail() {
        Dlnode node = tail.pre;
        removeNode(node);
        return node;
    }

    private void addNode(Dlnode node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;

    }

    public int get(int key) {
        Dlnode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
}
