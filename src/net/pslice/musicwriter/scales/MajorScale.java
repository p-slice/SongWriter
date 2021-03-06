package net.pslice.musicwriter.scales;

import net.pslice.musicwriter.Probability;

public class MajorScale extends Scale {

    public MajorScale(int baseNote) {
        name = "Major scale";
        this.baseNote = baseNote;

        notes = new Probability<>();
        notes.add(baseNote, 8);
        notes.add(baseNote + 2, 5);
        notes.add(baseNote + 4, 2);
        notes.add(baseNote + 5, 4);
        notes.add(baseNote + 7, 7);
        notes.add(baseNote + 9, 2);
        notes.add(baseNote + 11, 1);
        notes.add(baseNote + 12, 4);
    }
}
