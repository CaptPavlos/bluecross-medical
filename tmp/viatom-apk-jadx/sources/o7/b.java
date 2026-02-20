package o7;

import com.google.android.gms.internal.measurement.l5;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements Iterator, h7.a {

    /* renamed from: a, reason: collision with root package name */
    public int f11750a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f11751b;

    /* renamed from: c, reason: collision with root package name */
    public int f11752c;

    /* renamed from: d, reason: collision with root package name */
    public l7.d f11753d;
    public final /* synthetic */ n7.d e;

    public b(n7.d dVar) {
        this.e = dVar;
        int length = ((CharSequence) dVar.f11575b).length();
        if (length < 0) {
            com.google.gson.internal.a.n(a3.a.g(length, "Cannot coerce value to an empty range: maximum ", " is less than minimum 0."));
            throw null;
        }
        length = length >= 0 ? 0 : length;
        this.f11751b = length;
        this.f11752c = length;
    }

    public final void a() {
        s6.i iVar;
        n7.d dVar = this.e;
        CharSequence charSequence = (CharSequence) dVar.f11575b;
        int i10 = this.f11752c;
        if (i10 < 0) {
            this.f11750a = 0;
            this.f11753d = null;
            return;
        }
        if (i10 <= charSequence.length() && (iVar = (s6.i) ((g7.p) dVar.f11576c).invoke(charSequence, Integer.valueOf(this.f11752c))) != null) {
            int iIntValue = ((Number) iVar.f12693a).intValue();
            int iIntValue2 = ((Number) iVar.f12694b).intValue();
            this.f11753d = l5.N(this.f11751b, iIntValue);
            int i11 = iIntValue + iIntValue2;
            this.f11751b = i11;
            this.f11752c = i11 + (iIntValue2 == 0 ? 1 : 0);
        } else {
            this.f11753d = new l7.d(this.f11751b, m.g0(charSequence), 1);
            this.f11752c = -1;
        }
        this.f11750a = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f11750a == -1) {
            a();
        }
        return this.f11750a == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f11750a == -1) {
            a();
        }
        if (this.f11750a == 0) {
            com.google.gson.internal.a.b();
            return null;
        }
        l7.d dVar = this.f11753d;
        dVar.getClass();
        this.f11753d = null;
        this.f11750a = -1;
        return dVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
