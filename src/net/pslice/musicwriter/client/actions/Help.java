package net.pslice.musicwriter.client.actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URI;

public class Help extends AbstractAction {

    public Help()
    {
        super("Help");
    }

    public void actionPerformed(ActionEvent event)
    {
        try
        {
        Desktop.getDesktop().browse(URI.create("https://github.com/p-slice/SongWriter/blob/master/README.md"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
