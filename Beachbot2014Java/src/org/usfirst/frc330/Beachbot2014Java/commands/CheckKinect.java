/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc330.Beachbot2014Java.commands;

import org.usfirst.frc330.Beachbot2014Java.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Check the Kinect arm positions and save the value in the OI class so that
 * it can be utilized for subsequent commands.
 * 
 */
public class CheckKinect extends Command {

    protected void initialize() {
    }

    protected void execute() {
        Robot.oi.checkKinect();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
