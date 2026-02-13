package androidx.savedstate;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import g7.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import s6.i;
import s6.w;
import t6.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final /* synthetic */ class SavedStateKt__SavedState_androidKt {
    public static final Bundle savedState(Map<String, ? extends Object> map, l lVar) {
        i[] iVarArr;
        map.getClass();
        lVar.getClass();
        if (map.isEmpty()) {
            iVarArr = new i[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                arrayList.add(new i(entry.getKey(), entry.getValue()));
            }
            iVarArr = (i[]) arrayList.toArray(new i[0]);
        }
        Bundle bundleBundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        lVar.invoke(SavedStateWriter.m181boximpl(SavedStateWriter.m183constructorimpl(bundleBundleOf)));
        return bundleBundleOf;
    }

    public static Bundle savedState$default(Map map, l lVar, int i10, Object obj) {
        i[] iVarArr;
        if ((i10 & 1) != 0) {
            map = u.f12809a;
        }
        if ((i10 & 2) != 0) {
            lVar = new l() { // from class: androidx.savedstate.SavedStateKt__SavedState_androidKt.savedState.1
                @Override // g7.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    m94invokexApjlu4(((SavedStateWriter) obj2).m221unboximpl());
                    return w.f12711a;
                }

                /* renamed from: invoke-xApjlu4, reason: not valid java name */
                public final void m94invokexApjlu4(Bundle bundle) {
                    bundle.getClass();
                }
            };
        }
        map.getClass();
        lVar.getClass();
        if (map.isEmpty()) {
            iVarArr = new i[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new i((String) entry.getKey(), entry.getValue()));
            }
            iVarArr = (i[]) arrayList.toArray(new i[0]);
        }
        Bundle bundleBundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        lVar.invoke(SavedStateWriter.m181boximpl(SavedStateWriter.m183constructorimpl(bundleBundleOf)));
        return bundleBundleOf;
    }

    public static final Bundle savedState(Bundle bundle, l lVar) {
        bundle.getClass();
        lVar.getClass();
        Bundle bundle2 = new Bundle(bundle);
        lVar.invoke(SavedStateWriter.m181boximpl(SavedStateWriter.m183constructorimpl(bundle2)));
        return bundle2;
    }

    public static /* synthetic */ Bundle savedState$default(Bundle bundle, l lVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = new l() { // from class: androidx.savedstate.SavedStateKt__SavedState_androidKt.savedState.3
                @Override // g7.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    m95invokexApjlu4(((SavedStateWriter) obj2).m221unboximpl());
                    return w.f12711a;
                }

                /* renamed from: invoke-xApjlu4, reason: not valid java name */
                public final void m95invokexApjlu4(Bundle bundle2) {
                    bundle2.getClass();
                }
            };
        }
        bundle.getClass();
        lVar.getClass();
        Bundle bundle2 = new Bundle(bundle);
        lVar.invoke(SavedStateWriter.m181boximpl(SavedStateWriter.m183constructorimpl(bundle2)));
        return bundle2;
    }
}
