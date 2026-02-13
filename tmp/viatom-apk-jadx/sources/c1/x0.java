package c1;

import android.os.Bundle;
import androidx.browser.trusted.sharing.ShareTarget;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1559a;

    /* renamed from: b, reason: collision with root package name */
    public long f1560b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1561c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1562d;
    public Object e;

    public x0() {
        this.f1559a = 2;
        this.f1561c = "SwA" + System.currentTimeMillis() + "SwA";
    }

    public static void g(Exception exc, h5.p0 p0Var, String str) {
        p0Var.f8698c = str;
        if (exc.getMessage() != null) {
            p0Var.f8696a = exc.getMessage();
        } else {
            p0Var.f8696a = exc.toString();
        }
    }

    public static x0 l(v vVar) {
        String str = vVar.f1505a;
        String str2 = vVar.f1507c;
        return new x0(vVar.f1508d, vVar.f1506b.e(), str, str2);
    }

    public void a(String str, byte[] bArr) throws IOException {
        try {
            OutputStream outputStream = (OutputStream) this.e;
            outputStream.getClass();
            String str2 = "--" + ((String) this.f1561c) + "\r\n";
            Charset charset = o7.a.f11749a;
            byte[] bytes = str2.getBytes(charset);
            bytes.getClass();
            outputStream.write(bytes);
            OutputStream outputStream2 = (OutputStream) this.e;
            outputStream2.getClass();
            byte[] bytes2 = ("Content-Disposition: form-data; name=\"zipped\"; filename=\"" + str + "\"\r\n").getBytes(charset);
            bytes2.getClass();
            outputStream2.write(bytes2);
            OutputStream outputStream3 = (OutputStream) this.e;
            outputStream3.getClass();
            byte[] bytes3 = "Content-Type: application/octet-stream\r\n".getBytes(charset);
            bytes3.getClass();
            outputStream3.write(bytes3);
            OutputStream outputStream4 = (OutputStream) this.e;
            outputStream4.getClass();
            byte[] bytes4 = "Content-Transfer-Encoding: binary\r\n".getBytes(charset);
            bytes4.getClass();
            outputStream4.write(bytes4);
            OutputStream outputStream5 = (OutputStream) this.e;
            outputStream5.getClass();
            byte[] bytes5 = "\r\n".getBytes(charset);
            bytes5.getClass();
            outputStream5.write(bytes5);
            OutputStream outputStream6 = (OutputStream) this.e;
            outputStream6.getClass();
            outputStream6.write(bArr, 0, bArr.length);
            OutputStream outputStream7 = (OutputStream) this.e;
            outputStream7.getClass();
            byte[] bytes6 = "\r\n".getBytes(charset);
            bytes6.getClass();
            outputStream7.write(bytes6);
        } catch (IOException unused) {
            OutputStream outputStream8 = (OutputStream) this.e;
            outputStream8.getClass();
            outputStream8.close();
        } catch (Exception unused2) {
            OutputStream outputStream9 = (OutputStream) this.e;
            outputStream9.getClass();
            outputStream9.close();
        } catch (OutOfMemoryError unused3) {
            OutputStream outputStream10 = (OutputStream) this.e;
            outputStream10.getClass();
            outputStream10.close();
        }
    }

    public long b(String str, String str2) throws IOException {
        long j10 = 0;
        try {
            OutputStream outputStream = (OutputStream) this.e;
            outputStream.getClass();
            String str3 = "--" + ((String) this.f1561c) + "\r\n";
            Charset charset = o7.a.f11749a;
            byte[] bytes = str3.getBytes(charset);
            bytes.getClass();
            outputStream.write(bytes);
            OutputStream outputStream2 = (OutputStream) this.e;
            outputStream2.getClass();
            byte[] bytes2 = ("Content-Disposition: form-data; name=\"apk_file\"; filename=\"" + str + "\"\r\n").getBytes(charset);
            bytes2.getClass();
            outputStream2.write(bytes2);
            OutputStream outputStream3 = (OutputStream) this.e;
            outputStream3.getClass();
            byte[] bytes3 = "Content-Type: application/octet-stream\r\n".getBytes(charset);
            bytes3.getClass();
            outputStream3.write(bytes3);
            OutputStream outputStream4 = (OutputStream) this.e;
            outputStream4.getClass();
            byte[] bytes4 = "Content-Transfer-Encoding: binary\r\n".getBytes(charset);
            bytes4.getClass();
            outputStream4.write(bytes4);
            OutputStream outputStream5 = (OutputStream) this.e;
            outputStream5.getClass();
            byte[] bytes5 = "\r\n".getBytes(charset);
            bytes5.getClass();
            outputStream5.write(bytes5);
            FileInputStream fileInputStream = new FileInputStream(str2);
            byte[] bArr = new byte[8192];
            while (true) {
                int i10 = fileInputStream.read(bArr);
                if (i10 <= 0) {
                    fileInputStream.close();
                    OutputStream outputStream6 = (OutputStream) this.e;
                    outputStream6.getClass();
                    byte[] bytes6 = "\r\n".getBytes(o7.a.f11749a);
                    bytes6.getClass();
                    outputStream6.write(bytes6);
                    return j10;
                }
                OutputStream outputStream7 = (OutputStream) this.e;
                outputStream7.getClass();
                outputStream7.write(bArr, 0, i10);
                j10 += i10;
            }
        } catch (IOException unused) {
            OutputStream outputStream8 = (OutputStream) this.e;
            if (outputStream8 != null) {
                outputStream8.close();
            }
            return j10;
        } catch (Exception unused2) {
            OutputStream outputStream9 = (OutputStream) this.e;
            if (outputStream9 != null) {
                outputStream9.close();
            }
            return j10;
        } catch (OutOfMemoryError unused3) {
            OutputStream outputStream10 = (OutputStream) this.e;
            if (outputStream10 != null) {
                outputStream10.close();
            }
            return j10;
        }
    }

    public void c(String str, String str2) throws IOException {
        str2.getClass();
        OutputStream outputStream = (OutputStream) this.e;
        outputStream.getClass();
        String strO = a3.a.o(new StringBuilder("--"), (String) this.f1561c, "\r\n");
        Charset charset = o7.a.f11749a;
        byte[] bytes = strO.getBytes(charset);
        bytes.getClass();
        outputStream.write(bytes);
        OutputStream outputStream2 = (OutputStream) this.e;
        outputStream2.getClass();
        byte[] bytes2 = "Content-Type: text/plain\r\n".getBytes(charset);
        bytes2.getClass();
        outputStream2.write(bytes2);
        OutputStream outputStream3 = (OutputStream) this.e;
        outputStream3.getClass();
        byte[] bytes3 = ("Content-Disposition: form-data; name=\"" + str + "\"\r\n").getBytes(charset);
        bytes3.getClass();
        outputStream3.write(bytes3);
        OutputStream outputStream4 = (OutputStream) this.e;
        outputStream4.getClass();
        byte[] bytes4 = ("\r\n" + str2 + "\r\n").getBytes(charset);
        bytes4.getClass();
        outputStream4.write(bytes4);
    }

    public void d(URL url, String str) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        uRLConnectionOpenConnection.getClass();
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
        this.f1562d = httpsURLConnection;
        httpsURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
        HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) this.f1562d;
        httpsURLConnection2.getClass();
        httpsURLConnection2.setReadTimeout(30000);
        HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) this.f1562d;
        httpsURLConnection3.getClass();
        httpsURLConnection3.setConnectTimeout(30000);
        HttpsURLConnection httpsURLConnection4 = (HttpsURLConnection) this.f1562d;
        httpsURLConnection4.getClass();
        httpsURLConnection4.setDoInput(true);
        HttpsURLConnection httpsURLConnection5 = (HttpsURLConnection) this.f1562d;
        httpsURLConnection5.getClass();
        httpsURLConnection5.setDoOutput(true);
        HttpsURLConnection httpsURLConnection6 = (HttpsURLConnection) this.f1562d;
        httpsURLConnection6.getClass();
        httpsURLConnection6.setRequestProperty("Connection", "Keep-Alive");
        HttpsURLConnection httpsURLConnection7 = (HttpsURLConnection) this.f1562d;
        httpsURLConnection7.getClass();
        httpsURLConnection7.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + ((String) this.f1561c));
        HttpsURLConnection httpsURLConnection8 = (HttpsURLConnection) this.f1562d;
        httpsURLConnection8.getClass();
        httpsURLConnection8.setRequestProperty("Accept-Charset", "utf-8");
        HttpsURLConnection httpsURLConnection9 = (HttpsURLConnection) this.f1562d;
        httpsURLConnection9.getClass();
        httpsURLConnection9.setRequestProperty("Accept", "application/json");
        HttpsURLConnection httpsURLConnection10 = (HttpsURLConnection) this.f1562d;
        httpsURLConnection10.getClass();
        httpsURLConnection10.setRequestProperty("Identificador", "Uptodown_Android");
        HttpsURLConnection httpsURLConnection11 = (HttpsURLConnection) this.f1562d;
        httpsURLConnection11.getClass();
        httpsURLConnection11.setRequestProperty("apk_file", str);
        HttpsURLConnection httpsURLConnection12 = (HttpsURLConnection) this.f1562d;
        httpsURLConnection12.getClass();
        httpsURLConnection12.setRequestProperty("Identificador-Version", "704");
        HttpsURLConnection httpsURLConnection13 = (HttpsURLConnection) this.f1562d;
        httpsURLConnection13.getClass();
        httpsURLConnection13.setRequestProperty("APIKEY", v5.n.b());
        ((HttpsURLConnection) this.f1562d).getClass();
        HttpsURLConnection httpsURLConnection14 = (HttpsURLConnection) this.f1562d;
        httpsURLConnection14.getClass();
        httpsURLConnection14.setFixedLengthStreamingMode((int) this.f1560b);
        HttpsURLConnection httpsURLConnection15 = (HttpsURLConnection) this.f1562d;
        httpsURLConnection15.getClass();
        httpsURLConnection15.connect();
        HttpsURLConnection httpsURLConnection16 = (HttpsURLConnection) this.f1562d;
        httpsURLConnection16.getClass();
        this.e = httpsURLConnection16.getOutputStream();
    }

    public void e() throws IOException {
        OutputStream outputStream = (OutputStream) this.e;
        outputStream.getClass();
        byte[] bytes = a3.a.o(new StringBuilder("--"), (String) this.f1561c, "--\r\n").getBytes(o7.a.f11749a);
        bytes.getClass();
        outputStream.write(bytes);
        OutputStream outputStream2 = (OutputStream) this.e;
        outputStream2.getClass();
        outputStream2.close();
    }

    public h5.p0 f(boolean z9) throws IOException {
        InputStream errorStream;
        boolean z10;
        h5.p0 p0Var = new h5.p0();
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) this.f1562d;
            httpsURLConnection.getClass();
            int responseCode = httpsURLConnection.getResponseCode();
            p0Var.f8697b = responseCode;
            if (responseCode < 200 || responseCode >= 300) {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) this.f1562d;
                httpsURLConnection2.getClass();
                errorStream = httpsURLConnection2.getErrorStream();
                if (errorStream == null) {
                    HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) this.f1562d;
                    httpsURLConnection3.getClass();
                    errorStream = httpsURLConnection3.getInputStream();
                }
                z10 = false;
            } else {
                HttpsURLConnection httpsURLConnection4 = (HttpsURLConnection) this.f1562d;
                httpsURLConnection4.getClass();
                errorStream = httpsURLConnection4.getInputStream();
                if (errorStream == null) {
                    HttpsURLConnection httpsURLConnection5 = (HttpsURLConnection) this.f1562d;
                    httpsURLConnection5.getClass();
                    errorStream = httpsURLConnection5.getErrorStream();
                }
                z10 = true;
            }
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[1024];
            if (z10 && z9) {
                InflaterInputStream inflaterInputStream = new InflaterInputStream(errorStream, new Inflater(true));
                while (true) {
                    int i10 = inflaterInputStream.read(bArr);
                    if (i10 == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, i10, o7.a.f11749a));
                }
                p0Var.f8696a = sb.toString();
                inflaterInputStream.close();
            } else {
                while (true) {
                    int i11 = errorStream.read(bArr);
                    if (i11 == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, i11, o7.a.f11749a));
                }
                p0Var.f8696a = sb.toString();
            }
            errorStream.close();
            HttpsURLConnection httpsURLConnection6 = (HttpsURLConnection) this.f1562d;
            httpsURLConnection6.getClass();
            httpsURLConnection6.disconnect();
            return p0Var;
        } catch (NullPointerException e) {
            g(e, p0Var, "NullPointerException");
            return p0Var;
        } catch (SecurityException e3) {
            g(e3, p0Var, "SecurityException");
            return p0Var;
        } catch (MalformedURLException e7) {
            g(e7, p0Var, "MalformedURLException");
            return p0Var;
        } catch (ProtocolException e10) {
            g(e10, p0Var, "ProtocolException");
            return p0Var;
        } catch (SocketTimeoutException e11) {
            g(e11, p0Var, "SocketTimeoutException");
            return p0Var;
        } catch (SSLHandshakeException e12) {
            g(e12, p0Var, "SSLHandshakeException");
            return p0Var;
        } catch (IOException e13) {
            g(e13, p0Var, "IOException");
            return p0Var;
        } catch (IllegalArgumentException e14) {
            g(e14, p0Var, "IllegalArgumentException");
            return p0Var;
        } catch (IllegalStateException e15) {
            g(e15, p0Var, "IllegalStateException");
            return p0Var;
        }
    }

    public void h(String str, byte[] bArr) {
        str.getClass();
        long length = this.f1560b + ("--" + ((String) this.f1561c) + "\r\n").length();
        this.f1560b = length;
        long j10 = (long) 2;
        this.f1560b = length + ("Content-Disposition: form-data; name=\"zipped\"; filename=\"" + str + "\"\r\n").length() + 40 + 35 + j10 + ((long) bArr.length) + j10;
    }

    public void i(long j10, String str) {
        long length = this.f1560b + ("--" + ((String) this.f1561c) + "\r\n").length();
        this.f1560b = length;
        long j11 = (long) 2;
        this.f1560b = length + ("Content-Disposition: form-data; name=\"apk_file\"; filename=\"" + str + "\"\r\n").length() + 40 + 35 + j11 + j10 + j11;
    }

    public void j() {
        this.f1560b = this.f1560b + ("--" + ((String) this.f1561c) + "--\r\n").length();
    }

    public void k(String str, String str2) {
        str2.getClass();
        long length = this.f1560b + ("--" + ((String) this.f1561c) + "\r\n").length() + 26;
        this.f1560b = length;
        long length2 = length + ("Content-Disposition: form-data; name=\"" + str + "\"\r\n").length();
        this.f1560b = length2;
        this.f1560b = length2 + ("\r\n" + str2 + "\r\n").length();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fb A[PHI: r8 r16 r17
      0x00fb: PHI (r8v7 android.database.Cursor) = (r8v6 android.database.Cursor), (r8v10 android.database.Cursor) binds: [B:61:0x0126, B:46:0x00f4] A[DONT_GENERATE, DONT_INLINE]
      0x00fb: PHI (r16v5 com.google.android.gms.internal.measurement.c3) = (r16v3 com.google.android.gms.internal.measurement.c3), (r16v10 com.google.android.gms.internal.measurement.c3) binds: [B:61:0x0126, B:46:0x00f4] A[DONT_GENERATE, DONT_INLINE]
      0x00fb: PHI (r17v4 long) = (r17v2 long), (r17v7 long) binds: [B:61:0x0126, B:46:0x00f4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.internal.measurement.c3 m(com.google.android.gms.internal.measurement.c3 r21, java.lang.String r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.x0.m(com.google.android.gms.internal.measurement.c3, java.lang.String):com.google.android.gms.internal.measurement.c3");
    }

    public v n() {
        return new v((String) this.f1561c, new u(new Bundle((Bundle) this.e)), (String) this.f1562d, this.f1560b);
    }

    public String toString() {
        switch (this.f1559a) {
            case 0:
                String str = (String) this.f1562d;
                String string = ((Bundle) this.e).toString();
                int length = String.valueOf(str).length();
                String str2 = (String) this.f1561c;
                StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + string.length());
                sb.append("origin=");
                sb.append(str);
                sb.append(",name=");
                sb.append(str2);
                return a3.a.o(sb, ",params=", string);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ x0(c cVar) {
        this.f1559a = 1;
        this.e = cVar;
    }

    public x0(long j10, Bundle bundle, String str, String str2) {
        this.f1559a = 0;
        this.f1561c = str;
        this.f1562d = str2;
        this.e = bundle;
        this.f1560b = j10;
    }
}
