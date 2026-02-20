package com.mbridge.msdk.newreward.player.redirect;

import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.same.e.b;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.newreward.function.command.c;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class UrlReDirectController {
    private c commandManager;
    private b mLoader;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.player.redirect.UrlReDirectController$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$mbridge$msdk$newreward$player$redirect$RedirectType;

        static {
            int[] iArr = new int[RedirectType.values().length];
            $SwitchMap$com$mbridge$msdk$newreward$player$redirect$RedirectType = iArr;
            try {
                iArr[RedirectType.CLICK_URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$mbridge$msdk$newreward$player$redirect$RedirectType[RedirectType.NOTICE_URL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public UrlReDirectController() {
        this.mLoader = null;
        this.mLoader = new b(com.mbridge.msdk.foundation.controller.c.m().c());
    }

    private void reDirect(final String str) {
        this.mLoader.a(new a() { // from class: com.mbridge.msdk.newreward.player.redirect.UrlReDirectController.1
            @Override // com.mbridge.msdk.foundation.same.e.a
            public void runTask() throws Throwable {
                UrlReDirectController.this.realDoDirectUrl(str);
            }

            @Override // com.mbridge.msdk.foundation.same.e.a
            public void cancelTask() {
            }

            @Override // com.mbridge.msdk.foundation.same.e.a
            public void pauseTask(boolean z9) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realDoDirectUrl(String str) throws Throwable {
        Throwable th;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setRequestProperty(Command.HTTP_HEADER_USER_AGENT, ab.g());
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    String headerField = httpURLConnection.getHeaderField("Location");
                    if (headerField.startsWith("market:")) {
                        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().c(), headerField);
                    } else {
                        httpURLConnection.disconnect();
                        realDoDirectUrl(headerField);
                    }
                }
                httpURLConnection.disconnect();
            } catch (Exception unused) {
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnection == null) {
                    throw th;
                }
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
    }

    public void doReDirect(RedirectModel redirectModel) {
        int i10 = AnonymousClass2.$SwitchMap$com$mbridge$msdk$newreward$player$redirect$RedirectType[redirectModel.getRedirectType().ordinal()];
        if (i10 == 1) {
            reDirect(null);
        } else {
            if (i10 != 2) {
                return;
            }
            reDirect(null);
        }
    }

    public c getCommandManager() {
        return this.commandManager;
    }

    public void setCommandManager(c cVar) {
        this.commandManager = cVar;
    }
}
