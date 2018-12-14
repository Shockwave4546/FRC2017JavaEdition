/**
 *
 *
 * @author Garrick Craft
 */
public class GearArm extends Subsystem
{

	private SpeedController gearArmMotor;
	private Encoder encoder;
	private DigitalInput homeSwitch;
	private DoubleSolenoid solenoid;
	private Position m_idealPosition;
	private boolean s_override = false;
	private boolean SolenoidP()
	{
		return solenoid != null;
	}


	public GearArm()
	{
		super("GearArm");

		gearArmMotor = RobotMap.gearArmMotor;
		encoder = RobotMap.gearArmEncoder;
		homeSwitch = RobotMap.gearArmSwitch;
		solenoid = RobotMap.gearShootSolenoid;

		m_idealPosition = Position.NOT_INITIALIZED;

		//CloseShoot();

	}

	public final void InitDefaultCommand()
	{

		SetDefaultCommand(new ControlGearArm());
	}

	public final void ControlGearArmMotor(double speed)
	{
		if (speed > 0 && GetHomeSwitch())
		{
			StopGearArmMotor();
		}
		else if (speed > 0)
		{
			gearArmMotor.Set(speed * 0.75);
		}
		else
		{
			gearArmMotor.Set(speed * 0.5);
		}
	}
	public final void SetIdealPosition(Position position)
	{
		m_idealPosition = position;
	}
	public final void StopGearArmMotor()
	{
		gearArmMotor.StopMotor();
	}

	public final void OverrideSwitch()
	{
		s_override = true;
	}


	public final void OpenShoot()
	{
		if (SolenoidP())
		{
			solenoid.Set(frc.DoubleSolenoid.Value.kForward);
			//frc::Wait(1);
		}
	}
	public final void CloseShoot()
	{
		if (SolenoidP())
		{
			solenoid.Set(frc.DoubleSolenoid.Value.kReverse);
			//frc::Wait(2.5);
		}
	}
	public final boolean ShootOpened()
	{
		return SolenoidP() && solenoid.Get() == frc.DoubleSolenoid.Value.kForward;
	}
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//	void Rumble();

	public final boolean Override()
	{
		return s_override;
	}
	public final boolean GetHomeSwitch()
	{
		return homeSwitch.Get();
	}
	public final Position GetIdealPosition()
	{
		return m_idealPosition;
	}

}