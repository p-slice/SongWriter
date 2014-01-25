package net.pslice.musicwriter.program.tracks.types;

import net.pslice.musicwriter.program.music.Instrument;
import net.pslice.musicwriter.program.tracks.Track;

public class DrumTrack extends Track {

    /*
     * ================================================
     * Initializer:
     * See main track class for details
     * ================================================
     */

    public DrumTrack(String name, Instrument instrument, int channel, int velocity, int lowestOctave, int highestOctave)
    {
        super(name, instrument, channel, velocity, lowestOctave, highestOctave);
    }





    /*
     * ================================================
     * Implemented generation method:
     * Parameters:
     *      [None]
     * Returns:
     *      [None]
     * Currently incomplete until song-generation process has been finalized
     * ================================================
     */

    public void generate()
    {

    }
}
