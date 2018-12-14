/**
 *
 *
 * @author Garrick Craft
 */
public class GearPCM extends Subsystem
{

	private Compressor compressor;
	private DoubleSolenoid solenoid;

	private boolean SolenoidP()
	{
		return solenoid != null;
	}
	private boolean CompressorP()
	{
		return compressor != null;
	}

	public GearPCM()
	{
		super("GearPCM");

		compressor = RobotMap.gearPCMCompressor;
		solenoid = RobotMap.gearPCMSolenoid;

		//SetGearPCM(PCMStatus::CLOSED);
		//StartCompressor();

	}
	public final void InitDefaultCommand()
	{

	}

	public final void SetGearPCM(PCMStatus status)
	{
		if (SolenoidP())
		{
			if (status == PCMStatus.OPENED)
			{
				solenoid.Set(frc.DoubleSolenoid.Value.kReverse);
			}
			else
			{
				solenoid.Set(frc.DoubleSolenoid.Value.kForward);
			}
		}
		else
		{
			frc.SmartDashboard.PutString("gearpcm works", "nope");
		}
	}

	public final PCMStatus GetPCMStatus()
	{
		if (solenoid.Get() == frc.DoubleSolenoid.Value.kForward)
		{
			return PCMStatus.CLOSED;
		}
		else
		{
			return PCMStatus.OPENED;
		}
	}

	public final String GetPCMStatusS()
	{
		if (SolenoidP())
		{
			if (solenoid.Get() == frc.DoubleSolenoid.Value.kForward)
			{
				return "Opened";
			}
			else if (solenoid.Get() == frc.DoubleSolenoid.Value.kReverse)
			{
				return "Closed";
			}
			else
			{
				return "Off";
			}
		}
		else
		{
			return "null";
		}
	}

	public final void StartCompressor()
	{
		if (CompressorP())
		{
			compressor.Start();
		}
	}

	public final void StopCompressor()
	{
		if (CompressorP())
		{
			compressor.Stop();
		}
	}
}