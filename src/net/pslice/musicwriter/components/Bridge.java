package net.pslice.musicwriter.components;

import net.pslice.musicwriter.Probability;

public class Bridge extends Component {

    public Bridge() {
        MAX = 2;
        CURRENT = 0;
        type = "Bridge";

        totalBars = new Probability<>();
        totalBars.add(2, 2);
        totalBars.add(4, 3);
        totalBars.add(8, 1);

        barLengths = new Probability<>();
        barLengths.add(32, 2);
        barLengths.add(64, 3);

        noteLengths = new Probability<>();
        noteLengths.add(8, 2);
        noteLengths.add(16, 3);
        noteLengths.add(32, 2);
    }
}
