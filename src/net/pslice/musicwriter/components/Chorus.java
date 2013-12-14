package net.pslice.musicwriter.components;

import net.pslice.musicwriter.Probability;

public class Chorus extends Component {

    public Chorus() {
        MAX = 4;
        CURRENT = 0;
        type = "Chorus";

        totalBars = new Probability<>();
        totalBars.add(8, 1);
        totalBars.add(16, 2);

        barLengths = new Probability<>();
        barLengths.add(32, 2);
        barLengths.add(64, 3);

        noteLengths = new Probability<>();
        noteLengths.add(8, 2);
        noteLengths.add(16, 3);
    }
}
