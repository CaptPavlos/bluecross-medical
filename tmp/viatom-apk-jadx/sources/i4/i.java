package i4;

import a3.i0;
import android.view.KeyEvent;
import android.view.View;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.uptodown.activities.YouTubeActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9007a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f9008b;

    public /* synthetic */ i(KeyEvent.Callback callback, int i10) {
        this.f9007a = i10;
        this.f9008b = callback;
    }

    public final void a(View view, i0 i0Var) {
        int i10 = this.f9007a;
        int i11 = 0;
        KeyEvent.Callback callback = this.f9008b;
        switch (i10) {
            case 0:
                ArrayList arrayList = ((YouTubePlayerView) callback).f6628a;
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    while (i11 < size) {
                        Object obj = arrayList.get(i11);
                        i11++;
                        ((i) obj).a(view, i0Var);
                    }
                    break;
                } else {
                    androidx.window.layout.c.g("To enter fullscreen you need to first register a FullscreenListener.");
                    break;
                }
            default:
                YouTubeActivity youTubeActivity = (YouTubeActivity) callback;
                int i12 = YouTubeActivity.J;
                youTubeActivity.n0().f7143c.setVisibility(8);
                youTubeActivity.n0().f7142b.setVisibility(0);
                youTubeActivity.n0().f7142b.addView(view);
                break;
        }
    }

    public final void b() {
        int i10 = this.f9007a;
        int i11 = 0;
        KeyEvent.Callback callback = this.f9008b;
        switch (i10) {
            case 0:
                ArrayList arrayList = ((YouTubePlayerView) callback).f6628a;
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    while (i11 < size) {
                        Object obj = arrayList.get(i11);
                        i11++;
                        ((i) obj).b();
                    }
                    break;
                } else {
                    androidx.window.layout.c.g("To enter fullscreen you need to first register a FullscreenListener.");
                    break;
                }
            default:
                YouTubeActivity youTubeActivity = (YouTubeActivity) callback;
                int i12 = YouTubeActivity.J;
                youTubeActivity.n0().f7143c.setVisibility(0);
                youTubeActivity.n0().f7142b.setVisibility(8);
                youTubeActivity.n0().f7142b.removeAllViews();
                break;
        }
    }
}
