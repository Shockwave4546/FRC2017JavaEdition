//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Subsystem.h"

public enum Target
{
	HOOK,
	GEAR;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static Target forValue(int value)
	{
		return values()[value];
	}
}