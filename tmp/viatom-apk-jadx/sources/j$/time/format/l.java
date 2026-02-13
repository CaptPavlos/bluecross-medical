package j$.time.format;

/* loaded from: classes2.dex */
public final class l implements f {

    /* renamed from: a, reason: collision with root package name */
    public final String f9229a;

    public l(String str) {
        this.f9229a = str;
    }

    @Override // j$.time.format.f
    public final boolean e(p pVar, StringBuilder sb) {
        sb.append(this.f9229a);
        return true;
    }

    public final String toString() {
        return "'" + this.f9229a.replace("'", "''") + "'";
    }
}
