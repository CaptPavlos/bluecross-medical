package i4;

import a3.s;
import android.content.Context;
import android.webkit.WebView;
import java.util.Collection;
import java.util.List;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends WebView {

    /* renamed from: a, reason: collision with root package name */
    public final i f8998a;

    /* renamed from: b, reason: collision with root package name */
    public final e4.j f8999b;

    /* renamed from: c, reason: collision with root package name */
    public final g f9000c;

    /* renamed from: d, reason: collision with root package name */
    public s f9001d;
    public boolean e;
    public final e4.h f;

    public f(Context context, i iVar) {
        super(context, null, 0);
        this.f8998a = iVar;
        e4.j jVar = new e4.j();
        this.f8999b = jVar;
        this.f9000c = new g(this, jVar);
        this.f = new e4.h(this);
    }

    @Override // android.webkit.WebView
    public final void destroy() {
        g gVar = this.f9000c;
        synchronized (gVar.f9004c) {
            gVar.f9005d.clear();
        }
        gVar.f9003b.removeCallbacksAndMessages(null);
        super.destroy();
    }

    public e4.e getInstance() {
        return this.f9000c;
    }

    public Collection<f4.a> getListeners() {
        List listR0;
        g gVar = this.f9000c;
        synchronized (gVar.f9004c) {
            listR0 = l.r0(gVar.f9005d);
        }
        return listR0;
    }

    public final e4.e getYoutubePlayer$core_release() {
        return this.f9000c;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onWindowVisibilityChanged(int i10) {
        if (this.e && (i10 == 8 || i10 == 4)) {
            return;
        }
        super.onWindowVisibilityChanged(i10);
    }

    public final void setBackgroundPlaybackEnabled$core_release(boolean z9) {
        this.e = z9;
    }
}
