import java.util.*;

public class ArrayIntList {
    int[] array;
    int len = 0;
    int capacity = 10;

    public ArrayIntList(int capacity) throws Exception {
        if (capacity < 0)
            throw new Exception("IllegalArgumentException");
        else {
            while (capacity > this.capacity) {
                ensureCapacity(this.capacity);
            }
            array = new int[this.capacity];
        }
    }

    public ArrayIntList() throws Exception {
        this(10);
    }

    public void add(int value) {
        len++;
        ensureCapacity(capacity);
        array[len - 1] = value;
    }

    public void add(int index, int value) throws Exception {
        len++;
        ensureCapacity(capacity);
        for (int i = len - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
    }

    public int indexOf(int value) {
        for (int i = 0; i < len; i++) {
            if (array[i] == value)
                return i;
        }
        return -1;
    }

    public int get(int index) throws Exception {
        checkIndex(index, 0, len - 1);
        return array[index];
    }

    public void remove(int index) throws Exception {
        checkIndex(index, 0, len - 1);
        for (int i = index; i < len - 1; i++) {
            array[i] = array[i + 1];
        }
        array[len - 1] = 0;
        len--;
    }

    public int size() {
        return len;
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
        return output;
    }

    public void clear() {
        len = 0;
    }

    public boolean contains(int value) {
        for (int i = 0; i < len; i++) {
            if (array[i] == value)
                return true;
        }
        return false;
    }

    public void ensureCapacity(int capacity) {
        if (len > capacity) {
            capacity *= 2;
            int[] arrayTemp = new int[capacity];
            for (int i = 0; i < len - 1; i++) {
                arrayTemp[i] = array[i];
            }
            array = arrayTemp;
        }
    }

    public boolean isEmpty() {
        return len == 0;
    }

    private void checkIndex(int index, int min, int max) throws Exception {
        if (index < min || index > max) {
            throw new Exception("array index out-of-bounds");
        }
    }
}
