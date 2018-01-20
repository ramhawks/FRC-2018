package org.usfirst.frc.team3090.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

import org.usfirst.frc.team3090.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class MainDrive extends Subsystem {

	
	
	private MecanumDrive driveMain;
	
		private void DriveTrain(){
			WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.talonFL);
			WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.talonFR);
			WPI_TalonSRX backLeft = new WPI_TalonSRX(RobotMap.talonBL);
			WPI_TalonSRX backRight = new WPI_TalonSRX(RobotMap.talonBR);
			
			driveMain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
		}
		
	public void mecDrive(double y, double x, double z){
		driveMain.driveCartesian(y, x, z);
	}
	//drive motor controller constructors
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void drive(double speed){
    	
    }
}

