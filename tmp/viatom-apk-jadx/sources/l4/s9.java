package l4;

import com.uptodown.activities.Updates;
import java.util.Comparator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s9 implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Updates f10825a;

    public s9(Updates updates) {
        this.f10825a = updates;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        ((h5.f) obj).f8526c.getClass();
        Updates updates = this.f10825a;
        Boolean boolValueOf = Boolean.valueOf(!kotlin.jvm.internal.l.a(v5.a.b(updates, r3), updates.getPackageName()));
        ((h5.f) obj2).f8526c.getClass();
        return l1.b.u(boolValueOf, Boolean.valueOf(!kotlin.jvm.internal.l.a(v5.a.b(updates, r4), updates.getPackageName())));
    }
}
