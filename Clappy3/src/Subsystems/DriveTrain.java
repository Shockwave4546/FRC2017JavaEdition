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

public enum DriveMotor
{
	TOP_LEFT,
	TOP_RIGHT,
	BOTTOM_LEFT,
	BOTTOM_RIGHT,
	CENTER;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static DriveMotor forValue(int value)
	{
		return values()[value];
	}
}

/**
 *
 *
 * @author Garrick Craft
 */
public class DriveTrain extends Subsystem
{

	private SpeedController topLeft;
	private SpeedController topRight;
	private SpeedController bottomLeft;
	private SpeedController bottomRight;
	private SpeedController center;
	private Direction m_direction;
	private Slow m_slow;
	private double right_res = 0;
	private double left_res = 0;
	private double ratio = 1;

	public DriveTrain()
	{
		super("DriveTrain");

		topLeft = RobotMap.driveTrainTopLeft;
		topRight = RobotMap.driveTrainTopRight;
		bottomLeft = RobotMap.driveTrainBottomLeft;
		bottomRight = RobotMap.driveTrainBottomRight;
		center = RobotMap.driveTrainCenter;

		m_direction = Direction.FORWARD;
		m_slow = Slow.DEACTIVATED;

	}

	public final void InitDefaultCommand()
	{

		SetDefaultCommand(new DriveTeleop());
		m_direction = Direction.FORWARD;
		m_slow = Slow.DEACTIVATED;

	}

	public final void ControlDriveTrain(double x, double y, double z, double sens)
	{
		if (m_slow == Slow.ACTIVATED)
		{
			z = 0;
			Robot.oi.RumbleDriveGamepad(0.5);
		}
		else
		{
			Robot.oi.StopDriveGamepadRumble();
		}
		right_res = calc.DriveSpeed(calc.DriveMotorRight(y, z), sens);
		left_res = calc.DriveSpeed(calc.DriveMotorLeft(y, z), sens);
		if (m_direction == Direction.FORWARD)
		{
			/*
			if (right_res < 0)
				right_res *= 0.9;
			if (left_res > 0)
				left_res *= 0.9;
				*/
			topLeft.Set(left_res);
			topRight.Set(right_res);
			bottomLeft.Set(left_res);
			bottomRight.Set(right_res);
			//center->Set(x);
		}
		else
		{
			/*
			if (right_res > 0)
				right_res *= 0.9;
			if (left_res < 0)
				left_res *= 0.9;
				*/
			topLeft.Set(-right_res);
			topRight.Set(-left_res);
			bottomLeft.Set(-right_res);
			bottomRight.Set(-left_res);
			//center->Set(-x);
		}

		SmartDashboard.PutNumber("topLeft", left_res); //topLeft->Get());
		SmartDashboard.PutNumber("topRight", right_res); //topRight->Get());
		SmartDashboard.PutNumber("bottomLeft", bottomLeft.Get());
		SmartDashboard.PutNumber("bottomRight", bottomRight.Get());
		SmartDashboard.PutNumber("center", center.Get());
		SmartDashboard.PutNumber("y", y);
		SmartDashboard.PutNumber("z", z);

	}

	public final void StopMoving()
	{
		topLeft.StopMotor();
		topRight.StopMotor();
		bottomLeft.StopMotor();
		bottomRight.StopMotor();
		center.StopMotor();
	}

	public final void ChangeDirection()
	{
		if (m_direction == Direction.FORWARD)
		{
			m_direction = Direction.REVERSE;
		}
		else
		{
			m_direction = Direction.FORWARD;
		}
	}

	public final void SetDirection(Direction direction)
	{
		m_direction = direction;
	}

	public final void ToggleSlow()
	{
		if (m_slow == Slow.ACTIVATED)
		{
			m_slow = Slow.DEACTIVATED;
		}
		else
		{
			m_slow = Slow.ACTIVATED;
		}
	}

	public final void SetSlow(Slow slow)
	{
		m_slow = slow;
	}


	public final int GetDirection()
	{
		return m_direction;
	}

	public final String GetDirectionS()
	{
		if (m_direction == Direction.FORWARD)
		{

//====================================================================================================
//End of the allowed output for the Free Edition of C++ to Java Converter.

//To subscribe to the Premium Edition, visit our website:
//https://www.tangiblesoftwaresolutions.com/order/order-cplus-to-java.html
//====================================================================================================
