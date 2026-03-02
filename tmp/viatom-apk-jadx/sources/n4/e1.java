package n4;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import java.util.ArrayList;
import y5.b2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e1 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11334a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.x f11335b;

    public e1(ArrayList arrayList, a3.x xVar) {
        arrayList.getClass();
        this.f11334a = arrayList;
        this.f11335b = xVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11334a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        b2 b2Var = (b2) viewHolder;
        b2Var.getClass();
        Object obj = this.f11334a.get(i10);
        obj.getClass();
        h5.j1 j1Var = (h5.j1) obj;
        int i11 = j1Var.f8630c;
        w2.r rVar = b2Var.f13819a;
        if (i11 == 1) {
            ((TextView) rVar.f13464d).setText(((RelativeLayout) rVar.f13462b).getContext().getString(R.string.current_device_tag));
        } else {
            ((TextView) rVar.f13464d).setText(j1Var.f8629b);
        }
        if (j1Var.f8631d == 1) {
            RelativeLayout relativeLayout = (RelativeLayout) rVar.f13462b;
            CheckBox checkBox = (CheckBox) rVar.f13463c;
            TextView textView = (TextView) rVar.e;
            relativeLayout.setAlpha(1.0f);
            checkBox.setVisibility(8);
            textView.setVisibility(0);
            textView.setText(relativeLayout.getContext().getString(R.string.app_installed));
            textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(relativeLayout.getContext(), R.drawable.vector_installed_check), (Drawable) null, (Drawable) null, (Drawable) null);
            relativeLayout.setOnClickListener(null);
            checkBox.setOnCheckedChangeListener(null);
            return;
        }
        if (j1Var.e != 1) {
            RelativeLayout relativeLayout2 = (RelativeLayout) rVar.f13462b;
            CheckBox checkBox2 = (CheckBox) rVar.f13463c;
            TextView textView2 = (TextView) rVar.e;
            relativeLayout2.setAlpha(0.3f);
            checkBox2.setVisibility(8);
            textView2.setVisibility(0);
            textView2.setText(relativeLayout2.getContext().getString(R.string.device_not_compatible));
            textView2.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(relativeLayout2.getContext(), R.drawable.vector_incompatible), (Drawable) null, (Drawable) null, (Drawable) null);
            relativeLayout2.setOnClickListener(null);
            checkBox2.setOnCheckedChangeListener(null);
            return;
        }
        CheckBox checkBox3 = (CheckBox) rVar.f13463c;
        TextView textView3 = (TextView) rVar.e;
        RelativeLayout relativeLayout3 = (RelativeLayout) rVar.f13462b;
        checkBox3.setVisibility(0);
        if (j1Var.f != 1) {
            relativeLayout3.setAlpha(1.0f);
            checkBox3.setClickable(true);
            checkBox3.setChecked(false);
            textView3.setVisibility(8);
            textView3.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            relativeLayout3.setOnClickListener(new y5.p(b2Var, 6));
            checkBox3.setOnCheckedChangeListener(new com.google.android.material.chip.a(b2Var, 2));
            return;
        }
        relativeLayout3.setAlpha(0.3f);
        checkBox3.setClickable(false);
        checkBox3.setChecked(true);
        textView3.setVisibility(0);
        textView3.setText(relativeLayout3.getContext().getString(R.string.install_pending));
        textView3.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(relativeLayout3.getContext(), R.drawable.vector_pending), (Drawable) null, (Drawable) null, (Drawable) null);
        relativeLayout3.setOnClickListener(null);
        checkBox3.setOnCheckedChangeListener(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.user_remote_install_device_item, viewGroup, false);
        int i11 = R.id.cb_remote_install_device_item;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(viewG, R.id.cb_remote_install_device_item);
        if (checkBox != null) {
            i11 = R.id.iv_remote_install_device_item;
            if (((ImageView) ViewBindings.findChildViewById(viewG, R.id.iv_remote_install_device_item)) != null) {
                i11 = R.id.ll_remote_install_device_item;
                if (((LinearLayout) ViewBindings.findChildViewById(viewG, R.id.ll_remote_install_device_item)) != null) {
                    i11 = R.id.tv_remote_install_device_name_item;
                    TextView textView = (TextView) ViewBindings.findChildViewById(viewG, R.id.tv_remote_install_device_name_item);
                    if (textView != null) {
                        i11 = R.id.tv_remote_install_status_item;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(viewG, R.id.tv_remote_install_status_item);
                        if (textView2 != null) {
                            return new b2(new w2.r((RelativeLayout) viewG, checkBox, textView, textView2, 15), this.f11335b);
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewG.getResources().getResourceName(i11)));
        return null;
    }
}
