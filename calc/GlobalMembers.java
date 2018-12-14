package calc;

public class GlobalMembers
{
	/*
	 * Calculations.cpp
	 *
	 *  Created on: Feb 19, 2017
	 *      Author: Garrick Craft
	 */

	/*
	 * Calculations.h
	 *
	 *  Created on: Feb 19, 2017
	 *      Author: Garrick Craft
	 */


	public static double DriveSpeed(double input, double sens)
	{
		return sens * Math.pow(input, 3);
	}
	public static double DriveMotorLeft(double y, double z)
	{
		return y - z;
	}
	public static double DriveMotorRight(double y, double z)
	{
		return y + z;
	}
	public static double TwistAxisScalar(double y, double z)
	{
		return Math.abs((2 / (1 + Math.exp((y == 0) ? z / 0.01 : z / y)) - 1));
	}
	public static double AutoZValue(double offset, double distanceWeight, double functionWeight)
	{
		return (2 * functionWeight * distanceWeight / (1 + Math.exp(-5 * offset))) - functionWeight * distanceWeight;
	}
	public static double AutoYValue(double offset, double distanceWeight, double functionWeight)
	{
		return (offset < 1) ? functionWeight * distanceWeight * Math.pow(offset + 1, 2) : functionWeight * distanceWeight * Math.pow(offset - 1, 2);
	}
	public static double DistanceWeight(double distance, double minimum)
	{
		return 2 / (1 + Math.exp(3 - 3 * distance / (minimum == 0) ? 1 : minimum)) - 1;
	}
}