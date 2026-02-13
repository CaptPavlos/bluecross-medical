package androidx.window.layout;

import androidx.window.sidecar.SidecarDisplayFeature;
import g7.l;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SidecarAdapter$translate$checkedFeature$2 extends m implements l {
    public static final SidecarAdapter$translate$checkedFeature$2 INSTANCE = new SidecarAdapter$translate$checkedFeature$2();

    public SidecarAdapter$translate$checkedFeature$2() {
        super(1);
    }

    @Override // g7.l
    public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature) {
        sidecarDisplayFeature.getClass();
        return Boolean.valueOf((sidecarDisplayFeature.getRect().width() == 0 && sidecarDisplayFeature.getRect().height() == 0) ? false : true);
    }
}
