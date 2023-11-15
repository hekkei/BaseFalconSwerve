package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wrist extends SubsystemBase{

    private static TalonFX m_wristMotor = new TalonFX(13);
    private static VictorSPX m_intakeMotor = new VictorSPX(16);
    private static VictorSPX m_intakeMotor2 = new VictorSPX(15);
    private static VictorSPX m_wrist2 = new VictorSPX(3);

    private static final double downPos = 2200.0;
    private static final double downPosCones = 3100.0;
    private static double intakePower = -0.50;
    private static double outtakePower = 0.70;
    private static double holdPower = -0.1;

    public void init() {
        m_intakeMotor2.follow(m_intakeMotor);
        m_intakeMotor.configOpenloopRamp(0.125);
        m_wrist2.follow(m_wristMotor);
    }

    public void goDownCones() {
        m_wristMotor.set(ControlMode.Position, downPosCones);
        m_intakeMotor.set(ControlMode.PercentOutput, -intakePower);
    }
    public void goDownCubes() {
        m_wristMotor.set(ControlMode.Position, downPos);
        m_intakeMotor.set(ControlMode.PercentOutput, intakePower);
    }

    public void goUp() {
        m_wristMotor.set(ControlMode.Position, 0.0);
        m_intakeMotor.set(ControlMode.PercentOutput, holdPower);
    }

    public void spit() {
        m_intakeMotor.set(ControlMode.PercentOutput, -outtakePower);
    }
    public void spitCubes() {
        m_intakeMotor.set(ControlMode.PercentOutput, outtakePower);
    }
    
    public void resetSpin() {
        m_intakeMotor.set(ControlMode.PercentOutput, 0);
    }

    public void brake() {
        m_intakeMotor.setNeutralMode(NeutralMode.Brake);
    }
}
