package org.usfirst.frc.team3090.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3090.robot.RobotMap;
import org.usfirst.frc.team3090.robot.commands.Mecanum_Drive;

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
			
			//frontRight.setInverted(true);
			//backRight.setInverted(true);
			
			driveMain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
		}
		
	public void mecDrive(double y, double x, double z){
		//SmartDashboard.putBoolean("elihbgewoirhbgoeiwrhbgob", true);
		SmartDashboard.putNumber("x", x);
		SmartDashboard.putNumber("y", y);
		SmartDashboard.putNumber("z", z);
		if (Math.abs(y)<.15){
			y = 0;
		}
		if (Math.abs(x)<.1){
			x = 0;
		}
		if (Math.abs(z)<.1){
			z = 0;
		}
		driveMain.driveCartesian(y, x, z);
		//SmartDashboard.putBoolean("Finished", true);
	}
	//drive motor controller constructors
	
	

    public void initDefaultCommand() {
        setDefaultCommand(new Mecanum_Drive());
    }
    
    public void seperateMotors(boolean inFL, boolean inFR, boolean inBL, boolean inBR){
    	if(inFL){
    		frontLeft.set(.5);
    	}
    	if(inFR){
    		frontRight.set(.5);
    	}
    	if(inBL){
    		backLeft.set(.5);
    	}
    	if(inBR){
    		backRight.set(.5);
    	}
    }
}

