package v4;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.measurement.l5;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import l4.n5;
import o7.u;
import p4.m0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13129a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c2.d f13130b;

    public /* synthetic */ b(c2.d dVar, int i10) {
        this.f13129a = i10;
        this.f13130b = dVar;
    }

    /* JADX INFO: Infinite loop detected, blocks: 37, insns: 0 */
    @Override // java.lang.Runnable
    public final void run() throws IOException {
        byte[] bArr;
        int i10;
        File file;
        InputStream inputStream;
        switch (this.f13129a) {
            case 0:
                c2.d dVar = this.f13130b;
                a aVar = (a) dVar.f1643d;
                n5 n5Var = (n5) dVar.f1642c;
                try {
                    Socket socket = aVar.f13128d;
                    if (socket == null) {
                        ((o4.b) n5Var.f10654b).b();
                        break;
                    } else if (socket.isClosed()) {
                        ((o4.b) n5Var.f10654b).b();
                        break;
                    } else {
                        while (true) {
                            Socket socket2 = aVar.f13128d;
                            socket2.getClass();
                            String utf = new DataInputStream(socket2.getInputStream()).readUTF();
                            if (utf == null) {
                                ((o4.b) n5Var.f10654b).b();
                            } else if (utf.equalsIgnoreCase("OK")) {
                                u4.c cVar = aVar.f;
                                if (cVar != null) {
                                    n5Var.getClass();
                                    n5.j0(cVar);
                                }
                            } else if (utf.equalsIgnoreCase("KO")) {
                                n5Var.getClass();
                            } else if (utf.equalsIgnoreCase("FileReceived")) {
                                n5Var.getClass();
                            } else if (u.c0(utf, "resolveService:", false)) {
                                n5Var.q0(utf.substring(15));
                            } else {
                                u4.c cVar2 = new u4.c();
                                dVar.h = cVar2;
                                cVar2.a(utf);
                                u4.c cVar3 = (u4.c) dVar.h;
                                cVar3.getClass();
                                n5Var.getClass();
                                n5.h0(cVar3);
                            }
                        }
                    }
                } catch (EOFException unused) {
                    ((o4.b) n5Var.f10654b).b();
                    return;
                } catch (IOException unused2) {
                    ((o4.b) n5Var.f10654b).b();
                    return;
                } catch (Exception unused3) {
                    ((o4.b) n5Var.f10654b).b();
                    return;
                }
            case 1:
                c2.d dVar2 = this.f13130b;
                n5 n5Var2 = (n5) dVar2.f1642c;
                try {
                    Context context = (Context) dVar2.f1641b;
                    context.getClass();
                    File file2 = new File(context.getExternalFilesDir(null), "received");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    u4.c cVar4 = (u4.c) dVar2.h;
                    cVar4.getClass();
                    if (cVar4.f12899b != null) {
                        u4.c cVar5 = (u4.c) dVar2.h;
                        cVar5.getClass();
                        String str = cVar5.f12899b;
                        str.getClass();
                        File file3 = new File(file2, str);
                        Socket socket3 = ((a) dVar2.f1643d).e;
                        socket3.getClass();
                        InputStream inputStream2 = socket3.getInputStream();
                        if (inputStream2 == null) {
                            n5Var2.l0("ERROR: cant create output file");
                            break;
                        } else {
                            FileOutputStream fileOutputStream = new FileOutputStream(file3);
                            u4.c cVar6 = (u4.c) dVar2.h;
                            cVar6.getClass();
                            long j10 = cVar6.e;
                            int i11 = 0;
                            long j11 = 0;
                            byte[] bArr2 = new byte[8192];
                            int i12 = 0;
                            int i13 = 0;
                            while (i12 < j10 && (i10 = inputStream2.read((bArr = bArr2), i11, 8192)) > 0) {
                                fileOutputStream.write(bArr, i11, i10);
                                i12 += i10;
                                long j12 = j11;
                                FileOutputStream fileOutputStream2 = fileOutputStream;
                                int i14 = (int) ((i12 * 100.0d) / j10);
                                if (i14 <= i13 + 5) {
                                    file = file3;
                                    inputStream = inputStream2;
                                    if (System.currentTimeMillis() <= j12 + 1000 || i14 <= i13) {
                                        fileOutputStream = fileOutputStream2;
                                        j11 = j12;
                                        file3 = file;
                                        inputStream2 = inputStream;
                                        i11 = 0;
                                        bArr2 = bArr;
                                    }
                                } else {
                                    file = file3;
                                    inputStream = inputStream2;
                                }
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                n5Var2.getClass();
                                Activity activity = o4.b.g;
                                if (activity != null && (activity instanceof m0)) {
                                    m0 m0Var = (m0) activity;
                                    m0Var.runOnUiThread(new androidx.core.content.res.a(m0Var, i14, 3));
                                }
                                bArr2 = bArr;
                                i13 = i14;
                                fileOutputStream = fileOutputStream2;
                                i11 = 0;
                                j11 = jCurrentTimeMillis;
                                file3 = file;
                                inputStream2 = inputStream;
                            }
                            File file4 = file3;
                            FileOutputStream fileOutputStream3 = fileOutputStream;
                            n5Var2.getClass();
                            Activity activity2 = o4.b.g;
                            if (activity2 != null && (activity2 instanceof m0)) {
                                m0 m0Var2 = (m0) activity2;
                                m0Var2.runOnUiThread(new androidx.core.content.res.a(m0Var2, 100, 3));
                            }
                            fileOutputStream3.close();
                            String strY = l5.y(file4.getAbsolutePath());
                            if (strY != null) {
                                u4.c cVar7 = (u4.c) dVar2.h;
                                cVar7.getClass();
                                if (strY.equalsIgnoreCase(cVar7.f12900c)) {
                                    u4.c cVar8 = (u4.c) dVar2.h;
                                    cVar8.getClass();
                                    String str2 = cVar8.f12899b;
                                    str2.getClass();
                                    n5.g0(str2);
                                    break;
                                }
                            }
                            n5Var2.l0("ERROR: File hashes do not macth!");
                            break;
                        }
                    }
                } catch (Exception e) {
                    if (e.getMessage() == null) {
                        n5Var2.l0("Exception");
                        return;
                    }
                    String message = e.getMessage();
                    message.getClass();
                    n5Var2.l0(message);
                    return;
                }
                break;
            default:
                c2.d dVar3 = this.f13130b;
                n5 n5Var3 = (n5) dVar3.f1642c;
                try {
                    ServerSocket serverSocket = new ServerSocket(0);
                    dVar3.e = serverSocket;
                    n5Var3.k0(serverSocket.getLocalPort());
                    while (true) {
                        Thread thread = (Thread) dVar3.f;
                        thread.getClass();
                        if (thread.isInterrupted()) {
                            break;
                        } else {
                            ServerSocket serverSocket2 = (ServerSocket) dVar3.e;
                            serverSocket2.getClass();
                            Socket socketAccept = serverSocket2.accept();
                            a aVar2 = (a) dVar3.f1643d;
                            socketAccept.getClass();
                            aVar2.b(socketAccept);
                            n5.f0(socketAccept.getRemoteSocketAddress().toString());
                        }
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return;
                }
        }
    }
}
