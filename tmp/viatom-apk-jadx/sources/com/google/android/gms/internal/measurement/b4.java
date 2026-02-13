package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import j$.util.Objects;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b4 extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1887a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1888b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b4(c2.d dVar) {
        super(null);
        Objects.requireNonNull(dVar);
        this.f1888b = dVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z9) {
        switch (this.f1887a) {
            case 0:
                ((AtomicBoolean) ((c2.d) this.f1888b).f1641b).set(true);
                return;
            default:
                g4 g4Var = (g4) this.f1888b;
                synchronized (g4Var.f) {
                    g4Var.g = null;
                    g4Var.f1967c.run();
                }
                synchronized (g4Var) {
                    try {
                        Iterator it = g4Var.h.iterator();
                        if (it.hasNext()) {
                            if (it.next() != null) {
                                throw new ClassCastException();
                            }
                            throw null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b4(g4 g4Var) {
        super(null);
        this.f1888b = g4Var;
    }
}
