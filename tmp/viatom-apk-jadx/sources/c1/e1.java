package c1;

import android.content.SharedPreferences;
import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f1145a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1146b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1147c;

    /* renamed from: d, reason: collision with root package name */
    public long f1148d;
    public final /* synthetic */ h1 e;

    public e1(h1 h1Var, String str, long j10) {
        Objects.requireNonNull(h1Var);
        this.e = h1Var;
        i0.y.d(str);
        this.f1145a = str;
        this.f1146b = j10;
    }

    public final long a() {
        if (!this.f1147c) {
            this.f1147c = true;
            this.f1148d = this.e.k().getLong(this.f1145a, this.f1146b);
        }
        return this.f1148d;
    }

    public final void b(long j10) {
        SharedPreferences.Editor editorEdit = this.e.k().edit();
        editorEdit.putLong(this.f1145a, j10);
        editorEdit.apply();
        this.f1148d = j10;
    }
}
