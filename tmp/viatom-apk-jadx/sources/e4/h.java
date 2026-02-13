package e4;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final i4.f f7663a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f7664b = new Handler(Looper.getMainLooper());

    public h(i4.f fVar) {
        this.f7663a = fVar;
    }

    @JavascriptInterface
    public final boolean sendApiChange() {
        return this.f7664b.post(new g(this, 4));
    }

    @JavascriptInterface
    public final void sendError(String str) {
        c cVar;
        str.getClass();
        if (str.equalsIgnoreCase("2")) {
            cVar = c.f7652b;
        } else if (str.equalsIgnoreCase(CampaignEx.CLICKMODE_ON)) {
            cVar = c.f7653c;
        } else if (str.equalsIgnoreCase("100")) {
            cVar = c.f7654d;
        } else {
            cVar = (str.equalsIgnoreCase("101") || str.equalsIgnoreCase("150")) ? c.e : str.equalsIgnoreCase("153") ? c.f : c.f7651a;
        }
        this.f7664b.post(new androidx.browser.trusted.c(12, this, cVar));
    }

    @JavascriptInterface
    public final void sendPlaybackQualityChange(String str) {
        str.getClass();
        this.f7664b.post(new g(this, str.equalsIgnoreCase("small") ? a.f7641b : str.equalsIgnoreCase("medium") ? a.f7642c : str.equalsIgnoreCase("large") ? a.f7643d : str.equalsIgnoreCase("hd720") ? a.e : str.equalsIgnoreCase("hd1080") ? a.f : str.equalsIgnoreCase("highres") ? a.g : str.equalsIgnoreCase(MRAIDCommunicatorUtil.STATES_DEFAULT) ? a.h : a.f7640a, 1));
    }

    @JavascriptInterface
    public final void sendPlaybackRateChange(String str) {
        str.getClass();
        this.f7664b.post(new g(this, str.equalsIgnoreCase("0.25") ? b.f7646b : str.equalsIgnoreCase("0.5") ? b.f7647c : str.equalsIgnoreCase("0.75") ? b.f7648d : str.equalsIgnoreCase("1") ? b.e : str.equalsIgnoreCase("1.25") ? b.f : str.equalsIgnoreCase("1.5") ? b.g : str.equalsIgnoreCase("1.75") ? b.h : str.equalsIgnoreCase("2") ? b.f7649i : b.f7645a, 3));
    }

    @JavascriptInterface
    public final boolean sendReady() {
        return this.f7664b.post(new g(this, 5));
    }

    @JavascriptInterface
    public final void sendStateChange(String str) {
        str.getClass();
        this.f7664b.post(new androidx.browser.trusted.c(13, this, str.equalsIgnoreCase("UNSTARTED") ? d.f7656b : str.equalsIgnoreCase("ENDED") ? d.f7657c : str.equalsIgnoreCase("PLAYING") ? d.f7658d : str.equalsIgnoreCase("PAUSED") ? d.e : str.equalsIgnoreCase("BUFFERING") ? d.f : str.equalsIgnoreCase("CUED") ? d.g : d.f7655a));
    }

    @JavascriptInterface
    public final void sendVideoCurrentTime(String str) throws NumberFormatException {
        str.getClass();
        try {
            final float f = Float.parseFloat(str);
            this.f7664b.post(new Runnable() { // from class: e4.f
                @Override // java.lang.Runnable
                public final void run() {
                    i4.f fVar = this.f7659a.f7663a;
                    Iterator<T> it = fVar.getListeners().iterator();
                    while (it.hasNext()) {
                        ((f4.a) it.next()).a(fVar.getInstance(), f);
                    }
                }
            });
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    public final void sendVideoDuration(String str) {
        str.getClass();
        try {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.f7664b.post(new g(this, Float.parseFloat(str), 2));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    public final boolean sendVideoId(String str) {
        str.getClass();
        return this.f7664b.post(new androidx.browser.trusted.c(11, this, str));
    }

    @JavascriptInterface
    public final void sendVideoLoadedFraction(String str) {
        str.getClass();
        try {
            this.f7664b.post(new g(this, Float.parseFloat(str), 6));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    public final boolean sendYouTubeIFrameAPIReady() {
        return this.f7664b.post(new g(this, 0));
    }
}
