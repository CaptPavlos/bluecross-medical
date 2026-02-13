package com.mbridge.msdk.newreward.player.iview;

import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.newreward.function.command.retention.ReportAnnotation;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface IBaseView {
    void addViewToCurrentViewGroup(View view);

    boolean initViews(boolean z9);

    void onActivityLifeCycleCallback(String str);

    void removeTempleFromSuperView(ViewGroup viewGroup);

    @ReportAnnotation.MethodInfo(className = "IBaseView.show", reportType = "2")
    void show(ViewGroup viewGroup);
}
