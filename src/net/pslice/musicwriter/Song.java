package net.pslice.musicwriter;

import net.pslice.musicwriter.components.*;
import net.pslice.musicwriter.scales.MajorScale;
import net.pslice.musicwriter.scales.Scale;
import net.pslice.musicwriter.tracks.Track;

import java.io.IOException;
import java.util.*;

public class Song {

    /*
    ** Variables.
     */
    private String name;
    private int key;
    private int tempo;
    private static int currentTracks;
    private static boolean verbosity;

    /*
    ** Special types and variables.
     */
    private static Scale scale;
    private Probability<Component> componentProbability;

    /*
    ** Sets and lists.
     */
    private Set<Track> trackSet;

    /*
    ** Initializers.
     */
    public Song() {
        new Song("Default");
    }

    public Song(String name) {
        trackSet = new LinkedHashSet<>();

        componentProbability = new Probability<>();
        componentProbability.add(new Verse(), 7);
        componentProbability.add(new Chorus(), 6);
        componentProbability.add(new Outro(), 2);

        this.name = name;
        key = 0;
        tempo = 120;
        currentTracks = 0;
        verbosity = true;

        scale = new MajorScale(key);
    }

    /*
    ** Setter and getter for song name.
     */
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    /*
    ** Setter and getter for song key.
     */
    public void setKey(int key) {
        this.key = key;
    }
    public int getKey() {
        return key;
    }

    /*
    ** Setter and getter for song tempo.
     */
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    public int getTempo() {
        return tempo;
    }

    /*
    ** Getter for current number of tracks.
     */
    public static int getCurrentTracks() {
        return currentTracks;
    }

    /*
    ** Setter and getter for song verbosity.
     */
    public static void setVerbosity(boolean verbosity) {
        Song.verbosity = verbosity;
    }
    public static boolean isVerbose() {
        return verbosity;
    }

    /*
    ** Setter and getter for song scale.
     */
    public static void setScale(Scale scale) {
      Song.scale = scale;
    }
    public static Scale getScale() {
        return scale;
    }

    /*
    ** Add and remove a track from the song.
     */
    public void addTrack(Track track) {
        if (!trackSet.contains(track)) {
            trackSet.add(track);
            currentTracks++;
        }
    }
    public void removeTrack(Track track) {
        if (trackSet.contains(track)) {
            trackSet.remove(track);
            currentTracks--;
        }
    }

    /*
    ** Add or remove a component from the song.
     */
    public void addComponent(Component component, int probability) {
        componentProbability.add(component, probability);
    }
    public void removeComponent(Component component) {
        componentProbability.remove(component);
    }

    /*
    ** Method to generate the song.
    ** Should be the last thing to run.
     */
    public void generate() {
        FileWriter.setKeyData(key);
        FileWriter.setTempoData(tempo);
        FileWriter.setTimeSignatureData();

        List<Component> componentList = new ArrayList<>();

        Component intro = new Intro();
        componentList.add(intro);
        intro.generateChords();

        if (verbosity) {
            System.out.println("Added new component: Intro");
            System.out.println("Bars: " + intro.getBars());
            System.out.println("==================================");
        }

        boolean addedOutro = false;
        while (!addedOutro) {
            Component component = componentProbability.getResult();
            if (component.CURRENT < component.MAX) {
                componentList.add(component);
                component.generateChords();
                component.CURRENT++;

                if (verbosity) {
                    System.out.println("Added new component: " + component.getType());
                    System.out.println("Bars: " + component.getBars());
                    System.out.println("==================================");
                }

                if (component.getType().equals("Outro"))
                    addedOutro = true;
            }
        }

        for (Track track : trackSet) {
            if (verbosity) {
                System.out.println("Now generating track: " + track.getName());
                System.out.println("Track instrument: " + track.getInstrument());
                System.out.println("Track octave: " + track.getOctave());
                System.out.println("Track velocity: " + track.getVelocity());
                System.out.println("Track channel: " + track.getChan());
                System.out.println("==================================");
            }
            for (Component component: componentList)
                track.generate(component);
        }

        try {
            FileWriter.write(trackSet, name + ".mid");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
