package net.pslice.musicwriter.program.music;

public enum Note {

    /*
     * ================================================
     * All possible notes:
     * ================================================
     */

    A(9, "A"),

    A_Sharp(10, "A#"),
    B_Flat(10, "Bb"),

    B(11, "B"),

    C(0, "C"),

    C_Sharp(1, "C#"),
    D_Flat(1, "Db"),

    D(2, "D"),

    D_Sharp(3, "D#"),
    E_Flat(3, "Eb"),

    E(4, "E"),

    F(5, "F"),

    F_Sharp(6, "F#"),
    G_Flat(6, "Gb"),

    G(7, "G"),

    G_Sharp(8, "G#"),
    A_Flat(8, "Ab");





    /*
     * ================================================
     * Variables, Objects, Sets, Lists and Maps:
     * ================================================
     */

    // The ID used by MIDI used to identify a note
    private final int ID;

    // The symbol representing the note
    private final String symbol;





    /*
     * ================================================
     * Initializer:
     * Parameters:
     *      [Integer] ID: The ID used by MIDI to identify a note
     *      [String] symbol: The symbol representing the note
     * ================================================
     */

    Note(int ID, String symbol)
    {
        this.ID = ID;
        this.symbol = symbol;
    }





    /*
     * ================================================
     * Getter for the ID of a note:
     * ================================================
     */

    public int getID()
    {
        return ID;
    }





    /*
     * ================================================
     * Getter for the symbol of a note:
     * ================================================
     */

    public String getSymbol()
    {
        return symbol;
    }
}
