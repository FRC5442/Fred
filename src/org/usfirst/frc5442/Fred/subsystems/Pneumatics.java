// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5442.Fred.subsystems;

import org.usfirst.frc5442.Fred.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
//@SuppressWarnings("unused")
public class Pneumatics extends Subsystem {
    private Compressor compressor = RobotMap.pneumaticsCompressor;

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Pneumatics() {
        compressor.start();
    }

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

