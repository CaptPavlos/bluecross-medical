package j8;

import java.util.List;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends c {

    /* renamed from: a, reason: collision with root package name */
    public final c8.b f10030a;

    public a(c8.b bVar) {
        bVar.getClass();
        this.f10030a = bVar;
    }

    @Override // j8.c
    public final c8.b a(List list) {
        return this.f10030a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && l.a(((a) obj).f10030a, this.f10030a);
    }

    public final int hashCode() {
        return this.f10030a.hashCode();
    }
}
