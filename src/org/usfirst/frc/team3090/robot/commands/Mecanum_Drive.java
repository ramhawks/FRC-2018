package org.usfirst.frc.team3090.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3090.robot.Robot;

/**
 *
 */
public class Mecanum_Drive extends Command {

    public Mecanum_Drive() {
        requires(Robot.mainDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.mainDrive.mecDrive(Robot.OI.controllerd.getRawAxis(0), -Robot.OI.controllerd.getRawAxis(1), Robot.OI.controllerd.getRawAxis(4));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.mainDrive.mecDrive(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.mainDrive.mecDrive(0, 0, 0);
    }
}
