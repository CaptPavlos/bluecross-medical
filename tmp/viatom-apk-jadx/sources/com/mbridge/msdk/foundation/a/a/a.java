package com.mbridge.msdk.foundation.a.a;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3312a = "a";

    /* renamed from: c, reason: collision with root package name */
    private static a f3313c;

    /* renamed from: b, reason: collision with root package name */
    FastKV f3314b;

    private a() {
    }

    public final void a(String str, long j10) {
        try {
            if (c.m().c() == null) {
                af.b(f3312a, "context is null in put");
                return;
            }
            b();
            FastKV fastKV = this.f3314b;
            if (fastKV != null) {
                try {
                    fastKV.putLong(str, j10);
                } catch (Exception unused) {
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.a(f3312a, "putLong error: " + e.getMessage());
            }
        }
    }

    public final Long b(String str) {
        try {
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.a(f3312a, "getLong error: " + e.getMessage());
            }
        }
        if (c.m().c() == null) {
            af.b(f3312a, "context is null in get");
            return 0L;
        }
        b();
        FastKV fastKV = this.f3314b;
        if (fastKV != null) {
            try {
                return Long.valueOf(fastKV.getLong(str, 0L));
            } catch (Exception unused) {
                return 0L;
            }
        }
        return 0L;
    }

    public final void c(String str) {
        if (c.m().c() == null) {
            return;
        }
        b();
        FastKV fastKV = this.f3314b;
        if (fastKV != null) {
            try {
                fastKV.remove(str);
            } catch (Exception unused) {
            }
        }
    }

    public final String a(String str) {
        try {
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.a(f3312a, "get error: " + e.getMessage());
            }
        }
        if (c.m().c() == null) {
            return null;
        }
        b();
        FastKV fastKV = this.f3314b;
        if (fastKV != null) {
            try {
                return fastKV.getString(str, "");
            } catch (Exception unused) {
                return "";
            }
        }
        return null;
    }

    public final int a(String str, int i10) {
        try {
            if (c.m().c() != null) {
                b();
                FastKV fastKV = this.f3314b;
                if (fastKV != null) {
                    try {
                        return fastKV.getInt(str, i10);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.a(f3312a, "getInt error: " + e.getMessage());
            }
        }
        return i10;
    }

    public final void a(String str, String str2) {
        try {
            if (c.m().c() == null) {
                return;
            }
            b();
            FastKV fastKV = this.f3314b;
            if (fastKV != null) {
                try {
                    fastKV.putString(str, str2);
                } catch (Exception unused) {
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.a(f3312a, "put error: " + e.getMessage());
            }
        }
    }

    public final void b(String str, int i10) {
        try {
            if (c.m().c() == null) {
                return;
            }
            b();
            FastKV fastKV = this.f3314b;
            if (fastKV != null) {
                try {
                    fastKV.putInt(str, i10);
                } catch (Exception unused) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b() {
        if (this.f3314b == null) {
            try {
                this.f3314b = new FastKV.Builder(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
            } catch (Exception unused) {
                this.f3314b = null;
            }
        }
    }

    public static synchronized a a() {
        try {
            if (f3313c == null) {
                f3313c = new a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3313c;
    }
}
