package net.pslice.musicwriter.client.panels;

import net.pslice.musicwriter.client.Client;
import net.pslice.musicwriter.program.music.Instrument;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Enumeration;

public class TrackItem extends JPanel implements ChangeListener {

    /*
     * ================================================
     * Variables, Objects, Sets, Lists and Maps:
     * ================================================
     */

    // The client the panel is assigned to (UNUSED)
    private final Client client;
    // The identification number of the track item
    private final int ID;

    // Array of possible octave multipliers
    private static final Integer[] octaves = {1, 2, 3, 4, 5, 6, 7, 8};

    // Text field for the name of the track
    private final JTextField trackName;
    // ComboBox of all possible instruments
    private final JComboBox<Instrument> instrumentOptions = new JComboBox<>(Instrument.values());
    // ComboBoxes of all possible octaves for both low and high settings
    private final JComboBox<Integer>
            lowOctaveOptions = new JComboBox<>(octaves),
            highOctaveOptions = new JComboBox<>(octaves);
    // Label of the current track velocity
    private final JLabel velocityLabel = new JLabel(" Velocity: 100");
    // Slider to set the track velocity
    private final JSlider velocitySlider = new JSlider(JSlider.VERTICAL, 1, 127, 100);
    // Button group of all possible track types:
    private final ButtonGroup trackTypes = new ButtonGroup();





    /*
     * ================================================
     * Initializer:
     * Parameters:
     *      [Client] client: The client the panel is assigned to
     *      [Integer] ID: The ID to be used by the track
     * ================================================
     */

