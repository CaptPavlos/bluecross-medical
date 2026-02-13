package com.mbridge.msdk.reward.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.reward.b.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final a f5277a;

    public b(a aVar) {
        super(Looper.getMainLooper());
        this.f5277a = aVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        Object obj = message.obj;
        com.mbridge.msdk.foundation.same.report.d.c cVarA = this.f5277a.a(message);
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListE = this.f5277a.e();
        List<CampaignEx> listF = this.f5277a.f();
        com.mbridge.msdk.reward.adapter.c cVarG = this.f5277a.g();
        boolean zH = this.f5277a.h();
        String strJ = this.f5277a.j();
        String strI = this.f5277a.i();
        a.c cVarK = this.f5277a.k();
        InterVideoOutListener interVideoOutListenerL = this.f5277a.l();
        boolean zM = this.f5277a.m();
        MBridgeIds mBridgeIdsN = this.f5277a.n();
        boolean zO = this.f5277a.o();
        switch (i10) {
            case 8:
                if (copyOnWriteArrayListE != null && copyOnWriteArrayListE.size() > 0) {
                    boolean z9 = (listF == null || listF.size() <= 0) ? false : !TextUtils.isEmpty(listF.get(0).getCMPTEntryUrl());
                    int nscpt = copyOnWriteArrayListE.get(0).getNscpt();
                    if (cVarG != null && cVarG.a(copyOnWriteArrayListE, z9, nscpt)) {
                        if (cVarK != null && zH) {
                            cVarK.a(strJ, strI, cVarA);
                            break;
                        }
                    } else if (cVarK != null && zH) {
                        com.mbridge.msdk.videocommon.a.c(strI);
                        com.mbridge.msdk.videocommon.a.a();
                        com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880010, "load timeout");
                        if (cVarA != null) {
                            cVarA.a(bVarB);
                        }
                        cVarK.a(bVarB, cVarA);
                        break;
                    }
                }
                break;
            case 9:
                if (interVideoOutListenerL != null && zH) {
                    if (zM) {
                        this.f5277a.c();
                    }
                    interVideoOutListenerL.onVideoLoadSuccess(mBridgeIdsN);
                    break;
                }
                break;
            case 16:
            case 18:
                if (interVideoOutListenerL != null && zH) {
                    String string = obj instanceof String ? obj.toString() : "";
                    if (cVarA != null && cVarA.o() != null) {
                        string = cVarA.o().b();
                    }
                    com.mbridge.msdk.videocommon.a.c(strI);
                    com.mbridge.msdk.videocommon.a.a();
                    if (zM) {
                        this.f5277a.c();
                    }
                    interVideoOutListenerL.onVideoLoadFail(mBridgeIdsN, string);
                    break;
                }
                break;
            case 17:
                if (interVideoOutListenerL != null && zH) {
                    if (zM) {
                        this.f5277a.c();
                    }
                    interVideoOutListenerL.onLoadSuccess(mBridgeIdsN);
                    break;
                }
                break;
            case 1001001:
                this.f5277a.a(false, d.a().a(0, zO ? 287 : 94, strI, true, 1));
                break;
            case 1001002:
                if (cVarG != null) {
                    if (!cVarG.b()) {
                        if (!cVarG.h(false)) {
                            if (cVarG.h(true)) {
                                if (!cVarG.b()) {
                                    cVarG.g(true);
                                    break;
                                } else if (cVarK != null) {
                                    cVarG.f(true);
                                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListD = cVarG.d();
                                    if (copyOnWriteArrayListD != null && copyOnWriteArrayListD.size() == 0) {
                                        copyOnWriteArrayListD = cVarG.e();
                                    }
                                    this.f5277a.a(copyOnWriteArrayListD);
                                    com.mbridge.msdk.foundation.same.report.d.c cVarA2 = this.f5277a.a(copyOnWriteArrayListD, cVarA);
                                    if (cVarA2 != null) {
                                        cVarA2.b(copyOnWriteArrayListD);
                                    }
                                    cVarK.b(strJ, strI, cVarA2);
                                    break;
                                }
                            }
                        } else if (!cVarG.b()) {
                            cVarG.g(false);
                            if (cVarG.h(true)) {
                                if (!cVarG.b()) {
                                    cVarG.g(true);
                                    break;
                                } else if (cVarK != null) {
                                    cVarG.f(true);
                                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListD2 = cVarG.d();
                                    if (copyOnWriteArrayListD2 != null && copyOnWriteArrayListD2.size() == 0) {
                                        copyOnWriteArrayListD2 = cVarG.e();
                                    }
                                    this.f5277a.a(copyOnWriteArrayListD2);
                                    com.mbridge.msdk.foundation.same.report.d.c cVarA3 = this.f5277a.a(copyOnWriteArrayListD2, cVarA);
                                    if (cVarA3 != null) {
                                        cVarA3.b(copyOnWriteArrayListD2);
                                    }
                                    cVarK.b(strJ, strI, cVarA3);
                                    break;
                                }
                            }
                        } else if (cVarK != null) {
                            cVarG.f(false);
                            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListD3 = cVarG.d();
                            if (copyOnWriteArrayListD3 != null && copyOnWriteArrayListD3.size() == 0) {
                                copyOnWriteArrayListD3 = cVarG.e();
                            }
                            this.f5277a.a(copyOnWriteArrayListD3);
                            com.mbridge.msdk.foundation.same.report.d.c cVarA4 = this.f5277a.a(copyOnWriteArrayListD3, cVarA);
                            if (cVarA4 != null) {
                                cVarA4.b(copyOnWriteArrayListD3);
                            }
                            cVarK.b(strJ, strI, cVarA4);
                            break;
                        }
                    } else if (cVarK != null) {
                        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListD4 = cVarG.d();
                        if (copyOnWriteArrayListD4 != null && copyOnWriteArrayListD4.size() == 0) {
                            copyOnWriteArrayListD4 = cVarG.e();
                        }
                        this.f5277a.a(copyOnWriteArrayListD4);
                        com.mbridge.msdk.foundation.same.report.d.c cVarA5 = this.f5277a.a(copyOnWriteArrayListD4, cVarA);
                        if (cVarA5 != null) {
                            cVarA5.b(copyOnWriteArrayListD4);
                        }
                        cVarK.b(strJ, strI, cVarA5);
                        break;
                    }
                }
                break;
        }
    }
}
