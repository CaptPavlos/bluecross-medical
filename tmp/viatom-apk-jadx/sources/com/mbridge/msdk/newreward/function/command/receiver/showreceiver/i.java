package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.player.model.WebTemplateModel;
import com.mbridge.msdk.newreward.player.view.hybrid.MBWebView;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i implements com.mbridge.msdk.newreward.function.command.receiver.b {

    /* renamed from: d, reason: collision with root package name */
    private final String f4896d = "WebTemplateReceiver";

    /* renamed from: a, reason: collision with root package name */
    MBWebView f4893a = null;

    /* renamed from: b, reason: collision with root package name */
    WebTemplateModel f4894b = null;

    /* renamed from: c, reason: collision with root package name */
    Handler f4895c = new Handler(Looper.getMainLooper());

    @Override // com.mbridge.msdk.newreward.function.command.receiver.b
    public final void a(Object obj) {
        final String absolutePath;
        int iF;
        WebTemplateModel webTemplateModel;
        Map map = (Map) obj;
        if (map == null || map.isEmpty()) {
            return;
        }
        try {
            Object obj2 = map.get("web_resource_action");
            int iIntValue = obj2 instanceof Integer ? ((Integer) obj2).intValue() : 1;
            final ViewGroup viewGroup = (map.containsKey("parent_temple") && (map.get("parent_temple") instanceof ViewGroup)) ? (ViewGroup) map.get("parent_temple") : null;
            String str = (String) map.get("bridge_ids");
            final com.mbridge.msdk.newreward.a.e eVar = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
            com.mbridge.msdk.newreward.function.command.c cVar = (com.mbridge.msdk.newreward.function.command.c) map.get("command_manager");
            if (eVar == null) {
                return;
            }
            absolutePath = "";
            Iterator<com.mbridge.msdk.newreward.function.c.a.a> it = eVar.D().b().u().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                iF = TypedValues.Custom.TYPE_BOOLEAN;
                if (!zHasNext) {
                    break;
                }
                com.mbridge.msdk.newreward.function.c.a.a next = it.next();
                if (next.g().equals(str)) {
                    Object objA = next.c().a();
                    absolutePath = objA instanceof String ? (String) objA : "";
                    if (objA instanceof File) {
                        File file = (File) objA;
                        if (file.exists()) {
                            absolutePath = file.getAbsolutePath();
                        }
                    }
                    if (next.h() != null && next.h().getRewardTemplateMode() != null) {
                        iF = next.h().getRewardTemplateMode().f();
                    }
                }
            }
            if (TextUtils.isEmpty(absolutePath)) {
                if (iIntValue == 2) {
                    a(iF, cVar, eVar, viewGroup);
                    return;
                }
                return;
            }
            if (iIntValue == 1) {
                this.f4895c.post(new Runnable() { // from class: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MutableContextWrapper mutableContextWrapper = new MutableContextWrapper(com.mbridge.msdk.foundation.controller.c.m().c());
                        try {
                            i.this.f4893a = new MBWebView(mutableContextWrapper);
                            i.this.f4894b = new WebTemplateModel(null, eVar);
                            i.this.f4894b.setRenderType(2);
                            i iVar = i.this;
                            iVar.f4893a.setHybridCommunicator(iVar.f4894b);
                            i iVar2 = i.this;
                            iVar2.f4893a.setWebViewEventListener(iVar2.f4894b);
                            i.this.f4893a.loadUrl(absolutePath);
                            com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
                            eVar2.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                            eVar.z().a(eVar, eVar2.a(), "2000154");
                        } catch (Throwable unused) {
                            eVar.p(false);
                            i.this.f4893a = null;
                        }
                    }
                });
            }
            if (iIntValue == 2) {
                if (this.f4893a != null && (webTemplateModel = this.f4894b) != null) {
                    int renderStatus = webTemplateModel.getRenderStatus();
                    final String h5InitCallbackParameter = this.f4894b.getH5InitCallbackParameter();
                    if ((renderStatus == 2 || renderStatus == 3) && viewGroup != null) {
                        this.f4895c.post(new Runnable() { // from class: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i.2
                            /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
                            @Override // java.lang.Runnable
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public final void run() {
                                /*
                                    r4 = this;
                                    r0 = 0
                                    org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L17
                                    java.lang.String r2 = r2     // Catch: java.lang.Throwable -> L17
                                    r1.<init>(r2)     // Catch: java.lang.Throwable -> L17
                                    java.lang.String r2 = "showTransparent"
                                    int r2 = r1.optInt(r2)     // Catch: java.lang.Throwable -> L17
                                    java.lang.String r3 = "webfront"
                                    int r1 = r1.optInt(r3)     // Catch: java.lang.Throwable -> L15
                                    goto L23
                                L15:
                                    r1 = move-exception
                                    goto L19
                                L17:
                                    r1 = move-exception
                                    r2 = r0
                                L19:
                                    java.lang.String r3 = "WebTemplateReceiver"
                                    java.lang.String r1 = r1.getMessage()
                                    com.mbridge.msdk.foundation.tools.af.b(r3, r1)
                                    r1 = r0
                                L23:
                                    r3 = 1
                                    if (r2 != r3) goto L2d
                                    com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i r2 = com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i.this
                                    com.mbridge.msdk.newreward.player.view.hybrid.MBWebView r2 = r2.f4893a
                                    r2.setBackgroundColor(r0)
                                L2d:
                                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r0 = new com.mbridge.msdk.newreward.player.view.WebViewTemplate
                                    android.view.ViewGroup r2 = r3
                                    android.content.Context r2 = r2.getContext()
                                    r0.<init>(r2)
                                    com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i r2 = com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i.this
                                    com.mbridge.msdk.newreward.player.view.hybrid.MBWebView r2 = r2.f4893a
                                    r0.addWebView(r2, r1)
                                    android.view.ViewGroup r1 = r3
                                    r0.show(r1)
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i.AnonymousClass2.run():void");
                            }
                        });
                        return;
                    } else {
                        a(iF, cVar, eVar, viewGroup);
                        return;
                    }
                }
                a(iF, cVar, eVar, viewGroup);
            }
        } catch (Throwable th) {
            af.b("WebTemplateReceiver", th.getMessage());
        }
    }

    private void a(int i10, com.mbridge.msdk.newreward.function.command.c cVar, com.mbridge.msdk.newreward.a.e eVar, ViewGroup viewGroup) {
        if (cVar != null) {
            try {
                cVar.g(cVar.a("add_temple", Integer.valueOf(i10), "template_type", 17, "adapter_model", eVar, "parent_temple", viewGroup), com.mbridge.msdk.newreward.function.command.f.SHOW_ADD_TEMPLE);
            } catch (Throwable th) {
                af.b("WebTemplateReceiver", th.getMessage());
            }
        }
    }
}
