package org.firstinspires.ftc.library.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.library.hardware.config.OpModeCatalog;
import org.firstinspires.ftc.library.hardware.config.MotorConfig;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

/**A class to handle motor hardware input and output*/
public class MotorIO {
    private final DcMotorEx motor;

    private final double gearRatio;
    private final double resolution;
    private final String id;

    /**
     * Constructs a new instance of <span style='font-weight:bold'>MotorIO</span> with a given config
     * @param config a <span style='font-weight:bold'>MotorConfig</span> containing hardware information
     */
    public MotorIO(MotorConfig config) {
        id = config.id;
        motor = OpModeCatalog.getHardwareMap().get(DcMotorEx.class, config.id);
        motor.setDirection(config.direction);
        motor.setZeroPowerBehavior(config.idle_behavior);
        resolution = config.encoder_resolution;
        gearRatio = config.gear_ratio;
    }

    /**
     * Returns the name of the device passed into hardware-mapping
     * @return the hardware id used in mapping
     */
    public String getId() {
        return id;
    }

    /**
     * Returns an independent copy of the motor
     * @return a copied instance of <span style='font-weight:bold'>DcMotorEx</span>
     */
    public DcMotorEx getMotor() {
        return motor;
    }

    /**
     * Sets the PIDF coefficients for the motor movement
     * @param coefficients an instance of <span style='font-weight:bold'>PIDFCoefficients</span> to configure the motor to
     */
    public void setControlCoefficients(PIDFCoefficients coefficients) {
        motor.setPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION, coefficients);
    }

    /**
     * Stops and resets the encoder on the motor
     */
    public void reset() {
        stop();
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    /**
     * Outputs a percentage of the total power to the the motor
     * @param power a value between -1.0 and 1.0 representing the percent of maximum power output
     */
    public void set(double power) {
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setPower(power);
    }

    /**
     * Uses PIDF Control to move the motor to a position, this function accounts for gearRatio and resolution
     * @param position a unit-less measure of position
     */
    public void runToPosition(double position) {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition((int) (gearRatio * resolution * position));
    }

    /**
     * Uses PIDF Control to accelerate the motor to a velocity, this function accounts for gearRatio and resolution
     * @param velocity a degree measurement of angular velocity
     */
    public void runToVelocity(double velocity) {
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setVelocity(gearRatio * resolution * velocity, AngleUnit.DEGREES);
    }

    /**
     * Stops the motor
     */
    public void stop() {
        set(0);
    }
}
