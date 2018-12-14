//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Subsystem.h"

/**
 *
 *
 * @author Garrick Craft
 */
public class DriveTeleop extends Command
{

	public DriveTeleop()
	{
		super();

		Requires(Robot.driveTrain.get());

		driveStick = Robot.oi.getDriveStick();
		driveStickX = Robot.oi.getDriveStickX();

	}

	public void Initialize()
	{

	}
	public void Execute()
	{

		if (driveStick != null)
		{
			m_sens = (-0.5 * driveStick.GetRawAxis(3) + 0.5) * 5;
			m_X = -driveStick.GetRawAxis(0);
			m_Y = -driveStick.GetRawAxis(1);
			m_Z = 0.5 * -driveStick.GetRawAxis(2);
			m_Z *= calc.TwistAxisScalar(m_Y, m_Z);
		}

		if (driveStickX != null)
		{
			m_X = -driveStickX.GetX(XboxController.kLeftHand);
			m_Y = -driveStickX.GetY(XboxController.kLeftHand);
			m_Z = -driveStickX.GetX(XboxController.kRightHand);
			m_sens = 1;
		}
		Robot.driveTrain.ControlDriveTrain(m_X, m_Y, m_Z, m_sens);

	}
	public boolean IsFinished()
	{
		return false;
	}
	public void End()
	{

	}
	public void Interrupted()
	{
		Robot.driveTrain.StopMoving();
	}


	private double m_X = 0;
	private double m_Y = 0;
	private double m_Z = 0;
	private double m_scalar = 1;
	private double m_sens = 1;

	private Joystick driveStick;
	private XboxController driveStickX;

}