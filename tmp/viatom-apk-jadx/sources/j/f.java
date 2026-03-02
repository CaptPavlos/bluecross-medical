package j;

import g7.p;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.u;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class f extends m implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9876a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f9877b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(u uVar, int i10) {
        super(2);
        this.f9876a = i10;
        this.f9877b = uVar;
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f9876a) {
            case 0:
                ((Number) obj).intValue();
                if (!((Boolean) obj2).booleanValue()) {
                    this.f9877b.f10135a = false;
                }
                break;
            default:
                ((Number) obj).intValue();
                if (((Boolean) obj2).booleanValue()) {
                    this.f9877b.f10135a = false;
                }
                break;
        }
        return w.f12711a;
    }
}
