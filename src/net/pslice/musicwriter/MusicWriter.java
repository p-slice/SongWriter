package net.pslice.musicwriter;

import net.pslice.musicwriter.tracks.ChordTrack;
import net.pslice.musicwriter.tracks.MelodyTrack;
import net.pslice.musicwriter.tracks.Track;

public class MusicWriter {

    public static void main(String[] args) {
        Song song = new Song("Song 1");

        Track chordTrack = new ChordTrack(0);
        chordTrack.setName("Chord track");
        song.addTrack(chordTrack);

        Track melodyTrack = new MelodyTrack(0);
        melodyTrack.setName("Melody track");
        song.addTrack(melodyTrack);

        song.generate();
    }
}
