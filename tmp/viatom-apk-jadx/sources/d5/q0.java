package d5;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.util.views.UsernameTextView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7295a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f7296b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f7297c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f7298d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f7299i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f7300j;

    /* renamed from: k, reason: collision with root package name */
    public final LinearLayout f7301k;

    /* renamed from: l, reason: collision with root package name */
    public final LinearLayout f7302l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f7303m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f7304n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f7305o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f7306p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f7307q;

    /* renamed from: r, reason: collision with root package name */
    public final TextView f7308r;

    /* renamed from: s, reason: collision with root package name */
    public final UsernameTextView f7309s;

    public q0(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, UsernameTextView usernameTextView) {
        this.f7295a = relativeLayout;
        this.f7296b = imageView;
        this.f7297c = imageView2;
        this.f7298d = imageView3;
        this.e = imageView4;
        this.f = imageView5;
        this.g = imageView6;
        this.h = imageView7;
        this.f7299i = imageView8;
        this.f7300j = imageView9;
        this.f7301k = linearLayout;
        this.f7302l = linearLayout2;
        this.f7303m = textView;
        this.f7304n = textView2;
        this.f7305o = textView3;
        this.f7306p = textView4;
        this.f7307q = textView5;
        this.f7308r = textView6;
        this.f7309s = usernameTextView;
    }

    public static q0 a(View view) {
        int i10 = R.id.iv_author_verified_review;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_author_verified_review);
        if (imageView != null) {
            i10 = R.id.iv_avatar_review;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_avatar_review);
            if (imageView2 != null) {
                i10 = R.id.iv_follow_user_review;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_follow_user_review);
                if (imageView3 != null) {
                    i10 = R.id.iv_likes_counter_review;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_likes_counter_review);
                    if (imageView4 != null) {
                        i10 = R.id.iv_star1_review;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star1_review);
                        if (imageView5 != null) {
                            i10 = R.id.iv_star2_review;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star2_review);
                            if (imageView6 != null) {
                                i10 = R.id.iv_star3_review;
                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star3_review);
                                if (imageView7 != null) {
                                    i10 = R.id.iv_star4_review;
                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star4_review);
                                    if (imageView8 != null) {
                                        i10 = R.id.iv_star5_review;
                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star5_review);
                                        if (imageView9 != null) {
                                            i10 = R.id.iv_turbo_mark_review;
                                            if (((ImageView) ViewBindings.findChildViewById(view, R.id.iv_turbo_mark_review)) != null) {
                                                i10 = R.id.ll_likes_review;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_likes_review);
                                                if (linearLayout != null) {
                                                    i10 = R.id.ll_reviews_counter_review;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_reviews_counter_review);
                                                    if (linearLayout2 != null) {
                                                        i10 = R.id.ll_stars_review;
                                                        if (((LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_stars_review)) != null) {
                                                            i10 = R.id.ll_username_review;
                                                            if (((LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_username_review)) != null) {
                                                                i10 = R.id.tv_body_review;
                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_body_review);
                                                                if (textView != null) {
                                                                    i10 = R.id.tv_date_review;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_date_review);
                                                                    if (textView2 != null) {
                                                                        i10 = R.id.tv_likes_counter_review;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_likes_counter_review);
                                                                        if (textView3 != null) {
                                                                            i10 = R.id.tv_reply_review;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_reply_review);
                                                                            if (textView4 != null) {
                                                                                i10 = R.id.tv_reviews_counter_review;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_reviews_counter_review);
                                                                                if (textView5 != null) {
                                                                                    i10 = R.id.tv_show_more_review;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_show_more_review);
                                                                                    if (textView6 != null) {
                                                                                        i10 = R.id.tv_username_review;
                                                                                        UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(view, R.id.tv_username_review);
                                                                                        if (usernameTextView != null) {
                                                                                            return new q0((RelativeLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, linearLayout, linearLayout2, textView, textView2, textView3, textView4, textView5, textView6, usernameTextView);
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
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        return null;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7295a;
    }
}
