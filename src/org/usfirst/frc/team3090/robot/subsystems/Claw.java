package org.usfirst.frc.team3090.robot.subsystems;

import org.usfirst.frc.team3090.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
	
	Spark left = new Spark(RobotMap.claw_left);
	Spark right = new Spark(RobotMap.claw_right);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void suckIn(double speedIn){
    	left.set(speedIn);
    	right.set(speedIn * -1);
    }
    
    public void spitOut(double speedOut){
    	left.set(speedOut * -1);
    	right.set(speedOut);
    }
    
}

