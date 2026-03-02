package androidx.privacysandbox.ads.adservices.java.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.OnActionClickedListener;
import androidx.work.WorkerKt;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.tv.ui.activity.TvOldVersionsActivity;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import h1.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import p.i;
import q1.d;
import r7.b0;
import s.c;
import w.f;
import w.g;
import w.h;
import w2.j;
import x.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements CallbackToFutureAdapter.Resolver, d, q2.a, OnActionClickedListener, b, f, h1.d, h1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f594a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f595b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f596c;

    public /* synthetic */ a(int i10, Object obj, Object obj2) {
        this.f594a = i10;
        this.f595b = obj;
        this.f596c = obj2;
    }

    @Override // h1.a
    public Object a(p pVar) {
        j jVar = (j) this.f595b;
        String str = (String) this.f596c;
        synchronized (jVar) {
            ((ArrayMap) jVar.f13447b).remove(str);
        }
        return pVar;
    }

    @Override // w.f
    public Object apply(Object obj) {
        h hVar = (h) this.f595b;
        i iVar = (i) this.f596c;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        w.a aVar = hVar.f13310d;
        ArrayList arrayListE = hVar.e(sQLiteDatabase, iVar, aVar.f13297b);
        for (m.d dVar : m.d.values()) {
            if (dVar != iVar.f11857c) {
                int size = aVar.f13297b - arrayListE.size();
                if (size <= 0) {
                    break;
                }
                arrayListE.addAll(hVar.e(sQLiteDatabase, iVar.a(dVar), size));
            }
        }
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i10 = 0; i10 < arrayListE.size(); i10++) {
            sb.append(((w.b) arrayListE.get(i10)).f13300a);
            if (i10 < arrayListE.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        Cursor cursorQuery = sQLiteDatabase.query("event_metadata", new String[]{"event_id", RewardPlus.NAME, "value"}, sb.toString(), null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                long j10 = cursorQuery.getLong(0);
                Set hashSet = (Set) map.get(Long.valueOf(j10));
                if (hashSet == null) {
                    hashSet = new HashSet();
                    map.put(Long.valueOf(j10), hashSet);
                }
                hashSet.add(new g(cursorQuery.getString(1), cursorQuery.getString(2)));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        ListIterator listIterator = arrayListE.listIterator();
        while (listIterator.hasNext()) {
            w.b bVar = (w.b) listIterator.next();
            long j11 = bVar.f13300a;
            if (map.containsKey(Long.valueOf(j11))) {
                d5.h hVarC = bVar.f13302c.c();
                for (g gVar : (Set) map.get(Long.valueOf(j11))) {
                    hVarC.a(gVar.f13305a, gVar.f13306b);
                }
                listIterator.set(new w.b(j11, bVar.f13301b, hVarC.b()));
            }
        }
        return arrayListE;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f594a) {
            case 0:
                return CoroutineAdapterKt.asListenableFuture$lambda$0((b0) this.f595b, this.f596c, completer);
            default:
                return WorkerKt.future$lambda$2((Executor) this.f595b, (g7.a) this.f596c, completer);
        }
    }

    @Override // q2.a
    public void b(q2.b bVar) {
        q2.a aVar = (q2.a) this.f595b;
        q2.a aVar2 = (q2.a) this.f596c;
        aVar.b(bVar);
        aVar2.b(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    @Override // q1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(a3.z0 r4) {
        /*
            r3 = this;
            int r0 = r3.f594a
            switch(r0) {
                case 2: goto L89;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r3.f595b
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r3.f596c
            com.google.gson.internal.a r1 = (com.google.gson.internal.a) r1
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            java.lang.Object r4 = r4.a(r2)
            android.content.Context r4 = (android.content.Context) r4
            int r1 = r1.f2473a
            switch(r1) {
                case 14: goto L77;
                case 15: goto L72;
                case 16: goto L30;
                default: goto L1a;
            }
        L1a:
            android.content.pm.PackageManager r1 = r4.getPackageManager()
            java.lang.String r4 = r4.getPackageName()
            java.lang.String r4 = r1.getInstallerPackageName(r4)
            if (r4 == 0) goto L2d
            java.lang.String r4 = com.google.firebase.FirebaseCommonRegistrar.b(r4)
            goto L83
        L2d:
            java.lang.String r4 = ""
            goto L83
        L30:
            android.content.pm.PackageManager r1 = r4.getPackageManager()
            java.lang.String r2 = "android.hardware.type.television"
            boolean r1 = r1.hasSystemFeature(r2)
            if (r1 == 0) goto L3f
            java.lang.String r4 = "tv"
            goto L83
        L3f:
            android.content.pm.PackageManager r1 = r4.getPackageManager()
            java.lang.String r2 = "android.hardware.type.watch"
            boolean r1 = r1.hasSystemFeature(r2)
            if (r1 == 0) goto L4e
            java.lang.String r4 = "watch"
            goto L83
        L4e:
            android.content.pm.PackageManager r1 = r4.getPackageManager()
            java.lang.String r2 = "android.hardware.type.automotive"
            boolean r1 = r1.hasSystemFeature(r2)
            if (r1 == 0) goto L5d
            java.lang.String r4 = "auto"
            goto L83
        L5d:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L2d
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            java.lang.String r1 = "android.hardware.type.embedded"
            boolean r4 = r4.hasSystemFeature(r1)
            if (r4 == 0) goto L2d
            java.lang.String r4 = "embedded"
            goto L83
        L72:
            java.lang.String r4 = com.google.firebase.FirebaseCommonRegistrar.a(r4)
            goto L83
        L77:
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo()
            if (r4 == 0) goto L2d
            int r4 = r4.targetSdkVersion
            java.lang.String r4 = java.lang.String.valueOf(r4)
        L83:
            y2.a r1 = new y2.a
            r1.<init>(r0, r4)
            return r1
        L89:
            java.lang.Object r0 = r3.f595b
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r3.f596c
            q1.a r1 = (q1.a) r1
            android.os.Trace.beginSection(r0)     // Catch: java.lang.Throwable -> L9e
            q1.d r0 = r1.f     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r4 = r0.c(r4)     // Catch: java.lang.Throwable -> L9e
            android.os.Trace.endSection()
            return r4
        L9e:
            r4 = move-exception
            android.os.Trace.endSection()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.java.internal.a.c(a3.z0):java.lang.Object");
    }

    @Override // x.b
    public Object execute() {
        switch (this.f594a) {
            case 5:
                v.h hVar = (v.h) this.f595b;
                Iterable iterable = (Iterable) this.f596c;
                h hVar2 = (h) hVar.f13113c;
                hVar2.getClass();
                if (iterable.iterator().hasNext()) {
                    hVar2.a().compileStatement("DELETE FROM events WHERE _id in ".concat(h.i(iterable))).execute();
                    break;
                }
                break;
            default:
                v.h hVar3 = (v.h) this.f595b;
                for (Map.Entry entry : ((HashMap) this.f596c).entrySet()) {
                    ((h) hVar3.f13115i).f(((Integer) entry.getValue()).intValue(), c.INVALID_PAYLOD, (String) entry.getKey());
                }
                break;
        }
        return null;
    }

    @Override // h1.d
    public void o(p pVar) {
        ((FirebaseMessagingService) this.f595b).a((Intent) this.f596c);
    }

    @Override // androidx.leanback.widget.OnActionClickedListener
    public void onActionClicked(Action action) {
        Bundle bundleA;
        TvAppDetailFragment tvAppDetailFragment = (TvAppDetailFragment) this.f595b;
        FragmentActivity fragmentActivity = (FragmentActivity) this.f596c;
        action.getClass();
        if (action.getId() == 1) {
            int i10 = tvAppDetailFragment.f6695c;
            if (i10 != 0) {
                if (i10 == 1) {
                    tvAppDetailFragment.f();
                    return;
                }
                if (i10 == 2) {
                    tvAppDetailFragment.f();
                    return;
                }
                if (i10 == 3) {
                    tvAppDetailFragment.b();
                    return;
                } else if (i10 == 5) {
                    tvAppDetailFragment.f();
                    return;
                } else {
                    if (i10 != 6) {
                        return;
                    }
                    tvAppDetailFragment.f();
                    return;
                }
            }
            h5.h hVar = tvAppDetailFragment.f6693a;
            if (hVar == null || hVar.f8595w == null || tvAppDetailFragment.getContext() == null) {
                return;
            }
            PackageManager packageManager = tvAppDetailFragment.requireContext().getPackageManager();
            h5.h hVar2 = tvAppDetailFragment.f6693a;
            hVar2.getClass();
            String str = hVar2.f8595w;
            str.getClass();
            Intent leanbackLaunchIntentForPackage = packageManager.getLeanbackLaunchIntentForPackage(str);
            if (leanbackLaunchIntentForPackage == null) {
                PackageManager packageManager2 = tvAppDetailFragment.requireContext().getPackageManager();
                h5.h hVar3 = tvAppDetailFragment.f6693a;
                hVar3.getClass();
                String str2 = hVar3.f8595w;
                str2.getClass();
                leanbackLaunchIntentForPackage = packageManager2.getLaunchIntentForPackage(str2);
            }
            if (leanbackLaunchIntentForPackage != null) {
                tvAppDetailFragment.startActivity(leanbackLaunchIntentForPackage);
                return;
            }
            return;
        }
        if (action.getId() == 2) {
            h5.h hVar4 = tvAppDetailFragment.f6693a;
            if (hVar4 == null || hVar4.f8595w == null) {
                return;
            }
            Context contextRequireContext = tvAppDetailFragment.requireContext();
            contextRequireContext.getClass();
            h5.h hVar5 = tvAppDetailFragment.f6693a;
            hVar5.getClass();
            String str3 = hVar5.f8595w;
            str3.getClass();
            Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str3)));
            intent.addFlags(268435456);
            contextRequireContext.startActivity(intent);
            return;
        }
        if (action.getId() == 3) {
            if (tvAppDetailFragment.f6693a != null) {
                Intent intent2 = new Intent(fragmentActivity, (Class<?>) TvOldVersionsActivity.class);
                intent2.putExtra("appInfo", tvAppDetailFragment.f6693a);
                float f = UptodownApp.E;
                tvAppDetailFragment.startActivity(intent2, k4.c.a(fragmentActivity));
                return;
            }
            return;
        }
        if (action.getId() == 4) {
            if (tvAppDetailFragment.f6693a != null) {
                Intent intent3 = new Intent(fragmentActivity, (Class<?>) VirusTotalReport.class);
                intent3.putExtra("appInfo", tvAppDetailFragment.f6693a);
                float f10 = UptodownApp.E;
                tvAppDetailFragment.startActivity(intent3, k4.c.a(fragmentActivity));
                return;
            }
            return;
        }
        if (action.getId() != 5 || tvAppDetailFragment.f6693a == null) {
            return;
        }
        Intent intent4 = new Intent(tvAppDetailFragment.getContext(), (Class<?>) MoreInfo.class);
        intent4.putExtra("appInfo", tvAppDetailFragment.f6693a);
        FragmentActivity activity = tvAppDetailFragment.getActivity();
        if (activity != null) {
            float f11 = UptodownApp.E;
            bundleA = k4.c.a(activity);
        } else {
            bundleA = null;
        }
        tvAppDetailFragment.startActivity(intent4, bundleA);
    }
}
