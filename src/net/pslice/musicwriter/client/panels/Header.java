package net.pslice.musicwriter.client.panels;

import net.pslice.musicwriter.client.Client;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {

    /*
     * =============================================
     * Variables, Objects, Sets, Lists and Maps:
     * =============================================
     */

    // The client the panel is assigned to (UNUSED)
    private final Client client;

    // Text field for song name entry
    private final JTextField name = new JTextField("Default");





    /*
     * =============================================
     * Initializer:
     * Parameters:
     *      [Client] client: The client the panel is assigned to
     * =============================================
     */

    public Header(Client client)
    {
        this.client = client;

        // Main panel setup:
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setBackground(Client.background1);

        // Settings for external components:
        name.setMaximumSize(new Dimension(150, name.getMinimumSize().height));

        // Add components to main panel:
        this.add(new JLabel(" Song Name: "));
        this.add(name);
    }





    /*
     * =============================================
     * Getter for the name of the song:
     * =============================================
     */

    public String getSongName()
    {
        return name.getText();
    }
}
