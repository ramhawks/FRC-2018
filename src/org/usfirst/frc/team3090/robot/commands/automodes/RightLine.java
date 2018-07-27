package org.usfirst.frc.team3090.robot.commands.automodes;

import org.usfirst.frc.team3090.robot.Robot;
import org.usfirst.frc.team3090.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RightLine extends Command {

    public RightLine() {
        requires(Robot.mainDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.mainDrive.resetEncoders();
    	Robot.OI.warning("Running Right Line");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//while(Robot.mainDrive.encBL.get() < Robot.OI.inchToEnc(RobotMap.auto_inches) || Robot.mainDrive.encFL.get() < Robot.OI.inchToEnc(RobotMap.auto_inches)){
    		Robot.mainDrive.jeffDrive(RobotMap.run_speed, 0);
    		Robot.OI.warning("Right Line - Driving Forward");
    	//}
    	Robot.mainDrive.jeffDrive(0, 0);
    	Robot.OI.warning("Right Line - Stopping");
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
