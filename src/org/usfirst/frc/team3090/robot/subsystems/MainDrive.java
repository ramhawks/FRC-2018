package org.usfirst.frc.team3090.robot.subsystems;

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

	private WPI_TalonSRX frontLeft;
	private WPI_TalonSRX frontRight;
	private WPI_TalonSRX backLeft;
	private WPI_TalonSRX backRight;
	
	private MecanumDrive driveMain;
	
		public void DriveTrain(){
			
			frontLeft = new WPI_TalonSRX(RobotMap.talonFL);
			frontRight = new WPI_TalonSRX(RobotMap.talonFR);
			backLeft = new WPI_TalonSRX(RobotMap.talonBL);
			backRight = new WPI_TalonSRX(RobotMap.talonBR);
			
			driveMain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
		}
		
	public void mecDrive(double y, double x, double z){
		SmartDashboard.putBoolean("elihbgewoirhbgoeiwrhbgob", true);
		SmartDashboard.putNumber("x", x);
		SmartDashboard.putNumber("y", y);
		SmartDashboard.putNumber("z", z);
		if (y<.1){
			y = 0;
		}
		if (x<.1){
			x = 0;
		}
		if (z<.1){
			z = 0;
		}
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

