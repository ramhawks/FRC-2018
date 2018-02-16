package org.usfirst.frc.team3090.robot.commands.automodes;

import org.usfirst.frc.team3090.robot.Robot;
import org.usfirst.frc.team3090.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

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
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(Robot.mainDrive.encBL.get() < Robot.OI.inchToEnc(RobotMap.auto_inches) || Robot.mainDrive.encFL.get() < Robot.OI.inchToEnc(RobotMap.auto_inches)){
    		Robot.mainDrive.mecDrive(0, .5, 0);
    	}
    	Robot.mainDrive.mecDrive(0, 0, 0);
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
