package l4;

import android.widget.TextView;
import com.uptodown.activities.UserDevicesActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class jb implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserDevicesActivity f10535a;

    public jb(UserDevicesActivity userDevicesActivity) {
        this.f10535a = userDevicesActivity;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        v5.m mVar = (v5.m) obj;
        boolean zA = kotlin.jvm.internal.l.a(mVar, v5.j.f13166a);
        UserDevicesActivity userDevicesActivity = this.f10535a;
        if (zA) {
            userDevicesActivity.n0().f7046b.setVisibility(0);
            userDevicesActivity.n0().f7047c.setVisibility(8);
        } else {
            if (mVar instanceof v5.l) {
                nb nbVar = (nb) ((v5.l) mVar).f13168a;
                h5.h1 h1Var = nbVar.f10666a;
                ArrayList arrayList = nbVar.f10667b;
                int i10 = UserDevicesActivity.K;
                userDevicesActivity.n0().f7049i.f.setTypeface(o4.b.f11719r);
                userDevicesActivity.n0().f7049i.e.setTypeface(o4.b.f11720s);
                userDevicesActivity.n0().f7049i.f.setText(h1Var.f8607c);
                TextView textView = userDevicesActivity.n0().f7049i.e;
                long j10 = h1Var.h;
                textView.setText(j10 > 0 ? new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date(j10)) : null);
                userDevicesActivity.n0().f7049i.f6983b.setOnClickListener(new f5(8, userDevicesActivity, h1Var));
                if (arrayList.isEmpty()) {
                    userDevicesActivity.n0().f.setVisibility(8);
                } else {
                    userDevicesActivity.n0().f7048d.setAdapter(new n4.c1(arrayList, new i0.k(16, userDevicesActivity, mVar)));
                }
                userDevicesActivity.n0().f7046b.setVisibility(8);
                userDevicesActivity.n0().f7047c.setVisibility(0);
            } else if (!kotlin.jvm.internal.l.a(mVar, v5.k.f13167a)) {
                androidx.window.layout.c.b();
                return null;
            }
        }
        return s6.w.f12711a;
    }
}
