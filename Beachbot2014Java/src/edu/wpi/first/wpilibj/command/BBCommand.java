/**
 * 
 */
package edu.wpi.first.wpilibj.command;

import org.usfirst.frc330.Beachbot2014Java.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author allenpeters
 *
 */
public class BBCommand extends Command {

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#initialize()
	 */
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#execute()
	 */
	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#end()
	 */
	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#interrupted()
	 */
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}
	
	void _initialize(){
		super._initialize();
		System.out.println(this.getClass().getName() + "_initialize");
		Robot.logger(this.getClass().getName() + " initialized");
	}

	void _end(){
		super._end();
		Robot.logger(this.getClass().getName() + " ended");
	}
	
	void _interrupted(){
		super._interrupted();
		Robot.logger(this.getClass().getName() + " interrupted");
	}
}
