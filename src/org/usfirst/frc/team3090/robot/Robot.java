/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3090.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3090.robot.subsystems.*;
import org.usfirst.frc.team3090.robot.commands.*;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	public static Command autoCommand;
	public String plates;
	
	//subsystems
	//public static final SingleMotor singleMotor = new SingleMotor();
	public static final MainDrive mainDrive = new MainDrive();

	//public static final TestTheStupidNoWorkyMotorsUgh stupidUgh = new TestTheStupidNoWorkyMotorsUg(
	
	//public static final Sensors sensors = new Sensors();
	public static final Claw claw = new Claw();
	//public static final Winch winch = new Winch();
	//public static final Scissors scissors = new Scissors();
	public static final Forklift forklift = new Forklift();
	
	////////*****ALWAYS INIT OI AFTER SUBSYSTEMS*******///////
	public static final OI OI = new OI();
	
	//choosers
	SendableChooser<String> startChooser = new SendableChooser<>();
	SendableChooser<String> endChooser = new SendableChooser<>();
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		//SmartDashboard.putData("Spin Motor", new SpinMotor());
		SmartDashboard.putData(claw);
		SmartDashboard.putData(mainDrive);
		SmartDashboard.putData("Seperate Motors", new SeperateMotors());
		
		//SmartDashboard.putData("UGH", new SpinStupidMotor());
		//SmartDashboard.putData("claw", new Claw());
		//SmartDashboard.putData("SensoryTest", new SensoryTest())
		
		//objects for starting position chooser
		startChooser.addDefault("1", "1");
		startChooser.addObject("2", "2");
		startChooser.addObject("3", "3");
		
		//objects for end position chooser
		endChooser.addDefault("Nicht", "Nicht");
		endChooser.addObject("Switch", "Switch");
		endChooser.addObject("Scale", "Scale");
		endChooser.addObject("Line", "Line");
		
		//Display choosers
		SmartDashboard.putData("Starting Position", startChooser);
		SmartDashboard.putData("Ending Position", endChooser);
		
		
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		plates = DriverStation.getInstance().getGameSpecificMessage();
		OI.autoQuery(startChooser.getSelected(), endChooser.getSelected());
		autoCommand.start();
	}	
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	
	public void testInit() {
		
	}
	
	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
	}
}
