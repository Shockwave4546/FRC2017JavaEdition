public class Robot extends IterativeRobot
{
	public std::unique_ptr<Command> autonomousCommand = new std::unique_ptr<Command>();
	public static std::unique_ptr<OI> oi = new std::unique_ptr<OI>();
	public LiveWindow lw = LiveWindow.GetInstance();

	public static DriveTrain driveTrain;
	public static GearPCM gearPCM;
	public static GearArm gearArm;
	public static Climber climber;



//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//	virtual void RobotInit();
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//	virtual void DisabledInit();
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//	virtual void DisabledPeriodic();
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//	virtual void AutonomousInit();
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//	virtual void AutonomousPeriodic();
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//	virtual void TeleopInit();
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//	virtual void TeleopPeriodic();
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//	virtual void TestPeriodic();

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//	void ChangeCamera();

	private cs.UsbCamera cam0;
	private cs.UsbCamera cam1;
	private cs.UsbCamera gearCam = new cs.UsbCamera();
	private cs.UsbCamera backCam = new cs.UsbCamera();
	private cs.MjpegServer mjpegServer;
}