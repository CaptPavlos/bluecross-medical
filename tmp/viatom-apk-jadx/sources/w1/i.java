package w1;

import android.util.Log;
import j$.util.Objects;
import java.io.File;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final s f13341a;

    /* renamed from: b, reason: collision with root package name */
    public final h f13342b;

    public i(s sVar, c2.d dVar) {
        this.f13341a = sVar;
        this.f13342b = new h(dVar);
    }

    public final String a(String str) {
        String strSubstring;
        h hVar = this.f13342b;
        synchronized (hVar) {
            if (Objects.equals(hVar.f13339b, str)) {
                return hVar.f13340c;
            }
            c2.d dVar = hVar.f13338a;
            c2.a aVar = h.f13337d;
            File file = new File((File) dVar.e, str);
            file.mkdirs();
            List listM = c2.d.m(file.listFiles(aVar));
            if (listM.isEmpty()) {
                strSubstring = null;
                Log.w("FirebaseCrashlytics", "Unable to read App Quality Sessions session id.", null);
            } else {
                strSubstring = ((File) Collections.min(listM, h.e)).getName().substring(4);
            }
            return strSubstring;
        }
    }

    public final void b(String str) {
        h hVar = this.f13342b;
        synchronized (hVar) {
            if (!Objects.equals(hVar.f13339b, str)) {
                h.a(hVar.f13338a, str, hVar.f13340c);
                hVar.f13339b = str;
            }
        }
    }
}
