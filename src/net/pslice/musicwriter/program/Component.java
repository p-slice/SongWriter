package net.pslice.musicwriter.program;

import java.util.Random;

public class Component {

    /*
     * ================================================
     * Variables, Objects, Sets, Lists and Maps:
     * ================================================
     */

    // Random used in generation
    private static final Random random = new Random();

    // Possible lengths of components
    private static final int[]
            lengths = {2, 4, 4, 4, 8, 8, 8, 8, 8, 16, 16};

    // Length of the component
    private final int length;





    /*
     * ================================================
     * Initializer:
     * Parameters:
     *      [None]
     * ================================================
     */

    public Component()
    {
        length = lengths[random.nextInt(lengths.length)];
    }





    /*
     * ================================================
     * Getter for the length of the component:
     * ================================================
     */

    public int getLength()
    {
        return length;
    }
}
