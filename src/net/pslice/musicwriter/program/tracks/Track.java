package net.pslice.musicwriter.program.tracks;

import net.pslice.musicwriter.program.music.Instrument;

import java.util.ArrayList;
import java.util.List;

public abstract class Track {

    /*
     * ================================================
     * Variables, Objects, Sets, Lists and Maps:
     * ================================================
     */

    // The name of the track
    final String name;

    // The track instrument
    final Instrument instrument;

    // The channel, velocity, lowest octave and highest octave of the track
    final int
            channel,
            velocity,

            lowestOctave,
            highestOctave;

    // All data saved from track generation in int[] format
    final List<int[]> data;





    /*
     * ================================================
     * Initializer:
     * Parameters:
     *      [String] name: The name of the track
     *      [Instrument] instrument: The track instrument
     *      [Integer] channel: The track channel:
     *      [Integer] velocity: The velocity of the track
     *      [Integer] lowestOctave: The lowest octave of the track
     *      [Integer] highestOctave: The highest octave of the track
     * ================================================
     */

    public Track(String name, Instrument instrument, int channel, int velocity, int lowestOctave, int highestOctave)
    {
        this.name = name;
        this.instrument = instrument;
        this.channel = channel;
        this.velocity = velocity;
        this.lowestOctave = lowestOctave;
        this.highestOctave = highestOctave;

        data = new ArrayList<>();
    }





    /*
     * ================================================
     * Abstract method to generate track data:
     * See individual track classes for usage
     * ================================================
     */

    public abstract void generate();





    /*
     * ================================================
     * Getter for the name of the track:
     * ================================================
     */

    public String getName()
    {
        return name;
    }





    /*
     * ================================================
     * Getter for the track instrument:
     * ================================================
     */

    public Instrument getInstrument()
    {
        return instrument;
    }





    /*
     * ================================================
     * Getter for the track channel:
     * ================================================
     */

    public int getChannel()
    {
        return channel;
    }





    /*
     * ================================================
     * Getter for the velocity of the track:
     * ================================================
     */

    public int getVelocity()
    {
        return velocity;
    }





    /*
     * ================================================
     * Getter for the lowest octave of the track:
     * ================================================
     */

    public int getLowestOctave()
    {
        return lowestOctave;
    }





    /*
     * ================================================
     * Getter for the highest octave of the track:
     * ================================================
     */

    public int getHighestOctave()
    {
        return highestOctave;
    }




    /*
     * ================================================
     * Getter for all of the track data:
     * ================================================
     */

    public List<int[]> getData()
    {
        return data;
    }
}
