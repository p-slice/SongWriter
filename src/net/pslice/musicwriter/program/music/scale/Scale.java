package net.pslice.musicwriter.program.music.scale;

public enum  Scale {

    /*
     * ================================================
     * All possible scales:
     * (Currently incomplete, more to be added soon)
     * ================================================
     */

    Major(0, 2, 4, 5, 7, 9, 11),
    Minor(0, 2, 3, 5, 7, 8, 10);





    /*
     * ================================================
     * Variables, Objects, Sets, Lists and Maps:
     * ================================================
     */

    // All the notes in the scale
    private int[] notes;





    /*
     * ================================================
     * Initializer:
     * Parameters:
     *      [Integer...] notes: All the notes in the scale
     * ================================================
     */

    Scale(int... notes)
    {
        this.notes = notes;
    }





    /*
     * ================================================
     * Getter for all the notes in the scale:
     * ================================================
     */

    public int[] getNotes()
    {
        return notes;
    }
}
