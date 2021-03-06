package org.usfirst.frc5442.Fred.commands;

import org.usfirst.frc5442.Fred.OI;
import org.usfirst.frc5442.Fred.Robot;
import org.usfirst.frc5442.Fred.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;

/*
 * Command to move the winch based on joystick2 trim value. Command will run for the time
 * need to execute or until another command which requires one or more of the 
 * same subsystems is scheduled to run.
*/
public class winchMove extends Command {
	public winchMove() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

		requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while (OI.xboxController.getRawAxis(2) > 0) {
    		Robot.winch.move(OI.xboxController.getRawAxis(2) * -1);
    	}
    	while (OI.xboxController.getRawAxis(3) > 0) {
    		Robot.winch.move(OI.xboxController.getRawAxis(3));
    	}
    	Robot.winch.move(.1);
    	//System.out.println("Pot: " + CANTalon.FeedbackDevice.AnalogPot.value);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.winch.move(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.winch.move(0.0);
    }

}
