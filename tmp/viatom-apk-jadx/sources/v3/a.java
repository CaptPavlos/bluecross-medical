package v3;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import j$.util.DesugarCollections;
import java.util.Iterator;
import t3.h;
import w3.c;
import w3.i;
import w3.j;

/* loaded from: classes3.dex */
public final class a extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13121a;

    /* renamed from: b, reason: collision with root package name */
    public final AudioManager f13122b;

    /* renamed from: c, reason: collision with root package name */
    public final h f13123c;

    /* renamed from: d, reason: collision with root package name */
    public final j f13124d;
    public float e;

    public a(Handler handler, Context context, h hVar, j jVar) {
        super(handler);
        this.f13121a = context;
        this.f13122b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f13123c = hVar;
        this.f13124d = jVar;
    }

    public final float a() {
        AudioManager audioManager = this.f13122b;
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        this.f13123c.getClass();
        if (streamMaxVolume <= 0 || streamVolume <= 0) {
            return 0.0f;
        }
        float f = streamVolume / streamMaxVolume;
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public final void b() {
        float f = this.e;
        j jVar = this.f13124d;
        jVar.f13512a = f;
        if (jVar.f13515d == null) {
            jVar.f13515d = c.f13498c;
        }
        Iterator it = DesugarCollections.unmodifiableCollection(jVar.f13515d.f13500b).iterator();
        while (it.hasNext()) {
            y3.a aVar = ((t3.j) it.next()).e;
            i.f13511a.a(aVar.f(), "setDeviceVolume", Float.valueOf(f), aVar.f13782a);
        }
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z9) {
        super.onChange(z9);
        float fA = a();
        if (fA != this.e) {
            this.e = fA;
            b();
        }
    }
}
