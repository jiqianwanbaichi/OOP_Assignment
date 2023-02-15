import java.util.*;

public class SortedIntList extends ArrayIntList {
    boolean unique;

    public SortedIntList() throws Exception {
        this(false);
    }

    public SortedIntList(boolean unique) throws Exception {
        super(10);
        this.unique = unique;
    }

    public SortedIntList(int capacity) throws Exception {
        this(false, capacity);
    }

    public SortedIntList(boolean unique, int capacity) throws Exception {
        super(capacity);
        this.unique = unique;
    }

    public void setUnique(boolean value) throws Exception {
        unique = value;
        if (unique == true) {
            // array.sort(null);
            for (int i = len - 1; i > 0; i--) {
                if (get(i) == get(i - 1)) {
                    remove(i);
                }
            }
        }

    }

    public void add(int value) {
        int insert;
        if (indexOf(value) < 0)
            insert = Math.abs(indexOf(value));
        else
            insert = indexOf(value);
        if (!unique) {
            len++;
            ensureCapacity(capacity);
            for (int i = len - 1; i > insert; i--) {
                array[i] = array[i - 1];
            }
            array[insert] = value;
        }
    }

    public void add(int index, int value) throws Exception {
        throw new Exception("UnsupportedOperationException");
    }

    public boolean getUnique() {
        return unique;
    }

    public int indexOf(int value) {
        return Arrays.binarySearch(array, value);
    }

    public int max() throws Exception {
        if (len == 0)
            throw new Exception("NoSuchElementException");
        else {
            // array.sort(null);
            return get(len - 1);
        }
    }

    public int min() throws Exception {
        if (len == 0)
            throw new Exception("NoSuchElementException");
        else {
            // array.sort(null);
            return get(0);
        }
    }

    public String toString() {
        String output = "[";
        for (int i = 0; i < len; i++) {
            output += array[i];
            if (i != len - 1)
                output += ",";
            else
                output += "]";
        }
        if (unique)
            return "s:" + output + "U";
        else
            return "s:" + output;
    }

    public void sort() {
        for (int i = 0; i < len - 1; i++) {

        }
    }
}
