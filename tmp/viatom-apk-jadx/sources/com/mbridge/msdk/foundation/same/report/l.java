package com.mbridge.msdk.foundation.same.report;

import android.util.Log;
import com.mbridge.msdk.tracker.network.u;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends com.mbridge.msdk.tracker.network.toolbox.a {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f3877a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private final byte f3878b;

    public l(byte b10) {
        this.f3878b = b10;
    }

    @Override // com.mbridge.msdk.tracker.network.toolbox.a
    public final com.mbridge.msdk.tracker.network.toolbox.g a(u<?> uVar, Map<String, String> map) throws IOException {
        ByteBuffer byteBuffer;
        OutputStream outputStream;
        ByteBuffer byteBufferWrap;
        Socket socket;
        ByteOrder byteOrder;
        byte[] bArr;
        ByteBuffer byteBufferWrap2;
        com.mbridge.msdk.tracker.network.toolbox.g gVar;
        byte[] byteArray;
        if (com.mbridge.msdk.tracker.a.f5328a) {
            Log.d("TrackManager_Volley", "SocketStack executeRequest " + uVar.k() + ":" + uVar.h());
        }
        Socket socket2 = null;
        try {
            Socket socket3 = new Socket(uVar.k(), uVar.h());
            try {
                socket3.setSoTimeout(uVar.u());
                outputStream = socket3.getOutputStream();
            } catch (Throwable th) {
                th = th;
                outputStream = null;
                byteBufferWrap = null;
            }
            try {
                if (outputStream == null) {
                    throw new IOException("create outputStream exception");
                }
                byteBufferWrap = ByteBuffer.wrap(new byte[8]);
                try {
                    byteOrder = ByteOrder.BIG_ENDIAN;
                    byteBufferWrap.order(byteOrder);
                    byteBufferWrap.put(this.f3878b);
                    byte[] bArrP = uVar.p();
                    if (bArrP == null || bArrP.length == 0) {
                        byteBufferWrap.put((byte) 1);
                    } else {
                        byteBufferWrap.put((byte) 3);
                    }
                    byteBufferWrap.putShort((short) f3877a.getAndIncrement());
                    if (bArrP == null || bArrP.length == 0) {
                        byteBufferWrap.putInt(0);
                        outputStream.write(byteBufferWrap.array());
                    } else {
                        if (bArrP.length == 0) {
                            byteArray = null;
                        } else {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(bArrP);
                            gZIPOutputStream.close();
                            byteArray = byteArrayOutputStream.toByteArray();
                        }
                        byteBufferWrap.putInt(byteArray == null ? 0 : byteArray.length);
                        outputStream.write(byteBufferWrap.array());
                        outputStream.write(byteArray);
                    }
                    outputStream.flush();
                    bArr = new byte[8];
                    socket3.getInputStream().read(bArr, 0, 8);
                    byteBufferWrap2 = ByteBuffer.wrap(bArr);
                } catch (Throwable th2) {
                    th = th2;
                    socket = socket3;
                    byteBuffer = null;
                }
                try {
                    byteBufferWrap2.order(byteOrder);
                    int i10 = byteBufferWrap2.getInt(4);
                    boolean z9 = bArr[1] == 2;
                    byte[] bArr2 = new byte[i10];
                    new DataInputStream(socket3.getInputStream()).readFully(bArr2);
                    if (z9 && i10 == 0) {
                        gVar = new com.mbridge.msdk.tracker.network.toolbox.g(204, new ArrayList(), i10, null);
                    } else {
                        if (i10 < 1 || bArr2[0] != 1) {
                            com.mbridge.msdk.tracker.network.toolbox.g gVar2 = new com.mbridge.msdk.tracker.network.toolbox.g(500, new ArrayList(), 0, null);
                            a(outputStream);
                            a(socket3);
                            a(byteBufferWrap);
                            a(byteBufferWrap2);
                            return gVar2;
                        }
                        gVar = new com.mbridge.msdk.tracker.network.toolbox.g(200, new ArrayList(), i10, null);
                    }
                    a(outputStream);
                    a(socket3);
                    a(byteBufferWrap);
                    a(byteBufferWrap2);
                    return gVar;
                } catch (Throwable th3) {
                    socket = socket3;
                    byteBuffer = byteBufferWrap2;
                    th = th3;
                    socket2 = socket;
                    try {
                        throw new IOException(th);
                    } catch (Throwable th4) {
                        a(outputStream);
                        a(socket2);
                        a(byteBufferWrap);
                        a(byteBuffer);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                byteBufferWrap = null;
                socket2 = socket3;
                byteBuffer = byteBufferWrap;
                throw new IOException(th);
            }
        } catch (Throwable th6) {
            th = th6;
            byteBuffer = null;
            outputStream = null;
            byteBufferWrap = null;
        }
    }

    private static void a(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    private static void a(Socket socket) throws IOException {
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception unused) {
            }
        }
    }

    private void a(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            try {
                byteBuffer.clear();
            } catch (Exception unused) {
            }
        }
    }
}
