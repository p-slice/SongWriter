package net.pslice.musicwriter;

import net.pslice.musicwriter.components.Solo;
import net.pslice.musicwriter.tracks.*;

public class MusicWriter {

    public static void main(String[] args) {

        /*
        ** The following is an example of how to generate a song.
        ** The order you add the tracks is the order they will appear in the file itself.
        ** Songs can be created either with or without a title - it will be named "Default" if you don't.
        **
        ** The number used in Track creation is the instrument.
        ** See http://en.wikipedia.org/wiki/General_MIDI for what instrument corresponds to what number.
        **
        ** The code for this music writer originally comes from a program by Kevin Boone
        ** (See http://kevinboone.net/javamidi.html)
         */
        Song song = new Song("Song 1");

        ChordTrack chordTrack = new ChordTrack(0);
        chordTrack.setName("Chord track");
        chordTrack.setOctave(4);
        song.addTrack(chordTrack);

        MelodyTrack melodyTrack = new MelodyTrack(17);
        melodyTrack.setName("Melody track");
        melodyTrack.setVelocity(90);
        song.addTrack(melodyTrack);

        song.addComponent(new Solo(), 4);

        BassTrack bassTrack = new BassTrack(32);
        bassTrack.setName("Bass track");
        song.addTrack(bassTrack);

        DrumTrack drumTrack = new DrumTrack();
        drumTrack.setName("Drum track");
        drumTrack.setCymbal(DrumTrack.Cymbal.HiHat);

        song.generate();
    }
}
