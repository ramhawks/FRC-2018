package org.usfirst.frc.team3090.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3090.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class MainDrive extends Subsystem {

	
	
	RobotDrive driveMain;
	
		//private void DriveTrain(){
			WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.talonFL);
			WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.talonFR);
			WPI_TalonSRX backLeft = new WPI_TalonSRX(RobotMap.talonBL);
			WPI_TalonSRX backRight = new WPI_TalonSRX(RobotMap.talonBR);
			
			driveMain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
		}
		
	public void mecDrive(double y, double x, double z){
		SmartDashboard.putBoolean("elihbgewoirhbgoeiwrhbgob", true);
		SmartDashboard.putNumber("x", x);
		SmartDashboard.putNumber("y", y);
		SmartDashboard.putNumber("z", z);
		driveMain.driveCartesian(y, x, z);
		SmartDashboard.putBoolean("Finished", true);
	}
	//drive motor controller constructors
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void drive(double speed){
    	
    }
}

