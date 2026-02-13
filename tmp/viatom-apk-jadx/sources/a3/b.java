package a3;

import android.os.Build;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f24a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25b;

    /* renamed from: c, reason: collision with root package name */
    public final String f26c;

    /* renamed from: d, reason: collision with root package name */
    public final k0 f27d;
    public final ArrayList e;

    public b(String str, String str2, String str3, k0 k0Var, ArrayList arrayList) {
        String str4 = Build.MANUFACTURER;
        str2.getClass();
        str3.getClass();
        str4.getClass();
        this.f24a = str;
        this.f25b = str2;
        this.f26c = str3;
        this.f27d = k0Var;
        this.e = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.f24a.equals(bVar.f24a) || !kotlin.jvm.internal.l.a(this.f25b, bVar.f25b) || !kotlin.jvm.internal.l.a(this.f26c, bVar.f26c)) {
            return false;
        }
        String str = Build.MANUFACTURER;
        return kotlin.jvm.internal.l.a(str, str) && this.f27d.equals(bVar.f27d) && this.e.equals(bVar.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + ((this.f27d.hashCode() + androidx.constraintlayout.core.widgets.analyzer.a.o(androidx.constraintlayout.core.widgets.analyzer.a.o(androidx.constraintlayout.core.widgets.analyzer.a.o(this.f24a.hashCode() * 31, 31, this.f25b), 31, this.f26c), 31, Build.MANUFACTURER)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidApplicationInfo(packageName=");
        sb.append(this.f24a);
        sb.append(", versionName=");
        sb.append(this.f25b);
        sb.append(", appBuildVersion=");
        sb.append(this.f26c);
        sb.append(", deviceManufacturer=");
        sb.append(Build.MANUFACTURER);
        sb.append(", currentProcessDetails=");
        sb.append(this.f27d);
        sb.append(", appProcessDetails=");
        return a.p(sb, this.e, ')');
    }
}
