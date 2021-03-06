// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// C++ from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.




//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Subsystem.h"

/**
 *
 *
 * @author Garrick Craft
 */
public class ToggleRobotDirection extends Command
{

	public ToggleRobotDirection()
	{
		super();

		Requires(Robot.driveTrain.get());

	}

	public void Initialize()
	{

	}
	public void Execute()
	{
		Robot.driveTrain.ChangeDirection();
		m_done = true;
	}
	public boolean IsFinished()
	{

		return m_done;
	}
	public void End()
	{

	}
	public void Interrupted()
	{

	}


	private boolean m_done = false;

}