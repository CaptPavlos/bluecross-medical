package o1;

import c1.l2;
import com.google.android.gms.internal.measurement.l5;
import com.mbridge.msdk.MBridgeConstans;
import j1.d;
import j1.g;
import j1.i;
import java.util.Arrays;
import r0.f;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final g f11666a;

    /* renamed from: b, reason: collision with root package name */
    public static final i f11667b;

    /* renamed from: c, reason: collision with root package name */
    public static final i f11668c;

    /* renamed from: d, reason: collision with root package name */
    public static final i f11669d;

    static {
        int i10 = g.f9893c;
        Object[] objArr = new Object[15];
        objArr[0] = "_in";
        objArr[1] = "_xa";
        objArr[2] = "_xu";
        objArr[3] = "_aq";
        objArr[4] = "_aa";
        objArr[5] = "_ai";
        System.arraycopy(new String[]{"_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"}, 0, objArr, 6, 9);
        f11666a = g.i(15, objArr);
        j1.b bVar = d.f9886b;
        Object[] objArr2 = {"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd"};
        t1.j(7, objArr2);
        f11667b = d.g(7, objArr2);
        Object[] objArr3 = {"auto", MBridgeConstans.DYNAMIC_VIEW_WX_APP, "am"};
        t1.j(3, objArr3);
        f11668c = d.g(3, objArr3);
        Object[] objArr4 = {"_r", "_dbg"};
        t1.j(2, objArr4);
        f11669d = d.g(2, objArr4);
        l5.j(4, "initialCapacity");
        String[] strArr = l2.f1321i;
        t1.j(15, strArr);
        Object[] objArrCopyOf = Arrays.copyOf(new Object[4], f.v(4, 15));
        System.arraycopy(strArr, 0, objArrCopyOf, 0, 15);
        String[] strArr2 = l2.f1322j;
        t1.j(15, strArr2);
        if (objArrCopyOf.length < 30) {
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, f.v(objArrCopyOf.length, 30));
        }
        System.arraycopy(strArr2, 0, objArrCopyOf, 15, 15);
        d.g(30, objArrCopyOf);
        Object[] objArr5 = {"^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$"};
        t1.j(2, objArr5);
        d.g(2, objArr5);
    }
}
