//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Subsystem.h"

/**
 *
 *
 * @author Garrick Craft
 */
public class ControlGearArm extends Command
{
	public ControlGearArm()
	{
		Requires(Robot.gearArm.get());
		gearStick = Robot.oi.getGearStickX();
	}
	public ControlGearArm(double speed, double timeout)
	{
		Requires(Robot.gearArm.get());
		gearStick = null;
		m_speed = speed;
		m_timeout = timeout;
	}
	public final void Initialize()
	{
		if (m_timeout > 0)
		{
			SetTimeout(m_timeout);
		}
	}
	public final void Execute()
	{

		if (gearStick != null)
		{
			Robot.gearArm.ControlGearArmMotor(calc.DriveSpeed(-gearStick.GetY(frc.Joystick.JoystickHand.kLeftHand), 1));
		}
		else
		{
			Robot.gearArm.ControlGearArmMotor(m_speed);
		}
		if (Robot.gearArm.GetHomeSwitch() && gearStick.GetY(frc.Joystick.JoystickHand.kLeftHand) < 0)
		{
			if (Robot.gearArm.Override())
			{
				Robot.gearArm.ControlGearArmMotor(calc.DriveSpeed(-gearStick.GetY(frc.Joystick.JoystickHand.kLeftHand), 1));
			}
			else
			{
				Robot.gearArm.StopGearArmMotor();
				Robot.oi.RumbleGearGamepad(0.5);
			}
		}
		else
		{
			Robot.oi.StopGearGamepadRumble();
		}

	}
	public final boolean IsFinished()
	{
		return IsTimedOut();
	}
	public final void End()
	{
		Robot.gearArm.StopGearArmMotor();
	}
	public final void Interrupted()
	{
		Robot.gearArm.StopGearArmMotor();
	}
	private XboxController gearStick;
	private double m_speed = 0;
	private double m_timeout = -1;
}