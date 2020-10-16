
public class MyStruct<T> {
    private final static int DEFAULT_CAPACITY = 7;// default size
    private final static double LOAD = 0.7;
    private int numBuckets;   // number of buckets
    private int numElements; // number of existing elements
    private Object[] buckets;

    public MyStruct(int capacity) {
        numBuckets = capacity;
        buckets = new Object[numBuckets];
        numElements = 0;
    }

    public MyStruct(){
        this(DEFAULT_CAPACITY);
    }
    /*
     adds element into array of buckets
     calculates index using hashCode of key
     if some keys have same index last key is add  as linked list
     returns true if key is successfully added
     */
    public boolean add(T key) {
        if (key == null) return false;
        resize();
        int index = Math.abs(key.hashCode()) % numBuckets;
        Bucket<T> newElem = new Bucket<>(key);
        Bucket<T> curr = (Bucket) buckets[index];
        if (curr == null) {
            buckets[index] = newElem;
        } else {
            if (curr.key.equals(key)) return false;
            while (curr.next != null) {
                if (curr.next.key.equals(key)) {
                    return false;
                }
                curr = curr.next;
            }
            curr.next = newElem;
        }
        numElements++;
        return true;
    }
        // deletes key from MyStruct
    public boolean delete(T key) {
        int index = Math.abs(key.hashCode()) % numBuckets;
        Bucket<T> current = (Bucket) buckets[index];
        if (current == null) {
            return false;
        } else {
            if (current.key.equals(key)) {
                buckets[index] = current.next;
                numElements--;
                return true;
            }
            while (current.next != null) {
                if (current.next.key.equals(key)) {
                    current.next = current.next.next;
                    numElements--;
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
    /*
    check if MyStruct contains key
     */
    public boolean contains(T key) {
        int index = Math.abs(key.hashCode()) % numBuckets;
        Bucket<T> curr = (Bucket) buckets[index];
        if (curr == null) {
            return false;
        } else {
            if (curr.key.equals(key)) return true;
            while (curr.next != null) {
                if (curr.next.key.equals(key)) {
                    return true;
                }
                curr = curr.next;
            }
        }
        return false;
    }

    // resize array of objects if number of elements  almost equals capacity
    private void resize() {
        if ((numElements + 1) / numBuckets >= LOAD) {
            int newSize = numBuckets << 1; // double size
            Object[] newBuckets = new Object[newSize];
            for (int i = 0; i < numBuckets; i++) {
                Bucket<T> curr = (Bucket) buckets[i];
                while (curr != null) {
                    int newIndex = Math.abs(curr.key.hashCode()) % newSize;
                    Bucket<T> next = curr.next;
                    curr.next = (Bucket) newBuckets[newIndex]; // add current element at the front of linked list
                    newBuckets[newIndex] = curr;
                    curr = next;
                }
            }
            buckets = newBuckets;
            numBuckets = newSize;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < numBuckets; i++) {
            if (buckets[i] != null) {
                Bucket<T> curr = (Bucket) buckets[i];
                while (curr != null) {
                    sb.append(curr.key).append(" ");
                    curr = curr.next;
                }
            }
        }
        return sb.toString();
    }

    public int size() {
        return numElements;
    }

    /*
        inner class
        used as linked list node
     */
    private static class Bucket<T> {
        private final T key;
        private Bucket<T> next;
        private Bucket(T key) {
            this.key = key;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        MyStruct<String> st = new MyStruct<>();
        for (int i = 0; i < 1000; i++) {
            st.add(i + "test");
        }
        System.out.println(st.toString());

        st.delete("6test");
        st.delete("199test");
        //st.delete(1);
        //System.out.println(st.contains(1) );
        System.out.println(st.toString());
    }

}
