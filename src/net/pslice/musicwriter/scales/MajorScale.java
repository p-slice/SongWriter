package net.pslice.musicwriter.scales;

import net.pslice.musicwriter.Probability;

public class MajorScale extends Scale {

    public MajorScale(int baseNote) {
        name = "Major scale";
        this.baseNote = baseNote;

        note = new Probability<>();
        note.add(baseNote, 8);
        note.add(baseNote + 2, 5);
        note.add(baseNote + 4, 2);
        note.add(baseNote + 5, 4);
        note.add(baseNote + 7, 7);
        note.add(baseNote + 9, 2);
        note.add(baseNote + 11, 1);
        note.add(baseNote + 12, 4);
    }
}
