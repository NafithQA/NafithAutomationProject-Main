package org.nafeth.helpers;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import java.io.File;
import java.lang.reflect.Method;

public class Recorder {

    public static ATUTestRecorder recorder;

    public static void startRecord(Method method) throws ATUTestRecorderException {

        {
            try {
                recorder = new ATUTestRecorder(System.getProperty("user.dir") + File.separator +
                        "test-output" + File.separator + "AllTestsVideos" + File.separator, method.getName(), false);
            } catch (ATUTestRecorderException e) {
                e.printStackTrace();
            }
        }
        recorder.start();
    }

    public static void stopRecord() throws ATUTestRecorderException {

        recorder.stop();
    }
}
