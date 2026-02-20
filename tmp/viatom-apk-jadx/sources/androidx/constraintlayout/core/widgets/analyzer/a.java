package androidx.constraintlayout.core.widgets.analyzer;

import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import android.widget.EditText;
import androidx.core.provider.b;
import androidx.core.util.Predicate;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.SavedStateReaderKt;
import androidx.sqlite.SQLite;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.model.WorkTagDao;
import com.google.android.gms.internal.measurement.a4;
import com.google.android.gms.internal.measurement.d5;
import com.google.android.gms.internal.measurement.h;
import com.google.android.gms.internal.measurement.j;
import com.google.android.gms.internal.measurement.n;
import com.google.android.gms.internal.measurement.q;
import com.google.android.gms.internal.measurement.t;
import com.google.android.gms.internal.measurement.u6;
import com.google.android.material.datepicker.c;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.foundation.tools.af;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import w2.r;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static ArrayList A(Object obj) {
        s6.a.e(obj);
        return new ArrayList();
    }

    public static void B(int i10, String str, String str2) {
        Log.w(str2, str + i10);
    }

    public static /* synthetic */ void C(AutoCloseable autoCloseable) throws Exception {
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (autoCloseable instanceof ExecutorService) {
            b.e((ExecutorService) autoCloseable);
            return;
        }
        if (autoCloseable instanceof TypedArray) {
            ((TypedArray) autoCloseable).recycle();
            return;
        }
        if (autoCloseable instanceof MediaMetadataRetriever) {
            ((MediaMetadataRetriever) autoCloseable).release();
            return;
        }
        if (autoCloseable instanceof MediaDrm) {
            ((MediaDrm) autoCloseable).release();
            return;
        }
        if (autoCloseable instanceof DrmManagerClient) {
            ((DrmManagerClient) autoCloseable).release();
        } else if (autoCloseable instanceof ContentProviderClient) {
            ((ContentProviderClient) autoCloseable).release();
        } else {
            f.a();
        }
    }

    public static void D(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        af.b(str, sb.toString());
    }

    public static void E(String str, String str2, String str3) {
        af.a(str3, str + str2);
    }

    public static /* synthetic */ String F(int i10) {
        switch (i10) {
            case 1:
                return "CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN";
            case 2:
                return "CLIENT_UPLOAD_ELIGIBLE";
            case 3:
                return "MEASUREMENT_SERVICE_NOT_ENABLED";
            case 4:
                return "ANDROID_TOO_OLD";
            case 5:
                return "NON_PLAY_MODE";
            case 6:
                return "SDK_TOO_OLD";
            case 7:
                return "MISSING_JOB_SCHEDULER";
            case 8:
                return "NOT_ENABLED_IN_MANIFEST";
            case 9:
                return "CLIENT_FLAG_OFF";
            case 10:
                return "SERVICE_FLAG_OFF";
            case 11:
                return "PINNED_TO_SERVICE_UPLOAD";
            case 12:
                return "MISSING_SGTM_SERVER_URL";
            default:
                throw null;
        }
    }

    public static void G(EditText... editTextArr) {
        if (editTextArr.length == 0) {
            return;
        }
        c cVar = new c(editTextArr, 0);
        for (EditText editText : editTextArr) {
            editText.setOnFocusChangeListener(cVar);
        }
        EditText editText2 = editTextArr[0];
        editText2.postDelayed(new com.google.android.material.bottomappbar.a(editText2, 1), 100L);
    }

    public static /* synthetic */ String H(int i10) {
        switch (i10) {
            case 1:
                return "GO_TO_PAGE";
            case 2:
                return "PURPOSE";
            case 3:
                return "SPECIAL_FEATURE";
            case 4:
                return "PARTIAL_CONSENT";
            case 5:
                return "SAVE_AND_EXIT";
            case 6:
                return "ACCEPT_ALL";
            case 7:
                return "REJECT_ALL";
            case 8:
                return "ACCEPT_ALL_LEGITIMATE";
            case 9:
                return "OBJECT_ALL_LEGITIMATE";
            case 10:
                return "START_ON_PAGE";
            case 11:
                return "EXPAND_ELEMENT";
            case 12:
                return "COLLAPSE_ELEMENT";
            case 13:
                return "ACTION1";
            case 14:
                return "ACTION2";
            case 15:
                return "CONFIRM";
            default:
                return "null";
        }
    }

    public static n I(j jVar, q qVar, r rVar, ArrayList arrayList) {
        String str = qVar.f2137a;
        if (jVar.h(str)) {
            n nVarC = jVar.c(str);
            if (nVarC instanceof h) {
                return ((h) nVarC).a(rVar, arrayList);
            }
            com.google.gson.internal.a.n(a3.a.C(str, " is not a function"));
            return null;
        }
        if ("hasOwnProperty".equals(str)) {
            a.a.T(arrayList, "hasOwnProperty", 1);
            return jVar.h(((t) rVar.f13463c).c(rVar, (n) arrayList.get(0)).f()) ? n.f2096f0 : n.f2097g0;
        }
        com.google.gson.internal.a.n(a3.a.i("Object has no function ", str));
        return null;
    }

    public static androidx.core.util.a a(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new androidx.core.util.a(predicate, predicate2, 1);
    }

    public static ViewModel b(ViewModelProvider.Factory factory, Class cls, CreationExtras creationExtras) {
        cls.getClass();
        creationExtras.getClass();
        return factory.create(cls);
    }

    public static ViewModel c(ViewModelProvider.Factory factory, m7.c cVar, CreationExtras creationExtras) {
        cVar.getClass();
        creationExtras.getClass();
        return factory.create(a4.q(cVar), creationExtras);
    }

    public static void d(WorkTagDao workTagDao, String str, Set set) {
        str.getClass();
        set.getClass();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            workTagDao.insert(new WorkTag((String) it.next(), str));
        }
    }

    public static androidx.core.util.a e(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new androidx.core.util.a(predicate, predicate2, 0);
    }

    public static Number f(int i10, i3.a aVar) {
        if (i10 == 1) {
            return Double.valueOf(aVar.o());
        }
        if (i10 == 2) {
            return new com.google.gson.internal.h(aVar.v());
        }
        if (i10 == 3) {
            String strV = aVar.v();
            if (strV.indexOf(46) >= 0) {
                return g(strV, aVar);
            }
            try {
                return Long.valueOf(Long.parseLong(strV));
            } catch (NumberFormatException unused) {
                return g(strV, aVar);
            }
        }
        String strV2 = aVar.v();
        try {
            return com.google.gson.internal.f.i(strV2);
        } catch (NumberFormatException e) {
            StringBuilder sbY = a3.a.y("Cannot parse ", strV2, "; at path ");
            sbY.append(aVar.j(true));
            throw new u6(sbY.toString(), e);
        }
    }

    public static Double g(String str, i3.a aVar) throws NumberFormatException, i3.c {
        try {
            Double dValueOf = Double.valueOf(str);
            if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                if (aVar.f8979o != 1) {
                    throw new i3.c("JSON forbids NaN and infinities: " + dValueOf + "; at path " + aVar.j(true));
                }
            }
            return dValueOf;
        } catch (NumberFormatException e) {
            StringBuilder sbY = a3.a.y("Cannot parse ", str, "; at path ");
            sbY.append(aVar.j(true));
            throw new u6(sbY.toString(), e);
        }
    }

    public static String h(String str, char c10) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c10);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String i(String str) {
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            char cCharAt = str.charAt(i10);
            if (!Character.isLetter(cCharAt)) {
                i10++;
            } else if (!Character.isUpperCase(cCharAt)) {
                char upperCase = Character.toUpperCase(cCharAt);
                if (i10 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i10) + upperCase + str.substring(i10 + 1);
            }
        }
        return str;
    }

    public static int j(int i10) {
        switch (i10) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            default:
                switch (i10) {
                    case 20:
                        return 10;
                    case 21:
                        return 11;
                    case 22:
                        return 12;
                    default:
                        return 0;
                }
        }
    }

    public static /* synthetic */ String k(int i10) {
        if (i10 == 1) {
            return "All";
        }
        if (i10 == 2) {
            return "Partial";
        }
        if (i10 == 3) {
            return "Reject";
        }
        if (i10 == 4) {
            return "NA";
        }
        throw null;
    }

    public static /* synthetic */ int l(int i10) {
        switch (i10) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
                return 8;
            case 10:
                return 20;
            case 11:
                return 21;
            case 12:
                return 22;
            default:
                throw null;
        }
    }

    public static int m(int i10, int i11, int i12) {
        return d5.s(i10) + i11 + i12;
    }

    public static int n(int i10, int i11, int i12, int i13) {
        return d5.s(i10) + i11 + i12 + i13;
    }

    public static int o(int i10, int i11, String str) {
        return (str.hashCode() + i10) * i11;
    }

    public static u6 p(int i10, String str) {
        SQLite.throwSQLiteException(i10, str);
        return new u6();
    }

    public static u6 q(Object obj) {
        s6.a.e(obj);
        return new u6();
    }

    public static u6 r(String str) {
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        return new u6();
    }

    public static g s(com.mbridge.msdk.c.h hVar) {
        return hVar.b(com.mbridge.msdk.foundation.controller.c.m().k());
    }

    public static Object t(ArrayList arrayList, int i10) {
        return arrayList.get(arrayList.size() - i10);
    }

    public static String u(int i10, int i11, String str, String str2) {
        return str + i10 + str2 + i11;
    }

    public static String v(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String w(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String x(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String y(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static String z(StringBuilder sb, boolean z9, char c10) {
        sb.append(z9);
        sb.append(c10);
        return sb.toString();
    }
}
