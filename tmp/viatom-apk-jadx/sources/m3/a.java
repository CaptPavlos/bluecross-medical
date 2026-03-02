package m3;

import j$.util.Collection;
import j$.util.stream.Collectors;
import java.util.Collection;
import java.util.function.Predicate;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11176a;

    /* renamed from: b, reason: collision with root package name */
    public Predicate f11177b = null;

    /* renamed from: c, reason: collision with root package name */
    public Object f11178c;

    public a(boolean z9) {
        this.f11176a = z9;
    }

    public abstract void a(String str);

    public abstract String b();

    public abstract String c(int i10, String str);

    @Override // m3.b
    public Object getValue() {
        return this.f11178c;
    }

    @Override // m3.b
    public void setValue(Object obj) {
        Predicate predicate = this.f11177b;
        if (predicate == null || predicate.test(obj)) {
            this.f11178c = obj;
        } else {
            if (obj instanceof Collection) {
                throw new o3.c(a3.a.o(new StringBuilder("Invalid value '"), (String) Collection.EL.stream((java.util.Collection) obj).map(new k3.a(1)).collect(Collectors.joining(",")), "'"));
            }
            throw new o3.c("Invalid value '" + obj + "'");
        }
    }
}
