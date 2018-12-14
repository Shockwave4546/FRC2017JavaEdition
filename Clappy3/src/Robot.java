//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "WPILib.h"
//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Command.h"
//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "LiveWindow/LiveWindow.h"
//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include <networktables/NetworkTable.h>


//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "WPILib.h"
//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "Commands/Command.h"
//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include "LiveWindow/LiveWindow.h"
//C++ TO JAVA CONVERTER WARNING: The following #include directive was ignored:
//#include <networktables/NetworkTable.h>


public class Robot extends IterativeRobot
{
	public std::unique_ptr<Command> autonomousCommand = new std::unique_ptr<Command>();
	public static std::unique_ptr<OI> oi = new std::unique_ptr<OI>();
	public LiveWindow lw = LiveWindow.GetInstance();

	public static DriveTrain driveTrain;
	public static GearPCM gearPCM;
	public static GearArm gearArm;
	public static Climber climber;



	public void RobotInit()
	{
		RobotMap.init();

		/*
		gearCam = CameraServer::GetInstance()->StartAutomaticCapture(0);
		frc::Wait(1);
		gearCam.SetResolution(640, 480);
		frc::Wait(1);
	
		backCam = CameraServer::GetInstance()->StartAutomaticCapture(1);
		frc::Wait(1);
		backCam.SetResolution(640, 480);
		frc::Wait(1);
		*/

		driveTrain.reset(new DriveTrain());
		gearPCM.reset(new GearPCM());
		gearArm.reset(new GearArm());
		climber.reset(new Climber());
		GlobalMembers.oi.reset(new OI());

		autonomousCommand.reset(new AutonomousCommand());

	}
	public void DisabledInit()
	{

	}
	public void DisabledPeriodic()
	{
		Scheduler.GetInstance().Run();
	}
	public void AutonomousInit()
	{

		//autonomousCommand.reset(new AutoMovePastTheLine());

		if (autonomousCommand.get() != null)
		{
			autonomousCommand.Start();
		}
	}
	public void AutonomousPeriodic()
	{
		Scheduler.GetInstance().Run();
	}
	public void TeleopInit()
	{
		if (autonomousCommand.get() != null)
		{
			autonomousCommand.Cancel();
		}


	}
	public void TeleopPeriodic()
	{

		Scheduler.GetInstance().Run();

		SmartDashboard.PutString("Robot Direction", driveTrain.GetDirectionS());
		SmartDashboard.PutString("GearPCM Status", gearPCM.GetPCMStatusS());
		SmartDashboard.PutString("Slow", driveTrain.GetSlowS());
		//SmartDashboard::PutBoolean("Tracking", true);
		//SmartDashboard::PutString("Target", "hook");


	}
	public void TestPeriodic()
	{
		lw.Run();
	}

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//	void ChangeCamera();

	private cs.UsbCamera cam0;
	private cs.UsbCamera cam1;
	private cs.UsbCamera gearCam = new cs.UsbCamera();
	private cs.UsbCamera backCam = new cs.UsbCamera();
	private cs.MjpegServer mjpegServer;
}