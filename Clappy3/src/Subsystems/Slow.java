public enum Slow
{
	ACTIVATED,
	DEACTIVATED;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static Slow forValue(int value)
	{
		return values()[value];
	}
}