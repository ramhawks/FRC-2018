package org.usfirst.frc.team3090.robot.subsystems;

import org.usfirst.frc.team3090.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
	
	DoubleSolenoid clawPiston = new DoubleSolenoid(1, RobotMap.claw_forward, RobotMap.claw_backward);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void pistonNeutral(){
    	clawPiston.set(DoubleSolenoid.Value.kOff);
    }
    
    public void suckIn(double speedIn){
    	clawPiston.set(DoubleSolenoid.Value.kForward);
    }
    
    public void spitOut(double speedOut){
    	clawPiston.set(DoubleSolenoid.Value.kReverse);
    }
    
}

