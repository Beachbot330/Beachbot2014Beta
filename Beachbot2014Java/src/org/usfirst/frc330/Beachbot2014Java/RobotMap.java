// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc330.Beachbot2014Java;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//import java.util.Vector;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController chassisLeftDrive1;
    public static SpeedController chassisLeftDrive2;
    public static SpeedController chassisLeftDrive3;
    public static SpeedController chassisRightDrive1;
    public static SpeedController chassisRightDrive2;
    public static SpeedController chassisRightDrive3;
//    public static Relay chassisShiftSpike;
    public static Encoder chassisLeftDriveEncoder;
    public static Encoder chassisRightDriveEncoder;
    public static SpeedController armArm1;
    public static SpeedController armArm2;
    public static AnalogInput armArmPotentiometer;
    public static Solenoid shooterShooter1;
    public static Solenoid shooterShooter2;
    public static Solenoid shooterShooter3;
    public static Solenoid shooterShooter4;
    public static AnalogInput shooterShooterUltrasonic;
    public static DoubleSolenoid wingsWingSolenoid;
    public static DigitalInput wingsWingLeftLimitSwitch;
    public static DigitalInput wingsWingRightLimitSwitch;
    public static SpeedController pickupPickup1;
    public static SpeedController pickupPickup2;
/*    public static AnalogInput pickupCurrentSensor;  */
    public static Compressor compressor;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static AnalogInput pressureSensor;
    
    public static BackgroundCalibratingGyro chassisGyro;
    
    public static DoubleSolenoid shiftSolenoid;
    
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassisLeftDrive1 = new Talon(0);
	LiveWindow.addActuator("Chassis", "LeftDrive1", (Talon) chassisLeftDrive1);
        
        chassisLeftDrive2 = new Talon(1);
	LiveWindow.addActuator("Chassis", "LeftDrive2", (Talon) chassisLeftDrive2);
        
        chassisLeftDrive3 = new VictorSP(2);
	LiveWindow.addActuator("Chassis", "LeftDrive3", (VictorSP) chassisLeftDrive3);
        
        chassisRightDrive1 = new Talon(3);
	LiveWindow.addActuator("Chassis", "RightDrive1", (Talon) chassisRightDrive1);
        
        chassisRightDrive2 = new Talon(4);
	LiveWindow.addActuator("Chassis", "RightDrive2", (Talon) chassisRightDrive2);
        
        chassisRightDrive3 = new VictorSP(5);
	LiveWindow.addActuator("Chassis", "RightDrive3", (VictorSP) chassisRightDrive3);
        
        //chassisCompressor = new Compressor(1, 14, 1, 8);  TODO: Test our ability to control the compressor
	
        
//        chassisShiftSpike = new Relay(0);
	shiftSolenoid = new DoubleSolenoid(1,0,1);
	LiveWindow.addActuator("Chassis", "ShiftSpike", shiftSolenoid);
        
        chassisLeftDriveEncoder = new Encoder(4, 5, false, EncodingType.k4X);
	LiveWindow.addSensor("Chassis", "LeftDriveEncoder", chassisLeftDriveEncoder);
        chassisLeftDriveEncoder.setDistancePerPulse(1.0);
        chassisLeftDriveEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
        //chassisLeftDriveEncoder.start();
        chassisRightDriveEncoder = new Encoder(6, 7, true, EncodingType.k4X);
	LiveWindow.addSensor("Chassis", "RightDriveEncoder", chassisRightDriveEncoder);
        chassisRightDriveEncoder.setDistancePerPulse(1.0);
        chassisRightDriveEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
        //chassisRightDriveEncoder.start();
        armArm1 = new Jaguar(8);
	LiveWindow.addActuator("Arm", "Arm1", (Jaguar) armArm1);
        
        armArm2 = new Jaguar(9);
	LiveWindow.addActuator("Arm", "Arm2", (Jaguar) armArm2);
        
        armArmPotentiometer = new AnalogInput(1);
	LiveWindow.addSensor("Arm", "ArmPotentiometer", armArmPotentiometer);
        
        shooterShooter1 = new Solenoid(0, 0);
	LiveWindow.addActuator("Shooter", "Shooter1", shooterShooter1);
        
        shooterShooter2 = new Solenoid(0, 1);
	LiveWindow.addActuator("Shooter", "Shooter2", shooterShooter2);
        
        shooterShooter3 = new Solenoid(0, 2);
	LiveWindow.addActuator("Shooter", "Shooter3", shooterShooter3);
        
        shooterShooter4 = new Solenoid(0, 3);
	LiveWindow.addActuator("Shooter", "Shooter4", shooterShooter4);
        
        shooterShooterUltrasonic = new AnalogInput(2);
	LiveWindow.addSensor("Shooter", "ShooterUltrasonic", shooterShooterUltrasonic);
        
        wingsWingSolenoid = new DoubleSolenoid(0, 6, 7);      
	
        
        wingsWingLeftLimitSwitch = new DigitalInput(0);
	LiveWindow.addSensor("Wings", "WingLeftLimitSwitch", wingsWingLeftLimitSwitch);
        
        wingsWingRightLimitSwitch = new DigitalInput(1);
	LiveWindow.addSensor("Wings", "WingRightLimitSwitch", wingsWingRightLimitSwitch);
        
        pickupPickup1 = new TalonSRX(6);
	LiveWindow.addActuator("Pickup", "Pickup1", (TalonSRX) pickupPickup1);
        
        pickupPickup2 = new TalonSRX(7);
	LiveWindow.addActuator("Pickup", "Pickup2", (TalonSRX) pickupPickup2);
        
 /*       pickupCurrentSensor = new AnalogInput(2);
	LiveWindow.addSensor("Pickup", "CurrentSensor", pickupCurrentSensor);
*/
	compressor = new Compressor();
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        pressureSensor = new AnalogInput(3);
    LiveWindow.addSensor("Chassis", "PressureSensor", pressureSensor);
	
        LiveWindow.addActuator("Wings", "WingSolenoid", wingsWingSolenoid);
        chassisGyro = new BackgroundCalibratingGyro(0);
	LiveWindow.addSensor("Chassis", "Gyro", chassisGyro);
        chassisGyro.setSensitivity(0.007);
    }
}
