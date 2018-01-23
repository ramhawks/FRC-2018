package org.usfirst.frc.team3090.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3090.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class TestTheStupidNoWorkyMotorsUgh extends Subsystem {

	WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.talonFL);
	WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.talonFR);
	WPI_TalonSRX backLeft = new WPI_TalonSRX(RobotMap.talonBL);
	WPI_TalonSRX backRight = new WPI_TalonSRX(RobotMap.talonBR);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void spinTheMotors(double input){
    	frontLeft.set(input * .5);
    }
}

