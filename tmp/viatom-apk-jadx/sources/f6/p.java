package f6;

import com.inmobi.cmp.core.model.Vector;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p extends kotlin.jvm.internal.m implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Vector f8122a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Vector f8123b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Vector vector, Vector vector2) {
        super(2);
        this.f8122a = vector;
        this.f8123b = vector2;
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        int iIntValue = ((Number) obj).intValue();
        ((Boolean) obj2).getClass();
        Vector vector = this.f8122a;
        if (vector != null && !vector.contains(iIntValue)) {
            this.f8123b.unset(iIntValue);
        }
        return w.f12711a;
    }
}
