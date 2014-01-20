package net.pslice.musicwriter.client.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Footer extends JPanel implements ActionListener {

    /*
     * =============================================
     * ...
     * =============================================
     */

    private final JButton run = new JButton("Write Song");

    /*
     * =============================================
     * ...
     * =============================================
     */

    public Footer()
    {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));

        setRunEnabled(false);
        run.addActionListener(this);

        add(run, BorderLayout.EAST);
    }

    /*
     * =============================================
     * ...
     * =============================================
     */

    public void setRunEnabled(boolean enabled)
    {
        run.setEnabled(enabled);
        if (run.isEnabled())
            run.setToolTipText("Click to begin the song-writing process!");
        else
            run.setToolTipText("There must be at least one track to create the song!");
    }

    /*
     * =============================================
     * ...
     * =============================================
     */

    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource().equals(run))
        {

        }
    }
}
