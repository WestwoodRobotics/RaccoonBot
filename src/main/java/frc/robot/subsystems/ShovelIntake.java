package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PortConstants;

public class ShovelIntake extends SubsystemBase {

    private SparkMax motor5;

    public ShovelIntake() {
        this.motor5 = new SparkMax(PortConstants.intakeMotorPort, MotorType.kBrushless);
    }

    public void setHeight (double height) {
        //TODO: implement this
    }
    
}
