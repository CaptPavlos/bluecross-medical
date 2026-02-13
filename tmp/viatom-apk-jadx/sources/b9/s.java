package b9;

import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.UUID;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static UUID f936a = UUID.randomUUID();

    /* renamed from: b, reason: collision with root package name */
    public static final h f937b = i9.a.l();

    static {
        new LinkedHashMap();
        new LinkedHashMap();
    }

    public static LiveData a(int i10) {
        String strH;
        Boolean bool;
        if (i10 == 0) {
            throw null;
        }
        int iC = c.i.c(i10);
        if (iC == 4) {
            strH = androidx.constraintlayout.core.widgets.analyzer.a.H(5);
            bool = null;
        } else if (iC == 5) {
            bool = Boolean.TRUE;
            strH = androidx.constraintlayout.core.widgets.analyzer.a.H(6);
        } else if (iC != 6) {
            bool = Boolean.FALSE;
            strH = androidx.constraintlayout.core.widgets.analyzer.a.H(4);
        } else {
            bool = Boolean.FALSE;
            strH = androidx.constraintlayout.core.widgets.analyzer.a.H(7);
        }
        String strT = i9.a.j().t(8);
        String strT2 = i9.a.j().t(63);
        f937b.h(strH, CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        return CoroutineLiveDataKt.liveData$default((w6.h) null, 0L, new a6.q(strT, strT2, bool, (w6.c) null), 3, (Object) null);
    }

    public static LiveData b(int i10, int i11) {
        int i12;
        if (i10 == 0 || i11 == 0) {
            throw null;
        }
        int iC = c.i.c(i10);
        String strH = iC != 4 ? iC != 5 ? iC != 6 ? androidx.constraintlayout.core.widgets.analyzer.a.H(4) : androidx.constraintlayout.core.widgets.analyzer.a.H(7) : androidx.constraintlayout.core.widgets.analyzer.a.H(6) : androidx.constraintlayout.core.widgets.analyzer.a.H(5);
        int iC2 = c.i.c(i11);
        if (iC2 != 0) {
            i12 = 2;
            if (iC2 != 2) {
                i12 = 3;
            }
        } else {
            i12 = 1;
        }
        f937b.h(strH, CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        return CoroutineLiveDataKt.liveData$default((w6.h) null, 0L, new o(i9.a.j().t(69), i11, i12, null), 3, (Object) null);
    }

    public static Object c(d dVar, int i10, y6.i iVar) {
        Object objB;
        String strValueOf = String.valueOf(i10);
        h hVar = f937b;
        hVar.h("goToPage", strValueOf);
        ArrayList arrayList = (ArrayList) hVar.h;
        if (arrayList.size() < 2) {
            objB = "";
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList);
            l lVar = new l(arrayList2);
            arrayList.clear();
            objB = hVar.b(2, lVar, dVar, iVar);
        }
        return objB == x6.a.f13718a ? objB : w.f12711a;
    }

    public static LiveData d(int i10) {
        String str;
        w6.c cVar = null;
        if (i10 == 0) {
            throw null;
        }
        switch (i10) {
            case 1:
                str = "goToPage";
                break;
            case 2:
                str = "purpose";
                break;
            case 3:
                str = "specialFeature";
                break;
            case 4:
                str = "partial";
                break;
            case 5:
                str = "saveAndExit";
                break;
            case 6:
                str = "acceptAll";
                break;
            case 7:
                str = "rejectAll";
                break;
            case 8:
                str = "acceptAllLegitimate";
                break;
            case 9:
                str = "objectAllLegitimate";
                break;
            case 10:
                str = "startOnPage";
                break;
            case 11:
                str = "expandElement";
                break;
            case 12:
                str = "collapseElement";
                break;
            case 13:
                str = "Action1";
                break;
            case 14:
                str = "Action2";
                break;
            case 15:
                str = "Confirm";
                break;
            default:
                throw null;
        }
        f937b.h(str, CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        return CoroutineLiveDataKt.liveData$default((w6.h) null, 0L, new a6.c(2, cVar), 3, (Object) null);
    }
}
