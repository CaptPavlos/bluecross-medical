package s8;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f12729a;

    /* renamed from: b, reason: collision with root package name */
    public int f12730b;

    public c() {
        this.f12729a = new ArrayList();
        this.f12730b = 128;
    }

    public synchronized List a() {
        return DesugarCollections.unmodifiableList(new ArrayList(this.f12729a));
    }

    public c(ArrayList arrayList) {
        this.f12730b = 0;
        this.f12729a = arrayList;
    }
}
