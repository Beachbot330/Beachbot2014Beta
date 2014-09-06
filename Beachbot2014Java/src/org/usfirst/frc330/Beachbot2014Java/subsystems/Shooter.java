// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc330.Beachbot2014Java.subsystems;
import org.usfirst.frc330.Beachbot2014Java.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc330.Beachbot2014Java.Robot;
/**
 *
 */
public class Shooter extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    Solenoid shooter1 = RobotMap.shooterShooter1;
    Solenoid shooter2 = RobotMap.shooterShooter2;
    Solenoid shooter3 = RobotMap.shooterShooter3;
    Solenoid shooter4 = RobotMap.shooterShooter4;
    AnalogInput shooterUltrasonic = RobotMap.shooterShooterUltrasonic;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Shooter() {
        super();
        SmartDashboard.putBoolean("BallSensorOverride", false);
        SmartDashboard.putBoolean("ShooterDisable", false);
    }
    
    public void shootSolenoidOn() {
        if (!SmartDashboard.getBoolean("ShooterDisable", false)) {
            shooter1.set(true);
            shooter2.set(true);
            shooter3.set(true);
            shooter4.set(true);
        }
    }
    public void lowPowerShootSolenoidOn() {
        if (!SmartDashboard.getBoolean("ShooterDisable", false)) {
            shooter1.set(false);
            shooter2.set(false);
            shooter3.set(true);
            shooter4.set(true);
        }
    }    
    
    public void shootSolenoidOff() {
        shooter1.set(false);
        shooter2.set(false);
        shooter3.set(false);
        shooter4.set(false);
    }
    
    
    public double shootSolenoidOffTime() {
        if (!Preferences.getInstance().containsKey("shooterOffTime"))
        {
            Preferences.getInstance().putDouble("shooterOffTime", 0.2);
            Preferences.getInstance().save();
        }
        return Preferences.getInstance().getDouble("shooterOffTime", 0.2);
    }
    
    public double getBallDistance() {
        return shooterUltrasonic.getAverageVoltage() / 0.0098;
    }
    
    private double isBallInShooterDistance() {
        if (!Preferences.getInstance().containsKey("isBallInShooterDistance"))
        {
            Preferences.getInstance().putDouble("isBallInShooterDistance", 9);
            Preferences.getInstance().save();
        }
        return Preferences.getInstance().getDouble("isBallInShooterDistance", 9);
    } 
     
    public boolean isBallInShooter() {
        return getBallDistance() < Robot.shooter.isBallInShooterDistance() 
                || SmartDashboard.getBoolean("BallSensorOverride", false);
    }
    
    public boolean isBallInWings() {
        double ballDistance = getBallDistance();
        //TODO make the ball distances preferences.
        return ballDistance > 15 && ballDistance < getCatchHeight() && !SmartDashboard.getBoolean("BallSensorOverride", false);
    }
    
    public double getCatchHeight() {
        if (!Preferences.getInstance().containsKey("catchHeight"))
        {
            Preferences.getInstance().putDouble("catchHeight", 38);
            Preferences.getInstance().save();
}
        return Preferences.getInstance().getDouble("catchHeight", 38);
    }
}
