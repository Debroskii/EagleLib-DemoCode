package org.firstinspires.ftc.library.hardware.config;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**A class to store a temporary object cache to interface with the robot */
public class OpModeCatalog {
    private static HardwareMap hardwareMap = null;
    private static Telemetry telemetry = null;

    /**Sets object cache using an OpMode */
    public static void set(LinearOpMode donor) {
        hardwareMap = donor.hardwareMap;
        telemetry = donor.telemetry;
    }

    /**
     * Returns the cached <span style='font-weight:bold'>HardwareMap</span> to use in external mapping
     * @return an instance of <span style='font-weight:bold'>HardwareMap</span> cached within the hardwareMap variable
     * @throws NullPointerException if there is no <span style='font-weight:bold'>HardwareMap</span> cached
     */
    public static HardwareMap getHardwareMap() throws NullPointerException {
        if(hardwareMap != null) return hardwareMap;
        throw new NullPointerException("OpModeCatalog never initialized");
    }

    /**
     * Returns the cached <span style='font-weight:bold'>Telemetry</span> to use in external debug
     * @return an instance of <span style='font-weight:bold'>Telemetry</span> cached within the telemetry variable
     * @throws NullPointerException if there is no <span style='font-weight:bold'>Telemetry</span> cached
     */
    public static Telemetry getTelemetry() throws NullPointerException {
        if(telemetry != null) return telemetry;
        throw new NullPointerException("OpModeCatalog never initialized");
    }
}
