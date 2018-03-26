/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3090.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//xbox controllers								//claw speeds all positive
	public static final int devon = 0;				public static final double claw_in_speed = .5;
	public static final int oren = 1;				public static final double claw_out_speed = .5;
													
	//test board motor controllers					//scissors speeds pos and neg, acceleration positive
	public static final int spark1 = 3;				public static final double scissors_up_speed = Robot.OI.controllerd.getRawAxis(3);
	public static final int spark2 = 4;				public static final double scissors_down_speed = -Robot.OI.controllerd.getRawAxis(2);
	
	/*claw motor controllers*/						public static final double scissors_acceleration = 100;
	public static final int claw_left = 0;
	public static final int claw_right = 1;			//winch speed pos or neg
													public static final double winch_speed = 1;
	//robot drive motor controllers
	public static final int talonFL = 13;			//auto-run commands
	public static final int talonFR = 10;			public static final double run_seconds = 3;
	public static final int talonBL = 11;			public static final double run_speed = .6;
	public static final int talonBR = 12;			
	
	//robot other motor controllers					//teleop drive speed
	public static final int scissor_chain = 9;		public static final double drive_speed = .8;
	public static final int winch_motor = 15;
	public static final int forklift_motor = 14;	public static final double forklift_speed = .5;
	
	//encoders
	public static final int encFL_a = 0;
	public static final int encFL_b = 1;			public static final double auto_inches = 120;
	public static final int encFR_a = 2;
	public static final int encFR_b = 3;
	public static final int encBL_a = 4;
	public static final int encBL_b = 5;
	public static final int encBR_a = 6;
	public static final int encBR_b = 7;
	
	//claw pneumatics
	public static final int claw_piston = 1;
}
