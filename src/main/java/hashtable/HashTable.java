package hashtable;

import java.util.Arrays;

public class HashTable {
    private Entry[] assocArray;
    private final int DEFAULT_SIZE = 5;
    private int currentCapacity;
    private final double DEFAULT_MAX_CAPACITY_COEF = 0.75;

    public HashTable() {
        assocArray = new Entry[DEFAULT_SIZE];
        this.currentCapacity = 0;
    }

    public HashTable(int size) {
        assocArray = new Entry[size];
        this.currentCapacity = 0;
    }

    private class Entry {
        String key;
        Object value;
        Entry next;
        int rawHash;

        Entry(String key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.rawHash = hash(key);
        }


        public String toString() {
            StringBuilder s = new StringBuilder();
            return stringifyEntry(this, s);
        }


        private String stringifyEntry(Entry e, StringBuilder s) {
            String result = "(" + e.key + " : " + e.value.toString() + ")";
            if (e.next == null) {
                s.append(result).append(" -> ");
                return s.toString();
            }
            s.append(result).append(" -> ");
            return stringifyEntry(e.next, s);

        }
    }

    private void resize() {
        Entry[] tempArray = Arrays.copyOf(assocArray, assocArray.length);
        this.assocArray = new Entry[2 * this.assocArray.length];
        this.currentCapacity = 0;
        int i = 0;
        while (i++ < tempArray.length - 1) {
            rehashBucket(tempArray[i - 1]);
        }
    }

    private void rehashBucket(Entry e) {
        if (e == null) {
            return;
        } else if (e.next == null) {
            set(e.key, e.value);
            return;
        }
        set(e.key, e.value);
        rehashBucket(e.next);
    }

    public void set(String k, Object v) {
        double occupancy = (double) currentCapacity / assocArray.length;
        if (occupancy >= DEFAULT_MAX_CAPACITY_COEF) {
            resize();
        }
        int index = hash(k) % assocArray.length;

        if (assocArray[index] == null) {
            assocArray[index] = new Entry(k, v);
            this.currentCapacity += 1;
        } else if (assocArray[index] != null && assocArray[index].key.equals(k)) {
            assocArray[index].value = v;
        } else {
            auxSet(assocArray[index], k, v);
        }
    }

    public Object get(String k) {
        int index = hash(k) % assocArray.length;
        return (assocArray[index] != null) ? traverseBucket(k, assocArray[index]) : null;
    }

    private Object traverseBucket(String k, Entry e) {
        if (e.key.equals(k)) {
            return e.value;
        } else if (e.next != null) {
            traverseBucket(k, e.next);
        }
        return null;
    }


    private void auxSet(Entry e, String k, Object v) {
        if (e.next != null) {
            auxSet(e.next, k, v);
        }
        e.next = new Entry(k, v);
    }

    public int hash(String key) {
        int hashKeyValue = 0;
        for (int i = 0; i < key.length(); i++) {
            int charCode = key.charAt(i);
            hashKeyValue = (hashKeyValue + charCode * 23);
        }
        return hashKeyValue;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < assocArray.length; i++) {
            result.append(i).append(" : ").append((assocArray[i] != null) ? assocArray[i].toString() : "null").append("\n");
        }
        return result.toString();
    }
}

