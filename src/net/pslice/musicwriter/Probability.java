package net.pslice.musicwriter;

import java.util.*;

public class Probability<T> {

    /*
    ** Storage for probability data, plus a random.
     */
    private final HashMap<T, Integer> probabilitySet;
    private final Random random = new Random();

    /*
    ** Initializer.
     */
    public Probability() {
        probabilitySet = new HashMap<>();
    }

    /*
    ** Method to add an item to the probability.
     */
    public void add(T type, int probability) {
        probabilitySet.put(type, probability);
    }

    /*
    ** Method to remove an item from the probability.
     */
    public void remove(T type) {
        if (probabilitySet.containsKey(type))
            probabilitySet.remove(type);
    }

    /*
    ** Method to get a random probability result.
     */
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
