/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3090.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3090.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class SpinMotor extends Command {
	
	double EndSpeed = 0;
	double AccelCoeff = 0;
	
	
	public SpinMotor() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.singleMotor);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.singleMotor.resetEnc();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		//SmartDashboard.putNumber("EndSpeed", EndSpeed);
		//SmartDashboard.putNumber("Acceleration Coefficient", AccelCoeff);
		
		Robot.singleMotor.spin(.5, Robot.OI.controllerd.getRawAxis(1));
		SmartDashboard.putNumber("Controller Axis 1", -Robot.OI.controllerd.getRawAxis(1));
		SmartDashboard.putNumber("Controller Axis O", Robot.OI.controllerd.getRawAxis(0));
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.singleMotor.spin(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.singleMotor.spin(0, 0);
	}
}
