package o1;

import android.os.Bundle;
import c1.l2;
import c1.m2;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import i0.k;
import j1.g;
import java.util.HashSet;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements m2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11670a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11671b;

    public /* synthetic */ b(Object obj, int i10) {
        this.f11670a = i10;
        this.f11671b = obj;
    }

    @Override // c1.m2
    public final void a(long j10, Bundle bundle, String str, String str2) {
        int i10 = this.f11670a;
        Object obj = this.f11671b;
        switch (i10) {
            case 0:
                k kVar = (k) obj;
                if (((HashSet) kVar.f8923b).contains(str2)) {
                    Bundle bundle2 = new Bundle();
                    g gVar = a.f11666a;
                    String strG = l2.g(str2, l2.f1319c, l2.f1317a);
                    if (strG != null) {
                        str2 = strG;
                    }
                    bundle2.putString("events", str2);
                    ((k) kVar.f8924c).B(2, bundle2);
                    break;
                }
                break;
            default:
                if (str != null && !a.f11666a.contains(str2)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(RewardPlus.NAME, str2);
                    bundle3.putLong("timestampInMillis", j10);
                    bundle3.putBundle("params", bundle);
                    ((k) ((x4) obj).f10987b).B(3, bundle3);
                    break;
                }
                break;
        }
    }
}
