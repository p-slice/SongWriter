package net.pslice.musicwriter.program.music.chords;

public enum ChordType {

    /*
     * ================================================
     * All possible chord types:
     * (Currently incomplete, more to be added soon)
     * ================================================
     */

    Major(0, 4, 7, 12),
    Minor(0, 3, 7, 12),
    Power(0, 7, 12);





    /*
     * ================================================
     * Variables, Objects, Sets, Lists and Maps:
     * ================================================
     */

    // The notes in the chord
    private int[] notes;





    /*
     * ================================================
     * Initializer:
     * Parameters:
     *      [Integer...] notes: The notes in the chord
     * ================================================
     */

    ChordType(int... notes)
    {
        this.notes = notes;
    }





    /*
     * ================================================
     * Getter for the notes in the chord:
     * ================================================
     */

    public int[] getNotes()
    {
        return notes;
    }
}
