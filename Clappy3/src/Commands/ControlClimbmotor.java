//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Subsystem.h"

public class ControlClimbmotor extends Command
{
	public ControlClimbmotor()
	{
		// Use Requires() here to declare subsystem dependencies
		// eg. Requires(Robot::chassis.get());
		Requires(Robot.climber.get());
		gearStickX = Robot.oi.getGearStickX();
	}

	// Called just before this Command runs the first time
	public final void Initialize()
	{

	}

	// Called repeatedly when this Command is scheduled to run
	public final void Execute()
	{

		Robot.climber.SetMotorSpeed(-gearStickX.GetTriggerAxis(Joystick.JoystickHand.kLeftHand));

	}

	// Make this return true when this Command no longer needs to run execute()
	public final boolean IsFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	public final void End()
	{

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	public final void Interrupted()
	{

	}
	private XboxController gearStickX;
	private Joystick gearStick;
}