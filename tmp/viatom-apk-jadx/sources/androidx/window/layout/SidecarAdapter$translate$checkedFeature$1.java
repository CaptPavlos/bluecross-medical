package androidx.window.layout;

import androidx.window.sidecar.SidecarDisplayFeature;
import g7.l;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SidecarAdapter$translate$checkedFeature$1 extends m implements l {
    public static final SidecarAdapter$translate$checkedFeature$1 INSTANCE = new SidecarAdapter$translate$checkedFeature$1();

    public SidecarAdapter$translate$checkedFeature$1() {
        super(1);
    }

    @Override // g7.l
    public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature) {
        sidecarDisplayFeature.getClass();
        boolean z9 = true;
        if (sidecarDisplayFeature.getType() != 1 && sidecarDisplayFeature.getType() != 2) {
            z9 = false;
        }
        return Boolean.valueOf(z9);
    }
}
