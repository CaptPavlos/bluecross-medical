package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.ConnectivityManager;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import d4.a;
import g4.b;
import h0.r;
import i4.c;
import i4.d;
import i4.f;
import i4.g;
import i4.h;
import i4.i;
import i4.j;
import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class YouTubePlayerView extends d implements LifecycleEventObserver {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f6628a;

    /* renamed from: b, reason: collision with root package name */
    public final c f6629b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6630c;

    public YouTubePlayerView(Context context, AttributeSet attributeSet, int i10) throws JSONException {
        super(context, attributeSet, 0);
        this.f6628a = new ArrayList();
        c cVar = new c(context, new i(this, 0));
        this.f6629b = cVar;
        addView(cVar, new FrameLayout.LayoutParams(-1, -1));
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.f6837a, 0, 0);
        typedArrayObtainStyledAttributes.getClass();
        this.f6630c = typedArrayObtainStyledAttributes.getBoolean(1, true);
        boolean z9 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(2, true);
        String string = typedArrayObtainStyledAttributes.getString(3);
        typedArrayObtainStyledAttributes.recycle();
        if (z9 && string == null) {
            androidx.window.layout.c.g("YouTubePlayerView: videoId is not set but autoPlay is set to true. This combination is not allowed.");
            throw null;
        }
        j jVar = new j(string, this, z9);
        if (this.f6630c) {
            g4.a aVar = new g4.a(context);
            aVar.b(1, "controls");
            cVar.a(jVar, z10, new b(aVar.f8228a), string);
        }
    }

    public final void a(f4.a aVar, b bVar) {
        if (this.f6630c) {
            androidx.window.layout.c.g("YouTubePlayerView: If you want to initialize this view manually, you need to set 'enableAutomaticInitialization' to false.");
            return;
        }
        c cVar = this.f6629b;
        cVar.getClass();
        cVar.a(aVar, true, bVar, null);
    }

    public final void b() {
        c cVar = this.f6629b;
        f fVar = cVar.f8993a;
        h4.d dVar = cVar.f8994b;
        Context context = dVar.f8449a;
        if (Build.VERSION.SDK_INT >= 24) {
            h4.c cVar2 = dVar.f8452d;
            if (cVar2 != null) {
                Object systemService = context.getSystemService("connectivity");
                systemService.getClass();
                ((ConnectivityManager) systemService).unregisterNetworkCallback(cVar2);
                dVar.f8450b.clear();
                dVar.f8452d = null;
                dVar.f8451c = null;
            }
        } else {
            r rVar = dVar.f8451c;
            if (rVar != null) {
                try {
                    context.unregisterReceiver(rVar);
                } catch (Throwable unused) {
                }
                dVar.f8450b.clear();
                dVar.f8452d = null;
                dVar.f8451c = null;
            }
        }
        cVar.removeView(fVar);
        fVar.removeAllViews();
        fVar.destroy();
    }

    public final boolean getEnableAutomaticInitialization() {
        return this.f6630c;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        lifecycleOwner.getClass();
        event.getClass();
        int i10 = h.f9006a[event.ordinal()];
        c cVar = this.f6629b;
        switch (i10) {
            case 1:
                cVar.f8995c.f8453a = true;
                cVar.g = true;
                break;
            case 2:
                ((g) cVar.f8993a.getYoutubePlayer$core_release()).e();
                cVar.f8995c.f8453a = false;
                cVar.g = false;
                break;
            case 3:
                b();
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                break;
            default:
                androidx.window.layout.c.b();
                break;
        }
    }

    public final void setCustomPlayerUi(View view) {
        view.getClass();
        this.f6629b.setCustomPlayerUi(view);
    }

    public final void setEnableAutomaticInitialization(boolean z9) {
        this.f6630c = z9;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        context.getClass();
    }
}
