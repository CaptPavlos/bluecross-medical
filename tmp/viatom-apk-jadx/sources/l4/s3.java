package l4;

import android.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class s3 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10811a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a4 f10812b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h5.y0 f10813c;

    public /* synthetic */ s3(h5.y0 y0Var, a4 a4Var) {
        this.f10813c = y0Var;
        this.f10812b = a4Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f10811a;
        h5.y0 y0Var = this.f10813c;
        a4 a4Var = this.f10812b;
        int i11 = 0;
        switch (i10) {
            case 0:
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    k4.c.w(y0Var.f8795b);
                    h5.q qVar = y0Var.f8798i;
                    if (qVar != null) {
                        qVar.s(a4Var);
                    }
                    k4.c.E(a4Var);
                    AlertDialog alertDialog = a4Var.f10935w;
                    alertDialog.getClass();
                    alertDialog.dismiss();
                    a4Var.O = false;
                    break;
                }
                break;
            default:
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    AlertDialog alertDialog2 = a4Var.f10935w;
                    alertDialog2.getClass();
                    alertDialog2.dismiss();
                    a4Var.O = false;
                    String str = y0Var.h;
                    str.getClass();
                    AlertDialog.Builder builder = new AlertDialog.Builder(a4Var);
                    View viewInflate = a4Var.getLayoutInflater().inflate(R.layout.dialog_changelog, (ViewGroup) null, false);
                    int i12 = R.id.ll_dialog_cd;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_dialog_cd);
                    if (linearLayout != null) {
                        i12 = R.id.tv_accept_cd;
                        TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_accept_cd);
                        if (textView != null) {
                            i12 = R.id.tv_changelog_cd;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_changelog_cd);
                            if (textView2 != null) {
                                i12 = R.id.tv_title_cd;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_cd);
                                if (textView3 != null) {
                                    LinearLayout linearLayout2 = (LinearLayout) viewInflate;
                                    linearLayout2.setOnClickListener(new r3(a4Var, i11));
                                    linearLayout.setOnClickListener(new e5.n(12));
                                    textView3.setTypeface(o4.b.f11719r);
                                    textView2.setTypeface(o4.b.f11720s);
                                    textView2.setText(str);
                                    textView.setTypeface(o4.b.f11719r);
                                    textView.setOnClickListener(new r3(a4Var, 1));
                                    builder.setView(linearLayout2);
                                    a4Var.f10935w = builder.create();
                                    if (!a4Var.isFinishing()) {
                                        AlertDialog alertDialog3 = a4Var.f10935w;
                                        alertDialog3.getClass();
                                        Window window = alertDialog3.getWindow();
                                        if (window != null) {
                                            a3.a.A(window, 0);
                                        }
                                        AlertDialog alertDialog4 = a4Var.f10935w;
                                        alertDialog4.getClass();
                                        alertDialog4.show();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i12)));
                    break;
                }
                break;
        }
    }

    public /* synthetic */ s3(a4 a4Var, h5.y0 y0Var) {
        this.f10812b = a4Var;
        this.f10813c = y0Var;
    }
}
