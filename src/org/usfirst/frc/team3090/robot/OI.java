/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3090.robot;

//import org.usfirst.frc.team3090.robot.commands.SpinMotor;
import org.usfirst.frc.team3090.robot.commands.automodes.*;
import org.usfirst.frc.team3090.robot.commands.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3090.robot.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	
	//create xbox controllers as joysticks
	public Joystick controllerd = new Joystick(RobotMap.devon);
	public Joystick controllero = new Joystick(RobotMap.oren);
	
	
	/////*****ADD ONE TO ALL BUTTON INDEXES****/////
	private JoystickButton 	clawIn_ = new JoystickButton(controllerd, 2),
	  						clawOut_ = new JoystickButton(controllerd, 3),
	  						scissorsUp_ = new JoystickButton(controllerd, 4),
	  						scissorsDown_ = new JoystickButton(controllerd, 1),
							forkliftUp_ = new JoystickButton(controllerd, 4),
							forkliftDown_ = new JoystickButton(controllerd, 1),
							forkliftUp_o = new JoystickButton(controllero, 4),
							forkliftDown_o = new JoystickButton(controllero, 1),
							clawIn_o = new JoystickButton(controllero, 2),
							clawOut_o = new JoystickButton(controllero, 3);
	
	/*public void incrementation(double increment, double min, double max){
		
		double value = min;
		
		if (controllerd.getRawButtonPressed(0) && value < max){
			value += increment;
		}
		if (controllerd.getRawButtonPressed(3) && value < max){
			value -= increment;
		}
	}*/
	
	public OI(){
		clawIn_.whenPressed(new ClawIn());
		clawOut_.whenPressed(new ClawOut());
		
		if (!Robot.forklift.limitUp.get()){
			forkliftUp_.whileHeld(new ForkliftUp());
			forkliftUp_o.whileHeld(new ForkliftUp());
		}
		
		forkliftDown_.whileHeld(new ForkliftDown());
		forkliftUp_o.whileHeld(new ForkliftUp());
		forkliftDown_o.whileHeld(new ForkliftDown());
		clawIn_o.whenPressed(new ClawIn());
		clawOut_o.whenPressed(new ClawOut());
	}
	
	public void warning(String mark){
		//DriverStation.reportWarning(mark, true);
	}
	
	public void autoQuery(String start, String end){
		switch(start + end){
		case "1Scale": Robot.autoCommand = new LeftScale(); break;
		case "1Switch": Robot.autoCommand = new LeftSwitch(); break;
		case "1Line": Robot.autoCommand = new CenterLine(); break;
		case "2Switch": Robot.autoCommand = new CenterSwitch(); break;
		case "2Line":  Robot.autoCommand = new CenterLine(); break;
		case "3Scale":  Robot.autoCommand = new RightScale(); break;
		case "3Switch": Robot.autoCommand =  new RightSwitch(); break;
		case "3Line": Robot.autoCommand =  new CenterLine(); break;
		default: Robot.autoCommand =  new NullAuto();
		}
	}
	
	public double inchToEnc(double inches){
		return inches / 3.17;
	}
	
}
