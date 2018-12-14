//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Subsystem.h"

public class OverrideSwitch extends Command
{
	public OverrideSwitch()
	{
		Requires(Robot.gearArm.get());
	}

	// Called just before this Command runs the first time
	public final void Initialize()
	{

	}

	// Called repeatedly when this Command is scheduled to run
	public final void Execute()
	{

		Robot.gearArm.OverrideSwitch();

	}

	// Make this return true when this Command no longer needs to run execute()
	public final boolean IsFinished()
	{
		return m_done;
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
	private boolean m_done = false;
}