package com.mbridge.msdk.foundation.same.e;

import android.annotation.SuppressLint;
import android.content.Context;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.ah;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    ThreadPoolExecutor f3684a;

    /* renamed from: b, reason: collision with root package name */
    HashMap<Long, a> f3685b;

    /* renamed from: c, reason: collision with root package name */
    WeakReference<Context> f3686c;

    @SuppressLint({"UseSparseArrays"})
    public b(Context context) {
        if (ah.a().a("c_t_l_t_p", true)) {
            this.f3684a = c.a();
        } else {
            if (ah.a().a("c_t_p_t_l", true)) {
                int iAvailableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
                this.f3684a = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } else {
                this.f3684a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            }
            this.f3684a.allowCoreThreadTimeOut(true);
        }
        this.f3685b = new HashMap<>();
        this.f3686c = new WeakReference<>(context);
    }

    private synchronized void b(final a aVar, final a.InterfaceC0029a interfaceC0029a) {
        this.f3685b.put(Long.valueOf(aVar.getId()), aVar);
        aVar.setOnStateChangeListener(new a.InterfaceC0029a() { // from class: com.mbridge.msdk.foundation.same.e.b.1
            @Override // com.mbridge.msdk.foundation.same.e.a.InterfaceC0029a
            public final void a(a.b bVar) {
                if (bVar == a.b.CANCEL || bVar == a.b.FINISH) {
                    b.this.f3685b.remove(Long.valueOf(aVar.getId()));
                } else if (bVar == a.b.RUNNING && b.this.f3686c.get() == null) {
                    b.this.a();
                }
                a.InterfaceC0029a interfaceC0029a2 = interfaceC0029a;
                if (interfaceC0029a2 != null) {
                    interfaceC0029a2.a(bVar);
                }
            }
        });
    }

    public final synchronized void a() {
        try {
            Iterator<Map.Entry<Long, a>> it = this.f3685b.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().cancel();
            }
            this.f3685b.clear();
        } catch (Exception unused) {
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void a(a aVar) {
        b(aVar, null);
        this.f3684a.execute(aVar);
    }

    public final void a(a aVar, a.InterfaceC0029a interfaceC0029a) {
        b(aVar, interfaceC0029a);
        this.f3684a.execute(aVar);
    }

    @SuppressLint({"UseSparseArrays"})
    public b(Context context, int i10) {
        if (ah.a().a("c_t_l_t_p", true)) {
            this.f3684a = c.a();
        } else {
            if (i10 == 0) {
                this.f3684a = new ThreadPoolExecutor(1, 5, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } else {
                this.f3684a = new ThreadPoolExecutor(i10, (i10 * 2) + 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            }
            this.f3684a.allowCoreThreadTimeOut(true);
        }
        this.f3685b = new HashMap<>();
        this.f3686c = new WeakReference<>(context);
    }
}
