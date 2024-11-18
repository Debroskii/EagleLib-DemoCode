package org.firstinspires.ftc.library.hardware.config;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class MotorConfig {
    public final String id;
    public final DcMotorSimple.Direction direction;
    public final DcMotor.ZeroPowerBehavior idle_behavior;
    public final double gear_ratio;

    public MotorConfig(String id, DcMotorSimple.Direction direction, DcMotor.ZeroPowerBehavior idle_behavior, double gear_ratio) {
        this.id = id;
        this.direction = direction;
        this.idle_behavior = idle_behavior;
        this.gear_ratio = gear_ratio;
    }
}
