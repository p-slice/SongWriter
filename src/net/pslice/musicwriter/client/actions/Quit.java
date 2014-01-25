package net.pslice.musicwriter.client.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Quit extends AbstractAction {

    /*
     * =============================================
     * Initializer:
     * Parameters:
     *      [None]
     * =============================================
     */

    public Quit()
    {
        super("Exit");
    }





    /*
     * =============================================
     * Implemented action performed method:
     * Parameters:
     *      [ActionEvent] event: The event that occurred
     * Returns:
     *      [None]
     * =============================================
     */

    public void actionPerformed(ActionEvent event)
    {
        System.exit(0);
    }
}
