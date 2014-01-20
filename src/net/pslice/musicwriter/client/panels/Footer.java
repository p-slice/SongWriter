package net.pslice.musicwriter.client.panels;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {

    /*
     * =============================================
     * ...
     * =============================================
     */

    public Footer()
    {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));

        JButton run = new JButton("Write Song");
        run.setToolTipText("Begin writing the song");

        add(run, BorderLayout.EAST);
    }
}
