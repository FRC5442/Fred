// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5442.Fred;

import org.usfirst.frc5442.Fred.commands.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

	public JoystickButton joystick2TriggerIn;
	public JoystickButton joystick1TriggerIn;
	public static Joystick joystick2;
    public JoystickButton joystickSideButtonIn;
    public JoystickButton joystickSideButtonOut;
    public static Joystick joystick1;
    public JoystickButton joystick1Button3;
    public JoystickButton xboxRightBumperIn;
    public JoystickButton xboxLeftBumper;
    public JoystickButton xboxAButton;
    public static Joystick xboxController;
    public JoystickButton xboxYButton;
    public JoystickButton xboxLeftStick;
    public JoystickButton xboxXButton;

    public OI() {

    	
        xboxController = new Joystick(0);
        
        xboxLeftBumper = new JoystickButton(xboxController, 5);
        //xboxLeftBumper.whileHeld(new XboxWinchUp());
        xboxLeftBumper.whenPressed(new LedLightsXbox());
        xboxRightBumperIn = new JoystickButton(xboxController, 6);
        xboxRightBumperIn.whileHeld(new TurboMode());
        xboxAButton = new JoystickButton(xboxController, 1);
        xboxAButton.whileHeld(new CylinderOut());
        xboxYButton = new JoystickButton(xboxController, 4);
        xboxYButton.whileHeld(new CylinderIn());
        xboxLeftStick = new JoystickButton(xboxController, 7);
        //xboxLeftStick.whileHeld(new TurboMode());
        xboxXButton = new JoystickButton(xboxController, 3);
        xboxXButton.whenPressed(new LedLightsOff());
        /**joystick1 = new Joystick(1);
        
        joystick1TriggerIn = new JoystickButton(joystick1, 1);
        joystick1TriggerIn.whileHeld(new DriveStraight());
        joystickSideButtonOut = new JoystickButton(joystick1, 2);
        joystickSideButtonOut.whenReleased(new CylinderOut());
        joystickSideButtonIn = new JoystickButton(joystick1, 2);
        joystickSideButtonIn.whileHeld(new CylinderIn());
        joystick1Button3 = new JoystickButton(joystick1, 3);
        joystick1Button3.whileHeld(new Debug());
       
        
        joystick2 = new Joystick(0);
        joystick2TriggerIn = new JoystickButton(joystick2, 1);
        joystick2TriggerIn.whileHeld(new winchMove());
        **/
        
        

	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new DriveIntoAutoZone());

        SmartDashboard.putData("CylinderIn", new CylinderIn());

        SmartDashboard.putData("CylinderOut", new CylinderOut());

        SmartDashboard.putData("DriveWithController", new DriveWithController());
        
        SmartDashboard.putData("winchMove", new winchMove());
    }
    public Joystick getJoystick2() {
        return joystick2;
    }

    public Joystick getJoystick1() {
        return joystick1;
    }

    public Joystick getXboxController() {
        return xboxController;
    }
}

