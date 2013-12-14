package net.pslice.musicwriter;

import java.util.*;

public class Probability<T> {

    private final HashMap<T, Integer> probabilitySet;
    private final Random random = new Random();

    public Probability() {
        probabilitySet = new HashMap<>();
    }

    public void add(T type, int probability) {
        probabilitySet.put(type, probability);
    }

    public void remove(T type) {
        if (probabilitySet.containsKey(type))
            probabilitySet.remove(type);
    }

    public T getResult() {
        List<T> typeList = new ArrayList<>();
        for (T type: probabilitySet.keySet()) {
            int added = 0;
            while (added < probabilitySet.get(type)) {
                typeList.add(type);
                added++;
            }
        }
        return typeList.get(random.nextInt(typeList.size()));
    }
}
