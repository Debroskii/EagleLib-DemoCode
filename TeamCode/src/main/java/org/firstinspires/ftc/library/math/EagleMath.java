package org.firstinspires.ftc.library.math;

public class EagleMath {

    /**
     * Passes a value through a clamp filter to restrict the returned value between a minimum and maximum
     * @param value the object to be clamped
     * @param min the minimum value the inputted object is allowed to be
     * @param max the maximum value the inputted object is allowed to be
     * @return a value passed through the clamp filter
     */
    public static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    /**
     * I don't know what this does
     * @param values some values, usually motion components of a chassis
     * @return some value?
     */
    public static double denominator(double... values) {
        double sum = 0;
        for(double value : values) {
            sum += Math.abs(value);
        }
        return Math.max(sum, 1);
    }
}
