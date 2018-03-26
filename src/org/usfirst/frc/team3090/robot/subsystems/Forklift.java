package org.usfirst.frc.team3090.robot.subsystems;

import org.usfirst.frc.team3090.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Forklift extends Subsystem {

    WPI_TalonSRX forkliftMotor = new WPI_TalonSRX(RobotMap.forklift_motor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void forkliftUp(double speed){
    	forkliftMotor.set(speed);
    }
    
    public void forkliftDown(double speed){
    	forkliftMotor.set(-speed);
    }
}

