package n4;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11523a;

    /* renamed from: b, reason: collision with root package name */
    public final x4 f11524b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11525c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11526d;
    public final boolean e;
    public int f;

    public z0(ArrayList arrayList, x4 x4Var, int i10, int i11, boolean z9, int i12) {
        i11 = (i12 & 8) != 0 ? 0 : i11;
        z9 = (i12 & 16) != 0 ? false : z9;
        x4Var.getClass();
        this.f11523a = arrayList;
        this.f11524b = x4Var;
        this.f11525c = i10;
        this.f11526d = i11;
        this.e = z9;
        this.f = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11523a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        viewHolder.getClass();
        Object obj = this.f11523a.get(i10);
        obj.getClass();
        h5.j jVar = (h5.j) obj;
        if (!(viewHolder instanceof y0)) {
            if (viewHolder instanceof x0) {
                x0 x0Var = (x0) viewHolder;
                boolean z9 = this.f == i10;
                j4.d0 d0VarE = j4.y.d().e(jVar.a());
                float f = UptodownApp.E;
                Context context = x0Var.f11512c;
                d0VarE.g(k4.c.y(context));
                d0VarE.f(R.drawable.shape_avatar_item);
                a3.z0 z0Var = x0Var.f11510a;
                ImageView imageView = (ImageView) z0Var.f196b;
                ImageView imageView2 = (ImageView) z0Var.f197c;
                d0VarE.e(imageView, null);
                ((ImageView) z0Var.f196b).setOnClickListener(new e0(x0Var, jVar, i10, i));
                RelativeLayout relativeLayout = (RelativeLayout) z0Var.e;
                if (z9) {
                    relativeLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_avatar_selected_turbo_item));
                    imageView2.setVisibility(0);
                } else {
                    relativeLayout.setBackground(null);
                    imageView2.setVisibility(8);
                }
                boolean z10 = x0Var.f11513d.e;
                ImageView imageView3 = (ImageView) z0Var.f198d;
                if (z10) {
                    imageView3.setVisibility(8);
                    return;
                } else {
                    imageView3.setVisibility(0);
                    return;
                }
            }
            return;
        }
        y0 y0Var = (y0) viewHolder;
        i = this.f != i10 ? 0 : 1;
        j4.d0 d0VarE2 = j4.y.d().e(jVar.a());
        float f10 = UptodownApp.E;
        Context context2 = y0Var.f11519c;
        d0VarE2.g(k4.c.y(context2));
        d0VarE2.f(R.drawable.shape_avatar_item);
        w2.r rVar = y0Var.f11517a;
        ImageView imageView4 = (ImageView) rVar.f13463c;
        RelativeLayout relativeLayout2 = (RelativeLayout) rVar.e;
        ImageView imageView5 = (ImageView) rVar.f13464d;
        RelativeLayout relativeLayout3 = (RelativeLayout) rVar.f13462b;
        d0VarE2.e(imageView4, null);
        ((ImageView) rVar.f13463c).setOnClickListener(new e0(y0Var, jVar, i10, 2));
        int i11 = this.f11526d;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i11, i11);
        int dimension = (int) context2.getResources().getDimension(R.dimen.margin_m);
        if (i != 0) {
            layoutParams.setMargins(dimension, dimension, dimension, dimension);
            relativeLayout3.setLayoutParams(layoutParams);
            relativeLayout3.animate().scaleX(1.2f).scaleY(1.2f).setDuration(200L).start();
            imageView5.setVisibility(0);
            relativeLayout2.setBackground(ContextCompat.getDrawable(context2, R.drawable.shape_avatar_selected_item));
            return;
        }
        layoutParams.setMargins(dimension, dimension, dimension, dimension);
        relativeLayout3.setLayoutParams(layoutParams);
        relativeLayout3.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200L).start();
        relativeLayout2.setBackground(null);
        imageView5.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005c A[PHI: r2
      0x005c: PHI (r2v2 int) = (r2v0 int), (r2v3 int) binds: [B:9:0x002f, B:11:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup r14, int r15) {
        /*
            r13 = this;
            r14.getClass()
            java.lang.String r15 = "Missing required view with ID: "
            l4.x4 r0 = r13.f11524b
            r1 = 2131363360(0x7f0a0620, float:1.8346527E38)
            r2 = 2131362318(0x7f0a020e, float:1.8344413E38)
            r3 = 2131362300(0x7f0a01fc, float:1.8344377E38)
            r4 = 0
            int r5 = r13.f11525c
            if (r5 == 0) goto L76
            r6 = 1
            if (r5 != r6) goto L70
            r5 = 2131558896(0x7f0d01f0, float:1.874312E38)
            android.view.View r4 = c.i.b(r14, r5, r14, r4)
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r3)
            r8 = r5
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L5e
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r2)
            r9 = r3
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L5c
            r2 = 2131362403(0x7f0a0263, float:1.8344586E38)
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r2)
            r10 = r3
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L5c
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r1)
            r11 = r2
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            if (r11 == 0) goto L5f
            a3.z0 r6 = new a3.z0
            r7 = r4
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            r12 = 4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            n4.x0 r15 = new n4.x0
            android.content.Context r14 = r14.getContext()
            r14.getClass()
            r15.<init>(r13, r6, r0, r14)
            return r15
        L5c:
            r1 = r2
            goto L5f
        L5e:
            r1 = r3
        L5f:
            android.content.res.Resources r14 = r4.getResources()
            java.lang.String r14 = r14.getResourceName(r1)
            java.lang.String r14 = r15.concat(r14)
            androidx.window.layout.c.k(r14)
        L6e:
            r14 = 0
            return r14
        L70:
            java.lang.String r14 = "ViewHolder unknown!!"
            com.google.gson.internal.a.n(r14)
            goto L6e
        L76:
            r5 = 2131558894(0x7f0d01ee, float:1.8743117E38)
            android.view.View r4 = c.i.b(r14, r5, r14, r4)
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r3)
            r8 = r5
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto Lb1
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r2)
            r9 = r3
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto Laf
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r1)
            r10 = r2
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            if (r10 == 0) goto Lb2
            w2.r r6 = new w2.r
            r7 = r4
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            r11 = 14
            r6.<init>(r7, r8, r9, r10, r11)
            n4.y0 r15 = new n4.y0
            android.content.Context r14 = r14.getContext()
            r14.getClass()
            r15.<init>(r6, r0, r14)
            return r15
        Laf:
            r1 = r2
            goto Lb2
        Lb1:
            r1 = r3
        Lb2:
            android.content.res.Resources r14 = r4.getResources()
            java.lang.String r14 = r14.getResourceName(r1)
            java.lang.String r14 = r15.concat(r14)
            androidx.window.layout.c.k(r14)
            goto L6e
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.z0.onCreateViewHolder(android.view.ViewGroup, int):androidx.recyclerview.widget.RecyclerView$ViewHolder");
    }
}
