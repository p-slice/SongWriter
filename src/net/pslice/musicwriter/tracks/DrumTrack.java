package net.pslice.musicwriter.tracks;

import net.pslice.musicwriter.components.Component;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DrumTrack extends Track {

    /*
    ** Variables.
     */
    int beatsPerBar;
    int cymbal;

    boolean writeFills;

    public static enum Cymbal {HiHat, Crash1, Crash2, Ride, RideBell, Splash, Cowbell}

    /*
    ** Sets and lists.
     */
    Set<Integer> snareHitBeats;
    Set<Integer> bassHitBeats;

    /*
    ** Initializer.
     */
    public DrumTrack() {
        super(0, 120, 0);
        chan = 9;

        snareHitBeats = new LinkedHashSet<>();
        bassHitBeats = new LinkedHashSet<>();

        beatsPerBar = 8;
        setSnareHitBeats(3, 7);
        setBassHitBeats(1, 3, 5, 7);

        setCymbal(Cymbal.HiHat);

        writeFills = true;
    }

    /*
    ** Setter and getter for beats per bar.
     */
    public void setBeatsPerBar(int beats) {
        beatsPerBar = beats;
    }
    public int getBeatsPerBar() {
        return beatsPerBar;
    }

    /*
    ** Setter and getter for cymbal type.
     */
    public void setCymbal(Cymbal cymbal) {
        switch (cymbal) {
            case HiHat:
                this.cymbal = 42;
                break;
            case Crash1:
                this.cymbal = 49;
                break;
            case Crash2:
                this.cymbal = 57;
                break;
            case Ride:
                this.cymbal = 51;
                break;
            case RideBell:
                this.cymbal = 53;
                break;
            case Splash:
                this.cymbal = 55;
                break;
            case Cowbell:
                this.cymbal = 56;
                break;
            default:
                break;
        }
    }

    /*
    ** Setter and getter for snare hit beats.
     */
    public void setSnareHitBeats(int... beats) {
        snareHitBeats.clear();
        for (int beat : beats)
            snareHitBeats.add(beat);
    }
    public Set<Integer> getSnareHitBeats() {
        return snareHitBeats;
    }

    /*
    ** Setter and getter for bass hit beats.
     */
    public void setBassHitBeats(int... beats) {
        bassHitBeats.clear();
        for (int beat : beats)
            bassHitBeats.add(beat);
    }
    public Set<Integer> getBassHitBeats() {
        return bassHitBeats;
    }

    /*
    ** Method to generate the track parts.
     */
    public void generate(Component component) {
        for (int b = 0; b < component.getBars(); b++) {
            //if (writeFills
            //&& b + 1 == component.getBars()) {
                /*
                ** Code to write fills will go in here.
                 */
            //} else {
            for (int a = 0; a < beatsPerBar; a++) {
                List<Integer> soundList = new ArrayList<>();
                if (snareHitBeats.contains(a))
                    soundList.add(38);
                if (bassHitBeats.contains(a))
                    soundList.add(36);
                int[] sounds = new int[soundList.size()];
                for (int i = 0; i < sounds.length; i++)
                    sounds[i] =  soundList.get(i);
                writeChord(cymbal, 64 / beatsPerBar, sounds);
            }
            //}
        }
    }
}
