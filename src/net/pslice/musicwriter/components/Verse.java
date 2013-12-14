package net.pslice.musicwriter.components;

import net.pslice.musicwriter.Probability;

public class Verse extends Component {

    public Verse() {
        MAX = 3;
        CURRENT = 0;
        type = "Verse";

        totalBars = new Probability<>();
        totalBars.add(8, 2);
        totalBars.add(16, 1);

        barLengths = new Probability<>();
        barLengths.add(32, 1);
        barLengths.add(64, 2);

        noteLengths = new Probability<>();
        noteLengths.add(8, 2);
        noteLengths.add(16, 3);
        noteLengths.add(32, 1);
    }
}
