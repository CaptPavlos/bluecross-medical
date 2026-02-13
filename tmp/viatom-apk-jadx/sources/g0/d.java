package g0;

import a3.x;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import androidx.collection.ArraySet;
import c1.d0;
import com.google.android.gms.internal.measurement.h0;
import h0.q;
import i0.y;
import java.util.Collections;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8187a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8188b;

    /* renamed from: c, reason: collision with root package name */
    public final a4.f f8189c;

    /* renamed from: d, reason: collision with root package name */
    public final a f8190d;
    public final h0.a e;
    public final Looper f;
    public final int g;
    public final q h;

    /* renamed from: i, reason: collision with root package name */
    public final d0 f8191i;

    /* renamed from: j, reason: collision with root package name */
    public final h0.e f8192j;

    public d(Context context, a4.f fVar, a aVar, c cVar) {
        y.h(context, "Null context is not permitted.");
        y.h(fVar, "Api must not be null.");
        y.h(cVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        y.h(applicationContext, "The provided context did not have an application context.");
        this.f8187a = applicationContext;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : null;
        this.f8188b = attributionTag;
        this.f8189c = fVar;
        this.f8190d = aVar;
        this.f = cVar.f8186b;
        this.e = new h0.a(fVar, aVar, attributionTag);
        this.h = new q(this);
        h0.e eVarD = h0.e.d(applicationContext);
        this.f8192j = eVarD;
        this.g = eVarD.h.getAndIncrement();
        this.f8191i = cVar.f8185a;
        h0 h0Var = eVarD.f8371m;
        h0Var.sendMessage(h0Var.obtainMessage(7, this));
    }

    public final x a() {
        x xVar = new x(27, false);
        Set set = Collections.EMPTY_SET;
        if (((ArraySet) xVar.f181b) == null) {
            xVar.f181b = new ArraySet();
        }
        ((ArraySet) xVar.f181b).addAll(set);
        Context context = this.f8187a;
        xVar.f183d = context.getClass().getName();
        xVar.f182c = context.getPackageName();
        return xVar;
    }
}
