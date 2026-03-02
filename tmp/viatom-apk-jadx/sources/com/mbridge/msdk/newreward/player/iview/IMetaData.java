package com.mbridge.msdk.newreward.player.iview;

import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.newreward.function.command.retention.ReportAnnotation;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface IMetaData {
    @ReportAnnotation.MethodInfo(className = "IMetaData", methodName = "report", methodParameter = "1", reportType = ExifInterface.GPS_MEASUREMENT_3D)
    void activityReport(String str);

    @ReportAnnotation.MethodInfo(className = "IMetaData", methodName = "report", methodParameter = "1", reportType = ExifInterface.GPS_MEASUREMENT_3D)
    void activityReport(String str, e eVar);

    Object getDate();

    ViewGroup getRootViewGroup();

    @ReportAnnotation.MethodInfo(isParameter = true, key = "2000131", reportType = "1")
    void onShowFail(String str, int i10);

    void setDate(Object obj);
}
