package org.firstinspires.ftc.library.hardware.config;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class OpModeCatalog {
    private static HardwareMap hardwareMap = null;
    private static Telemetry telemetry = null;

    public static void set(OpMode donor) {
        hardwareMap = donor.hardwareMap;
        telemetry = donor.telemetry;
    }

    public static HardwareMap getHardwareMap() throws NullPointerException {
        if(hardwareMap != null) return hardwareMap;
        throw new NullPointerException("OpModeCatalog never initialized");
    }

    public static Telemetry getTelemetry() throws NullPointerException {
        if(telemetry != null) return telemetry;
        throw new NullPointerException("OpModeCatalog never initialized");
    }
}
