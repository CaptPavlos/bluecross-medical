package j$.util;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class m implements Iterator, z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9473a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Iterator f9474b;

    public m(n nVar) {
        this.f9474b = nVar.f9475a.iterator();
    }

    public m(t tVar) {
        this.f9474b = tVar.f9475a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f9473a) {
        }
        return this.f9474b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f9473a) {
            case 0:
                return this.f9474b.next();
            default:
                return new r((Map.Entry) this.f9474b.next());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f9473a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Iterator, j$.util.z
    public final void forEachRemaining(Consumer consumer) {
        switch (this.f9473a) {
            case 0:
                c.r(this.f9474b, consumer);
                break;
            default:
                c.r(this.f9474b, new q(0, consumer));
                break;
        }
    }
}
