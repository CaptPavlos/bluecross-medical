package o2;

import android.util.Base64OutputStream;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11676a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f11677b;

    public /* synthetic */ c(d dVar, int i10) {
        this.f11676a = i10;
        this.f11677b = dVar;
    }

    private final Object a() {
        String string;
        d dVar = this.f11677b;
        synchronized (dVar) {
            try {
                i iVar = (i) dVar.f11678a.get();
                ArrayList arrayListC = iVar.c();
                iVar.b();
                JSONArray jSONArray = new JSONArray();
                for (int i10 = 0; i10 < arrayListC.size(); i10++) {
                    a aVar = (a) arrayListC.get(i10);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", aVar.f11672a);
                    jSONObject.put("dates", new JSONArray((Collection) aVar.f11673b));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put("version", "2");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                    try {
                        gZIPOutputStream.write(jSONObject2.toString().getBytes(C.UTF8_NAME));
                        gZIPOutputStream.close();
                        base64OutputStream.close();
                        string = byteArrayOutputStream.toString(C.UTF8_NAME);
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f11676a) {
            case 0:
                return a();
            default:
                d dVar = this.f11677b;
                synchronized (dVar) {
                    ((i) dVar.f11678a.get()).k(System.currentTimeMillis(), ((y2.b) dVar.f11680c.get()).a());
                }
                return null;
        }
    }
}
