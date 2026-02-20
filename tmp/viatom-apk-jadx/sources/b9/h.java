package b9;

import android.app.UiModeManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import c1.d0;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import com.uptodown.R;
import com.uptodown.core.activities.FileExplorerActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final Object f882a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f883b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f884c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f885d;
    public final Object e;
    public final Object f;
    public final Object g;
    public final Object h;

    public h(t3.h hVar, WebView webView, String str, List list, String str2, String str3, t3.c cVar) {
        ArrayList arrayList = new ArrayList();
        this.h = arrayList;
        this.f884c = new HashMap();
        this.f882a = hVar;
        this.f883b = webView;
        this.g = str;
        this.f = cVar;
        if (list != null) {
            arrayList.addAll(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                t3.i iVar = (t3.i) it.next();
                ((HashMap) this.f884c).put(UUID.randomUUID().toString(), iVar);
            }
        }
        this.e = str2;
        this.f885d = str3;
    }

    public static b a(d dVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        d0.i iVarJ = i9.a.j();
        int iOrdinal = dVar.ordinal();
        if (iOrdinal == 0) {
            i10 = 89;
        } else if (iOrdinal == 1) {
            i10 = 81;
        } else if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                androidx.window.layout.c.b();
                return null;
            }
            i10 = 81;
        } else {
            i10 = 86;
        }
        String strT = iVarJ.t(i10);
        if (strT.length() == 0) {
            return null;
        }
        d0.i iVarJ2 = i9.a.j();
        int iOrdinal2 = dVar.ordinal();
        if (iOrdinal2 == 0) {
            i11 = 90;
        } else if (iOrdinal2 == 1) {
            i11 = 82;
        } else if (iOrdinal2 != 2) {
            if (iOrdinal2 != 3) {
                androidx.window.layout.c.b();
                return null;
            }
            i11 = 82;
        } else {
            i11 = 87;
        }
        String strT2 = iVarJ2.t(i11);
        int iOrdinal3 = dVar.ordinal();
        if (iOrdinal3 == 0) {
            i12 = 0;
        } else {
            if (iOrdinal3 != 1) {
                if (iOrdinal3 != 2) {
                    if (iOrdinal3 != 3) {
                        androidx.window.layout.c.b();
                        return null;
                    }
                }
                i12 = 0;
            }
            i12 = 83;
        }
        Boolean boolValueOf = i12 == 0 ? null : Boolean.valueOf(((SharedPreferences) i9.a.j().f6781b).getBoolean(com.mbridge.msdk.dycreator.baseview.a.c(i12), false));
        int iOrdinal4 = dVar.ordinal();
        if (iOrdinal4 == 0) {
            i13 = 0;
        } else {
            if (iOrdinal4 != 1) {
                if (iOrdinal4 != 2) {
                    if (iOrdinal4 != 3) {
                        androidx.window.layout.c.b();
                        return null;
                    }
                }
                i13 = 0;
            }
            i13 = 84;
        }
        Boolean boolValueOf2 = i13 != 0 ? Boolean.valueOf(((SharedPreferences) i9.a.j().f6781b).getBoolean(com.mbridge.msdk.dycreator.baseview.a.c(i13), false)) : null;
        d0.i iVarJ3 = i9.a.j();
        int iOrdinal5 = dVar.ordinal();
        if (iOrdinal5 == 0) {
            i14 = 91;
        } else if (iOrdinal5 == 1) {
            i14 = 85;
        } else if (iOrdinal5 != 2) {
            if (iOrdinal5 != 3) {
                androidx.window.layout.c.b();
                return null;
            }
            i14 = 85;
        } else {
            i14 = 88;
        }
        return new b(strT, strT2, boolValueOf, boolValueOf2, ((SharedPreferences) iVarJ3.f6781b).getBoolean(com.mbridge.msdk.dycreator.baseview.a.c(i14), false));
    }

    public static Object e(h hVar, Boolean bool, String str, String str2, String str3, y6.i iVar, int i10) {
        boolean z9 = (i10 & 64) == 0;
        hVar.getClass();
        d0.i iVar2 = (d0.i) hVar.f;
        ArrayList arrayList = (ArrayList) hVar.h;
        Boolean bool2 = Boolean.TRUE;
        ArrayList arrayList2 = null;
        String strF = kotlin.jvm.internal.l.a(bool, bool2) ? "All" : hVar.f(null);
        String strF2 = kotlin.jvm.internal.l.a(bool, bool2) ? "none" : hVar.f("legitimate");
        String strE = j.g.e();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(arrayList);
        if (j.g.f9878a) {
            arrayList2 = new ArrayList();
            j.g.f9879b.forEach(new j.e(arrayList2, 0));
        }
        k kVar = new k(arrayList3, strF, strF2, str, str2, null, null, str3, null, strE, arrayList2, Boolean.valueOf(z9), 96);
        arrayList.clear();
        iVar2.p(76, strF);
        if (strE == null) {
            strE = "";
        }
        iVar2.p(93, strE);
        return hVar.b(3, kVar, d.GDPR, iVar);
    }

    public static h k(t3.h hVar, String str, List list, String str2, String str3) {
        t1.b(str, "OM SDK JS script content is null");
        t1.b(list, "VerificationScriptResources is null");
        if (str3 == null || str3.length() <= 256) {
            return new h(hVar, (WebView) null, str, list, str2, str3, t3.c.NATIVE);
        }
        com.google.gson.internal.a.n("CustomReferenceData is greater than 256 characters");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(int r5, b9.i r6, b9.d r7, y6.c r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof b9.e
            if (r0 == 0) goto L13
            r0 = r8
            b9.e r0 = (b9.e) r0
            int r1 = r0.f875c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f875c = r1
            goto L18
        L13:
            b9.e r0 = new b9.e
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.f873a
            int r1 = r0.f875c
            java.lang.String r2 = ""
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 != r3) goto L27
            s6.a.e(r8)     // Catch: d6.a -> L82
            goto L73
        L27:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r5)
            r5 = 0
            return r5
        L2e:
            s6.a.e(r8)
            r4.g(r5, r6, r7)
            java.lang.String r5 = "https://api.cmp.inmobi.com/"
            android.net.Uri r5 = android.net.Uri.parse(r5)
            android.net.Uri$Builder r5 = r5.buildUpon()
            java.lang.String r6 = r6.d()
            java.lang.String r7 = "\\"
            r8 = 0
            java.lang.String r6 = o7.u.b0(r6, r7, r2, r8)
            java.lang.String r7 = "log"
            android.net.Uri$Builder r5 = r5.appendQueryParameter(r7, r6)
            android.net.Uri r5 = r5.build()
            java.lang.String r5 = r5.toString()
            r5.getClass()
            java.lang.Object r6 = r4.f884c     // Catch: d6.a -> L82
            y2.c r6 = (y2.c) r6     // Catch: d6.a -> L82
            boolean r6 = r6.v()     // Catch: d6.a -> L82
            if (r6 == 0) goto L76
            java.lang.Object r6 = r4.f885d     // Catch: d6.a -> L82
            c1.d0 r6 = (c1.d0) r6     // Catch: d6.a -> L82
            r0.f875c = r3     // Catch: d6.a -> L82
            java.lang.Object r8 = r6.k(r5, r0)     // Catch: d6.a -> L82
            x6.a r5 = x6.a.f13718a
            if (r8 != r5) goto L73
            return r5
        L73:
            java.lang.String r8 = (java.lang.String) r8     // Catch: d6.a -> L82
            return r8
        L76:
            java.lang.Object r5 = r4.e     // Catch: d6.a -> L82
            com.inmobi.cmp.ChoiceCmpCallback r5 = (com.inmobi.cmp.ChoiceCmpCallback) r5     // Catch: d6.a -> L82
            if (r5 != 0) goto L7d
            goto L82
        L7d:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch: d6.a -> L82
            r5.onCmpError(r6)     // Catch: d6.a -> L82
        L82:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b9.h.b(int, b9.i, b9.d, y6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(int r5, b9.n r6, b9.d r7, y6.c r8) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r8 instanceof b9.f
            if (r0 == 0) goto L13
            r0 = r8
            b9.f r0 = (b9.f) r0
            int r1 = r0.f878c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f878c = r1
            goto L18
        L13:
            b9.f r0 = new b9.f
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.f876a
            int r1 = r0.f878c
            r2 = 1
            if (r1 == 0) goto L2c
            if (r1 != r2) goto L25
            s6.a.e(r8)     // Catch: d6.a -> L66
            goto L66
        L25:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r5)
            r5 = 0
            return r5
        L2c:
            s6.a.e(r8)
            r4.g(r5, r6, r7)
            java.lang.String r5 = "https://visit-server.inmobi-choice.io/visit-event"
            java.lang.Object r7 = r4.f884c     // Catch: d6.a -> L66
            y2.c r7 = (y2.c) r7     // Catch: d6.a -> L66
            boolean r7 = r7.v()     // Catch: d6.a -> L66
            if (r7 == 0) goto L5a
            java.lang.Object r7 = r4.f885d     // Catch: d6.a -> L66
            c1.d0 r7 = (c1.d0) r7     // Catch: d6.a -> L66
            java.lang.String r6 = r6.d()     // Catch: d6.a -> L66
            java.lang.String r8 = "\\"
            java.lang.String r1 = ""
            r3 = 0
            java.lang.String r6 = o7.u.b0(r6, r8, r1, r3)     // Catch: d6.a -> L66
            r0.f878c = r2     // Catch: d6.a -> L66
            java.lang.Object r5 = r7.j(r5, r6, r0)     // Catch: d6.a -> L66
            x6.a r6 = x6.a.f13718a
            if (r5 != r6) goto L66
            return r6
        L5a:
            java.lang.Object r5 = r4.e     // Catch: d6.a -> L66
            com.inmobi.cmp.ChoiceCmpCallback r5 = (com.inmobi.cmp.ChoiceCmpCallback) r5     // Catch: d6.a -> L66
            if (r5 != 0) goto L61
            goto L66
        L61:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch: d6.a -> L66
            r5.onCmpError(r6)     // Catch: d6.a -> L66
        L66:
            s6.w r5 = s6.w.f12711a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b9.h.c(int, b9.n, b9.d, y6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(b9.d r18, b9.c r19, java.lang.String r20, boolean r21, y6.c r22) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r22
            boolean r3 = r2 instanceof b9.g
            if (r3 == 0) goto L19
            r3 = r2
            b9.g r3 = (b9.g) r3
            int r4 = r3.f881c
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.f881c = r4
            goto L1e
        L19:
            b9.g r3 = new b9.g
            r3.<init>(r0, r2)
        L1e:
            java.lang.Object r2 = r3.f879a
            int r4 = r3.f881c
            r5 = 1
            if (r4 == 0) goto L33
            if (r4 != r5) goto L2c
            s6.a.e(r2)
            goto Lbb
        L2c:
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r1)
            r1 = 0
            return r1
        L33:
            s6.a.e(r2)
            r2 = 0
            if (r21 == 0) goto L3f
            b9.b r4 = a(r1)
            r13 = r4
            goto L40
        L3f:
            r13 = r2
        L40:
            b9.b r12 = new b9.b
            o8.i r4 = i9.a.h()
            o8.c r4 = r4.f11814b
            java.lang.String r4 = r4.U
            if (r4 != 0) goto L4e
            java.lang.String r4 = ""
        L4e:
            r7 = r4
            d0.i r4 = i9.a.j()
            r6 = 33
            java.lang.String r8 = r4.t(r6)
            r1.getClass()
            b9.d r4 = b9.d.GDPR
            if (r1 != r4) goto L6a
            boolean r6 = r0.f.t()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r9 = r6
            goto L6b
        L6a:
            r9 = r2
        L6b:
            if (r1 != r4) goto L77
            boolean r4 = r0.f.l()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r10 = r4
            goto L78
        L77:
            r10 = r2
        L78:
            boolean r11 = j.g.f9878a
            r6 = r12
            r6.<init>(r7, r8, r9, r10, r11)
            java.lang.Object r4 = r0.f883b
            o8.c r4 = (o8.c) r4
            if (r4 != 0) goto L85
            goto Lbf
        L85:
            java.lang.String r7 = r4.f11778a
            java.lang.String r8 = r4.g
            java.lang.Object r6 = r0.f882a
            f6.m r6 = (f6.m) r6
            int r9 = r6.f8105m
            r6 = r19
            java.lang.String r10 = r6.f868a
            java.lang.String r11 = r4.e
            if (r21 == 0) goto L9c
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r16 = r4
            goto L9e
        L9c:
            r16 = r2
        L9e:
            if (r21 == 0) goto La8
            java.lang.Object r2 = r0.f
            d0.i r2 = (d0.i) r2
            java.lang.String r2 = j.g.c(r2)
        La8:
            r15 = r2
            b9.j r6 = new b9.j
            r14 = r20
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r3.f881c = r5
            java.lang.Object r2 = r0.b(r5, r6, r1, r3)
            x6.a r1 = x6.a.f13718a
            if (r2 != r1) goto Lbb
            return r1
        Lbb:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto Lc2
        Lbf:
            java.lang.String r1 = "Error sending init log: CMP configuration have not been initialized yet"
            return r1
        Lc2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b9.h.d(b9.d, b9.c, java.lang.String, boolean, y6.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String f(String str) {
        ArrayList arrayList;
        LinkedHashMap linkedHashMap;
        boolean zA = kotlin.jvm.internal.l.a(str, "legitimate");
        f6.m mVar = (f6.m) this.f882a;
        int i10 = 0;
        int i11 = 1;
        if (zA) {
            List listQ = t6.m.Q(mVar.D.getMap().values(), mVar.C.getMap().values(), mVar.f8111s.getMap().values());
            arrayList = new ArrayList();
            Iterator it = listQ.iterator();
            while (it.hasNext()) {
                t6.r.X((Iterable) it.next(), arrayList);
            }
        } else {
            Collection<Boolean> collectionValues = mVar.f8110r.getMap().values();
            Vector vector = new Vector(null, i11, 0 == true ? 1 : 0);
            for (Map.Entry<Integer, Boolean> entry : mVar.f8116z.getMap().entrySet()) {
                k8.c cVar = mVar.f8097a;
                k8.h hVar = (cVar == null || (linkedHashMap = cVar.h) == null) ? null : (k8.h) linkedHashMap.get(String.valueOf(entry.getKey().intValue()));
                if (hVar != null && f6.m.c(hVar)) {
                    vector.getMap().put(entry.getKey(), entry.getValue());
                }
            }
            List listQ2 = t6.m.Q(collectionValues, vector.getMap().values(), mVar.A.getMap().values());
            arrayList = new ArrayList();
            Iterator it2 = listQ2.iterator();
            while (it2.hasNext()) {
                t6.r.X((Iterable) it2.next(), arrayList);
            }
        }
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            int i12 = 0;
            while (i12 < size) {
                Object obj = arrayList.get(i12);
                i12++;
                if (!((Boolean) obj).booleanValue()) {
                    if (!arrayList.isEmpty()) {
                        int size2 = arrayList.size();
                        while (i10 < size2) {
                            Object obj2 = arrayList.get(i10);
                            i10++;
                            if (((Boolean) obj2).booleanValue()) {
                                return "Partial";
                            }
                        }
                    }
                    return zA ? "all" : "Reject";
                }
            }
        }
        return zA ? "none" : "All";
    }

    public void g(int i10, i iVar, d dVar) {
        iVar.b(Calendar.getInstance().getTimeInMillis());
        if (i10 == 0) {
            throw null;
        }
        iVar.f887b = i10;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.f872a);
        sb.append('-');
        String string = s.f936a.toString();
        string.getClass();
        sb.append(string);
        iVar.f888c = sb.toString();
        String str = (String) this.g;
        str.getClass();
        iVar.f889d = str;
        String str2 = i9.a.f9114n;
        str2.getClass();
        iVar.e = str2;
        Context applicationContext = i9.a.b().getApplicationContext();
        applicationContext.getClass();
        Object systemService = applicationContext.getSystemService("uimode");
        if (systemService == null) {
            androidx.window.layout.c.k("null cannot be cast to non-null type android.app.UiModeManager");
            return;
        }
        UiModeManager uiModeManager = (UiModeManager) systemService;
        iVar.f = uiModeManager.getCurrentModeType() == 4 ? "TV" : uiModeManager.getCurrentModeType() == 3 ? "automotive" : applicationContext.getPackageManager().hasSystemFeature("android.hardware.type.watch") ? "wearable" : (applicationContext.getResources().getConfiguration().screenLayout & 15) >= 3 ? "tablet" : "mobile";
        o8.c cVar = (o8.c) this.f883b;
        iVar.g = cVar != null ? cVar.T : null;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return (LinearLayout) this.f882a;
    }

    public void h(String str, String str2) {
        str.getClass();
        str2.getClass();
        ((ArrayList) this.h).add(new a(Calendar.getInstance().getTimeInMillis(), str + ':' + str2));
    }

    public void i(String str) {
        ((TextView) this.f).setText(str);
        ((RelativeLayout) this.g).setVisibility(8);
        ((TextView) this.e).setVisibility(8);
        ((TextView) this.h).setText(((FileExplorerActivity) this.f885d).getString(R.string.close));
    }

    public void j(String str) {
        str.getClass();
        EditText editText = (EditText) this.f884c;
        editText.setFocusable(false);
        editText.setFocusableInTouchMode(false);
        editText.clearFocus();
        ((ProgressBar) this.f882a).setVisibility(0);
        TextView textView = (TextView) this.f883b;
        textView.setVisibility(0);
        textView.setText(((FileExplorerActivity) this.f885d).getString(R.string.core_start_counting_value, str));
        ((TextView) this.e).setVisibility(8);
    }

    public /* synthetic */ h(View view, TextView textView, EditText editText, KeyEvent.Callback callback, TextView textView2, TextView textView3, View view2, TextView textView4) {
        this.f882a = view;
        this.f883b = textView;
        this.f884c = editText;
        this.f885d = callback;
        this.e = textView2;
        this.f = textView3;
        this.g = view2;
        this.h = textView4;
    }

    public h(f6.m mVar, o8.c cVar, y2.c cVar2, d0 d0Var, ChoiceCmpCallback choiceCmpCallback, d0.i iVar, String str) {
        str.getClass();
        this.f882a = mVar;
        this.f883b = cVar;
        this.f884c = cVar2;
        this.f885d = d0Var;
        this.e = choiceCmpCallback;
        this.f = iVar;
        this.g = str;
        this.h = new ArrayList();
    }
}
