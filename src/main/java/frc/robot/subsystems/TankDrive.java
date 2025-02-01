package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PortConstants;

public class TankDrive extends SubsystemBase {

    private SparkMax motor1;
    private SparkMax motor2;
    private SparkMax motor3;
    private SparkMax motor4;

    public TankDrive() {
        this.motor1 = new SparkMax(PortConstants.kRearLeftDriving1CanId, MotorType.kBrushless);
        this.motor2 = new SparkMax(PortConstants.kRearLeftDriving2CanId, MotorType.kBrushless);
        this.motor3 = new SparkMax(PortConstants.kRearRightDriving1CanId, MotorType.kBrushless);
        this.motor4 = new SparkMax(PortConstants.kRearRightDriving2CanId, MotorType.kBrushless);
        
    }

    public void setLeftWheelSpeed(double speed) {
        motor1.set(speed);
        motor3.set(speed);
    }

    public void setRightWheelSpeed(double speed) {
        motor2.set(-speed);
        motor4.set(-speed);
    }
    
}
