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
	
	//controllers
	public static final int devon = 0;
	public static final int oren = 1;
	
	//test board motor controllers
	public static final int spark1 = 3;
	public static final int spark2 = 4;
	
	public static final int claw_left = 0;
	public static final int claw_right = 1;
	
	//robot drive motor controllers
	public static final int talonFL = 13;
	public static final int talonFR = 10;
	public static final int talonBL = 11;
	public static final int talonBR = 12;
}
