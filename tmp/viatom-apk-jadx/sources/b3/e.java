package b3;

import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f837a;

    public e(String str) {
        str.getClass();
        this.f837a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && l.a(this.f837a, ((e) obj).f837a);
    }

    public final int hashCode() {
        return this.f837a.hashCode();
    }

    public final String toString() {
        return a3.a.m(new StringBuilder("SessionDetails(sessionId="), this.f837a, ')');
    }
}
