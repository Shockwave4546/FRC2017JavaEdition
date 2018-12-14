//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Subsystem.h"

public class ControlDriveTrain extends Command
{
	public ControlDriveTrain(double x, double y, double z, double timeout)
	{
		Requires(Robot.driveTrain.get());
		m_X = x;
		m_Y = y;
		m_Z = z;
		m_timeout = timeout;
	}

	// Called just before this Command runs the first time
	public final void Initialize()
	{
		SetTimeout(m_timeout);
	}

	// Called repeatedly when this Command is scheduled to run
	public final void Execute()
	{
		Robot.driveTrain.ControlDriveTrain(m_X, m_Y, m_Z, 1);
	}

	// Make this return true when this Command no longer needs to run execute()
	public final boolean IsFinished()
	{
		return IsTimedOut();
	}

	// Called once after isFinished returns true
	public final void End()
	{
		Robot.driveTrain.StopMoving();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	public final void Interrupted()
	{
		Robot.driveTrain.StopMoving();
	}
	private double m_X;
	private double m_Y;
	private double m_Z;
	private double m_timeout;
}