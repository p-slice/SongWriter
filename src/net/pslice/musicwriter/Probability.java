package net.pslice.musicwriter;

import java.util.*;

public class Probability<P> {

    /*
    ** Storage for probability data, plus a random.
     */
    private final HashMap<P, Integer> probabilitySet;
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
    public void add(P item, int probability) {
        probabilitySet.put(item, probability);
    }

    /*
    ** Method to remove an item from the probability.
     */
    public void remove(P item) {
        if (probabilitySet.containsKey(item))
            probabilitySet.remove(item);
    }

    /*
    ** Method to get a random probability result.
     */
    public P getResult() {
        List<P> typeList = new ArrayList<>();
        for (P type: probabilitySet.keySet()) {
            int added = 0;
            while (added < probabilitySet.get(type)) {
                typeList.add(type);
                added++;
            }
        }
        return typeList.get(random.nextInt(typeList.size()));
    }
}
