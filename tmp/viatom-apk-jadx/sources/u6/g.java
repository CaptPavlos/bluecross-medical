package u6;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends t6.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12965a;

    /* renamed from: b, reason: collision with root package name */
    public final f f12966b;

    public /* synthetic */ g(f fVar, int i10) {
        this.f12965a = i10;
        this.f12966b = fVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f12965a) {
            case 0:
                ((Map.Entry) obj).getClass();
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int i10 = this.f12965a;
        collection.getClass();
        switch (i10) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // t6.g
    public final int c() {
        switch (this.f12965a) {
        }
        return this.f12966b.f12960i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f12965a) {
            case 0:
                this.f12966b.clear();
                break;
            default:
                this.f12966b.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f12965a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                f fVar = this.f12966b;
                fVar.getClass();
                int iH = fVar.h(entry.getKey());
                if (iH < 0) {
                    return false;
                }
                Object[] objArr = fVar.f12957b;
                objArr.getClass();
                return l.a(objArr[iH], entry.getValue());
            default:
                return this.f12966b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.f12965a) {
            case 0:
                collection.getClass();
                return this.f12966b.f(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.f12965a) {
        }
        return this.f12966b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f12965a) {
            case 0:
                f fVar = this.f12966b;
                fVar.getClass();
                return new d(fVar, 0);
            default:
                f fVar2 = this.f12966b;
                fVar2.getClass();
                return new d(fVar2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f12965a) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    f fVar = this.f12966b;
                    fVar.getClass();
                    fVar.d();
                    int iH = fVar.h(entry.getKey());
                    if (iH >= 0) {
                        Object[] objArr = fVar.f12957b;
                        objArr.getClass();
                        if (l.a(objArr[iH], entry.getValue())) {
                            fVar.l(iH);
                            break;
                        }
                    }
                }
                break;
            default:
                f fVar2 = this.f12966b;
                fVar2.d();
                int iH2 = fVar2.h(obj);
                if (iH2 >= 0) {
                    fVar2.l(iH2);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        int i10 = this.f12965a;
        collection.getClass();
        switch (i10) {
            case 0:
                this.f12966b.d();
                break;
            default:
                this.f12966b.d();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        int i10 = this.f12965a;
        collection.getClass();
        switch (i10) {
            case 0:
                this.f12966b.d();
                break;
            default:
                this.f12966b.d();
                break;
        }
        return super.retainAll(collection);
    }
}
