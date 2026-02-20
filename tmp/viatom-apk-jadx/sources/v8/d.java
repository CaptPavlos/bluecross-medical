package v8;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import j$.util.DesugarCollections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final b[] f13214a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map f13215b;

    static {
        b bVar = new b(b.f13206i, "");
        z8.l lVar = b.f;
        b bVar2 = new b(lVar, ShareTarget.METHOD_GET);
        b bVar3 = new b(lVar, ShareTarget.METHOD_POST);
        z8.l lVar2 = b.g;
        b bVar4 = new b(lVar2, "/");
        b bVar5 = new b(lVar2, "/index.html");
        z8.l lVar3 = b.h;
        b bVar6 = new b(lVar3, "http");
        b bVar7 = new b(lVar3, "https");
        z8.l lVar4 = b.e;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, new b(lVar4, "200"), new b(lVar4, "204"), new b(lVar4, "206"), new b(lVar4, "304"), new b(lVar4, "400"), new b(lVar4, "404"), new b(lVar4, "500"), new b("accept-charset", ""), new b("accept-encoding", "gzip, deflate"), new b("accept-language", ""), new b("accept-ranges", ""), new b("accept", ""), new b("access-control-allow-origin", ""), new b("age", ""), new b("allow", ""), new b("authorization", ""), new b("cache-control", ""), new b("content-disposition", ""), new b("content-encoding", ""), new b("content-language", ""), new b("content-length", ""), new b("content-location", ""), new b("content-range", ""), new b("content-type", ""), new b("cookie", ""), new b("date", ""), new b(DownloadModel.ETAG, ""), new b("expect", ""), new b("expires", ""), new b(TypedValues.TransitionType.S_FROM, ""), new b("host", ""), new b("if-match", ""), new b("if-modified-since", ""), new b("if-none-match", ""), new b("if-range", ""), new b("if-unmodified-since", ""), new b("last-modified", ""), new b("link", ""), new b("location", ""), new b("max-forwards", ""), new b("proxy-authenticate", ""), new b("proxy-authorization", ""), new b("range", ""), new b("referer", ""), new b(ToolBar.REFRESH, ""), new b("retry-after", ""), new b("server", ""), new b("set-cookie", ""), new b("strict-transport-security", ""), new b("transfer-encoding", ""), new b("user-agent", ""), new b("vary", ""), new b("via", ""), new b("www-authenticate", "")};
        f13214a = bVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(bVarArr.length);
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            if (!linkedHashMap.containsKey(bVarArr[i10].f13207a)) {
                linkedHashMap.put(bVarArr[i10].f13207a, Integer.valueOf(i10));
            }
        }
        f13215b = DesugarCollections.unmodifiableMap(linkedHashMap);
    }

    public static void a(z8.l lVar) {
        int iE = lVar.e();
        for (int i10 = 0; i10 < iE; i10++) {
            byte bJ = lVar.j(i10);
            if (bJ >= 65 && bJ <= 90) {
                com.google.gson.internal.a.m("PROTOCOL_ERROR response malformed: mixed case name: ".concat(lVar.r()));
                return;
            }
        }
    }
}
