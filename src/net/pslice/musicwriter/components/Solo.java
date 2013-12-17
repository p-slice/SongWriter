package net.pslice.musicwriter.components;

import net.pslice.musicwriter.Probability;

public class Solo extends Component {

    public Solo() {
        MAX = 1;
        CURRENT = 0;
        type = "Solo";

        totalBars = new Probability<>();
        totalBars.add(8, 3);
        totalBars.add(16, 1);

        barLengths = new Probability<>();
        barLengths.add(32, 1);
        barLengths.add(64, 4);

        noteLengths = new Probability<>();
        noteLengths.add(4, 1);
        noteLengths.add(8, 3);
        noteLengths.add(16, 4);
    }
}
