package org.usfirst.frc.team3090.robot.commands;

import org.usfirst.frc.team3090.robot.Robot;
import org.usfirst.frc.team3090.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JeffDrive extends Command {

    public JeffDrive() {
        requires(Robot.mainDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.mainDrive.DriveTrain();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.mainDrive.jeffDrive(-Robot.OI.controllerd.getRawAxis(1) * RobotMap.drive_speed, Robot.OI.controllerd.getRawAxis(4));
    }

    // Make this return true when this Command no longer needs to run execute()
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
