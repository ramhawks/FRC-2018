package org.usfirst.frc.team3090.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3090.robot.Robot;

/**
 *
 */
public class Mecanum_Drive extends Command {

	private boolean excecution;
	
	//set the speed for the mec drive
	double driveSpeed = .5;
	
    public Mecanum_Drive() {
        requires(Robot.mainDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.mainDrive.DriveTrain();
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	excecution = true;
    	SmartDashboard.putBoolean("excecution", excecution);
    	Robot.mainDrive.mecDrive(Robot.OI.controllerd.getRawAxis(0) * driveSpeed, -Robot.OI.controllerd.getRawAxis(1) * driveSpeed, Robot.OI.controllerd.getRawAxis(4) * driveSpeed);
    	SmartDashboard.putNumber("the y value", Robot.OI.controllerd.getRawAxis(0));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.mainDrive.mecDrive(0, 0, 0);
    	excecution = false;
    	SmartDashboard.putBoolean("excecution", excecution);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.mainDrive.mecDrive(0, 0, 0);
    }
   
}
