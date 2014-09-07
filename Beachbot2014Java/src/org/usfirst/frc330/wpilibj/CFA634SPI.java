/* Not used for now

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc330.wpilibj;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.*;
/*
 * $Log: CFA634SPI.java,v $
 * Revision 1.1  2013-02-09 02:07:19  jross
 * Add LCD
 *
 * Revision 1.1  2013-01-28 03:14:08  jross
 * Working implementation of the CFA-634 spi API
 *
 */
/**
 *
 * @author joe
 */
public class CFA634SPI extends LCDInterface {

    private SPI spi = null;
    

    /**
     * Create a new device on the SPI bus.<br>The chip select line is active low
     *
     * @param slot The module of the digital output for the device's chip select pin
     * @param csChannel	The channel for the digital output for the device's chip select pin
     */
    public CFA634SPI(SPI.Port port) {
        spi = new SPI(port);
        setSPIParams();
    }
    
        
    private void setSPIParams() {
    	spi.setMSBFirst();
//        spi.setBitOrder(SPI.BIT_ORDER_MSB_FIRST);
    	spi.setChipSelectActiveLow();
//        spi.setClockPolarity(SPI.CLOCK_POLARITY_ACTIVE_LOW);
    	spi.setSampleDataOnFalling();
//        spi.setDataOnTrailing(SPI.DATA_ON_TRAILING_EDGE);

//        spi.setFrameMode(SPI.FRAME_MODE_CHIP_SELECT); //TODO can't find a method

        spi.setClockRate(8000);
    }

    public void println(Line line, int startingColumn, String text)
    {
//        int[] numBits = new int[20-startingColumn];
        byte[] bytes = new byte[20-startingColumn];
        
        for (int i = 0; i < text.length(); i++)
        {
//            numBits[i] = 8;
            bytes[i] = (byte)text.charAt(i);
        }
        for (int i = text.length(); i < 20-startingColumn; i++)
        {
            if (i<20)
            {
//                numBits[i] = 8;
                bytes[i] = 0x20;
            }
        }
       
        setCursorPosition(line, startingColumn);

//        spi.transfer(bytes, numBits);
        spi.write(bytes, bytes.length);
    }

    
    public void print(Line line, int startingColumn, String text) {
//        int[] numBits = new int[text.length()];
        byte[] bytes = new byte[text.length()];
        
        for (int i = 0; i < text.length(); i++)
        {
//            numBits[i] = 8;
            bytes[i] = (byte)text.charAt(i);
        }
       
        setCursorPosition(line, startingColumn);

//        spi.transfer(bytes, numBits);
        spi.write(bytes, bytes.length);
    }
    
    
    public void cursorHome()
    {
    	byte[] data = new byte[1];
    	data[0] = 1;
//        spi.transfer(1, 8);
    	spi.write(data, 1);
    }
    
    
    public void hideCursor()
    {
    	byte[] data = new byte[1];
    	data[0] = 4;
        spi.write(data, 1);
    }
    
    
    public void backspace()
    {
    	byte[] data = new byte[1];
    	data[0] = 8;
        spi.write(data, 1);
//        spi.transfer(8, 8);
    }
    
    
    public void lineFeed()
    {
    	byte[] data = new byte[1];
    	data[0] = 10;
        spi.write(data, 1);
//        spi.transfer(10, 8);
    }
    
    
    public void deleteInPlace()
    {
    	byte[] data = new byte[1];
    	data[0] = 11;
        spi.write(data, 1);
//        spi.transfer(11, 8);
    }
    
    
    public void clearScreen()
    {
    	byte[] data = new byte[1];
    	data[0] = 12;
        spi.write(data, 1);
//        spi.transfer(12, 8);
    }
    
    
    public void carriageReturn()
    {
    	byte[] data = new byte[1];
    	data[0] = 13;
        spi.write(data, 1);
//        spi.transfer(13, 8);
    }
    
    
    public void scrollOff()
    {
    	byte[] data = new byte[1];
    	data[0] = 20;
        spi.write(data, 1);    	
//        spi.transfer(20, 8);
    }
    
    
    public void wrapOff()
    {
    	byte[] data = new byte[1];
    	data[0] = 24;
        spi.write(data, 1);
//       spi.transfer(24, 8);
    }
    
    private void setCursorPosition(Line line, int column)
    {
    	byte[] data = new byte[3];
    	data[0] = 17;
    	data[1] = (byte) column;
    	data[2] = (byte) line.value;
        spi.write(data, 3);
//        spi.transfer(17, 8);
//        spi.transfer(column, 8);
//        spi.transfer(line.value, 8);
    }
    
    
}
