package net.pslice.musicwriter.scales;

import net.pslice.musicwriter.Probability;

public abstract class Scale {

    /*
    ** Variables.
     */
    String name;
    int baseNote;

    /*
    ** Special types and variables.
     */
    Probability<Integer> notes;

    /*
    ** Getter for scale name.
     */
    public String getName() {
        return name;
    }

    /*
    ** Getter for base scale note.
     */
    public int getBaseNote() {
        return baseNote;
    }

    /*
    ** Getter for a random/probable note on the scale.
     */
    public int getNextNote() {
        return notes.getResult();
    }
}
