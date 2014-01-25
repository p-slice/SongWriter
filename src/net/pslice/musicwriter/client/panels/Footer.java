package net.pslice.musicwriter.client.panels;

import net.pslice.musicwriter.client.Client;
import net.pslice.musicwriter.program.Song;
import net.pslice.musicwriter.program.tracks.Track;
import net.pslice.musicwriter.program.tracks.types.ChordTrack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Footer extends JPanel implements ActionListener {

    /*
     * =============================================
     * Variables, Objects, Sets, Lists and Maps:
     * =============================================
     */

    // The client the panel is assigned to
    private final Client client;

    // Button to begin writing the song
    private final JButton run = new JButton("Write Song");





    /*
     * =============================================
     * Initializer:
     * Parameters:
     *      [Client] client: The client the panel is assigned to
     * =============================================
     */

    public Footer(Client client)
    {
        this.client = client;

        // Main panel setup:
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setBackground(Client.background4);

        // Settings for external components:
        setRunEnabled(false);
        run.addActionListener(this);

        // Add components to main panel:
        this.add(new JLabel(" Version: " + Client.version), BorderLayout.WEST);
        this.add(run, BorderLayout.EAST);
    }





    /*
     * =============================================
     * Method to set the state of the run button:
     * Parameters:
     *      [Boolean] enabled: new state of run button
     * Returns:
     *      [None]
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
     * Implemented action performed listener:
     * Parameters:
     *      [ActionEvent] event: The event that occurred
     * Returns:
     *      [None]
     * Currently incomplete until song-generation process has been finalized.
     * =============================================
     */

    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource().equals(run))
        {
            System.out.println("Preparing to generate song...");
            System.out.println("Song name: " + client.getHeader().getSongName());
            System.out.println("Song key: " + client.getSideBar().getSongKey().toString() + " " + client.getSideBar().getSongScale());
            System.out.println("Song tempo: " + client.getSideBar().getSongTempo());
            System.out.println("Tracks: ");

            for (TrackItem item : client.getContent().getTrackItems())
            {
                System.out.println("Name: " + item.getTrackName());
                System.out.println("  ID: " + item.getID());
                System.out.println("  Instrument: " + item.getTrackInstrument().getName());
                System.out.println("  Type: " + item.getTrackType());
                System.out.println("  Range: " + item.getLowestOctave() + "-" + item.getHighestOctave());
            }

            System.exit(0);
        }
    }
}
