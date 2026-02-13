package f6;

import com.inmobi.cmp.core.model.Vector;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o extends kotlin.jvm.internal.m implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8120a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Vector f8121b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(int i10, Vector vector) {
        super(2);
        this.f8120a = i10;
        this.f8121b = vector;
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f8120a) {
            case 0:
                int iIntValue = ((Number) obj).intValue();
                boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                Vector vector = this.f8121b;
                if (zBooleanValue) {
                    vector.set(iIntValue);
                } else {
                    vector.unset(iIntValue);
                }
                break;
            case 1:
                int iIntValue2 = ((Number) obj).intValue();
                boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
                Vector vector2 = this.f8121b;
                if (vector2.getMap().containsKey(Integer.valueOf(iIntValue2))) {
                    if (zBooleanValue2) {
                        vector2.set(iIntValue2);
                    } else {
                        vector2.unset(iIntValue2);
                    }
                }
                break;
            default:
                int iIntValue3 = ((Number) obj).intValue();
                boolean zBooleanValue3 = ((Boolean) obj2).booleanValue();
                Vector vector3 = this.f8121b;
                if (!vector3.contains(iIntValue3)) {
                    if (zBooleanValue3) {
                        vector3.set(iIntValue3);
                    } else {
                        vector3.unset(iIntValue3);
                    }
                }
                break;
        }
        return w.f12711a;
    }
}
