package org.usfirst.frc.team3090.robot.commands;

import org.usfirst.frc.team3090.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SeperateMotors extends Command {

    public SeperateMotors() {
        requires(Robot.mainDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.mainDrive.seperateMotors(Robot.OI.controllerd.getRawButton(3), Robot.OI.controllerd.getRawButton(4), Robot.OI.controllerd.getRawButton(1), Robot.OI.controllerd.getRawButton(2));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.mainDrive.seperateMotors(false, false, false, false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.mainDrive.seperateMotors(false, false, false, false);
    }
}
