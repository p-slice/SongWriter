package net.pslice.musicwriter.program.music;

import java.util.HashSet;
import java.util.Set;

public enum Instrument {

    /*
     * ================================================
     * All possible instruments:
     * (Currently incomplete, more to be added soon)
     * ================================================
     */

    Acoustic_Grand_Piano("Acoustic Grand Piano", 0),
    Bright_Piano("Acoustic Bright Piano", 1),
    Electric_Grand_Piano("Electric Grand Piano", 2),
    Honkey_Tonk_Piano("Honkey-tonk Piano", 3),
    Electric_Piano_1("Electric Piano 1", 4),
    Electric_Piano_2("Electric Piano 2", 5),
    Harpsichord("Harpsichord", 6),
    Clavinet("Clavinet", 7),

    Celesta("Celesta", 8),
    Glockenspiel("Glockenspiel", 9),
    Music_Box("Music Box", 10),
    Vibraphone("Vibraphone", 11),
    Marimba("Marimba", 12),
    Xylophone("Xylophone", 13),
    Tubular_Bells("Tubular Bells", 14),
    Dulcimer("Dulcimer", 15),

    Drawbar_Organ("Drawbar Organ", 16),
    Percussive_Organ("Percussive Organ", 17),
    Rock_Organ("Rock Organ", 18),
    Church_Organ("Church Organ", 19),
    Reed_Organ("Reed Organ", 20),
    Accordion("Accordion", 21),
    Harmonica("Harmonica", 22),
    Tango_Accordion("Tango Accordion", 23)
    ;





    /*
     * =============================================
     * Variables, Objects, Sets, Lists and Maps:
     * =============================================
     */

    // The ID used by MIDI to identify the instrument
    private final int ID;

    // The name of the instrument
    private final String name;





    /*
     * =============================================
     * Initializer:
     * Parameters:
     *      [String] name: The name of the instrument
     *      [Integer] ID: The ID used by MIDI to identify the instrument
     * =============================================
     */

    Instrument(String name, int ID)
    {
        this.ID = ID;
        this.name = name;
    }





    /*
     * =============================================
     * Getter for the ID of the instrument:
     * =============================================
     */

    public int getID()
    {
        return ID;
    }





    /*
     * =============================================
     * Getter for the name of the instrument:
     * =============================================
     */

    public String getName()
    {
        return name;
    }
}
