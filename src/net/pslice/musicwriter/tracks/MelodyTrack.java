package net.pslice.musicwriter.tracks;

import net.pslice.musicwriter.Probability;
import net.pslice.musicwriter.Song;
import net.pslice.musicwriter.components.Component;
import net.pslice.musicwriter.scales.MajorScale;
import net.pslice.musicwriter.scales.Scale;

import java.util.ArrayList;

public class MelodyTrack extends Track {

    public MelodyTrack(int instrument) {
        super(instrument, 120, 5);
    }

    public void generate(Component component) {
        Probability<Integer> noteLengths = component.getNoteLengths();

        for (int[] data : component.getData()) {
            Scale scale = new MajorScale(data[0]);
            int totalBeats = data[1];
            int currentBeats = 0;

            while (currentBeats < totalBeats) {
                int length = noteLengths.getResult();
                if (length + currentBeats > totalBeats)
                    length = totalBeats - currentBeats;

                writeNote(scale.getNextNote(), length);
                currentBeats += length;
            }
        }
    }
}
