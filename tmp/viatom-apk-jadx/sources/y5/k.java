package y5;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends h {

    /* renamed from: b, reason: collision with root package name */
    public final d0.i f13914b;

    /* renamed from: c, reason: collision with root package name */
    public final RelativeLayout f13915c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f13916d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final ProgressBar h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f13917i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f13918j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f13919k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f13920l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f13921m;

    /* renamed from: n, reason: collision with root package name */
    public final RelativeLayout f13922n;

    public k(View view, d0.i iVar) {
        super(view);
        this.f13914b = iVar;
        View viewFindViewById = view.findViewById(R.id.rl_download_item);
        viewFindViewById.getClass();
        this.f13915c = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tv_name_download_item);
        viewFindViewById2.getClass();
        TextView textView = (TextView) viewFindViewById2;
        this.f13916d = textView;
        View viewFindViewById3 = view.findViewById(R.id.tv_version_download_item);
        viewFindViewById3.getClass();
        TextView textView2 = (TextView) viewFindViewById3;
        this.e = textView2;
        View viewFindViewById4 = view.findViewById(R.id.tv_size_download_item);
        viewFindViewById4.getClass();
        TextView textView3 = (TextView) viewFindViewById4;
        this.f = textView3;
        View viewFindViewById5 = view.findViewById(R.id.tv_date_download_item);
        viewFindViewById5.getClass();
        TextView textView4 = (TextView) viewFindViewById5;
        this.g = textView4;
        View viewFindViewById6 = view.findViewById(R.id.pb_progress_download_item);
        viewFindViewById6.getClass();
        this.h = (ProgressBar) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.iv_cancel_download_item);
        viewFindViewById7.getClass();
        ImageView imageView = (ImageView) viewFindViewById7;
        this.f13917i = imageView;
        View viewFindViewById8 = view.findViewById(R.id.iv_icon_download_item);
        viewFindViewById8.getClass();
        ImageView imageView2 = (ImageView) viewFindViewById8;
        this.f13918j = imageView2;
        View viewFindViewById9 = view.findViewById(R.id.tv_info_download_item);
        viewFindViewById9.getClass();
        TextView textView5 = (TextView) viewFindViewById9;
        this.f13919k = textView5;
        View viewFindViewById10 = view.findViewById(R.id.tv_deeplink_download_item);
        viewFindViewById10.getClass();
        TextView textView6 = (TextView) viewFindViewById10;
        this.f13920l = textView6;
        View viewFindViewById11 = view.findViewById(R.id.iv_resume_download_item);
        viewFindViewById11.getClass();
        ImageView imageView3 = (ImageView) viewFindViewById11;
        this.f13921m = imageView3;
        View viewFindViewById12 = view.findViewById(R.id.rl_container_options_download_item);
        viewFindViewById12.getClass();
        this.f13922n = (RelativeLayout) viewFindViewById12;
        final int i10 = 0;
        view.setOnClickListener(new View.OnClickListener(this) { // from class: y5.i

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k f13885b;

            {
                this.f13885b = this;
            }

            /* JADX WARN: Removed duplicated region for block: B:134:0x0327  */
            /* JADX WARN: Removed duplicated region for block: B:144:0x0364  */
            /* JADX WARN: Removed duplicated region for block: B:148:0x037f  */
            /* JADX WARN: Removed duplicated region for block: B:151:0x038b  */
            /* JADX WARN: Removed duplicated region for block: B:152:0x0399  */
            /* JADX WARN: Removed duplicated region for block: B:155:0x03c1  */
            /* JADX WARN: Removed duplicated region for block: B:158:0x03ec  */
            /* JADX WARN: Removed duplicated region for block: B:161:0x040d  */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void onClick(android.view.View r24) {
                /*
                    Method dump skipped, instructions count: 1110
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: y5.i.onClick(android.view.View):void");
            }
        });
        view.setOnLongClickListener(new j(this, i10));
        final int i11 = 1;
        imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: y5.i

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k f13885b;

            {
                this.f13885b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View v6) {
                /*
                    Method dump skipped, instructions count: 1110
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: y5.i.onClick(android.view.View):void");
            }
        });
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11719r);
        textView4.setTypeface(o4.b.f11720s);
        textView5.setTypeface(o4.b.f11719r);
        textView6.setTypeface(o4.b.f11719r);
        final int i12 = 2;
        imageView.setOnClickListener(new View.OnClickListener(this) { // from class: y5.i

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k f13885b;

            {
                this.f13885b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View v6) {
                /*
                    Method dump skipped, instructions count: 1110
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: y5.i.onClick(android.view.View):void");
            }
        });
        final int i13 = 3;
        imageView3.setOnClickListener(new View.OnClickListener(this) { // from class: y5.i

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k f13885b;

            {
                this.f13885b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View v6) {
                /*
                    Method dump skipped, instructions count: 1110
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: y5.i.onClick(android.view.View):void");
            }
        });
    }
}
