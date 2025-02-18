package frc.robot.subsystems.vision;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AprilTagVision extends SubsystemBase {

  private AprilTagVisionIO io;

  public AprilTagVision(AprilTagVisionIO io) {
    this.io = io;
  }

  public double autoRotate() {
    return io.autoRotate();
  }

  public double autoTranslateX() {
    return io.autoTranslateX();
  }

  public double autoTranslateY() {
    return io.autoTranslateY();
  }

  public double getArea() {
    return io.getArea();
  }
}