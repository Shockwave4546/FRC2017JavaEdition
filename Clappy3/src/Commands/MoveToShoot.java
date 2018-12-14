//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Subsystem.h"

public class MoveToShoot extends Command
{
	public MoveToShoot()
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
			frc.Wait(1.5);
			Robot.gearArm.StopGearArmMotor();
			Robot.gearArm.OpenShoot();
			Robot.gearArm.ControlGearArmMotor(-0.5);
			frc.Wait(0.5);
		}
		else if (Robot.gearArm.GetIdealPosition() == Position.SWITCH)
		{
			Robot.gearArm.OpenShoot();
			Robot.gearArm.ControlGearArmMotor(-0.5);
			frc.Wait(0.5);
			Robot.gearArm.StopGearArmMotor();
		}

		Robot.gearArm.SetIdealPosition.SHOOT;
	}
	public final boolean IsFinished()
	{
		return Robot.gearArm.GetIdealPosition() == Position.SHOOT;
	}
	public final void End()
	{

	}
	public final void Interrupted()
	{

	}
}