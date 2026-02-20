package n4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.util.views.UsernameTextView;
import java.util.ArrayList;
import l4.f5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11318a;

    /* renamed from: b, reason: collision with root package name */
    public final d0.i f11319b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11320c;

    public d(ArrayList arrayList, d0.i iVar) {
        arrayList.getClass();
        iVar.getClass();
        this.f11318a = arrayList;
        this.f11319b = iVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11318a.size() + (this.f11320c ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        return i10 == this.f11318a.size() ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        viewHolder.getClass();
        if (viewHolder instanceof y5.u) {
            y5.u uVar = (y5.u) viewHolder;
            Object obj = this.f11318a.get(i10);
            obj.getClass();
            h5.e1 e1Var = (h5.e1) obj;
            Context context = uVar.f14024c;
            a3.z0 z0Var = uVar.f14022a;
            j4.y yVarD = j4.y.d();
            String str = e1Var.f8514c;
            j4.d0 d0VarE = yVarD.e(str != null ? a3.a.o(a3.a.v(str), UptodownApp.N, ":webp") : null);
            float f = UptodownApp.E;
            context.getClass();
            d0VarE.g(k4.c.y(context));
            ImageView imageView = (ImageView) z0Var.f196b;
            UsernameTextView usernameTextView = (UsernameTextView) z0Var.e;
            ImageView imageView2 = (ImageView) z0Var.f197c;
            TextView textView = (TextView) z0Var.f198d;
            d0VarE.e(imageView, null);
            ((RelativeLayout) z0Var.f).setOnClickListener(new f5(24, uVar, e1Var));
            boolean zD = e1Var.d();
            ImageView imageView3 = (ImageView) z0Var.f196b;
            if (zD) {
                int dimension = (int) imageView3.getContext().getResources().getDimension(R.dimen.border_radius_xs);
                imageView3.setForeground(ContextCompat.getDrawable(imageView3.getContext(), R.drawable.shape_stroke_review_avatar_turbo));
                imageView3.setPadding(dimension, dimension, dimension, dimension);
                imageView2.setVisibility(0);
            } else {
                imageView3.setForeground(null);
                imageView3.setPadding(0, 0, 0, 0);
                imageView2.setVisibility(8);
            }
            usernameTextView.setText(e1Var.f8515d);
            int i11 = UsernameTextView.f6728j;
            l1.b.j(usernameTextView, e1Var.d(), e1Var.f);
            textView.setOnClickListener(new y5.t(uVar, e1Var, i10));
            int i12 = e1Var.f8516i;
            if (i12 == 1) {
                textView.setVisibility(0);
                textView.setText(context.getString(R.string.following));
                textView.setBackground(ContextCompat.getDrawable(context, R.drawable.ripple_open_button));
                textView.setTextColor(ContextCompat.getColor(context, R.color.blue_primary));
                return;
            }
            if (i12 != 0) {
                if (i12 == -1) {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(0);
                textView.setText(context.getString(R.string.follow));
                textView.setBackground(ContextCompat.getDrawable(context, R.drawable.ripple_blue_primary_button));
                textView.setTextColor(ContextCompat.getColor(context, R.color.white));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        if (i10 != 0) {
            if (i10 != 1) {
                com.google.gson.internal.a.n("viewType unknown");
                return null;
            }
            View viewB = c.i.b(viewGroup, R.layout.pb_loading_more_content, viewGroup, false);
            viewB.getClass();
            return new y5.h0(viewB);
        }
        View viewB2 = c.i.b(viewGroup, R.layout.follow_list_item, viewGroup, false);
        int i11 = R.id.iv_avatar_follow_list_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewB2, R.id.iv_avatar_follow_list_item);
        if (imageView != null) {
            i11 = R.id.iv_turbo_mark_follow_list_item;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewB2, R.id.iv_turbo_mark_follow_list_item);
            if (imageView2 != null) {
                i11 = R.id.tv_action_follow_list_item;
                TextView textView = (TextView) ViewBindings.findChildViewById(viewB2, R.id.tv_action_follow_list_item);
                if (textView != null) {
                    i11 = R.id.tv_username_follow_list_item;
                    UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(viewB2, R.id.tv_username_follow_list_item);
                    if (usernameTextView != null) {
                        return new y5.u(new a3.z0((RelativeLayout) viewB2, imageView, imageView2, textView, usernameTextView, 3), this.f11319b);
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewB2.getResources().getResourceName(i11)));
        return null;
    }
}
