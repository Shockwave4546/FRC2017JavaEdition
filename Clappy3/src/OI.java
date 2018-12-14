public class OI
{

	private Joystick driveStick;
	private Joystick gearStick;
	private JoystickButton drivetriggerRb;
	private JoystickButton drivetriggerLb;
	private JoystickButton triggerRb;
	private JoystickButton triggerLb;
	private JoystickButton button4a;
	private JoystickButton button5b;
	private JoystickButton button6x;
	private JoystickButton button7y;

	private XboxController driveStickX;
	private XboxController gearStickX;

	private ControlConfig m_driveConfig;
	private ControlConfig m_gearConfig;


	//#include "SmartDashboard/SmartDashboard.h"


	public OI()
	{

		m_driveConfig = ControlConfig.XBOXCONTOLLER;
		m_gearConfig = ControlConfig.XBOXCONTOLLER;

		switch (m_driveConfig)
		{
		case JOYSTICK:
		{
			driveStick.reset(new Joystick(0));
			driveStickX = null;

			drivetriggerRb.reset(new JoystickButton(driveStick.get(), 1)); //Trigger
			drivetriggerRb.WhenPressed(new ToggleRobotDirection());

			break;
		}
		case XBOXCONTOLLER:
		{
			driveStickX.reset(new XboxController(0));
			driveStick = null;

			drivetriggerRb.reset(new JoystickButton(driveStickX.get(), 6)); //Rb
			drivetriggerRb.WhenPressed(new ToggleRobotDirection());

			drivetriggerLb.reset(new JoystickButton(driveStickX.get(), 5)); //Lb
			drivetriggerLb.WhenPressed(new ToggleSlow());

			break;
		}
		case DISABLED:
		{
			driveStick = null;
			driveStickX = null;
			drivetriggerRb = null;
			break;
		}
		}

		switch (m_gearConfig)
		{
		case XBOXCONTOLLER:
		{
			gearStickX.reset(new XboxController(1));
			gearStick = null;

			triggerRb.reset(new JoystickButton(gearStickX.get(), 6)); //Rb
			triggerRb.WhenPressed(new ToggleGearPCM(PCMStatus.CLOSED));

			triggerLb.reset(new JoystickButton(gearStickX.get(), 5));
			triggerLb.WhenPressed(new ToggleGearPCM(PCMStatus.OPENED));

			button4a.reset(new JoystickButton(gearStickX.get(), 8)); //start
			button4a.WhenPressed(new OverrideSwitch());

			button5b.reset(new JoystickButton(gearStickX.get(), 2));
			button5b.WhenPressed(new SetShoot(Direction.REVERSE));

			button6x.reset(new JoystickButton(gearStickX.get(), 3));
			button6x.WhenPressed(new SetShoot(Direction.FORWARD));

			button7y = null;

			break;
		}
		default:
		{
			gearStickX = null;
			gearStick = null;
			triggerLb = null;
			button4a = null;
			button5b = null;
			button6x = null;
			button7y = null;
			break;
		}
		}

	}

	public final Joystick getDriveStick()
	{
	   return driveStick;
	}
	public final Joystick getGearStick()
	{
		return gearStick;
	}

	public final XboxController getDriveStickX()
	{
		return driveStickX;
	}
	public final XboxController getGearStickX()
	{
		return gearStickX;
	}

	public final ControlConfig getDriveConfig()
	{
		return m_driveConfig;
	}
	public final ControlConfig getGearConfig()
	{
		return m_gearConfig;
	}

	public final void RumbleDriveGamepad(double value)
	{
		driveStickX.SetRumble(XboxController.RumbleType.kLeftRumble, value);
		driveStickX.SetRumble(XboxController.RumbleType.kRightRumble, value);
	}
	public final void RumbleGearGamepad(double value)
	{
		gearStickX.SetRumble(XboxController.RumbleType.kLeftRumble, value);
		gearStickX.SetRumble(XboxController.RumbleType.kRightRumble, value);
	}
	public final void StopDriveGamepadRumble()
	{
		driveStickX.SetRumble(XboxController.RumbleType.kLeftRumble, 0);
		driveStickX.SetRumble(XboxController.RumbleType.kRightRumble, 0);
	}
	public final void StopGearGamepadRumble()
	{
		gearStickX.SetRumble(XboxController.RumbleType.kLeftRumble, 0);
		gearStickX.SetRumble(XboxController.RumbleType.kRightRumble, 0);
	}
}