package a3;

import android.os.Build;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f35a;

    /* renamed from: b, reason: collision with root package name */
    public final b f36b;

    public c(String str, b bVar) {
        String str2 = Build.MODEL;
        String str3 = Build.VERSION.RELEASE;
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.f35a = str;
        this.f36b = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!kotlin.jvm.internal.l.a(this.f35a, cVar.f35a)) {
            return false;
        }
        String str = Build.MODEL;
        if (!kotlin.jvm.internal.l.a(str, str)) {
            return false;
        }
        String str2 = Build.VERSION.RELEASE;
        return kotlin.jvm.internal.l.a(str2, str2) && this.f36b.equals(cVar.f36b);
    }

    public final int hashCode() {
        return this.f36b.hashCode() + ((d0.LOG_ENVIRONMENT_PROD.hashCode() + androidx.constraintlayout.core.widgets.analyzer.a.o((((Build.MODEL.hashCode() + (this.f35a.hashCode() * 31)) * 31) + 48517562) * 31, 31, Build.VERSION.RELEASE)) * 31);
    }

    public final String toString() {
        return "ApplicationInfo(appId=" + this.f35a + ", deviceModel=" + Build.MODEL + ", sessionSdkVersion=3.0.3, osVersion=" + Build.VERSION.RELEASE + ", logEnvironment=" + d0.LOG_ENVIRONMENT_PROD + ", androidAppInfo=" + this.f36b + ')';
    }
}
