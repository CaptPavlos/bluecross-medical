package l4;

import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.uptodown.UptodownApp;
import com.uptodown.activities.YouTubeActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class qc extends f4.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10776a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10777b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10778c;

    public /* synthetic */ qc(int i10, Object obj, Object obj2) {
        this.f10776a = i10;
        this.f10777b = obj;
        this.f10778c = obj2;
    }

    @Override // f4.a
    public void a(e4.e eVar, float f) {
        switch (this.f10776a) {
            case 1:
                eVar.getClass();
                UptodownApp.V.put(((n4.k1) this.f10777b).f11412i, Float.valueOf(f));
                break;
            default:
                super.a(eVar, f);
                break;
        }
    }

    @Override // f4.a
    public void b(e4.e eVar, e4.c cVar) {
        switch (this.f10776a) {
            case 0:
                eVar.getClass();
                ((YouTubeActivity) this.f10777b).finish();
                break;
            default:
                super.b(eVar, cVar);
                break;
        }
    }

    @Override // f4.a
    public final void c(e4.e eVar) {
        int i10 = this.f10776a;
        Object obj = this.f10778c;
        switch (i10) {
            case 0:
                eVar.getClass();
                int i11 = YouTubeActivity.J;
                ((i4.g) eVar).d((String) obj, 0.0f);
                break;
            default:
                n4.k1 k1Var = (n4.k1) this.f10777b;
                YouTubePlayerView youTubePlayerView = k1Var.g;
                eVar.getClass();
                if (UptodownApp.Q == 0) {
                    youTubePlayerView.getClass();
                    if (youTubePlayerView.getHeight() != 0) {
                        youTubePlayerView.getClass();
                        UptodownApp.Q = youTubePlayerView.getHeight();
                        youTubePlayerView.getClass();
                        UptodownApp.R = youTubePlayerView.getWidth();
                    }
                }
                x5.c cVar = new x5.c((View) obj, eVar);
                k1Var.f11417n = cVar;
                i4.g gVar = (i4.g) eVar;
                gVar.a(cVar);
                gVar.c(gVar.f9002a, CampaignEx.JSON_NATIVE_VIDEO_MUTE, new Object[0]);
                k1Var.h = eVar;
                k1Var.f11415l = true;
                k1Var.notifyItemChanged(0);
                break;
        }
    }

    @Override // f4.a
    public void d(e4.e eVar, e4.d dVar) {
        switch (this.f10776a) {
            case 1:
                n4.k1 k1Var = (n4.k1) this.f10777b;
                eVar.getClass();
                e4.d dVar2 = e4.d.f;
                if (dVar == dVar2 && k1Var.f) {
                    ((i4.g) eVar).f();
                }
                if (dVar == dVar2 && kotlin.jvm.internal.l.a(k1Var.f11411d, kotlin.jvm.internal.y.a(e5.t1.class).c())) {
                    ((i4.g) eVar).f();
                }
                if (dVar == e4.d.e) {
                    k1Var.f11416m = false;
                }
                if (dVar == e4.d.f7658d) {
                    k1Var.f11416m = true;
                    break;
                }
                break;
            default:
                super.d(eVar, dVar);
                break;
        }
    }
}
