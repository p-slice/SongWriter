package net.pslice.musicwriter.client.panels;

import javax.swing.*;
import java.awt.*;

public class SideBar extends JPanel {

    /*
     * =============================================
     * ...
     * =============================================
     */

    private static final String[] keys = {
            "A", "A#/Bb", "B", "C", "C#/Db",
            "D", "D#/Eb", "E", "F", "F#/Gb",
            "G", "G#/Ab"
    };

    /*
     * =============================================
     * ...
     * =============================================
     */

    public SideBar()
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel options = new JLabel("Song Options: ");
        options.setMaximumSize(new Dimension(Integer.MAX_VALUE, options.getMinimumSize().height));
        add(options);

        JPanel key = new JPanel(new BorderLayout());
        key.add(new JLabel(" Key: "), BorderLayout.WEST);

        JComboBox<String> keyOptions = new JComboBox<>(keys);

        key.add(keyOptions, BorderLayout.CENTER);
        key.setMaximumSize(new Dimension(Integer.MAX_VALUE, key.getMinimumSize().height));

        add(key);
    }
}
