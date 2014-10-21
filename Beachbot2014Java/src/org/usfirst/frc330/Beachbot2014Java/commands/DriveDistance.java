
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
import edu.wpi.first.wpilibj.command.AutoSpreadsheetCommand;
import edu.wpi.first.wpilibj.command.BBCommand;
import org.usfirst.frc330.Beachbot2014Java.Robot;
import org.usfirst.frc330.Beachbot2014Java.subsystems.Chassis;
/**
 * Drive a distance in inches using encoders, Stop when within a tolerance.
 * The distance is relative to the starting position of the robot at the beginning of the match.
 * This command is only suitable for driving in straight lines (not after turning).
 * For more complicated maneuvers, see DriveWaypoint and TurnWaypoint. To drive
 * straight from the relative to the current position, see DriveDistanceRel.
 * 
 * @see DriveWaypoint
 * @see TurnGyroWaypoint
 * @see DriveDistanceRel
 */
public class  DriveDistance extends BBCommand implements AutoSpreadsheetCommand {
    double leftDistance, rightDistance, tolerance;
    boolean stopAtEnd = false;
    
    public DriveDistance()
    {
        this(0,0,0,false);
    }
    
    public DriveDistance(double distance) {
        this(distance, 0, 0, false);
    }
    
    public DriveDistance(double distance, double tolerance)
    {
        this(distance, tolerance, 0, false);
    }
    
    public DriveDistance(double distance, double tolerance, double timeout, boolean stopAtEnd) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chassis);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        this.leftDistance = distance;
        this.rightDistance = distance;
        this.tolerance = tolerance;
        setTimeout(timeout);
        this.stopAtEnd = stopAtEnd;
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.chassis.gyroPID.disable();
        if (!Robot.chassis.getShiftState())
        {
            Robot.chassis.leftDrivePID.setGainName(Chassis.DRIVELOW);
            Robot.chassis.rightDrivePID.setGainName(Chassis.DRIVELOW);
        }
        else
        {
             Robot.chassis.leftDrivePID.setGainName(Chassis.DRIVEHIGH);
             Robot.chassis.rightDrivePID.setGainName(Chassis.DRIVEHIGH);
        }
        Robot.chassis.leftDrivePID.setSetpoint(leftDistance);
        Robot.chassis.rightDrivePID.setSetpoint(rightDistance);
        Robot.chassis.leftDrivePID.enable();
        Robot.chassis.rightDrivePID.enable();
        Robot.chassis.leftDrivePID.setAbsoluteTolerance(tolerance);
        Robot.chassis.rightDrivePID.setAbsoluteTolerance(tolerance);
        
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Robot.chassis.leftDrivePID.onTarget() || Robot.chassis.rightDrivePID.onTarget() || isTimedOut())
        {
                return true;            
        }
        return false;
    }
    // Called once after isFinished returns true
    protected void end() {
        if (stopAtEnd)
        {
            Robot.chassis.stopDrive();
        }
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        stopAtEnd = true;
        end();
    }
    /**
     * The first parameter in the AutoSpreadsheet, distance.
     * @param distance the distance to travel in inches
     */
    public void setParam1(double distance) {
        this.leftDistance = distance;
        this.rightDistance = distance;
    }
     /**
     * The third parameter in the AutoSpreadsheet, tolerance. 
     * The tolerance in inches for how close to be to the distance before stopping.
     * 3 inches is a reasonable tolerance for normal movements. If a smaller
     * tolerance is used, the robot may not ever reach the tolerance, and the 
     * {@link #setTimeout(double) timeout} may be reached.
     * @param tolerance in inches
     * @see edu.wpi.first.wpilibj.PIDController#setAbsoluteTolerance
     */
    public void setParam2(double tolerance) {
        this.tolerance =    tolerance;
    }
    public void setParam3(double param3) {
    }
    public void setStopAtEnd(boolean stopAtEnd) {
        this.stopAtEnd = stopAtEnd;
    }
}
