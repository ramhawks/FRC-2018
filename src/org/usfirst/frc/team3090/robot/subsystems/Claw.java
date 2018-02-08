package org.usfirst.frc.team3090.robot.subsystems;

import org.usfirst.frc.team3090.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
	
	Spark left = new Spark(RobotMap.spark2);
	Spark right = new Spark(RobotMap.spark1);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void suckIn(){
    	left.set(.5);
    	right.set(-.5);
    }
    
    public void spitOut(){
    	left.set(-.5);
    	right.set(.5);
    }
    
}

