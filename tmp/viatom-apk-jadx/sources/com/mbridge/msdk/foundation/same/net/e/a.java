package com.mbridge.msdk.foundation.same.net.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {
    public static String a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        if (aVar != null) {
            try {
                int i10 = aVar.f3702a;
                com.mbridge.msdk.foundation.same.net.d.a aVar2 = aVar.f3704c;
                int i11 = aVar2 != null ? aVar2.f3713d : 0;
                if (i10 == -2) {
                    return "Network is canceled";
                }
                if (i10 == 15) {
                    return "Network error,I/O exception contents null";
                }
                if (i10 == 880023) {
                    return "timeout";
                }
                if (i10 == 880041) {
                    return "Network error,UnknownHostException";
                }
                switch (i10) {
                    case 1:
                        break;
                    case 2:
                        return "Network error,I/O exception";
                    case 3:
                        return "Network error,timeout exception";
                    case 4:
                        return "Network unknown error";
                    case 5:
                        return "Network error，https is not work,please check your phone time";
                    case 6:
                        if (i11 == 0) {
                            return "Network error,please check ";
                        }
                        return "Network error,please check state code " + i11;
                    case 7:
                        if (i11 == 0) {
                            return "The server returns an exception ";
                        }
                        return "The server returns an exception state code " + i11;
                    case 8:
                        return "Cast exception, return data can not be casted correctly";
                    default:
                        switch (i10) {
                            case 10:
                                return "Network error,socket timeout exception";
                            case 11:
                                return "Network error，sslp exception";
                            case 12:
                                return "Network error,ConnectException";
                            case 13:
                                if (aVar2 == null) {
                                    return "Unknown socket exception";
                                }
                                byte[] bArr = aVar2.f3710a;
                                return bArr != null ? new String(bArr) : "Socket exception message is NULL";
                            default:
                                return "Network error,unknown";
                        }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "Network error,Load failed";
            }
        }
        return "Network error,Load failed";
    }
}
