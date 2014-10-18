// For reading and writing from a realtime clock

package org.usfirst.frc330.Beachbot2014Java.subsystems;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import org.usfirst.frc330.Beachbot2014Java.RobotMap;
import org.usfirst.frc330.Beachbot2014Java.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Clock extends Subsystem {

    final int ClockAddress = 33<<1; //Currently set to LED Arduino value TODO: Update
    
    I2C rtc = new I2C(Port.kOnboard,ClockAddress);  
    int data = 0;
    byte[] receivedData = new byte[4];
    byte[] prevData = new byte[4];
    
    public Clock() {
        super();
        prevData[0] = 1;
        prevData[1] = -1;
        prevData[2] = 114;
        prevData[3] = 0;
        
    }
    
    public long currentTimeMillis(){
    	return 0;
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        //setDefaultCommand(new HandleLEDs());
    }
       
    public void readSmartDashboard() {
        
        data = (int) SmartDashboard.getNumber("Arduino/Value",0);
        if (data != 0) {
            receivedData[0] = (byte)((data & 0xFF000000) >> 24);
            receivedData[1] = (byte)((data & 0x00FF0000) >> 16);
            receivedData[2] = (byte)((data & 0x0000FF00) >> 8);
            receivedData[3] = (byte)((data & 0x000000FF));
            System.out.println("ReceivedData: " + data + " " + receivedData[0] + " " + receivedData[1] + " " + receivedData[2] + " " + receivedData[3]);
// TODO: LED's            arduino.transaction(receivedData, receivedData.length, null, 0);
            SmartDashboard.putNumber("Arduino/Value",0);
            if (receivedData[0] == 1) {
//                prevData = (byte[]) receivedData.clone();
                prevData[0] = receivedData[0];
                prevData[1] = receivedData[1];
                prevData[2] = receivedData[2];
                prevData[3] = receivedData[3];
            }
        }
    }
    
    public void setRed() {
        receivedData[0] = 1;
        receivedData[1] = -1;
        receivedData[2] = 0;
        receivedData[3] = 0;
// TODO: LED's        arduino.transaction(receivedData, receivedData.length, null, 0);
    }
    
    public void setGreen() {
        receivedData[0] = 1;
        receivedData[1] = 0;
        receivedData[2] = -1;
        receivedData[3] = 0;
    }
    
    public void setBlue() {
        receivedData[0] = 1;
        receivedData[1] = 0;
        receivedData[2] = 0;
        receivedData[3] = -1;
    }
}
