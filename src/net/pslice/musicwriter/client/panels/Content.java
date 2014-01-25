package net.pslice.musicwriter.client.panels;

import net.pslice.musicwriter.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Content extends JPanel implements ActionListener {

    /*
     * =============================================
     * Variables, Objects, Sets, Lists and Maps:
     * =============================================
     */

    // The client the panel is assigned to
    private final Client client;

    // Label of all current tracks
    private final JLabel currentTracks = new JLabel(" Current Tracks: 0");
    // Tab pane containing track setup
    private final JTabbedPane trackTabs = new JTabbedPane();
    // Button to add a new track
    private final JButton addButton = new JButton("Add Track");

    // Map of all track items:
    private final Map<Integer, TrackItem> trackItems = new HashMap<>();





    /*
     * =============================================
     * Initializer:
     * Parameters:
     *      [Client] client: The client the panel is assigned to
     * =============================================
     */

    public Content(Client client)
    {
        this.client = client;

        // Main panel setup:
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Client.border));
        this.setBackground(Client.background5);

        // Settings for external components:
        addButton.addActionListener(this);
        addButton.setActionCommand("Add");

        trackTabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        trackTabs.setBackground(Client.tab);

        // Initializers for local panels:
        JPanel upperPanel = new JPanel(new BorderLayout());

        // Settings for local panels:
        upperPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        upperPanel.setBackground(Client.background3);

        // Add external components to local panels:
        upperPanel.add(currentTracks, BorderLayout.WEST);
        upperPanel.add(addButton, BorderLayout.EAST);

        // Add local panels and external panels to main panel:
        this.add(upperPanel, BorderLayout.NORTH);
        this.add(trackTabs, BorderLayout.CENTER);
    }





    /*
     * =============================================
     * Implemented action performed listener:
     * Parameters:
     *      [ActionEvent] event: The event that occurred
     * Returns:
     *      [None]
     * =============================================
     */

    public void actionPerformed(ActionEvent event)
    {
        if (event.getActionCommand().equals("Add"))
            if (trackItems.size() < 16)
                for (int ID = 1; ID < 17; ID++)
                    if (!trackItems.containsKey(ID))
                    {
                        TrackItem item = new TrackItem(client, ID);
                        trackItems.put(ID, item);

                        currentTracks.setText(" Current Tracks: " + trackItems.size());
                        trackTabs.addTab("Track " + ID, item);

                        if (trackItems.size() == 16)
                            addButton.setEnabled(false);
                        client.getFooter().setRunEnabled(true);

                        break;
                    }

        if (event.getActionCommand().startsWith("Remove"))
        {
            int ID = Integer.parseInt(event.getActionCommand().split(" ")[1]);

            trackTabs.remove(trackTabs.indexOfTab("Track " + ID));

            if (trackItems.containsKey(ID))
                trackItems.remove(ID);

            currentTracks.setText(" Current Tracks: " + trackItems.size());
            addButton.setEnabled(true);
            if (trackItems.size() == 0)
               client.getFooter().setRunEnabled(false);
        }
    }





    /*
     * ================================================
     * Getter for the set of all track items:
     * ================================================
     */

    public Set<TrackItem> getTrackItems()
    {
        Set<TrackItem> items = new LinkedHashSet<>();
        for (int i : trackItems.keySet())
            items.add(trackItems.get(i));
        return items;
    }
}
