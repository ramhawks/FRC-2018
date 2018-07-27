package org.usfirst.frc.team3090.robot.subsystems;

import org.usfirst.frc.team3090.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Forklift extends Subsystem {

    WPI_TalonSRX forkliftMotor = new WPI_TalonSRX(RobotMap.forklift_motor);
    public DigitalInput limitUp = new DigitalInput(RobotMap.limit_up);
    //DigitalInput limitDown = new DigitalInput(RobotMap.limit_down)

    public void initDefaultCommand() {
        
    }
    
    public void forkliftUp(double speed){
    	
    	//if(!limitUp.get()){
    		forkliftMotor.set(speed);
    	//}
    }
    
    public void forkliftDown(double speed){
    	//if(!limitDown.get()){
    		forkliftMotor.set(-speed);
    	//}
    }
}