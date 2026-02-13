package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2165a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2166b;

    public t(int i10) {
        switch (i10) {
            case 3:
                this.f2165a = new TreeMap();
                this.f2166b = new TreeMap();
                break;
            default:
                this.f2165a = new HashMap();
                this.f2166b = new s(6);
                s sVar = new s(0);
                w wVar = w.BITWISE_AND;
                ArrayList arrayList = sVar.f2152a;
                arrayList.add(wVar);
                arrayList.add(w.BITWISE_LEFT_SHIFT);
                arrayList.add(w.BITWISE_NOT);
                arrayList.add(w.BITWISE_OR);
                arrayList.add(w.BITWISE_RIGHT_SHIFT);
                arrayList.add(w.BITWISE_UNSIGNED_RIGHT_SHIFT);
                arrayList.add(w.BITWISE_XOR);
                b(sVar);
                s sVar2 = new s(1);
                w wVar2 = w.EQUALS;
                ArrayList arrayList2 = sVar2.f2152a;
                arrayList2.add(wVar2);
                arrayList2.add(w.GREATER_THAN);
                arrayList2.add(w.GREATER_THAN_EQUALS);
                arrayList2.add(w.IDENTITY_EQUALS);
                arrayList2.add(w.IDENTITY_NOT_EQUALS);
                arrayList2.add(w.LESS_THAN);
                arrayList2.add(w.LESS_THAN_EQUALS);
                arrayList2.add(w.NOT_EQUALS);
                b(sVar2);
                s sVar3 = new s(2);
                w wVar3 = w.APPLY;
                ArrayList arrayList3 = sVar3.f2152a;
                arrayList3.add(wVar3);
                arrayList3.add(w.BLOCK);
                arrayList3.add(w.BREAK);
                arrayList3.add(w.CASE);
                arrayList3.add(w.DEFAULT);
                arrayList3.add(w.CONTINUE);
                arrayList3.add(w.DEFINE_FUNCTION);
                arrayList3.add(w.FN);
                arrayList3.add(w.IF);
                arrayList3.add(w.QUOTE);
                arrayList3.add(w.RETURN);
                arrayList3.add(w.SWITCH);
                arrayList3.add(w.TERNARY);
                b(sVar3);
                s sVar4 = new s(3);
                w wVar4 = w.AND;
                ArrayList arrayList4 = sVar4.f2152a;
                arrayList4.add(wVar4);
                arrayList4.add(w.NOT);
                arrayList4.add(w.OR);
                b(sVar4);
                s sVar5 = new s(4);
                w wVar5 = w.FOR_IN;
                ArrayList arrayList5 = sVar5.f2152a;
                arrayList5.add(wVar5);
                arrayList5.add(w.FOR_IN_CONST);
                arrayList5.add(w.FOR_IN_LET);
                arrayList5.add(w.FOR_LET);
                arrayList5.add(w.FOR_OF);
                arrayList5.add(w.FOR_OF_CONST);
                arrayList5.add(w.FOR_OF_LET);
                arrayList5.add(w.WHILE);
                b(sVar5);
                s sVar6 = new s(5);
                w wVar6 = w.ADD;
                ArrayList arrayList6 = sVar6.f2152a;
                arrayList6.add(wVar6);
                arrayList6.add(w.DIVIDE);
                arrayList6.add(w.MODULUS);
                arrayList6.add(w.MULTIPLY);
                arrayList6.add(w.NEGATE);
                arrayList6.add(w.POST_DECREMENT);
                arrayList6.add(w.POST_INCREMENT);
                arrayList6.add(w.PRE_DECREMENT);
                arrayList6.add(w.PRE_INCREMENT);
                arrayList6.add(w.SUBTRACT);
                b(sVar6);
                s sVar7 = new s(7);
                w wVar7 = w.ASSIGN;
                ArrayList arrayList7 = sVar7.f2152a;
                arrayList7.add(wVar7);
                arrayList7.add(w.CONST);
                arrayList7.add(w.CREATE_ARRAY);
                arrayList7.add(w.CREATE_OBJECT);
                arrayList7.add(w.EXPRESSION_LIST);
                arrayList7.add(w.GET);
                arrayList7.add(w.GET_INDEX);
                arrayList7.add(w.GET_PROPERTY);
                arrayList7.add(w.NULL);
                arrayList7.add(w.SET_PROPERTY);
                arrayList7.add(w.TYPEOF);
                arrayList7.add(w.UNDEFINED);
                arrayList7.add(w.VAR);
                b(sVar7);
                break;
        }
    }

    public Object a() {
        Uri uri;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        String string;
        j4 j4Var = (j4) this.f2165a;
        String str = (String) this.f2166b;
        Context context = (Context) j4Var.f2008b;
        context.getClass();
        ContentResolver contentResolver = context.getContentResolver();
        c2.d dVar = y3.f2272a;
        if (contentResolver == null) {
            dVar.getClass();
            androidx.window.layout.c.g("ContentResolver needed with GservicesDelegateSupplier.init()");
            return null;
        }
        synchronized (dVar) {
            try {
                HashMap map = (HashMap) dVar.f1642c;
                AtomicBoolean atomicBoolean = (AtomicBoolean) dVar.f1641b;
                if (map == null) {
                    atomicBoolean.set(false);
                    dVar.f1642c = new HashMap(16, 1.0f);
                    dVar.h = new Object();
                    contentResolver.registerContentObserver(z3.f2277a, true, new b4(dVar));
                } else if (atomicBoolean.getAndSet(false)) {
                    ((HashMap) dVar.f1642c).clear();
                    ((HashMap) dVar.f1643d).clear();
                    ((HashMap) dVar.e).clear();
                    ((HashMap) dVar.f).clear();
                    ((HashMap) dVar.g).clear();
                    dVar.h = new Object();
                }
                Object obj = dVar.h;
                String str2 = null;
                if (((HashMap) dVar.f1642c).containsKey(str)) {
                    String str3 = (String) ((HashMap) dVar.f1642c).get(str);
                    if (str3 != null) {
                        str2 = str3;
                    }
                    return str2;
                }
                try {
                    uri = z3.f2277a;
                    contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                    try {
                    } finally {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    }
                } catch (c4 unused) {
                }
                if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                    throw new c4("Unable to acquire ContentProviderClient");
                }
                try {
                    Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, null, new String[]{str}, null);
                    try {
                        if (cursorQuery == null) {
                            throw new c4("ContentProvider query returned null cursor");
                        }
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(1);
                            cursorQuery.close();
                        } else {
                            cursorQuery.close();
                            string = null;
                        }
                        if (string != null && string.equals(null)) {
                            string = null;
                        }
                        synchronized (dVar) {
                            try {
                                if (obj == dVar.h) {
                                    ((HashMap) dVar.f1642c).put(str, string);
                                }
                            } finally {
                            }
                        }
                        if (string != null) {
                            return string;
                        }
                        return null;
                    } finally {
                    }
                } catch (RemoteException e) {
                    throw new c4("ContentProvider query failed", e);
                }
            } finally {
            }
        }
    }

    public void b(s sVar) {
        ArrayList arrayList = sVar.f2152a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((HashMap) this.f2165a).put(Integer.valueOf(((w) obj).f2244a).toString(), sVar);
        }
    }

    public n c(w2.r rVar, n nVar) {
        a.a.e0(rVar);
        if (!(nVar instanceof o)) {
            return nVar;
        }
        o oVar = (o) nVar;
        ArrayList arrayList = oVar.f2111b;
        String str = oVar.f2110a;
        HashMap map = (HashMap) this.f2165a;
        return (map.containsKey(str) ? (s) map.get(str) : (s) this.f2166b).a(str, rVar, arrayList);
    }

    public void d(w2.r rVar, a3.x xVar) {
        z4 z4Var = new z4(xVar);
        TreeMap treeMap = (TreeMap) this.f2165a;
        for (Integer num : treeMap.keySet()) {
            b bVarClone = ((b) xVar.f182c).clone();
            n nVarA = ((m) treeMap.get(num)).a(rVar, Collections.singletonList(z4Var));
            int iA0 = nVarA instanceof g ? a.a.a0(((g) nVarA).f1959a.doubleValue()) : -1;
            if (iA0 == 2 || iA0 == -1) {
                xVar.f182c = bVarClone;
            }
        }
        TreeMap treeMap2 = (TreeMap) this.f2166b;
        Iterator it = treeMap2.keySet().iterator();
        while (it.hasNext()) {
            n nVarA2 = ((m) treeMap2.get((Integer) it.next())).a(rVar, Collections.singletonList(z4Var));
            if (nVarA2 instanceof g) {
                a.a.a0(((g) nVarA2).f1959a.doubleValue());
            }
        }
    }

    public /* synthetic */ t(Object obj, Object obj2) {
        this.f2165a = obj;
        this.f2166b = obj2;
    }
}
