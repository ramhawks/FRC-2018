package org.usfirst.frc.team3090.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem {

	Ultrasonic eyes = new Ultrasonic(3, 4);
	SerialPort ears = new SerialPort(9600, SerialPort.Port.kOnboard);
	
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setAuto(){
    	eyes.setAutomaticMode(true);
    }
    
    public double rangeOfEyes(){
    	return eyes.getRangeInches();
    }
    
   
}

