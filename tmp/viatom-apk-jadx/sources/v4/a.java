package v4;

import android.content.Context;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import c1.r2;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final n5 f13125a;

    /* renamed from: b, reason: collision with root package name */
    public final c2.d f13126b;

    /* renamed from: c, reason: collision with root package name */
    public final t1.c f13127c;

    /* renamed from: d, reason: collision with root package name */
    public Socket f13128d;
    public Socket e;
    public u4.c f;

    public a(Context context, n5 n5Var) {
        n5Var.getClass();
        context.getClass();
        this.f13125a = n5Var;
        this.f13126b = new c2.d(context, n5Var, this);
        this.f13127c = new t1.c(n5Var, this);
    }

    public final void a() {
        f fVar = o4.b.t;
        NsdServiceInfo nsdServiceInfo = fVar != null ? fVar.f : null;
        if (nsdServiceInfo != null) {
            n5 n5Var = this.f13125a;
            try {
                InetAddress host = nsdServiceInfo.getHost();
                if (Build.VERSION.SDK_INT >= 34) {
                    Iterator<InetAddress> it = nsdServiceInfo.getHostAddresses().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        InetAddress next = it.next();
                        if (next != null) {
                            host = next;
                            break;
                        }
                    }
                }
                b(new Socket(host, nsdServiceInfo.getPort()));
                n5Var.getClass();
                n5.n0(nsdServiceInfo);
            } catch (ConnectException unused) {
                ((o4.b) n5Var.f10654b).b();
            } catch (IOException unused2) {
                ((o4.b) n5Var.f10654b).b();
            }
        }
    }

    public final synchronized void b(Socket socket) {
        try {
            Socket socket2 = this.f13128d;
            if (socket2 == null || !socket2.isConnected()) {
                this.f13128d = socket;
            } else {
                c(socket);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001a A[Catch: all -> 0x0014, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000c, B:10:0x0010, B:15:0x0017, B:16:0x001a), top: B:21:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void c(java.net.Socket r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.net.Socket r0 = r2.e     // Catch: java.lang.Throwable -> L14
            if (r0 == 0) goto L1a
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L14
            r1 = 1
            if (r0 != r1) goto L1a
            java.net.Socket r0 = r2.e     // Catch: java.lang.Throwable -> L14 java.io.IOException -> L16
            if (r0 == 0) goto L1a
            r0.close()     // Catch: java.lang.Throwable -> L14 java.io.IOException -> L16
            goto L1a
        L14:
            r3 = move-exception
            goto L1e
        L16:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L14
        L1a:
            r2.e = r3     // Catch: java.lang.Throwable -> L14
            monitor-exit(r2)
            return
        L1e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L14
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.a.c(java.net.Socket):void");
    }

    public final void d(boolean z9) {
        Socket socket = this.f13128d;
        if (socket == null || socket.isClosed()) {
            ((o4.b) this.f13125a.f10654b).b();
            return;
        }
        t1.c cVar = this.f13127c;
        cVar.getClass();
        new Thread(new r2(cVar, z9)).start();
    }

    public final void e() {
        c2.d dVar = this.f13126b;
        Thread thread = (Thread) dVar.f;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            ServerSocket serverSocket = (ServerSocket) dVar.e;
            if (serverSocket != null) {
                serverSocket.close();
            }
            dVar.e = null;
        } catch (IOException unused) {
        }
        try {
            Socket socket = this.e;
            if (socket != null) {
                socket.close();
            }
            this.e = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Socket socket2 = this.f13128d;
            if (socket2 != null) {
                socket2.close();
            }
            this.f13128d = null;
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
}
