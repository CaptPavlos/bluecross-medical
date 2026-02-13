package com.mbridge.msdk.video.dynview.i.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.p;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.g.a;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f5752a;

    /* renamed from: b, reason: collision with root package name */
    private View f5753b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f5754c;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f5755d;

    private a() {
    }

    public final void a(Map<String, Bitmap> map, c cVar, View view) throws Throwable {
        if (view == null || cVar == null || map == null || map.size() == 0 || map.size() < 2 || cVar.g() == null || cVar.g().size() < 2) {
            return;
        }
        this.f5753b = view;
        int iE = cVar.e();
        float fD = cVar.d();
        float fC = cVar.c();
        try {
            List<CampaignEx> listG = cVar.g();
            String md5 = listG.get(0) != null ? SameMD5.getMD5(listG.get(0).getImageUrl()) : "";
            String md52 = listG.get(1) != null ? SameMD5.getMD5(listG.get(1).getImageUrl()) : "";
            Bitmap bitmap = null;
            Bitmap bitmap2 = (TextUtils.isEmpty(md5) || !map.containsKey(md5)) ? null : map.get(md5);
            if (!TextUtils.isEmpty(md52) && map.containsKey(md52)) {
                bitmap = map.get(md52);
            }
            Bitmap bitmap3 = bitmap;
            if (bitmap2 == null || bitmap2.isRecycled() || bitmap3 == null || bitmap3.isRecycled()) {
                return;
            }
            a(iE, fD, fC, bitmap2, bitmap3);
        } catch (Exception e) {
            af.b("ChoiceOneDrawBitBg", e.getMessage());
        }
    }

    public final void b() {
        if (this.f5753b != null) {
            this.f5753b = null;
        }
        Bitmap bitmap = this.f5754c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f5754c.recycle();
            this.f5754c = null;
        }
        Bitmap bitmap2 = this.f5755d;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        this.f5755d.recycle();
        this.f5755d = null;
    }

    public static a a() {
        a aVar;
        if (f5752a == null) {
            synchronized (a.class) {
                try {
                    if (f5752a == null) {
                        f5752a = new a();
                    }
                    aVar = f5752a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVar;
        }
        return f5752a;
    }

    private synchronized void a(final int i10, final float f, final float f10, final Bitmap bitmap, Bitmap bitmap2) throws Throwable {
        try {
            try {
                try {
                    com.mbridge.msdk.foundation.same.f.a.a().execute(new Runnable() { // from class: com.mbridge.msdk.video.dynview.i.a.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                Bitmap bitmapA = p.a(bitmap, 10);
                                Bitmap bitmapA2 = p.a(bitmap, 10);
                                final a.C0063a c0063aA = com.mbridge.msdk.video.dynview.g.a.a();
                                c0063aA.a(i10).a(bitmapA).b(bitmapA2);
                                int i11 = i10;
                                float f11 = f;
                                if (i11 == 2) {
                                    float f12 = f10;
                                    if (f11 > f12) {
                                        c0063aA.a(f11).b(f10);
                                    } else {
                                        c0063aA.a(f12).b(f);
                                    }
                                } else {
                                    c0063aA.a(f11).b(f10);
                                }
                                if (a.this.f5753b != null) {
                                    a.this.f5753b.post(new Runnable() { // from class: com.mbridge.msdk.video.dynview.i.a.a.1.1
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            if (a.this.f5753b == null || c0063aA.a() == null) {
                                                return;
                                            }
                                            a.this.f5753b.setBackground(c0063aA.a());
                                        }
                                    });
                                }
                            } catch (Exception e) {
                                af.b("ChoiceOneDrawBitBg", e.getMessage());
                            }
                        }
                    });
                } catch (Exception e) {
                    e = e;
                    af.a("ChoiceOneDrawBitBg", e.getMessage());
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }
}
