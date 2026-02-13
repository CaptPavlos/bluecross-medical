package i4;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends f4.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9009a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ YouTubePlayerView f9010b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f9011c;

    public j(String str, YouTubePlayerView youTubePlayerView, boolean z9) {
        this.f9009a = str;
        this.f9010b = youTubePlayerView;
        this.f9011c = z9;
    }

    @Override // f4.a
    public final void c(e4.e eVar) {
        eVar.getClass();
        String str = this.f9009a;
        if (str != null) {
            if (this.f9010b.f6629b.getCanPlay$core_release() && this.f9011c) {
                ((g) eVar).d(str, 0.0f);
            } else {
                ((g) eVar).b(str, 0.0f);
            }
        }
        g gVar = (g) eVar;
        synchronized (gVar.f9004c) {
            gVar.f9005d.remove(this);
        }
    }
}
