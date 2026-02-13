package d0;

import a6.o;
import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.common.api.Status;
import i0.y;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public static final o f6769c = new o("RevokeAccessOperation", new String[0]);

    /* renamed from: a, reason: collision with root package name */
    public final String f6770a;

    /* renamed from: b, reason: collision with root package name */
    public final h0.i f6771b;

    public c(String str) {
        y.d(str);
        this.f6770a = str;
        this.f6771b = new h0.i(null);
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        o oVar = f6769c;
        Status status = Status.g;
        try {
            String str = this.f6770a;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 50);
            sb.append("https://accounts.google.com/o/oauth2/revoke?token=");
            sb.append(str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.e;
            } else {
                Log.e((String) oVar.f278c, ((String) oVar.f279d).concat("Unable to revoke access!"));
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(responseCode).length() + 15);
            sb2.append("Response Code: ");
            sb2.append(responseCode);
            oVar.b(sb2.toString(), new Object[0]);
        } catch (IOException e) {
            Log.e((String) oVar.f278c, ((String) oVar.f279d).concat("IOException when revoking access: ".concat(String.valueOf(e.toString()))));
        } catch (Exception e3) {
            Log.e((String) oVar.f278c, ((String) oVar.f279d).concat("Exception when revoking access: ".concat(String.valueOf(e3.toString()))));
        }
        this.f6771b.e(status);
    }
}
