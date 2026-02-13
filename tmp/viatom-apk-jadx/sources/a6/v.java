package a6;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.uptodown.UptodownApp;
import com.uptodown.workers.UploadFileWorker;
import kotlin.jvm.internal.a0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class v {
    public static void a(Context context) {
        context.getClass();
        Object systemService = context.getSystemService("display");
        systemService.getClass();
        kotlin.jvm.internal.b bVarD = a0.d(((DisplayManager) systemService).getDisplays());
        while (bVarD.hasNext()) {
            if (((Display) bVarD.next()).getState() != 1) {
                return;
            }
        }
        float f = UptodownApp.E;
        if (k4.c.o(context, "UploadFileWorker")) {
            return;
        }
        WorkManager.Companion.getInstance(context).enqueue(((OneTimeWorkRequest.Builder) com.mbridge.msdk.dycreator.baseview.a.h(UploadFileWorker.class, "UploadFileWorker")).build());
    }
}
