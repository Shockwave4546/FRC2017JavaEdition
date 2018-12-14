//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Subsystem.h"

/**
 *
 *
 * @author Garrick Craft
 */
public class ToggleGearPCM extends Command
{
	public ToggleGearPCM(PCMStatus status)
	{
		Requires(Robot.gearPCM.get());
		m_status = status;
	}
	public final void Initialize()
	{

	}
	public final void Execute()
	{

		if (m_status == PCMStatus.TOGGLE)
		{
			if (Robot.gearPCM.GetPCMStatus() == PCMStatus.OPENED)
			{
				Robot.gearPCM.SetGearPCM(PCMStatus.CLOSED);
			}
			else
			{
				Robot.gearPCM.SetGearPCM(PCMStatus.OPENED);
			}
		}
		else
		{
			Robot.gearPCM.SetGearPCM(m_status);
		}



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
	private boolean m_done = false;
	private PCMStatus m_status;
}