//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Subsystem.h"

public class MoveToGround extends Command
{
	public MoveToGround()
	{
		Requires(Robot.gearArm.get());
	}
	public final void Initialize()
	{

	}
	public final void Execute()
	{

		if (Robot.gearArm.GetIdealPosition() != Position.GROUND)
		{
			if (Robot.gearArm.GetIdealPosition() == Position.SHOOT)
			{
				Robot.gearArm.ControlGearArmMotor(0.5);
				frc.Wait(0.5);
				Robot.gearArm.StopGearArmMotor();
			}
			Robot.gearArm.CloseShoot();
			Robot.gearArm.ControlGearArmMotor(-0.5);
			frc.Wait(1);
			Robot.gearArm.SetIdealPosition.GROUND;
		}

	}
	public final boolean IsFinished()
	{
		return Robot.gearArm.GetIdealPosition() == Position.GROUND;
	}
	public final void End()
	{

	}
	public final void Interrupted()
	{

	}
}