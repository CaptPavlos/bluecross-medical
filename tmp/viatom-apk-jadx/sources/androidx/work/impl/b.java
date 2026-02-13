package androidx.work.impl;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f679a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f680b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f681c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f682d;

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i10) {
        this.f679a = i10;
        this.f680b = obj;
        this.f681c = obj2;
        this.f682d = obj3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f679a) {
            case 0:
                return ((Processor) this.f680b).lambda$startWork$0((ArrayList) this.f681c, (String) this.f682d);
            default:
                return ((r1.f) this.f680b).f12333a.submit(new androidx.browser.trusted.c(21, (Callable) this.f681c, (n5) this.f682d));
        }
    }
}
