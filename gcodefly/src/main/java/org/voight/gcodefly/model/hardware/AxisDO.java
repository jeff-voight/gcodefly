/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.voight.gcodefly.model.hardware;

/**
 *
 * @author Jeffrey Voight <jeff.voight@gmail.com>
 */
public class AxisDO {
    protected String label = "Empty";
    protected double min=0;	    // The minimum value for this axis
    protected double max;	    // The maximum value for this axis
    protected double maxspeed;	    // Stored in mm/min
    protected double speed;	    // The current speed in mm/min
    protected double position;	    // The current position
    protected double stepsPerMM;    // How many steps to move one mm.
}
