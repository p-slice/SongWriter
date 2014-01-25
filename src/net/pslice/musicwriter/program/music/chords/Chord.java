package net.pslice.musicwriter.program.music.chords;

import net.pslice.musicwriter.program.music.Note;

public class Chord {

    /*
     * ================================================
     * Variables, Objects, Sets, Lists and Maps:
     * ================================================
     */

    // The duration of the chord
    private int duration;

    // The base note of the chord
    private Note baseNote;

    // The type of chord
    private ChordType chordType;





    /*
     * ================================================
     * Initializer:
     * Parameters:
     *      [Note] baseNote: The base note of the chord
     *      [Integer] duration: The duration of the chord
     *      [ChordType] chordType: The type of chord
     * ================================================
     */

    public Chord(Note baseNote, int duration, ChordType chordType)
    {
        this.baseNote = baseNote;
        this.duration = duration;
        this.chordType = chordType;
    }





    /*
     * ================================================
     * Getter for the duration of the chord:
     * ================================================
     */

    public int getDuration()
    {
        return duration;
    }





    /*
     * ================================================
     * Getter for the base note of the chord:
     * ================================================
     */

    public Note getBaseNote()
    {
        return baseNote;
    }





    /*
     * ================================================
     * Getter for the type of the chord:
     * ================================================
     */

    public ChordType getChordType()
    {
        return chordType;
    }
}
