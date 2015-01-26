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
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
@SuppressWarnings("unused")
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainTalonController1;
    public static SpeedController driveTrainTalonController2;
    public static SpeedController driveTrainTalonController3;
    public static SpeedController driveTrainTalonController4;
    public static RobotDrive driveTrainRobotDrive;
    public static Compressor pneumaticsCompressor;
    public static DoubleSolenoid manipulatorCylinder;
    public static Encoder encoderEncoderLeft;
    public static Encoder encoderEncoderRight;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainTalonController1 = new Talon(1);
        LiveWindow.addActuator("Drive Train", "TalonController1", (Talon) driveTrainTalonController1);
        
        driveTrainTalonController2 = new Talon(2);
        LiveWindow.addActuator("Drive Train", "TalonController2", (Talon) driveTrainTalonController2);
        
        driveTrainTalonController3 = new Talon(3);
        LiveWindow.addActuator("Drive Train", "TalonController3", (Talon) driveTrainTalonController3);
        
        driveTrainTalonController4 = new Talon(4);
        LiveWindow.addActuator("Drive Train", "TalonController4", (Talon) driveTrainTalonController4);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainTalonController2, driveTrainTalonController4,
              driveTrainTalonController1, driveTrainTalonController3);
        
        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);

        pneumaticsCompressor = new Compressor(0);
        
        
        //Warning, the two modules in robot builder are different!
manipulatorCylinder = new DoubleSolenoid(0, 0, 1);      
        LiveWindow.addActuator("Manipulator", "Cylinder", manipulatorCylinder);
        
        encoderEncoderLeft = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Encoder", "EncoderLeft", encoderEncoderLeft);
        encoderEncoderLeft.setDistancePerPulse(1.0);
        encoderEncoderLeft.setPIDSourceParameter(PIDSourceParameter.kDistance);
        encoderEncoderRight = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Encoder", "EncoderRight", encoderEncoderRight);
        encoderEncoderRight.setDistancePerPulse(1.0);
        encoderEncoderRight.setPIDSourceParameter(PIDSourceParameter.kDistance);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
