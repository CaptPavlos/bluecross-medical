package l4;

import android.view.View;
import com.uptodown.activities.UserDeviceDetailsActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class ya implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11051a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserDeviceDetailsActivity f11052b;

    public /* synthetic */ ya(UserDeviceDetailsActivity userDeviceDetailsActivity, int i10) {
        this.f11051a = i10;
        this.f11052b = userDeviceDetailsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i10 = this.f11051a;
        UserDeviceDetailsActivity userDeviceDetailsActivity = this.f11052b;
        switch (i10) {
            case 0:
                int i11 = UserDeviceDetailsActivity.N;
                userDeviceDetailsActivity.getOnBackPressedDispatcher().onBackPressed();
                break;
            case 1:
                int i12 = UserDeviceDetailsActivity.N;
                userDeviceDetailsActivity.getOnBackPressedDispatcher().onBackPressed();
                break;
            case 2:
                int i13 = UserDeviceDetailsActivity.N;
                boolean zBooleanValue = ((Boolean) userDeviceDetailsActivity.o0().h.getValue()).booleanValue();
                n4.b1 b1Var = userDeviceDetailsActivity.J;
                if (zBooleanValue) {
                    if (b1Var != null && (arrayList2 = b1Var.f11307a) != null && arrayList2.size() > 1) {
                        t6.q.W(arrayList2, new a9.i(17));
                    }
                    n4.b1 b1Var2 = userDeviceDetailsActivity.J;
                    if (b1Var2 != null) {
                        b1Var2.notifyDataSetChanged();
                    }
                    userDeviceDetailsActivity.n0().f7020c.animate().rotation(180.0f).setDuration(200L).start();
                } else {
                    if (b1Var != null && (arrayList = b1Var.f11307a) != null && arrayList.size() > 1) {
                        t6.q.W(arrayList, new a9.i(18));
                    }
                    n4.b1 b1Var3 = userDeviceDetailsActivity.J;
                    if (b1Var3 != null) {
                        b1Var3.notifyDataSetChanged();
                    }
                    userDeviceDetailsActivity.n0().f7020c.animate().rotation(0.0f).setDuration(200L).start();
                }
                u7.m0 m0Var = userDeviceDetailsActivity.o0().h;
                Boolean boolValueOf = Boolean.valueOf(!((Boolean) userDeviceDetailsActivity.o0().h.getValue()).booleanValue());
                m0Var.getClass();
                m0Var.g(null, boolValueOf);
                userDeviceDetailsActivity.n0().f7023j.setAdapter(userDeviceDetailsActivity.J);
                break;
            default:
                int i14 = UserDeviceDetailsActivity.N;
                userDeviceDetailsActivity.Q();
                break;
        }
    }
}
