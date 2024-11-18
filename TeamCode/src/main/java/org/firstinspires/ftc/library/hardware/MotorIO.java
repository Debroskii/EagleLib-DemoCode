package org.firstinspires.ftc.library.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.library.hardware.config.OpModeCatalog;
import org.firstinspires.ftc.library.hardware.config.MotorConfig;

public class MotorIO {
    private final DcMotorEx motor;

    private final double gearRatio;
    private final double resolution;

    public MotorIO(MotorConfig config) {
        motor = OpModeCatalog.hardwareMap.get(DcMotorEx.class, config.id);
        motor.setDirection(config.direction);
        motor.setZeroPowerBehavior(config.idle_behavior);
        gearRatio = config.gear_ratio;
    }

    public void set(double power) {
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setPower(power);
    }

    public void runToPosition(double position) {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(position * gearRatio);
    }
}
