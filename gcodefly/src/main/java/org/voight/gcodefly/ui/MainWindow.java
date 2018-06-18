/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.voight.gcodefly.ui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Jeffrey Voight <jeff.voight@gmail.com>
 */
public class MainWindow extends JFrame {

    private Color backgroundColor = new Color(200, 200, 200);
    private Color foregroundColor = new Color(0, 0, 0);
    private int preferredWidth = 800;
    private int preferredHeight = 480;

    private JMenuBar mainMenuBar;

    private JTabbedPane tabPanel;

    public static void main(String argv[]) {
	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		new MainWindow(argv).setVisible(true);
	    }
	});
    }

    public MainWindow(String argv[]) {
	initComponents();
    }

    public void initComponents() {
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

}
