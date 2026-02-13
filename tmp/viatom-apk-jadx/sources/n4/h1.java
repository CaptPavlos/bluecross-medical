package n4;

import android.content.Context;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.util.views.UsernameTextView;
import java.util.ArrayList;
import l4.f5;
import l4.p2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h1 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f11367a;

    /* renamed from: b, reason: collision with root package name */
    public p2 f11368b;

    /* renamed from: c, reason: collision with root package name */
    public int f11369c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11367a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i10) {
        int i11;
        final g1 g1Var = (g1) viewHolder;
        g1Var.getClass();
        Object obj = this.f11367a.get(i10);
        obj.getClass();
        h5.t0 t0Var = (h5.t0) obj;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        d5.r0 r0Var = g1Var.f11350b;
        RelativeLayout relativeLayout = r0Var.f7314a;
        TextView textView = r0Var.f7325p;
        UsernameTextView usernameTextView = r0Var.f7320k;
        ImageView imageView = r0Var.f7315b;
        LinearLayout linearLayout = r0Var.f7318i;
        LinearLayout linearLayout2 = r0Var.f7319j;
        TextView textView2 = r0Var.f7321l;
        Context context = g1Var.itemView.getContext();
        context.getClass();
        y5.f.a(layoutParams, context, i10, g1Var.f11352d.f11369c);
        relativeLayout.setLayoutParams(layoutParams);
        com.mbridge.msdk.dycreator.baseview.a.p(g1Var.itemView, R.drawable.vector_star_on, r0Var.f7317d);
        ImageView imageView2 = r0Var.e;
        com.mbridge.msdk.dycreator.baseview.a.p(g1Var.itemView, R.drawable.vector_star_off, imageView2);
        ImageView imageView3 = r0Var.f;
        com.mbridge.msdk.dycreator.baseview.a.p(g1Var.itemView, R.drawable.vector_star_off, imageView3);
        ImageView imageView4 = r0Var.g;
        com.mbridge.msdk.dycreator.baseview.a.p(g1Var.itemView, R.drawable.vector_star_off, imageView4);
        ImageView imageView5 = r0Var.h;
        com.mbridge.msdk.dycreator.baseview.a.p(g1Var.itemView, R.drawable.vector_star_off, imageView5);
        if (t0Var.g >= 2) {
            View view = g1Var.itemView;
            i11 = R.drawable.vector_star_on;
            com.mbridge.msdk.dycreator.baseview.a.p(view, R.drawable.vector_star_on, imageView2);
        } else {
            i11 = R.drawable.vector_star_on;
        }
        if (t0Var.g >= 3) {
            com.mbridge.msdk.dycreator.baseview.a.p(g1Var.itemView, i11, imageView3);
        }
        if (t0Var.g >= 4) {
            com.mbridge.msdk.dycreator.baseview.a.p(g1Var.itemView, i11, imageView4);
        }
        if (t0Var.g == 5) {
            com.mbridge.msdk.dycreator.baseview.a.p(g1Var.itemView, i11, imageView5);
        }
        String str = t0Var.f8742d;
        if (str == null || str.length() == 0) {
            j4.d0 d0VarF = j4.y.d().f();
            float f = UptodownApp.E;
            Context context2 = g1Var.itemView.getContext();
            context2.getClass();
            d0VarF.g(k4.c.z(context2));
            d0VarF.e(imageView, null);
        } else {
            j4.y yVarD = j4.y.d();
            String str2 = t0Var.f8742d;
            j4.d0 d0VarE = yVarD.e(str2 != null ? a3.a.o(a3.a.v(str2), UptodownApp.G, ":webp") : null);
            float f10 = UptodownApp.E;
            Context context3 = g1Var.itemView.getContext();
            context3.getClass();
            d0VarE.g(k4.c.y(context3));
            d0VarE.e(imageView, null);
        }
        String str3 = t0Var.f8746l;
        if (str3 != null && str3.length() != 0) {
            usernameTextView.setText(t0Var.f8746l);
        }
        final int i12 = 0;
        usernameTextView.setOnClickListener(new View.OnClickListener() { // from class: n4.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i12) {
                    case 0:
                        g1Var.f11351c.o(i10);
                        break;
                    case 1:
                        g1Var.f11351c.o(i10);
                        break;
                    default:
                        g1Var.f11351c.K(i10);
                        break;
                }
            }
        });
        final int i13 = 1;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: n4.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i13) {
                    case 0:
                        g1Var.f11351c.o(i10);
                        break;
                    case 1:
                        g1Var.f11351c.o(i10);
                        break;
                    default:
                        g1Var.f11351c.K(i10);
                        break;
                }
            }
        });
        boolean zContains = v5.n.f13172d.contains(Long.valueOf(t0Var.f8739a));
        ImageView imageView6 = r0Var.f7316c;
        View view2 = g1Var.itemView;
        if (zContains) {
            com.mbridge.msdk.dycreator.baseview.a.p(view2, R.drawable.vector_heart_red, imageView6);
        } else {
            com.mbridge.msdk.dycreator.baseview.a.p(view2, R.drawable.vector_heart, imageView6);
        }
        String str4 = t0Var.f8743i;
        if (str4 != null) {
            r0Var.f7322m.setText(str4);
        }
        Spanned spannedA = t0Var.a();
        if (spannedA == null || spannedA.length() == 0) {
            textView.setVisibility(8);
            textView2.setVisibility(4);
            linearLayout2.setVisibility(4);
            linearLayout.setVisibility(4);
            return;
        }
        Spanned spannedA2 = t0Var.a();
        textView2.setText(spannedA2 != null ? o7.m.v0(spannedA2) : null);
        textView2.setVisibility(0);
        final int i14 = 2;
        textView2.getViewTreeObserver().addOnPreDrawListener(new e5.g0(g1Var, i14));
        textView.setOnClickListener(new View.OnClickListener() { // from class: n4.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view22) {
                switch (i14) {
                    case 0:
                        g1Var.f11351c.o(i10);
                        break;
                    case 1:
                        g1Var.f11351c.o(i10);
                        break;
                    default:
                        g1Var.f11351c.K(i10);
                        break;
                }
            }
        });
        linearLayout2.setTag(Integer.valueOf(i10));
        linearLayout2.setOnClickListener(new e5.s(g1Var, 21));
        int i15 = t0Var.h;
        TextView textView3 = r0Var.f7324o;
        if (i15 > 0) {
            textView3.setText(String.valueOf(i15));
        } else {
            textView3.setText(g1Var.itemView.getContext().getString(R.string.reply));
        }
        r0Var.f7323n.setText(String.valueOf(t0Var.f8744j));
        linearLayout.setTag(Integer.valueOf(i10));
        linearLayout.setOnClickListener(new f5(15, g1Var, t0Var));
        linearLayout2.setVisibility(0);
        linearLayout.setVisibility(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.review_mini, null, false);
        int i11 = R.id.iv_avatar_review;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewG, R.id.iv_avatar_review);
        if (imageView != null) {
            i11 = R.id.iv_likes_counter_review;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewG, R.id.iv_likes_counter_review);
            if (imageView2 != null) {
                i11 = R.id.iv_star1_review;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(viewG, R.id.iv_star1_review);
                if (imageView3 != null) {
                    i11 = R.id.iv_star2_review;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(viewG, R.id.iv_star2_review);
                    if (imageView4 != null) {
                        i11 = R.id.iv_star3_review;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(viewG, R.id.iv_star3_review);
                        if (imageView5 != null) {
                            i11 = R.id.iv_star4_review;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(viewG, R.id.iv_star4_review);
                            if (imageView6 != null) {
                                i11 = R.id.iv_star5_review;
                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(viewG, R.id.iv_star5_review);
                                if (imageView7 != null) {
                                    i11 = R.id.ll_likes_review;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(viewG, R.id.ll_likes_review);
                                    if (linearLayout != null) {
                                        i11 = R.id.ll_reviews_counter_review;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(viewG, R.id.ll_reviews_counter_review);
                                        if (linearLayout2 != null) {
                                            i11 = R.id.ll_stars_review;
                                            if (((LinearLayout) ViewBindings.findChildViewById(viewG, R.id.ll_stars_review)) != null) {
                                                i11 = R.id.tv_app_name_review;
                                                UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(viewG, R.id.tv_app_name_review);
                                                if (usernameTextView != null) {
                                                    i11 = R.id.tv_body_review;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(viewG, R.id.tv_body_review);
                                                    if (textView != null) {
                                                        i11 = R.id.tv_date_review;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(viewG, R.id.tv_date_review);
                                                        if (textView2 != null) {
                                                            i11 = R.id.tv_likes_counter_review;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(viewG, R.id.tv_likes_counter_review);
                                                            if (textView3 != null) {
                                                                i11 = R.id.tv_replies_counter_review;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(viewG, R.id.tv_replies_counter_review);
                                                                if (textView4 != null) {
                                                                    i11 = R.id.tv_show_more_review;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(viewG, R.id.tv_show_more_review);
                                                                    if (textView5 != null) {
                                                                        return new g1(this, new d5.r0((RelativeLayout) viewG, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, linearLayout, linearLayout2, usernameTextView, textView, textView2, textView3, textView4, textView5), this.f11368b);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewG.getResources().getResourceName(i11)));
        return null;
    }
}
