package org.firstinspires.ftc.library.math.kinematics;

import org.firstinspires.ftc.library.math.EagleMath;

/**A class representing the state of a chassis at a single moment.
 * <p style="font-style: italic">Stores an X-axis, Y-axis, and Z-axis Rotation components as values between -1.0 and 1.0</p>
 */
public class ChassisState {
    public final double x, y, r;

    ChassisState(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    /**
     * Constructs a new instance of <span style="font-weight:bold">ChassisState</span> with robot-relative motion
     * @param x X-axis motion component
     * @param y Y-axis motion component
     * @param r Z-axis Rotation component
     * @return a robot-relative instance of <span style="font-weight:bold">ChassisState</span>
     */
    public static ChassisState relative(double x, double y, double r) {
        return new ChassisState(
            EagleMath.clamp(x, -1, 1),
            EagleMath.clamp(y, -1, 1),
            EagleMath.clamp(r, -1, 1)
        );
    }

    /**
     * Constructs a new instance of <span style='font-weight:bold'>ChassisState</span> with field-relative motion
     * @param x X-axis motion component
     * @param y Y-axis motion component
     * @param r Z-axis Rotation component
     * @param heading the current heading of the robot along the Z-axis (radians)
     * @return a field-relative instance of <span style='font-weight:bold'>ChassisState</span>
     */
    public static ChassisState absolute(double x, double y, double r, double heading) {
        x = EagleMath.clamp(x, -1, 1);
        y = EagleMath.clamp(y, -1, 1);

        // Correcting cartesian components of motion using the heading to convert robot motion into field motion
        double cX = x * Math.cos(heading) - y * Math.sin(heading);
        double cY = x * Math.sin(heading) + y * Math.cos(heading);

        return new ChassisState(cX, cY, EagleMath.clamp(r, -1, 1));
    }
}
