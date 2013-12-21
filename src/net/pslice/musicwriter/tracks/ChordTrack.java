package net.pslice.musicwriter.tracks;

import net.pslice.musicwriter.Song;
import net.pslice.musicwriter.components.Component;

import java.util.ArrayList;

public class ChordTrack extends Track {

    public ChordTrack(int instrument) {
        super(instrument, 120, 5);
    }

    public void generate(Component component) {
        for (int[] data : component.getData()) {
            int[] chord = new int[] {
                    data[0] + 7,
                    data[0] + 12
            };
            writeChord(data[0], data[1], chord);
        }
    }
}
