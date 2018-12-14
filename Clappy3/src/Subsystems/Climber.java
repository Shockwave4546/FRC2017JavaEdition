//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Subsystem.h"
//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "WPILib.h"

public class Climber extends Subsystem
{
	// It's desirable that everything possible under private except
	// for methods that implement subsystem capabilities
	private SpeedController climbMotor;

	public Climber()
	{
		super("Climber");

		climbMotor = RobotMap.climbMotor;

	}
	public final void InitDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// SetDefaultCommand(new MySpecialCommand());
		SetDefaultCommand(new ControlClimbmotor());
	}

	public final void SetMotorSpeed(double speed)
	{
		climbMotor.Set(speed);
	}
	public final void StopMotor()
	{
		climbMotor.StopMotor();
	}
}
// Put methods for controlling this subsystem
// here. Call these from Commands.
