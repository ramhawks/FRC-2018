package org.usfirst.frc.team3090.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3090.robot.RobotMap;
import org.usfirst.frc.team3090.robot.commands.JeffDrive;
import org.usfirst.frc.team3090.robot.commands.Mecanum_Drive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class MainDrive extends Subsystem {

	public Timer driveClock = new Timer();
	
	private WPI_TalonSRX frontLeft;
	private WPI_TalonSRX frontRight;
	private WPI_TalonSRX backLeft;
	private WPI_TalonSRX backRight;
	
	//right side inverted
	public Encoder encFL = new Encoder(RobotMap.encFL_a, RobotMap.encFL_b, false, Encoder.EncodingType.k4X);
	public Encoder encFR = new Encoder(RobotMap.encFR_a, RobotMap.encFR_b, true, Encoder.EncodingType.k4X);
	public Encoder encBL = new Encoder(RobotMap.encBL_a, RobotMap.encBL_b, false, Encoder.EncodingType.k4X);
	public Encoder encBR = new Encoder(RobotMap.encBR_a, RobotMap.encBR_b, true, Encoder.EncodingType.k4X);
	
	private MecanumDrive driveMain;
	private DifferentialDrive tankDrive;
	
		public void DriveTrain(){
			
			frontLeft = new WPI_TalonSRX(RobotMap.talonFL);
			frontRight = new WPI_TalonSRX(RobotMap.talonFR);
			backLeft = new WPI_TalonSRX(RobotMap.talonBL);
			backRight = new WPI_TalonSRX(RobotMap.talonBR);
			
			SpeedControllerGroup leftSide = new SpeedControllerGroup(frontLeft, backLeft);
			SpeedControllerGroup rightSide = new SpeedControllerGroup(frontRight, backRight);
			//frontRight.setInverted(true);
			//backRight.setInverted(true);
			
			driveMain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
			tankDrive = new DifferentialDrive(leftSide, rightSide);
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
	
	public void jeffDrive(double x, double turn){
		tankDrive.arcadeDrive(x, turn);
		SmartDashboard.putNumber("speed", Math.abs(x));
		SmartDashboard.putNumber("rotations left", encFL.get());
		SmartDashboard.putNumber("rotations right", encFR.get());
		SmartDashboard.putNumber("back left", encBL.get());
		SmartDashboard.putNumber("back right", encBR.get());
	}
	//drive motor controller constructors
	
	

    public void initDefaultCommand() {
        setDefaultCommand(new JeffDrive());
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
    
    public void resetEncoders(){
    	encFL.reset();
    	encFR.reset();
    	encBL.reset();
    	encBR.reset();
    }
}

