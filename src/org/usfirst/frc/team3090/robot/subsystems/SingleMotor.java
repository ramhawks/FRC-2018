/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3090.robot.subsystems;

import org.usfirst.frc.team3090.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class SingleMotor extends Subsystem {
	
	//make the test motor
	//Spark motor = new Spark(RobotMap.spark2);
	
	//make the encoder
	Encoder howSpinny = new Encoder(8, 9, false, Encoder.EncodingType.k4X);

	//make a timer
	Timer SMClock = new Timer();
	
	
	public void initDefaultCommand() {
		
	}
	
	//spin function for quick tests
	public void spin(double speed, double input){
		//motor.set(speed * -input);
		SmartDashboard.putNumber("How Spinny?", howSpinny.get());
		SmartDashboard.putNumber("How Rotations?", (double)howSpinny.get() / 20);
	}
	
	public void resetEnc(){
		howSpinny.reset();
	}
	
	//increaseToSpin function for testing speed increasing while pressing button until set end speed
	/*public void increaseToSpin(double endSpeed, double accelCoeff, boolean inpt){
		
		double direction = Math.abs(endSpeed) / endSpeed;
		
		if(Math.abs(endSpeed) > 1){
			DriverStation.reportWarning("endSpeed must be between -1 and 1", true);
			input = false;
		}
		
		if(accelCoeff <= 0){
			DriverStation.reportWarning("accelCoeff must be greater than 0", true);
			input = false;
		}
		
		if(input){
			//clock init
			SMClock.reset();
			SMClock.start();
			//local variable for end power set to motor
			double power = 0;
			//loop increase in speed until reaches end speed
			while(Math.abs(power) < Math.abs(endSpeed)){
				//function for figuring power as accelerating, 
				//accelCoeff is how fast motor speeds up, must be positive
				power = accelCoeff * SMClock.get();
				motor.set(power * direction);
			}
			//once at end speed, stay at end speed (needs to be between -1 and 1)
			motor.set(endSpeed);
		}
	}*/	
}
