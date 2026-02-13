package d5;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j1 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7141a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f7142b;

    /* renamed from: c, reason: collision with root package name */
    public final YouTubePlayerView f7143c;

    public j1(RelativeLayout relativeLayout, FrameLayout frameLayout, YouTubePlayerView youTubePlayerView) {
        this.f7141a = relativeLayout;
        this.f7142b = frameLayout;
        this.f7143c = youTubePlayerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7141a;
    }
}
