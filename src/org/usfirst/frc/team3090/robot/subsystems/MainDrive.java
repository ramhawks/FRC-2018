package org.usfirst.frc.team3090.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3090.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 *
 */
public class MainDrive extends Subsystem {

	//drive motor conntroller constructors
	TalonSRX frontLeft = new TalonSRX(RobotMap.talonFL);
	TalonSRX frontRight = new TalonSRX(RobotMap.talonFR);
	TalonSRX backLeft = new TalonSRX(RobotMap.talonBL);
	TalonSRX backRight = new TalonSRX(RobotMap.talonBR);

	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void drive(double speed){
    	
    }
}

