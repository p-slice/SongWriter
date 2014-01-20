package net.pslice.musicwriter.client.panels;

import net.pslice.musicwriter.client.Client;
import net.pslice.musicwriter.program.Instrument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class Content extends JPanel implements ActionListener {

    /*
     * =============================================
     * ...
     * =============================================
     */

    private final JLabel trackName = new JLabel(" Current Tracks: 0");

    private final JTabbedPane trackTabs = new JTabbedPane();
    private final JButton addButton = new JButton("Add Track");

    private final Set<Integer> tracks = new HashSet<>();

    /*
     * =============================================
     * ...
     * =============================================
     */

    public Content()
    {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.blue));
        setBackground(Color.white);

        JPanel upperPanel = new JPanel(new BorderLayout());
        upperPanel.setBorder(BorderFactory.createLineBorder(Color.blue));

        upperPanel.add(trackName, BorderLayout.WEST);

        addButton.addActionListener(this);
        addButton.setActionCommand("Add");

        upperPanel.add(addButton, BorderLayout.EAST);

        add(upperPanel, BorderLayout.NORTH);

        trackTabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        add(trackTabs, BorderLayout.CENTER);
    }

    /*
     * =============================================
     * ...
     * =============================================
     */

    public void actionPerformed(ActionEvent event)
    {
        if (event.getActionCommand().equals("Add"))
        {
            if (tracks.size() < 16)
            {
                JPanel trackPanel = new JPanel(new BorderLayout());

                int i;
                for (i = 1; i < 17; i++)
                    if (!tracks.contains(i))
                    {
                        tracks.add(i);
                        break;
                    }

                JPanel trackPanelTop = new JPanel();
                trackPanelTop.setLayout(new BoxLayout(trackPanelTop, BoxLayout.LINE_AXIS));
                trackPanelTop.add(new JLabel(" Track Name: "));
                JTextField nameField = new JTextField("Track " + i);
                nameField.setMaximumSize(new Dimension(100, nameField.getMinimumSize().height));

                trackPanelTop.add(nameField);

                trackPanelTop.add(new JLabel(" Instrument: "));
                JComboBox<Instrument> instrumentOptions = new JComboBox<>(Instrument.values());
                instrumentOptions.setMaximumSize(new Dimension(150, instrumentOptions.getMinimumSize().height));

                trackPanelTop.add(instrumentOptions);

                trackPanel.add(trackPanelTop, BorderLayout.NORTH);
                trackPanel.add(new JTextArea(), BorderLayout.CENTER);



                JPanel trackPanelBottom = new JPanel(new BorderLayout());
                JButton remove = new JButton("Delete Track");
                remove.addActionListener(this);
                remove.setActionCommand("Remove " + i);

                trackPanelBottom.add(remove, BorderLayout.EAST);
                trackPanel.add(trackPanelBottom, BorderLayout.SOUTH);

                trackName.setText(" Current Tracks: " + tracks.size());
                trackTabs.addTab("Track " + i, trackPanel);

                if (tracks.size() == 16)
                    addButton.setEnabled(false);
                Client.getClient().getFooter().setRunEnabled(true);
            }
        }
        if (event.getActionCommand().startsWith("Remove"))
        {
            int i = Integer.parseInt(event.getActionCommand().split(" ")[1]);

            trackTabs.remove(trackTabs.indexOfTab("Track " + i));
            tracks.remove(i);
            trackName.setText(" Current Tracks: " + tracks.size());
            addButton.setEnabled(true);
            if (tracks.size() == 0)
                Client.getClient().getFooter().setRunEnabled(false);
        }
    }
}
