package net.pslice.musicwriter.components;

import net.pslice.musicwriter.Probability;

public class Intro extends Component {

    public Intro() {
        MAX = 1;
        CURRENT = 0;
        type = "Intro";

        totalBars = new Probability<>();
        totalBars.add(2, 2);
        totalBars.add(4, 2);
        totalBars.add(8, 1);

        barLengths = new Probability<>();
        barLengths.add(32, 1);
        barLengths.add(64, 2);

        noteLengths = new Probability<>();
        noteLengths.add(8, 2);
        noteLengths.add(16, 3);
        noteLengths.add(32, 1);
    }
}
