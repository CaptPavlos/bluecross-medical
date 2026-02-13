package u6;

import java.util.AbstractList;
import java.util.ListIterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements ListIterator, h7.a {

    /* renamed from: b, reason: collision with root package name */
    public int f12937b;

    /* renamed from: d, reason: collision with root package name */
    public int f12939d;
    public final t6.f e;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12936a = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f12938c = -1;

    public a(c cVar, int i10) {
        this.e = cVar;
        this.f12937b = i10;
        this.f12939d = ((AbstractList) cVar).modCount;
    }

    public void a() {
        if (((AbstractList) ((b) this.e).e).modCount == this.f12939d) {
            return;
        }
        a2.a.e();
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.f12936a) {
            case 0:
                a();
                b bVar = (b) this.e;
                int i10 = this.f12937b;
                this.f12937b = i10 + 1;
                bVar.add(i10, obj);
                this.f12938c = -1;
                this.f12939d = ((AbstractList) bVar).modCount;
                break;
            default:
                c();
                c cVar = (c) this.e;
                int i11 = this.f12937b;
                this.f12937b = i11 + 1;
                cVar.add(i11, obj);
                this.f12938c = -1;
                this.f12939d = ((AbstractList) cVar).modCount;
                break;
        }
    }

    public void c() {
        if (((AbstractList) ((c) this.e)).modCount == this.f12939d) {
            return;
        }
        a2.a.e();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f12936a) {
            case 0:
                if (this.f12937b < ((b) this.e).f12942c) {
                }
                break;
            default:
                if (this.f12937b < ((c) this.e).f12946b) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f12936a) {
            case 0:
                if (this.f12937b > 0) {
                }
                break;
            default:
                if (this.f12937b > 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f12936a) {
            case 0:
                a();
                int i10 = this.f12937b;
                b bVar = (b) this.e;
                if (i10 >= bVar.f12942c) {
                    com.google.gson.internal.a.b();
                    break;
                } else {
                    this.f12937b = i10 + 1;
                    this.f12938c = i10;
                    break;
                }
            default:
                c();
                int i11 = this.f12937b;
                c cVar = (c) this.e;
                if (i11 >= cVar.f12946b) {
                    com.google.gson.internal.a.b();
                    break;
                } else {
                    this.f12937b = i11 + 1;
                    this.f12938c = i11;
                    break;
                }
        }
        return null;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f12936a) {
        }
        return this.f12937b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f12936a) {
            case 0:
                a();
                int i10 = this.f12937b;
                if (i10 <= 0) {
                    com.google.gson.internal.a.b();
                    break;
                } else {
                    int i11 = i10 - 1;
                    this.f12937b = i11;
                    this.f12938c = i11;
                    b bVar = (b) this.e;
                    break;
                }
            default:
                c();
                int i12 = this.f12937b;
                if (i12 <= 0) {
                    com.google.gson.internal.a.b();
                    break;
                } else {
                    int i13 = i12 - 1;
                    this.f12937b = i13;
                    this.f12938c = i13;
                    break;
                }
        }
        return null;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i10;
        switch (this.f12936a) {
            case 0:
                i10 = this.f12937b;
                break;
            default:
                i10 = this.f12937b;
                break;
        }
        return i10 - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.f12936a) {
            case 0:
                b bVar = (b) this.e;
                a();
                int i10 = this.f12938c;
                if (i10 == -1) {
                    androidx.window.layout.c.g("Call next() or previous() before removing element from the iterator.");
                    break;
                } else {
                    bVar.d(i10);
                    this.f12937b = this.f12938c;
                    this.f12938c = -1;
                    this.f12939d = ((AbstractList) bVar).modCount;
                    break;
                }
            default:
                c cVar = (c) this.e;
                c();
                int i11 = this.f12938c;
                if (i11 == -1) {
                    androidx.window.layout.c.g("Call next() or previous() before removing element from the iterator.");
                    break;
                } else {
                    cVar.d(i11);
                    this.f12937b = this.f12938c;
                    this.f12938c = -1;
                    this.f12939d = ((AbstractList) cVar).modCount;
                    break;
                }
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f12936a) {
            case 0:
                a();
                int i10 = this.f12938c;
                if (i10 == -1) {
                    androidx.window.layout.c.g("Call next() or previous() before replacing element from the iterator.");
                    break;
                } else {
                    ((b) this.e).set(i10, obj);
                    break;
                }
            default:
                c();
                int i11 = this.f12938c;
                if (i11 == -1) {
                    androidx.window.layout.c.g("Call next() or previous() before replacing element from the iterator.");
                    break;
                } else {
                    ((c) this.e).set(i11, obj);
                    break;
                }
        }
    }

    public a(b bVar, int i10) {
        this.e = bVar;
        this.f12937b = i10;
        this.f12939d = ((AbstractList) bVar).modCount;
    }
}
