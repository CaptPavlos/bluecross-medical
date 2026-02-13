package androidx.work.impl.utils;

import a3.s;
import android.content.Context;
import android.webkit.WebSettings;
import androidx.work.ForegroundInfo;
import com.google.android.gms.internal.measurement.l5;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.uptodown.R;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import o7.u;
import s6.w;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f766a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f767b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f768c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f769d;
    public final /* synthetic */ Object e;

    public /* synthetic */ f(Object obj, Object obj2, Object obj3, Object obj4, int i10) {
        this.f766a = i10;
        this.f767b = obj;
        this.f768c = obj2;
        this.f769d = obj3;
        this.e = obj4;
    }

    @Override // g7.a
    public final Object invoke() {
        String str;
        switch (this.f766a) {
            case 0:
                return ((WorkForegroundUpdater) this.f767b).lambda$setForegroundAsync$0((UUID) this.f768c, (ForegroundInfo) this.f769d, (Context) this.e);
            default:
                i4.c cVar = (i4.c) this.f767b;
                g4.b bVar = (g4.b) this.f768c;
                String str2 = (String) this.f769d;
                f4.a aVar = (f4.a) this.e;
                i4.f fVar = cVar.f8993a;
                s sVar = new s(aVar, 13);
                fVar.getClass();
                fVar.f9001d = sVar;
                WebSettings settings = fVar.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setMediaPlaybackRequiresUserGesture(false);
                settings.setCacheMode(-1);
                fVar.addJavascriptInterface(fVar.f, "YouTubePlayerBridge");
                fVar.addJavascriptInterface(fVar.f8999b, "YouTubePlayerCallbacks");
                InputStream inputStreamOpenRawResource = fVar.getResources().openRawResource(R.raw.ayp_youtube_player);
                inputStreamOpenRawResource.getClass();
                try {
                    try {
                        String strH0 = l.h0(l5.D(new BufferedReader(new InputStreamReader(inputStreamOpenRawResource, "utf-8"))), "\n", null, null, null, 62);
                        inputStreamOpenRawResource.close();
                        if (str2 != null) {
                            str = "'" + str2 + '\'';
                        } else {
                            str = "undefined";
                        }
                        String strB0 = u.b0(u.b0(strH0, "<<injectedVideoId>>", str, false), "<<injectedPlayerVars>>", bVar.toString(), false);
                        String string = bVar.f8230b.getString(TtmlNode.ATTR_TTS_ORIGIN);
                        string.getClass();
                        fVar.loadDataWithBaseURL(string, strB0, "text/html", "utf-8", null);
                        fVar.setWebChromeClient(new i4.e(fVar));
                        return w.f12711a;
                    } catch (Exception unused) {
                        throw new RuntimeException("Can't parse HTML file.");
                    }
                } finally {
                }
        }
    }
}