    public TrackItem(Client client, int ID)
    {
        this.client = client;
        this.ID = ID;

        // Main panel setup:
        setLayout(new BorderLayout());

        // Initializers for local panels:
        JPanel trackPanelTop = new JPanel();
        JPanel trackPanelCenter = new JPanel(new GridLayout(1, 4));
        JPanel trackPanelBottom = new JPanel(new BorderLayout());

        JPanel velocity = new JPanel(new BorderLayout());

        JPanel octave = new JPanel();
        JPanel octaveSetting = new JPanel(new BorderLayout());
        JPanel lowestOctave = new JPanel(new BorderLayout());
        JPanel highestOctave = new JPanel(new BorderLayout());

        JPanel types = new JPanel(new BorderLayout());
        JPanel typesOptions = new JPanel();

        JPanel space = new JPanel();
        JPanel emptyPanel = new JPanel(); // This might be used for more settings later, if needed

        // Initializers for local and external components:
        trackName = new JTextField("Track " + ID);

        JRadioButton chord = new JRadioButton("Chords");
        JRadioButton melody = new JRadioButton("Melody");
        JRadioButton bass = new JRadioButton("Bass");
        JRadioButton backgrounds = new JRadioButton("Backgrounds");
        JRadioButton drums = new JRadioButton("Drums");

        JButton remove = new JButton("Delete Track");

        // Layout settings for local panels:
        trackPanelTop.setLayout(new BoxLayout(trackPanelTop, BoxLayout.LINE_AXIS));

        octave.setLayout(new BoxLayout(octave, BoxLayout.PAGE_AXIS));
        typesOptions.setLayout(new BoxLayout(typesOptions, BoxLayout.PAGE_AXIS));

        // Size settings for external components:
        trackName.setMaximumSize(new Dimension(100, trackName.getMinimumSize().height));
        instrumentOptions.setMaximumSize(new Dimension(200, instrumentOptions.getMinimumSize().height));
        lowOctaveOptions.setMaximumSize(new Dimension(Integer.MAX_VALUE, lowOctaveOptions.getMinimumSize().height));
        highOctaveOptions.setMaximumSize(new Dimension(Integer.MAX_VALUE, highOctaveOptions.getMinimumSize().height));

        // Size settings for local panels:
        octaveSetting.setMaximumSize(new Dimension(Integer.MAX_VALUE, octaveSetting.getMinimumSize().height));
        lowestOctave.setMaximumSize(new Dimension(Integer.MAX_VALUE, lowestOctave.getMinimumSize().height));
        highestOctave.setMaximumSize(new Dimension(Integer.MAX_VALUE, highestOctave.getMinimumSize().height));

        // Background settings for external components:
        instrumentOptions.setBackground(Color.white);
        lowOctaveOptions.setBackground(Color.white);
        highOctaveOptions.setBackground(Color.white);

        velocitySlider.setBackground(Client.background5);

        // Background settings for local panels:
        trackPanelTop.setBackground(Client.background5);
        trackPanelCenter.setBackground(Client.background5);
        trackPanelBottom.setBackground(Client.background5);

        velocity.setBackground(Client.background5);

        octave.setBackground(Client.background5);
        octaveSetting.setBackground(Client.background5);
        lowestOctave.setBackground(Client.background5);
        highestOctave.setBackground(Client.background5);

        types.setBackground(Client.background5);
        typesOptions.setBackground(Client.background5);

        space.setBackground(Client.background5);
        emptyPanel.setBackground(Client.background5);

        chord.setBackground(Client.background5);
        melody.setBackground(Client.background5);
        bass.setBackground(Client.background5);
        backgrounds.setBackground(Client.background5);
        drums.setBackground(Client.background5);

        // Border settings for local panels:
        trackPanelTop.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        trackPanelBottom.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));

        velocity.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        octave.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        types.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Other settings for components:
        velocitySlider.setPaintTicks(true);
        velocitySlider.setMajorTickSpacing(50);
        velocitySlider.setMinorTickSpacing(10);
        velocitySlider.addChangeListener(this);

        lowOctaveOptions.setSelectedIndex(2);
        highOctaveOptions.setSelectedIndex(4);

        remove.addActionListener(client.getContent());
        remove.setActionCommand("Remove " + ID);

        chord.setSelected(true);

        // Add components/panels to upper-level panels:
        trackPanelTop.add(new JLabel(" Track Name: "));
        trackPanelTop.add(trackName);
        trackPanelTop.add(new JLabel(" Instrument: "));
        trackPanelTop.add(instrumentOptions);

        trackPanelCenter.add(velocity);
        trackPanelCenter.add(octave);
        trackPanelCenter.add(types);
        trackPanelCenter.add(emptyPanel);

        trackPanelBottom.add(new JLabel(" Track ID: " + ID), BorderLayout.WEST);
        trackPanelBottom.add(remove, BorderLayout.EAST);

        // Add components/panels to mid-level panels:
        velocity.add(velocityLabel, BorderLayout.NORTH);
        velocity.add(velocitySlider, BorderLayout.CENTER);

        octave.add(octaveSetting);
        octave.add(Box.createRigidArea(new Dimension(10, 10)));
        octave.add(lowestOctave);
        octave.add(lowOctaveOptions);
        octave.add(highestOctave);
        octave.add(highOctaveOptions);
        octave.add(space);

        types.add(new JLabel("Optimize track for:"), BorderLayout.NORTH);
        types.add(typesOptions, BorderLayout.CENTER);

        // Add components to lowest-level panels:
        octaveSetting.add(new JLabel("Octave Settings:"), BorderLayout.WEST);
        lowestOctave.add(new JLabel("Lowest Octave:"), BorderLayout.WEST);
        highestOctave.add(new JLabel("Highest Octave:"), BorderLayout.WEST);

        typesOptions.add(chord);
        typesOptions.add(melody);
        typesOptions.add(bass);
        typesOptions.add(backgrounds);
        typesOptions.add(drums);

        // Add radio buttons to button group:
        trackTypes.add(chord);
        trackTypes.add(melody);
        trackTypes.add(bass);
        trackTypes.add(backgrounds);
        trackTypes.add(drums);

        // Add local panels to main panel:
        this.add(trackPanelTop, BorderLayout.NORTH);
        this.add(trackPanelCenter, BorderLayout.CENTER);
        this.add(trackPanelBottom, BorderLayout.SOUTH);
    }





    /*
     * ================================================
     * Getter for the ID of the track:
     * ================================================
     */

    public int getID()
    {
        return ID;
    }





    /*
     * ================================================
     * Getter for the name of the track:
     * ================================================
     */

    public String getTrackName()
    {
        return trackName.getText();
    }






    /*
     * ================================================
     * Getter for the track instrument:
     * ================================================
     */

    public Instrument getTrackInstrument()
    {
        return (Instrument) instrumentOptions.getSelectedItem();
    }





    /*
     * ================================================
     * Getter for the lowest octave of the track:
     * ================================================
     */

    public int getLowestOctave()
    {
        return (int) lowOctaveOptions.getSelectedItem();
    }





    /*
     * ================================================
     * Getter for the highest octave of the track:
     * ================================================
     */

    public int getHighestOctave()
    {
        return (int) highOctaveOptions.getSelectedItem();
    }





    /*
     * ================================================
     * Getter for the track type:
     * ================================================
     */

    public String getTrackType()
    {
        for (Enumeration<AbstractButton> buttons = trackTypes.getElements(); buttons.hasMoreElements();)
        {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected())
                return button.getText();
        }
        return null;
    }





    /*
     * ================================================
     * Implemented state change method:
     * Parameters:
     *      [ChangeEvent] event: The event that occurred
     * Returns:
     *      [None]
     * ================================================
     */

    public void stateChanged(ChangeEvent evt)
    {
        JSlider source = (JSlider) evt.getSource();
        if (!source.getValueIsAdjusting())
            velocityLabel.setText(" Velocity: " + velocitySlider.getValue());
    }
}
