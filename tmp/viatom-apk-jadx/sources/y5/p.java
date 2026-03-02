package y5;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.FeedActivity;
import com.uptodown.activities.GdprPrivacySettings;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.Updates;
import l4.o9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class p implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13961a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13962b;

    public /* synthetic */ p(Object obj, int i10) {
        this.f13961a = i10;
        this.f13962b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int bindingAdapterPosition;
        int i10 = this.f13961a;
        Object obj = this.f13962b;
        switch (i10) {
            case 0:
                d0.i iVar = ((q) obj).f13970b;
                switch (iVar.f6780a) {
                    case 11:
                        e5.m1 m1Var = (e5.m1) iVar.f6781b;
                        float f = UptodownApp.E;
                        if (k4.c.s()) {
                            FragmentActivity fragmentActivityRequireActivity = m1Var.requireActivity();
                            fragmentActivityRequireActivity.getClass();
                            String string = m1Var.getString(R.string.url_turbo);
                            string.getClass();
                            v5.c.e(fragmentActivityRequireActivity, string, m1Var.getString(R.string.uptodown_turbo));
                            break;
                        }
                        break;
                    default:
                        FeedActivity feedActivity = (FeedActivity) iVar.f6781b;
                        float f10 = UptodownApp.E;
                        if (k4.c.s()) {
                            String string2 = feedActivity.getString(R.string.url_turbo);
                            string2.getClass();
                            v5.c.e(feedActivity, string2, feedActivity.getString(R.string.uptodown_turbo));
                            break;
                        }
                        break;
                }
            case 1:
                ((RepliesActivity) ((w0) obj).f14053b.f10654b).l0();
                break;
            case 2:
                o1 o1Var = (o1) obj;
                g5.b bVar = o1Var.f13957a;
                if (bVar != null && (bindingAdapterPosition = o1Var.getBindingAdapterPosition()) != -1) {
                    bVar.a(bindingAdapterPosition);
                    break;
                }
                break;
            case 3:
                Updates updates = ((p1) obj).f13965a.f10695a;
                float f11 = UptodownApp.E;
                if (k4.c.s() && k4.c.E(updates)) {
                    int i11 = Updates.f6656p0;
                    u7.m0 m0Var = updates.J0().f11049c;
                    Boolean bool = Boolean.TRUE;
                    m0Var.getClass();
                    m0Var.g(null, bool);
                    break;
                }
                break;
            case 4:
                ((s1) obj).f14008a.getClass();
                break;
            case 5:
                u1 u1Var = (u1) obj;
                TextView textView = u1Var.f;
                Context context = u1Var.f14030b;
                TextView textView2 = u1Var.g;
                int maxLines = textView.getMaxLines();
                TextView textView3 = u1Var.f;
                if (maxLines != Integer.MAX_VALUE) {
                    textView3.setMaxLines(Integer.MAX_VALUE);
                    textView2.setText(context.getString(R.string.read_less_desc_app_detail));
                    break;
                } else {
                    textView3.setMaxLines(4);
                    textView2.setText(context.getString(R.string.read_more_desc_app_detail));
                    break;
                }
            case 6:
                ((CheckBox) ((b2) obj).f13819a.f13463c).performClick();
                break;
            default:
                o9 o9Var = (o9) obj;
                o9Var.getClass();
                float f12 = UptodownApp.E;
                if (k4.c.s()) {
                    Updates updates2 = o9Var.f10695a;
                    int i12 = Updates.f6656p0;
                    updates2.f6660n0.launch(new Intent(updates2.getApplicationContext(), (Class<?>) GdprPrivacySettings.class), k4.c.b(updates2));
                    break;
                }
                break;
        }
    }
}
