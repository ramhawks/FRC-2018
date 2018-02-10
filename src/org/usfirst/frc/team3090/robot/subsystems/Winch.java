package org.usfirst.frc.team3090.robot.subsystems;

import org.usfirst.frc.team3090.robot.RobotMap;
import org.usfirst.frc.team3090.robot.commands.FaceTheBoss;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {

    WPI_TalonSRX winchMotor = new WPI_TalonSRX(RobotMap.winch_motor);

    public void initDefaultCommand() {
        setDefaultCommand(new FaceTheBoss());
    }
    
    public void faceTheBoss(double input){
    	winchMotor.set(input * RobotMap.winch_speed);
    }
}

