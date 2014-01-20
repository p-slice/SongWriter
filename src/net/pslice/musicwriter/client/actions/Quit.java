package net.pslice.musicwriter.client.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Quit extends AbstractAction {

    public Quit()
    {
        super("Exit");
    }

    public void actionPerformed(ActionEvent event)
    {
        System.exit(0);
    }
}
