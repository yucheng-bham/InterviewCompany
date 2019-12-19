import java.util.HashMap;
import java.util.Map;

public class LeetCode_146_LRU_CACHE {
    public static class LRUCache {
        class Dlnode {
            int key;
            int val;
            Dlnode pre;
            Dlnode next;
        }
        public void addNode(Dlnode node) {
            node.pre = head;
            node.next = head.next;

            head.next.pre = node;
            head.next = node;
        }
        public void removeNode(Dlnode node) {
            Dlnode pre = node.pre;
            Dlnode next = node.next;

            pre.next = next;
            next.pre = pre;
        }
        public void moveToHead(Dlnode node) {
            removeNode(node);
            addNode(node);
        }
        public Dlnode popTail() {
            Dlnode tailNode = tail.pre;
            removeNode(tailNode);
            return tailNode;
        }
        private Map<Integer, Dlnode> cache = new HashMap<>();
        private int capacity;
        private Dlnode head;
        private Dlnode tail;
        public LRUCache(int capacity) {
            this.capacity = capacity;

            head = new Dlnode();
            tail = new Dlnode();

            head.next = tail;
            tail.pre = head;

        }

        public int get(int key) {
            Dlnode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            Dlnode node = cache.get(key);
            if (node == null) {
                Dlnode newNode = new Dlnode();
                newNode.key = key;
                newNode.val = value;
                cache.put(key, newNode);

                addNode(newNode);

                if (cache.size() > capacity) {
                    Dlnode tailnode = popTail();
                    removeNode(tailnode);

                    cache.remove(tailnode.key);
                }

            } else {
                node.val = value;
                cache.put(key, node);
                moveToHead(node);
            }
        }
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

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
