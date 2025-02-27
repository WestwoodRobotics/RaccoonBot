package frc.robot;

import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

public class Constants {
    public class DriveConstants {
        // CAN ID
        private static final int leftFrontMotorCANID = 0; // fix later
        private static final int leftBackMotorCANID = 1;
        private static final int rightFrontMotorCANID = 2;
        private static final int rightBackMotorCANID = 3;
        
        // PID constants for the new PIDController in the driveCommand class
        public static final double kP = 0.015;
        public static final double kI = 0.0;
        public static final double kD = 0.0005;
        
        // Driving Parameters - Note that these are not the maximum capable speeds of
        // the robot, rather the allowed maximum speeds
        public static final double kMaxSpeedMetersPerSecond = 6.77;
        public static final double kMaxAngularSpeed = 2 * Math.PI; // radians per second

        public static final double kDirectionSlewRate = Math.PI/3; // radians per second
        public static final double kMagnitudeSlewRate = 1.8; // percent per second (1 = 100%)
        public static final double kRotationalSlewRate = 2; // percent per second (1 = 100%)

        // Chassis configuration
        public static final double kTrackWidth = Units.inchesToMeters(21.5);
        // Distance between centers of right and left wheels on robot
        public static final double kWheelBase = Units.inchesToMeters(21.5);
        // Distance between front and back wheels on robot
        public static final Translation2d frontLeftPos = new Translation2d(kWheelBase / 2, kTrackWidth / 2);
        public static final Translation2d frontRightPos = new Translation2d(kWheelBase / 2, -kTrackWidth / 2);
        public static final Translation2d rearLeftPos = new Translation2d(-kWheelBase / 2, kTrackWidth / 2);
        public static final Translation2d rearRightPos = new Translation2d(-kWheelBase / 2, -kTrackWidth / 2);
        public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
            frontLeftPos,
            frontRightPos,
            rearLeftPos,
            rearRightPos);

        // Angular offsets of the modules relative to the chassis in radians
        // These values are the angle offset of the wheels when the robot is facing forwards (Absolute Encoders)
        //DO NOT CHANGE THESE VALUES UNLESS YOU KNOW WHAT YOU'RE DOING!!
        public static final double kFrontLeftChassisAngularOffset = Math.PI+(Math.PI/2);
        public static final double kFrontRightChassisAngularOffset = 0; 
        public static final double kRearLeftChassisAngularOffset = Math.PI;
        public static final double kRearRightChassisAngularOffset = Math.PI/2;


        public static final boolean kGyroReversed = false;

        public static final double slowModeMultiplier = 0.25;

        
    }

    public static final class PortConstants{
        // SPARK MAX CAN IDs
        public static final int kRearLeftDriving1CanId = 13;
        public static final int kRearLeftDriving2CanId = 15;
        public static final int kRearRightDriving1CanId = 11;
        public static final int kRearRightDriving2CanId = 17;
    
        public static final int testCANId = 0; //TODO: Change this to the CAN ID of the motor you want to test
    
        public static final int kDriverControllerPort = 0;
    
        public static int intakeMotorPort = 59;
    
      }
    
    public static final class ModuleConstants {
        // The MAXSwerve module can be configured with one of three pinion gears: 12T, 13T, or 14T.
        // This changes the drive speed of the module (a pinion gear with more teeth will result in a
        // robot that drives faster).
        public static final int kDrivingMotorPinionTeeth = 15;

        // Invert the turning encoder, since the output shaft rotates in the opposite direction of
        // the steering motor in the MAXSwerve Module.
        public static final boolean kTurningEncoderInverted = true;

        // Calculations required for driving motor conversion factors and feed forward
        public static final double kDrivingMotorFreeSpeedRps = VortexMotorConstants.kFreeSpeedRpm / 60;
        public static final double kWheelDiameterMeters = 0.0762;
        public static final double kWheelCircumferenceMeters = kWheelDiameterMeters * Math.PI;
        // 45 teeth on the wheel's bevel gear, 22 teeth on the first-stage spur gear, 15 teeth on the bevel pinion
        public static final double kDrivingMotorReduction = (45.0 * 20) / (kDrivingMotorPinionTeeth * 15);
        public static final double kDriveWheelFreeSpeedRps = (kDrivingMotorFreeSpeedRps * kWheelCircumferenceMeters)
            / kDrivingMotorReduction;

        public static final double kDrivingEncoderPositionFactor = (kWheelDiameterMeters * Math.PI)
            / kDrivingMotorReduction; // meters
        public static final double kDrivingEncoderVelocityFactor = ((kWheelDiameterMeters * Math.PI)
            / kDrivingMotorReduction) / 60.0; // meters per second

        public static final double kTurningEncoderPositionFactor = (2 * Math.PI); // radians
        public static final double kTurningEncoderVelocityFactor = (2 * Math.PI) / 60.0; // radians per second

        public static final double kTurningEncoderPositionPIDMinInput = 0; // radians
        public static final double kTurningEncoderPositionPIDMaxInput = kTurningEncoderPositionFactor; // radians


        // These PID Gains have been tested
        public static final double kDrivingP = 0.0000002; // 0.2 original value
        public static final double kDrivingI = 0; 
        public static final double kDrivingD = 0.0001; // 0.0001
        public static final double kDrivingFF = 1 / kDriveWheelFreeSpeedRps; // 1

        public static final double kDrivingMinOutput = 0; //-1
        public static final double kDrivingMaxOutput = 0; //1

        public static final double kTurningP = 1;
        public static final double kTurningI = 0;
        public static final double kTurningD = 0.2;
        public static final double kTurningFF = 0;
        public static final double kTurningMinOutput = -1;
        public static final double kTurningMaxOutput = 1;

        public static final IdleMode kDrivingMotorIdleMode = IdleMode.kBrake;
        public static final IdleMode kTurningMotorIdleMode = IdleMode.kBrake;

        public static final int kDrivingMotorCurrentLimit = 50; // amps
        public static final int kTurningMotorCurrentLimit = 20; // amps
    }

    public static final class VortexMotorConstants {
        public static final double kFreeSpeedRpm = 6784;
    }
}
