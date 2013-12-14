package net.pslice.musicwriter.components;

import net.pslice.musicwriter.Probability;
import net.pslice.musicwriter.Song;
import net.pslice.musicwriter.scales.Scale;

import java.util.ArrayList;
import java.util.List;

public abstract class Component {

    /*
    ** Publicly accessible variables.
     */
    public int MAX;
    public int CURRENT;

    /*
    ** Variables.
     */
    String type;
    private int bars;

    /*
    ** Special types and variables.
     */
    Probability<Integer> totalBars;
    Probability<Integer> barLengths;
    Probability<Integer> noteLengths;

    /*
    ** Sets and Lists.
     */
    private List<int[]> componentData;

    /*
    ** Getter for component type.
     */
    public String getType() {
        return type;
    }

    /*
    ** Getter for component data.
     */
    public List<int[]> getData() {
        return componentData;
    }

    /*
    ** Getter for component note lengths.
     */
    public Probability<Integer> getNoteLengths() {
        return noteLengths;
    }

    /*
    ** Method to generate the chords and chord lengths for the component.
     */
    public void generateChords() {
        componentData = new ArrayList<>();
        bars = totalBars.getResult();
        Scale scale = Song.getScale();

        int totalBeats = bars * 64;

        int[] firstData = new int[2];
        firstData[0] = scale.getBaseNote();
        firstData[1] = barLengths.getResult();

        componentData.add(firstData);

        int currentBeats = firstData[1];

        while (currentBeats < totalBeats) {
            int length = barLengths.getResult();
            if (currentBeats + length > totalBeats)
                length = totalBeats - currentBeats;

            int[] data = new int[2];
            data[0] = scale.getNextNote();
            data[1] = length;

            componentData.add(data);

            currentBeats += data[1];
        }
    }

}
