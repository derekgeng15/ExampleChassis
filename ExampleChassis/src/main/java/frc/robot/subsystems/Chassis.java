/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Chassis extends SubsystemBase {
  /**
   * Creates a new Chassis.
   */
  WPI_TalonSRX m_leftMaster;
  WPI_VictorSPX m_leftSlaveA;
  WPI_VictorSPX m_leftSlaveB;

  WPI_TalonSRX m_rightMaster;
  WPI_VictorSPX m_rightSlaveA;
  WPI_VictorSPX m_rightSlaveB;

  public Chassis() {
    m_leftMaster = new WPI_TalonSRX(Constants.kLeftMaster);
    m_leftSlaveA = new WPI_VictorSPX(Constants.kLeftSlaveA);
    m_leftSlaveB = new WPI_VictorSPX(Constants.kLeftSlaveB);

    m_rightMaster = new WPI_TalonSRX(Constants.kRightMaster);
    m_rightSlaveA = new WPI_VictorSPX(Constants.kRightSlaveA);
    m_rightSlaveB = new WPI_VictorSPX(Constants.kRightSlaveB);

    m_leftSlaveA.follow(m_leftMaster);
    m_leftSlaveB.follow(m_leftMaster);

    m_rightSlaveA.follow(m_rightMaster);
    m_rightSlaveB.follow(m_rightMaster);
  }

  public void set(double left, double right){//1 to -1
    m_leftMaster.set(left);
    m_rightMaster.set(right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
