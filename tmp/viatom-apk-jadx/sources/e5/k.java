package e5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.R;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7797a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0 f7798b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f7799c;

    public /* synthetic */ k(j0 j0Var, View view, int i10) {
        this.f7797a = i10;
        this.f7798b = j0Var;
        this.f7799c = view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Resources.NotFoundException {
        int i10 = this.f7797a;
        View view2 = this.f7799c;
        j0 j0Var = this.f7798b;
        switch (i10) {
            case 0:
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    FragmentActivity activity = j0Var.getActivity();
                    activity.getClass();
                    AlertDialog alertDialog = ((l4.w) activity).f10935w;
                    if (alertDialog != null) {
                        alertDialog.dismiss();
                    }
                    if (view2.getContext() != null) {
                        d5.j jVarG = d5.j.g(j0Var.getLayoutInflater());
                        TextView textView = (TextView) jVarG.f7136d;
                        TextView textView2 = (TextView) jVarG.f;
                        TextView textView3 = (TextView) jVarG.e;
                        TextView textView4 = (TextView) jVarG.f7135c;
                        textView2.setTypeface(o4.b.f11719r);
                        textView2.setText(j0Var.getString(R.string.cancel_registration));
                        textView.setTypeface(o4.b.f11720s);
                        String string = j0Var.getString(R.string.confirm_cancel_preregister, j0Var.D().f8567b);
                        string.getClass();
                        String str = j0Var.D().f8567b;
                        str.getClass();
                        Context context = view2.getContext();
                        context.getClass();
                        SpannableString spannableString = new SpannableString(string);
                        int iK0 = o7.m.k0(string, str, 0, false, 6);
                        int length = str.length() + iK0;
                        if (iK0 != -1) {
                            float dimension = context.getResources().getDimension(R.dimen.text_size_m);
                            Typeface typeface = o4.b.f11719r;
                            typeface.getClass();
                            spannableString.setSpan(new v5.e(dimension, typeface, ContextCompat.getColor(context, R.color.text_primary)), iK0, length, 33);
                        }
                        textView.setText(spannableString);
                        textView4.setTypeface(o4.b.f11719r);
                        textView3.setTypeface(o4.b.f11719r);
                        textView3.setText(j0Var.getString(R.string.dialog_confirmation_verify_afirmative));
                        textView4.setVisibility(0);
                        textView4.setOnClickListener(new r(j0Var, 18));
                        textView3.setOnClickListener(new r(j0Var, 19));
                        ((ImageView) jVarG.g).setOnClickListener(new r(j0Var, 20));
                        AlertDialog.Builder builder = new AlertDialog.Builder(j0Var.requireContext());
                        builder.setView((RelativeLayout) jVarG.f7134b);
                        builder.setCancelable(true);
                        j0Var.l0(builder);
                        break;
                    }
                }
                break;
            default:
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    FragmentActivity activity2 = j0Var.getActivity();
                    activity2.getClass();
                    AlertDialog alertDialog2 = ((l4.w) activity2).f10935w;
                    if (alertDialog2 != null) {
                        alertDialog2.dismiss();
                    }
                    if (view2.getContext() != null) {
                        d5.j jVarG2 = d5.j.g(j0Var.getLayoutInflater());
                        TextView textView5 = (TextView) jVarG2.e;
                        ((TextView) jVarG2.f).setTypeface(o4.b.f11719r);
                        ((TextView) jVarG2.f7136d).setTypeface(o4.b.f11720s);
                        textView5.setTypeface(o4.b.f11719r);
                        textView5.setOnClickListener(new r(j0Var, 16));
                        ((ImageView) jVarG2.g).setOnClickListener(new r(j0Var, 17));
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(j0Var.requireContext());
                        builder2.setView((RelativeLayout) jVarG2.f7134b);
                        builder2.setCancelable(true);
                        j0Var.l0(builder2);
                        break;
                    }
                }
                break;
        }
    }
}
