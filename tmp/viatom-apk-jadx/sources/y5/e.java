package y5;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import j$.util.concurrent.ConcurrentHashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final g5.b f13845a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f13846b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f13847c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f13848d;
    public final TextView e;
    public final TextView f;
    public final TextView g;

    public e(View view, g5.b bVar) {
        super(view);
        this.f13845a = bVar;
        View viewFindViewById = view.findViewById(R.id.iv_icon_installed_app_item);
        viewFindViewById.getClass();
        ImageView imageView = (ImageView) viewFindViewById;
        this.f13846b = imageView;
        View viewFindViewById2 = view.findViewById(R.id.tv_name_installed_app_item);
        viewFindViewById2.getClass();
        TextView textView = (TextView) viewFindViewById2;
        this.f13847c = textView;
        View viewFindViewById3 = view.findViewById(R.id.tv_version_installed_app_item);
        viewFindViewById3.getClass();
        TextView textView2 = (TextView) viewFindViewById3;
        this.f13848d = textView2;
        View viewFindViewById4 = view.findViewById(R.id.tv_size_installed_app_item);
        viewFindViewById4.getClass();
        TextView textView3 = (TextView) viewFindViewById4;
        this.e = textView3;
        View viewFindViewById5 = view.findViewById(R.id.tv_last_update_installed_app_item);
        viewFindViewById5.getClass();
        TextView textView4 = (TextView) viewFindViewById5;
        this.f = textView4;
        View viewFindViewById6 = view.findViewById(R.id.tv_excluded_installed_app_item);
        viewFindViewById6.getClass();
        TextView textView5 = (TextView) viewFindViewById6;
        this.g = textView5;
        View viewFindViewById7 = view.findViewById(R.id.rl_installed_app_item);
        viewFindViewById7.getClass();
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11719r);
        textView3.setTypeface(o4.b.f11720s);
        textView4.setTypeface(o4.b.f11720s);
        textView5.setTypeface(o4.b.f11719r);
        final int i10 = 0;
        ((RelativeLayout) viewFindViewById7).setOnClickListener(new View.OnClickListener(this) { // from class: y5.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f13835b;

            {
                this.f13835b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                switch (i10) {
                    case 0:
                        e eVar = this.f13835b;
                        g5.b bVar2 = eVar.f13845a;
                        if (bVar2 != null && (bindingAdapterPosition = eVar.getBindingAdapterPosition()) != -1) {
                            bVar2.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    default:
                        e eVar2 = this.f13835b;
                        g5.b bVar3 = eVar2.f13845a;
                        if (bVar3 != null && (bindingAdapterPosition2 = eVar2.getBindingAdapterPosition()) != -1) {
                            bVar3.d(bindingAdapterPosition2);
                            break;
                        }
                        break;
                }
            }
        });
        final int i11 = 1;
        imageView.setOnClickListener(new View.OnClickListener(this) { // from class: y5.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f13835b;

            {
                this.f13835b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                switch (i11) {
                    case 0:
                        e eVar = this.f13835b;
                        g5.b bVar2 = eVar.f13845a;
                        if (bVar2 != null && (bindingAdapterPosition = eVar.getBindingAdapterPosition()) != -1) {
                            bVar2.a(bindingAdapterPosition);
                            break;
                        }
                        break;
                    default:
                        e eVar2 = this.f13835b;
                        g5.b bVar3 = eVar2.f13845a;
                        if (bVar3 != null && (bindingAdapterPosition2 = eVar2.getBindingAdapterPosition()) != -1) {
                            bVar3.d(bindingAdapterPosition2);
                            break;
                        }
                        break;
                }
            }
        });
    }

    public final void a(h5.f fVar) {
        boolean z9 = fVar.B;
        View view = this.itemView;
        if (z9) {
            view.setAlpha(0.3f);
        } else {
            view.setAlpha(1.0f);
        }
        t3.h hVar = v5.g.f13148u;
        Context context = this.itemView.getContext();
        context.getClass();
        v5.g gVarL = hVar.l(context);
        gVarL.a();
        String str = fVar.f8526c;
        str.getClass();
        h5.y0 y0VarM = gVarL.M(str);
        gVarL.b();
        ConcurrentHashMap concurrentHashMap = v5.n.f13169a;
        Context context2 = this.itemView.getContext();
        context2.getClass();
        this.f13846b.setImageDrawable(v5.n.c(context2, fVar.f8526c));
        this.f13847c.setText(fVar.f8525b);
        String str2 = fVar.e;
        TextView textView = this.f13848d;
        textView.setText(str2);
        long j10 = fVar.f8533n;
        Context context3 = this.itemView.getContext();
        context3.getClass();
        this.e.setText(l1.b.M(context3, j10));
        long j11 = fVar.f8534o;
        this.f.setText(j11 <= 0 ? null : new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date(j11)));
        float f = UptodownApp.E;
        Activity activity = o4.b.g;
        u4.a aVarA = r0.f.A();
        if (o7.u.Z(aVarA != null ? aVarA.f12891a : null, fVar.f8526c, true)) {
            textView.setText(R.string.installing);
        }
        int i10 = fVar.f8532m;
        TextView textView2 = this.g;
        if (i10 == 1) {
            textView2.setText(this.itemView.getContext().getString(R.string.disabled_updates));
            textView2.setVisibility(0);
        } else if (y0VarM == null || y0VarM.f != 1) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.itemView.getContext().getString(R.string.skipped_update));
            textView2.setVisibility(0);
        }
    }
}
