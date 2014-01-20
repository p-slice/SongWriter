package net.pslice.musicwriter.client.panels;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {

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

        JTextField name = new JTextField("Default");
        name.setMaximumSize(new Dimension(150, name.getMinimumSize().height));

        add(name);
    }
}
