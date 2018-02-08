/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3090.robot;

import org.usfirst.frc.team3090.robot.commands.SpinMotor;

import org.usfirst.frc.team3090.robot.commands.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	//create xbox controllers as joysticks
	public Joystick controllerd = new Joystick(RobotMap.devon);
	public Joystick controllero = new Joystick(RobotMap.oren);
	
	//private JoystickButton clawIn = new JoystickButton(controllerd, 0)
	//private JoystickButton clawOut = new JoystickButton(controllerd, 3);
	
	/*public void incrementation(double increment, double min, double max){
		
		double value = min;
		
		if (controllerd.getRawButtonPressed(0) && value < max){
			value += increment;
		}
		if (controllerd.getRawButtonPressed(3) && value < max){
			value -= increment;
		}
	}*/
	
	//public OI(){
		//clawIn.whileHeld(new ClawIn());
		//clawOut.whileHeld(new ClawOut());
	//}
	
	public void warning(String mark){
		DriverStation.reportError(mark, true);
	}
	
}
