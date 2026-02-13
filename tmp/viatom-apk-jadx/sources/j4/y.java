package j4;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.squareup.picasso.PicassoProvider;
import com.uptodown.R;
import j$.util.DesugarCollections;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y {

    /* renamed from: i, reason: collision with root package name */
    public static final com.google.android.gms.internal.measurement.h0 f10010i = new com.google.android.gms.internal.measurement.h0(Looper.getMainLooper(), 1, false);

    /* renamed from: j, reason: collision with root package name */
    public static volatile y f10011j = null;

    /* renamed from: a, reason: collision with root package name */
    public final List f10012a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f10013b;

    /* renamed from: c, reason: collision with root package name */
    public final n f10014c;

    /* renamed from: d, reason: collision with root package name */
    public final y2.c f10015d;
    public final g0 e;
    public final WeakHashMap f;
    public final WeakHashMap g;
    public final ReferenceQueue h;

    public y(Context context, n nVar, y2.c cVar, g0 g0Var) {
        this.f10013b = context;
        this.f10014c = nVar;
        this.f10015d = cVar;
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(new i(context, 1));
        arrayList.add(new h(context));
        int i10 = 0;
        arrayList.add(new u(context, i10));
        arrayList.add(new i(context, i10));
        arrayList.add(new c(context));
        arrayList.add(new u(context, 1));
        arrayList.add(new x(nVar.f9992c, g0Var));
        this.f10012a = DesugarCollections.unmodifiableList(arrayList);
        this.e = g0Var;
        this.f = new WeakHashMap();
        this.g = new WeakHashMap();
        ReferenceQueue referenceQueue = new ReferenceQueue();
        this.h = referenceQueue;
        new a5.a(referenceQueue, f10010i).start();
    }

    public static y d() {
        if (f10011j == null) {
            synchronized (y.class) {
                try {
                    if (f10011j == null) {
                        Context context = PicassoProvider.f6631a;
                        if (context == null) {
                            throw new IllegalStateException("context == null");
                        }
                        Context applicationContext = context.getApplicationContext();
                        d0.i iVar = new d0.i(applicationContext, 18);
                        y2.c cVar = new y2.c(applicationContext);
                        b0 b0Var = new b0(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new k0());
                        g0 g0Var = new g0(cVar);
                        f10011j = new y(applicationContext, new n(applicationContext, b0Var, f10010i, iVar, cVar, g0Var), cVar, g0Var);
                    }
                } finally {
                }
            }
        }
        return f10011j;
    }

    public final void a(Object obj) {
        StringBuilder sb = l0.f9987a;
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            androidx.window.layout.c.g("Method call should happen from the main thread.");
            return;
        }
        b bVar = (b) this.f.remove(obj);
        if (bVar != null) {
            bVar.a();
            l lVar = this.f10014c.h;
            lVar.sendMessage(lVar.obtainMessage(2, bVar));
        }
        if (obj instanceof ImageView) {
            j jVar = (j) this.g.remove((ImageView) obj);
            if (jVar != null) {
                jVar.f9981c = null;
                WeakReference weakReference = jVar.f9980b;
                ImageView imageView = (ImageView) weakReference.get();
                if (imageView == null) {
                    return;
                }
                weakReference.clear();
                imageView.removeOnAttachStateChangeListener(jVar);
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(jVar);
                }
            }
        }
    }

    public final void b(Bitmap bitmap, int i10, b bVar, Exception exc) {
        if (bVar.g) {
            return;
        }
        if (!bVar.f) {
            this.f.remove(bVar.d());
        }
        if (bitmap == null) {
            bVar.c(exc);
        } else if (i10 != 0) {
            bVar.b(bitmap, i10);
        } else {
            p8.u.h("LoadedFrom cannot be null.");
        }
    }

    public final void c(b bVar) {
        Object objD = bVar.d();
        if (objD != null) {
            WeakHashMap weakHashMap = this.f;
            if (weakHashMap.get(objD) != bVar) {
                a(objD);
                weakHashMap.put(objD, bVar);
            }
        }
        l lVar = this.f10014c.h;
        lVar.sendMessage(lVar.obtainMessage(1, bVar));
    }

    public final d0 e(String str) {
        if (str == null) {
            return new d0(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return new d0(this, Uri.parse(str), 0);
        }
        com.google.gson.internal.a.n("Path must not be empty.");
        return null;
    }

    public final d0 f() {
        return new d0(this, null, R.drawable.vector_user_default);
    }

    public final Bitmap g(String str) {
        s sVar = (s) ((r) this.f10015d.f13781b).get(str);
        Bitmap bitmap = sVar != null ? sVar.f10000a : null;
        g0 g0Var = this.e;
        if (bitmap != null) {
            g0Var.f9957b.sendEmptyMessage(0);
            return bitmap;
        }
        g0Var.f9957b.sendEmptyMessage(1);
        return bitmap;
    }
}
