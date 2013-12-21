package net.pslice.musicwriter.tracks;

import net.pslice.musicwriter.Song;
import net.pslice.musicwriter.Writer;
import net.pslice.musicwriter.components.Component;

import java.util.ArrayList;
import java.util.List;

public abstract class Track {

    /*
    ** Variables.
     */
    String name;
    int instrument;
    int octave;
    int velocity;
    int chan;

    /*
    ** Sets and Lists.
     */
    List<int[]> trackData;

    /*
    ** Initializer:
     */
    public Track(int instrument, int velocity, int octave) {
        trackData = new ArrayList<>();

        this.instrument = instrument;
        chan = Song.getCurrentTracks();
        name = "Track " + chan;

        this.velocity = velocity;
        this.octave = octave;

        trackData.add(new int[]{0, 0xC0 + chan, instrument});
    }

    /*
    ** Abstract generation method used in extended track classes.
     */
    public abstract void generate(Component component);

    /*
    ** Setter and getter for track name.
     */
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    /*
    ** Setter and getter for track instrument.
     */
    public void setInstrument(int instrument) {
        this.instrument = instrument;
    }
    public int getInstrument() {
        return instrument;
    }

    /*
    ** Setter and getter for track octave.
     */
    public void setOctave(int octave) {
        this.octave = octave;
    }
    public int getOctave() {
        return octave;
    }

    /*
    ** Setter and getter for track velocity.
     */
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
    public int getVelocity() {
        return velocity;
    }

    /*
    ** Getter for track channel.
     */
    public int getChan() {
        return chan;
    }

    /*
    ** Getter for track data.
     */
    public List<int[]> getData() {
        return trackData;
    }

    /*
    ** Method to write a note to the track.
     */
    void writeNote(int note, int length) {
        note += octave * 12;
        trackData.add(Writer.noteOn(0, note, velocity, chan));
        trackData.add(Writer.noteOff(length, note, chan));
    }

    /*
    ** Method to write a chord to the track.
     */
    void writeChord(int baseNote, int length, int... chordNotes) {
        baseNote += octave * 12;
        trackData.add(Writer.noteOn(0, baseNote, velocity, chan));
        for (int note : chordNotes) {
            note += octave * 12;
            trackData.add(Writer.noteOn(0, note, velocity, chan));
        }

        trackData.add(Writer.noteOff(length, baseNote, chan));
        for (int note : chordNotes)
            trackData.add(Writer.noteOff(0, note, chan));

    }
}
