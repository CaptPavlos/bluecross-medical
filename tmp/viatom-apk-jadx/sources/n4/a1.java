package n4;

import android.content.Context;
import android.content.Intent;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.UserCommentsActivity;
import java.util.ArrayList;
import l4.x4;
import y5.u1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a1 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11296a;

    /* renamed from: b, reason: collision with root package name */
    public final x4 f11297b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11298c;

    public a1(ArrayList arrayList, x4 x4Var) {
        x4Var.getClass();
        this.f11296a = arrayList;
        this.f11297b = x4Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11296a.size() + (this.f11298c ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        return i10 == this.f11296a.size() ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i10) {
        ImageView imageView;
        String strO;
        viewHolder.getClass();
        if (viewHolder instanceof u1) {
            Object obj = this.f11296a.get(i10);
            obj.getClass();
            h5.t0 t0Var = (h5.t0) obj;
            final u1 u1Var = (u1) viewHolder;
            ImageView imageView2 = u1Var.f14041q;
            ImageView imageView3 = u1Var.f14040p;
            ImageView imageView4 = u1Var.f14039o;
            ImageView imageView5 = u1Var.f14038n;
            TextView textView = u1Var.f14031c;
            LinearLayout linearLayout = u1Var.f14034j;
            LinearLayout linearLayout2 = u1Var.f14033i;
            ImageView imageView6 = u1Var.f14032d;
            TextView textView2 = u1Var.f;
            Context context = u1Var.f14030b;
            String str = t0Var.f8746l;
            if (str != null && str.length() != 0) {
                textView.setText(t0Var.f8746l);
            }
            String str2 = t0Var.f8742d;
            if ((str2 != null ? a3.a.o(a3.a.v(str2), UptodownApp.G, ":webp") : null) != null) {
                j4.y yVarD = j4.y.d();
                String str3 = t0Var.f8742d;
                if (str3 != null) {
                    imageView = imageView2;
                    strO = a3.a.o(a3.a.v(str3), UptodownApp.G, ":webp");
                } else {
                    imageView = imageView2;
                    strO = null;
                }
                j4.d0 d0VarE = yVarD.e(strO);
                float f = UptodownApp.E;
                d0VarE.g(k4.c.y(context));
                d0VarE.e(imageView6, null);
            } else {
                imageView = imageView2;
                j4.d0 d0VarF = j4.y.d().f();
                float f10 = UptodownApp.E;
                d0VarF.g(k4.c.y(context));
                d0VarF.e(imageView6, null);
            }
            String str4 = t0Var.f8743i;
            if (str4 != null) {
                u1Var.e.setText(str4);
            }
            Spanned spannedA = t0Var.a();
            final int i11 = 0;
            if (spannedA == null || spannedA.length() == 0) {
                textView2.setVisibility(8);
                linearLayout2.setVisibility(8);
                linearLayout.setVisibility(8);
            } else {
                textView2.setText(t0Var.a());
                textView2.setVisibility(0);
                linearLayout2.setVisibility(0);
                linearLayout.setVisibility(0);
            }
            u1Var.h.setText(String.valueOf(t0Var.f8744j));
            boolean zContains = v5.n.f13172d.contains(Long.valueOf(t0Var.f8739a));
            ImageView imageView7 = u1Var.f14036l;
            if (zContains) {
                imageView7.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_heart_red));
            } else {
                imageView7.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_heart));
            }
            int i12 = t0Var.h;
            TextView textView3 = u1Var.f14035k;
            if (i12 == 0) {
                textView3.setText(context.getString(R.string.reply));
            } else {
                textView3.setText(String.valueOf(i12));
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: y5.t1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i13 = i11;
                    int i14 = i10;
                    u1 u1Var2 = u1Var;
                    switch (i13) {
                        case 0:
                            u1Var2.f14029a.u(i14);
                            break;
                        case 1:
                            u1Var2.f14029a.u(i14);
                            break;
                        default:
                            x4 x4Var = u1Var2.f14029a;
                            x4Var.getClass();
                            UserCommentsActivity userCommentsActivity = (UserCommentsActivity) x4Var.f10987b;
                            Intent intent = new Intent(userCommentsActivity, (Class<?>) RepliesActivity.class);
                            n4.a1 a1Var = userCommentsActivity.J;
                            a1Var.getClass();
                            Object obj2 = a1Var.f11296a.get(i14);
                            obj2.getClass();
                            h5.t0 t0Var2 = (h5.t0) obj2;
                            t0Var2.f8747m = ((h5.e1) userCommentsActivity.o0().e.getValue()).d() ? 1 : 0;
                            t0Var2.f8748n = ((h5.e1) userCommentsActivity.o0().e.getValue()).f;
                            t0Var2.f8740b = ((h5.e1) userCommentsActivity.o0().e.getValue()).f8512a;
                            intent.putExtra("review", t0Var2);
                            intent.putExtra("username", ((h5.e1) userCommentsActivity.o0().e.getValue()).f8515d);
                            intent.putExtra("appName", t0Var2.f8746l);
                            intent.putExtra("appIconUrl", t0Var2.f8742d);
                            intent.putExtra("userAvatarUrl", ((h5.e1) userCommentsActivity.o0().e.getValue()).f8514c);
                            float f11 = UptodownApp.E;
                            userCommentsActivity.startActivity(intent, k4.c.a(userCommentsActivity));
                            break;
                    }
                }
            });
            final int i13 = 1;
            imageView6.setOnClickListener(new View.OnClickListener() { // from class: y5.t1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i132 = i13;
                    int i14 = i10;
                    u1 u1Var2 = u1Var;
                    switch (i132) {
                        case 0:
                            u1Var2.f14029a.u(i14);
                            break;
                        case 1:
                            u1Var2.f14029a.u(i14);
                            break;
                        default:
                            x4 x4Var = u1Var2.f14029a;
                            x4Var.getClass();
                            UserCommentsActivity userCommentsActivity = (UserCommentsActivity) x4Var.f10987b;
                            Intent intent = new Intent(userCommentsActivity, (Class<?>) RepliesActivity.class);
                            n4.a1 a1Var = userCommentsActivity.J;
                            a1Var.getClass();
                            Object obj2 = a1Var.f11296a.get(i14);
                            obj2.getClass();
                            h5.t0 t0Var2 = (h5.t0) obj2;
                            t0Var2.f8747m = ((h5.e1) userCommentsActivity.o0().e.getValue()).d() ? 1 : 0;
                            t0Var2.f8748n = ((h5.e1) userCommentsActivity.o0().e.getValue()).f;
                            t0Var2.f8740b = ((h5.e1) userCommentsActivity.o0().e.getValue()).f8512a;
                            intent.putExtra("review", t0Var2);
                            intent.putExtra("username", ((h5.e1) userCommentsActivity.o0().e.getValue()).f8515d);
                            intent.putExtra("appName", t0Var2.f8746l);
                            intent.putExtra("appIconUrl", t0Var2.f8742d);
                            intent.putExtra("userAvatarUrl", ((h5.e1) userCommentsActivity.o0().e.getValue()).f8514c);
                            float f11 = UptodownApp.E;
                            userCommentsActivity.startActivity(intent, k4.c.a(userCommentsActivity));
                            break;
                    }
                }
            });
            linearLayout2.setOnClickListener(new y5.t(i10, u1Var, i13, t0Var));
            final int i14 = 2;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: y5.t1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i132 = i14;
                    int i142 = i10;
                    u1 u1Var2 = u1Var;
                    switch (i132) {
                        case 0:
                            u1Var2.f14029a.u(i142);
                            break;
                        case 1:
                            u1Var2.f14029a.u(i142);
                            break;
                        default:
                            x4 x4Var = u1Var2.f14029a;
                            x4Var.getClass();
                            UserCommentsActivity userCommentsActivity = (UserCommentsActivity) x4Var.f10987b;
                            Intent intent = new Intent(userCommentsActivity, (Class<?>) RepliesActivity.class);
                            n4.a1 a1Var = userCommentsActivity.J;
                            a1Var.getClass();
                            Object obj2 = a1Var.f11296a.get(i142);
                            obj2.getClass();
                            h5.t0 t0Var2 = (h5.t0) obj2;
                            t0Var2.f8747m = ((h5.e1) userCommentsActivity.o0().e.getValue()).d() ? 1 : 0;
                            t0Var2.f8748n = ((h5.e1) userCommentsActivity.o0().e.getValue()).f;
                            t0Var2.f8740b = ((h5.e1) userCommentsActivity.o0().e.getValue()).f8512a;
                            intent.putExtra("review", t0Var2);
                            intent.putExtra("username", ((h5.e1) userCommentsActivity.o0().e.getValue()).f8515d);
                            intent.putExtra("appName", t0Var2.f8746l);
                            intent.putExtra("appIconUrl", t0Var2.f8742d);
                            intent.putExtra("userAvatarUrl", ((h5.e1) userCommentsActivity.o0().e.getValue()).f8514c);
                            float f11 = UptodownApp.E;
                            userCommentsActivity.startActivity(intent, k4.c.a(userCommentsActivity));
                            break;
                    }
                }
            });
            Spanned spannedA2 = t0Var.a();
            textView2.setText(spannedA2 != null ? o7.m.v0(spannedA2) : null);
            textView2.getViewTreeObserver().addOnPreDrawListener(new e5.g0(u1Var, 3));
            u1Var.g.setOnClickListener(new y5.p(u1Var, 5));
            u1Var.f14037m.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
            imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
            imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
            imageView3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
            ImageView imageView8 = imageView;
            imageView8.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
            if (t0Var.g >= 2) {
                imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
            }
            if (t0Var.g >= 3) {
                imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
            }
            if (t0Var.g >= 4) {
                imageView3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
            }
            if (t0Var.g == 5) {
                imageView8.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        if (i10 != 0) {
            if (i10 == 1) {
                return new y5.h0(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.pb_loading_more_content, viewGroup, false));
            }
            com.google.gson.internal.a.n("viewType unknown");
            return null;
        }
        View viewX = com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.review, viewGroup, false);
        Context context = viewGroup.getContext();
        context.getClass();
        return new u1(viewX, this.f11297b, context);
    }
}
