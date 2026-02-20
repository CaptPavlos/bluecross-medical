package m3;

import java.util.function.Predicate;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h implements b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11185a;

    /* renamed from: b, reason: collision with root package name */
    public Predicate f11186b;

    /* renamed from: c, reason: collision with root package name */
    public Object f11187c;

    public h(Predicate predicate) {
        this.f11185a = 0;
        this.f11187c = null;
        this.f11186b = predicate;
        setValue('-');
    }

    @Override // m3.b
    public final Object getValue() {
        switch (this.f11185a) {
            case 0:
                return (Character) this.f11187c;
            default:
                return (Integer) this.f11187c;
        }
    }

    @Override // m3.b
    public final void setValue(Object obj) {
        switch (this.f11185a) {
            case 0:
                Character chValueOf = Character.valueOf(obj.toString().charAt(0));
                if (this.f11186b.test(chValueOf)) {
                    this.f11187c = chValueOf;
                    return;
                }
                throw new o3.c("Invalid value '" + chValueOf + "'");
            default:
                ((i) this.f11186b).getClass();
                this.f11187c = (Integer) obj;
                return;
        }
    }
}
