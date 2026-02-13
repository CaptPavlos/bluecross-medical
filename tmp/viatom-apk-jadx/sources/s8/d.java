package s8;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import l4.x4;
import p8.e0;
import p8.s;
import p8.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final p8.a f12731a;

    /* renamed from: b, reason: collision with root package name */
    public final x4 f12732b;

    /* renamed from: c, reason: collision with root package name */
    public final p8.b f12733c;

    /* renamed from: d, reason: collision with root package name */
    public final List f12734d;
    public int e;
    public List f;
    public final ArrayList g;

    public d(p8.a aVar, x4 x4Var, y yVar, p8.b bVar) {
        List list = Collections.EMPTY_LIST;
        this.f12734d = list;
        this.f = list;
        this.g = new ArrayList();
        this.f12731a = aVar;
        this.f12732b = x4Var;
        this.f12733c = bVar;
        List<Proxy> listSelect = aVar.g.select(aVar.f12045a.l());
        this.f12734d = (listSelect == null || listSelect.isEmpty()) ? q8.c.l(Proxy.NO_PROXY) : q8.c.k(listSelect);
        this.e = 0;
    }

    public final void a(e0 e0Var, IOException iOException) {
        p8.a aVar;
        ProxySelector proxySelector;
        if (e0Var.f12082b.type() != Proxy.Type.DIRECT && (proxySelector = (aVar = this.f12731a).g) != null) {
            proxySelector.connectFailed(aVar.f12045a.l(), e0Var.f12082b.address(), iOException);
        }
        x4 x4Var = this.f12732b;
        synchronized (x4Var) {
            ((LinkedHashSet) x4Var.f10987b).add(e0Var);
        }
    }

    public final c b() throws SocketException, UnknownHostException {
        String hostName;
        int port;
        boolean zContains;
        if (this.e >= this.f12734d.size() && this.g.isEmpty()) {
            com.google.gson.internal.a.b();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (this.e < this.f12734d.size()) {
            p8.a aVar = this.f12731a;
            if (this.e >= this.f12734d.size()) {
                throw new SocketException("No route to " + aVar.f12045a.f12157d + "; exhausted proxy configurations: " + this.f12734d);
            }
            List list = this.f12734d;
            int i10 = this.e;
            this.e = i10 + 1;
            Proxy proxy = (Proxy) list.get(i10);
            p8.b bVar = this.f12733c;
            this.f = new ArrayList();
            if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                s sVar = aVar.f12045a;
                hostName = sVar.f12157d;
                port = sVar.e;
            } else {
                SocketAddress socketAddressAddress = proxy.address();
                if (!(socketAddressAddress instanceof InetSocketAddress)) {
                    androidx.window.layout.c.f(socketAddressAddress.getClass(), "Proxy.address() is not an InetSocketAddress: ");
                    return null;
                }
                InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                InetAddress address = inetSocketAddress.getAddress();
                hostName = address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
                port = inetSocketAddress.getPort();
            }
            if (port < 1 || port > 65535) {
                throw new SocketException("No route to " + hostName + ":" + port + "; port is out of range");
            }
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f.add(InetSocketAddress.createUnresolved(hostName, port));
            } else {
                bVar.getClass();
                aVar.f12046b.getClass();
                if (hostName == null) {
                    throw new UnknownHostException("hostname == null");
                }
                try {
                    List listAsList = Arrays.asList(InetAddress.getAllByName(hostName));
                    if (listAsList.isEmpty()) {
                        throw new UnknownHostException(aVar.f12046b + " returned no addresses for " + hostName);
                    }
                    int size = listAsList.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        this.f.add(new InetSocketAddress((InetAddress) listAsList.get(i11), port));
                    }
                } catch (NullPointerException e) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostName));
                    unknownHostException.initCause(e);
                    throw unknownHostException;
                }
            }
            int size2 = this.f.size();
            for (int i12 = 0; i12 < size2; i12++) {
                e0 e0Var = new e0(this.f12731a, proxy, (InetSocketAddress) this.f.get(i12));
                x4 x4Var = this.f12732b;
                synchronized (x4Var) {
                    zContains = ((LinkedHashSet) x4Var.f10987b).contains(e0Var);
                }
                if (zContains) {
                    this.g.add(e0Var);
                } else {
                    arrayList.add(e0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.g);
            this.g.clear();
        }
        return new c(arrayList);
    }
}
