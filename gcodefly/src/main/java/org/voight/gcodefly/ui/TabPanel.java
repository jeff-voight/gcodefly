/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.voight.gcodefly.ui;

import javax.swing.JTabbedPane;

/**
 *
 * @author Jeffrey Voight <jeff.voight@gmail.com>
 */
public class TabPanel extends JTabbedPane {
    private String title="DRO";
    private String tooltip="Digital Readout"; // TODO: Localization
    
    public TabPanel(){
	this.setName(title);
	this.setToolTipText(tooltip);
	
    }
}
