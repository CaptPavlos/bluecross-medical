package com.uptodown.activities;

import a3.i0;
import android.widget.TextView;
import com.uptodown.R;
import d5.q;
import java.util.ArrayList;
import l4.b;
import l4.w;
import s6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Gallery extends w {
    public static final /* synthetic */ int K = 0;
    public ArrayList I;
    public final m H = new m(new i0(this, 24));
    public final b J = new b(this, 1);

    public final q n0() {
        return (q) this.H.getValue();
    }

    public final void o0(int i10) {
        TextView textView = n0().f7294d;
        Integer numValueOf = Integer.valueOf(i10 + 1);
        ArrayList arrayList = this.I;
        textView.setText(getString(R.string.gallery_item_count, numValueOf, arrayList != null ? Integer.valueOf(arrayList.size()) : null));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r5) {
        /*
            r4 = this;
            super.onCreate(r5)
            d5.q r5 = r4.n0()
            android.widget.RelativeLayout r5 = r5.f7291a
            r5.getClass()
            r4.setContentView(r5)
            androidx.activity.OnBackPressedDispatcher r5 = r4.getOnBackPressedDispatcher()
            l4.b r0 = r4.J
            r5.addCallback(r4, r0)
            android.content.Intent r5 = r4.getIntent()
            r0 = 0
            if (r5 == 0) goto L4f
            java.lang.String r1 = "bundle"
            android.os.Bundle r5 = r5.getBundleExtra(r1)
            if (r5 == 0) goto L4f
            java.lang.String r1 = "images"
            boolean r2 = r5.containsKey(r1)
            if (r2 == 0) goto L42
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 34
            if (r2 < r3) goto L3c
            java.lang.Class<h5.u0> r2 = h5.u0.class
            java.util.ArrayList r1 = r5.getParcelableArrayList(r1, r2)
            goto L40
        L3c:
            java.util.ArrayList r1 = r5.getParcelableArrayList(r1)
        L40:
            r4.I = r1
        L42:
            java.lang.String r1 = "index"
            boolean r2 = r5.containsKey(r1)
            if (r2 == 0) goto L4f
            int r5 = r5.getInt(r1)
            goto L50
        L4f:
            r5 = r0
        L50:
            l4.z0 r1 = new l4.z0
            r1.<init>(r4)
            d5.q r2 = r4.n0()
            androidx.viewpager2.widget.ViewPager2 r2 = r2.e
            r2.setAdapter(r1)
            if (r5 <= 0) goto L69
            d5.q r1 = r4.n0()
            androidx.viewpager2.widget.ViewPager2 r1 = r1.e
            r1.setCurrentItem(r5, r0)
        L69:
            d5.q r0 = r4.n0()
            androidx.viewpager2.widget.ViewPager2 r0 = r0.e
            l4.a1 r1 = new l4.a1
            r1.<init>(r4)
            r0.registerOnPageChangeCallback(r1)
            r4.o0(r5)
            d5.q r5 = r4.n0()
            android.widget.TextView r5 = r5.f7294d
            android.graphics.Typeface r0 = o4.b.f11719r
            r5.setTypeface(r0)
            d5.q r5 = r4.n0()
            android.widget.ImageView r5 = r5.f7292b
            l4.w0 r0 = new l4.w0
            r1 = 0
            r0.<init>(r4, r1)
            r5.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.Gallery.onCreate(android.os.Bundle):void");
    }
}
