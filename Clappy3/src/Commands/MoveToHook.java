//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Subsystem.h"

public class MoveToHook extends Command
{
	public MoveToHook()
	{
		Requires(Robot.gearArm.get());
	}
	public final void Initialize()
	{

	}
	public final void Execute()
	{

		if (Robot.gearArm.GetIdealPosition() == Position.GROUND)
		{
			Robot.gearArm.CloseShoot();
			Robot.gearArm.ControlGearArmMotor(0.5);
			frc.Wait(2);
		}
		else if (Robot.gearArm.GetIdealPosition() == Position.SHOOT)
		{
			Robot.gearArm.ControlGearArmMotor(0.5);
			frc.Wait(1);
		}
		Robot.gearArm.StopGearArmMotor();
		Robot.gearArm.SetIdealPosition.SWITCH;

	}
	public final boolean IsFinished()
	{
		return Robot.gearArm.GetIdealPosition() == Position.SWITCH;
	}
	public final void End()
	{

	}
	public final void Interrupted()
	{

	}
}