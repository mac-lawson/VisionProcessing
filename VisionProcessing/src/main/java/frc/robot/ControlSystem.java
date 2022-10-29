package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.XboxController;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ControlSystem {
    public static Double kP = 0.1; 
    public static Double kI = 1e-4;
    public static Double kD = 1.0; 
    public static Double kIz = 0.0; 
    public static Double kFF = 0.0; 
    public static Double kMaxOutput = 1.0; 
    public static Double kMinOutput = -1.0;
    public static void initMotor(CANSparkMax motor, Integer port, MotorType motorType) {
        motor = new CANSparkMax(port, motorType);
    }

    public static final Integer mainMotor = 1;

    public static void positionalControl(CANSparkMax m_motor, SparkMaxPIDController m_pidController, RelativeEncoder m_encoder) {
            m_motor.restoreFactoryDefaults();

            /**
             * In order to use PID functionality for a controller, a SparkMaxPIDController object
             * is constructed by calling the getPIDController() method on an existing
             * CANSparkMax object
             */
            m_pidController = m_motor.getPIDController();

            // Encoder object created to display position values
            m_encoder = m_motor.getEncoder();

            // PID coefficients
            Double kP = 0.1; 
            Double kI = 1e-4;
            Double kD = 1.0; 
            Double kIz = 0.0; 
            Double kFF = 0.0; 
            Double kMaxOutput = 1.0; 
            Double kMinOutput = -1.0;

            // set PID coefficients
            m_pidController.setP(kP);
            m_pidController.setI(kI);
            m_pidController.setD(kD);
            m_pidController.setIZone(kIz);
            m_pidController.setFF(kFF);
            m_pidController.setOutputRange(kMinOutput, kMaxOutput);

            // display PID coefficients on SmartDashboard
            SmartDashboard.putNumber("P Gain", kP);
            SmartDashboard.putNumber("I Gain", kI);
            SmartDashboard.putNumber("D Gain", kD);
            SmartDashboard.putNumber("I Zone", kIz);
            SmartDashboard.putNumber("Feed Forward", kFF);
            SmartDashboard.putNumber("Max Output", kMaxOutput);
            SmartDashboard.putNumber("Min Output", kMinOutput);
            SmartDashboard.putNumber("Set Rotations", 0);
    }

    public static void betaTest(SparkMaxPIDController m_pidController) {

        // read PID coefficients from SmartDashboard
    double p = SmartDashboard.getNumber("P Gain", 0);
    double i = SmartDashboard.getNumber("I Gain", 0);
    double d = SmartDashboard.getNumber("D Gain", 0);
    double iz = SmartDashboard.getNumber("I Zone", 0);
    double ff = SmartDashboard.getNumber("Feed Forward", 0);
    double max = SmartDashboard.getNumber("Max Output", 0);
    double min = SmartDashboard.getNumber("Min Output", 0);
    double rotations = SmartDashboard.getNumber("Set Rotations", 0);

    // if PID coefficients on SmartDashboard have changed, write new values to controller
    if((p != kP)) { m_pidController.setP(p); kP = p; }
    if((i != kI)) { m_pidController.setI(i); kI = i; }
    if((d != kD)) { m_pidController.setD(d); kD = d; }
    if((iz != kIz)) { m_pidController.setIZone(iz); kIz = iz; }
    if((ff != kFF)) { m_pidController.setFF(ff); kFF = ff; }
    if((max != kMaxOutput) || (min != kMinOutput)) { 
      m_pidController.setOutputRange(min, max); 
      kMinOutput = min; kMaxOutput = max; 
    }
}
}
