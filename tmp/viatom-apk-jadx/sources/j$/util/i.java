package j$.util;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.UnaryOperator;

/* loaded from: classes2.dex */
public class i extends h implements java.util.List, List {
    private static final long serialVersionUID = -7754090372962971524L;

    /* renamed from: c, reason: collision with root package name */
    public final java.util.List f9450c;

    public i(java.util.List list) {
        super(list);
        this.f9450c = list;
    }

    public i(java.util.List list, Object obj) {
        super(list, obj);
        this.f9450c = list;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        boolean zEquals;
        if (this == obj) {
            return true;
        }
        synchronized (this.f9445b) {
            zEquals = this.f9450c.equals(obj);
        }
        return zEquals;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int iHashCode;
        synchronized (this.f9445b) {
            iHashCode = this.f9450c.hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        Object obj;
        synchronized (this.f9445b) {
            obj = this.f9450c.get(i10);
        }
        return obj;
    }

    @Override // java.util.List
    public final Object set(int i10, Object obj) {
        Object obj2;
        synchronized (this.f9445b) {
            obj2 = this.f9450c.set(i10, obj);
        }
        return obj2;
    }

    @Override // java.util.List
    public final void add(int i10, Object obj) {
        synchronized (this.f9445b) {
            this.f9450c.add(i10, obj);
        }
    }

    @Override // java.util.List
    public final Object remove(int i10) {
        Object objRemove;
        synchronized (this.f9445b) {
            objRemove = this.f9450c.remove(i10);
        }
        return objRemove;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        int iIndexOf;
        synchronized (this.f9445b) {
            iIndexOf = this.f9450c.indexOf(obj);
        }
        return iIndexOf;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        int iLastIndexOf;
        synchronized (this.f9445b) {
            iLastIndexOf = this.f9450c.lastIndexOf(obj);
        }
        return iLastIndexOf;
    }

    @Override // java.util.List
    public final boolean addAll(int i10, java.util.Collection collection) {
        boolean zAddAll;
        synchronized (this.f9445b) {
            zAddAll = this.f9450c.addAll(i10, collection);
        }
        return zAddAll;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return this.f9450c.listIterator();
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i10) {
        return this.f9450c.listIterator(i10);
    }

    @Override // java.util.List
    public java.util.List subList(int i10, int i11) {
        i iVar;
        synchronized (this.f9445b) {
            iVar = new i(this.f9450c.subList(i10, i11), this.f9445b);
        }
        return iVar;
    }

    @Override // java.util.List, j$.util.List
    public final void replaceAll(UnaryOperator unaryOperator) {
        synchronized (this.f9445b) {
            java.util.List list = this.f9450c;
            if (list instanceof List) {
                ((List) list).replaceAll(unaryOperator);
            } else {
                Objects.requireNonNull(unaryOperator);
                ListIterator listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    listIterator.set(unaryOperator.apply(listIterator.next()));
                }
            }
        }
    }

    @Override // java.util.List, j$.util.List
    public final void sort(Comparator comparator) {
        synchronized (this.f9445b) {
            c.u(this.f9450c, comparator);
        }
    }

    private Object readResolve() {
        java.util.List list = this.f9450c;
        return list instanceof RandomAccess ? new k(list) : this;
    }
}
