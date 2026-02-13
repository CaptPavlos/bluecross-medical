package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c6 implements i1.d, g6 {

    /* renamed from: b, reason: collision with root package name */
    public static final m5 f1903b = new m5(3);

    /* renamed from: a, reason: collision with root package name */
    public final Object f1904a;

    public c6(int i10) {
        switch (i10) {
            case 1:
                this.f1904a = new HashMap();
                break;
            default:
                m6 m6Var = m6.f2086c;
                c6 c6Var = new c6(new g6[]{m5.f2084b, f1903b});
                Charset charset = u5.f2192a;
                this.f1904a = c6Var;
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.g6
    public boolean a(Class cls) {
        for (int i10 = 0; i10 < 2; i10++) {
            if (((g6[]) this.f1904a)[i10].a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.g6
    public o6 b(Class cls) {
        for (int i10 = 0; i10 < 2; i10++) {
            g6 g6Var = ((g6[]) this.f1904a)[i10];
            if (g6Var.a(cls)) {
                return g6Var.b(cls);
            }
        }
        a2.a.m("No factory is available for message type: ".concat(cls.getName()));
        return null;
    }

    public /* synthetic */ Object c() {
        g4 g4Var = (g4) this.f1904a;
        ContentResolver contentResolver = g4Var.f1965a;
        Uri uri = g4Var.f1966b;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        try {
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
                return Collections.EMPTY_MAP;
            }
            Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, g4.f1964j, null, null, null);
            try {
                if (cursorQuery == null) {
                    Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                    return Collections.EMPTY_MAP;
                }
                int count = cursorQuery.getCount();
                if (count == 0) {
                    Map map = Collections.EMPTY_MAP;
                    cursorQuery.close();
                    return map;
                }
                Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
                while (cursorQuery.moveToNext()) {
                    arrayMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
                }
                if (cursorQuery.isAfterLast()) {
                    cursorQuery.close();
                    return arrayMap;
                }
                Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                Map map2 = Collections.EMPTY_MAP;
                cursorQuery.close();
                return map2;
            } finally {
            }
        } catch (RemoteException e) {
            Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e);
            return Collections.EMPTY_MAP;
        } finally {
            contentProviderClientAcquireUnstableContentProviderClient.release();
        }
    }

    public void d(int i10, Object obj, p6 p6Var) throws e5 {
        u4 u4Var = (u4) obj;
        d5 d5Var = (d5) this.f1904a;
        d5Var.m((i10 << 3) | 2);
        d5Var.m(u4Var.b(p6Var));
        p6Var.d(u4Var, d5Var.f1914a);
    }

    public void e(int i10, Object obj, p6 p6Var) throws e5 {
        d5 d5Var = (d5) this.f1904a;
        d5Var.c(i10, 3);
        p6Var.d((u4) obj, d5Var.f1914a);
        d5Var.c(i10, 4);
    }

    @Override // i1.d
    public /* synthetic */ Object get() {
        Object obj = o4.g;
        return k4.e((Context) this.f1904a);
    }

    public /* synthetic */ c6(Object obj) {
        this.f1904a = obj;
    }

    public c6(d5 d5Var) {
        Charset charset = u5.f2192a;
        this.f1904a = d5Var;
        d5Var.f1914a = this;
    }
}
