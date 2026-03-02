package com.mbridge.msdk.tracker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class r {

    /* renamed from: a, reason: collision with root package name */
    private final c f5502a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5503b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5504c;

    /* renamed from: d, reason: collision with root package name */
    private final int f5505d;
    private final k e;

    /* renamed from: i, reason: collision with root package name */
    private Handler f5506i;
    private final AtomicInteger f = new AtomicInteger(0);
    private final AtomicInteger g = new AtomicInteger(0);
    private final Object h = new Object();

    /* renamed from: j, reason: collision with root package name */
    private boolean f5507j = true;

    /* renamed from: k, reason: collision with root package name */
    private long f5508k = 0;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f5509l = false;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f5510m = false;

    public r(k kVar) {
        this.f5502a = kVar.g();
        this.f5503b = kVar.l();
        this.f5504c = kVar.m();
        this.f5505d = kVar.n();
        this.e = kVar;
    }

    public static /* synthetic */ void a(r rVar) {
        if (com.mbridge.msdk.tracker.a.f5328a && com.mbridge.msdk.e.e.f3311b) {
            return;
        }
        int iB = rVar.f5502a.b();
        if (com.mbridge.msdk.tracker.a.f5328a) {
            Log.d("TrackManager", rVar.e.c() + " 删除无效数据的数量 = " + iB + " 当前剩余事件数 = " + rVar.g.addAndGet(0) + " 数据库中剩余事件数 = " + rVar.f5502a.a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(r rVar, List list) {
        if (y.a((List<?>) list)) {
            return;
        }
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!y.a(iVar)) {
                Object[] objArr = !iVar.b() && iVar.d() >= rVar.f5505d;
                boolean z9 = !iVar.a() && iVar.g() < System.currentTimeMillis();
                if (objArr == true || z9) {
                    iVar.b(-1);
                } else {
                    iVar.a(iVar.d() + (y.a(rVar.e.e()) ? 1 : 0));
                    iVar.b(3);
                    i10++;
                }
            }
        }
        rVar.f5502a.c((List<i>) list);
        rVar.g.addAndGet(i10);
    }

    public static /* synthetic */ void e(r rVar) {
        if (rVar.e.t()) {
            List<i> listA = rVar.f5502a.a(rVar.f5503b);
            if (y.a((List<?>) listA)) {
                if (com.mbridge.msdk.tracker.a.f5328a) {
                    Log.d("TrackManager", rVar.e.c() + " report: 没有可以上报的数据");
                    return;
                }
                return;
            }
            rVar.f5502a.a(listA);
            int size = listA.size();
            rVar.g.addAndGet(-size);
            boolean zP = false;
            if (com.mbridge.msdk.tracker.a.f5328a) {
                Log.d("TrackManager", rVar.e.c() + " report: 上报的数量 = " + size + " 当前剩余事件数 = " + rVar.g.addAndGet(0) + " 数据库中剩余事件数 = " + rVar.f5502a.a());
            }
            try {
                zP = rVar.e.p();
            } catch (IllegalStateException e) {
                if (com.mbridge.msdk.tracker.a.f5328a) {
                    Log.e("TrackManager", rVar.e.c() + " report environment check failed ", e);
                }
            }
            if (!zP) {
                if (com.mbridge.msdk.tracker.a.f5328a) {
                    Log.e("TrackManager", rVar.e.c() + " report 失败，请检查 TrackConfig 配置是否正确");
                    return;
                }
                return;
            }
            n nVarQ = rVar.e.q();
            nVarQ.a(new a(rVar.f5506i, rVar));
            Map<String, String> map = new HashMap<>();
            try {
                map = rVar.e.j().a(rVar.e.k(), listA, rVar.e.f());
            } catch (Exception e3) {
                if (com.mbridge.msdk.tracker.a.f5328a) {
                    Log.e("TrackManager", rVar.e.c() + " report decorate request params failed ", e3);
                }
            }
            nVarQ.a(new s(listA), map, y.b(listA));
        }
    }

    public static /* synthetic */ void i(r rVar) {
        rVar.f.set(0);
    }

    public static /* synthetic */ int j(r rVar) {
        return rVar.f.getAndIncrement();
    }

    public final void c() {
        synchronized (this.h) {
            try {
                if (!this.f5509l) {
                    this.f5509l = true;
                    this.f5502a.c();
                }
                if (!this.f5510m) {
                    this.f5510m = true;
                    this.g.addAndGet(this.f5502a.a());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        this.g.incrementAndGet();
    }

    public final boolean f() {
        return this.f5507j;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final r f5513a;

        public b(Looper looper, r rVar) {
            super(looper);
            this.f5513a = rVar;
        }

        private void a(String str) {
            Log.d("TrackManager", this.f5513a.e.c() + " " + str + this.f5513a.g.addAndGet(0) + " 数据库记录数：" + this.f5513a.f5502a.a());
        }

        private void b() {
            try {
                removeMessages(1);
                removeMessages(6);
                removeMessages(2);
                removeMessages(3);
            } catch (Exception e) {
                if (com.mbridge.msdk.tracker.a.f5328a) {
                    Log.e("TrackManager", this.f5513a.e.c() + " removeMessages failed ", e);
                }
            }
            if (this.f5513a.f()) {
                return;
            }
            try {
                sendMessageDelayed(Message.obtain(this, 1), y.a(this.f5513a.f.get(), this.f5513a.f5508k, this.f5513a.f5504c));
            } catch (Exception e3) {
                if (com.mbridge.msdk.tracker.a.f5328a) {
                    Log.e("TrackManager", this.f5513a.e.c() + " sendMessageDelayed failed ", e3);
                }
            }
        }

        @Override // android.os.Handler
        public final void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            int i10 = message.what;
            if (i10 == 2 || i10 == 3) {
                b();
                if (com.mbridge.msdk.tracker.a.f5328a) {
                    a("触发上报（report result）当前 Event 数量：");
                }
                a();
                return;
            }
            if (i10 == 5) {
                if (com.mbridge.msdk.tracker.a.f5328a) {
                    a("触发删除 当前 Event 数量：");
                }
                r.a(this.f5513a);
                sendMessageDelayed(Message.obtain(this, 5), 120000L);
                return;
            }
            if (i10 != 6) {
                if (i10 != 7) {
                    b();
                    if (com.mbridge.msdk.tracker.a.f5328a) {
                        a("触发上报（timer）当前 Event 数量：");
                    }
                    a();
                    return;
                }
                this.f5513a.c();
                b();
                if (com.mbridge.msdk.tracker.a.f5328a) {
                    a("触发上报（flush）当前 Event 数量：");
                }
                a();
                return;
            }
            Object obj = message.obj;
            e eVar = obj instanceof e ? (e) obj : null;
            if (com.mbridge.msdk.tracker.a.f5328a && !y.a(eVar)) {
                a(androidx.constraintlayout.core.widgets.analyzer.a.x("收到 Event( ", eVar.a(), " )，当前 Event 数量："));
            }
            if ((y.b(eVar) && eVar.c() == 1) || this.f5513a.e()) {
                b();
                if (com.mbridge.msdk.tracker.a.f5328a) {
                    a("触发上报（notice check）当前 Event 数量：");
                }
                a();
            }
        }

        private synchronized void a() {
            try {
                r.e(this.f5513a);
            } catch (Exception e) {
                if (com.mbridge.msdk.tracker.a.f5328a) {
                    Log.e("TrackManager", this.f5513a.e.c() + " report failed ", e);
                }
            }
        }
    }

    public final void a() {
        HandlerThread handlerThread = new HandlerThread("report_timer");
        handlerThread.start();
        b bVar = new b(handlerThread.getLooper(), this);
        this.f5506i = bVar;
        bVar.sendMessageDelayed(Message.obtain(bVar, 5), 5000L);
        Handler handler = this.f5506i;
        handler.sendMessageDelayed(Message.obtain(handler, 1), this.f5504c);
        this.f5507j = false;
    }

    public final void a(e eVar) {
        Handler handler = this.f5506i;
        handler.sendMessage(Message.obtain(handler, 6, eVar));
    }

    public static /* synthetic */ void a(r rVar, List list) {
        if (y.a((List<?>) list)) {
            return;
        }
        rVar.f5502a.b((List<i>) list);
    }

    public final void b() {
        this.f5506i.removeMessages(1);
        Handler handler = this.f5506i;
        handler.sendMessage(Message.obtain(handler, 7));
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a implements q {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f5511a;

        /* renamed from: b, reason: collision with root package name */
        private final r f5512b;

        public a(Handler handler, r rVar) {
            this.f5511a = handler;
            this.f5512b = rVar;
        }

        @Override // com.mbridge.msdk.tracker.q
        public final void a(s sVar, int i10, String str) {
            r.b(this.f5512b, sVar.a());
            this.f5512b.f5508k = System.currentTimeMillis();
            int iJ = r.j(this.f5512b);
            if (iJ <= 10) {
                Handler handler = this.f5511a;
                handler.sendMessageDelayed(Message.obtain(handler, 3), iJ * 1000);
            }
            if (com.mbridge.msdk.tracker.a.f5328a) {
                Log.d("TrackManager", this.f5512b.e.c() + " report failed " + sVar.a().size() + " 剩余事件数：" + this.f5512b.g.addAndGet(0) + " 个，数据库记录数：" + this.f5512b.f5502a.a() + " 个 连续失败次数： " + iJ);
            }
        }

        @Override // com.mbridge.msdk.tracker.q
        public final void a(s sVar) {
            r.a(this.f5512b, sVar.a());
            r.i(this.f5512b);
            this.f5512b.f5508k = 0L;
            if (this.f5512b.e()) {
                Handler handler = this.f5511a;
                handler.sendMessage(Message.obtain(handler, 2));
            }
            if (com.mbridge.msdk.tracker.a.f5328a) {
                Log.d("TrackManager", this.f5512b.e.c() + " report success " + sVar.a().size() + " 剩余事件数：" + this.f5512b.g.addAndGet(0) + " 个，数据库记录数：" + this.f5512b.f5502a.a() + " 个");
            }
        }
    }

    public final boolean e() {
        return this.g.addAndGet(0) >= this.f5503b;
    }
}
