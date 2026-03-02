package com.mbridge.msdk.newreward.function.command;

import com.mbridge.msdk.newreward.function.common.MBridgeError;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private a f4766a;

    /* renamed from: b, reason: collision with root package name */
    private a f4767b;

    public final Map a(Object... objArr) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (objArr.length % 2 == 0) {
            for (int i10 = 0; i10 < objArr.length; i10++) {
                if (i10 % 2 == 0) {
                    Object obj = objArr[i10];
                    Object obj2 = objArr[i10 + 1];
                    if (obj == null) {
                        obj = "";
                    }
                    if (obj2 == null) {
                        obj2 = "";
                    }
                    concurrentHashMap.put(obj, obj2);
                }
            }
        }
        return concurrentHashMap;
    }

    public final Object b(Object obj) {
        if (this.f4766a == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(obj);
        bVar.a(f.CANDIDATE_LOAD_ACTION);
        return this.f4766a.a(bVar).a();
    }

    public final void c(Object obj) throws MBridgeError {
        if (this.f4766a == null) {
            return;
        }
        b bVar = new b();
        bVar.a(f.CHECK_CAMPAIGN);
        bVar.a(obj);
        e eVarA = this.f4766a.a(bVar);
        if (!eVarA.b()) {
            throw ((MBridgeError) eVarA.a());
        }
    }

    public final void d(Object obj) throws MBridgeError {
        if (this.f4766a == null) {
            return;
        }
        b bVar = new b();
        bVar.a(f.CHECK_CAMPAIGN_EXCLUDE_INS);
        bVar.a(obj);
        e eVarA = this.f4766a.a(bVar);
        if (!eVarA.b()) {
            throw ((MBridgeError) eVarA.a());
        }
    }

    public final void e(Object obj, com.mbridge.msdk.newreward.a.b.b bVar) {
        if (this.f4767b == null) {
            return;
        }
        b bVar2 = new b();
        bVar2.a((f) ((Map) obj).get("command_type"));
        bVar2.a(obj);
        this.f4767b.a(bVar2, bVar);
    }

    public final Object f(Object obj, f fVar) {
        if (this.f4767b == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f4767b.a(bVar).a();
    }

    public final Object g(Object obj, f fVar) {
        if (this.f4767b == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f4767b.a(bVar).a();
    }

    public final Object h(Object obj, f fVar) {
        if (this.f4767b == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f4767b.a(bVar).a();
    }

    public final Object i(Object obj, f fVar) {
        if (this.f4767b == null) {
            this.f4767b = new com.mbridge.msdk.newreward.function.command.a.c();
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f4767b.a(bVar).a();
    }

    public final void f(Object obj) {
        b bVar = new b();
        bVar.a(obj);
        bVar.a(f.START_LOAD_CHECK);
        this.f4766a.a(bVar);
    }

    public final void b(Object obj, com.mbridge.msdk.newreward.a.b.b bVar) {
        if (this.f4766a == null) {
            return;
        }
        b bVar2 = new b();
        bVar2.a(obj);
        bVar2.a(f.SMART_LOAD);
        this.f4766a.a(bVar2, bVar);
    }

    public final Object e(Object obj, f fVar) {
        if (this.f4767b == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f4767b.a(bVar).a();
    }

    public final void b(a aVar) {
        if (this.f4767b == null) {
            this.f4767b = aVar;
        }
    }

    public final Object b(Object obj, f fVar) {
        if (this.f4766a == null) {
            return Boolean.FALSE;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f4766a.a(bVar).a();
    }

    public final Object c(Object obj, f fVar) {
        if (this.f4766a == null) {
            return Boolean.FALSE;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f4766a.a(bVar).a();
    }

    public final Object d(Object obj, f fVar) {
        if (this.f4767b == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f4767b.a(bVar).a();
    }

    public final void e(Object obj) {
        if (this.f4766a == null) {
            return;
        }
        b bVar = new b();
        bVar.a(obj);
        bVar.a(f.HANDLER_ALREADY_INSTALL_CAMPAIGN);
        this.f4766a.a(bVar);
    }

    public final void a(a aVar) {
        this.f4766a = aVar;
    }

    public final Object a(Object obj, f fVar) {
        if (this.f4766a == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(obj);
        bVar.a(fVar);
        return this.f4766a.a(bVar).a();
    }

    public final void c(Object obj, com.mbridge.msdk.newreward.a.b.b bVar) {
        if (this.f4766a == null) {
            return;
        }
        b bVar2 = new b();
        bVar2.a(obj);
        bVar2.a((f) ((Map) obj).get("command_type"));
        this.f4766a.a(bVar2, bVar);
    }

    public final void d(Object obj, com.mbridge.msdk.newreward.a.b.b bVar) {
        if (this.f4767b == null) {
            return;
        }
        b bVar2 = new b();
        bVar2.a(obj);
        bVar2.a((f) ((Map) obj).get("command_type"));
        this.f4767b.a(bVar2, bVar);
    }

    public final void a(Object obj, f fVar, com.mbridge.msdk.newreward.a.b.b bVar) {
        if (this.f4766a == null) {
            return;
        }
        b bVar2 = new b();
        bVar2.a(obj);
        bVar2.a(fVar);
        this.f4766a.a(bVar2, bVar);
    }

    public final void a(Object obj, com.mbridge.msdk.newreward.a.b.b bVar) {
        if (this.f4766a == null) {
            return;
        }
        b bVar2 = new b();
        bVar2.a(obj);
        bVar2.a(f.NORMAL_LOAD);
        this.f4766a.a(bVar2, bVar);
    }

    public final void a(Object obj) {
        if (this.f4766a == null) {
            return;
        }
        b bVar = new b();
        bVar.a(f.SHOW);
        bVar.a(obj);
        this.f4766a.a(bVar);
    }

    public final void a(Object obj, f fVar, Object obj2) {
        b bVar = new b();
        bVar.a(obj2);
        bVar.a(fVar);
        new com.mbridge.msdk.newreward.function.command.a.b(obj).a(bVar);
    }

    public final void a(Object obj, String str) {
        if (this.f4767b == null) {
            this.f4767b = new com.mbridge.msdk.newreward.function.command.a.c();
        }
        b bVar = new b();
        bVar.a(obj);
        this.f4767b.a(bVar, str);
    }
}
