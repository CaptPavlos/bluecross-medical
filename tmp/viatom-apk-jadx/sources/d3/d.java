package d3;

import android.net.Uri;
import java.net.URL;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final a3.c f6812a;

    /* renamed from: b, reason: collision with root package name */
    public final w6.h f6813b;

    public d(a3.c cVar, w6.h hVar) {
        cVar.getClass();
        hVar.getClass();
        this.f6812a = cVar;
        this.f6813b = hVar;
    }

    public static final URL a(d dVar) {
        dVar.getClass();
        Uri.Builder builderAppendPath = new Uri.Builder().scheme("https").authority("firebase-settings.crashlytics.com").appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp");
        a3.c cVar = dVar.f6812a;
        Uri.Builder builderAppendPath2 = builderAppendPath.appendPath(cVar.f35a).appendPath("settings");
        a3.b bVar = cVar.f36b;
        return new URL(builderAppendPath2.appendQueryParameter("build_version", bVar.f26c).appendQueryParameter("display_version", bVar.f25b).build().toString());
    }
}
