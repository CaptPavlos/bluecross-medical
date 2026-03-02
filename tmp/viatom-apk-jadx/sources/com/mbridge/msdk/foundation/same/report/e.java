package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.BatchReportDao;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.o;
import com.mbridge.msdk.tracker.w;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3844a = "e";

    /* renamed from: b, reason: collision with root package name */
    private static String f3845b = "roas";

    /* renamed from: c, reason: collision with root package name */
    private static volatile e f3846c;

    /* renamed from: d, reason: collision with root package name */
    private AtomicInteger f3847d;
    private BatchReportDao e;
    private int f;
    private long g;
    private String h;

    /* renamed from: i, reason: collision with root package name */
    private volatile int f3848i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3849j;

    /* renamed from: k, reason: collision with root package name */
    private Executor f3850k = Executors.newSingleThreadExecutor();

    /* renamed from: l, reason: collision with root package name */
    private Handler f3851l;

    /* renamed from: m, reason: collision with root package name */
    private Stack<Long> f3852m;

    /* renamed from: n, reason: collision with root package name */
    private com.mbridge.msdk.tracker.m f3853n;

    private e() throws JSONException {
        com.mbridge.msdk.c.a aVarQ;
        this.f = 1;
        this.g = 0L;
        this.h = com.mbridge.msdk.foundation.same.net.e.d.f().F;
        this.f3848i = 0;
        this.f3849j = false;
        com.mbridge.msdk.c.g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(com.mbridge.msdk.c.h.a());
        if (gVarS != null && (aVarQ = gVarS.q()) != null) {
            this.f = aVarQ.a();
            this.g = aVarQ.c() * 1000;
            this.h = com.mbridge.msdk.foundation.same.net.e.d.f().F;
            this.f3848i = aVarQ.b();
            boolean z9 = aVarQ.d() == 1;
            this.f3849j = z9;
            if (z9 && this.f3848i != 1) {
                int iA = ah.a().a("bcp", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, ah.a().a("t_r_t", 1));
                if (iA != 0 && iA != 1) {
                    iA = 0;
                }
                this.f3853n = com.mbridge.msdk.tracker.m.a(f3845b, com.mbridge.msdk.foundation.controller.c.m().c(), new w.a().a(new d()).a(new m()).a(iA, iA == 1 ? new o(new l((byte) 2), com.mbridge.msdk.foundation.same.net.e.d.f().f3740k, com.mbridge.msdk.foundation.same.net.e.d.f().f3744o) : new o(new com.mbridge.msdk.tracker.network.toolbox.h(), com.mbridge.msdk.foundation.same.net.e.d.f().F, 0)).e(ah.a().a("t_m_e_t", 604800000)).a(ah.a().a("t_m_e_s", 50)).d(ah.a().a("t_m_r_c", 50)).b(ah.a().a("t_m_t", DefaultLoadControl.DEFAULT_MIN_BUFFER_MS)).c(ah.a().a("t_m_r_t_s", 1)).a());
                JSONObject jSONObjectA = c.a();
                try {
                    jSONObjectA.put("device_type", ab.w(com.mbridge.msdk.foundation.controller.c.m().c()) ? "pad" : "phone");
                    if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
                        jSONObjectA.put(com.mbridge.msdk.foundation.same.net.f.e.g, ab.n());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f3853n.a(jSONObjectA);
                this.f3853n.a();
            }
        }
        af.a(f3844a, "初始化批量上报： " + this.h + " " + this.f + " " + this.g + " " + this.f3848i);
        this.f3847d = new AtomicInteger(0);
        this.f3852m = new Stack<>();
        this.e = BatchReportDao.getInstance(com.mbridge.msdk.foundation.controller.c.m().c());
        HandlerThread handlerThread = new HandlerThread("mb_revenue_batch_report_thread");
        handlerThread.start();
        this.f3851l = new Handler(handlerThread.getLooper()) { // from class: com.mbridge.msdk.foundation.same.report.e.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) throws UnsupportedEncodingException {
                int i10 = message.what;
                if (i10 == 1) {
                    Bundle data = message.getData();
                    if (e.this.f3851l == null || e.this.e == null || data == null) {
                        return;
                    }
                    e.this.f3851l.removeMessages(2);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    ArrayList<BatchReportMessage> batchReportMessages = e.this.e.getBatchReportMessages(jCurrentTimeMillis, 2);
                    e.a(e.this, batchReportMessages, jCurrentTimeMillis);
                    e.this.f3847d.set(0);
                    String str = e.f3844a;
                    StringBuilder sb = new StringBuilder("超时上报触发了，需要上报的数据： ");
                    sb.append(batchReportMessages != null ? batchReportMessages.size() : 0);
                    af.a(str, sb.toString());
                    return;
                }
                if (i10 == 2) {
                    Bundle data2 = message.getData();
                    if (e.this.f3851l == null || e.this.e == null || data2 == null) {
                        return;
                    }
                    e.this.f3851l.removeMessages(1);
                    long j10 = data2.getLong("last_report_time");
                    ArrayList<BatchReportMessage> batchReportMessages2 = e.this.e.getBatchReportMessages(j10, 2);
                    e.a(e.this, batchReportMessages2, j10);
                    String str2 = e.f3844a;
                    StringBuilder sb2 = new StringBuilder("队列上报触发了，需要上报的数据： ");
                    sb2.append(batchReportMessages2 != null ? batchReportMessages2.size() : 0);
                    af.a(str2, sb2.toString());
                    return;
                }
                if (i10 == 3) {
                    Bundle data3 = message.getData();
                    if (data3 != null) {
                        e.b(e.this, data3.getParcelableArrayList("report_message"), data3.getLong("last_report_time"));
                        return;
                    }
                    return;
                }
                if (i10 != 4) {
                    return;
                }
                Bundle data4 = message.getData();
                if (e.this.f3851l == null || e.this.e == null || data4 == null || !e.this.f3849j) {
                    return;
                }
                e.this.f3851l.removeMessages(4);
                ArrayList<BatchReportMessage> batchReportMessages3 = e.this.e.getBatchReportMessages(System.currentTimeMillis(), 2);
                if (batchReportMessages3 != null && batchReportMessages3.size() > 0) {
                    for (int i11 = 0; i11 < batchReportMessages3.size(); i11++) {
                        BatchReportMessage batchReportMessage = batchReportMessages3.get(i11);
                        e.a(e.this, batchReportMessage.getReportMessage(), batchReportMessage.getTimestamp());
                    }
                }
                String str3 = e.f3844a;
                StringBuilder sb3 = new StringBuilder("切换上报lib，需要上报的数据： ");
                sb3.append(batchReportMessages3 != null ? batchReportMessages3.size() : 0);
                af.a(str3, sb3.toString());
            }
        };
    }

    public static /* synthetic */ void a(e eVar, String str) {
        eVar.e.addReportMessage(str, 2);
        Handler handler = eVar.f3851l;
        if (handler != null && !handler.hasMessages(1)) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            eVar.f3851l.sendMessageDelayed(messageObtain, eVar.g);
        }
        if (eVar.f3847d.incrementAndGet() < eVar.f || eVar.f3851l == null) {
            return;
        }
        Message messageObtain2 = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putLong("last_report_time", System.currentTimeMillis());
        messageObtain2.setData(bundle);
        messageObtain2.what = 2;
        eVar.f3851l.sendMessage(messageObtain2);
        eVar.f3847d.set(0);
    }

    public static /* synthetic */ void b(e eVar, final ArrayList arrayList, final long j10) throws UnsupportedEncodingException {
        if (arrayList == null || arrayList.size() <= 0) {
            af.a(f3844a, "需要上报的数据条数： 0");
            return;
        }
        af.a(f3844a, "需要上报的数据条数： " + arrayList.size());
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        if (contextC == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.net.f.e eVarA = i.a(contextC);
        eVarA.a(MBridgeConstans.APP_ID, com.mbridge.msdk.foundation.controller.c.m().k());
        eVarA.a("m_sdk", "msdk");
        eVarA.a("lqswt", String.valueOf(1));
        eVarA.a("device_type", ab.w(contextC) ? "pad" : "phone");
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
            eVarA.a(com.mbridge.msdk.foundation.same.net.f.e.g, ab.n());
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                BatchReportMessage batchReportMessage = (BatchReportMessage) arrayList.get(i10);
                if (batchReportMessage != null) {
                    sb.append(batchReportMessage.getReportMessage() + "&ts=" + batchReportMessage.getTimestamp());
                    if (i10 >= 0 && i10 < size - 1) {
                        sb.append("\n");
                    }
                }
            } catch (Throwable th) {
                af.b(f3844a, th.getMessage());
            }
        }
        try {
            String strEncode = URLEncoder.encode(sb.toString(), "utf-8");
            eVarA.a(DataSchemeDataSource.SCHEME_DATA, strEncode);
            af.a(f3844a, "需要批量上报的数据： " + strEncode);
            com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(com.mbridge.msdk.foundation.controller.c.m().c());
            eVar.a(0, "");
            aVar.post(0, eVar.h, eVarA, new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.e.2
                @Override // com.mbridge.msdk.foundation.same.report.e.b
                public final void a(String str) {
                    af.a(e.f3844a, "批量上报成功");
                    e.this.a(1, "");
                    try {
                        if (e.this.e != null) {
                            e.this.e.deleteBatchReportMessagesByTimestamp(j10);
                        }
                    } catch (Exception e) {
                        af.b(e.f3844a, e.getMessage());
                    }
                    synchronized (e.this.f3852m) {
                        e.this.f3852m.clear();
                    }
                }

                @Override // com.mbridge.msdk.foundation.same.report.e.b
                public final void b(String str) {
                    e eVar2;
                    androidx.constraintlayout.core.widgets.analyzer.a.E("批量上报失败： ", str, e.f3844a);
                    e.this.a(2, str);
                    synchronized (e.this.f3852m) {
                        try {
                            e.this.f3852m.add(Long.valueOf(j10));
                            if (e.this.e != null) {
                                e.this.e.updateMessagesReportState(arrayList);
                            }
                            if (e.this.f3852m.size() >= 5) {
                                af.a(e.f3844a, "批量上报失败，上报失败的数据超过阈值");
                                try {
                                    try {
                                        e.this.f3852m.pop();
                                        long jLongValue = ((Long) e.this.f3852m.pop()).longValue();
                                        e.this.f3852m.clear();
                                        if (e.this.e != null) {
                                            e.this.e.deleteBatchReportMessagesByTimestamp(jLongValue);
                                        }
                                        eVar2 = e.this;
                                    } catch (Exception e) {
                                        af.b(e.f3844a, e.getMessage());
                                        eVar2 = e.this;
                                    }
                                    eVar2.f3852m.clear();
                                } catch (Throwable th2) {
                                    e.this.f3852m.clear();
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
            }, "roas", ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        } catch (Exception e) {
            af.b(f3844a, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, String str) {
        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
        eVar.a(MRAIDCommunicatorUtil.KEY_STATE, Integer.valueOf(i10));
        if (i10 == 2) {
            eVar.a("reason", str);
        }
        com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
        cVar.a("m_ad_rev_s_s", eVar);
        com.mbridge.msdk.foundation.same.report.d.d.a().a("m_ad_rev_s_s", cVar);
    }

    public static synchronized e a() {
        try {
            if (f3846c == null) {
                f3846c = new e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3846c;
    }

    public final synchronized void a(final String str) {
        try {
            if (this.f3848i == 1) {
                return;
            }
            Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.e.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (e.this.e == null) {
                        return;
                    }
                    af.a(e.f3844a, "接收到上报数据： " + str);
                    boolean z9 = e.this.f3849j;
                    e eVar = e.this;
                    if (!z9) {
                        if (eVar.f3848i != 1) {
                            e.a(e.this, str);
                        }
                    } else {
                        e.a(eVar, str, 0L);
                        if (((Integer) an.a(com.mbridge.msdk.foundation.controller.c.m().c(), "roas_use_event", 0)).intValue() == 0) {
                            an.b(com.mbridge.msdk.foundation.controller.c.m().c(), "roas_use_event", 1);
                            e.this.f3851l.sendEmptyMessage(4);
                        }
                    }
                }
            };
            com.mbridge.msdk.foundation.controller.d.a();
            Executor executor = this.f3850k;
            if (executor != null) {
                executor.execute(runnable);
            } else {
                runnable.run();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static /* synthetic */ void a(e eVar, ArrayList arrayList, long j10) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Message messageObtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("report_message", arrayList);
        bundle.putLong("last_report_time", j10);
        messageObtain.setData(bundle);
        messageObtain.what = 3;
        eVar.f3851l.sendMessage(messageObtain);
    }

    public static /* synthetic */ void a(e eVar, String str, long j10) {
        if (eVar.f3853n != null) {
            com.mbridge.msdk.tracker.e eVar2 = new com.mbridge.msdk.tracker.e("roas");
            eVar2.a(true);
            if (j10 != 0) {
                eVar2.a(j10);
            }
            eVar2.b(1);
            try {
                eVar2.a(eVar.b(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
            eVar.f3853n.a(eVar2);
        }
    }

    private JSONObject b(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str2 : str.split("&")) {
                    String[] strArrSplit = str2.split("=");
                    if (strArrSplit.length == 2) {
                        jSONObject.put(strArrSplit[0], strArrSplit[1]);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return jSONObject;
            }
        }
        return jSONObject;
    }

    public final void b() {
        Handler handler = this.f3851l;
        if (handler == null || handler.hasMessages(1) || this.f3848i == 1 || this.f3849j) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        this.f3851l.sendMessageDelayed(messageObtain, 5000L);
    }
}
