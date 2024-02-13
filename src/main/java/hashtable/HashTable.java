package hashtable;

public class HashTable {
    private Entry[] assocArray;
    private final int DEFAULT_SIZE = 7;

    public HashTable() {
        assocArray = new Entry[DEFAULT_SIZE];
    }

    private class Entry {
        String key;
        Object value;
        Entry next;

        Entry(String key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }


        public String toString() {
            StringBuilder s = new StringBuilder();
            return stringifyEntry(this, s);
        }

        private String stringifyEntry(Entry e, StringBuilder s) {
            String result = "(" + e.key + " -> " + e.value.toString() + ")";
            if (e.next != null) {
                s.append(result).append(" -> ");
                stringifyEntry(e.next, s);
            }
            s.append(result).append(" -> ");
            return s.toString();
        }
    }

    public void set(String k, Object v) {
        int index = hash(k);

        if (assocArray[index] == null) {
            assocArray[index] = new Entry(k, v);
        } else if (assocArray[index] != null && assocArray[index].key.equals(k)) {
            assocArray[index].value = v;
        } else {
            aux(assocArray[index], k, v);
        }
    }

    public Object get(String k) {
        int index = hash(k);

        if (assocArray[index] == null) {
            return null;
        } else {
            return auxGet(k, assocArray[index]);
        }
    }

    private Object auxGet(String k, Entry e) {
        if (e.key.equals(k)) {
            return e.value;
        } else if (e.next != null) {
            auxGet(k, e.next);
        }
        return null;
    }


    private void aux(Entry e, String k, Object v) {
        if (e.next != null) {
            aux(e.next, k, v);
        }
        e.next = new Entry(k, v);
    }

    public int hash(String key) {
        int hashKeyValue = 0;
        for (int i = 0; i < key.length(); i++) {
            int charCode = key.charAt(i);
            hashKeyValue = (hashKeyValue + charCode * 23) % assocArray.length;
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

