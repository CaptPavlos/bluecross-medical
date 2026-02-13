package com.mbridge.msdk.foundation.same.net;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile AtomicInteger f3714a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f3715b;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static e f3724a = new e();
    }

    private e() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 5L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.net.e.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                threadNewThread.setName("SocketThreadPool");
                return threadNewThread;
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
        this.f3715b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public final String a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int i10 = gZIPInputStream.read(bArr2, 0, 1024);
            if (i10 <= 0) {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(bArr2, 0, i10);
        }
    }

    public static e a() {
        return b.f3724a;
    }

    public final void a(String str, int i10, String str2, boolean z9, com.mbridge.msdk.foundation.same.net.b bVar) {
        final a aVar = new a(str, i10, str2, z9, bVar);
        this.f3715b.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.e.2
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                aVar.a();
            }
        });
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class a {

        /* renamed from: b, reason: collision with root package name */
        private ByteBuffer f3720b;

        /* renamed from: c, reason: collision with root package name */
        private String f3721c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f3722d;
        private com.mbridge.msdk.foundation.same.net.b e;
        private OutputStream f;
        private int g;
        private Socket h;

        /* renamed from: i, reason: collision with root package name */
        private String f3723i;

        public a(String str, int i10, String str2, boolean z9, com.mbridge.msdk.foundation.same.net.b bVar) {
            this.f3721c = str;
            this.g = i10;
            this.f3723i = str2;
            this.f3722d = z9;
            this.e = bVar;
        }

        /* JADX WARN: Finally extract failed */
        /* JADX WARN: Multi-variable type inference failed */
        public final void a() throws IOException {
            OutputStream outputStream;
            boolean z9;
            int i10;
            byte[] bytes;
            int length;
            InputStream inputStream;
            int i11;
            int i12;
            byte[] bArr;
            int i13;
            com.mbridge.msdk.foundation.same.net.b bVar;
            OutputStream outputStream2;
            try {
                try {
                    Socket socket = new Socket(this.f3721c, this.g);
                    this.h = socket;
                    socket.setSoTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
                    z9 = this.f3721c.contains(com.mbridge.msdk.foundation.same.net.e.d.f().f3738i) || this.f3721c.contains(com.mbridge.msdk.foundation.same.net.e.d.f().f3740k);
                    af.b("SocketManager", "Socket connect : " + this.f3721c + " : " + this.g + " isAnalytics : " + z9);
                    this.f = this.h.getOutputStream();
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[8]);
                    this.f3720b = byteBufferWrap;
                    ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                    byteBufferWrap.order(byteOrder);
                    this.f3720b.put((byte) 2);
                    boolean zIsEmpty = TextUtils.isEmpty(this.f3723i);
                    ByteBuffer byteBuffer = this.f3720b;
                    if (zIsEmpty) {
                        byteBuffer.put((byte) 1);
                    } else {
                        byteBuffer.put(this.f3722d ? (byte) 3 : (byte) 2);
                    }
                    this.f3720b.putShort((short) e.f3714a.getAndIncrement());
                    if (TextUtils.isEmpty(this.f3723i)) {
                        this.f3720b.putInt(0);
                        this.f.write(this.f3720b.array());
                        length = 0;
                        i10 = 1;
                    } else {
                        if (this.f3722d) {
                            String str = this.f3723i;
                            if (TextUtils.isEmpty(str)) {
                                i10 = 1;
                                bytes = null;
                            } else {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                i10 = 1;
                                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                                gZIPOutputStream.write(str.getBytes());
                                gZIPOutputStream.close();
                                bytes = byteArrayOutputStream.toByteArray();
                            }
                        } else {
                            i10 = 1;
                            bytes = this.f3723i.getBytes();
                        }
                        length = bytes.length;
                        this.f3720b.putInt(length);
                        this.f.write(this.f3720b.array());
                        this.f.write(bytes);
                    }
                    this.f.flush();
                    af.a("SocketManager", "Socket Request : header : " + Arrays.toString(this.f3720b.array()) + " length : " + length);
                    inputStream = this.h.getInputStream();
                    byte[] bArr2 = new byte[8];
                    inputStream.read(bArr2, 0, 8);
                    ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr2);
                    this.f3720b = byteBufferWrap2;
                    byteBufferWrap2.order(byteOrder);
                    i11 = this.f3720b.getInt(4);
                    byte b10 = bArr2[i10];
                    boolean z10 = b10 == 3 ? i10 : 0;
                    i12 = b10 == 2 ? i10 : 0;
                    af.b("SocketManager", "Socket Response : header : " + Arrays.toString(bArr2) + " length : " + i11 + " isGzip : " + z10);
                    bArr = new byte[i11];
                    new DataInputStream(this.h.getInputStream()).readFully(bArr);
                    i13 = z10;
                    if (z10 == 0) {
                        i13 = z10;
                        if (i11 > 2) {
                            i13 = z10;
                            if (((bArr[0] << 8) | (bArr[i10] & 255)) == 8075) {
                                i13 = i10;
                            }
                        }
                    }
                    bVar = this.e;
                } catch (Throwable th) {
                    try {
                        String message = th.getMessage();
                        af.a("SocketManager", "Socket exception: " + message);
                        a(message);
                        Socket socket2 = this.h;
                        if (socket2 == null) {
                            return;
                        }
                        socket2.close();
                        this.f3720b = null;
                        outputStream = this.f;
                    } catch (Throwable th2) {
                        Socket socket3 = this.h;
                        if (socket3 == null) {
                            throw th2;
                        }
                        try {
                            socket3.close();
                            this.f3720b = null;
                            this.f.close();
                            throw th2;
                        } catch (IOException e) {
                            af.b("SocketManager", e.getMessage());
                            throw th2;
                        }
                    }
                }
                try {
                    if (bVar == null) {
                        Socket socket4 = this.h;
                        if (socket4 == null) {
                            return;
                        }
                        socket4.close();
                        this.f3720b = null;
                        outputStream2 = this.f;
                    } else if (i12 != 0 && i11 == 0) {
                        bVar.onSuccess(d.a(null, new com.mbridge.msdk.foundation.same.net.d.a(204, null, null)));
                        Socket socket5 = this.h;
                        if (socket5 == null) {
                            return;
                        }
                        socket5.close();
                        this.f3720b = null;
                        outputStream2 = this.f;
                    } else if (i11 < i10) {
                        a("The response data less than 1");
                        Socket socket6 = this.h;
                        if (socket6 == null) {
                            return;
                        }
                        socket6.close();
                        this.f3720b = null;
                        outputStream2 = this.f;
                    } else {
                        if (!z9) {
                            try {
                                String strA = i13 != 0 ? e.this.a(bArr) : new String(bArr);
                                JSONObject jSONObject = !TextUtils.isEmpty(strA) ? new JSONObject(strA) : null;
                                af.b("SocketManager", "Socket Response length : " + i11 + " " + strA.length());
                                this.e.onSuccess(d.a(jSONObject, new com.mbridge.msdk.foundation.same.net.d.a(200, null, null)));
                            } catch (Throwable th3) {
                                String message2 = th3.getMessage();
                                af.b("SocketManager", th3.getMessage());
                                if (TextUtils.isEmpty(message2)) {
                                    message2 = "The JSON data is illegal";
                                }
                                a(message2);
                            }
                            inputStream.close();
                            Socket socket7 = this.h;
                            if (socket7 != null) {
                                socket7.close();
                                this.f3720b = null;
                                outputStream = this.f;
                                outputStream.close();
                                return;
                            }
                            return;
                        }
                        if (bArr[0] == 1) {
                            bVar.onSuccess(d.a(null, new com.mbridge.msdk.foundation.same.net.d.a(200, null, null)));
                        } else {
                            a("The server returns fail");
                        }
                        Socket socket8 = this.h;
                        if (socket8 == null) {
                            return;
                        }
                        socket8.close();
                        this.f3720b = null;
                        outputStream2 = this.f;
                    }
                    outputStream2.close();
                } catch (IOException e3) {
                    af.b("SocketManager", e3.getMessage());
                }
            } catch (IOException e7) {
                af.b("SocketManager", e7.getMessage());
            }
        }

        private void a(String str) {
            if (this.e != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "Unknown exception";
                }
                this.e.onError(new com.mbridge.msdk.foundation.same.net.a.a(13, new com.mbridge.msdk.foundation.same.net.d.a(MBridgeCommon.CampaignState.STATE_LOAD_FAILED_RESOURCE_DOWNLOAD_ERROR, str.getBytes(), null)));
            }
        }
    }
}
