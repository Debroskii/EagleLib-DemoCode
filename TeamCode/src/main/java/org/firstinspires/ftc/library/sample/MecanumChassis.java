package org.firstinspires.ftc.library.sample;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.library.hardware.MotorIO;
import org.firstinspires.ftc.library.hardware.config.MotorConfig;
import org.firstinspires.ftc.library.hardware.config.OpModeCatalog;
import org.firstinspires.ftc.library.math.kinematics.ChassisState;
import org.firstinspires.ftc.library.math.kinematics.HolonomicDrive;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class MecanumChassis {

    private final MotorIO leftFront, rightFront, leftBack, rightBack;
    private final IMU gyroscope;

    public MecanumChassis(IMU.Parameters orientation_param) {
        leftFront = new MotorIO(MotorConfig.simple("left_front", DcMotorSimple.Direction.REVERSE));
        rightFront = new MotorIO(MotorConfig.simple("right_front", DcMotorSimple.Direction.FORWARD));
        leftBack = new MotorIO(MotorConfig.simple("left_back", DcMotorSimple.Direction.REVERSE));
        rightBack = new MotorIO(MotorConfig.simple("right_back", DcMotorSimple.Direction.FORWARD));

        gyroscope = OpModeCatalog.getHardwareMap().get(IMU.class, "imu");

        gyroscope.initialize(orientation_param);
        resetHeading();
    }

    public void resetHeading() {
        gyroscope.resetYaw();
    }

    public double getHeading() {
        return gyroscope.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
    }

    public double[] getMotorPowers() {
        return new double[] {
                leftFront.getMotor().getPower(),
                rightFront.getMotor().getPower(),
                leftBack.getMotor().getPower(),
                rightBack.getMotor().getPower()
        };
    }

    public void setState(ChassisState state) {
        leftFront.set(HolonomicDrive.Mecanum.getLeftFront(state));
        rightFront.set(HolonomicDrive.Mecanum.getRightFront(state));
        leftBack.set(HolonomicDrive.Mecanum.getLeftBack(state));
        rightBack.set(HolonomicDrive.Mecanum.getRightBack(state));
    }
}
