// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc330.Beachbot2014Java.commands;
import org.usfirst.frc330.Beachbot2014Java.Robot;
import org.usfirst.frc330.Beachbot2014Java.subsystems.Chassis;
/**
 *
 */

public class DriveDistanceAtRelAngle extends DriveDistanceRel{
    double angle;
    
    public DriveDistanceAtRelAngle()
    {
        this(0,0,0,0,true);
    }
    
    public DriveDistanceAtRelAngle(double distance, double angle)
    {
        this(distance, 0, angle, 0, true);
    }
    
    public DriveDistanceAtRelAngle(double distance, double tolerance, double angle, double timeout, boolean stopAtEnd)
    {
        super(distance, tolerance, timeout, stopAtEnd);
        this.angle = angle;
    }
        // Called just before this Command runs the first time
    protected void initialize() {
        super.initialize();
        if (!Robot.chassis.getShiftState())
        {
            Robot.chassis.gyroPID.setGainName(Chassis.DRIVELOW);
        }
        else
        {
            Robot.chassis.gyroPID.setGainName(Chassis.DRIVEHIGH);
        }
        Robot.chassis.gyroPID.setSetpoint(angle);
        Robot.chassis.gyroPID.enable();
    }

    /**
     * The third parameter in the AutoSpreadsheet, angle.
     * The angle is relative 
     * to the angle where the robot started. The angle should be close to the 
     * current angle of the robot (ie this command is not appropriate for both turning and driving).
     * If the robot needs to turn prior to driving straight, use {@link TurnGyroAbs} 
     * first. 
     * @param angle The angle (in degrees) to maintain while driving
     */
    public void setParam3(double angle) {
        this.angle = angle;
    }

}
