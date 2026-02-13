package y5;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final x4 f13972a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f13973b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f13974c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f13975d;
    public final TextView e;
    public final ImageView f;
    public final ProgressBar g;
    public final RelativeLayout h;

    /* renamed from: i, reason: collision with root package name */
    public final float f13976i;

    /* renamed from: j, reason: collision with root package name */
    public final float f13977j;

    public q0(View view, x4 x4Var) {
        super(view);
        this.f13972a = x4Var;
        View viewFindViewById = view.findViewById(R.id.tv_version_old_version_item);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        this.f13973b = textView;
        View viewFindViewById2 = view.findViewById(R.id.tv_date_old_version_item);
        viewFindViewById2.getClass();
        TextView textView2 = (TextView) viewFindViewById2;
        this.f13974c = textView2;
        View viewFindViewById3 = view.findViewById(R.id.tv_type_old_version_item);
        viewFindViewById3.getClass();
        TextView textView3 = (TextView) viewFindViewById3;
        this.f13975d = textView3;
        View viewFindViewById4 = view.findViewById(R.id.tv_min_sdk_old_version_item);
        viewFindViewById4.getClass();
        TextView textView4 = (TextView) viewFindViewById4;
        this.e = textView4;
        View viewFindViewById5 = view.findViewById(R.id.iv_download_old_version_item);
        viewFindViewById5.getClass();
        this.f = (ImageView) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.pb_progress_old_version);
        viewFindViewById6.getClass();
        this.g = (ProgressBar) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.rl_download_old_version_item);
        viewFindViewById7.getClass();
        RelativeLayout relativeLayout = (RelativeLayout) viewFindViewById7;
        this.h = relativeLayout;
        View viewFindViewById8 = view.findViewById(R.id.iv_virustotal_report);
        viewFindViewById8.getClass();
        this.f13976i = 1.0f;
        this.f13977j = 0.4f;
        final int i10 = 0;
        relativeLayout.setOnClickListener(new View.OnClickListener(this) { // from class: y5.o0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ q0 f13956b;

            {
                this.f13956b = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:78:0x022e  */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void onClick(android.view.View r17) {
                /*
                    Method dump skipped, instructions count: 964
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: y5.o0.onClick(android.view.View):void");
            }
        });
        final int i11 = 1;
        ((ImageView) viewFindViewById8).setOnClickListener(new View.OnClickListener(this) { // from class: y5.o0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ q0 f13956b;

            {
                this.f13956b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View v6) {
                /*
                    Method dump skipped, instructions count: 964
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: y5.o0.onClick(android.view.View):void");
            }
        });
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11719r);
        textView4.setTypeface(o4.b.f11720s);
    }

    public final void a() {
        View view = this.itemView;
        ImageView imageView = this.f;
        com.mbridge.msdk.dycreator.baseview.a.p(view, R.drawable.core_vector_cross, imageView);
        this.h.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_ripple_bg_card));
        imageView.setContentDescription(this.itemView.getContext().getString(R.string.option_button_cancel));
    }

    public final void b() {
        if (this.g.getVisibility() == 0) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f13977j, this.f13976i);
            valueAnimatorOfFloat.setStartDelay(200L);
            valueAnimatorOfFloat.setDuration(300L);
            valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new p0(this, 1));
            valueAnimatorOfFloat.addListener(new z5.h(this, 2));
            valueAnimatorOfFloat.start();
        }
    }

    public final void c() {
        ProgressBar progressBar = this.g;
        if (progressBar.getVisibility() == 8) {
            progressBar.setVisibility(0);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f13976i, this.f13977j);
            valueAnimatorOfFloat.setDuration(300L);
            valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new p0(this, 0));
            valueAnimatorOfFloat.start();
        }
    }
}
