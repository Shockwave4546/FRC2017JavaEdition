//====================================================================================================
//The Free Edition of C++ to Java Converter limits conversion output to 100 lines per file.

//To subscribe to the Premium Edition, visit our website:
//https://www.tangiblesoftwaresolutions.com/order/order-cplus-to-java.html
//====================================================================================================

//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Subsystem.h"
//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "WPILib.h"

public enum Direction
{
	FORWARD,
	REVERSE;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static Direction forValue(int value)
	{
		return values()[value];
	}
}