package y5;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.measurement.l5;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import j$.util.concurrent.ConcurrentHashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r1 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final g5.p f13985a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f13986b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f13987c;

    /* renamed from: d, reason: collision with root package name */
    public final ProgressBar f13988d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f13989i;

    /* renamed from: j, reason: collision with root package name */
    public final RelativeLayout f13990j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f13991k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f13992l;

    /* renamed from: m, reason: collision with root package name */
    public final RelativeLayout f13993m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f13994n;

    /* renamed from: o, reason: collision with root package name */
    public final RelativeLayout f13995o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f13996p;

    /* renamed from: q, reason: collision with root package name */
    public final ImageView f13997q;

    /* renamed from: r, reason: collision with root package name */
    public String f13998r;

    public r1(View view, g5.p pVar) {
        super(view);
        this.f13985a = pVar;
        View viewFindViewById = view.findViewById(R.id.iv_icon_update_item);
        viewFindViewById.getClass();
        ImageView imageView = (ImageView) viewFindViewById;
        this.f13986b = imageView;
        View viewFindViewById2 = view.findViewById(R.id.tv_name_update_item);
        viewFindViewById2.getClass();
        TextView textView = (TextView) viewFindViewById2;
        this.f13987c = textView;
        View viewFindViewById3 = view.findViewById(R.id.pb_progress_update_item);
        viewFindViewById3.getClass();
        this.f13988d = (ProgressBar) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.tv_version_update_item);
        viewFindViewById4.getClass();
        TextView textView2 = (TextView) viewFindViewById4;
        this.e = textView2;
        View viewFindViewById5 = view.findViewById(R.id.tv_size_update_item);
        viewFindViewById5.getClass();
        TextView textView3 = (TextView) viewFindViewById5;
        this.f = textView3;
        View viewFindViewById6 = view.findViewById(R.id.tv_last_update_item);
        viewFindViewById6.getClass();
        TextView textView4 = (TextView) viewFindViewById6;
        this.g = textView4;
        View viewFindViewById7 = view.findViewById(R.id.tv_verified_by_uptodown_update_item);
        viewFindViewById7.getClass();
        TextView textView5 = (TextView) viewFindViewById7;
        this.h = textView5;
        View viewFindViewById8 = view.findViewById(R.id.tv_action_update_item);
        viewFindViewById8.getClass();
        TextView textView6 = (TextView) viewFindViewById8;
        this.f13989i = textView6;
        View viewFindViewById9 = view.findViewById(R.id.rl_actions_update_item);
        viewFindViewById9.getClass();
        this.f13990j = (RelativeLayout) viewFindViewById9;
        View viewFindViewById10 = view.findViewById(R.id.tv_excluded_update_item);
        viewFindViewById10.getClass();
        TextView textView7 = (TextView) viewFindViewById10;
        this.f13991k = textView7;
        View viewFindViewById11 = view.findViewById(R.id.iv_version_details_update_item);
        viewFindViewById11.getClass();
        this.f13992l = (ImageView) viewFindViewById11;
        View viewFindViewById12 = view.findViewById(R.id.rl_version_details_update_item);
        viewFindViewById12.getClass();
        this.f13993m = (RelativeLayout) viewFindViewById12;
        View viewFindViewById13 = view.findViewById(R.id.tv_version_details_update_item);
        viewFindViewById13.getClass();
        TextView textView8 = (TextView) viewFindViewById13;
        this.f13994n = textView8;
        View viewFindViewById14 = view.findViewById(R.id.rl_container_update_item);
        viewFindViewById14.getClass();
        View viewFindViewById15 = view.findViewById(R.id.rl_cancel_update_item);
        viewFindViewById15.getClass();
        this.f13995o = (RelativeLayout) viewFindViewById15;
        View viewFindViewById16 = view.findViewById(R.id.tv_pending_update_item);
        viewFindViewById16.getClass();
        TextView textView9 = (TextView) viewFindViewById16;
        this.f13996p = textView9;
        View viewFindViewById17 = view.findViewById(R.id.iv_cancel_update_item);
        viewFindViewById17.getClass();
        ImageView imageView2 = (ImageView) viewFindViewById17;
        this.f13997q = imageView2;
        final int i10 = 0;
        ((RelativeLayout) viewFindViewById14).setOnClickListener(new View.OnClickListener(this) { // from class: y5.q1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r1 f13979b;

            {
                this.f13979b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                switch (i10) {
                    case 0:
                        r1 r1Var = this.f13979b;
                        g5.p pVar2 = r1Var.f13985a;
                        if (pVar2 != null && (bindingAdapterPosition = r1Var.getBindingAdapterPosition()) != -1) {
                            pVar2.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    case 1:
                        r1 r1Var2 = this.f13979b;
                        g5.p pVar3 = r1Var2.f13985a;
                        if (pVar3 != null && (bindingAdapterPosition2 = r1Var2.getBindingAdapterPosition()) != -1) {
                            pVar3.d(bindingAdapterPosition2);
                            break;
                        }
                        break;
                    case 2:
                        r1 r1Var3 = this.f13979b;
                        g5.p pVar4 = r1Var3.f13985a;
                        if (pVar4 != null) {
                            pVar4.c(r1Var3.getBindingAdapterPosition());
                            break;
                        }
                        break;
                    default:
                        r1 r1Var4 = this.f13979b;
                        g5.p pVar5 = r1Var4.f13985a;
                        if (pVar5 != null) {
                            pVar5.e(r1Var4.getBindingAdapterPosition());
                            break;
                        }
                        break;
                }
            }
        });
        final int i11 = 1;
        imageView.setOnClickListener(new View.OnClickListener(this) { // from class: y5.q1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r1 f13979b;

            {
                this.f13979b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                switch (i11) {
                    case 0:
                        r1 r1Var = this.f13979b;
                        g5.p pVar2 = r1Var.f13985a;
                        if (pVar2 != null && (bindingAdapterPosition = r1Var.getBindingAdapterPosition()) != -1) {
                            pVar2.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    case 1:
                        r1 r1Var2 = this.f13979b;
                        g5.p pVar3 = r1Var2.f13985a;
                        if (pVar3 != null && (bindingAdapterPosition2 = r1Var2.getBindingAdapterPosition()) != -1) {
                            pVar3.d(bindingAdapterPosition2);
                            break;
                        }
                        break;
                    case 2:
                        r1 r1Var3 = this.f13979b;
                        g5.p pVar4 = r1Var3.f13985a;
                        if (pVar4 != null) {
                            pVar4.c(r1Var3.getBindingAdapterPosition());
                            break;
                        }
                        break;
                    default:
                        r1 r1Var4 = this.f13979b;
                        g5.p pVar5 = r1Var4.f13985a;
                        if (pVar5 != null) {
                            pVar5.e(r1Var4.getBindingAdapterPosition());
                            break;
                        }
                        break;
                }
            }
        });
        final int i12 = 2;
        textView6.setOnClickListener(new View.OnClickListener(this) { // from class: y5.q1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r1 f13979b;

            {
                this.f13979b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                switch (i12) {
                    case 0:
                        r1 r1Var = this.f13979b;
                        g5.p pVar2 = r1Var.f13985a;
                        if (pVar2 != null && (bindingAdapterPosition = r1Var.getBindingAdapterPosition()) != -1) {
                            pVar2.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    case 1:
                        r1 r1Var2 = this.f13979b;
                        g5.p pVar3 = r1Var2.f13985a;
                        if (pVar3 != null && (bindingAdapterPosition2 = r1Var2.getBindingAdapterPosition()) != -1) {
                            pVar3.d(bindingAdapterPosition2);
                            break;
                        }
                        break;
                    case 2:
                        r1 r1Var3 = this.f13979b;
                        g5.p pVar4 = r1Var3.f13985a;
                        if (pVar4 != null) {
                            pVar4.c(r1Var3.getBindingAdapterPosition());
                            break;
                        }
                        break;
                    default:
                        r1 r1Var4 = this.f13979b;
                        g5.p pVar5 = r1Var4.f13985a;
                        if (pVar5 != null) {
                            pVar5.e(r1Var4.getBindingAdapterPosition());
                            break;
                        }
                        break;
                }
            }
        });
        final int i13 = 3;
        imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: y5.q1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r1 f13979b;

            {
                this.f13979b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                switch (i13) {
                    case 0:
                        r1 r1Var = this.f13979b;
                        g5.p pVar2 = r1Var.f13985a;
                        if (pVar2 != null && (bindingAdapterPosition = r1Var.getBindingAdapterPosition()) != -1) {
                            pVar2.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    case 1:
                        r1 r1Var2 = this.f13979b;
                        g5.p pVar3 = r1Var2.f13985a;
                        if (pVar3 != null && (bindingAdapterPosition2 = r1Var2.getBindingAdapterPosition()) != -1) {
                            pVar3.d(bindingAdapterPosition2);
                            break;
                        }
                        break;
                    case 2:
                        r1 r1Var3 = this.f13979b;
                        g5.p pVar4 = r1Var3.f13985a;
                        if (pVar4 != null) {
                            pVar4.c(r1Var3.getBindingAdapterPosition());
                            break;
                        }
                        break;
                    default:
                        r1 r1Var4 = this.f13979b;
                        g5.p pVar5 = r1Var4.f13985a;
                        if (pVar5 != null) {
                            pVar5.e(r1Var4.getBindingAdapterPosition());
                            break;
                        }
                        break;
                }
            }
        });
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11719r);
        textView3.setTypeface(o4.b.f11720s);
        textView5.setTypeface(o4.b.f11720s);
        textView9.setTypeface(o4.b.f11719r);
        textView8.setTypeface(o4.b.f11720s);
        textView7.setTypeface(o4.b.f11719r);
        textView6.setTypeface(o4.b.f11719r);
        textView4.setTypeface(o4.b.f11720s);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v14 */
    public final void a(n4.u0 u0Var, boolean z9, boolean z10) {
        ImageView imageView;
        TextView textView;
        String str;
        n4.u0 u0Var2;
        h5.f fVar;
        ?? r72;
        String str2;
        h5.f fVar2 = u0Var.f11493a;
        h5.y0 y0Var = u0Var.f11494b;
        String str3 = fVar2.f8526c;
        boolean zA = kotlin.jvm.internal.l.a(this.f13998r, str3);
        ImageView imageView2 = this.f13986b;
        ProgressBar progressBar = this.f13988d;
        if (!zA) {
            imageView2.clearAnimation();
            progressBar.clearAnimation();
            progressBar.setVisibility(8);
            imageView2.setAlpha(1.0f);
            imageView2.setScaleX(1.0f);
            imageView2.setScaleY(1.0f);
        }
        this.f13998r = str3;
        TextView textView2 = this.f13989i;
        textView2.setVisibility(8);
        RelativeLayout relativeLayout = this.f13990j;
        relativeLayout.setVisibility(0);
        if (!progressBar.isIndeterminate()) {
            progressBar.setIndeterminate(true);
        }
        Drawable drawable = ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_vector_cross);
        ImageView imageView3 = this.f13997q;
        imageView3.setImageDrawable(drawable);
        imageView3.setClickable(true);
        TextView textView3 = this.f13991k;
        textView3.setVisibility(8);
        RelativeLayout relativeLayout2 = this.f13995o;
        relativeLayout2.setVisibility(8);
        TextView textView4 = this.f;
        textView4.setVisibility(0);
        TextView textView5 = this.f13996p;
        textView5.setVisibility(8);
        boolean z11 = fVar2.B;
        View view = this.itemView;
        if (z11) {
            view.setAlpha(0.3f);
        } else {
            view.setAlpha(1.0f);
        }
        ConcurrentHashMap concurrentHashMap = v5.n.f13169a;
        Context context = this.itemView.getContext();
        context.getClass();
        imageView2.setImageDrawable(v5.n.c(context, fVar2.f8526c));
        this.f13987c.setText(fVar2.f8525b);
        long j10 = fVar2.f8533n;
        Context context2 = this.itemView.getContext();
        context2.getClass();
        textView4.setText(l1.b.M(context2, j10));
        long j11 = fVar2.f8534o;
        if (j11 <= 0) {
            textView = textView2;
            imageView = imageView2;
            str = null;
        } else {
            imageView = imageView2;
            textView = textView2;
            str = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date(j11));
        }
        TextView textView6 = this.g;
        textView6.setText(str);
        t3.h hVar = v5.g.f13148u;
        Context context3 = this.itemView.getContext();
        context3.getClass();
        v5.g gVarL = hVar.l(context3);
        gVarL.a();
        h5.q qVar = y0Var.f8798i;
        h5.q qVarZ = qVar != null ? gVarL.z(qVar.f8700a) : null;
        gVarL.b();
        String str4 = (qVarZ != null && qVarZ.f8716v.size() == 1 && qVarZ.c() && (str2 = ((h5.r) qVarZ.f8716v.get(0)).h) != null && o7.u.X(str2, ".xapk", false)) ? ((h5.r) qVarZ.f8716v.get(0)).h : null;
        String str5 = y0Var.f8797d;
        TextView textView7 = this.e;
        textView7.setText(str5);
        boolean zB = y0Var.b();
        TextView textView8 = this.h;
        if (zB) {
            if (y0Var.f == 1) {
                String string = this.itemView.getContext().getString(R.string.skipped_update);
                string.getClass();
                textView3.setText(string);
                textView3.setVisibility(0);
                textView8.setVisibility(8);
                textView6.setVisibility(0);
                relativeLayout.setVisibility(8);
            } else {
                textView3.setVisibility(8);
                textView8.setVisibility(8);
                textView4.setVisibility(8);
                relativeLayout.setVisibility(8);
            }
            u0Var2 = u0Var;
        } else {
            Activity activity = o4.b.g;
            u4.a aVarA = r0.f.A();
            h5.q qVar2 = qVarZ;
            if (o7.u.Z(aVarA != null ? aVarA.f12891a : null, fVar2.f8526c, true) || z9) {
                u0Var2 = u0Var;
                ImageView imageView4 = imageView;
                textView7.setVisibility(0);
                relativeLayout.setVisibility(0);
                relativeLayout2.setVisibility(0);
                imageView3.setVisibility(0);
                imageView3.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_cross_disabled));
                imageView3.setClickable(false);
                textView5.setVisibility(0);
                textView5.setText(this.itemView.getContext().getString(R.string.installing));
                textView8.setVisibility(0);
                textView6.setVisibility(8);
                textView4.setVisibility(8);
                c(progressBar, imageView4, u0Var2);
            } else {
                b2.a aVar = o4.b.f11718q;
                if (aVar == null || !o7.u.Z(str4, aVar.f823a, true)) {
                    u0Var2 = u0Var;
                    ImageView imageView5 = imageView;
                    float f = UptodownApp.E;
                    if (k4.c.k(y0Var)) {
                        if (qVar2 != null) {
                            Context context4 = this.itemView.getContext();
                            Integer numValueOf = Integer.valueOf(qVar2.i());
                            fVar = fVar2;
                            long jK = qVar2.k();
                            Context context5 = this.itemView.getContext();
                            context5.getClass();
                            String strM = l1.b.M(context5, jK);
                            r72 = 0;
                            textView7.setText(context4.getString(R.string.percent_of_total_size, numValueOf, strM));
                        } else {
                            fVar = fVar2;
                            r72 = 0;
                        }
                        relativeLayout2.setVisibility(r72);
                        textView7.setVisibility(r72);
                        textView3.setVisibility(8);
                        textView8.setVisibility(r72);
                        textView6.setVisibility(8);
                        textView4.setVisibility(8);
                        if (progressBar.isIndeterminate()) {
                            progressBar.setIndeterminate(r72);
                        }
                        u0Var2 = u0Var;
                        c(progressBar, imageView5, u0Var2);
                        fVar2 = fVar;
                    } else {
                        String str6 = fVar2.f8526c;
                        str6.getClass();
                        if (k4.c.l(str6) || z10) {
                            textView5.setVisibility(0);
                            textView5.setText(this.itemView.getContext().getString(R.string.notification_line_downloading));
                            relativeLayout2.setVisibility(0);
                            b(progressBar, imageView5, u0Var2);
                        } else {
                            TextView textView9 = textView;
                            textView9.setText(this.itemView.getContext().getString(R.string.updates_button_update_app));
                            l5.F(textView9);
                            textView9.setVisibility(0);
                            textView8.setVisibility(8);
                            textView6.setVisibility(0);
                            b(progressBar, imageView5, u0Var2);
                        }
                    }
                    if (qVar2 != null) {
                        progressBar.setProgress(qVar2.i());
                    }
                } else {
                    b2.a aVar2 = o4.b.f11718q;
                    aVar2.getClass();
                    int i10 = aVar2.f824b;
                    textView7.setVisibility(0);
                    relativeLayout.setVisibility(0);
                    relativeLayout2.setVisibility(0);
                    textView5.setVisibility(0);
                    textView5.setText(this.itemView.getContext().getString(R.string.unzipping_status, Integer.valueOf(i10)));
                    imageView3.setVisibility(0);
                    imageView3.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_cross_disabled));
                    imageView3.setClickable(false);
                    textView8.setVisibility(0);
                    textView6.setVisibility(8);
                    textView4.setVisibility(8);
                    textView8.setVisibility(0);
                    if (progressBar.isIndeterminate()) {
                        progressBar.setIndeterminate(false);
                    }
                    progressBar.setProgress(i10);
                    u0Var2 = u0Var;
                    c(progressBar, imageView, u0Var2);
                }
            }
            y0Var = y0Var;
        }
        String str7 = y0Var.h;
        TextView textView10 = this.f13994n;
        RelativeLayout relativeLayout3 = this.f13993m;
        ImageView imageView6 = this.f13992l;
        if (str7 == null || str7.length() == 0) {
            textView10.setVisibility(8);
            relativeLayout3.setVisibility(8);
            imageView6.setVisibility(8);
        } else {
            relativeLayout3.setVisibility(0);
            imageView6.setVisibility(0);
            if (fVar2.f8540v) {
                textView10.setText(y0Var.h);
                relativeLayout3.setVisibility(0);
                textView10.setVisibility(0);
                imageView6.setScaleY(-1.0f);
                imageView6.setContentDescription(this.itemView.getContext().getString(R.string.cd_collapse_version_details));
            } else {
                textView10.setVisibility(8);
                relativeLayout3.setVisibility(8);
                imageView6.setScaleY(1.0f);
                imageView6.setContentDescription(this.itemView.getContext().getString(R.string.cd_expand_version_details));
            }
        }
        imageView6.setOnClickListener(new i0(7, u0Var2, this));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.widget.ProgressBar r11, android.widget.ImageView r12, n4.u0 r13) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.r1.b(android.widget.ProgressBar, android.widget.ImageView, n4.u0):void");
    }

    public final void c(ProgressBar progressBar, ImageView imageView, n4.u0 u0Var) {
        if (kotlin.jvm.internal.l.a(this.f13998r, u0Var.f11493a.f8526c)) {
            boolean z9 = u0Var.f11496d;
            int i10 = 0;
            if (z9 || u0Var.f11495c) {
                if (!z9 || progressBar.getVisibility() == 0) {
                    return;
                }
                imageView.setScaleX(0.6f);
                imageView.setScaleY(0.6f);
                progressBar.setVisibility(0);
                return;
            }
            progressBar.setVisibility(0);
            u0Var.f11495c = true;
            this.itemView.getContext().getClass();
            androidx.work.impl.utils.c cVar = new androidx.work.impl.utils.c(13, this, u0Var);
            imageView.getClass();
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.6f);
            valueAnimatorOfFloat.setDuration(300L);
            valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new z5.g(imageView, i10));
            valueAnimatorOfFloat.addListener(new z5.h(cVar, 1));
            valueAnimatorOfFloat.start();
        }
    }
}
