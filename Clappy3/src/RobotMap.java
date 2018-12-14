//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "WPILib.h"

public class RobotMap
{

	public static SpeedController driveTrainTopLeft;
	public static SpeedController driveTrainTopRight;
	public static SpeedController driveTrainBottomLeft;
	public static SpeedController driveTrainBottomRight;
	public static SpeedController driveTrainCenter;

	public static Compressor gearPCMCompressor;
	public static DoubleSolenoid gearPCMSolenoid;

	public static SpeedController gearArmMotor;
	public static Encoder gearArmEncoder;
	public static DigitalInput gearArmSwitch;
	public static DoubleSolenoid gearShootSolenoid;

	public static SpeedController climbMotor;


	//#include "LiveWindow/LiveWindow.h"
	//#include "WPILib.h"





	public static void init()
	{

		LiveWindow lw = LiveWindow.GetInstance();

		driveTrainTopLeft.reset(new VictorSP(0));
		lw.AddActuator("DriveTrain", "TopLeft", std::static_pointer_cast<VictorSP>(driveTrainTopLeft));
		driveTrainTopLeft.SetInverted(true);
		driveTrainTopLeft.StopMotor();

		driveTrainTopRight.reset(new VictorSP(1));
		lw.AddActuator("DriveTrain", "TopRight", std::static_pointer_cast<VictorSP>(driveTrainTopRight));
		driveTrainTopRight.StopMotor();

		driveTrainBottomLeft.reset(new VictorSP(2));
		lw.AddActuator("DriveTrain", "BottomLeft", std::static_pointer_cast<VictorSP>(driveTrainBottomLeft));
		driveTrainBottomLeft.SetInverted(true);
		driveTrainBottomLeft.StopMotor();

		driveTrainBottomRight.reset(new VictorSP(3));
		lw.AddActuator("DriveTrain", "BottomRight", std::static_pointer_cast<VictorSP>(driveTrainBottomRight));
		driveTrainBottomRight.StopMotor();

		driveTrainCenter.reset(new VictorSP(4));
		lw.AddActuator("DriveTrain", "Center", std::static_pointer_cast<VictorSP>(driveTrainCenter));
		driveTrainCenter.StopMotor();



		gearPCMCompressor.reset(new Compressor());
		if (gearPCMCompressor != null)
		{
			lw.AddActuator("GearPCM", "Compressor", gearPCMCompressor);
			gearPCMCompressor.Start();
		}

		gearPCMSolenoid.reset(new DoubleSolenoid(0, 1));
		if (gearPCMSolenoid != null)
		{
			lw.AddActuator("GearPCM", "Solenoid", gearPCMSolenoid);
		}



		gearArmMotor.reset(new TalonSRX(5));
		lw.AddActuator("GearArm", "Motor", std::static_pointer_cast<TalonSRX>(gearArmMotor));
		gearArmMotor.StopMotor();

		gearArmEncoder.reset(new Encoder(0, 1, true));
		lw.AddSensor("GearArm", "Encoder", gearArmEncoder);

		gearArmSwitch.reset(new DigitalInput(2));
		lw.AddSensor("GearArm", "HomeSwitch", gearArmSwitch);

		gearShootSolenoid.reset(new DoubleSolenoid(3, 2));
		if (gearShootSolenoid != null)
		{
			lw.AddActuator("GearArm", "Solenoid", gearShootSolenoid);
		}



		climbMotor.reset(new VictorSP(6));
		lw.AddActuator("Climber", "ClimbMotor", std::static_pointer_cast<VictorSP>(climbMotor));
		climbMotor.StopMotor();



	}
}