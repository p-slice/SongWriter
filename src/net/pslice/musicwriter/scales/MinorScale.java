package net.pslice.musicwriter.scales;

import net.pslice.musicwriter.Probability;

public class MinorScale extends Scale {

    public MinorScale(int baseNote) {
        name = "Minor scale";
        this.baseNote = baseNote;

        notes = new Probability<>();
        notes.add(baseNote, 8);
        notes.add(baseNote + 2, 5);
        notes.add(baseNote + 3, 2);
        notes.add(baseNote + 5, 4);
        notes.add(baseNote + 7, 7);
        notes.add(baseNote + 8, 2);
        notes.add(baseNote + 10, 1);
        notes.add(baseNote + 12, 4);
    }
}
