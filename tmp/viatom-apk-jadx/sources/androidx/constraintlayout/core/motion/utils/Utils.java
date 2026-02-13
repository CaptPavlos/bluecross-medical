package androidx.constraintlayout.core.motion.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class Utils {
    static DebugHandle sOurHandle;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface DebugHandle {
        void message(String str);
    }

    private static int clamp(int i10) {
        int i11 = (i10 & (~(i10 >> 31))) - 255;
        return (i11 & (i11 >> 31)) + 255;
    }

    public static void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String strSubstring = (stackTraceElement.getMethodName() + "                  ").substring(0, 17);
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")" + "    ".substring(Integer.toString(stackTraceElement.getLineNumber()).length()) + strSubstring;
        System.out.println(str2 + " " + str);
        DebugHandle debugHandle = sOurHandle;
        if (debugHandle != null) {
            debugHandle.message(str2 + " " + str);
        }
    }

    public static void logStack(String str, int i10) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int iMin = Math.min(i10, stackTrace.length - 1);
        String strConcat = " ";
        for (int i11 = 1; i11 <= iMin; i11++) {
            StackTraceElement stackTraceElement = stackTrace[i11];
            String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName();
            strConcat = strConcat.concat(" ");
            System.out.println(str + strConcat + str2 + strConcat);
        }
    }

    public static void loge(String str, String str2) {
        System.err.println(str + " : " + str2);
    }

    public static int rgbaTocColor(float f, float f10, float f11, float f12) {
        int iClamp = clamp((int) (f * 255.0f));
        int iClamp2 = clamp((int) (f10 * 255.0f));
        return (iClamp << 16) | (clamp((int) (f12 * 255.0f)) << 24) | (iClamp2 << 8) | clamp((int) (f11 * 255.0f));
    }

    public static void setDebugHandle(DebugHandle debugHandle) {
        sOurHandle = debugHandle;
    }

    public static void socketSend(String str) throws IOException {
        try {
            OutputStream outputStream = new Socket("127.0.0.1", 5327).getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.close();
        } catch (IOException e) {
            System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
    }

    public int getInterpolatedColor(float[] fArr) {
        return (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public static void log(String str, String str2) {
        System.out.println(str + " : " + str2);
    }
}
