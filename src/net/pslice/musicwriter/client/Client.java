package net.pslice.musicwriter.client;

import net.pslice.musicwriter.client.actions.*;
import net.pslice.musicwriter.client.panels.*;

import javax.swing.*;
import java.awt.*;

public class Client {

    /*
     * =============================================
     * Main static initializer:
     * =============================================
     */

    public static void main(String... args)
    {
        new Client();
    }





    /*
     * =============================================
     * Variables, Objects, Sets, Lists and Maps:
     * =============================================
     */

    // The dimension of the client frame
    private static final Dimension main = new Dimension(700, 400);

    // The version of the program
    public static final String version = "0.5.2";

    // The header panel assigned to the client
    private final Header header = new Header(this);
    // The side bar panel assigned to the client
    private final SideBar sideBar = new SideBar(this);
    // The content panel assigned to the client
    private final Content content = new Content(this);
    // The footer panel assigned to the client
    private final Footer footer = new Footer(this);

    // Colours used by the client
    // As a Canadian, I am disappointed by the lack of "Colour" class.
    public static final Color

            // The background colour used by the client header panel:
            background1 = new Color(245, 245, 245),

            // The background colour used by the client side bar panel:
            background2 = Color.white,

            // The background colour used by the client content panel:
            background3 = new Color(200, 200, 255),

            // The background colour used by the client footer panel:
            background4 = Color.white,

            // The background colour used by the client track panels:
            background5 = new Color(200, 200, 200),

            // The background colour used by the tab pane:
            tab = new Color(150, 200, 150),

            // The colour of the content border:
            border = Color.black;





    /*
     * =============================================
     * Initializer:
     * Parameters:
     *      [None]
     * =============================================
     */

    public Client()
    {
        // The main frame used by the client:
        JFrame frame = new JFrame("Music Writer");

        // Frame setup:
        frame.setMinimumSize(main);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        // Initializers for local components:
        final JMenuBar menuBar = new JMenuBar();
        final JMenu options = new JMenu("Options");

        // Add settings to options menu:
        options.add("Settings");
        options.add(new Help());
        options.addSeparator();
        options.add(new Quit());

        // Add menus to menu bar:
        menuBar.add(options);

        // Add menu bar and external panels to frame:
        frame.setJMenuBar(menuBar);

        frame.add(header, BorderLayout.NORTH);
        frame.add(sideBar, BorderLayout.WEST);
        frame.add(content, BorderLayout.CENTER);
        frame.add(footer, BorderLayout.SOUTH);

        frame.pack();
    }





    /*
     * =============================================
     * Getter for the header panel:
     * =============================================
     */

    public Header getHeader()
    {
        return header;
    }





    /*
     * =============================================
     * Getter for the side bar panel:
     * =============================================
     */

    public SideBar getSideBar()
    {
        return sideBar;
    }





    /*
     * =============================================
     * Getter for the content panel:
     * =============================================
     */

    public Content getContent()
    {
        return content;
    }





    /*
     * =============================================
     * Getter for the footer panel:
     * =============================================
     */

    public Footer getFooter()
    {
        return footer;
    }
}