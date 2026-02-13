package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static double f4382a = -1.0d;

    /* renamed from: b, reason: collision with root package name */
    private Context f4383b;

    /* renamed from: c, reason: collision with root package name */
    private AudioManager f4384c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4385d = false;
    private b e;
    private a f;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<d> f4386a;

        public a(d dVar) {
            this.f4386a = new WeakReference<>(dVar);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            d dVar;
            b bVarB;
            if (!"android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) || intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) != 3 || (dVar = this.f4386a.get()) == null || (bVarB = dVar.b()) == null) {
                return;
            }
            double dA = dVar.a();
            if (dA >= 0.0d) {
                bVarB.a(dA);
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface b {
        void a(double d8);
    }

    public d(Context context) {
        this.f4383b = context;
        this.f4384c = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    public final double a() {
        AudioManager audioManager = this.f4384c;
        double streamVolume = ((this.f4384c != null ? r3.getStreamVolume(3) : -1) * 100.0d) / (audioManager != null ? audioManager.getStreamMaxVolume(3) : -1);
        f4382a = streamVolume;
        return streamVolume;
    }

    public final b b() {
        return this.e;
    }

    public final void c() {
        if (this.f4383b != null) {
            this.f = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.f4383b.registerReceiver(this.f, intentFilter);
            this.f4385d = true;
        }
    }

    public final void d() {
        Context context;
        if (!this.f4385d || (context = this.f4383b) == null) {
            return;
        }
        try {
            context.unregisterReceiver(this.f);
            this.e = null;
            this.f4385d = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(b bVar) {
        this.e = bVar;
    }
}
