package org.usfirst.frc.team3090.robot.commands.automodes;

import org.usfirst.frc.team3090.robot.Robot;
import org.usfirst.frc.team3090.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CenterLine extends Command {

	
	
    public CenterLine() {
        requires(Robot.mainDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.mainDrive.resetEncoders();
    	Robot.OI.warning("Running Center Line");
    	Robot.mainDrive.driveClock.reset();
    	Robot.mainDrive.driveClock.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    	while(Robot.mainDrive.driveClock.get() < RobotMap.run_seconds){
    		Robot.mainDrive.jeffDrive(RobotMap.run_speed, 0);
    		//Robot.OI.warning("Center Line - Driving forward")
    		//SmartDashboard.putNumber("Encoder", Robot.mainDrive.encFL.get())
    		//SmartDashboard.putNumber("Encoder", Robot.mainDrive.encFR.get())
    		SmartDashboard.putNumber("timer", Robot.mainDrive.driveClock.get());
    	}
    	Robot.mainDrive.jeffDrive(0, 0);
    	Robot.OI.warning("Center Line - Stopping");
    }

    // Make this return true when this Command no longer needs to run execut
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.mainDrive.jeffDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.mainDrive.jeffDrive(0, 0);
    }
}
