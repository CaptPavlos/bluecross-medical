package r5;

import android.app.Activity;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.uptodown.R;
import h5.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import l4.n5;
import org.json.JSONException;
import org.json.JSONObject;
import p4.j0;
import p4.m0;
import r0.f;
import r7.g;
import r7.s;
import r7.u0;
import r7.y;
import w3.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12380a;

    /* renamed from: b, reason: collision with root package name */
    public Object f12381b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f12382c;

    public a(i iVar, WebView webView, String str) {
        this.f12380a = 6;
        this.f12381b = webView;
        this.f12382c = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException, IOException {
        t1.c cVar;
        n5 n5Var;
        int i10;
        byte[] bArr;
        FileInputStream fileInputStream;
        OutputStream outputStream;
        int iAvailable;
        int i11;
        int i12;
        long j10;
        n5 n5Var2;
        String string;
        int i13 = this.f12380a;
        long j11 = 0;
        int i14 = 1;
        int i15 = 0;
        Object obj = this.f12382c;
        switch (i13) {
            case 0:
                b bVar = (b) obj;
                List<Fragment> fragments = bVar.getSupportFragmentManager().getFragments();
                fragments.getClass();
                if (fragments.size() > 0) {
                    Fragment fragment = fragments.get(0);
                    String string2 = bVar.getString(R.string.tv_msg_download_complete, ((q) this.f12381b).f8709n);
                    string2.getClass();
                    Toast.makeText(fragment.getContext(), string2, 1).show();
                    break;
                }
                break;
            case 1:
                ((g) obj).B((u0) this.f12381b);
                break;
            case 2:
                ((g) this.f12381b).B((s7.c) obj);
                break;
            case 3:
                File file = (File) this.f12381b;
                t1.c cVar2 = (t1.c) obj;
                if (file != null) {
                    try {
                        n5 n5Var3 = (n5) cVar2.f12751b;
                        n5Var = (n5) cVar2.f12751b;
                        n5Var3.getClass();
                        Activity activity = o4.b.g;
                        if (activity != null && (activity instanceof m0)) {
                            m0 m0Var = (m0) activity;
                            m0Var.runOnUiThread(new j0(m0Var, i15));
                        }
                        i10 = 8192;
                        bArr = new byte[8192];
                        fileInputStream = new FileInputStream(file);
                        Socket socket = ((v4.a) cVar2.f12752c).e;
                        socket.getClass();
                        outputStream = socket.getOutputStream();
                        iAvailable = fileInputStream.available();
                        i11 = 0;
                        i12 = 0;
                    } catch (Exception e) {
                        e = e;
                        cVar = cVar2;
                    }
                    while (true) {
                        int i16 = fileInputStream.read(bArr, i15, i10);
                        if (i16 <= 0) {
                            cVar = cVar2;
                            n5 n5Var4 = n5Var;
                            n5Var4.getClass();
                            Activity activity2 = o4.b.g;
                            if (activity2 != null && (activity2 instanceof m0)) {
                                m0 m0Var2 = (m0) activity2;
                                m0Var2.runOnUiThread(new androidx.core.content.res.a(m0Var2, 100, 3));
                            }
                            fileInputStream.close();
                            outputStream.flush();
                            n5Var4.getClass();
                            Activity activity3 = o4.b.g;
                            if (activity3 == null || !(activity3 instanceof m0)) {
                                o4.b.f11722v = true;
                            } else {
                                m0 m0Var3 = (m0) activity3;
                                m0Var3.runOnUiThread(new j0(m0Var3, i14));
                                f.n(null);
                            }
                            v4.a aVar = o4.b.f11721u;
                            aVar.getClass();
                            aVar.f13126b.o();
                            break;
                        } else {
                            outputStream.write(bArr, i15, i16);
                            i11 += i16;
                            if (iAvailable > 0) {
                                n5Var2 = n5Var;
                                cVar = cVar2;
                                int i17 = (int) ((i11 * 100.0d) / iAvailable);
                                if (i17 <= i12 + 5) {
                                    try {
                                        j10 = j11;
                                        if (System.currentTimeMillis() > j10 + 1000 && i17 > i12) {
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                    }
                                }
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                n5Var2.getClass();
                                Activity activity4 = o4.b.g;
                                if (activity4 != null && (activity4 instanceof m0)) {
                                    m0 m0Var4 = (m0) activity4;
                                    m0Var4.runOnUiThread(new androidx.core.content.res.a(m0Var4, i17, 3));
                                }
                                j11 = jCurrentTimeMillis;
                                i12 = i17;
                                n5Var = n5Var2;
                                cVar2 = cVar;
                                i15 = 0;
                                i10 = 8192;
                            } else {
                                j10 = j11;
                                cVar = cVar2;
                                n5Var2 = n5Var;
                            }
                            n5Var = n5Var2;
                            cVar2 = cVar;
                            j11 = j10;
                            i15 = 0;
                            i10 = 8192;
                        }
                        e = e3;
                        if (e.getMessage() == null) {
                            ((n5) cVar.f12751b).m0("Exception");
                            break;
                        } else {
                            n5 n5Var5 = (n5) cVar.f12751b;
                            String message = e.getMessage();
                            message.getClass();
                            n5Var5.m0(message);
                            break;
                        }
                    }
                }
                break;
            case 4:
                t1.c cVar3 = (t1.c) obj;
                if (t1.c.b(cVar3, "resolveService:".concat((String) this.f12381b))) {
                    ((v4.a) cVar3.f12752c).f13126b.o();
                    break;
                }
                break;
            case 5:
                t1.c cVar4 = (t1.c) obj;
                u4.c cVar5 = (u4.c) this.f12381b;
                try {
                    JSONObject jSONObject = new JSONObject();
                    String str = cVar5.f12899b;
                    if (str != null) {
                        jSONObject.put(RewardPlus.NAME, str);
                    }
                    String str2 = cVar5.f12900c;
                    if (str2 != null) {
                        jSONObject.put("sha256", str2);
                    }
                    String str3 = cVar5.f12901d;
                    if (str3 != null) {
                        jSONObject.put(RewardPlus.ICON, str3);
                    }
                    long j12 = cVar5.e;
                    if (j12 > 0) {
                        jSONObject.put("size", j12);
                    }
                    String str4 = cVar5.f;
                    if (str4 != null) {
                        jSONObject.put("senderDeviceName", str4);
                    }
                    string = jSONObject.toString(2);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                    string = null;
                }
                if (t1.c.b(cVar4, string)) {
                    ((n5) cVar4.f12751b).getClass();
                    v4.a aVar2 = o4.b.f11721u;
                    aVar2.getClass();
                    c2.d dVar = aVar2.f13126b;
                    ((v4.a) dVar.f1643d).f = cVar5;
                    dVar.o();
                    break;
                }
                break;
            case 6:
                i.b((WebView) this.f12381b, (String) obj);
                break;
            default:
                w7.g gVar = (w7.g) obj;
                s sVar = gVar.f13535b;
                while (true) {
                    try {
                        ((Runnable) this.f12381b).run();
                    } catch (Throwable th) {
                        y.o(th, w6.i.f13523a);
                    }
                    Runnable runnableL = gVar.l();
                    if (runnableL != null) {
                        this.f12381b = runnableL;
                        i15++;
                        if (i15 >= 16 && sVar.isDispatchNeeded(gVar)) {
                            sVar.dispatch(gVar, this);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                break;
        }
    }

    public /* synthetic */ a(Object obj, Object obj2, int i10, boolean z9) {
        this.f12380a = i10;
        this.f12381b = obj;
        this.f12382c = obj2;
    }

    public /* synthetic */ a(int i10, Object obj, Object obj2) {
        this.f12380a = i10;
        this.f12382c = obj;
        this.f12381b = obj2;
    }
}
