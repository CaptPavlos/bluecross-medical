package i4;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.k;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends d {
    public static final /* synthetic */ int h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final f f8993a;

    /* renamed from: b, reason: collision with root package name */
    public final h4.d f8994b;

    /* renamed from: c, reason: collision with root package name */
    public final h4.e f8995c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8996d;
    public g7.a e;
    public final LinkedHashSet f;
    public boolean g;

    public c(Context context, i iVar) {
        super(context, null, 0);
        f fVar = new f(context, iVar);
        this.f8993a = fVar;
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        h4.d dVar = new h4.d(applicationContext);
        this.f8994b = dVar;
        h4.e eVar = new h4.e();
        this.f8995c = eVar;
        this.e = new k(17);
        this.f = new LinkedHashSet();
        this.g = true;
        addView(fVar, new FrameLayout.LayoutParams(-1, -1));
        g gVar = fVar.f9000c;
        gVar.a(eVar);
        gVar.a(new a(this, 0));
        gVar.a(new a(this, 1));
        dVar.f8450b.add(new b(this));
    }

    public final void a(f4.a aVar, boolean z9, g4.b bVar, String str) {
        if (this.f8996d) {
            androidx.window.layout.c.g("This YouTubePlayerView has already been initialized.");
            return;
        }
        if (z9) {
            this.f8994b.a();
        }
        androidx.work.impl.utils.f fVar = new androidx.work.impl.utils.f(this, bVar, str, aVar, 1);
        this.e = fVar;
        if (z9) {
            return;
        }
        fVar.invoke();
    }

    public final boolean getCanPlay$core_release() {
        return this.g;
    }

    public final f getWebViewYouTubePlayer$core_release() {
        return this.f8993a;
    }

    public final void setCustomPlayerUi(View view) {
        view.getClass();
        removeViews(1, getChildCount() - 1);
        addView(view);
    }

    public final void setYouTubePlayerReady$core_release(boolean z9) {
        this.f8996d = z9;
    }
}
