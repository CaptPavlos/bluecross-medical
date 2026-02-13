package n7;

import java.util.Iterator;
import kotlin.jvm.internal.a0;
import l4.x2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k implements Iterable, h7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11584a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11585b;

    public /* synthetic */ k(Object obj, int i10) {
        this.f11584a = i10;
        this.f11585b = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f11584a) {
            case 0:
                return new o7.b((d) this.f11585b);
            case 1:
                return new kotlin.jvm.internal.b((Object[]) this.f11585b);
            default:
                return new kotlin.jvm.internal.b(a0.d((Object[]) ((x2) this.f11585b).f10981b));
        }
    }
}
