package c1;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1546a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d5 f1547b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d2 f1548c;

    public /* synthetic */ w1(d2 d2Var, d5 d5Var, int i10) {
        this.f1546a = i10;
        this.f1547b = d5Var;
        this.f1548c = d2Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f1546a) {
            case 0:
                d2 d2Var = this.f1548c;
                d2Var.f1108a.B();
                d2Var.f1108a.Y(this.f1547b);
                break;
            case 1:
                d2 d2Var2 = this.f1548c;
                d2Var2.f1108a.B();
                v4 v4Var = d2Var2.f1108a;
                v4Var.b().g();
                v4Var.l0();
                d5 d5Var = this.f1547b;
                i0.y.g(d5Var);
                String str = d5Var.f1114a;
                i0.y.d(str);
                int i10 = 0;
                if (v4Var.e0().q(null, f0.A0)) {
                    v4Var.f().getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int iO = v4Var.e0().o(null, f0.f1177j0);
                    v4Var.e0();
                    long jLongValue = jCurrentTimeMillis - ((Long) f0.e.a(null)).longValue();
                    while (i10 < iO && v4Var.I(jLongValue, null)) {
                        i10++;
                    }
                } else {
                    v4Var.e0();
                    long jIntValue = ((Integer) f0.f1182l.a(null)).intValue();
                    while (i10 < jIntValue && v4Var.I(0L, str)) {
                        i10++;
                    }
                }
                if (v4Var.e0().q(null, f0.B0)) {
                    v4Var.b().g();
                    v4Var.H();
                }
                s4 s4Var = v4Var.f1523j;
                int iJ = androidx.constraintlayout.core.widgets.analyzer.a.j(d5Var.E);
                s4Var.g();
                if (iJ == 2 && !s4.j(str)) {
                    n1 n1Var = s4Var.f1335b.f1518a;
                    v4.U(n1Var);
                    com.google.android.gms.internal.measurement.g2 g2VarS = n1Var.s(str);
                    if (g2VarS != null && g2VarS.D() && !g2VarS.E().q().isEmpty()) {
                        v4Var.a().f1545n.c(str, "[sgtm] Going background, trigger client side upload. appId");
                        v4Var.f().getClass();
                        v4Var.r(System.currentTimeMillis(), str);
                        break;
                    }
                }
                break;
            case 2:
                d2 d2Var3 = this.f1548c;
                d2Var3.f1108a.B();
                v4 v4Var2 = d2Var3.f1108a;
                v4Var2.b().g();
                v4Var2.l0();
                d5 d5Var2 = this.f1547b;
                i0.y.d(d5Var2.f1114a);
                v4Var2.c0(d5Var2);
                break;
            case 3:
                d2 d2Var4 = this.f1548c;
                d2Var4.f1108a.B();
                v4 v4Var3 = d2Var4.f1108a;
                if (v4Var3.y != null) {
                    ArrayList arrayList = new ArrayList();
                    v4Var3.f1537z = arrayList;
                    arrayList.addAll(v4Var3.y);
                }
                n nVar = v4Var3.f1520c;
                v4.U(nVar);
                u1 u1Var = nVar.f1149a;
                d5 d5Var3 = this.f1547b;
                String str2 = d5Var3.f1114a;
                i0.y.g(str2);
                i0.y.d(str2);
                nVar.g();
                nVar.h();
                try {
                    SQLiteDatabase sQLiteDatabaseV = nVar.V();
                    String[] strArr = {str2};
                    int iDelete = sQLiteDatabaseV.delete("apps", "app_id=?", strArr) + sQLiteDatabaseV.delete("events", "app_id=?", strArr) + sQLiteDatabaseV.delete("events_snapshot", "app_id=?", strArr) + sQLiteDatabaseV.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseV.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseV.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseV.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseV.delete("queue", "app_id=?", strArr) + sQLiteDatabaseV.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseV.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseV.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseV.delete("trigger_uris", "app_id=?", strArr) + sQLiteDatabaseV.delete("upload_queue", "app_id=?", strArr);
                    if (u1Var.f1478d.q(null, f0.f1175i1)) {
                        iDelete += sQLiteDatabaseV.delete("no_data_mode_events", "app_id=?", strArr);
                    }
                    if (iDelete > 0) {
                        w0 w0Var = u1Var.f;
                        u1.m(w0Var);
                        w0Var.f1545n.d(str2, "Reset analytics data. app, records", Integer.valueOf(iDelete));
                    }
                } catch (SQLiteException e) {
                    w0 w0Var2 = u1Var.f;
                    u1.m(w0Var2);
                    w0Var2.f.d(w0.o(str2), "Error resetting analytics data. appId, error", e);
                }
                if (d5Var3.h) {
                    v4Var3.Y(d5Var3);
                    break;
                }
                break;
            case 4:
                d2 d2Var5 = this.f1548c;
                d2Var5.f1108a.B();
                v4 v4Var4 = d2Var5.f1108a;
                v4Var4.b().g();
                v4Var4.l0();
                d5 d5Var4 = this.f1547b;
                i0.y.d(d5Var4.f1114a);
                v4Var4.m0(d5Var4);
                v4Var4.n0(d5Var4);
                break;
            case 5:
                v4 v4Var5 = this.f1548c.f1108a;
                v4Var5.B();
                v4Var5.n0(this.f1547b);
                break;
            default:
                v4 v4Var6 = this.f1548c.f1108a;
                v4Var6.B();
                v4Var6.m0(this.f1547b);
                break;
        }
    }
}
