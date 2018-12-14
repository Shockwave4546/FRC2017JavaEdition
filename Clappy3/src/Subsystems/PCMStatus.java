//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Subsystem.h"
//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "WPILib.h"

public enum PCMStatus
{
	OPENED,
	CLOSED,
	TOGGLE;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static PCMStatus forValue(int value)
	{
		return values()[value];
	}
}