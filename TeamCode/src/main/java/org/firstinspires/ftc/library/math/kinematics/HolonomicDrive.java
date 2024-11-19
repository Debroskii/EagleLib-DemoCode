package org.firstinspires.ftc.library.math.kinematics;

import org.firstinspires.ftc.library.math.EagleMath;

public class HolonomicDrive {
    public static class Mecanum {
        public static double getLeftFront(ChassisState state) {
            return (state.y + state.x + state.r) / EagleMath.denominator(state.y, state.x, state.r);
        }

        public static double getRightFront(ChassisState state) {
            return (state.y - state.x - state.r) / EagleMath.denominator(state.y, state.x, state.r);
        }

        public static double getLeftBack(ChassisState state) {
            return (state.y - state.x + state.r) / EagleMath.denominator(state.y, state.x, state.r);
        }

        public static double getRightBack(ChassisState state) {
            return (state.y + state.x - state.r) / EagleMath.denominator(state.y, state.x, state.r);
        }
    }
}
