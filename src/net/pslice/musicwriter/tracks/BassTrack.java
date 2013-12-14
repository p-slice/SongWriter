package net.pslice.musicwriter.tracks;

import net.pslice.musicwriter.Probability;
import net.pslice.musicwriter.Song;
import net.pslice.musicwriter.components.Component;
import net.pslice.musicwriter.scales.MajorScale;
import net.pslice.musicwriter.scales.Scale;

import java.util.ArrayList;

public class BassTrack extends Track {

    public BassTrack(int instrument) {
        trackData = new ArrayList<>();

        this.instrument = instrument;
        chan = Song.getCurrentTracks();
        name = "Track " + chan;
        velocity = 100;
        octave = 3;

        trackData.add(new int[]{0, 0xC0 + chan, instrument});
    }

    public void generate(Component component) {
        Probability<Integer> noteLengths = new Probability<>();
        noteLengths.add(8, 2);
        noteLengths.add(16, 5);

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
