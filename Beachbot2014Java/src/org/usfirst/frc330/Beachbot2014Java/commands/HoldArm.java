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
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc330.Beachbot2014Java.Robot;
/**
 *
 */
public class  HoldArm extends Command {
    public HoldArm() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.arm);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        SmartDashboard.putNumber("ArmVelocityCutoff", 0);
    }
    
    double holdTime = 0;
    // Called just before this Command runs the first time
    protected void initialize() {
        holdTime = 0;
        
    }
    double prevArmPosition = 0;
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {        
        double velocity = Math.abs(prevArmPosition - Robot.arm.getArmPosition());
        if (!Robot.arm.isEnable() && velocity <= 0.005) {
            Robot.arm.setArmSetPoint(Robot.arm.getArmPosition());
            Robot.arm.enable();            
            Robot.arm.setGainName("Hold");
        }
        else if (Robot.arm.isEnable() && Robot.arm.onTarget() && velocity <= 0.01 && Timer.getFPGATimestamp() > holdTime && holdTime != 0) {
            Robot.arm.setGainName("Hold");
        }
        else if (Robot.arm.isEnable() && Robot.arm.onTarget() && velocity <= 0.01 && holdTime == 0) {
            holdTime = Timer.getFPGATimestamp() + 0.75;
        }
        else if (!Robot.arm.isEnable() || !Robot.arm.onTarget() || velocity >= 0.005) {
            holdTime = 0;
        }
//        System.out.println("holdTime: " + holdTime);
        prevArmPosition = Robot.arm.getArmPosition();
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    // Called once after isFinished returns true
    protected void end() {
        
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.arm.setGainName("");
    }
}