package net.pslice.musicwriter.client;

import net.pslice.musicwriter.client.actions.*;
import net.pslice.musicwriter.client.panels.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Client {

    /*
     * =============================================
     * ...
     * =============================================
     */

    private static Client client;

    public static Client getClient()
    {
        return client;
    }

    /*
     * =============================================
     * ...
     * =============================================
     */

    public static void main(String... args)
    {
        client = new Client();
    }

    /*
     * =============================================
     * ...
     * =============================================
     */

    private static final Dimension main = new Dimension(600, 400);

    private final Header header = new Header();
    private final SideBar sideBar = new SideBar();
    private final Content content = new Content();
    private final Footer footer = new Footer();

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

    /*
     * =============================================
     * ...
     * =============================================
     */

    public Header getHeader()
    {
        return header;
    }

    public SideBar getSideBar()
    {
        return sideBar;
    }

    public Content getContent()
    {
        return content;
    }

    public Footer getFooter()
    {
        return footer;
    }
}
