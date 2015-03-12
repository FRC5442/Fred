// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5442.Fred.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc5442.Fred.OI;
import org.usfirst.frc5442.Fred.Robot;
import org.usfirst.frc5442.Fred.RobotMap;

/**
 *
 */
//@SuppressWarnings("unused")
public class  DriveIntoAutoZone extends Command {
	
	//PIDController driveTo = new PIDController(0.1,0.001, Robot.Encoder.encoderLeft, Robot.DriveTrain.robotDrive);

    public DriveIntoAutoZone() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.encoders.encoderLeft.reset();
    	Robot.encoders.encoderLeft.reset();
    	RobotMap.imu.zeroYaw();
    	//driveTo.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//distance(in)/12.56/1.5
    	while (Robot.encoders.encoderRight.getDistance() < 11.5)
    	{
    		Robot.navXBoard.setSetpoint(0);
    		//Robot.driveTrain.tankDrive(-1, .974 * -1);
    	}
    	
    	
    }



	// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.driveStraight(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
