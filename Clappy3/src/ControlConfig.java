//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "WPILib.h"

public enum ControlConfig
{
	JOYSTICK,
	XBOXCONTOLLER,
	DISABLED;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static ControlConfig forValue(int value)
	{
		return values()[value];
	}
}