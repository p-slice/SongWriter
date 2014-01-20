package net.pslice.musicwriter.client.panels;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {

    /*
     * =============================================
     * ...
     * =============================================
     */

    private final JTextField name = new JTextField("Default");

    /*
     * =============================================
     * ...
     * =============================================
     */

    public Header()
    {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.black));

        add(new JLabel(" Song Name: "));

        name.setMaximumSize(new Dimension(150, name.getMinimumSize().height));

        add(name);
    }

    /*
     * =============================================
     * ...
     * =============================================
     */

    public String getSongName()
    {
        return name.getText();
    }
}
