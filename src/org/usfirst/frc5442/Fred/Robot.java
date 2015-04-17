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

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5442.Fred.commands.*;
import org.usfirst.frc5442.Fred.subsystems.*;

import com.kauailabs.nav6.frc.IMU;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    public static DriveTrain driveTrain;
    public static Pneumatics pneumatics;
    public static Manipulator manipulator;
    public static Encoder encoders;
    public static RearHooks hooks;
    public static Winch winch;
    public static NavXBoard navXBoard;
    public static Led Leds;
    public static Preferences prefs;
    public static double encoderDistance;
    boolean first_iteration;
    SendableChooser autonomousModes;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();

        driveTrain = new DriveTrain();
        pneumatics = new Pneumatics();
        manipulator = new Manipulator();
        encoders = new Encoder();
        winch = new Winch();
        navXBoard = new NavXBoard();
        Leds = new Led();
        hooks = new RearHooks();

        CameraServer server = null;
        
        //server = CameraServer.getInstance();
        if (CameraServer.getInstance() == null) {
        	
        } else {
        	server = CameraServer.getInstance();
        	server.setQuality(50);
            server.startAutomaticCapture("cam2");
        }
        
        // OI must be constructed after subsystems. If the OI creates Commands 
        //(which it very likely will), subsystems are not guaranteed to be 
        // constructed yet. Thus, their requires() statements may grab null 
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        autonomousCommand = new DriveIntoAutoZone();
        autonomousModes = new SendableChooser();
        autonomousModes.addDefault("Push Tote", new DriveIntoAutoZone());
        autonomousModes.addObject("Don't move", new AutoHoldStill());
        autonomousModes.addObject("Pick up and Drive back", new PickupDriveBack());
        autonomousModes.addObject("Custom Drive straight Distance", new DriveIntoAutoZoneCustom());
        SmartDashboard.putData("Autonomous Mode", autonomousModes);
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
    	//encoderDistance = prefs.getDouble("Drive distance", 7.6);
    	Robot.encoders.encoderLeft.reset();
    	Robot.encoders.encoderRight.reset();
        // schedule the autonomous command (example)
    	autonomousCommand = (Command) autonomousModes.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	Robot.encoders.encoderLeft.reset();
    	RobotMap.navXBoard.reset();
    	RobotMap.imu.zeroYaw();
    	RobotMap.ledlights.set(true);
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        boolean is_calibrating = RobotMap.imu.isCalibrating();
        if ( first_iteration && !is_calibrating ) {
            Timer.delay( 0.3 );
            RobotMap.imu.zeroYaw();
            first_iteration = false;
        }
        
        driveTrain.tankDrive(OI.xboxController.getRawAxis(5), OI.xboxController.getRawAxis(1));
        RobotMap.ledlights.set(true);
        if(OI.xboxController.getRawAxis(2) > 0.1)
        {
        	winch.move(-1*OI.xboxController.getRawAxis(2));
        }
        else if(OI.xboxController.getRawAxis(3) > 0.1)
        {
        	winch.move(OI.xboxController.getRawAxis(3));
        }
        else
        	winch.move(0.1);
        
        /*if(OI.xboxController.getRawButton(1))
        	manipulator.cylinder(DoubleSolenoid.Value.kForward);
        else if(OI.xboxController.getRawButton(3))
        	manipulator.cylinder(DoubleSolenoid.Value.kReverse);
        */
        /*
        SmartDashboard.putBoolean(  "IMU_Connected",        RobotMap.imu.isConnected());
        SmartDashboard.putBoolean(  "IMU_IsCalibrating",    RobotMap.imu.isCalibrating());
        SmartDashboard.putNumber(   "IMU_Yaw",              RobotMap.imu.getYaw());
        SmartDashboard.putNumber(   "IMU_Pitch",            RobotMap.imu.getPitch());
        SmartDashboard.putNumber(   "IMU_Roll",             RobotMap.imu.getRoll());
        SmartDashboard.putNumber(   "IMU_CompassHeading",   RobotMap.imu.getCompassHeading());
        SmartDashboard.putNumber(   "IMU_Update_Count",     RobotMap.imu.getUpdateCount());
        SmartDashboard.putNumber(   "IMU_Byte_Count",       RobotMap.imu.getByteCount());

        // If you are using the IMUAdvanced class, you can also access the following
        // additional functions, at the expense of some extra processing
        // that occurs on the CRio processor
       
        SmartDashboard.putNumber(   "IMU_Accel_X",          RobotMap.imu.getWorldLinearAccelX());
        SmartDashboard.putNumber(   "IMU_Accel_Y",          RobotMap.imu.getWorldLinearAccelY());
        SmartDashboard.putBoolean(  "IMU_IsMoving",         RobotMap.imu.isMoving());
        SmartDashboard.putNumber(   "IMU_Temp_C",           RobotMap.imu.getTempC());
       
        SmartDashboard.putNumber(   "Velocity_X",           RobotMap.imu.getVelocityX() );
        SmartDashboard.putNumber(   "Velocity_Y",           RobotMap.imu.getVelocityY() );
        SmartDashboard.putNumber(   "Displacement_X",       RobotMap.imu.getDisplacementX() );
        SmartDashboard.putNumber(   "Displacement_Y",       RobotMap.imu.getDisplacementY() );
        //SmartDashboard.putNumber( "Pot420", RobotMap.winchPot.get());
        SmartDashboard.putNumber("SRXVoltage", RobotMap.m_winchController.getOutputVoltage());
        SmartDashboard.putNumber("SRXAnalogPos", RobotMap.m_winchController.getAnalogInRaw());
        SmartDashboard.putNumber("SRXGet", RobotMap.m_winchController.get());
        SmartDashboard.putNumber("SRXPos", RobotMap.m_winchController.getPosition());
        */

        //System.out.println("Winch Current: " + RobotMap.m_winchController.getOutputCurrent());
        //System.out.println("Winch Value: " + CANTalon.FeedbackDevice.AnalogPot.value);
        //System.out.println("Pot Value: " + RobotMap.m_winchController.getPosition());
    }
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
