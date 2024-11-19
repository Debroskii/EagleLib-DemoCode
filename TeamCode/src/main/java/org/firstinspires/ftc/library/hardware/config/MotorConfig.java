package org.firstinspires.ftc.library.hardware.config;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**A class that stores constants/configs about a DcMotor hardware device */
public class MotorConfig {
    public final String id;
    public final DcMotorSimple.Direction direction;
    public final DcMotor.ZeroPowerBehavior idle_behavior;
    public final double encoder_resolution;
    public final double gear_ratio;

    /**
     * Constructs a new instance of <span style='font-weight:bold'>MotorConfig</span> with given config
     * @param id an identifier used in hardware-mapping
     * @param direction the direction for the motor to spin when given a positive power
     * @param idle_behavior the idle-behavior for the motor when no output is being given
     * @param resolution the resolution of the motor's encoder
     * @param gear_ratio the gear ratio or actuation ratio of the mechanism
     */
    public MotorConfig(String id, DcMotorSimple.Direction direction, DcMotor.ZeroPowerBehavior idle_behavior, double resolution, double gear_ratio) {
        this.id = id;
        this.direction = direction;
        this.idle_behavior = idle_behavior;
        this.encoder_resolution = resolution;
        this.gear_ratio = gear_ratio;
    }

    /**
     * Constructs a new instance of <span style='font-weight:bold'>MotorConfig</span> with simple inputs
     * @param id an identifier used in hardware-mapping
     * @param direction the direction for the motor to spin when given a positive power
     * @return an instance of <span style='font-weight:bold'>MotorConfig</span> with simplified values
     */
    public static MotorConfig simple(String id, DcMotorSimple.Direction direction) {
        return new MotorConfig(
                id,
                direction,
                DcMotor.ZeroPowerBehavior.FLOAT,
                1,
                1
        );
    }
}
