package org.usfirst.frc.team3090.robot.commands;

import org.usfirst.frc.team3090.robot.Robot;
import org.usfirst.frc.team3090.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ForkliftDown extends Command {

    public ForkliftDown() {
        requires(Robot.forklift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.forklift.forkliftDown(RobotMap.forklift_speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.forklift.forkliftUp(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.forklift.forkliftUp(0);
    }
}
