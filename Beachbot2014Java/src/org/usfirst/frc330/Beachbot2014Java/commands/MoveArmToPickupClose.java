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
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc330.Beachbot2014Java.Robot;
/**
 *
 */
public class  MoveArmToPickupClose extends MoveArmCommand implements AutoSpreadsheetCommand {
    public MoveArmToPickupClose() {
        super(0);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        if (Robot.arm.getIsArmFront())
            setpoint = Robot.arm.getArmFrontPickup();
        else
            setpoint = Robot.arm.getArmBackPickup();
        super.initialize();
    }
    public void setParam1(double param1) {
    }
    public void setParam2(double param2) {
    }
    public void setParam3(double param3) {
    }
    public void setStopAtEnd(boolean stopAtEnd) {
    }
    public Command copy() {
        return new MoveArmToPickupClose();
    }
}
