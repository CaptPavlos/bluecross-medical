package i4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f8992a;

    public b(c cVar) {
        this.f8992a = cVar;
    }

    public final void a() {
        c cVar = this.f8992a;
        if (!cVar.f8996d) {
            cVar.e.invoke();
            return;
        }
        h4.e eVar = cVar.f8995c;
        e4.e youtubePlayer$core_release = cVar.getWebViewYouTubePlayer$core_release().getYoutubePlayer$core_release();
        eVar.getClass();
        youtubePlayer$core_release.getClass();
        String str = eVar.f8456d;
        if (str == null) {
            return;
        }
        boolean z9 = eVar.f8454b;
        e4.c cVar2 = e4.c.f7653c;
        if (z9 && eVar.f8455c == cVar2) {
            boolean z10 = eVar.f8453a;
            float f = eVar.e;
            if (z10) {
                ((g) youtubePlayer$core_release).d(str, f);
            } else {
                ((g) youtubePlayer$core_release).b(str, f);
            }
        } else if (!z9 && eVar.f8455c == cVar2) {
            ((g) youtubePlayer$core_release).b(str, eVar.e);
        }
        eVar.f8455c = null;
    }
}
