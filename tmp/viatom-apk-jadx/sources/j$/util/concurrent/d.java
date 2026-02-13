package j$.util.concurrent;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class d extends a implements Iterator {
    @Override // java.util.Iterator
    public final Object next() {
        l lVar = this.f9390b;
        if (lVar == null) {
            throw new NoSuchElementException();
        }
        Object obj = lVar.f9382b;
        Object obj2 = lVar.f9383c;
        this.f9371j = lVar;
        a();
        return new k(obj, obj2, this.f9370i);
    }
}
