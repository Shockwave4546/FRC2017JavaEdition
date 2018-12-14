//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Subsystem.h"

public class SetShoot extends Command
{
	public SetShoot(Direction direction)
	{
		Requires(Robot.gearArm.get());
		m_direction = direction;
	}
	public final void Initialize()
	{

		if (m_direction == Direction.FORWARD)
		{
			if (!Robot.gearArm.Override())
			{
				if (Robot.gearArm.GetHomeSwitch())
				{
					Robot.gearArm.OpenShoot();
				}
				else
				{
					Robot.oi.RumbleGearGamepad(1);
					frc.Wait(0.5);
					Robot.oi.StopGearGamepadRumble();
				}
			}
			else
			{
				Robot.gearArm.OpenShoot();
			}
		}
		else
		{
			if (!Robot.gearArm.Override())
			{
				if (Robot.gearArm.GetHomeSwitch())
				{
					Robot.gearArm.CloseShoot();
				}
				else
				{
					Robot.oi.RumbleGearGamepad(1);
					frc.Wait(0.5);
					Robot.oi.StopGearGamepadRumble();
				}
			}
			else
			{
				Robot.gearArm.CloseShoot();
			}
		}

	}
	public final void Execute()
	{

		m_done = true;

	}
	public final boolean IsFinished()
	{
		return m_done;
	}
	public final void End()
	{

	}
	public final void Interrupted()
	{

	}
	private Direction m_direction;
	private boolean m_done = false;
}