package net.pslice.musicwriter.client.panels;

import net.pslice.musicwriter.client.Client;
import net.pslice.musicwriter.program.music.Note;
import net.pslice.musicwriter.program.music.scale.Scale;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SideBar extends JPanel implements ChangeListener {

    /*
     * =============================================
     * Variables, Objects, Sets, Lists and Maps:
     * =============================================
     */

    // The client the panel is assigned to (UNUSED)
    private final Client client;

    // ComboBox of all possible keys
    private JComboBox<Note> keyOptions = new JComboBox<>(Note.values());
    // ComboBox of all possible scales
    private JComboBox<Scale> scaleOptions = new JComboBox<>(Scale.values());
    // Label of the current tempo
    private JLabel tempo = new JLabel(" Tempo: 120 BPM");
    // Slider to set the tempo
    private JSlider tempoSlider = new JSlider(JSlider.HORIZONTAL, 60, 180, 120);





    /*
     * =============================================
     * Initializer:
     * Parameters:
     *      [Client] client: The client the panel is assigned to
     * =============================================
     */

    public SideBar(Client client)
    {
        this.client = client;

        // Main panel setup:
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setBackground(Client.background2);

        // Settings for external components:
        keyOptions.setBackground(Color.white);
        keyOptions.setSelectedItem(Note.C);

        scaleOptions.setBackground(Color.white);

        tempoSlider.setMajorTickSpacing(10);
        tempoSlider.setMinorTickSpacing(5);
        tempoSlider.addChangeListener(this);
        tempoSlider.setPaintTicks(true);
        tempoSlider.setBackground(Client.background2);

        // Initializers for local panels:
        JPanel options = new JPanel(new BorderLayout());
        JPanel key = new JPanel(new GridLayout(1, 2));
        JPanel scale = new JPanel(new GridLayout(1, 2));
        JPanel tempo1 = new JPanel(new BorderLayout());
        JPanel tempo2 = new JPanel(new BorderLayout());

        JPanel space = new JPanel();

        // Size settings for local panels:
        options.setMaximumSize(new Dimension(Integer.MAX_VALUE, options.getMinimumSize().height));
        key.setMaximumSize(new Dimension(Integer.MAX_VALUE, key.getMinimumSize().height));
        scale.setMaximumSize(new Dimension(Integer.MAX_VALUE, scale.getMinimumSize().height));
        tempo1.setMaximumSize(new Dimension(Integer.MAX_VALUE, tempo1.getMinimumSize().height));
        tempo2.setMaximumSize(new Dimension(Integer.MAX_VALUE, tempo2.getMinimumSize().height));

        // Background settings for local panels:
        options.setBackground(Client.background2);
        key.setBackground(Client.background2);
        scale.setBackground(Client.background2);
        tempo1.setBackground(Client.background2);
        tempo2.setBackground(Client.background2);

        space.setBackground(Client.background2);

        // Add various components to local panels:
        options.add(new JLabel(" Song Options: "), BorderLayout.WEST);

        key.add(new JLabel(" Key: "));
        key.add(keyOptions);

        scale.add(new JLabel(" Scale: "));
        scale.add(scaleOptions);

        tempo1.add(tempo, BorderLayout.WEST);
        tempo2.add(tempoSlider, BorderLayout.WEST);

        // Add local panels and spacing to main panel:
        this.add(options);
        this.add(Box.createRigidArea(new Dimension(1, 20)));
        this.add(key);
        this.add(Box.createRigidArea(new Dimension(1, 10)));
        this.add(scale);
        this.add(Box.createRigidArea(new Dimension(1, 20)));
        this.add(tempo1);
        this.add(tempo2);

        this.add(space);
    }





    /*
     * =============================================
     * Getter for the final song key:
     * =============================================
     */

    public Note getSongKey()
    {
        return (Note)keyOptions.getSelectedItem();
    }





    /*
     * =============================================
     * Getter for the final song scale
     * =============================================
     */

    public Scale getSongScale()
    {
        return (Scale)scaleOptions.getSelectedItem();
    }





    /*
     * =============================================
     * Getter for the final song tempo
     * =============================================
     */

    public int getSongTempo()
    {
        return tempoSlider.getValue();
    }





    /*
     * =============================================
     * Implemented state change method:
     * Parameters:
     *      [ChangeEvent] event: The event that occurred
     * Returns:
     *      [None]
     * =============================================
     */

    public void stateChanged(ChangeEvent evt)
    {
        JSlider source = (JSlider) evt.getSource();
        if (!source.getValueIsAdjusting())
            tempo.setText(" Tempo: " + source.getValue() + " BPM");
    }
}
