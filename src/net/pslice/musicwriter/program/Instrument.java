package net.pslice.musicwriter.program;

import java.util.HashSet;
import java.util.Set;

public enum Instrument {

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
     * ...
     * =============================================
     */

    private final int ID;
    private final String name;

    /*
     * =============================================
     * ...
     * =============================================
     */

    Instrument(String name, int ID)
    {
        this.ID = ID;
        this.name = name;
    }

    /*
     * =============================================
     * ...
     * =============================================
     */

    public int getID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
    }

    /*
     * =============================================
     * ...
     * =============================================
     */

    public static Set<String> getInstrumentNames()
    {
        Set<String> names = new HashSet<>();
        for (Instrument instrument : Instrument.values())
            names.add(instrument.getName());
        return names;
    }
}
