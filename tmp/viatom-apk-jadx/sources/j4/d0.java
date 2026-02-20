package j4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d0 {
    public static final AtomicInteger e = new AtomicInteger();

    /* renamed from: a, reason: collision with root package name */
    public final y f9929a;

    /* renamed from: b, reason: collision with root package name */
    public final c0 f9930b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9931c;

    /* renamed from: d, reason: collision with root package name */
    public int f9932d;

    public d0(y yVar, Uri uri, int i10) {
        this.f9929a = yVar;
        c0 c0Var = new c0();
        c0Var.f9925b = uri;
        c0Var.f9926c = i10;
        this.f9930b = c0Var;
    }

    public final c0 a(long j10) {
        e.getAndIncrement();
        c0 c0Var = this.f9930b;
        boolean z9 = c0Var.f;
        if (z9 && c0Var.f9927d == 0 && c0Var.e == 0) {
            androidx.window.layout.c.g("Center crop requires calling resize with positive width and height.");
            return null;
        }
        if (c0Var.h == 0) {
            c0Var.h = 2;
        }
        return new c0((Uri) c0Var.f9925b, c0Var.f9926c, (ArrayList) c0Var.f9928i, c0Var.f9927d, c0Var.e, z9, c0Var.g, c0Var.h);
    }

    public final void b(g gVar) {
        long jNanoTime = System.nanoTime();
        if (this.f9931c) {
            androidx.window.layout.c.g("Fit cannot be used with fetch.");
            return;
        }
        c0 c0Var = this.f9930b;
        if (((Uri) c0Var.f9925b) == null && c0Var.f9926c == 0) {
            return;
        }
        int i10 = c0Var.h;
        if (i10 == 0) {
            if (i10 != 0) {
                androidx.window.layout.c.g("Priority already set.");
                return;
            }
            c0Var.h = 1;
        }
        c0 c0VarA = a(jNanoTime);
        String strA = l0.a(c0VarA, new StringBuilder());
        y yVar = this.f9929a;
        if (yVar.g(strA) != null) {
            if (gVar != null) {
                gVar.onSuccess();
            }
        } else {
            o oVar = new o(yVar, c0VarA, strA, gVar);
            l lVar = yVar.f10014c.h;
            lVar.sendMessage(lVar.obtainMessage(1, oVar));
        }
    }

    public final Bitmap c() {
        long jNanoTime = System.nanoTime();
        StringBuilder sb = l0.f9987a;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            androidx.window.layout.c.g("Method call should not happen from the main thread.");
            return null;
        }
        if (this.f9931c) {
            androidx.window.layout.c.g("Fit cannot be used with get.");
            return null;
        }
        c0 c0Var = this.f9930b;
        Object obj = null;
        if (((Uri) c0Var.f9925b) == null && c0Var.f9926c == 0) {
            return null;
        }
        c0 c0VarA = a(jNanoTime);
        y yVar = this.f9929a;
        return f.e(yVar, yVar.f10014c, yVar.f10015d, yVar.e, new p(yVar, obj, c0VarA, l0.a(c0VarA, new StringBuilder()), 0)).f();
    }

    public final Drawable d() {
        int i10 = this.f9932d;
        if (i10 != 0) {
            return this.f9929a.f10013b.getDrawable(i10);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(ImageView imageView, g gVar) {
        long jNanoTime = System.nanoTime();
        StringBuilder sb = l0.f9987a;
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            androidx.window.layout.c.g("Method call should happen from the main thread.");
            return;
        }
        if (imageView == null) {
            com.google.gson.internal.a.n("Target must not be null.");
            return;
        }
        c0 c0Var = this.f9930b;
        Uri uri = (Uri) c0Var.f9925b;
        y yVar = this.f9929a;
        if (uri == null && c0Var.f9926c == 0) {
            yVar.a(imageView);
            z.a(imageView, d());
            return;
        }
        if (this.f9931c) {
            if (c0Var.f9927d != 0 || c0Var.e != 0) {
                androidx.window.layout.c.g("Fit cannot be used with resize.");
                return;
            }
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            if (width == 0 || height == 0) {
                z.a(imageView, d());
                j jVar = new j(this, imageView, gVar);
                WeakHashMap weakHashMap = yVar.g;
                if (weakHashMap.containsKey(imageView)) {
                    yVar.a(imageView);
                }
                weakHashMap.put(imageView, jVar);
                return;
            }
            c0Var.e(width, height);
        }
        c0 c0VarA = a(jNanoTime);
        StringBuilder sb2 = l0.f9987a;
        String strA = l0.a(c0VarA, sb2);
        sb2.setLength(0);
        Bitmap bitmapG = yVar.g(strA);
        if (bitmapG == null) {
            z.a(imageView, d());
            q qVar = new q(yVar, imageView, c0VarA, strA);
            qVar.h = gVar;
            yVar.c(qVar);
            return;
        }
        yVar.a(imageView);
        Context context = yVar.f10013b;
        int i10 = z.e;
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new z(context, bitmapG, drawable, 1));
        if (gVar != null) {
            gVar.onSuccess();
        }
    }

    public final void f(int i10) {
        if (i10 != 0) {
            this.f9932d = i10;
        } else {
            com.google.gson.internal.a.n("Placeholder image resource invalid.");
        }
    }

    public final void g(i0 i0Var) {
        i0Var.key();
        c0 c0Var = this.f9930b;
        if (((ArrayList) c0Var.f9928i) == null) {
            c0Var.f9928i = new ArrayList(2);
        }
        ((ArrayList) c0Var.f9928i).add(i0Var);
    }
}
