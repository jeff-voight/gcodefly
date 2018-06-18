/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.voight.gcodefly.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Jeffrey Voight <jeff.voight@gmail.com>
 */
public class MainMenuBar extends JMenuBar implements ActionListener {
    private MainWindow parent;
    String helpText = "Help";
    String fileCloseText = "Close";
    String fileExitText = "Exit";
    JMenuItem fileClose;
    JMenu fileMenu;
    JMenuItem fileOpen;
    String helpAboutText = "About";
    JMenuItem fileExit;
    String fileText = "File";
    JMenuItem helpAbout;
    String fileOpenText = "Open";
    JMenu helpMenu;
    
    public MainMenuBar(MainWindow parent){
	this.parent=parent;
	fileMenu = new JMenu();
	fileOpen = new JMenuItem();
	fileClose = new JMenuItem();
	fileExit = new JMenuItem();

	fileMenu.setText(fileText);
	fileOpen.setText(fileOpenText);
	fileClose.setText(fileCloseText);
	fileExit.setText(fileExitText);
	fileMenu.add(fileOpen);
	fileMenu.add(fileClose);
	fileMenu.add(fileExit);

	helpMenu = new JMenu();
	helpMenu.setText(helpText);
	helpAbout = new JMenuItem();
	helpAbout.setText(helpAboutText);
	helpMenu.add(helpAbout);
	
	fileOpen.setActionCommand("fileOpen");
	fileOpen.addActionListener(this);
	
	fileClose.setActionCommand("fileClose");
	fileClose.addActionListener(this);
	
	fileExit.setActionCommand("fileExit");
	fileExit.addActionListener(this);
	add(fileMenu);
	add(helpMenu);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
	switch(ae.getActionCommand()){
	    case "fileExit":
		parent.exit();	
		break;
	    case "fileClose":
		parent.close();
		break;
	    case "fileOpen":
		parent.open();
		break;		
	}
    }
    
}
