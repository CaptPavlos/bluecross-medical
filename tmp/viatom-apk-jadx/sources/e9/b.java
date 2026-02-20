package e9;

import android.graphics.BitmapFactory;
import com.google.android.gms.internal.measurement.a4;
import g7.p;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import s6.w;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7980a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7981b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(String str, w6.c cVar, int i10) {
        super(2, cVar);
        this.f7980a = i10;
        this.f7981b = str;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f7980a) {
            case 0:
                return new b(this.f7981b, cVar, 0);
            default:
                return new b(this.f7981b, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w6.c cVar = (w6.c) obj2;
        switch (this.f7980a) {
            case 0:
                return new b(this.f7981b, cVar, 0).invokeSuspend(w.f12711a);
            default:
                return new b(this.f7981b, cVar, 1).invokeSuspend(w.f12711a);
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws IOException {
        int i10 = this.f7980a;
        String str = this.f7981b;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
                if (uRLConnectionOpenConnection == null) {
                    androidx.window.layout.c.k("null cannot be cast to non-null type java.net.HttpURLConnection");
                    return null;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(((HttpURLConnection) uRLConnectionOpenConnection).getInputStream()));
                try {
                    StringWriter stringWriter = new StringWriter();
                    char[] cArr = new char[8192];
                    for (int i11 = bufferedReader.read(cArr); i11 >= 0; i11 = bufferedReader.read(cArr)) {
                        stringWriter.write(cArr, 0, i11);
                    }
                    String string = stringWriter.toString();
                    string.getClass();
                    bufferedReader.close();
                    return string;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        a4.j(bufferedReader, th);
                        throw th2;
                    }
                }
            default:
                s6.a.e(obj);
                return BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        }
    }
}
