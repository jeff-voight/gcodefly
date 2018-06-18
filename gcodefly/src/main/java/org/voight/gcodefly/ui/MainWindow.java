/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.voight.gcodefly.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.voight.gcodefly.model.GCode;

/**
 *
 * @author Jeffrey Voight <jeff.voight@gmail.com>
 */
public class MainWindow extends JFrame {

    private Color backgroundColor = new Color(200, 200, 200);
    private Color foregroundColor = new Color(0, 0, 0);
    private final int preferredWidth = 800;
    private final int preferredHeight = 480;

    private JMenuBar mainMenuBar;

    private JTabbedPane tabPanel;
    
    private JFileChooser chooser=new JFileChooser();

    private GCode gcode;
    
    public static void main(String argv[]) {
	/* Create and display the form */
	java.awt.EventQueue.invokeLater(() -> {
	    new MainWindow(argv).setVisible(true);
	});
    }

    public MainWindow(String argv[]) {
	initComponents();
    }

    public final void initComponents() {
	try {
	    // Set System L&F
	    UIManager.setLookAndFeel(
		    UIManager.getSystemLookAndFeelClassName());
	} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	    // handle exception
	}

	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	setSize(new Dimension(preferredWidth, preferredHeight));
	setPreferredSize(new Dimension(preferredWidth, preferredHeight));

	mainMenuBar = new MainMenuBar(this);

	this.tabPanel = new JTabbedPane();
	setTitle("GCode Fly");
	setBackground(backgroundColor);
	setForeground(foregroundColor);
	setSize(preferredWidth, preferredHeight);
	setJMenuBar(mainMenuBar);

	pack();
    }
    
    protected void exit(){
	this.dispose();
    }

    protected void close(){
	gcode=null;
    }
    
    protected void open(){
	int result=chooser.showOpenDialog(this);
	if(result==JFileChooser.APPROVE_OPTION){
	    try {
		gcode=new GCode(chooser.getSelectedFile());
	    } catch (IOException ex) {
		Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
}
