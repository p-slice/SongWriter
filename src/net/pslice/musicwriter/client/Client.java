package net.pslice.musicwriter.client;

import net.pslice.musicwriter.client.actions.*;
import net.pslice.musicwriter.client.panels.*;

import javax.swing.*;
import java.awt.*;

public class Client {

    /*
     * =============================================
     * ...
     * =============================================
     */

    public static void main(String... args)
    {
        Client client = new Client();
    }

    /*
     * =============================================
     * ...
     * =============================================
     */

    private static final Dimension main = new Dimension(600, 400);

    /*
     * =============================================
     * ...
     * =============================================
     */

    public Client()
    {
        JFrame frame = new JFrame("Music Writer");

        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.white);

        final JMenuBar menuBar = new JMenuBar();
        final JMenu options = new JMenu("Options");
        options.add("Settings");
        options.add(new Help());
        options.addSeparator();
        options.add(new Quit());

        menuBar.add(options);

        frame.setJMenuBar(menuBar);

        final JPanel
                header,
                sideBar,
                content,
                footer;

        header = new Header();
        sideBar = new SideBar();
        content = new Content();
        footer = new Footer();

        frame.add(header, BorderLayout.NORTH);
        frame.add(sideBar, BorderLayout.WEST);
        frame.add(content, BorderLayout.CENTER);
        frame.add(footer, BorderLayout.SOUTH);

        frame.setSize(main);
        frame.setMinimumSize(main);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
