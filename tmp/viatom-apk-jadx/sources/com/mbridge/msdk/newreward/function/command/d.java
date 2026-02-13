package com.mbridge.msdk.newreward.function.command;

import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f4768a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, com.mbridge.msdk.newreward.a.e> f4769b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private c f4770c;

    private d() {
    }

    public static d a() {
        if (f4768a == null) {
            synchronized (d.class) {
                try {
                    if (f4768a == null) {
                        f4768a = new d();
                    }
                } finally {
                }
            }
        }
        return f4768a;
    }

    public final void b(String str) {
        this.f4769b.remove(str);
    }

    public final c b() {
        return this.f4770c;
    }

    public final void a(c cVar) {
        this.f4770c = cVar;
    }

    public final com.mbridge.msdk.newreward.a.e a(String str) {
        return this.f4769b.get(str);
    }

    public final void a(com.mbridge.msdk.newreward.a.e eVar) {
        if (this.f4769b.get(eVar.G()) == null) {
            this.f4769b.put(eVar.G(), eVar);
        }
    }
}
