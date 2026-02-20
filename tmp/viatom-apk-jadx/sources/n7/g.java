package n7;

import java.util.Iterator;
import java.util.NoSuchElementException;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends h implements Iterator, w6.c, h7.a {

    /* renamed from: a, reason: collision with root package name */
    public int f11580a;

    /* renamed from: b, reason: collision with root package name */
    public Object f11581b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f11582c;

    /* renamed from: d, reason: collision with root package name */
    public w6.c f11583d;

    @Override // n7.h
    public final void a(Object obj, y6.h hVar) {
        this.f11581b = obj;
        this.f11580a = 3;
        this.f11583d = hVar;
    }

    public final RuntimeException d() {
        int i10 = this.f11580a;
        if (i10 == 4) {
            return new NoSuchElementException();
        }
        if (i10 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f11580a);
    }

    @Override // w6.c
    public final w6.h getContext() {
        return w6.i.f13523a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i10 = this.f11580a;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2 || i10 == 3) {
                        return true;
                    }
                    if (i10 == 4) {
                        return false;
                    }
                    throw d();
                }
                Iterator it = this.f11582c;
                it.getClass();
                if (it.hasNext()) {
                    this.f11580a = 2;
                    return true;
                }
                this.f11582c = null;
            }
            this.f11580a = 5;
            w6.c cVar = this.f11583d;
            cVar.getClass();
            this.f11583d = null;
            cVar.resumeWith(w.f12711a);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i10 = this.f11580a;
        if (i10 == 0 || i10 == 1) {
            if (hasNext()) {
                return next();
            }
            com.google.gson.internal.a.b();
            return null;
        }
        if (i10 == 2) {
            this.f11580a = 1;
            Iterator it = this.f11582c;
            it.getClass();
            return it.next();
        }
        if (i10 != 3) {
            throw d();
        }
        this.f11580a = 0;
        Object obj = this.f11581b;
        this.f11581b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // w6.c
    public final void resumeWith(Object obj) {
        s6.a.e(obj);
        this.f11580a = 4;
    }
}
