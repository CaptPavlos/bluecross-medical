package j$.time.format;

/* loaded from: classes2.dex */
public final class d implements f {

    /* renamed from: a, reason: collision with root package name */
    public final char f9216a;

    public d(char c10) {
        this.f9216a = c10;
    }

    @Override // j$.time.format.f
    public final boolean e(p pVar, StringBuilder sb) {
        sb.append(this.f9216a);
        return true;
    }

    public final String toString() {
        char c10 = this.f9216a;
        if (c10 == '\'') {
            return "''";
        }
        return "'" + c10 + "'";
    }
}
