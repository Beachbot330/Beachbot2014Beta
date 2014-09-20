package org.usfirst.frc330.Beachbot2014Java.commands;

import edu.wpi.first.wpilibj.command.CommandGroupUpdateable;

/**
 *
 */
public class ConditionalDebug extends CommandGroupUpdateable {
	static int count = 0;
    
    public  ConditionalDebug() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	setRunWhenDisabled(true);
    }
    
    protected void initialize()
    {
    	super.initialize();
    	if (count % 2 == 0)
    	{
    		addSequential(new debugOne());
    	}
    	else {
    		addSequential(new debugTwo());
    	}
    	count++;
    	System.out.println("ConditionalDebug Count: " + count);
    }
}
