package net.pslice.musicwriter.program;

import java.util.HashSet;
import java.util.Set;

public enum  Instruments {

    Acoustic_Piano("Acoustic Piano", 0),
    Bright_Piano("Acoustic Bright Piano", 1),
    Electric_Piano("Electric Piano", 2)
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

    Instruments(String name, int ID)
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
        for (Instruments instruments : Instruments.values())
            names.add(instruments.getName());
        return names;
    }
}
