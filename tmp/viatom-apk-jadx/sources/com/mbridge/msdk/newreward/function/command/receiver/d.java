package com.mbridge.msdk.newreward.function.command.receiver;

import android.text.TextUtils;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.i;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.j;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.k;
import com.mbridge.msdk.newreward.function.command.receiver.showreceiver.g;
import com.mbridge.msdk.newreward.function.command.receiver.showreceiver.h;
import j$.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f4867a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<f, Object> f4868b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f4869c;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.d$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4870a;

        static {
            int[] iArr = new int[f.values().length];
            f4870a = iArr;
            try {
                iArr[f.RESTORE_DB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4870a[f.SMART_LOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4870a[f.CAMPAIGN_REDIRECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4870a[f.SHOW_ADD_TEMPLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4870a[f.SHOW_LIFE_CYCLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4870a[f.SHOW_OR_PRELOAD_WEB_EC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4870a[f.NORMAL_LOAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4870a[f.PRE_HANDLE_LOAD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4870a[f.UNIT_INIT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4870a[f.BUILD_MORE_OFFER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4870a[f.CHECK_IS_REQUEST_CONTROL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4870a[f.UPDATE_CAM_TOKEN_RULE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f4870a[f.START_LOAD_CHECK.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f4870a[f.CANDIDATE_LOAD_ACTION.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f4870a[f.TEMP_PLAYER_INIT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f4870a[f.TEMP_PLAY_START_COUNT_DOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f4870a[f.TEMP_PLAY_PROGRESS_COUNT_DOWN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f4870a[f.ADD_SHAKE_VIEW.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f4870a[f.ADD_BAIT_CLICK.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    private d() {
    }

    public final <T extends b> T a(f fVar) {
        int i10 = AnonymousClass1.f4870a[fVar.ordinal()];
        if (i10 == 3) {
            return new g();
        }
        if (i10 == 4) {
            return new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.b();
        }
        if (i10 == 5) {
            return new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.a();
        }
        if (i10 != 6) {
            return null;
        }
        if (this.f4868b == null) {
            this.f4868b = new ConcurrentHashMap<>();
        }
        ConcurrentHashMap<f, Object> concurrentHashMap = this.f4868b;
        f fVar2 = f.SHOW_OR_PRELOAD_WEB_EC;
        h hVar = concurrentHashMap.containsKey(fVar2) ? (h) this.f4868b.get(fVar2) : null;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        this.f4868b.put(fVar2, hVar2);
        return hVar2;
    }

    public final <T extends a> T b(f fVar) {
        int i10 = AnonymousClass1.f4870a[fVar.ordinal()];
        if (i10 == 1) {
            return new com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.g();
        }
        if (i10 == 2) {
            return new i();
        }
        if (i10 == 4) {
            return new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.d();
        }
        switch (i10) {
            case 7:
                return new com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d();
            case 8:
                return new com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.e();
            case 9:
                return new j();
            case 10:
                return new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.e();
            default:
                return null;
        }
    }

    public final <T extends e> T c(f fVar) {
        switch (AnonymousClass1.f4870a[fVar.ordinal()]) {
            case 11:
                return new com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.f();
            case 12:
                return new k();
            case 13:
                return new com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.c();
            case 14:
                if (this.f4868b == null) {
                    this.f4868b = new ConcurrentHashMap<>();
                }
                ConcurrentHashMap<f, Object> concurrentHashMap = this.f4868b;
                f fVar2 = f.CANDIDATE_LOAD_ACTION;
                T t = concurrentHashMap.containsKey(fVar2) ? (T) this.f4868b.get(fVar2) : null;
                if (t != null) {
                    return t;
                }
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.a aVar = new com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.a();
                this.f4868b.put(fVar2, aVar);
                return aVar;
            case 15:
            case 16:
            case 17:
                return new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.f(fVar);
            case 18:
            case 19:
                return new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c(fVar);
            default:
                return null;
        }
    }

    public final void d(f fVar) {
        ConcurrentHashMap<f, Object> concurrentHashMap;
        if (fVar == null || (concurrentHashMap = this.f4868b) == null) {
            return;
        }
        concurrentHashMap.remove(fVar);
    }

    public static d a() {
        if (f4867a == null) {
            synchronized (d.class) {
                try {
                    if (f4867a == null) {
                        f4867a = new d();
                    }
                } finally {
                }
            }
        }
        return f4867a;
    }

    public final <T extends b> T a(f fVar, String str) {
        if (fVar == f.SHOW_OR_PRELOAD_WEB_TEMPLATE) {
            if (this.f4869c == null) {
                this.f4869c = new ConcurrentHashMap<>();
            }
            iVar = this.f4869c.containsKey(str) ? (com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i) this.f4869c.get(str) : null;
            if (iVar == null) {
                com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i iVar = new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i();
                this.f4869c.put(str, iVar);
                return iVar;
            }
        }
        return iVar;
    }

    public final void a(String str) {
        ConcurrentHashMap<String, Object> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f4869c) == null) {
            return;
        }
        concurrentHashMap.remove(str);
    }
}
