public class MoveToTarget extends Command
{
	public MoveToTarget(Target target)
	{
		Requires(Robot.driveTrain.get());
		m_target = target;
	}
	public MoveToTarget(Target target, double minDistance)
	{
		Requires(Robot.driveTrain.get());
		m_minDistance = minDistance;
		m_target = target;
	}
	public final void Initialize()
	{
		if (m_target == Target.GEAR)
		{
			SmartDashboard.PutString("Tracker", "gear");
		}
		else
		{
			SmartDashboard.PutString("Tracker", "hook");
		}
		SmartDashboard.PutBoolean("Tracking", true);
	}
	public final void Execute()
	{
		m_distance = SmartDashboard.GetNumber("hdist", 0);
		if (m_distance > 0)
		{
			m_offset = SmartDashboard.GetNumber("offset", 0);
			Robot.driveTrain.ControlDriveTrain(0, calc.AutoYValue(m_offset, calc.DistanceWeight(m_distance, m_minDistance), 1), calc.AutoZValue(m_offset, calc.DistanceWeight(m_distance, m_minDistance), 1), 1);
		}
	}
	public final boolean IsFinished()
	{
		return m_distance - m_minDistance <= 0.5 && Math.abs(m_offset) <= 0.2;
	}
	public final void End()
	{
		Robot.driveTrain.StopMoving();
		SmartDashboard.PutBoolean("Tracking", false);
	}
	public final void Interrupted()
	{
		Robot.driveTrain.StopMoving();
		SmartDashboard.PutBoolean("Tracking", false);
	}
	private double m_minDistance = 0;
	private Target m_target;
	private double m_distance = 0;
	private double m_offset = 0;
}