package e5;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.RepliesActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7772a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0 f7773b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h5.t0 f7774c;

    public /* synthetic */ i(j0 j0Var, h5.t0 t0Var, int i10) {
        this.f7772a = i10;
        this.f7773b = j0Var;
        this.f7774c = t0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f7772a;
        h5.t0 t0Var = this.f7774c;
        j0 j0Var = this.f7773b;
        switch (i10) {
            case 0:
                j0Var.U(t0Var);
                break;
            case 1:
                j0Var.U(t0Var);
                break;
            case 2:
                Context contextRequireContext = j0Var.requireContext();
                contextRequireContext.getClass();
                if (h5.c1.h(contextRequireContext) == null) {
                    if (j0Var.getActivity() != null) {
                        FragmentActivity activity = j0Var.getActivity();
                        activity.getClass();
                        String string = j0Var.getString(R.string.login_required_follow_title);
                        string.getClass();
                        String string2 = j0Var.getString(R.string.login_required_follow_msg);
                        string2.getClass();
                        a.a.q((l4.w) activity, string, string2);
                        break;
                    }
                } else {
                    c1 c1VarG = j0Var.G();
                    Context contextRequireContext2 = j0Var.requireContext();
                    contextRequireContext2.getClass();
                    int i11 = t0Var.f8749o;
                    String str = t0Var.f8740b;
                    str.getClass();
                    c1VarG.a(contextRequireContext2, i11, str);
                    break;
                }
                break;
            case 3:
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    Intent intent = new Intent(j0Var.requireActivity(), (Class<?>) RepliesActivity.class);
                    intent.putExtra("review", t0Var);
                    intent.putExtra("appName", j0Var.D().f8567b);
                    intent.putExtra("appIconUrl", j0Var.D().f8575l);
                    FragmentActivity fragmentActivityRequireActivity = j0Var.requireActivity();
                    fragmentActivityRequireActivity.getClass();
                    j0Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
                    break;
                }
                break;
            case 4:
                j0Var.U(t0Var);
                break;
            case 5:
                j0Var.U(t0Var);
                break;
            case 6:
                Context contextRequireContext3 = j0Var.requireContext();
                contextRequireContext3.getClass();
                if (h5.c1.h(contextRequireContext3) == null) {
                    if (j0Var.getActivity() != null) {
                        FragmentActivity activity2 = j0Var.getActivity();
                        activity2.getClass();
                        String string3 = j0Var.getString(R.string.login_required_follow_title);
                        string3.getClass();
                        String string4 = j0Var.getString(R.string.login_required_follow_msg);
                        string4.getClass();
                        a.a.q((l4.w) activity2, string3, string4);
                        break;
                    }
                } else {
                    c1 c1VarG2 = j0Var.G();
                    Context contextRequireContext4 = j0Var.requireContext();
                    contextRequireContext4.getClass();
                    int i12 = t0Var.f8749o;
                    String str2 = t0Var.f8740b;
                    str2.getClass();
                    c1VarG2.a(contextRequireContext4, i12, str2);
                    break;
                }
                break;
            default:
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    Intent intent2 = new Intent(j0Var.requireActivity(), (Class<?>) RepliesActivity.class);
                    intent2.putExtra("review", t0Var);
                    intent2.putExtra("appName", j0Var.D().f8567b);
                    intent2.putExtra("appIconUrl", j0Var.D().f8575l);
                    FragmentActivity fragmentActivityRequireActivity2 = j0Var.requireActivity();
                    fragmentActivityRequireActivity2.getClass();
                    j0Var.startActivity(intent2, k4.c.a(fragmentActivityRequireActivity2));
                    break;
                }
                break;
        }
    }
}
