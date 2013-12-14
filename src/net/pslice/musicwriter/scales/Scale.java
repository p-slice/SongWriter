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
    Probability<Integer> note;

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

    public int getNextNote() {
        return note.getResult();
    }
}
