package a3;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import j$.util.DesugarCollections;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import l4.p2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z0 implements c3.b, ViewBinding, q1.b, r.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f195a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f196b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f197c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f198d;
    public final Object e;
    public final Object f;

    public z0(q1.a aVar, q1.b bVar) {
        this.f195a = 10;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        Set<q1.i> set = aVar.f12221c;
        Set set2 = aVar.g;
        for (q1.i iVar : set) {
            int i10 = iVar.f12237c;
            int i11 = iVar.f12236b;
            boolean z9 = i10 == 0;
            q1.q qVar = iVar.f12235a;
            if (z9) {
                if (i11 == 2) {
                    hashSet4.add(qVar);
                } else {
                    hashSet.add(qVar);
                }
            } else if (i10 == 2) {
                hashSet3.add(qVar);
            } else if (i11 == 2) {
                hashSet5.add(qVar);
            } else {
                hashSet2.add(qVar);
            }
        }
        if (!set2.isEmpty()) {
            hashSet.add(q1.q.a(n2.b.class));
        }
        this.f = DesugarCollections.unmodifiableSet(hashSet);
        this.f196b = DesugarCollections.unmodifiableSet(hashSet2);
        this.f197c = DesugarCollections.unmodifiableSet(hashSet3);
        this.f198d = DesugarCollections.unmodifiableSet(hashSet4);
        DesugarCollections.unmodifiableSet(hashSet5);
        this.e = bVar;
    }

    public static z0 i(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        z0 z0Var = new z0(sharedPreferences, scheduledThreadPoolExecutor);
        synchronized (((ArrayDeque) z0Var.f198d)) {
            try {
                ((ArrayDeque) z0Var.f198d).clear();
                String string = ((SharedPreferences) z0Var.f).getString((String) z0Var.f196b, "");
                if (!TextUtils.isEmpty(string) && string.contains((String) z0Var.f197c)) {
                    String[] strArrSplit = string.split((String) z0Var.f197c, -1);
                    if (strArrSplit.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str : strArrSplit) {
                        if (!TextUtils.isEmpty(str)) {
                            ((ArrayDeque) z0Var.f198d).add(str);
                        }
                    }
                    return z0Var;
                }
                return z0Var;
            } finally {
            }
        }
    }

    public static z0 k(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_generic_accept_cancel, (ViewGroup) null, false);
        int i10 = R.id.cb_dont_show_again;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(viewInflate, R.id.cb_dont_show_again);
        if (checkBox != null) {
            i10 = R.id.tv_cancel;
            TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_cancel);
            if (textView != null) {
                i10 = R.id.tv_msg;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_msg);
                if (textView2 != null) {
                    i10 = R.id.tv_ok;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_ok);
                    if (textView3 != null) {
                        return new z0((LinearLayout) viewInflate, checkBox, textView, textView2, textView3, 2);
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i10)));
        return null;
    }

    @Override // q1.b
    public Object a(Class cls) {
        if (!((Set) this.f).contains(q1.q.a(cls))) {
            p8.u.j(cls, "Attempting to request an undeclared dependency ", ".");
            return null;
        }
        Object objA = ((q1.b) this.e).a(cls);
        if (!cls.equals(n2.b.class)) {
            return objA;
        }
        return new q1.r();
    }

    @Override // q1.b
    public q1.o b(q1.q qVar) {
        if (((Set) this.f197c).contains(qVar)) {
            return ((q1.b) this.e).b(qVar);
        }
        p8.u.j(qVar, "Attempting to request an undeclared dependency Deferred<", ">.");
        return null;
    }

    @Override // q1.b
    public q2.b c(Class cls) {
        return d(q1.q.a(cls));
    }

    @Override // q1.b
    public q2.b d(q1.q qVar) {
        if (((Set) this.f196b).contains(qVar)) {
            return ((q1.b) this.e).d(qVar);
        }
        p8.u.j(qVar, "Attempting to request an undeclared dependency Provider<", ">.");
        return null;
    }

    @Override // q1.b
    public Set e(q1.q qVar) {
        if (((Set) this.f198d).contains(qVar)) {
            return ((q1.b) this.e).e(qVar);
        }
        p8.u.j(qVar, "Attempting to request an undeclared dependency Set<", ">.");
        return null;
    }

    @Override // q1.b
    public Object f(q1.q qVar) {
        if (((Set) this.f).contains(qVar)) {
            return ((q1.b) this.e).f(qVar);
        }
        p8.u.j(qVar, "Attempting to request an undeclared dependency ", ".");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(y6.c r7) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.z0.g(y6.c):java.lang.Object");
    }

    @Override // p6.a
    public Object get() {
        switch (this.f195a) {
            case 0:
                return new y0((l1.g) ((d0.i) this.f).f6781b, (r2.d) ((p6.a) this.f196b).get(), (d3.j) ((p6.a) this.f197c).get(), (m) ((c3.c) this.e).get(), (w6.h) ((p6.a) this.f198d).get());
            case 1:
                return new d3.c((o1) ((p6.a) this.f196b).get(), (r2.d) ((p6.a) this.f197c).get(), (c) ((p6.a) this.f198d).get(), (d3.d) ((p6.a) this.f).get(), (d3.n) ((c3.c) this.e).get());
            default:
                return new u.a((Executor) ((p6.a) this.f196b).get(), (q.d) ((p6.a) this.f197c).get(), (p2) ((p2) this.f).get(), (w.d) ((p6.a) this.f198d).get(), (x.c) ((p6.a) this.e).get());
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        switch (this.f195a) {
        }
        return (RelativeLayout) this.f;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object h(y6.c r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof f9.a
            if (r0 == 0) goto L13
            r0 = r5
            f9.a r0 = (f9.a) r0
            int r1 = r0.f8126c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8126c = r1
            goto L18
        L13:
            f9.a r0 = new f9.a
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f8124a
            int r1 = r0.f8126c
            r2 = 1
            if (r1 == 0) goto L2c
            if (r1 != r2) goto L25
            s6.a.e(r5)     // Catch: d6.a -> L71
            goto L60
        L25:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r5)
            r5 = 0
            return r5
        L2c:
            s6.a.e(r5)
            java.lang.Object r5 = r4.f     // Catch: d6.a -> L71
            y2.c r5 = (y2.c) r5     // Catch: d6.a -> L71
            boolean r5 = r5.v()     // Catch: d6.a -> L71
            if (r5 == 0) goto L63
            java.lang.Object r5 = r4.f198d     // Catch: d6.a -> L71
            a3.x r5 = (a3.x) r5     // Catch: d6.a -> L71
            java.lang.Object r1 = r4.f196b     // Catch: d6.a -> L71
            d0.i r1 = (d0.i) r1     // Catch: d6.a -> L71
            r3 = 21
            java.lang.String r1 = r1.t(r3)     // Catch: d6.a -> L71
            java.lang.Object r5 = r5.g(r1)     // Catch: d6.a -> L71
            o8.i r5 = (o8.i) r5     // Catch: d6.a -> L71
            java.lang.Object r1 = r4.f197c     // Catch: d6.a -> L71
            c1.d0 r1 = (c1.d0) r1     // Catch: d6.a -> L71
            o8.c r5 = r5.f11814b     // Catch: d6.a -> L71
            java.lang.String r5 = r5.f11791r     // Catch: d6.a -> L71
            r0.f8126c = r2     // Catch: d6.a -> L71
            java.lang.Object r5 = r1.m(r5, r0)     // Catch: d6.a -> L71
            x6.a r0 = x6.a.f13718a
            if (r5 != r0) goto L60
            return r0
        L60:
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5     // Catch: d6.a -> L71
            return r5
        L63:
            com.inmobi.cmp.ChoiceCmp r5 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch: d6.a -> L71
            com.inmobi.cmp.ChoiceCmpCallback r5 = r5.getCallback()     // Catch: d6.a -> L71
            if (r5 != 0) goto L6c
            goto L71
        L6c:
            com.inmobi.cmp.model.ChoiceError r0 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch: d6.a -> L71
            r5.onCmpError(r0)     // Catch: d6.a -> L71
        L71:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.z0.h(y6.c):java.lang.Object");
    }

    public q1.o j(Class cls) {
        return b(q1.q.a(cls));
    }

    public String l() {
        String str;
        synchronized (((ArrayDeque) this.f198d)) {
            str = (String) ((ArrayDeque) this.f198d).peek();
        }
        return str;
    }

    public boolean m(Object obj) {
        boolean zRemove;
        synchronized (((ArrayDeque) this.f198d)) {
            zRemove = ((ArrayDeque) this.f198d).remove(obj);
            if (zRemove) {
                ((ScheduledThreadPoolExecutor) this.e).execute(new androidx.constraintlayout.helper.widget.a(this, 13));
            }
        }
        return zRemove;
    }

    public void n(m.a aVar, m.g gVar) {
        p.p pVar = (p.p) this.e;
        p.i iVar = (p.i) this.f;
        String str = (String) this.f196b;
        m.e eVar = (m.e) this.f198d;
        if (eVar == null) {
            androidx.window.layout.c.k("Null transformer");
            return;
        }
        m.c cVar = (m.c) this.f197c;
        u.a aVar2 = pVar.f11871c;
        p.i iVarA = iVar.a(aVar.f11150b);
        d5.h hVar = new d5.h();
        hVar.f7086j = new HashMap();
        hVar.h = Long.valueOf(pVar.f11869a.n());
        hVar.f7085i = Long.valueOf(pVar.f11870b.n());
        hVar.f7082b = str;
        hVar.g = new p.k(cVar, (byte[]) eVar.apply(aVar.f11149a));
        hVar.f = null;
        m.b bVar = aVar.f11151c;
        if (bVar != null) {
            hVar.f7087k = bVar.f11152a;
        }
        aVar2.f12877b.execute(new androidx.work.impl.e(aVar2, iVarA, gVar, hVar.b(), 2));
    }

    public Set o(Class cls) {
        return e(q1.q.a(cls));
    }

    public z0(Context context) {
        long jC;
        String str;
        this.f195a = 8;
        context.getClass();
        String packageName = context.getPackageName();
        packageName.getClass();
        this.f = packageName;
        PackageManager packageManager = context.getPackageManager();
        packageManager.getClass();
        this.f196b = l5.b.b(packageManager, packageName);
        try {
            PackageManager packageManager2 = context.getPackageManager();
            packageManager2.getClass();
            String packageName2 = context.getPackageName();
            packageName2.getClass();
            jC = l5.b.c(l5.a.e(packageManager2, packageName2, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            jC = 0;
        }
        this.f197c = String.valueOf(jC);
        try {
            PackageManager packageManager3 = context.getPackageManager();
            packageManager3.getClass();
            String packageName3 = context.getPackageName();
            packageName3.getClass();
            str = l5.a.e(packageManager3, packageName3, 0).versionName;
        } catch (PackageManager.NameNotFoundException e3) {
            e3.printStackTrace();
            str = null;
        }
        this.f198d = str;
        this.e = "117";
    }

    public z0(y2.c cVar, d0.i iVar, c1.d0 d0Var, x xVar, String str, String str2) {
        this.f195a = 6;
        str.getClass();
        str2.getClass();
        this.f = cVar;
        this.f196b = iVar;
        this.f197c = d0Var;
        this.f198d = xVar;
        this.e = String.format(kotlin.jvm.internal.l.g("configs/users/%s/%s/config?sdkVersion=%s", "https://choice.inmobi.com/"), Arrays.copyOf(new Object[]{str2, str, "p-a-2.3.3"}, 3));
    }

    public z0(p6.a aVar, p6.a aVar2, p2 p2Var, p6.a aVar3, p6.a aVar4) {
        this.f195a = 11;
        this.f196b = aVar;
        this.f197c = aVar2;
        this.f = p2Var;
        this.f198d = aVar3;
        this.e = aVar4;
    }

    public z0(c3.c cVar, d0.i iVar, c3.c cVar2, c3.c cVar3, c3.c cVar4) {
        this.f195a = 1;
        this.f196b = cVar;
        this.f197c = iVar;
        this.f198d = cVar2;
        this.f = cVar3;
        this.e = cVar4;
    }

    public /* synthetic */ z0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i10) {
        this.f195a = i10;
        this.f = obj;
        this.f196b = obj2;
        this.f197c = obj3;
        this.f198d = obj4;
        this.e = obj5;
    }

    public z0(d0.i iVar, d0.i iVar2, c3.c cVar, c3.c cVar2, d0.i iVar3) {
        this.f195a = 0;
        this.f = iVar;
        this.f196b = iVar2;
        this.f197c = cVar;
        this.e = cVar2;
        this.f198d = iVar3;
    }

    public z0(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f195a = 12;
        this.f198d = new ArrayDeque();
        this.f = sharedPreferences;
        this.f196b = "topic_operation_queue";
        this.f197c = ",";
        this.e = scheduledThreadPoolExecutor;
    }
}
