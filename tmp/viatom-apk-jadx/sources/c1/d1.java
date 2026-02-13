package c1;

import android.content.SharedPreferences;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f1104a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1105b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1106c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1107d;
    public final /* synthetic */ h1 e;

    public d1(h1 h1Var, String str, boolean z9) {
        this.e = h1Var;
        i0.y.d(str);
        this.f1104a = str;
        this.f1105b = z9;
    }

    public final boolean a() {
        if (!this.f1106c) {
            this.f1106c = true;
            this.f1107d = this.e.k().getBoolean(this.f1104a, this.f1105b);
        }
        return this.f1107d;
    }

    public final void b(boolean z9) {
        SharedPreferences.Editor editorEdit = this.e.k().edit();
        editorEdit.putBoolean(this.f1104a, z9);
        editorEdit.apply();
        this.f1107d = z9;
    }
}
