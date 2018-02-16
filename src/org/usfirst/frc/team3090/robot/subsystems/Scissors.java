package org.usfirst.frc.team3090.robot.subsystems;

import org.usfirst.frc.team3090.robot.RobotMap;
import org.usfirst.frc.team3090.robot.commands.ScissorsUp;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Scissors extends Subsystem {

    //WPI_TalonSRX scissorChain = new WPI_TalonSRX(RobotMap.scissor_chain);
	Spark scissorChain = new Spark(RobotMap.scissor_chain);
	
    Timer SMClock = new Timer();
    
    public void initDefaultCommand() {
        setDefaultCommand(new ScissorsUp());
    }
    
    public void scissorsMove(double endSpeed, double accelCoeff){
    	
    	boolean run = true;
    	double direction = Math.abs(endSpeed) / endSpeed;
		
		if(Math.abs(endSpeed) > 1){
			DriverStation.reportWarning("endSpeed must be between -1 and 1", true);
			run = false;
		}
		
		if(accelCoeff <= 0){
			DriverStation.reportWarning("accelCoeff must be greater than 0", true);
			run = false;
		}
		
		if(run){
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
				scissorChain.set(power * direction);
			}
			//once at end speed, stay at end speed (needs to be between -1 and 1)
			scissorChain.set(endSpeed);
		}
    }
}

