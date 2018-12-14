//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include <Commands/Subsystem.h>
//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "WPILib.h"

public enum Position
{
	GROUND,
	SHOOT,
	SWITCH,
	NOT_INITIALIZED,
	MOVING;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static Position forValue(int value)
	{
		return values()[value];
	}
}