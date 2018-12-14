//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Subsystem.h"

public class ToggleSlow extends Command
{
	public ToggleSlow()
	{
		Requires(Robot.driveTrain.get());
	}

	// Called just before this Command runs the first time
	public final void Initialize()
	{

	}

	// Called repeatedly when this Command is scheduled to run
	public final void Execute()
	{
		Robot.driveTrain.ToggleSlow();
		m_done = true;
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