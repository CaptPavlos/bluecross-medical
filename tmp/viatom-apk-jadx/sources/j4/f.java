package j4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements Runnable {

    /* renamed from: s, reason: collision with root package name */
    public static final Object f9939s = new Object();
    public static final h0.b0 t = new h0.b0(1);

    /* renamed from: u, reason: collision with root package name */
    public static final AtomicInteger f9940u = new AtomicInteger();

    /* renamed from: v, reason: collision with root package name */
    public static final d f9941v = new d();

    /* renamed from: a, reason: collision with root package name */
    public final int f9942a = f9940u.incrementAndGet();

    /* renamed from: b, reason: collision with root package name */
    public final y f9943b;

    /* renamed from: c, reason: collision with root package name */
    public final n f9944c;

    /* renamed from: d, reason: collision with root package name */
    public final y2.c f9945d;
    public final g0 e;
    public final String f;
    public final c0 g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public final f0 f9946i;

    /* renamed from: j, reason: collision with root package name */
    public b f9947j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f9948k;

    /* renamed from: l, reason: collision with root package name */
    public Bitmap f9949l;

    /* renamed from: m, reason: collision with root package name */
    public Future f9950m;

    /* renamed from: n, reason: collision with root package name */
    public int f9951n;

    /* renamed from: o, reason: collision with root package name */
    public Exception f9952o;

    /* renamed from: p, reason: collision with root package name */
    public int f9953p;

    /* renamed from: q, reason: collision with root package name */
    public int f9954q;

    /* renamed from: r, reason: collision with root package name */
    public int f9955r;

    public f(y yVar, n nVar, y2.c cVar, g0 g0Var, b bVar, f0 f0Var) {
        this.f9943b = yVar;
        this.f9944c = nVar;
        this.f9945d = cVar;
        this.e = g0Var;
        this.f9947j = bVar;
        this.f = bVar.f9920d;
        c0 c0Var = bVar.f9918b;
        this.g = c0Var;
        this.f9955r = c0Var.h;
        this.h = 0;
        this.f9946i = f0Var;
        this.f9954q = f0Var.d();
    }

    public static Bitmap a(List list, Bitmap bitmap) {
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            i0 i0Var = (i0) list.get(i10);
            try {
                Bitmap bitmapA = i0Var.a(bitmap);
                if (bitmapA == null) {
                    StringBuilder sbV = a3.a.v("Transformation ");
                    sbV.append(i0Var.key());
                    sbV.append(" returned null after ");
                    sbV.append(i10);
                    sbV.append(" previous transformation(s).\n\nTransformation list:\n");
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        sbV.append(((i0) it.next()).key());
                        sbV.append('\n');
                    }
                    y.f10010i.post(new a4.a(sbV, 15));
                    return null;
                }
                if (bitmapA == bitmap && bitmap.isRecycled()) {
                    y.f10010i.post(new e(i0Var, 0));
                    return null;
                }
                if (bitmapA != bitmap && !bitmap.isRecycled()) {
                    y.f10010i.post(new e(i0Var, 1));
                    return null;
                }
                i10++;
                bitmap = bitmapA;
            } catch (RuntimeException e) {
                y.f10010i.post(new k1.a(26, i0Var, e));
                return null;
            }
        }
        return bitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Bitmap c(z8.h0 h0Var, c0 c0Var) throws IOException {
        h0Var.getClass();
        z8.b0 b0Var = new z8.b0(h0Var);
        boolean z9 = b0Var.a(0L, l0.f9988b) && b0Var.a(8L, l0.f9989c);
        c0Var.getClass();
        int i10 = c0Var.e;
        int i11 = c0Var.f9927d;
        BitmapFactory.Options optionsC = f0.c(c0Var);
        boolean z10 = optionsC != null && optionsC.inJustDecodeBounds;
        if (z9) {
            z8.i iVar = b0Var.f14457b;
            iVar.j(h0Var);
            byte[] byteArray = iVar.readByteArray(iVar.f14479b);
            if (z10) {
                BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, optionsC);
                f0.a(i11, i10, optionsC.outWidth, optionsC.outHeight, optionsC, c0Var);
            }
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, optionsC);
        }
        z8.g gVar = new z8.g(b0Var, 1);
        if (z10) {
            t tVar = new t(gVar);
            tVar.f = false;
            long j10 = tVar.f10003b + 1024;
            if (tVar.f10005d < j10) {
                tVar.b(j10);
            }
            long j11 = tVar.f10003b;
            BitmapFactory.decodeStream(tVar, null, optionsC);
            f0.a(i11, i10, optionsC.outWidth, optionsC.outHeight, optionsC, c0Var);
            tVar.a(j11);
            tVar.f = true;
            gVar = tVar;
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(gVar, null, optionsC);
        if (bitmapDecodeStream != null) {
            return bitmapDecodeStream;
        }
        com.google.gson.internal.a.m("Failed to decode stream.");
        return null;
    }

    public static f e(y yVar, n nVar, y2.c cVar, g0 g0Var, b bVar) {
        c0 c0Var = bVar.f9918b;
        List list = yVar.f10012a;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            f0 f0Var = (f0) list.get(i10);
            if (f0Var.b(c0Var)) {
                return new f(yVar, nVar, cVar, g0Var, bVar, f0Var);
            }
        }
        return new f(yVar, nVar, cVar, g0Var, bVar, f9941v);
    }

    public static Bitmap g(c0 c0Var, Bitmap bitmap, int i10) {
        float f;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        c0Var.getClass();
        int i17 = c0Var.g;
        int i18 = c0Var.e;
        int i19 = c0Var.f9927d;
        int i20 = i18;
        Matrix matrix = new Matrix();
        int i21 = 0;
        if (c0Var.d() || i10 != 0) {
            if (i10 != 0) {
                switch (i10) {
                    case 3:
                    case 4:
                        i16 = SubsamplingScaleImageView.ORIENTATION_180;
                        break;
                    case 5:
                    case 6:
                        i16 = 90;
                        break;
                    case 7:
                    case 8:
                        i16 = 270;
                        break;
                    default:
                        i16 = 0;
                        break;
                }
                int i22 = (i10 == 2 || i10 == 7 || i10 == 4 || i10 == 5) ? -1 : 1;
                if (i16 != 0) {
                    matrix.preRotate(i16);
                    if (i16 == 90 || i16 == 270) {
                        i20 = i19;
                        i19 = i20;
                    }
                }
                if (i22 != 1) {
                    matrix.postScale(i22, 1.0f);
                }
            }
            if (c0Var.f) {
                if (i19 != 0) {
                    f13 = i19;
                    f14 = width;
                } else {
                    f13 = i20;
                    f14 = height;
                }
                float f17 = f13 / f14;
                if (i20 != 0) {
                    f15 = i20;
                    f16 = height;
                } else {
                    f15 = i19;
                    f16 = width;
                }
                float f18 = f15 / f16;
                if (f17 > f18) {
                    int iCeil = (int) Math.ceil((f18 / f17) * height);
                    int i23 = (i17 & 48) == 48 ? 0 : (i17 & 80) == 80 ? height - iCeil : (height - iCeil) / 2;
                    height = iCeil;
                    f18 = i20 / iCeil;
                    i11 = i23;
                } else if (f17 < f18) {
                    int iCeil2 = (int) Math.ceil((f17 / f18) * width);
                    int i24 = (i17 & 3) == 3 ? 0 : (i17 & 5) == 5 ? width - iCeil2 : (width - iCeil2) / 2;
                    width = iCeil2;
                    f17 = i19 / iCeil2;
                    i11 = 0;
                    i21 = i24;
                } else {
                    f17 = f18;
                    i11 = 0;
                }
                matrix.preScale(f17, f18);
                int i25 = height;
                i12 = width;
                i13 = i11;
                i14 = i25;
                i15 = i21;
            } else {
                if ((i19 != 0 || i20 != 0) && (i19 != width || i20 != height)) {
                    if (i19 != 0) {
                        f = i19;
                        f10 = width;
                    } else {
                        f = i20;
                        f10 = height;
                    }
                    float f19 = f / f10;
                    if (i20 != 0) {
                        f11 = i20;
                        f12 = height;
                    } else {
                        f11 = i19;
                        f12 = width;
                    }
                    matrix.preScale(f19, f11 / f12);
                }
                i14 = height;
                i15 = 0;
                i12 = width;
                i13 = 0;
            }
        } else {
            i14 = height;
            i15 = 0;
            i12 = width;
            i13 = 0;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i15, i13, i12, i14, matrix, true);
        if (bitmapCreateBitmap == bitmap) {
            return bitmap;
        }
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    public static void h(c0 c0Var) {
        Uri uri = (Uri) c0Var.f9925b;
        String strValueOf = uri != null ? String.valueOf(uri.getPath()) : Integer.toHexString(c0Var.f9926c);
        StringBuilder sb = (StringBuilder) t.get();
        sb.ensureCapacity(strValueOf.length() + 8);
        sb.replace(8, sb.length(), strValueOf);
        Thread.currentThread().setName(sb.toString());
    }

    public final boolean b() {
        ArrayList arrayList;
        Future future;
        return this.f9947j == null && ((arrayList = this.f9948k) == null || arrayList.isEmpty()) && (future = this.f9950m) != null && future.cancel(false);
    }

    public final void d(b bVar) {
        boolean zRemove;
        if (this.f9947j == bVar) {
            this.f9947j = null;
            zRemove = true;
        } else {
            ArrayList arrayList = this.f9948k;
            zRemove = arrayList != null ? arrayList.remove(bVar) : false;
        }
        if (zRemove && bVar.f9918b.h == this.f9955r) {
            ArrayList arrayList2 = this.f9948k;
            boolean z9 = (arrayList2 == null || arrayList2.isEmpty()) ? false : true;
            b bVar2 = this.f9947j;
            if (bVar2 != null || z9) {
                i = bVar2 != null ? bVar2.f9918b.h : 1;
                if (z9) {
                    int size = this.f9948k.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        int i11 = ((b) this.f9948k.get(i10)).f9918b.h;
                        if (c.i.c(i11) > c.i.c(i)) {
                            i = i11;
                        }
                    }
                }
            }
            this.f9955r = i;
        }
        this.f9943b.getClass();
    }

    public final Bitmap f() throws IOException {
        s sVar = (s) ((r) this.f9945d.f13781b).get(this.f);
        Bitmap bitmapG = sVar != null ? sVar.f10000a : null;
        boolean z9 = true;
        if (bitmapG != null) {
            this.e.f9957b.sendEmptyMessage(0);
            this.f9951n = 1;
            this.f9943b.getClass();
            return bitmapG;
        }
        int i10 = this.f9954q == 0 ? 4 : this.h;
        this.h = i10;
        e0 e0VarE = this.f9946i.e(this.g, i10);
        if (e0VarE != null) {
            this.f9951n = e0VarE.f9935a;
            this.f9953p = e0VarE.f9938d;
            bitmapG = e0VarE.f9936b;
            if (bitmapG == null) {
                z8.h0 h0Var = e0VarE.f9937c;
                try {
                    bitmapG = c(h0Var, this.g);
                } finally {
                    try {
                        h0Var.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }
        if (bitmapG != null) {
            this.f9943b.getClass();
            g0 g0Var = this.e;
            g0Var.getClass();
            StringBuilder sb = l0.f9987a;
            int allocationByteCount = bitmapG.getAllocationByteCount();
            if (allocationByteCount < 0) {
                com.google.gson.internal.a.h(bitmapG, "Negative size: ");
                return null;
            }
            l lVar = g0Var.f9957b;
            lVar.sendMessage(lVar.obtainMessage(2, allocationByteCount, 0));
            c0 c0Var = this.g;
            if (c0Var.d() || ((List) c0Var.f9928i) != null || this.f9953p != 0) {
                synchronized (f9939s) {
                    try {
                        if (this.g.d() || this.f9953p != 0) {
                            bitmapG = g(this.g, bitmapG, this.f9953p);
                            this.f9943b.getClass();
                        }
                        List list = (List) this.g.f9928i;
                        if (list == null) {
                            z9 = false;
                        }
                        if (z9) {
                            bitmapG = a(list, bitmapG);
                            this.f9943b.getClass();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (bitmapG != null) {
                    g0 g0Var2 = this.e;
                    g0Var2.getClass();
                    int allocationByteCount2 = bitmapG.getAllocationByteCount();
                    if (allocationByteCount2 < 0) {
                        com.google.gson.internal.a.h(bitmapG, "Negative size: ");
                        return null;
                    }
                    l lVar2 = g0Var2.f9957b;
                    lVar2.sendMessage(lVar2.obtainMessage(3, allocationByteCount2, 0));
                }
            }
        }
        return bitmapG;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar = this.f9944c;
        try {
            try {
                try {
                    h(this.g);
                    this.f9943b.getClass();
                    Bitmap bitmapF = f();
                    this.f9949l = bitmapF;
                    if (bitmapF == null) {
                        l lVar = nVar.h;
                        lVar.sendMessage(lVar.obtainMessage(6, this));
                    } else {
                        nVar.b(this);
                    }
                } catch (IOException e) {
                    this.f9952o = e;
                    l lVar2 = nVar.h;
                    lVar2.sendMessageDelayed(lVar2.obtainMessage(5, this), 500L);
                } catch (Exception e3) {
                    this.f9952o = e3;
                    l lVar3 = nVar.h;
                    lVar3.sendMessage(lVar3.obtainMessage(6, this));
                }
            } catch (w e7) {
                this.f9952o = e7;
                l lVar4 = nVar.h;
                lVar4.sendMessage(lVar4.obtainMessage(6, this));
            } catch (OutOfMemoryError e10) {
                StringWriter stringWriter = new StringWriter();
                this.e.a().a(new PrintWriter(stringWriter));
                this.f9952o = new RuntimeException(stringWriter.toString(), e10);
                l lVar5 = nVar.h;
                lVar5.sendMessage(lVar5.obtainMessage(6, this));
            }
        } finally {
            Thread.currentThread().setName("Picasso-Idle");
        }
    }
}
