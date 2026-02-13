package c2;

import a3.a1;
import a3.j0;
import a3.k1;
import a3.o1;
import a3.y0;
import a6.h;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.datastore.core.DataStore;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import c1.g1;
import c1.y1;
import com.uptodown.R;
import d3.j;
import j$.util.DesugarCollections;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import l4.n5;
import l4.p2;
import p.p;
import p8.u;
import t1.e;
import w1.g;
import w1.i;
import w1.q;
import w1.v;
import w1.w;
import w2.r;
import y1.f;
import y1.n;
import z1.a0;
import z1.b0;
import z1.c1;
import z1.c2;
import z1.d1;
import z1.f0;
import z1.f1;
import z1.j2;
import z1.o0;
import z1.p0;
import z1.q0;
import z1.r0;
import z1.t0;
import z1.u0;
import z1.v0;
import z1.z0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d implements c3.b, ViewBinding, r.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1640a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1641b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1642c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1643d;
    public Object e;
    public final Object f;
    public Object g;
    public Object h;

    public d(Context context) {
        String string;
        this.f1640a = 0;
        String str = ((z0) e.f12754a.b(context)).f14397a;
        this.f1641b = str;
        File filesDir = context.getFilesDir();
        this.f1642c = filesDir;
        if (str.isEmpty()) {
            string = ".com.google.firebase.crashlytics.files.v1";
        } else {
            StringBuilder sb = new StringBuilder(".crashlytics.v3");
            sb.append(File.separator);
            sb.append(str.length() > 40 ? g.h(str) : str.replaceAll("[^a-zA-Z0-9.]", "_"));
            string = sb.toString();
        }
        File file = new File(filesDir, string);
        k(file);
        this.f1643d = file;
        File file2 = new File(file, "open-sessions");
        k(file2);
        this.e = file2;
        File file3 = new File(file, "reports");
        k(file3);
        this.f = file3;
        File file4 = new File(file, "priority-reports");
        k(file4);
        this.g = file4;
        File file5 = new File(file, "native-reports");
        k(file5);
        this.h = file5;
    }

    public static p0 a(p0 p0Var, f fVar, d dVar, Map map) {
        Map mapUnmodifiableMap;
        o0 o0VarA = p0Var.a();
        String strC = ((y1.d) fVar.f13758b).c();
        if (strC != null) {
            o0VarA.e = new c1(strC);
        } else if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "No log data to include with this event.", null);
        }
        boolean zIsEmpty = map.isEmpty();
        g1 g1Var = (g1) dVar.e;
        if (zIsEmpty) {
            mapUnmodifiableMap = ((y1.e) ((AtomicMarkableReference) g1Var.f1230b).getReference()).a();
        } else {
            HashMap map2 = new HashMap(((y1.e) ((AtomicMarkableReference) g1Var.f1230b).getReference()).a());
            int i10 = 0;
            for (Map.Entry entry : map.entrySet()) {
                String strB = y1.e.b(1024, (String) entry.getKey());
                if (map2.size() < 64 || map2.containsKey(strB)) {
                    map2.put(strB, y1.e.b(1024, (String) entry.getValue()));
                } else {
                    i10++;
                }
            }
            if (i10 > 0) {
                Log.w("FirebaseCrashlytics", "Ignored " + i10 + " keys when adding event specific keys. Maximum allowable: 1024", null);
            }
            mapUnmodifiableMap = DesugarCollections.unmodifiableMap(map2);
        }
        List listI = i(mapUnmodifiableMap);
        List listI2 = i(((y1.e) ((AtomicMarkableReference) ((g1) dVar.f).f1230b).getReference()).a());
        if (!listI.isEmpty() || !listI2.isEmpty()) {
            q0 q0Var = (q0) p0Var.f14327c;
            o0VarA.f14319c = new q0(q0Var.f14333a, listI, listI2, q0Var.f14336d, q0Var.e, q0Var.f, q0Var.g);
        }
        return o0VarA.a();
    }

    public static j2 b(p0 p0Var, d dVar) {
        List listA = ((s8.c) dVar.g).a();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < listA.size(); i10++) {
            n nVar = (n) listA.get(i10);
            nVar.getClass();
            d1 d1Var = new d1();
            y1.b bVar = (y1.b) nVar;
            String str = bVar.e;
            if (str == null) {
                androidx.window.layout.c.k("Null variantId");
                return null;
            }
            String str2 = bVar.f13747b;
            if (str2 == null) {
                androidx.window.layout.c.k("Null rolloutId");
                return null;
            }
            d1Var.f14197a = new f1(str2, str);
            String str3 = bVar.f13748c;
            if (str3 == null) {
                androidx.window.layout.c.k("Null parameterKey");
                return null;
            }
            d1Var.f14198b = str3;
            d1Var.f14199c = bVar.f13749d;
            d1Var.f14200d = bVar.f;
            d1Var.e = (byte) (d1Var.e | 1);
            arrayList.add(d1Var.a());
        }
        if (arrayList.isEmpty()) {
            return p0Var;
        }
        o0 o0VarA = p0Var.a();
        o0VarA.f = new z1.g1(arrayList);
        return o0VarA.a();
    }

    public static d c(View view) {
        int i10 = R.id.iv_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_item);
        if (imageView != null) {
            i10 = R.id.iv_see_more_list;
            if (((ImageView) ViewBindings.findChildViewById(view, R.id.iv_see_more_list)) != null) {
                i10 = R.id.ll_apps_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_apps_container);
                if (linearLayout != null) {
                    i10 = R.id.loading_view_list;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.loading_view_list);
                    if (progressBar != null) {
                        i10 = R.id.rl_apps_container;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_apps_container);
                        if (relativeLayout != null) {
                            i10 = R.id.tv_app_count;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_count);
                            if (textView != null) {
                                i10 = R.id.tv_list_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_list_title);
                                if (textView2 != null) {
                                    return new d((LinearLayout) view, imageView, linearLayout, progressBar, relativeLayout, textView, textView2, 4);
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        return null;
    }

    public static d d(View view) {
        int i10 = R.id.iv_more_public_profile_top;
        if (((ImageView) ViewBindings.findChildViewById(view, R.id.iv_more_public_profile_top)) != null) {
            i10 = R.id.rl_no_items_public_profile_top;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_no_items_public_profile_top);
            if (relativeLayout != null) {
                i10 = R.id.rl_title_public_profile_top;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_title_public_profile_top);
                if (relativeLayout2 != null) {
                    i10 = R.id.rv_public_profile_top;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_public_profile_top);
                    if (recyclerView != null) {
                        i10 = R.id.tv_explore_public_profile_top;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_explore_public_profile_top);
                        if (textView != null) {
                            i10 = R.id.tv_no_items_public_profile_top;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items_public_profile_top);
                            if (textView2 != null) {
                                i10 = R.id.tv_title_public_profile_top;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_public_profile_top);
                                if (textView3 != null) {
                                    return new d((LinearLayout) view, relativeLayout, relativeLayout2, recyclerView, textView, textView2, textView3, 6);
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        return null;
    }

    public static String f(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i10 = bufferedInputStream.read(bArr);
                    if (i10 == -1) {
                        String string = byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                        byteArrayOutputStream.close();
                        bufferedInputStream.close();
                        return string;
                    }
                    byteArrayOutputStream.write(bArr, 0, i10);
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static d g(Context context, w wVar, d dVar, w1.a aVar, f fVar, d dVar2, a4.f fVar2, d5.n nVar, t1.c cVar, i iVar, x1.e eVar) {
        q qVar = new q(context, wVar, aVar, fVar2, nVar);
        b bVar = new b(dVar, nVar, iVar);
        a2.b bVar2 = d2.a.f6788b;
        p.b(context);
        return new d(qVar, bVar, new d2.a(new d2.c(p.a().c(new n.a(d2.a.f6789c, d2.a.f6790d)).a("FIREBASE_CRASHLYTICS_REPORT", new m.c("json"), d2.a.e), nVar.k(), cVar)), fVar, dVar2, wVar, eVar, 9);
    }

    public static List i(Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str == null) {
                androidx.window.layout.c.k("Null key");
                return null;
            }
            String str2 = (String) entry.getValue();
            if (str2 == null) {
                androidx.window.layout.c.k("Null value");
                return null;
            }
            arrayList.add(new f0(str, str2));
        }
        Collections.sort(arrayList, new h(8));
        return DesugarCollections.unmodifiableList(arrayList);
    }

    public static synchronized void k(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return;
                }
                String str = "Unexpected non-directory file: " + file + "; deleting file and creating new directory.";
                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", str, null);
                }
                file.delete();
            }
            if (!file.mkdirs()) {
                Log.e("FirebaseCrashlytics", "Could not create Crashlytics-specific directory: " + file, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static boolean l(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                l(file2);
            }
        }
        return file.delete();
    }

    public static List m(Object[] objArr) {
        return objArr == null ? Collections.EMPTY_LIST : Arrays.asList(objArr);
    }

    public void e(String str) {
        File file = new File((File) this.f1642c, str);
        if (file.exists() && l(file)) {
            String str2 = "Deleted previous Crashlytics file system: " + file.getPath();
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", str2, null);
            }
        }
    }

    @Override // p6.a
    public Object get() {
        switch (this.f1640a) {
            case 1:
                return new k1((j) ((p6.a) this.f1641b).get(), (a1) ((p6.a) this.f1642c).get(), (y0) ((p6.a) this.f1643d).get(), (o1) ((p6.a) this.e).get(), (DataStore) ((p6.a) this.f).get(), (j0) ((c3.c) this.g).get(), (w6.h) ((p6.a) this.h).get());
            default:
                return new v.h((Context) ((p6.a) this.f1641b).get(), (q.d) ((p6.a) this.f1642c).get(), (w.d) ((p6.a) this.f1643d).get(), (p2) ((p2) this.e).get(), (Executor) ((p6.a) this.f).get(), (x.c) ((p6.a) this.g).get(), new t3.h(17), new t3.h(16), (w.c) ((p6.a) this.h).get());
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        switch (this.f1640a) {
            case 3:
                return (LinearLayout) this.f1641b;
            case 4:
                return (LinearLayout) this.f1641b;
            case 5:
                return (RelativeLayout) this.f1641b;
            default:
                return (LinearLayout) this.f1641b;
        }
    }

    public File h(String str, String str2) {
        File file = new File((File) this.e, str);
        file.mkdirs();
        return new File(file, str2);
    }

    public void j(Throwable th, Thread thread, String str, final y1.c cVar, boolean z9) {
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it;
        byte b10;
        final boolean zEquals = str.equals("crash");
        q qVar = (q) this.f1641b;
        long j10 = cVar.f13751b;
        Context context = qVar.f13383a;
        int i10 = context.getResources().getConfiguration().orientation;
        a4.f fVar = qVar.f13386d;
        Stack stack = new Stack();
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            stack.push(cause);
        }
        r rVar = null;
        while (!stack.isEmpty()) {
            Throwable th2 = (Throwable) stack.pop();
            rVar = new r(th2.getLocalizedMessage(), th2.getClass().getName(), fVar.e(th2.getStackTrace()), rVar, 17);
        }
        r rVar2 = rVar;
        o0 o0Var = new o0();
        o0Var.f14318b = str;
        o0Var.f14317a = j10;
        o0Var.g = (byte) (o0Var.g | 1);
        c2 c2VarB = e.f12754a.b(context);
        int i11 = ((z0) c2VarB).f14399c;
        Boolean boolValueOf = i11 > 0 ? Boolean.valueOf(i11 != 100) : null;
        ArrayList arrayListA = e.a(context);
        byte b11 = (byte) 1;
        ArrayList arrayList = new ArrayList();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) rVar2.f13464d;
        String name = thread.getName();
        if (name == null) {
            androidx.window.layout.c.k("Null name");
            return;
        }
        byte b12 = (byte) 1;
        List listD = q.d(stackTraceElementArr, 4);
        if (listD == null) {
            androidx.window.layout.c.k("Null frames");
            return;
        }
        if (b12 != 1) {
            StringBuilder sb = new StringBuilder();
            if (b12 == 0) {
                sb.append(" importance");
            }
            androidx.window.layout.c.g(r1.i.e(sb, "Missing required properties:"));
            return;
        }
        arrayList.add(new v0(listD, name, 4));
        if (z9) {
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it2 = Thread.getAllStackTraces().entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<Thread, StackTraceElement[]> next = it2.next();
                Thread key = next.getKey();
                if (key.equals(thread)) {
                    it = it2;
                    b10 = b12;
                } else {
                    StackTraceElement[] stackTraceElementArrE = fVar.e(next.getValue());
                    String name2 = key.getName();
                    if (name2 == null) {
                        androidx.window.layout.c.k("Null name");
                        return;
                    }
                    it = it2;
                    List listD2 = q.d(stackTraceElementArrE, 0);
                    if (listD2 == null) {
                        androidx.window.layout.c.k("Null frames");
                        return;
                    }
                    if (b12 != 1) {
                        byte b13 = b12;
                        StringBuilder sb2 = new StringBuilder();
                        if (b13 == 0) {
                            sb2.append(" importance");
                        }
                        androidx.window.layout.c.g(r1.i.e(sb2, "Missing required properties:"));
                        return;
                    }
                    b10 = b12;
                    arrayList.add(new v0(listD2, name2, 0));
                }
                it2 = it;
                b12 = b10;
            }
        }
        List listUnmodifiableList = DesugarCollections.unmodifiableList(arrayList);
        t0 t0VarC = q.c(rVar2, 0);
        u0 u0VarE = q.e();
        List listA = qVar.a();
        if (listA == null) {
            androidx.window.layout.c.k("Null binaries");
            return;
        }
        r0 r0Var = new r0(listUnmodifiableList, t0VarC, null, u0VarE, listA);
        if (b11 != 1) {
            StringBuilder sb3 = new StringBuilder();
            if (b11 == 0) {
                sb3.append(" uiOrientation");
            }
            androidx.window.layout.c.g(r1.i.e(sb3, "Missing required properties:"));
            return;
        }
        o0Var.f14319c = new q0(r0Var, null, null, boolValueOf, c2VarB, arrayListA, i10);
        o0Var.f14320d = qVar.b(i10);
        p0 p0VarA = o0Var.a();
        Map map = cVar.f13752c;
        f fVar2 = (f) this.e;
        d dVar = (d) this.f;
        final j2 j2VarB = b(a(p0VarA, fVar2, dVar, map), dVar);
        if (z9) {
            ((b) this.f1642c).d(j2VarB, cVar.f13750a, zEquals);
        } else {
            ((x1.e) this.h).f13577b.a(new Runnable() { // from class: w1.x
                @Override // java.lang.Runnable
                public final void run() {
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "disk worker: log non-fatal event to persistence", null);
                    }
                    ((c2.b) this.f13404a.f1642c).d(j2VarB, cVar.f13750a, zEquals);
                }
            });
        }
    }

    public h1.p n(Executor executor, String str) {
        h1.i iVar;
        ArrayList arrayListB = ((b) this.f1642c).b();
        ArrayList arrayList = new ArrayList();
        int size = arrayListB.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            File file = (File) arrayListB.get(i10);
            try {
                a2.b bVar = b.g;
                String strE = b.e(file);
                bVar.getClass();
                arrayList.add(new w1.b(a2.b.i(strE), file.getName(), file));
            } catch (IOException e) {
                Log.w("FirebaseCrashlytics", "Could not load report file " + file + "; deleting", e);
                file.delete();
            }
            i10 = i11;
        }
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        int i12 = 0;
        while (i12 < size2) {
            Object obj = arrayList.get(i12);
            i12++;
            w1.b bVar2 = (w1.b) obj;
            if (str == null || str.equals(bVar2.f13322b)) {
                d2.a aVar = (d2.a) this.f1643d;
                b0 b0Var = bVar2.f13321a;
                if (b0Var.f == null || b0Var.g == null) {
                    v vVarB = ((w) this.g).b(true);
                    b0 b0Var2 = bVar2.f13321a;
                    String str2 = vVarB.f13398a;
                    a0 a0VarA = b0Var2.a();
                    a0VarA.e = str2;
                    b0 b0VarA = a0VarA.a();
                    String str3 = vVarB.f13399b;
                    a0 a0VarA2 = b0VarA.a();
                    a0VarA2.f = str3;
                    bVar2 = new w1.b(a0VarA2.a(), bVar2.f13322b, bVar2.f13323c);
                }
                boolean z9 = str != null;
                d2.c cVar = aVar.f6791a;
                synchronized (cVar.f) {
                    try {
                        iVar = new h1.i();
                        if (z9) {
                            ((AtomicInteger) cVar.f6800i.f12751b).getAndIncrement();
                            if (cVar.f.size() < cVar.e) {
                                t1.d dVar = t1.d.f12753a;
                                dVar.b("Enqueueing report: " + bVar2.f13322b);
                                dVar.b("Queue size: " + cVar.f.size());
                                cVar.g.execute(new y1(cVar, bVar2, iVar, 9));
                                dVar.b("Closing task for report: " + bVar2.f13322b);
                                iVar.c(bVar2);
                            } else {
                                cVar.a();
                                String str4 = "Dropping report due to queue being full: " + bVar2.f13322b;
                                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                                    Log.d("FirebaseCrashlytics", str4, null);
                                }
                                ((AtomicInteger) cVar.f6800i.f12752c).getAndIncrement();
                                iVar.c(bVar2);
                            }
                        } else {
                            cVar.b(bVar2, iVar);
                        }
                    } finally {
                    }
                }
                arrayList2.add(iVar.f8418a.d(executor, new u(this, 18)));
            }
        }
        return r0.f.M(arrayList2);
    }

    public void o() {
        Thread thread = (Thread) this.g;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new v4.b(this, 0));
            this.g = thread2;
            thread2.start();
        }
    }

    public d() {
        this.f1640a = 2;
        this.f1641b = new AtomicBoolean();
        this.f1642c = null;
        this.f1643d = new HashMap(16, 1.0f);
        this.e = new HashMap(16, 1.0f);
        this.f = new HashMap(16, 1.0f);
        this.g = new HashMap(16, 1.0f);
        this.h = null;
    }

    public d(Context context, n5 n5Var, v4.a aVar) {
        this.f1640a = 8;
        context.getClass();
        n5Var.getClass();
        this.f1641b = context;
        this.f1642c = n5Var;
        this.f1643d = aVar;
        Thread thread = new Thread(new v4.b(this, 2));
        this.f = thread;
        thread.start();
    }

    public d(LinearLayout linearLayout, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView, TextView textView2, TextView textView3) {
        this.f1640a = 3;
        this.f1641b = linearLayout;
        this.f1642c = editText;
        this.f1643d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = imageView5;
        this.h = imageView6;
    }

    public /* synthetic */ d(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, int i10) {
        this.f1640a = i10;
        this.f1641b = obj;
        this.f1642c = obj2;
        this.f1643d = obj3;
        this.e = obj4;
        this.f = obj5;
        this.g = obj6;
        this.h = obj7;
    }

    public d(String str, d dVar, x1.e eVar) {
        this.f1640a = 10;
        this.e = new g1(this, false);
        this.f = new g1(this, true);
        this.g = new s8.c();
        this.h = new AtomicMarkableReference(null, false);
        this.f1641b = str;
        this.f1642c = new y1.h(dVar);
        this.f1643d = eVar;
    }
}
