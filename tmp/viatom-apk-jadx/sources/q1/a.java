package q1;

import com.google.android.gms.internal.measurement.a4;
import j$.util.DesugarCollections;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f12219a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f12220b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f12221c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12222d;
    public final int e;
    public final d f;
    public final Set g;

    public a(String str, Set set, Set set2, int i10, int i11, d dVar, Set set3) {
        this.f12219a = str;
        this.f12220b = DesugarCollections.unmodifiableSet(set);
        this.f12221c = DesugarCollections.unmodifiableSet(set2);
        this.f12222d = i10;
        this.e = i11;
        this.f = dVar;
        this.g = DesugarCollections.unmodifiableSet(set3);
    }

    public static f9.p a(Class cls) {
        return new f9.p(cls, new Class[0]);
    }

    public static f9.p b(q qVar) {
        return new f9.p(qVar, new q[0]);
    }

    public static a c(Object obj, Class cls, Class... clsArr) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(q.a(cls));
        for (Class cls2 : clsArr) {
            a4.i(cls2, "Null interface");
            hashSet.add(q.a(cls2));
        }
        return new a(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new androidx.core.view.inputmethod.a(obj, 23), hashSet3);
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.f12220b.toArray()) + ">{" + this.f12222d + ", type=" + this.e + ", deps=" + Arrays.toString(this.f12221c.toArray()) + "}";
    }
}
