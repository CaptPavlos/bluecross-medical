package z8;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g0 extends d {

    /* renamed from: m, reason: collision with root package name */
    public final Socket f14475m;

    public g0(Socket socket) {
        socket.getClass();
        this.f14475m = socket;
    }

    @Override // z8.d
    public final void j() throws IOException {
        Socket socket = this.f14475m;
        try {
            socket.close();
        } catch (AssertionError e) {
            if (!t1.D(e)) {
                throw e;
            }
            y.f14516a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
        } catch (Exception e3) {
            y.f14516a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e3);
        }
    }

    public final IOException k(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
