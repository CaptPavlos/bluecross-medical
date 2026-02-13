package com.inmobi.cmp.presentation.components;

import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import b9.d;
import b9.q;
import b9.s;
import com.inmobi.cmp.ChoiceCmp;
import i9.a;
import j.g;
import java.util.UUID;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.x;
import l9.c;
import r0.f;
import r7.i0;
import r7.v0;
import r7.y;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class CmpActivity extends AppCompatActivity {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2616b = 0;

    /* renamed from: a, reason: collision with root package name */
    public c f2617a;

    public final void i(d dVar, boolean z9) {
        String strD;
        if (z9) {
            strD = null;
        } else {
            c cVar = this.f2617a;
            if (cVar == null) {
                l.i("viewModel");
                throw null;
            }
            strD = f.d(dVar, cVar.f11104a);
        }
        UUID uuid = s.f936a;
        x xVar = new x();
        xVar.f10138a = dVar;
        x xVar2 = new x();
        b9.c cVar2 = b9.c.TCF_CHANGE_OF_CONSENT;
        xVar2.f10138a = cVar2;
        int iOrdinal = dVar.ordinal();
        if (iOrdinal == 0) {
            xVar2.f10138a = b9.c.USP;
        } else if (iOrdinal == 1) {
            if (z9) {
                cVar2 = b9.c.TCF_MANDATORY;
            }
            xVar2.f10138a = cVar2;
        } else if (iOrdinal == 2) {
            xVar2.f10138a = z9 ? b9.c.MSPA_MANDATORY : ((SharedPreferences) a.j().f6781b).getBoolean("MSPAShown", false) ? b9.c.MSPA_CHANGE_OF_CONSENT : b9.c.MSPA_OPT_OUT;
        } else if (iOrdinal == 3) {
            xVar2.f10138a = g.f9878a ? ((SharedPreferences) a.j().f6781b).getBoolean("GBCShown", false) ? b9.c.GBC_CHANGE_OF_CONSENT : b9.c.GBC : b9.c.NR;
        }
        s.f937b.h("startOnPage", xVar.f10138a + "_1");
        s.f936a = UUID.randomUUID();
        if (dVar == d.GDPR) {
            ChoiceCmp.INSTANCE.setCurrentSessionId(s.f936a);
        }
        e eVar = i0.f12407a;
        y.q(v0.f12442a, y7.d.f14116a, null, new q(xVar, xVar2, strD, z9, null), 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00d6  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.presentation.components.CmpActivity.onCreate(android.os.Bundle):void");
    }
}
