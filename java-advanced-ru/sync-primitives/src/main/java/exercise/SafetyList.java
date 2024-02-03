package exercise;

import java.util.ArrayList;
import java.util.List;

class SafetyList {
    // BEGIN
    private final List<Integer> list = new ArrayList<>();

    public synchronized boolean add(int element) {
        this.list.add(element);
        return true;
    }

    public int get(int index) {
        return this.list.get(index);
    }

    public int getSize() {
        return this.list.size();
    }
    // END
}
