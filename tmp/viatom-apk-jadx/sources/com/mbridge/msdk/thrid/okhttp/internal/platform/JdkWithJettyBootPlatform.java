package com.mbridge.msdk.thrid.okhttp.internal.platform;

import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
class JdkWithJettyBootPlatform extends Platform {
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class JettyNegoProvider implements InvocationHandler {
        private final List<String> protocols;
        String selected;
        boolean unsupported;

        public JettyNegoProvider(List<String> list) {
            this.protocols = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = Util.EMPTY_STRING_ARRAY;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.unsupported = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.protocols;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    int i10 = 0;
                    while (true) {
                        List<String> list2 = this.protocols;
                        if (i10 >= size) {
                            String str = list2.get(0);
                            this.selected = str;
                            return str;
                        }
                        if (list2.contains(list.get(i10))) {
                            String str2 = (String) list.get(i10);
                            this.selected = str2;
                            return str2;
                        }
                        i10++;
                    }
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.selected = (String) objArr[0];
            return null;
        }
    }

    public JdkWithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.putMethod = method;
        this.getMethod = method2;
        this.removeMethod = method3;
        this.clientProviderClass = cls;
        this.serverProviderClass = cls2;
    }

    public static Platform buildIfSupported() throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new JdkWithJettyBootPlatform(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.Platform
    public void afterHandshake(SSLSocket sSLSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.removeMethod.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.assertionError("unable to remove alpn", e);
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.putMethod.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new JettyNegoProvider(Platform.alpnProtocolNames(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.assertionError("unable to set alpn", e);
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        try {
            JettyNegoProvider jettyNegoProvider = (JettyNegoProvider) Proxy.getInvocationHandler(this.getMethod.invoke(null, sSLSocket));
            boolean z9 = jettyNegoProvider.unsupported;
            if (!z9 && jettyNegoProvider.selected == null) {
                Platform.get().log(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            }
            if (z9) {
                return null;
            }
            return jettyNegoProvider.selected;
        } catch (IllegalAccessException e) {
            e = e;
            throw Util.assertionError("unable to get selected protocol", e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw Util.assertionError("unable to get selected protocol", e);
        }
    }
}
