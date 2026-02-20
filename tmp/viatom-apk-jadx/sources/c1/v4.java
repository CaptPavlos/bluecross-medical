package c1;

import android.app.BroadcastOptions;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.j8;
import com.google.android.gms.internal.measurement.w5;
import com.mbridge.msdk.MBridgeConstans;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v4 implements g2 {
    public static volatile v4 K;
    public final HashMap B;
    public final HashMap C;
    public final HashMap D;
    public k3 F;
    public String G;
    public e4 H;
    public long I;

    /* renamed from: a, reason: collision with root package name */
    public final n1 f1518a;

    /* renamed from: b, reason: collision with root package name */
    public final a1 f1519b;

    /* renamed from: c, reason: collision with root package name */
    public n f1520c;

    /* renamed from: d, reason: collision with root package name */
    public c1 f1521d;
    public l4 e;
    public c f;
    public final a1 g;
    public a1 h;

    /* renamed from: i, reason: collision with root package name */
    public z3 f1522i;

    /* renamed from: k, reason: collision with root package name */
    public j1 f1524k;

    /* renamed from: l, reason: collision with root package name */
    public final u1 f1525l;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1527n;

    /* renamed from: o, reason: collision with root package name */
    public long f1528o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f1529p;

    /* renamed from: r, reason: collision with root package name */
    public int f1531r;

    /* renamed from: s, reason: collision with root package name */
    public int f1532s;
    public boolean t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1533u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1534v;

    /* renamed from: w, reason: collision with root package name */
    public FileLock f1535w;

    /* renamed from: x, reason: collision with root package name */
    public FileChannel f1536x;
    public ArrayList y;

    /* renamed from: z, reason: collision with root package name */
    public ArrayList f1537z;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f1526m = new AtomicBoolean(false);

    /* renamed from: q, reason: collision with root package name */
    public final LinkedList f1530q = new LinkedList();
    public final HashMap E = new HashMap();
    public final d0.i J = new d0.i(this, 7);
    public long A = -1;

    /* renamed from: j, reason: collision with root package name */
    public final s4 f1523j = new s4(this);

    public v4(w4 w4Var) {
        this.f1525l = u1.s(w4Var.f1555a, null, null);
        a1 a1Var = new a1(this, 2);
        a1Var.i();
        this.g = a1Var;
        a1 a1Var2 = new a1(this, 0);
        a1Var2.i();
        this.f1519b = a1Var2;
        n1 n1Var = new n1(this);
        n1Var.i();
        this.f1518a = n1Var;
        this.B = new HashMap();
        this.C = new HashMap();
        this.D = new HashMap();
        b().p(new a4.a(this, w4Var));
    }

    public static v4 C(Context context) {
        i0.y.g(context);
        i0.y.g(context.getApplicationContext());
        if (K == null) {
            synchronized (v4.class) {
                try {
                    if (K == null) {
                        K = new v4(new w4(context, 0, false));
                    }
                } finally {
                }
            }
        }
        return K;
    }

    public static final void D(com.google.android.gms.internal.measurement.b3 b3Var, int i10, String str) {
        List listG = b3Var.g();
        for (int i11 = 0; i11 < listG.size(); i11++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.f3) listG.get(i11)).q())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.e3 e3VarB = com.google.android.gms.internal.measurement.f3.B();
        e3VarB.g("_err");
        e3VarB.i(i10);
        com.google.android.gms.internal.measurement.f3 f3Var = (com.google.android.gms.internal.measurement.f3) e3VarB.d();
        com.google.android.gms.internal.measurement.e3 e3VarB2 = com.google.android.gms.internal.measurement.f3.B();
        e3VarB2.g("_ev");
        e3VarB2.h(str);
        com.google.android.gms.internal.measurement.f3 f3Var2 = (com.google.android.gms.internal.measurement.f3) e3VarB2.d();
        b3Var.j(f3Var);
        b3Var.j(f3Var2);
    }

    public static final void E(com.google.android.gms.internal.measurement.b3 b3Var, String str) {
        List listG = b3Var.g();
        for (int i10 = 0; i10 < listG.size(); i10++) {
            if (str.equals(((com.google.android.gms.internal.measurement.f3) listG.get(i10)).q())) {
                b3Var.l(i10);
                return;
            }
        }
    }

    public static String M(String str, Map map) {
        if (map == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                if (((List) entry.getValue()).isEmpty()) {
                    return null;
                }
                return (String) ((List) entry.getValue()).get(0);
            }
        }
        return null;
    }

    public static void S(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 34) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        }
    }

    public static final boolean T(d5 d5Var) {
        return !TextUtils.isEmpty(d5Var.f1115b);
    }

    public static final void U(q4 q4Var) {
        if (q4Var == null) {
            androidx.window.layout.c.g("Upload Component not created");
        } else {
            if (q4Var.f1419c) {
                return;
            }
            androidx.window.layout.c.g("Component not initialized: ".concat(String.valueOf(q4Var.getClass())));
        }
    }

    public static final Boolean V(d5 d5Var) {
        Boolean bool = d5Var.f1125p;
        String str = d5Var.C;
        if (!TextUtils.isEmpty(str)) {
            int iOrdinal = ((h2) y2.c.E(str).f13781b).ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                return null;
            }
            if (iOrdinal == 2) {
                return Boolean.TRUE;
            }
            if (iOrdinal == 3) {
                return Boolean.FALSE;
            }
        }
        return bool;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x015a A[Catch: all -> 0x005f, TryCatch #1 {all -> 0x005f, blocks: (B:8:0x0030, B:18:0x004e, B:55:0x015d, B:26:0x006c, B:31:0x00c8, B:30:0x00b6, B:32:0x00cd, B:36:0x00de, B:40:0x00f4, B:42:0x010c, B:44:0x0127, B:46:0x0130, B:48:0x0136, B:49:0x013a, B:51:0x0143, B:53:0x0152, B:54:0x015a, B:43:0x0118, B:37:0x00e5, B:39:0x00ee), top: B:64:0x0030, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(java.lang.String r10, int r11, java.lang.Throwable r12, byte[] r13, java.util.Map r14) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.v4.A(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    public final void B() {
        b().g();
        l0();
        if (this.f1527n) {
            return;
        }
        this.f1527n = true;
        b().g();
        FileLock fileLock = this.f1535w;
        u1 u1Var = this.f1525l;
        if (fileLock == null || !fileLock.isValid()) {
            this.f1520c.f1149a.getClass();
            try {
                FileChannel channel = new RandomAccessFile(new File(new File(u1Var.f1475a.getFilesDir(), "google_app_measurement.db").getPath()), "rw").getChannel();
                this.f1536x = channel;
                FileLock fileLockTryLock = channel.tryLock();
                this.f1535w = fileLockTryLock;
                if (fileLockTryLock == null) {
                    a().f.b("Storage concurrent data access panic");
                    return;
                }
                a().f1545n.b("Storage concurrent access okay");
            } catch (FileNotFoundException e) {
                a().f.c(e, "Failed to acquire storage lock");
                return;
            } catch (IOException e3) {
                a().f.c(e3, "Failed to access storage lock file");
                return;
            } catch (OverlappingFileLockException e7) {
                a().f1540i.c(e7, "Storage lock already acquired");
                return;
            }
        } else {
            a().f1545n.b("Storage concurrent access okay");
        }
        FileChannel fileChannel = this.f1536x;
        b().g();
        int i10 = 0;
        if (fileChannel == null || !fileChannel.isOpen()) {
            a().f.b("Bad channel to read from");
        } else {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0L);
                int i11 = fileChannel.read(byteBufferAllocate);
                if (i11 == 4) {
                    byteBufferAllocate.flip();
                    i10 = byteBufferAllocate.getInt();
                } else if (i11 != -1) {
                    a().f1540i.c(Integer.valueOf(i11), "Unexpected data length. Bytes read");
                }
            } catch (IOException e10) {
                a().f.c(e10, "Failed to read from channel");
            }
        }
        n0 n0VarR = u1Var.r();
        n0VarR.h();
        int i12 = n0VarR.e;
        b().g();
        if (i10 > i12) {
            a().f.d(Integer.valueOf(i10), "Panic: can't downgrade version. Previous, current version", Integer.valueOf(i12));
            return;
        }
        if (i10 < i12) {
            FileChannel fileChannel2 = this.f1536x;
            b().g();
            if (fileChannel2 == null || !fileChannel2.isOpen()) {
                a().f.b("Bad channel to read from");
            } else {
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                byteBufferAllocate2.putInt(i12);
                byteBufferAllocate2.flip();
                try {
                    fileChannel2.truncate(0L);
                    fileChannel2.write(byteBufferAllocate2);
                    fileChannel2.force(true);
                    if (fileChannel2.size() != 4) {
                        a().f.c(Long.valueOf(fileChannel2.size()), "Error writing to channel. Bytes written");
                    }
                    a().f1545n.d(Integer.valueOf(i10), "Storage version upgraded. Previous, current version", Integer.valueOf(i12));
                    return;
                } catch (IOException e11) {
                    a().f.c(e11, "Failed to write to channel");
                }
            }
            a().f.d(Integer.valueOf(i10), "Storage version upgrade failed. Previous, current version", Integer.valueOf(i12));
        }
    }

    public final int F(String str, d0.i iVar) {
        h2 h2VarK;
        n1 n1Var = this.f1518a;
        com.google.android.gms.internal.measurement.b2 b2VarB = n1Var.B(str);
        j2 j2Var = j2.AD_PERSONALIZATION;
        if (b2VarB == null) {
            iVar.K(j2Var, h.FAILSAFE);
            return 1;
        }
        n nVar = this.f1520c;
        U(nVar);
        b1 b1VarI0 = nVar.i0(str);
        if (b1VarI0 == null || ((h2) y2.c.E(b1VarI0.s()).f13781b) != h2.POLICY || (h2VarK = n1Var.k(str, j2Var)) == h2.UNINITIALIZED) {
            iVar.K(j2Var, h.REMOTE_DEFAULT);
            if (n1Var.A(str, j2Var)) {
                return 0;
            }
        } else {
            iVar.K(j2Var, h.REMOTE_ENFORCED_DEFAULT);
            if (h2VarK == h2.GRANTED) {
                return 0;
            }
        }
        return 1;
    }

    public final HashMap G(com.google.android.gms.internal.measurement.c3 c3Var) {
        Serializable serializableV;
        HashMap map = new HashMap();
        j0();
        HashMap map2 = new HashMap();
        for (com.google.android.gms.internal.measurement.f3 f3Var : c3Var.p()) {
            if (f3Var.q().startsWith("gad_") && (serializableV = a1.v(f3Var)) != null) {
                map2.put(f3Var.q(), serializableV);
            }
        }
        for (Map.Entry entry : map2.entrySet()) {
            map.put((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        return map;
    }

    public final void H() {
        b().g();
        if (this.f1530q.isEmpty()) {
            return;
        }
        if (this.H == null) {
            this.H = new e4(this, this.f1525l, 2);
        }
        if (this.H.f1380c != 0) {
            return;
        }
        f().getClass();
        long jMax = Math.max(0L, ((Integer) f0.C0.a(null)).intValue() - (SystemClock.elapsedRealtime() - this.I));
        a().f1545n.c(Long.valueOf(jMax), "Scheduling notify next app runnable, delay in ms");
        if (this.H == null) {
            this.H = new e4(this, this.f1525l, 2);
        }
        this.H.b(jMax);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(40:8|(3:9|10|(4:12|13|(4:15|(1:22)|25|471)(18:26|27|(2:35|(3:37|(1:44)(1:43)|45)(0))(1:34)|46|(2:48|(3:50|(4:53|(1:476)(2:59|473)|60|51)|472))|61|62|(4:64|65|(0)(1:71)|(7:117|(5:121|(2:123|487)(2:124|(2:126|486)(1:488))|127|118|119)|485|128|(2:131|(3:137|(1:139)(2:140|(3:142|(3:145|(1:147)(1:504)|143)|503))|148)(2:135|136))(1:130)|149|(2:151|(6:(2:156|(6:158|159|193|(9:195|(4:198|(2:211|(2:213|490)(1:492))(5:202|(5:205|(2:208|206)|494|209|203)|493|210|491)|214|196)|489|215|(4:218|(3:496|220|499)(1:498)|497|216)|495|221|(1:223)|500)(1:224)|225|470))|160|193|(0)(0)|225|470)(7:161|162|192|193|(0)(0)|225|470))(2:163|(8:165|(6:(2:170|(6:172|159|193|(0)(0)|225|470))|173|193|(0)(0)|225|470)|162|192|193|(0)(0)|225|470)(7:174|(2:185|(2:186|(2:188|(2:502|190)(1:191))(1:501)))(0)|192|193|(0)(0)|225|470)))(3:136|149|(0)(0)))(1:72)|70|(3:73|74|(3:76|(2:78|479)(2:79|(2:81|480)(2:82|478))|83)(1:477))|84|(1:87)|(1:89)|90|(1:92)(1:93)|94|(4:99|(4:102|(2:104|483)(2:105|(2:107|482)(1:484))|108|100)|481|(1:(1:114)(1:115))(1:(1:111)(2:112|(0)(0))))|(0)(0))|226)(1:469))|227|(3:229|(2:231|(2:233|507)(2:234|(1:508)(3:236|(1:238)(1:239)|(1:510)(2:243|506))))(0)|244)|505|245|(3:246|247|(1:511)(2:249|(2:512|251)(1:513)))|252|(1:254)(2:255|(1:257))|258|(1:260)(1:261)|262|(1:264)(1:265)|266|(6:269|(1:271)|272|(2:274|515)(1:516)|275|267)|514|276|(2:281|(1:285))(1:280)|286|(1:288)|289|(1:291)|292|(2:294|(1:300))|301|(8:303|(8:307|308|(4:310|(2:312|(1:314))|(1:331)(5:318|(1:322)|324|(1:329)(1:328)|330)|332)(3:334|(4:465|336|341|(6:343|(3:346|(3:521|348|(3:350|354|(1:356)(6:357|(1:361)|362|(1:364)(1:366)|365|(3:368|(1:376)|377)(4:378|(3:380|(1:382)|383)(4:384|(1:386)(1:387)|388|(3:390|(1:392)|393)(2:394|(1:396)))|397|518)))(2:351|(0)(0)))(1:352)|344)|520|353|354|(0)(0))(3:353|354|(0)(0)))(3:340|341|(0)(0))|398)|333|519|398|304|305)|517|399|(1:401)|402|(2:405|403)|522)(1:406)|407|(1:409)(13:411|(9:413|(1:415)(1:416)|417|(1:419)(1:420)|421|(1:423)(1:424)|425|(1:427)(1:428)|429)|430|(3:432|(2:438|(1:440)(1:441))(1:437)|442)|443|(3:(2:447|524)(1:525)|448|444)|523|449|(1:451)|452|467|453|457)|410|430|(0)|443|(1:444)|523|449|(0)|452|467|453|457) */
    /* JADX WARN: Code restructure failed: missing block: B:455:0x0f1c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:456:0x0f1d, code lost:
    
        r2.f1149a.a().k().d(c1.w0.o(r1), "Failed to remove unused event metadata. appId", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03f6 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d19, B:334:0x0abd, B:336:0x0adb, B:341:0x0af6, B:343:0x0b16, B:344:0x0b1e, B:346:0x0b24, B:348:0x0b36, B:354:0x0b4c, B:356:0x0b62, B:357:0x0b85, B:359:0x0b91, B:361:0x0ba7, B:362:0x0be7, B:368:0x0c03, B:370:0x0c0e, B:372:0x0c12, B:374:0x0c16, B:376:0x0c1a, B:377:0x0c26, B:378:0x0c2b, B:380:0x0c31, B:382:0x0c49, B:383:0x0c4e, B:397:0x0d16, B:384:0x0c8d, B:386:0x0c92, B:390:0x0ca6, B:392:0x0cc5, B:393:0x0ccc, B:396:0x0d0a, B:387:0x0c97, B:339:0x0ae1, B:399:0x0d24, B:401:0x0d31, B:402:0x0d45, B:403:0x0d4d, B:405:0x0d53, B:407:0x0d69, B:409:0x0d7b, B:430:0x0e2b, B:432:0x0e31, B:434:0x0e46, B:437:0x0e4d, B:442:0x0e90, B:438:0x0e5c, B:440:0x0e6a, B:441:0x0e77, B:443:0x0e9f, B:444:0x0eb8, B:447:0x0ec0, B:448:0x0ec5, B:449:0x0ed5, B:451:0x0eef, B:452:0x0f0a, B:453:0x0f12, B:457:0x0f30, B:456:0x0f1d, B:411:0x0d97, B:413:0x0d9d, B:415:0x0dad, B:417:0x0db4, B:423:0x0dca, B:425:0x0dd1, B:427:0x0e1c, B:429:0x0e23, B:428:0x0e20, B:424:0x0dce, B:416:0x0db1, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f39), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0415 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d19, B:334:0x0abd, B:336:0x0adb, B:341:0x0af6, B:343:0x0b16, B:344:0x0b1e, B:346:0x0b24, B:348:0x0b36, B:354:0x0b4c, B:356:0x0b62, B:357:0x0b85, B:359:0x0b91, B:361:0x0ba7, B:362:0x0be7, B:368:0x0c03, B:370:0x0c0e, B:372:0x0c12, B:374:0x0c16, B:376:0x0c1a, B:377:0x0c26, B:378:0x0c2b, B:380:0x0c31, B:382:0x0c49, B:383:0x0c4e, B:397:0x0d16, B:384:0x0c8d, B:386:0x0c92, B:390:0x0ca6, B:392:0x0cc5, B:393:0x0ccc, B:396:0x0d0a, B:387:0x0c97, B:339:0x0ae1, B:399:0x0d24, B:401:0x0d31, B:402:0x0d45, B:403:0x0d4d, B:405:0x0d53, B:407:0x0d69, B:409:0x0d7b, B:430:0x0e2b, B:432:0x0e31, B:434:0x0e46, B:437:0x0e4d, B:442:0x0e90, B:438:0x0e5c, B:440:0x0e6a, B:441:0x0e77, B:443:0x0e9f, B:444:0x0eb8, B:447:0x0ec0, B:448:0x0ec5, B:449:0x0ed5, B:451:0x0eef, B:452:0x0f0a, B:453:0x0f12, B:457:0x0f30, B:456:0x0f1d, B:411:0x0d97, B:413:0x0d9d, B:415:0x0dad, B:417:0x0db4, B:423:0x0dca, B:425:0x0dd1, B:427:0x0e1c, B:429:0x0e23, B:428:0x0e20, B:424:0x0dce, B:416:0x0db1, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f39), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0430 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d19, B:334:0x0abd, B:336:0x0adb, B:341:0x0af6, B:343:0x0b16, B:344:0x0b1e, B:346:0x0b24, B:348:0x0b36, B:354:0x0b4c, B:356:0x0b62, B:357:0x0b85, B:359:0x0b91, B:361:0x0ba7, B:362:0x0be7, B:368:0x0c03, B:370:0x0c0e, B:372:0x0c12, B:374:0x0c16, B:376:0x0c1a, B:377:0x0c26, B:378:0x0c2b, B:380:0x0c31, B:382:0x0c49, B:383:0x0c4e, B:397:0x0d16, B:384:0x0c8d, B:386:0x0c92, B:390:0x0ca6, B:392:0x0cc5, B:393:0x0ccc, B:396:0x0d0a, B:387:0x0c97, B:339:0x0ae1, B:399:0x0d24, B:401:0x0d31, B:402:0x0d45, B:403:0x0d4d, B:405:0x0d53, B:407:0x0d69, B:409:0x0d7b, B:430:0x0e2b, B:432:0x0e31, B:434:0x0e46, B:437:0x0e4d, B:442:0x0e90, B:438:0x0e5c, B:440:0x0e6a, B:441:0x0e77, B:443:0x0e9f, B:444:0x0eb8, B:447:0x0ec0, B:448:0x0ec5, B:449:0x0ed5, B:451:0x0eef, B:452:0x0f0a, B:453:0x0f12, B:457:0x0f30, B:456:0x0f1d, B:411:0x0d97, B:413:0x0d9d, B:415:0x0dad, B:417:0x0db4, B:423:0x0dca, B:425:0x0dd1, B:427:0x0e1c, B:429:0x0e23, B:428:0x0e20, B:424:0x0dce, B:416:0x0db1, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f39), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04ef A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d19, B:334:0x0abd, B:336:0x0adb, B:341:0x0af6, B:343:0x0b16, B:344:0x0b1e, B:346:0x0b24, B:348:0x0b36, B:354:0x0b4c, B:356:0x0b62, B:357:0x0b85, B:359:0x0b91, B:361:0x0ba7, B:362:0x0be7, B:368:0x0c03, B:370:0x0c0e, B:372:0x0c12, B:374:0x0c16, B:376:0x0c1a, B:377:0x0c26, B:378:0x0c2b, B:380:0x0c31, B:382:0x0c49, B:383:0x0c4e, B:397:0x0d16, B:384:0x0c8d, B:386:0x0c92, B:390:0x0ca6, B:392:0x0cc5, B:393:0x0ccc, B:396:0x0d0a, B:387:0x0c97, B:339:0x0ae1, B:399:0x0d24, B:401:0x0d31, B:402:0x0d45, B:403:0x0d4d, B:405:0x0d53, B:407:0x0d69, B:409:0x0d7b, B:430:0x0e2b, B:432:0x0e31, B:434:0x0e46, B:437:0x0e4d, B:442:0x0e90, B:438:0x0e5c, B:440:0x0e6a, B:441:0x0e77, B:443:0x0e9f, B:444:0x0eb8, B:447:0x0ec0, B:448:0x0ec5, B:449:0x0ed5, B:451:0x0eef, B:452:0x0f0a, B:453:0x0f12, B:457:0x0f30, B:456:0x0f1d, B:411:0x0d97, B:413:0x0d9d, B:415:0x0dad, B:417:0x0db4, B:423:0x0dca, B:425:0x0dd1, B:427:0x0e1c, B:429:0x0e23, B:428:0x0e20, B:424:0x0dce, B:416:0x0db1, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f39), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0538 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d19, B:334:0x0abd, B:336:0x0adb, B:341:0x0af6, B:343:0x0b16, B:344:0x0b1e, B:346:0x0b24, B:348:0x0b36, B:354:0x0b4c, B:356:0x0b62, B:357:0x0b85, B:359:0x0b91, B:361:0x0ba7, B:362:0x0be7, B:368:0x0c03, B:370:0x0c0e, B:372:0x0c12, B:374:0x0c16, B:376:0x0c1a, B:377:0x0c26, B:378:0x0c2b, B:380:0x0c31, B:382:0x0c49, B:383:0x0c4e, B:397:0x0d16, B:384:0x0c8d, B:386:0x0c92, B:390:0x0ca6, B:392:0x0cc5, B:393:0x0ccc, B:396:0x0d0a, B:387:0x0c97, B:339:0x0ae1, B:399:0x0d24, B:401:0x0d31, B:402:0x0d45, B:403:0x0d4d, B:405:0x0d53, B:407:0x0d69, B:409:0x0d7b, B:430:0x0e2b, B:432:0x0e31, B:434:0x0e46, B:437:0x0e4d, B:442:0x0e90, B:438:0x0e5c, B:440:0x0e6a, B:441:0x0e77, B:443:0x0e9f, B:444:0x0eb8, B:447:0x0ec0, B:448:0x0ec5, B:449:0x0ed5, B:451:0x0eef, B:452:0x0f0a, B:453:0x0f12, B:457:0x0f30, B:456:0x0f1d, B:411:0x0d97, B:413:0x0d9d, B:415:0x0dad, B:417:0x0db4, B:423:0x0dca, B:425:0x0dd1, B:427:0x0e1c, B:429:0x0e23, B:428:0x0e20, B:424:0x0dce, B:416:0x0db1, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f39), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05e8 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d19, B:334:0x0abd, B:336:0x0adb, B:341:0x0af6, B:343:0x0b16, B:344:0x0b1e, B:346:0x0b24, B:348:0x0b36, B:354:0x0b4c, B:356:0x0b62, B:357:0x0b85, B:359:0x0b91, B:361:0x0ba7, B:362:0x0be7, B:368:0x0c03, B:370:0x0c0e, B:372:0x0c12, B:374:0x0c16, B:376:0x0c1a, B:377:0x0c26, B:378:0x0c2b, B:380:0x0c31, B:382:0x0c49, B:383:0x0c4e, B:397:0x0d16, B:384:0x0c8d, B:386:0x0c92, B:390:0x0ca6, B:392:0x0cc5, B:393:0x0ccc, B:396:0x0d0a, B:387:0x0c97, B:339:0x0ae1, B:399:0x0d24, B:401:0x0d31, B:402:0x0d45, B:403:0x0d4d, B:405:0x0d53, B:407:0x0d69, B:409:0x0d7b, B:430:0x0e2b, B:432:0x0e31, B:434:0x0e46, B:437:0x0e4d, B:442:0x0e90, B:438:0x0e5c, B:440:0x0e6a, B:441:0x0e77, B:443:0x0e9f, B:444:0x0eb8, B:447:0x0ec0, B:448:0x0ec5, B:449:0x0ed5, B:451:0x0eef, B:452:0x0f0a, B:453:0x0f12, B:457:0x0f30, B:456:0x0f1d, B:411:0x0d97, B:413:0x0d9d, B:415:0x0dad, B:417:0x0db4, B:423:0x0dca, B:425:0x0dd1, B:427:0x0e1c, B:429:0x0e23, B:428:0x0e20, B:424:0x0dce, B:416:0x0db1, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f39), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x06fc  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x074e A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d19, B:334:0x0abd, B:336:0x0adb, B:341:0x0af6, B:343:0x0b16, B:344:0x0b1e, B:346:0x0b24, B:348:0x0b36, B:354:0x0b4c, B:356:0x0b62, B:357:0x0b85, B:359:0x0b91, B:361:0x0ba7, B:362:0x0be7, B:368:0x0c03, B:370:0x0c0e, B:372:0x0c12, B:374:0x0c16, B:376:0x0c1a, B:377:0x0c26, B:378:0x0c2b, B:380:0x0c31, B:382:0x0c49, B:383:0x0c4e, B:397:0x0d16, B:384:0x0c8d, B:386:0x0c92, B:390:0x0ca6, B:392:0x0cc5, B:393:0x0ccc, B:396:0x0d0a, B:387:0x0c97, B:339:0x0ae1, B:399:0x0d24, B:401:0x0d31, B:402:0x0d45, B:403:0x0d4d, B:405:0x0d53, B:407:0x0d69, B:409:0x0d7b, B:430:0x0e2b, B:432:0x0e31, B:434:0x0e46, B:437:0x0e4d, B:442:0x0e90, B:438:0x0e5c, B:440:0x0e6a, B:441:0x0e77, B:443:0x0e9f, B:444:0x0eb8, B:447:0x0ec0, B:448:0x0ec5, B:449:0x0ed5, B:451:0x0eef, B:452:0x0f0a, B:453:0x0f12, B:457:0x0f30, B:456:0x0f1d, B:411:0x0d97, B:413:0x0d9d, B:415:0x0dad, B:417:0x0db4, B:423:0x0dca, B:425:0x0dd1, B:427:0x0e1c, B:429:0x0e23, B:428:0x0e20, B:424:0x0dce, B:416:0x0db1, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f39), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0b16 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d19, B:334:0x0abd, B:336:0x0adb, B:341:0x0af6, B:343:0x0b16, B:344:0x0b1e, B:346:0x0b24, B:348:0x0b36, B:354:0x0b4c, B:356:0x0b62, B:357:0x0b85, B:359:0x0b91, B:361:0x0ba7, B:362:0x0be7, B:368:0x0c03, B:370:0x0c0e, B:372:0x0c12, B:374:0x0c16, B:376:0x0c1a, B:377:0x0c26, B:378:0x0c2b, B:380:0x0c31, B:382:0x0c49, B:383:0x0c4e, B:397:0x0d16, B:384:0x0c8d, B:386:0x0c92, B:390:0x0ca6, B:392:0x0cc5, B:393:0x0ccc, B:396:0x0d0a, B:387:0x0c97, B:339:0x0ae1, B:399:0x0d24, B:401:0x0d31, B:402:0x0d45, B:403:0x0d4d, B:405:0x0d53, B:407:0x0d69, B:409:0x0d7b, B:430:0x0e2b, B:432:0x0e31, B:434:0x0e46, B:437:0x0e4d, B:442:0x0e90, B:438:0x0e5c, B:440:0x0e6a, B:441:0x0e77, B:443:0x0e9f, B:444:0x0eb8, B:447:0x0ec0, B:448:0x0ec5, B:449:0x0ed5, B:451:0x0eef, B:452:0x0f0a, B:453:0x0f12, B:457:0x0f30, B:456:0x0f1d, B:411:0x0d97, B:413:0x0d9d, B:415:0x0dad, B:417:0x0db4, B:423:0x0dca, B:425:0x0dd1, B:427:0x0e1c, B:429:0x0e23, B:428:0x0e20, B:424:0x0dce, B:416:0x0db1, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f39), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0b4a A[PHI: r2
      0x0b4a: PHI (r2v53 long) = (r2v52 long), (r2v76 long) binds: [B:342:0x0b14, B:520:0x0b4a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0b62 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d19, B:334:0x0abd, B:336:0x0adb, B:341:0x0af6, B:343:0x0b16, B:344:0x0b1e, B:346:0x0b24, B:348:0x0b36, B:354:0x0b4c, B:356:0x0b62, B:357:0x0b85, B:359:0x0b91, B:361:0x0ba7, B:362:0x0be7, B:368:0x0c03, B:370:0x0c0e, B:372:0x0c12, B:374:0x0c16, B:376:0x0c1a, B:377:0x0c26, B:378:0x0c2b, B:380:0x0c31, B:382:0x0c49, B:383:0x0c4e, B:397:0x0d16, B:384:0x0c8d, B:386:0x0c92, B:390:0x0ca6, B:392:0x0cc5, B:393:0x0ccc, B:396:0x0d0a, B:387:0x0c97, B:339:0x0ae1, B:399:0x0d24, B:401:0x0d31, B:402:0x0d45, B:403:0x0d4d, B:405:0x0d53, B:407:0x0d69, B:409:0x0d7b, B:430:0x0e2b, B:432:0x0e31, B:434:0x0e46, B:437:0x0e4d, B:442:0x0e90, B:438:0x0e5c, B:440:0x0e6a, B:441:0x0e77, B:443:0x0e9f, B:444:0x0eb8, B:447:0x0ec0, B:448:0x0ec5, B:449:0x0ed5, B:451:0x0eef, B:452:0x0f0a, B:453:0x0f12, B:457:0x0f30, B:456:0x0f1d, B:411:0x0d97, B:413:0x0d9d, B:415:0x0dad, B:417:0x0db4, B:423:0x0dca, B:425:0x0dd1, B:427:0x0e1c, B:429:0x0e23, B:428:0x0e20, B:424:0x0dce, B:416:0x0db1, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f39), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0b85 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d19, B:334:0x0abd, B:336:0x0adb, B:341:0x0af6, B:343:0x0b16, B:344:0x0b1e, B:346:0x0b24, B:348:0x0b36, B:354:0x0b4c, B:356:0x0b62, B:357:0x0b85, B:359:0x0b91, B:361:0x0ba7, B:362:0x0be7, B:368:0x0c03, B:370:0x0c0e, B:372:0x0c12, B:374:0x0c16, B:376:0x0c1a, B:377:0x0c26, B:378:0x0c2b, B:380:0x0c31, B:382:0x0c49, B:383:0x0c4e, B:397:0x0d16, B:384:0x0c8d, B:386:0x0c92, B:390:0x0ca6, B:392:0x0cc5, B:393:0x0ccc, B:396:0x0d0a, B:387:0x0c97, B:339:0x0ae1, B:399:0x0d24, B:401:0x0d31, B:402:0x0d45, B:403:0x0d4d, B:405:0x0d53, B:407:0x0d69, B:409:0x0d7b, B:430:0x0e2b, B:432:0x0e31, B:434:0x0e46, B:437:0x0e4d, B:442:0x0e90, B:438:0x0e5c, B:440:0x0e6a, B:441:0x0e77, B:443:0x0e9f, B:444:0x0eb8, B:447:0x0ec0, B:448:0x0ec5, B:449:0x0ed5, B:451:0x0eef, B:452:0x0f0a, B:453:0x0f12, B:457:0x0f30, B:456:0x0f1d, B:411:0x0d97, B:413:0x0d9d, B:415:0x0dad, B:417:0x0db4, B:423:0x0dca, B:425:0x0dd1, B:427:0x0e1c, B:429:0x0e23, B:428:0x0e20, B:424:0x0dce, B:416:0x0db1, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f39), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0e31 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d19, B:334:0x0abd, B:336:0x0adb, B:341:0x0af6, B:343:0x0b16, B:344:0x0b1e, B:346:0x0b24, B:348:0x0b36, B:354:0x0b4c, B:356:0x0b62, B:357:0x0b85, B:359:0x0b91, B:361:0x0ba7, B:362:0x0be7, B:368:0x0c03, B:370:0x0c0e, B:372:0x0c12, B:374:0x0c16, B:376:0x0c1a, B:377:0x0c26, B:378:0x0c2b, B:380:0x0c31, B:382:0x0c49, B:383:0x0c4e, B:397:0x0d16, B:384:0x0c8d, B:386:0x0c92, B:390:0x0ca6, B:392:0x0cc5, B:393:0x0ccc, B:396:0x0d0a, B:387:0x0c97, B:339:0x0ae1, B:399:0x0d24, B:401:0x0d31, B:402:0x0d45, B:403:0x0d4d, B:405:0x0d53, B:407:0x0d69, B:409:0x0d7b, B:430:0x0e2b, B:432:0x0e31, B:434:0x0e46, B:437:0x0e4d, B:442:0x0e90, B:438:0x0e5c, B:440:0x0e6a, B:441:0x0e77, B:443:0x0e9f, B:444:0x0eb8, B:447:0x0ec0, B:448:0x0ec5, B:449:0x0ed5, B:451:0x0eef, B:452:0x0f0a, B:453:0x0f12, B:457:0x0f30, B:456:0x0f1d, B:411:0x0d97, B:413:0x0d9d, B:415:0x0dad, B:417:0x0db4, B:423:0x0dca, B:425:0x0dd1, B:427:0x0e1c, B:429:0x0e23, B:428:0x0e20, B:424:0x0dce, B:416:0x0db1, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f39), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:446:0x0ebe  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x0eef A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d19, B:334:0x0abd, B:336:0x0adb, B:341:0x0af6, B:343:0x0b16, B:344:0x0b1e, B:346:0x0b24, B:348:0x0b36, B:354:0x0b4c, B:356:0x0b62, B:357:0x0b85, B:359:0x0b91, B:361:0x0ba7, B:362:0x0be7, B:368:0x0c03, B:370:0x0c0e, B:372:0x0c12, B:374:0x0c16, B:376:0x0c1a, B:377:0x0c26, B:378:0x0c2b, B:380:0x0c31, B:382:0x0c49, B:383:0x0c4e, B:397:0x0d16, B:384:0x0c8d, B:386:0x0c92, B:390:0x0ca6, B:392:0x0cc5, B:393:0x0ccc, B:396:0x0d0a, B:387:0x0c97, B:339:0x0ae1, B:399:0x0d24, B:401:0x0d31, B:402:0x0d45, B:403:0x0d4d, B:405:0x0d53, B:407:0x0d69, B:409:0x0d7b, B:430:0x0e2b, B:432:0x0e31, B:434:0x0e46, B:437:0x0e4d, B:442:0x0e90, B:438:0x0e5c, B:440:0x0e6a, B:441:0x0e77, B:443:0x0e9f, B:444:0x0eb8, B:447:0x0ec0, B:448:0x0ec5, B:449:0x0ed5, B:451:0x0eef, B:452:0x0f0a, B:453:0x0f12, B:457:0x0f30, B:456:0x0f1d, B:411:0x0d97, B:413:0x0d9d, B:415:0x0dad, B:417:0x0db4, B:423:0x0dca, B:425:0x0dd1, B:427:0x0e1c, B:429:0x0e23, B:428:0x0e20, B:424:0x0dce, B:416:0x0db1, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f39), top: B:464:0x0019, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean I(long r47, java.lang.String r49) {
        /*
            Method dump skipped, instructions count: 3921
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.v4.I(long, java.lang.String):boolean");
    }

    public final void J(com.google.android.gms.internal.measurement.j3 j3Var, long j10, boolean z9) {
        z4 z4Var;
        Object obj;
        String str = true != z9 ? "_lte" : "_se";
        n nVar = this.f1520c;
        U(nVar);
        z4 z4VarA0 = nVar.a0(j3Var.n(), str);
        if (z4VarA0 == null || (obj = z4VarA0.e) == null) {
            String strN = j3Var.n();
            f().getClass();
            z4Var = new z4(strN, "auto", str, System.currentTimeMillis(), Long.valueOf(j10));
        } else {
            String strN2 = j3Var.n();
            f().getClass();
            z4Var = new z4(strN2, "auto", str, System.currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j10));
        }
        com.google.android.gms.internal.measurement.s3 s3VarA = com.google.android.gms.internal.measurement.t3.A();
        s3VarA.b();
        ((com.google.android.gms.internal.measurement.t3) s3VarA.f2102b).C(str);
        f().getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        s3VarA.b();
        ((com.google.android.gms.internal.measurement.t3) s3VarA.f2102b).B(jCurrentTimeMillis);
        Object obj2 = z4Var.e;
        long jLongValue = ((Long) obj2).longValue();
        s3VarA.b();
        ((com.google.android.gms.internal.measurement.t3) s3VarA.f2102b).F(jLongValue);
        com.google.android.gms.internal.measurement.t3 t3Var = (com.google.android.gms.internal.measurement.t3) s3VarA.d();
        int iU = a1.U(j3Var, str);
        if (iU >= 0) {
            j3Var.b();
            ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).c0(iU, t3Var);
        } else {
            j3Var.b();
            ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).d0(t3Var);
        }
        if (j10 > 0) {
            n nVar2 = this.f1520c;
            U(nVar2);
            nVar2.Z(z4Var);
            a().f1545n.d(true != z9 ? "lifetime" : "session-scoped", "Updated engagement user property. scope, value", obj2);
        }
    }

    public final boolean K(com.google.android.gms.internal.measurement.b3 b3Var, com.google.android.gms.internal.measurement.b3 b3Var2) {
        i0.y.b("_e".equals(b3Var.m()));
        j0();
        com.google.android.gms.internal.measurement.f3 f3VarO = a1.o((com.google.android.gms.internal.measurement.c3) b3Var.d(), "_sc");
        String strS = f3VarO == null ? null : f3VarO.s();
        j0();
        com.google.android.gms.internal.measurement.f3 f3VarO2 = a1.o((com.google.android.gms.internal.measurement.c3) b3Var2.d(), "_pc");
        String strS2 = f3VarO2 != null ? f3VarO2.s() : null;
        if (strS2 == null || !strS2.equals(strS)) {
            return false;
        }
        i0.y.b("_e".equals(b3Var.m()));
        j0();
        com.google.android.gms.internal.measurement.f3 f3VarO3 = a1.o((com.google.android.gms.internal.measurement.c3) b3Var.d(), "_et");
        if (f3VarO3 == null || !f3VarO3.t() || f3VarO3.u() <= 0) {
            return true;
        }
        long jU = f3VarO3.u();
        j0();
        com.google.android.gms.internal.measurement.f3 f3VarO4 = a1.o((com.google.android.gms.internal.measurement.c3) b3Var2.d(), "_et");
        if (f3VarO4 != null && f3VarO4.u() > 0) {
            jU += f3VarO4.u();
        }
        j0();
        a1.m(b3Var2, "_et", Long.valueOf(jU));
        j0();
        a1.m(b3Var, "_fr", 1L);
        return true;
    }

    public final boolean L() {
        b().g();
        l0();
        n nVar = this.f1520c;
        U(nVar);
        if (nVar.Q("select count(1) > 0 from raw_events", null) != 0) {
            return true;
        }
        n nVar2 = this.f1520c;
        U(nVar2);
        return !TextUtils.isEmpty(nVar2.o());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x032e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N() {
        /*
            Method dump skipped, instructions count: 1020
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.v4.N():void");
    }

    public final void O() {
        b().g();
        if (this.t || this.f1533u || this.f1534v) {
            a().f1545n.e("Not stopping services. fetch, network, upload", Boolean.valueOf(this.t), Boolean.valueOf(this.f1533u), Boolean.valueOf(this.f1534v));
            return;
        }
        a().f1545n.b("Stopping uploading service(s)");
        ArrayList arrayList = this.f1529p;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((Runnable) obj).run();
        }
        ArrayList arrayList2 = this.f1529p;
        i0.y.g(arrayList2);
        arrayList2.clear();
    }

    public final Boolean P(b1 b1Var) {
        try {
            long jP = b1Var.P();
            u1 u1Var = this.f1525l;
            if (jP != -2147483648L) {
                if (b1Var.P() == p0.c.a(u1Var.f1475a).b(0, b1Var.D()).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = p0.c.a(u1Var.f1475a).b(0, b1Var.D()).versionName;
                String strN = b1Var.N();
                if (strN != null && strN.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final d5 Q(String str) {
        n nVar = this.f1520c;
        U(nVar);
        b1 b1VarI0 = nVar.i0(str);
        if (b1VarI0 != null) {
            u1 u1Var = b1VarI0.f1035a;
            if (!TextUtils.isEmpty(b1VarI0.N())) {
                Boolean boolP = P(b1VarI0);
                if (boolP != null && !boolP.booleanValue()) {
                    a().f.c(w0.o(str), "App version does not match; dropping. appId");
                    return null;
                }
                String strG = b1VarI0.G();
                String strN = b1VarI0.N();
                long jP = b1VarI0.P();
                r1 r1Var = u1Var.g;
                u1.m(r1Var);
                r1Var.g();
                String str2 = b1VarI0.f1042l;
                r1 r1Var2 = u1Var.g;
                u1.m(r1Var2);
                r1Var2.g();
                long j10 = b1VarI0.f1043m;
                r1 r1Var3 = u1Var.g;
                u1.m(r1Var3);
                r1Var3.g();
                long j11 = b1VarI0.f1044n;
                r1 r1Var4 = u1Var.g;
                u1.m(r1Var4);
                r1Var4.g();
                boolean z9 = b1VarI0.f1045o;
                String strJ = b1VarI0.J();
                r1 r1Var5 = u1Var.g;
                u1.m(r1Var5);
                r1Var5.g();
                boolean z10 = b1VarI0.f1046p;
                Boolean boolW = b1VarI0.w();
                long jB = b1VarI0.b();
                r1 r1Var6 = u1Var.g;
                u1.m(r1Var6);
                r1Var6.g();
                ArrayList arrayList = b1VarI0.f1049s;
                String strG2 = d(str).g();
                boolean zY = b1VarI0.y();
                r1 r1Var7 = u1Var.g;
                u1.m(r1Var7);
                r1Var7.g();
                long j12 = b1VarI0.f1051v;
                int i10 = d(str).f1303b;
                String str3 = o0(str).f1394b;
                r1 r1Var8 = u1Var.g;
                u1.m(r1Var8);
                r1Var8.g();
                int i11 = b1VarI0.f1053x;
                r1 r1Var9 = u1Var.g;
                u1.m(r1Var9);
                r1Var9.g();
                return new d5(str, strG, strN, jP, str2, j10, j11, (String) null, z9, false, strJ, 0L, 0, z10, false, boolW, jB, (List) arrayList, strG2, "", (String) null, zY, j12, i10, str3, i11, b1VarI0.B, b1VarI0.C(), b1VarI0.s(), 0L, b1VarI0.t());
            }
        }
        a().f1544m.c(str, "No app data available; dropping");
        return null;
    }

    public final boolean R(String str, String str2) {
        n nVar = this.f1520c;
        U(nVar);
        s sVarE = nVar.E("events", str, str2);
        return sVarE == null || sVarE.f1442c < 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void W(c1.y4 r24, c1.d5 r25) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.v4.W(c1.y4, c1.d5):void");
    }

    public final void X(String str, d5 d5Var) {
        b().g();
        l0();
        boolean zT = T(d5Var);
        String str2 = d5Var.f1114a;
        if (zT) {
            if (!d5Var.h) {
                c0(d5Var);
                return;
            }
            Boolean boolV = V(d5Var);
            if ("_npa".equals(str) && boolV != null) {
                a().f1544m.b("Falling back to manifest metadata value for ad personalization");
                f().getClass();
                W(new y4(System.currentTimeMillis(), Long.valueOf(true != boolV.booleanValue() ? 0L : 1L), "_npa", "auto"), d5Var);
                return;
            }
            u0 u0Var = a().f1544m;
            u1 u1Var = this.f1525l;
            u0Var.c(u1Var.f1480j.c(str), "Removing user property");
            n nVar = this.f1520c;
            U(nVar);
            nVar.S();
            try {
                c0(d5Var);
                if ("_id".equals(str)) {
                    n nVar2 = this.f1520c;
                    U(nVar2);
                    i0.y.g(str2);
                    nVar2.Y(str2, "_lair");
                }
                n nVar3 = this.f1520c;
                U(nVar3);
                i0.y.g(str2);
                nVar3.Y(str2, str);
                n nVar4 = this.f1520c;
                U(nVar4);
                nVar4.T();
                a().f1544m.c(u1Var.f1480j.c(str), "User property removed");
                n nVar5 = this.f1520c;
                U(nVar5);
                nVar5.U();
            } catch (Throwable th) {
                n nVar6 = this.f1520c;
                U(nVar6);
                nVar6.U();
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0420 A[Catch: all -> 0x02c8, TryCatch #4 {all -> 0x02c8, blocks: (B:105:0x0295, B:107:0x02b3, B:150:0x037c, B:151:0x037f, B:153:0x038c, B:154:0x039c, B:165:0x0444, B:112:0x02cb, B:117:0x02eb, B:119:0x02f3, B:121:0x02fa, B:125:0x030d, B:129:0x031f, B:133:0x032b, B:136:0x033e, B:141:0x035d, B:143:0x0365, B:145:0x036d, B:147:0x0373, B:139:0x034b, B:127:0x0318, B:115:0x02d9, B:155:0x03b5, B:157:0x03ea, B:158:0x03ed, B:160:0x03fa, B:161:0x0408, B:162:0x0420, B:164:0x0428), top: B:178:0x0136, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010d A[Catch: all -> 0x00c4, TryCatch #3 {all -> 0x00c4, blocks: (B:24:0x00a4, B:26:0x00b4, B:34:0x00cc, B:38:0x00dc, B:40:0x00eb, B:46:0x0100, B:48:0x010d, B:50:0x0118, B:53:0x0121, B:56:0x0138, B:59:0x0151, B:67:0x0199, B:54:0x012c, B:49:0x0114, B:42:0x00f5, B:45:0x00fd), top: B:176:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0114 A[Catch: all -> 0x00c4, TryCatch #3 {all -> 0x00c4, blocks: (B:24:0x00a4, B:26:0x00b4, B:34:0x00cc, B:38:0x00dc, B:40:0x00eb, B:46:0x0100, B:48:0x010d, B:50:0x0118, B:53:0x0121, B:56:0x0138, B:59:0x0151, B:67:0x0199, B:54:0x012c, B:49:0x0114, B:42:0x00f5, B:45:0x00fd), top: B:176:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0121 A[Catch: all -> 0x00c4, TRY_ENTER, TryCatch #3 {all -> 0x00c4, blocks: (B:24:0x00a4, B:26:0x00b4, B:34:0x00cc, B:38:0x00dc, B:40:0x00eb, B:46:0x0100, B:48:0x010d, B:50:0x0118, B:53:0x0121, B:56:0x0138, B:59:0x0151, B:67:0x0199, B:54:0x012c, B:49:0x0114, B:42:0x00f5, B:45:0x00fd), top: B:176:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012c A[Catch: all -> 0x00c4, TryCatch #3 {all -> 0x00c4, blocks: (B:24:0x00a4, B:26:0x00b4, B:34:0x00cc, B:38:0x00dc, B:40:0x00eb, B:46:0x0100, B:48:0x010d, B:50:0x0118, B:53:0x0121, B:56:0x0138, B:59:0x0151, B:67:0x0199, B:54:0x012c, B:49:0x0114, B:42:0x00f5, B:45:0x00fd), top: B:176:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0138 A[Catch: all -> 0x00c4, TRY_LEAVE, TryCatch #3 {all -> 0x00c4, blocks: (B:24:0x00a4, B:26:0x00b4, B:34:0x00cc, B:38:0x00dc, B:40:0x00eb, B:46:0x0100, B:48:0x010d, B:50:0x0118, B:53:0x0121, B:56:0x0138, B:59:0x0151, B:67:0x0199, B:54:0x012c, B:49:0x0114, B:42:0x00f5, B:45:0x00fd), top: B:176:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017b  */
    /* JADX WARN: Type inference failed for: r2v0, types: [c1.d5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v13, types: [c1.v4] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v5, types: [c1.v4] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y(c1.d5 r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1118
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.v4.Y(c1.d5):void");
    }

    public final void Z(e eVar, d5 d5Var) {
        v vVar;
        i0.y.d(eVar.f1134a);
        i0.y.g(eVar.f1135b);
        i0.y.g(eVar.f1136c);
        i0.y.d(eVar.f1136c.f1610b);
        b().g();
        l0();
        if (T(d5Var)) {
            if (!d5Var.h) {
                c0(d5Var);
                return;
            }
            e eVar2 = new e(eVar);
            boolean z9 = false;
            eVar2.e = false;
            n nVar = this.f1520c;
            U(nVar);
            nVar.S();
            try {
                n nVar2 = this.f1520c;
                U(nVar2);
                String str = eVar2.f1134a;
                i0.y.g(str);
                e eVarE0 = nVar2.e0(str, eVar2.f1136c.f1610b);
                u1 u1Var = this.f1525l;
                if (eVarE0 != null && !eVarE0.f1135b.equals(eVar2.f1135b)) {
                    a().f1540i.e("Updating a conditional user property with different origin. name, origin, origin (from DB)", u1Var.f1480j.c(eVar2.f1136c.f1610b), eVar2.f1135b, eVarE0.f1135b);
                }
                if (eVarE0 != null && eVarE0.e) {
                    eVar2.f1135b = eVarE0.f1135b;
                    eVar2.f1137d = eVarE0.f1137d;
                    eVar2.h = eVarE0.h;
                    eVar2.f = eVarE0.f;
                    eVar2.f1138i = eVarE0.f1138i;
                    eVar2.e = true;
                    y4 y4Var = eVar2.f1136c;
                    eVar2.f1136c = new y4(eVarE0.f1136c.f1611c, y4Var.b(), y4Var.f1610b, eVarE0.f1136c.f);
                } else if (TextUtils.isEmpty(eVar2.f)) {
                    y4 y4Var2 = eVar2.f1136c;
                    eVar2.f1136c = new y4(eVar2.f1137d, y4Var2.b(), y4Var2.f1610b, eVar2.f1136c.f);
                    eVar2.e = true;
                    z9 = true;
                }
                if (eVar2.e) {
                    y4 y4Var3 = eVar2.f1136c;
                    String str2 = eVar2.f1134a;
                    i0.y.g(str2);
                    String str3 = eVar2.f1135b;
                    String str4 = y4Var3.f1610b;
                    long j10 = y4Var3.f1611c;
                    Object objB = y4Var3.b();
                    i0.y.g(objB);
                    z4 z4Var = new z4(str2, str3, str4, j10, objB);
                    Object obj = z4Var.e;
                    String str5 = z4Var.f1631c;
                    n nVar3 = this.f1520c;
                    U(nVar3);
                    if (nVar3.Z(z4Var)) {
                        a().f1544m.e("User property updated immediately", eVar2.f1134a, u1Var.f1480j.c(str5), obj);
                    } else {
                        a().f.e("(2)Too many active user properties, ignoring", w0.o(eVar2.f1134a), u1Var.f1480j.c(str5), obj);
                    }
                    if (z9 && (vVar = eVar2.f1138i) != null) {
                        l(new v(vVar, eVar2.f1137d), d5Var);
                    }
                }
                n nVar4 = this.f1520c;
                U(nVar4);
                if (nVar4.d0(eVar2)) {
                    a().f1544m.e("Conditional property added", eVar2.f1134a, u1Var.f1480j.c(eVar2.f1136c.f1610b), eVar2.f1136c.b());
                } else {
                    a().f.e("Too many conditional properties, ignoring", w0.o(eVar2.f1134a), u1Var.f1480j.c(eVar2.f1136c.f1610b), eVar2.f1136c.b());
                }
                n nVar5 = this.f1520c;
                U(nVar5);
                nVar5.T();
                n nVar6 = this.f1520c;
                U(nVar6);
                nVar6.U();
            } catch (Throwable th) {
                n nVar7 = this.f1520c;
                U(nVar7);
                nVar7.U();
                throw th;
            }
        }
    }

    @Override // c1.g2
    public final w0 a() {
        u1 u1Var = this.f1525l;
        i0.y.g(u1Var);
        w0 w0Var = u1Var.f;
        u1.m(w0Var);
        return w0Var;
    }

    public final void a0(e eVar, d5 d5Var) {
        i0.y.d(eVar.f1134a);
        i0.y.g(eVar.f1136c);
        i0.y.d(eVar.f1136c.f1610b);
        b().g();
        l0();
        if (T(d5Var)) {
            if (!d5Var.h) {
                c0(d5Var);
                return;
            }
            n nVar = this.f1520c;
            U(nVar);
            nVar.S();
            try {
                c0(d5Var);
                String str = eVar.f1134a;
                i0.y.g(str);
                n nVar2 = this.f1520c;
                U(nVar2);
                e eVarE0 = nVar2.e0(str, eVar.f1136c.f1610b);
                u1 u1Var = this.f1525l;
                if (eVarE0 != null) {
                    a().f1544m.d(eVar.f1134a, "Removing conditional user property", u1Var.f1480j.c(eVar.f1136c.f1610b));
                    n nVar3 = this.f1520c;
                    U(nVar3);
                    nVar3.f0(str, eVar.f1136c.f1610b);
                    if (eVarE0.e) {
                        n nVar4 = this.f1520c;
                        U(nVar4);
                        nVar4.Y(str, eVar.f1136c.f1610b);
                    }
                    v vVar = eVar.f1140k;
                    if (vVar != null) {
                        u uVar = vVar.f1506b;
                        v vVarJ = k0().J(vVar.f1505a, uVar != null ? uVar.e() : null, eVarE0.f1135b, vVar.f1508d, true);
                        i0.y.g(vVarJ);
                        l(vVarJ, d5Var);
                    }
                } else {
                    a().f1540i.d(w0.o(eVar.f1134a), "Conditional user property doesn't exist", u1Var.f1480j.c(eVar.f1136c.f1610b));
                }
                n nVar5 = this.f1520c;
                U(nVar5);
                nVar5.T();
                n nVar6 = this.f1520c;
                U(nVar6);
                nVar6.U();
            } catch (Throwable th) {
                n nVar7 = this.f1520c;
                U(nVar7);
                nVar7.U();
                throw th;
            }
        }
    }

    @Override // c1.g2
    public final r1 b() {
        u1 u1Var = this.f1525l;
        i0.y.g(u1Var);
        r1 r1Var = u1Var.g;
        u1.m(r1Var);
        return r1Var;
    }

    public final void b0(d5 d5Var, long j10) throws Throwable {
        n nVar = this.f1520c;
        U(nVar);
        String str = d5Var.f1114a;
        i0.y.g(str);
        b1 b1VarI0 = nVar.i0(str);
        if (b1VarI0 != null) {
            k0();
            String str2 = d5Var.f1115b;
            String strG = b1VarI0.G();
            boolean zIsEmpty = TextUtils.isEmpty(str2);
            boolean zIsEmpty2 = TextUtils.isEmpty(strG);
            if (!zIsEmpty && !zIsEmpty2) {
                i0.y.g(str2);
                if (!str2.equals(strG)) {
                    a().f1540i.c(w0.o(b1VarI0.D()), "New GMP App Id passed in. Removing cached database data. appId");
                    n nVar2 = this.f1520c;
                    U(nVar2);
                    u1 u1Var = nVar2.f1149a;
                    String strD = b1VarI0.D();
                    nVar2.h();
                    nVar2.g();
                    i0.y.d(strD);
                    try {
                        SQLiteDatabase sQLiteDatabaseV = nVar2.V();
                        String[] strArr = {strD};
                        int iDelete = sQLiteDatabaseV.delete("events", "app_id=?", strArr) + sQLiteDatabaseV.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseV.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseV.delete("apps", "app_id=?", strArr) + sQLiteDatabaseV.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseV.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseV.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseV.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseV.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseV.delete("consent_settings", "app_id=?", strArr) + sQLiteDatabaseV.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseV.delete("trigger_uris", "app_id=?", strArr);
                        if (u1Var.f1478d.q(null, f0.f1175i1)) {
                            iDelete += sQLiteDatabaseV.delete("no_data_mode_events", "app_id=?", strArr);
                        }
                        if (iDelete > 0) {
                            w0 w0Var = u1Var.f;
                            u1.m(w0Var);
                            w0Var.f1545n.d(strD, "Deleted application data. app, records", Integer.valueOf(iDelete));
                        }
                    } catch (SQLiteException e) {
                        w0 w0Var2 = u1Var.f;
                        u1.m(w0Var2);
                        w0Var2.f.d(w0.o(strD), "Error deleting application data. appId, error", e);
                    }
                    b1VarI0 = null;
                }
            }
        }
        if (b1VarI0 != null) {
            boolean z9 = (b1VarI0.P() == -2147483648L || b1VarI0.P() == d5Var.f1119j) ? false : true;
            String strN = b1VarI0.N();
            if (z9 || ((b1VarI0.P() != -2147483648L || strN == null || strN.equals(d5Var.f1116c)) ? false : true)) {
                v vVar = new v("_au", new u(com.mbridge.msdk.dycreator.baseview.a.f("_pv", strN)), "auto", j10);
                if (e0().q(null, f0.f1164d1)) {
                    i(vVar, d5Var);
                } else {
                    j(vVar, d5Var);
                }
            }
        }
    }

    @Override // c1.g2
    public final o2.e c() {
        return this.f1525l.f1477c;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x028e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c1.b1 c0(c1.d5 r13) {
        /*
            Method dump skipped, instructions count: 680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.v4.c0(c1.d5):c1.b1");
    }

    public final k2 d(String str) {
        k2 k2Var = k2.f1301c;
        b().g();
        l0();
        HashMap map = this.B;
        k2 k2VarZ = (k2) map.get(str);
        if (k2VarZ == null) {
            n nVar = this.f1520c;
            U(nVar);
            k2VarZ = nVar.z(str);
            if (k2VarZ == null) {
                k2VarZ = k2.f1301c;
            }
            b().g();
            l0();
            map.put(str, k2VarZ);
            n nVar2 = this.f1520c;
            U(nVar2);
            nVar2.B(str, k2VarZ);
        }
        return k2VarZ;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    public final List d0(Bundle bundle, d5 d5Var) {
        int[] iArr;
        b().g();
        j8.a();
        g gVarE0 = e0();
        String str = d5Var.f1114a;
        if (!gVarE0.q(str, f0.Q0) || str == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    a().f.b("Uri sources and timestamps do not match");
                } else {
                    int i10 = 0;
                    while (i10 < intArray.length) {
                        n nVar = this.f1520c;
                        U(nVar);
                        u1 u1Var = nVar.f1149a;
                        int i11 = intArray[i10];
                        long j10 = longArray[i10];
                        i0.y.d(str);
                        nVar.g();
                        nVar.h();
                        try {
                            iArr = intArray;
                            try {
                                int iDelete = nVar.V().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i11), String.valueOf(j10)});
                                w0 w0Var = u1Var.f;
                                u1.m(w0Var);
                                u0 u0Var = w0Var.f1545n;
                                StringBuilder sb = new StringBuilder(String.valueOf(iDelete).length() + 46);
                                sb.append("Pruned ");
                                sb.append(iDelete);
                                sb.append(" trigger URIs. appId, source, timestamp");
                                u0Var.e(sb.toString(), str, Integer.valueOf(i11), Long.valueOf(j10));
                            } catch (SQLiteException e) {
                                e = e;
                                w0 w0Var2 = u1Var.f;
                                u1.m(w0Var2);
                                w0Var2.f.d(w0.o(str), "Error pruning trigger URIs. appId", e);
                                i10++;
                                intArray = iArr;
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            iArr = intArray;
                        }
                        i10++;
                        intArray = iArr;
                    }
                }
            }
        }
        n nVar2 = this.f1520c;
        U(nVar2);
        String str2 = d5Var.f1114a;
        i0.y.d(str2);
        nVar2.g();
        nVar2.h();
        ?? arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = nVar2.V().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str2}, null, null, "rowid", null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string == null) {
                            string = "";
                        }
                        arrayList.add(new k4(cursorQuery.getInt(2), cursorQuery.getLong(1), string));
                    } while (cursorQuery.moveToNext());
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e7) {
            w0 w0Var3 = nVar2.f1149a.f;
            u1.m(w0Var3);
            w0Var3.f.d(w0.o(str2), "Error querying trigger uris. appId", e7);
            arrayList = Collections.EMPTY_LIST;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    @Override // c1.g2
    public final Context e() {
        return this.f1525l.f1475a;
    }

    public final g e0() {
        u1 u1Var = this.f1525l;
        i0.y.g(u1Var);
        return u1Var.f1478d;
    }

    @Override // c1.g2
    public final n0.a f() {
        u1 u1Var = this.f1525l;
        i0.y.g(u1Var);
        return u1Var.f1481k;
    }

    public final n1 f0() {
        n1 n1Var = this.f1518a;
        U(n1Var);
        return n1Var;
    }

    public final long g() {
        f().getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        z3 z3Var = this.f1522i;
        z3Var.h();
        z3Var.g();
        e1 e1Var = z3Var.f1628j;
        long jA = e1Var.a();
        if (jA == 0) {
            u1.k(z3Var.f1149a.f1479i);
            jA = r2.e0().nextInt(86400000) + 1;
            e1Var.b(jA);
        }
        return ((((jCurrentTimeMillis + jA) / 1000) / 60) / 60) / 24;
    }

    public final n g0() {
        n nVar = this.f1520c;
        U(nVar);
        return nVar;
    }

    public final void h(v vVar, String str) {
        n nVar = this.f1520c;
        U(nVar);
        b1 b1VarI0 = nVar.i0(str);
        if (b1VarI0 != null) {
            u1 u1Var = b1VarI0.f1035a;
            if (!TextUtils.isEmpty(b1VarI0.N())) {
                Boolean boolP = P(b1VarI0);
                if (boolP == null) {
                    if (!"_ui".equals(vVar.f1505a)) {
                        a().f1540i.c(w0.o(str), "Could not find package. appId");
                    }
                } else if (!boolP.booleanValue()) {
                    a().f.c(w0.o(str), "App version does not match; dropping event. appId");
                    return;
                }
                String strG = b1VarI0.G();
                String strN = b1VarI0.N();
                long jP = b1VarI0.P();
                r1 r1Var = u1Var.g;
                u1.m(r1Var);
                r1Var.g();
                String str2 = b1VarI0.f1042l;
                r1 r1Var2 = u1Var.g;
                u1.m(r1Var2);
                r1Var2.g();
                long j10 = b1VarI0.f1043m;
                r1 r1Var3 = u1Var.g;
                u1.m(r1Var3);
                r1Var3.g();
                long j11 = b1VarI0.f1044n;
                r1 r1Var4 = u1Var.g;
                u1.m(r1Var4);
                r1Var4.g();
                boolean z9 = b1VarI0.f1045o;
                String strJ = b1VarI0.J();
                r1 r1Var5 = u1Var.g;
                u1.m(r1Var5);
                r1Var5.g();
                boolean z10 = b1VarI0.f1046p;
                Boolean boolW = b1VarI0.w();
                long jB = b1VarI0.b();
                r1 r1Var6 = u1Var.g;
                u1.m(r1Var6);
                r1Var6.g();
                ArrayList arrayList = b1VarI0.f1049s;
                String strG2 = d(str).g();
                boolean zY = b1VarI0.y();
                r1 r1Var7 = u1Var.g;
                u1.m(r1Var7);
                r1Var7.g();
                long j12 = b1VarI0.f1051v;
                int i10 = d(str).f1303b;
                String str3 = o0(str).f1394b;
                r1 r1Var8 = u1Var.g;
                u1.m(r1Var8);
                r1Var8.g();
                int i11 = b1VarI0.f1053x;
                r1 r1Var9 = u1Var.g;
                u1.m(r1Var9);
                r1Var9.g();
                i(vVar, new d5(str, strG, strN, jP, str2, j10, j11, (String) null, z9, false, strJ, 0L, 0, z10, false, boolW, jB, (List) arrayList, strG2, "", (String) null, zY, j12, i10, str3, i11, b1VarI0.B, b1VarI0.C(), b1VarI0.s(), 0L, b1VarI0.t()));
                return;
            }
        }
        a().f1544m.c(str, "No app data available; dropping event");
    }

    public final c1 h0() {
        c1 c1Var = this.f1521d;
        if (c1Var != null) {
            return c1Var;
        }
        androidx.window.layout.c.g("Network broadcast receiver not created");
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x007e: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:127), block:B:18:0x007e */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(c1.v r11, c1.d5 r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.v4.i(c1.v, c1.d5):void");
    }

    public final c i0() {
        c cVar = this.f;
        U(cVar);
        return cVar;
    }

    public final void j(v vVar, d5 d5Var) {
        v vVar2;
        List listH0;
        u1 u1Var;
        List listH02;
        List<e> listH03;
        String str;
        i0.y.g(d5Var);
        String str2 = d5Var.f1114a;
        i0.y.d(str2);
        b().g();
        l0();
        long j10 = vVar.f1508d;
        x0 x0VarL = x0.l(vVar);
        b().g();
        b5.Y((this.F == null || (str = this.G) == null || !str.equals(str2)) ? null : this.F, (Bundle) x0VarL.e, false);
        v vVarN = x0VarL.n();
        j0();
        if (TextUtils.isEmpty(d5Var.f1115b)) {
            return;
        }
        if (!d5Var.h) {
            c0(d5Var);
            return;
        }
        List list = d5Var.f1127r;
        if (list != null) {
            String str3 = vVarN.f1505a;
            if (!list.contains(str3)) {
                a().f1544m.e("Dropping non-safelisted event. appId, event name, origin", str2, vVarN.f1505a, vVarN.f1507c);
                return;
            } else {
                Bundle bundleE = vVarN.f1506b.e();
                bundleE.putLong("ga_safelisted", 1L);
                vVar2 = new v(str3, new u(bundleE), vVarN.f1507c, vVarN.f1508d);
            }
        } else {
            vVar2 = vVarN;
        }
        n nVar = this.f1520c;
        U(nVar);
        nVar.S();
        try {
            String str4 = vVar2.f1505a;
            if ("_s".equals(str4)) {
                n nVar2 = this.f1520c;
                U(nVar2);
                if (!nVar2.v(str2, "_s") && vVar2.f1506b.f1470a.getLong("_sid") != 0) {
                    n nVar3 = this.f1520c;
                    U(nVar3);
                    if (nVar3.v(str2, "_f")) {
                        n nVar4 = this.f1520c;
                        U(nVar4);
                        nVar4.y(str2, null, "_sid", k(vVar2, str2));
                    } else {
                        n nVar5 = this.f1520c;
                        U(nVar5);
                        if (nVar5.v(str2, "_v")) {
                            n nVar42 = this.f1520c;
                            U(nVar42);
                            nVar42.y(str2, null, "_sid", k(vVar2, str2));
                        } else {
                            n nVar6 = this.f1520c;
                            U(nVar6);
                            f().getClass();
                            nVar6.y(str2, Long.valueOf(System.currentTimeMillis() - 15000), "_sid", k(vVar2, str2));
                        }
                    }
                }
            }
            n nVar7 = this.f1520c;
            U(nVar7);
            i0.y.d(str2);
            nVar7.g();
            nVar7.h();
            if (j10 < 0) {
                w0 w0Var = nVar7.f1149a.f;
                u1.m(w0Var);
                w0Var.f1540i.d(w0.o(str2), "Invalid time querying timed out conditional properties", Long.valueOf(j10));
                listH0 = Collections.EMPTY_LIST;
            } else {
                listH0 = nVar7.h0("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j10)});
            }
            Iterator it = listH0.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                u1Var = this.f1525l;
                if (!zHasNext) {
                    break;
                }
                e eVar = (e) it.next();
                if (eVar != null) {
                    a().f1545n.e("User property timed out", eVar.f1134a, u1Var.f1480j.c(eVar.f1136c.f1610b), eVar.f1136c.b());
                    v vVar3 = eVar.g;
                    if (vVar3 != null) {
                        l(new v(vVar3, j10), d5Var);
                    }
                    n nVar8 = this.f1520c;
                    U(nVar8);
                    nVar8.f0(str2, eVar.f1136c.f1610b);
                }
            }
            n nVar9 = this.f1520c;
            U(nVar9);
            i0.y.d(str2);
            nVar9.g();
            nVar9.h();
            if (j10 < 0) {
                w0 w0Var2 = nVar9.f1149a.f;
                u1.m(w0Var2);
                w0Var2.f1540i.d(w0.o(str2), "Invalid time querying expired conditional properties", Long.valueOf(j10));
                listH02 = Collections.EMPTY_LIST;
            } else {
                listH02 = nVar9.h0("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j10)});
            }
            ArrayList arrayList = new ArrayList(listH02.size());
            Iterator it2 = listH02.iterator();
            while (it2.hasNext()) {
                e eVar2 = (e) it2.next();
                if (eVar2 != null) {
                    Iterator it3 = it2;
                    a().f1545n.e("User property expired", eVar2.f1134a, u1Var.f1480j.c(eVar2.f1136c.f1610b), eVar2.f1136c.b());
                    n nVar10 = this.f1520c;
                    U(nVar10);
                    nVar10.Y(str2, eVar2.f1136c.f1610b);
                    v vVar4 = eVar2.f1140k;
                    if (vVar4 != null) {
                        arrayList.add(vVar4);
                    }
                    n nVar11 = this.f1520c;
                    U(nVar11);
                    nVar11.f0(str2, eVar2.f1136c.f1610b);
                    it2 = it3;
                }
            }
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                l(new v((v) obj, j10), d5Var);
            }
            n nVar12 = this.f1520c;
            U(nVar12);
            i0.y.d(str2);
            i0.y.d(str4);
            nVar12.g();
            nVar12.h();
            if (j10 < 0) {
                u1 u1Var2 = nVar12.f1149a;
                w0 w0Var3 = u1Var2.f;
                u1.m(w0Var3);
                w0Var3.f1540i.e("Invalid time querying triggered conditional properties", w0.o(str2), u1Var2.f1480j.a(str4), Long.valueOf(j10));
                listH03 = Collections.EMPTY_LIST;
            } else {
                listH03 = nVar12.h0("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j10)});
            }
            ArrayList arrayList2 = new ArrayList(listH03.size());
            for (e eVar3 : listH03) {
                if (eVar3 != null) {
                    y4 y4Var = eVar3.f1136c;
                    String str5 = eVar3.f1134a;
                    i0.y.g(str5);
                    String str6 = eVar3.f1135b;
                    String str7 = y4Var.f1610b;
                    Object objB = y4Var.b();
                    i0.y.g(objB);
                    z4 z4Var = new z4(str5, str6, str7, j10, objB);
                    Object obj2 = z4Var.e;
                    String str8 = z4Var.f1631c;
                    n nVar13 = this.f1520c;
                    U(nVar13);
                    if (nVar13.Z(z4Var)) {
                        a().f1545n.e("User property triggered", eVar3.f1134a, u1Var.f1480j.c(str8), obj2);
                    } else {
                        a().f.e("Too many active user properties, ignoring", w0.o(eVar3.f1134a), u1Var.f1480j.c(str8), obj2);
                    }
                    v vVar5 = eVar3.f1138i;
                    if (vVar5 != null) {
                        arrayList2.add(vVar5);
                    }
                    eVar3.f1136c = new y4(z4Var);
                    eVar3.e = true;
                    n nVar14 = this.f1520c;
                    U(nVar14);
                    nVar14.d0(eVar3);
                }
            }
            l(vVar2, d5Var);
            int size2 = arrayList2.size();
            int i11 = 0;
            while (i11 < size2) {
                Object obj3 = arrayList2.get(i11);
                i11++;
                l(new v((v) obj3, j10), d5Var);
            }
            n nVar15 = this.f1520c;
            U(nVar15);
            nVar15.T();
            n nVar16 = this.f1520c;
            U(nVar16);
            nVar16.U();
        } catch (Throwable th) {
            n nVar17 = this.f1520c;
            U(nVar17);
            nVar17.U();
            throw th;
        }
    }

    public final a1 j0() {
        a1 a1Var = this.g;
        U(a1Var);
        return a1Var;
    }

    public final Bundle k(v vVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", vVar.f1506b.f1470a.getLong("_sid"));
        n nVar = this.f1520c;
        U(nVar);
        z4 z4VarA0 = nVar.a0(str, "_sno");
        if (z4VarA0 != null) {
            Object obj = z4VarA0.e;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    public final b5 k0() {
        u1 u1Var = this.f1525l;
        i0.y.g(u1Var);
        b5 b5Var = u1Var.f1479i;
        u1.k(b5Var);
        return b5Var;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:74|(12:76|(0)(1:79)|80|87|(1:89)|91|(0)(0)|94|102|(0)(0)|157|158)|78|81|396|82|86|80|87|(0)(0)|91|(0)(0)|94|102|(0)(0)|157|158) */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02fd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02fe, code lost:
    
        r10.f1149a.a().k().d(c1.w0.o(r13), "Error pruning currencies. appId", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x03e3 A[Catch: all -> 0x01eb, TryCatch #8 {all -> 0x01eb, blocks: (B:35:0x01cc, B:38:0x01d9, B:40:0x01e1, B:46:0x01ef, B:91:0x036a, B:102:0x03a7, B:104:0x03e3, B:106:0x03e8, B:107:0x03ff, B:109:0x040a, B:111:0x0424, B:113:0x042a, B:114:0x0441, B:117:0x0460, B:121:0x0482, B:122:0x0499, B:123:0x04a2, B:126:0x04bf, B:127:0x04d3, B:129:0x04db, B:131:0x04e5, B:133:0x04eb, B:134:0x04f2, B:136:0x04ff, B:138:0x0507, B:140:0x050f, B:142:0x0517, B:143:0x0523, B:144:0x0530, B:150:0x0574, B:151:0x0589, B:153:0x05b6, B:156:0x05e0, B:160:0x0630, B:163:0x065e, B:165:0x068b, B:166:0x068e, B:168:0x0694, B:170:0x069c, B:172:0x06a2, B:174:0x06aa, B:176:0x06b0, B:180:0x06bf, B:183:0x06ce, B:185:0x06d7, B:187:0x06df, B:190:0x0710, B:192:0x0719, B:196:0x072e, B:201:0x073b, B:236:0x07b6, B:237:0x07bd, B:239:0x07e0, B:242:0x07e9, B:246:0x07f4, B:247:0x080e, B:249:0x0814, B:251:0x082e, B:253:0x083a, B:255:0x0847, B:262:0x0878, B:266:0x0882, B:267:0x0885, B:269:0x0892, B:270:0x0895, B:281:0x08d9, B:260:0x0866, B:240:0x07e3, B:204:0x0744, B:208:0x0751, B:212:0x075f, B:216:0x076d, B:220:0x077b, B:224:0x0789, B:228:0x0795, B:232:0x07a3, B:162:0x0651, B:147:0x055b, B:95:0x037c, B:96:0x0388, B:98:0x038e, B:100:0x039c, B:54:0x020f, B:57:0x021d, B:59:0x0232, B:65:0x024a, B:70:0x027a, B:72:0x0280, B:74:0x028e, B:76:0x029c, B:79:0x02a5, B:87:0x032c, B:89:0x0336, B:81:0x02d2, B:82:0x02eb, B:86:0x0311, B:85:0x02fe, B:68:0x0256, B:69:0x0274), top: B:395:0x01cc, inners: #0, #7, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x07b0  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0882 A[Catch: all -> 0x01eb, TryCatch #8 {all -> 0x01eb, blocks: (B:35:0x01cc, B:38:0x01d9, B:40:0x01e1, B:46:0x01ef, B:91:0x036a, B:102:0x03a7, B:104:0x03e3, B:106:0x03e8, B:107:0x03ff, B:109:0x040a, B:111:0x0424, B:113:0x042a, B:114:0x0441, B:117:0x0460, B:121:0x0482, B:122:0x0499, B:123:0x04a2, B:126:0x04bf, B:127:0x04d3, B:129:0x04db, B:131:0x04e5, B:133:0x04eb, B:134:0x04f2, B:136:0x04ff, B:138:0x0507, B:140:0x050f, B:142:0x0517, B:143:0x0523, B:144:0x0530, B:150:0x0574, B:151:0x0589, B:153:0x05b6, B:156:0x05e0, B:160:0x0630, B:163:0x065e, B:165:0x068b, B:166:0x068e, B:168:0x0694, B:170:0x069c, B:172:0x06a2, B:174:0x06aa, B:176:0x06b0, B:180:0x06bf, B:183:0x06ce, B:185:0x06d7, B:187:0x06df, B:190:0x0710, B:192:0x0719, B:196:0x072e, B:201:0x073b, B:236:0x07b6, B:237:0x07bd, B:239:0x07e0, B:242:0x07e9, B:246:0x07f4, B:247:0x080e, B:249:0x0814, B:251:0x082e, B:253:0x083a, B:255:0x0847, B:262:0x0878, B:266:0x0882, B:267:0x0885, B:269:0x0892, B:270:0x0895, B:281:0x08d9, B:260:0x0866, B:240:0x07e3, B:204:0x0744, B:208:0x0751, B:212:0x075f, B:216:0x076d, B:220:0x077b, B:224:0x0789, B:228:0x0795, B:232:0x07a3, B:162:0x0651, B:147:0x055b, B:95:0x037c, B:96:0x0388, B:98:0x038e, B:100:0x039c, B:54:0x020f, B:57:0x021d, B:59:0x0232, B:65:0x024a, B:70:0x027a, B:72:0x0280, B:74:0x028e, B:76:0x029c, B:79:0x02a5, B:87:0x032c, B:89:0x0336, B:81:0x02d2, B:82:0x02eb, B:86:0x0311, B:85:0x02fe, B:68:0x0256, B:69:0x0274), top: B:395:0x01cc, inners: #0, #7, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0892 A[Catch: all -> 0x01eb, TryCatch #8 {all -> 0x01eb, blocks: (B:35:0x01cc, B:38:0x01d9, B:40:0x01e1, B:46:0x01ef, B:91:0x036a, B:102:0x03a7, B:104:0x03e3, B:106:0x03e8, B:107:0x03ff, B:109:0x040a, B:111:0x0424, B:113:0x042a, B:114:0x0441, B:117:0x0460, B:121:0x0482, B:122:0x0499, B:123:0x04a2, B:126:0x04bf, B:127:0x04d3, B:129:0x04db, B:131:0x04e5, B:133:0x04eb, B:134:0x04f2, B:136:0x04ff, B:138:0x0507, B:140:0x050f, B:142:0x0517, B:143:0x0523, B:144:0x0530, B:150:0x0574, B:151:0x0589, B:153:0x05b6, B:156:0x05e0, B:160:0x0630, B:163:0x065e, B:165:0x068b, B:166:0x068e, B:168:0x0694, B:170:0x069c, B:172:0x06a2, B:174:0x06aa, B:176:0x06b0, B:180:0x06bf, B:183:0x06ce, B:185:0x06d7, B:187:0x06df, B:190:0x0710, B:192:0x0719, B:196:0x072e, B:201:0x073b, B:236:0x07b6, B:237:0x07bd, B:239:0x07e0, B:242:0x07e9, B:246:0x07f4, B:247:0x080e, B:249:0x0814, B:251:0x082e, B:253:0x083a, B:255:0x0847, B:262:0x0878, B:266:0x0882, B:267:0x0885, B:269:0x0892, B:270:0x0895, B:281:0x08d9, B:260:0x0866, B:240:0x07e3, B:204:0x0744, B:208:0x0751, B:212:0x075f, B:216:0x076d, B:220:0x077b, B:224:0x0789, B:228:0x0795, B:232:0x07a3, B:162:0x0651, B:147:0x055b, B:95:0x037c, B:96:0x0388, B:98:0x038e, B:100:0x039c, B:54:0x020f, B:57:0x021d, B:59:0x0232, B:65:0x024a, B:70:0x027a, B:72:0x0280, B:74:0x028e, B:76:0x029c, B:79:0x02a5, B:87:0x032c, B:89:0x0336, B:81:0x02d2, B:82:0x02eb, B:86:0x0311, B:85:0x02fe, B:68:0x0256, B:69:0x0274), top: B:395:0x01cc, inners: #0, #7, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0961  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x09a6 A[Catch: all -> 0x093a, TryCatch #6 {all -> 0x093a, blocks: (B:273:0x08ab, B:275:0x08b6, B:277:0x08c4, B:279:0x08ce, B:282:0x08e2, B:284:0x08ec, B:286:0x08f8, B:288:0x0902, B:290:0x0910, B:292:0x0928, B:296:0x0941, B:298:0x094f, B:299:0x0958, B:301:0x0963, B:303:0x09a6, B:306:0x09b1, B:307:0x09bb, B:308:0x09bc, B:310:0x09c6, B:276:0x08bb), top: B:392:0x08ab }] */
    /* JADX WARN: Removed duplicated region for block: B:310:0x09c6 A[Catch: all -> 0x093a, TRY_LEAVE, TryCatch #6 {all -> 0x093a, blocks: (B:273:0x08ab, B:275:0x08b6, B:277:0x08c4, B:279:0x08ce, B:282:0x08e2, B:284:0x08ec, B:286:0x08f8, B:288:0x0902, B:290:0x0910, B:292:0x0928, B:296:0x0941, B:298:0x094f, B:299:0x0958, B:301:0x0963, B:303:0x09a6, B:306:0x09b1, B:307:0x09bb, B:308:0x09bc, B:310:0x09c6, B:276:0x08bb), top: B:392:0x08ab }] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0a2c  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0a37 A[Catch: all -> 0x09f4, TryCatch #1 {all -> 0x09f4, blocks: (B:312:0x09cf, B:314:0x09e6, B:318:0x09f7, B:320:0x0a2f, B:322:0x0a37, B:324:0x0a41, B:325:0x0a4b, B:327:0x0a55, B:328:0x0a5f, B:329:0x0a68, B:331:0x0a6e, B:333:0x0ab8, B:335:0x0aca, B:339:0x0ae9, B:341:0x0af9, B:338:0x0ad9, B:345:0x0b0c, B:346:0x0b4e, B:347:0x0b59, B:348:0x0b6c, B:350:0x0b72, B:359:0x0bb9, B:360:0x0c01, B:362:0x0c12, B:376:0x0c73, B:367:0x0c2a, B:368:0x0c2d, B:353:0x0b80, B:355:0x0ba6, B:373:0x0c46, B:374:0x0c5d, B:375:0x0c5e), top: B:384:0x09cf, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0a55 A[Catch: all -> 0x09f4, TryCatch #1 {all -> 0x09f4, blocks: (B:312:0x09cf, B:314:0x09e6, B:318:0x09f7, B:320:0x0a2f, B:322:0x0a37, B:324:0x0a41, B:325:0x0a4b, B:327:0x0a55, B:328:0x0a5f, B:329:0x0a68, B:331:0x0a6e, B:333:0x0ab8, B:335:0x0aca, B:339:0x0ae9, B:341:0x0af9, B:338:0x0ad9, B:345:0x0b0c, B:346:0x0b4e, B:347:0x0b59, B:348:0x0b6c, B:350:0x0b72, B:359:0x0bb9, B:360:0x0c01, B:362:0x0c12, B:376:0x0c73, B:367:0x0c2a, B:368:0x0c2d, B:353:0x0b80, B:355:0x0ba6, B:373:0x0c46, B:374:0x0c5d, B:375:0x0c5e), top: B:384:0x09cf, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0a6e A[Catch: all -> 0x09f4, TryCatch #1 {all -> 0x09f4, blocks: (B:312:0x09cf, B:314:0x09e6, B:318:0x09f7, B:320:0x0a2f, B:322:0x0a37, B:324:0x0a41, B:325:0x0a4b, B:327:0x0a55, B:328:0x0a5f, B:329:0x0a68, B:331:0x0a6e, B:333:0x0ab8, B:335:0x0aca, B:339:0x0ae9, B:341:0x0af9, B:338:0x0ad9, B:345:0x0b0c, B:346:0x0b4e, B:347:0x0b59, B:348:0x0b6c, B:350:0x0b72, B:359:0x0bb9, B:360:0x0c01, B:362:0x0c12, B:376:0x0c73, B:367:0x0c2a, B:368:0x0c2d, B:353:0x0b80, B:355:0x0ba6, B:373:0x0c46, B:374:0x0c5d, B:375:0x0c5e), top: B:384:0x09cf, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0b04  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0b72 A[Catch: all -> 0x09f4, TryCatch #1 {all -> 0x09f4, blocks: (B:312:0x09cf, B:314:0x09e6, B:318:0x09f7, B:320:0x0a2f, B:322:0x0a37, B:324:0x0a41, B:325:0x0a4b, B:327:0x0a55, B:328:0x0a5f, B:329:0x0a68, B:331:0x0a6e, B:333:0x0ab8, B:335:0x0aca, B:339:0x0ae9, B:341:0x0af9, B:338:0x0ad9, B:345:0x0b0c, B:346:0x0b4e, B:347:0x0b59, B:348:0x0b6c, B:350:0x0b72, B:359:0x0bb9, B:360:0x0c01, B:362:0x0c12, B:376:0x0c73, B:367:0x0c2a, B:368:0x0c2d, B:353:0x0b80, B:355:0x0ba6, B:373:0x0c46, B:374:0x0c5d, B:375:0x0c5e), top: B:384:0x09cf, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0c12 A[Catch: all -> 0x09f4, SQLiteException -> 0x0c26, TRY_LEAVE, TryCatch #2 {SQLiteException -> 0x0c26, blocks: (B:360:0x0c01, B:362:0x0c12), top: B:385:0x0c01, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0c28  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0b80 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0336 A[Catch: all -> 0x01eb, TryCatch #8 {all -> 0x01eb, blocks: (B:35:0x01cc, B:38:0x01d9, B:40:0x01e1, B:46:0x01ef, B:91:0x036a, B:102:0x03a7, B:104:0x03e3, B:106:0x03e8, B:107:0x03ff, B:109:0x040a, B:111:0x0424, B:113:0x042a, B:114:0x0441, B:117:0x0460, B:121:0x0482, B:122:0x0499, B:123:0x04a2, B:126:0x04bf, B:127:0x04d3, B:129:0x04db, B:131:0x04e5, B:133:0x04eb, B:134:0x04f2, B:136:0x04ff, B:138:0x0507, B:140:0x050f, B:142:0x0517, B:143:0x0523, B:144:0x0530, B:150:0x0574, B:151:0x0589, B:153:0x05b6, B:156:0x05e0, B:160:0x0630, B:163:0x065e, B:165:0x068b, B:166:0x068e, B:168:0x0694, B:170:0x069c, B:172:0x06a2, B:174:0x06aa, B:176:0x06b0, B:180:0x06bf, B:183:0x06ce, B:185:0x06d7, B:187:0x06df, B:190:0x0710, B:192:0x0719, B:196:0x072e, B:201:0x073b, B:236:0x07b6, B:237:0x07bd, B:239:0x07e0, B:242:0x07e9, B:246:0x07f4, B:247:0x080e, B:249:0x0814, B:251:0x082e, B:253:0x083a, B:255:0x0847, B:262:0x0878, B:266:0x0882, B:267:0x0885, B:269:0x0892, B:270:0x0895, B:281:0x08d9, B:260:0x0866, B:240:0x07e3, B:204:0x0744, B:208:0x0751, B:212:0x075f, B:216:0x076d, B:220:0x077b, B:224:0x0789, B:228:0x0795, B:232:0x07a3, B:162:0x0651, B:147:0x055b, B:95:0x037c, B:96:0x0388, B:98:0x038e, B:100:0x039c, B:54:0x020f, B:57:0x021d, B:59:0x0232, B:65:0x024a, B:70:0x027a, B:72:0x0280, B:74:0x028e, B:76:0x029c, B:79:0x02a5, B:87:0x032c, B:89:0x0336, B:81:0x02d2, B:82:0x02eb, B:86:0x0311, B:85:0x02fe, B:68:0x0256, B:69:0x0274), top: B:395:0x01cc, inners: #0, #7, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x037c A[Catch: all -> 0x01eb, TryCatch #8 {all -> 0x01eb, blocks: (B:35:0x01cc, B:38:0x01d9, B:40:0x01e1, B:46:0x01ef, B:91:0x036a, B:102:0x03a7, B:104:0x03e3, B:106:0x03e8, B:107:0x03ff, B:109:0x040a, B:111:0x0424, B:113:0x042a, B:114:0x0441, B:117:0x0460, B:121:0x0482, B:122:0x0499, B:123:0x04a2, B:126:0x04bf, B:127:0x04d3, B:129:0x04db, B:131:0x04e5, B:133:0x04eb, B:134:0x04f2, B:136:0x04ff, B:138:0x0507, B:140:0x050f, B:142:0x0517, B:143:0x0523, B:144:0x0530, B:150:0x0574, B:151:0x0589, B:153:0x05b6, B:156:0x05e0, B:160:0x0630, B:163:0x065e, B:165:0x068b, B:166:0x068e, B:168:0x0694, B:170:0x069c, B:172:0x06a2, B:174:0x06aa, B:176:0x06b0, B:180:0x06bf, B:183:0x06ce, B:185:0x06d7, B:187:0x06df, B:190:0x0710, B:192:0x0719, B:196:0x072e, B:201:0x073b, B:236:0x07b6, B:237:0x07bd, B:239:0x07e0, B:242:0x07e9, B:246:0x07f4, B:247:0x080e, B:249:0x0814, B:251:0x082e, B:253:0x083a, B:255:0x0847, B:262:0x0878, B:266:0x0882, B:267:0x0885, B:269:0x0892, B:270:0x0895, B:281:0x08d9, B:260:0x0866, B:240:0x07e3, B:204:0x0744, B:208:0x0751, B:212:0x075f, B:216:0x076d, B:220:0x077b, B:224:0x0789, B:228:0x0795, B:232:0x07a3, B:162:0x0651, B:147:0x055b, B:95:0x037c, B:96:0x0388, B:98:0x038e, B:100:0x039c, B:54:0x020f, B:57:0x021d, B:59:0x0232, B:65:0x024a, B:70:0x027a, B:72:0x0280, B:74:0x028e, B:76:0x029c, B:79:0x02a5, B:87:0x032c, B:89:0x0336, B:81:0x02d2, B:82:0x02eb, B:86:0x0311, B:85:0x02fe, B:68:0x0256, B:69:0x0274), top: B:395:0x01cc, inners: #0, #7, #9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(c1.v r60, c1.d5 r61) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 3244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.v4.l(c1.v, c1.d5):void");
    }

    public final void l0() {
        if (this.f1526m.get()) {
            return;
        }
        androidx.window.layout.c.g("UploadController is not initialized");
    }

    public final void m(b1 b1Var, com.google.android.gms.internal.measurement.j3 j3Var) {
        d0.i iVar;
        com.google.android.gms.internal.measurement.t3 t3Var;
        h hVar;
        b().g();
        l0();
        String strB0 = ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).B0();
        EnumMap enumMap = new EnumMap(j2.class);
        int length = strB0.length();
        int length2 = j2.values().length;
        h hVar2 = h.UNSET;
        int i10 = 0;
        if (length < length2 || strB0.charAt(0) != '1') {
            iVar = new d0.i(4);
        } else {
            j2[] j2VarArrValues = j2.values();
            int length3 = j2VarArrValues.length;
            int i11 = 0;
            int i12 = 1;
            while (i11 < length3) {
                j2 j2Var = j2VarArrValues[i11];
                int i13 = i12 + 1;
                char cCharAt = strB0.charAt(i12);
                h[] hVarArrValues = h.values();
                int length4 = hVarArrValues.length;
                int i14 = i10;
                while (true) {
                    if (i14 >= length4) {
                        hVar = hVar2;
                        break;
                    }
                    hVar = hVarArrValues[i14];
                    if (hVar.f1241a == cCharAt) {
                        break;
                    } else {
                        i14++;
                    }
                }
                enumMap.put((EnumMap) j2Var, (j2) hVar);
                i11++;
                i12 = i13;
                i10 = 0;
            }
            iVar = new d0.i(enumMap);
        }
        String strD = b1Var.D();
        b().g();
        l0();
        k2 k2VarD = d(strD);
        EnumMap enumMap2 = k2VarD.f1302a;
        j2 j2Var2 = j2.AD_STORAGE;
        h2 h2Var = (h2) enumMap2.get(j2Var2);
        h2 h2Var2 = h2.UNINITIALIZED;
        if (h2Var == null) {
            h2Var = h2Var2;
        }
        int i15 = k2VarD.f1303b;
        int iOrdinal = h2Var.ordinal();
        h hVar3 = h.REMOTE_ENFORCED_DEFAULT;
        h hVar4 = h.FAILSAFE;
        if (iOrdinal == 1) {
            iVar.K(j2Var2, hVar3);
        } else if (iOrdinal == 2 || iOrdinal == 3) {
            iVar.J(j2Var2, i15);
        } else {
            iVar.K(j2Var2, hVar4);
        }
        j2 j2Var3 = j2.ANALYTICS_STORAGE;
        h2 h2Var3 = (h2) enumMap2.get(j2Var3);
        if (h2Var3 != null) {
            h2Var2 = h2Var3;
        }
        int iOrdinal2 = h2Var2.ordinal();
        if (iOrdinal2 == 1) {
            iVar.K(j2Var3, hVar3);
        } else if (iOrdinal2 == 2 || iOrdinal2 == 3) {
            iVar.J(j2Var3, i15);
        } else {
            iVar.K(j2Var3, hVar4);
        }
        String strD2 = b1Var.D();
        b().g();
        l0();
        p pVarQ0 = q0(strD2, o0(strD2), d(strD2), iVar);
        String str = pVarQ0.f1396d;
        Boolean bool = pVarQ0.f1395c;
        i0.y.g(bool);
        boolean zBooleanValue = bool.booleanValue();
        j3Var.b();
        ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).f1(zBooleanValue);
        if (!TextUtils.isEmpty(str)) {
            j3Var.b();
            ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).g1(str);
        }
        b().g();
        l0();
        Iterator it = DesugarCollections.unmodifiableList(((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).U1()).iterator();
        while (true) {
            if (it.hasNext()) {
                t3Var = (com.google.android.gms.internal.measurement.t3) it.next();
                if ("_npa".equals(t3Var.r())) {
                    break;
                }
            } else {
                t3Var = null;
                break;
            }
        }
        if (t3Var != null) {
            EnumMap enumMap3 = (EnumMap) iVar.f6781b;
            j2 j2Var4 = j2.AD_PERSONALIZATION;
            h hVar5 = (h) enumMap3.get(j2Var4);
            if (hVar5 == null) {
                hVar5 = hVar2;
            }
            if (hVar5 == hVar2) {
                n nVar = this.f1520c;
                U(nVar);
                z4 z4VarA0 = nVar.a0(b1Var.D(), "_npa");
                h hVar6 = h.MANIFEST;
                h hVar7 = h.API;
                if (z4VarA0 != null) {
                    String str2 = z4VarA0.f1630b;
                    if ("tcf".equals(str2)) {
                        iVar.K(j2Var4, h.TCF);
                    } else if (MBridgeConstans.DYNAMIC_VIEW_WX_APP.equals(str2)) {
                        iVar.K(j2Var4, hVar7);
                    } else {
                        iVar.K(j2Var4, hVar6);
                    }
                } else {
                    Boolean boolW = b1Var.w();
                    if (boolW == null || ((boolW.booleanValue() && t3Var.v() != 1) || !(boolW.booleanValue() || t3Var.v() == 0))) {
                        iVar.K(j2Var4, hVar7);
                    } else {
                        iVar.K(j2Var4, hVar6);
                    }
                }
            }
        } else {
            int iF = F(b1Var.D(), iVar);
            com.google.android.gms.internal.measurement.s3 s3VarA = com.google.android.gms.internal.measurement.t3.A();
            s3VarA.b();
            ((com.google.android.gms.internal.measurement.t3) s3VarA.f2102b).C("_npa");
            f().getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            s3VarA.b();
            ((com.google.android.gms.internal.measurement.t3) s3VarA.f2102b).B(jCurrentTimeMillis);
            s3VarA.b();
            ((com.google.android.gms.internal.measurement.t3) s3VarA.f2102b).F(iF);
            com.google.android.gms.internal.measurement.t3 t3Var2 = (com.google.android.gms.internal.measurement.t3) s3VarA.d();
            j3Var.b();
            ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).d0(t3Var2);
            a().f1545n.d("non_personalized_ads(_npa)", "Setting user property", Integer.valueOf(iF));
        }
        String string = iVar.toString();
        j3Var.b();
        ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).e1(string);
        String strD3 = b1Var.D();
        n1 n1Var = this.f1518a;
        n1Var.g();
        n1Var.m(strD3);
        com.google.android.gms.internal.measurement.b2 b2VarB = n1Var.B(strD3);
        boolean z9 = b2VarB == null || !b2VarB.s() || b2VarB.t();
        List listT = j3Var.T();
        for (int i16 = 0; i16 < listT.size(); i16++) {
            if ("_tcf".equals(((com.google.android.gms.internal.measurement.c3) listT.get(i16)).s())) {
                com.google.android.gms.internal.measurement.b3 b3Var = (com.google.android.gms.internal.measurement.b3) ((com.google.android.gms.internal.measurement.c3) listT.get(i16)).i();
                List listG = b3Var.g();
                int i17 = 0;
                while (true) {
                    if (i17 >= listG.size()) {
                        break;
                    }
                    if ("_tcfd".equals(((com.google.android.gms.internal.measurement.f3) listG.get(i17)).q())) {
                        String strS = ((com.google.android.gms.internal.measurement.f3) listG.get(i17)).s();
                        if (z9 && strS.length() > 4) {
                            char[] charArray = strS.toCharArray();
                            int i18 = 1;
                            while (true) {
                                if (i18 >= 64) {
                                    i18 = 0;
                                    break;
                                } else if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i18)) {
                                    break;
                                } else {
                                    i18++;
                                }
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i18 | 1);
                            strS = String.valueOf(charArray);
                        }
                        com.google.android.gms.internal.measurement.e3 e3VarB = com.google.android.gms.internal.measurement.f3.B();
                        e3VarB.g("_tcfd");
                        e3VarB.h(strS);
                        b3Var.b();
                        ((com.google.android.gms.internal.measurement.c3) b3Var.f2102b).A(i17, (com.google.android.gms.internal.measurement.f3) e3VarB.d());
                    } else {
                        i17++;
                    }
                }
                j3Var.V(i16, b3Var);
                return;
            }
        }
    }

    public final void m0(d5 d5Var) {
        b().g();
        l0();
        String str = d5Var.f1114a;
        i0.y.d(str);
        k2 k2VarC = k2.c(d5Var.f1132x, d5Var.f1128s);
        d(str);
        a().f1545n.d(str, "Setting storage consent for package", k2VarC);
        b().g();
        l0();
        this.B.put(str, k2VarC);
        n nVar = this.f1520c;
        U(nVar);
        nVar.B(str, k2VarC);
    }

    public final void n(b1 b1Var, com.google.android.gms.internal.measurement.j3 j3Var) {
        Serializable serializableV;
        b().g();
        l0();
        com.google.android.gms.internal.measurement.m2 m2VarO = com.google.android.gms.internal.measurement.p2.O();
        u1 u1Var = b1Var.f1035a;
        r1 r1Var = u1Var.g;
        u1.m(r1Var);
        r1Var.g();
        byte[] bArr = b1Var.H;
        if (bArr != null) {
            try {
                m2VarO = (com.google.android.gms.internal.measurement.m2) a1.T(m2VarO, bArr);
            } catch (w5 unused) {
                a().f1540i.c(w0.o(b1Var.D()), "Failed to parse locally stored ad campaign info. appId");
            }
        }
        Iterator it = j3Var.T().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.google.android.gms.internal.measurement.c3 c3Var = (com.google.android.gms.internal.measurement.c3) it.next();
            if (c3Var.s().equals("_cmp")) {
                com.google.android.gms.internal.measurement.f3 f3VarO = a1.o(c3Var, "gclid");
                Serializable serializableV2 = f3VarO == null ? null : a1.v(f3VarO);
                if (serializableV2 == null) {
                    serializableV2 = "";
                }
                String str = (String) serializableV2;
                com.google.android.gms.internal.measurement.f3 f3VarO2 = a1.o(c3Var, "gbraid");
                Serializable serializableV3 = f3VarO2 == null ? null : a1.v(f3VarO2);
                if (serializableV3 == null) {
                    serializableV3 = "";
                }
                String str2 = (String) serializableV3;
                com.google.android.gms.internal.measurement.f3 f3VarO3 = a1.o(c3Var, "gad_source");
                Object objV = f3VarO3 == null ? null : a1.v(f3VarO3);
                String str3 = (String) (objV != null ? objV : "");
                String[] strArrSplit = ((String) f0.f1172h1.a(null)).split(",");
                j0();
                HashMap map = new HashMap();
                for (com.google.android.gms.internal.measurement.f3 f3Var : c3Var.p()) {
                    if (Arrays.asList(strArrSplit).contains(f3Var.q()) && (serializableV = a1.v(f3Var)) != null) {
                        map.put(f3Var.q(), serializableV);
                    }
                }
                if (!map.isEmpty()) {
                    com.google.android.gms.internal.measurement.f3 f3VarO4 = a1.o(c3Var, "click_timestamp");
                    Object objV2 = f3VarO4 == null ? null : a1.v(f3VarO4);
                    long jLongValue = ((Long) (objV2 != null ? objV2 : 0L)).longValue();
                    if (jLongValue <= 0) {
                        jLongValue = c3Var.u();
                    }
                    com.google.android.gms.internal.measurement.f3 f3VarO5 = a1.o(c3Var, "_cis");
                    if ("referrer API v2".equals(f3VarO5 != null ? a1.v(f3VarO5) : null)) {
                        if (jLongValue > ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).N()) {
                            if (str.isEmpty()) {
                                m2VarO.b();
                                ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).q();
                            } else {
                                m2VarO.b();
                                ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).p(str);
                            }
                            if (str2.isEmpty()) {
                                m2VarO.b();
                                ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).s();
                            } else {
                                m2VarO.b();
                                ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).r(str2);
                            }
                            if (str3.isEmpty()) {
                                m2VarO.b();
                                ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).u();
                            } else {
                                m2VarO.b();
                                ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).t(str3);
                            }
                            m2VarO.b();
                            ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).v(jLongValue);
                            m2VarO.b();
                            ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).x().clear();
                            HashMap mapG = G(c3Var);
                            m2VarO.b();
                            ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).x().putAll(mapG);
                        }
                    } else if (jLongValue > ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).F()) {
                        if (str.isEmpty()) {
                            m2VarO.b();
                            ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).R();
                        } else {
                            m2VarO.b();
                            ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).Q(str);
                        }
                        if (str2.isEmpty()) {
                            m2VarO.b();
                            ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).T();
                        } else {
                            m2VarO.b();
                            ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).S(str2);
                        }
                        if (str3.isEmpty()) {
                            m2VarO.b();
                            ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).V();
                        } else {
                            m2VarO.b();
                            ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).U(str3);
                        }
                        m2VarO.b();
                        ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).W(jLongValue);
                        m2VarO.b();
                        ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).w().clear();
                        HashMap mapG2 = G(c3Var);
                        m2VarO.b();
                        ((com.google.android.gms.internal.measurement.p2) m2VarO.f2102b).w().putAll(mapG2);
                    }
                }
            }
        }
        if (!((com.google.android.gms.internal.measurement.p2) m2VarO.d()).equals(com.google.android.gms.internal.measurement.p2.P())) {
            com.google.android.gms.internal.measurement.p2 p2Var = (com.google.android.gms.internal.measurement.p2) m2VarO.d();
            j3Var.b();
            ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).k1(p2Var);
        }
        byte[] bArrA = ((com.google.android.gms.internal.measurement.p2) m2VarO.d()).a();
        r1 r1Var2 = u1Var.g;
        u1.m(r1Var2);
        r1Var2.g();
        b1Var.Q |= b1Var.H != bArrA;
        b1Var.H = bArrA;
        if (b1Var.o()) {
            n nVar = this.f1520c;
            U(nVar);
            nVar.j0(b1Var, false);
        }
        if (e0().q(null, f0.f1170g1)) {
            n nVar2 = this.f1520c;
            U(nVar2);
            nVar2.Y(b1Var.D(), "_lgclid");
        }
    }

    public final void n0(d5 d5Var) throws NumberFormatException {
        b().g();
        l0();
        String str = d5Var.f1114a;
        i0.y.d(str);
        p pVarB = p.b(d5Var.y);
        a().f1545n.d(str, "Setting DMA consent for package", pVarB);
        b().g();
        l0();
        h2 h2VarA = p.c(100, p0(str)).a();
        this.C.put(str, pVarB);
        n nVar = this.f1520c;
        U(nVar);
        i0.y.g(str);
        i0.y.g(pVarB);
        nVar.g();
        nVar.h();
        k2 k2VarZ = nVar.z(str);
        k2 k2Var = k2.f1301c;
        if (k2VarZ == k2Var) {
            nVar.B(str, k2Var);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("dma_consent_settings", pVarB.f1394b);
        nVar.D(contentValues);
        h2 h2VarA2 = p.c(100, p0(str)).a();
        b().g();
        l0();
        h2 h2Var = h2.GRANTED;
        h2 h2Var2 = h2.DENIED;
        boolean z9 = h2VarA == h2Var2 && h2VarA2 == h2Var;
        boolean z10 = h2VarA == h2Var && h2VarA2 == h2Var2;
        if (z9 || z10) {
            a().f1545n.c(str, "Generated _dcu event for");
            Bundle bundle = new Bundle();
            n nVar2 = this.f1520c;
            U(nVar2);
            if (nVar2.k0(g(), str, false, false, false, false).f < e0().o(str, f0.f1187n0)) {
                bundle.putLong("_r", 1L);
                n nVar3 = this.f1520c;
                U(nVar3);
                a().f1545n.d(str, "_dcu realtime event count", Long.valueOf(nVar3.k0(g(), str, false, false, true, false).f));
            }
            this.J.b(str, "_dcu", bundle);
        }
    }

    public final String o(k2 k2Var) {
        if (!k2Var.i(j2.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        k0().e0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final p o0(String str) throws NumberFormatException {
        b().g();
        l0();
        HashMap map = this.C;
        p pVar = (p) map.get(str);
        if (pVar != null) {
            return pVar;
        }
        n nVar = this.f1520c;
        U(nVar);
        i0.y.g(str);
        nVar.g();
        nVar.h();
        p pVarB = p.b(nVar.C("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}));
        map.put(str, pVarB);
        return pVarB;
    }

    public final void p(ArrayList arrayList) {
        i0.y.b(!arrayList.isEmpty());
        if (this.y != null) {
            a().f.b("Set uploading progress before finishing the previous upload");
        } else {
            this.y = new ArrayList(arrayList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Bundle p0(String str) {
        b().g();
        l0();
        n1 n1Var = this.f1518a;
        U(n1Var);
        if (n1Var.B(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        k2 k2VarD = d(str);
        Bundle bundle2 = new Bundle();
        Iterator it = k2VarD.f1302a.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            int iOrdinal = ((h2) entry.getValue()).ordinal();
            String str2 = iOrdinal != 2 ? iOrdinal != 3 ? null : "granted" : "denied";
            if (str2 != null) {
                bundle2.putString(((j2) entry.getKey()).f1290a, str2);
            }
        }
        bundle.putAll(bundle2);
        p pVarQ0 = q0(str, o0(str), k2VarD, new d0.i(4));
        Bundle bundle3 = new Bundle();
        for (Map.Entry entry2 : pVarQ0.e.entrySet()) {
            int iOrdinal2 = ((h2) entry2.getValue()).ordinal();
            String str3 = iOrdinal2 != 2 ? iOrdinal2 != 3 ? null : "granted" : "denied";
            if (str3 != null) {
                bundle3.putString(((j2) entry2.getKey()).f1290a, str3);
            }
        }
        Boolean bool = pVarQ0.f1395c;
        if (bool != null) {
            bundle3.putString("is_dma_region", bool.toString());
        }
        String str4 = pVarQ0.f1396d;
        if (str4 != null) {
            bundle3.putString("cps_display_str", str4);
        }
        bundle.putAll(bundle3);
        n nVar = this.f1520c;
        U(nVar);
        z4 z4VarA0 = nVar.a0(str, "_npa");
        bundle.putString("ad_personalization", 1 != (z4VarA0 != null ? z4VarA0.e.equals(1L) : F(str, new d0.i(4))) ? "granted" : "denied");
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x01a5 A[Catch: all -> 0x0028, TryCatch #3 {all -> 0x0028, blocks: (B:3:0x000e, B:5:0x001b, B:8:0x002b, B:10:0x0031, B:11:0x003e, B:13:0x0046, B:14:0x004b, B:16:0x0056, B:17:0x0063, B:19:0x006e, B:20:0x007e, B:22:0x00a8, B:24:0x00ae, B:25:0x00b1, B:27:0x00ca, B:28:0x00df, B:30:0x00f0, B:32:0x00f6, B:35:0x010b, B:45:0x0128, B:47:0x012d, B:48:0x0130, B:49:0x0131, B:50:0x0136, B:55:0x0179, B:71:0x019f, B:73:0x01a5, B:75:0x01b0, B:79:0x01bb, B:80:0x01be, B:33:0x00fb, B:37:0x010f, B:42:0x0117), top: B:86:0x000e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01bb A[Catch: all -> 0x0028, DONT_GENERATE, TRY_ENTER, TryCatch #3 {all -> 0x0028, blocks: (B:3:0x000e, B:5:0x001b, B:8:0x002b, B:10:0x0031, B:11:0x003e, B:13:0x0046, B:14:0x004b, B:16:0x0056, B:17:0x0063, B:19:0x006e, B:20:0x007e, B:22:0x00a8, B:24:0x00ae, B:25:0x00b1, B:27:0x00ca, B:28:0x00df, B:30:0x00f0, B:32:0x00f6, B:35:0x010b, B:45:0x0128, B:47:0x012d, B:48:0x0130, B:49:0x0131, B:50:0x0136, B:55:0x0179, B:71:0x019f, B:73:0x01a5, B:75:0x01b0, B:79:0x01bb, B:80:0x01be, B:33:0x00fb, B:37:0x010f, B:42:0x0117), top: B:86:0x000e, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q() {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.v4.q():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c1.p q0(java.lang.String r12, c1.p r13, c1.k2 r14, d0.i r15) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.v4.q0(java.lang.String, c1.p, c1.k2, d0.i):c1.p");
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d A[PHI: r0 r11 r24
      0x006d: PHI (r0v113 java.util.List) = (r0v7 java.util.List), (r0v136 java.util.List) binds: [B:108:0x0221, B:16:0x006b] A[DONT_GENERATE, DONT_INLINE]
      0x006d: PHI (r11v55 android.database.Cursor) = (r11v5 android.database.Cursor), (r11v57 android.database.Cursor) binds: [B:108:0x0221, B:16:0x006b] A[DONT_GENERATE, DONT_INLINE]
      0x006d: PHI (r24v19 long) = (r24v2 long), (r24v20 long) binds: [B:108:0x0221, B:16:0x006b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x05f6  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x061e  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x07aa  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x07fe  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x080c  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0a78  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x07f2 A[EDGE_INSN: B:436:0x07f2->B:313:0x07f2 BREAK  A[LOOP:4: B:259:0x0649->B:312:0x07e4], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:438:0x07e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:473:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:475:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:476:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(long r32, java.lang.String r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2762
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.v4.r(long, java.lang.String):void");
    }

    public final boolean s(String str, String str2) {
        n nVar = this.f1520c;
        U(nVar);
        b1 b1VarI0 = nVar.i0(str);
        HashMap map = this.E;
        if (b1VarI0 != null && k0().H(str, b1VarI0.C())) {
            map.remove(str2);
            return true;
        }
        u4 u4Var = (u4) map.get(str2);
        if (u4Var != null) {
            u4Var.f1502a.f().getClass();
            if (System.currentTimeMillis() < u4Var.f1504c) {
                return false;
            }
        }
        return true;
    }

    public final void t(String str) {
        b().g();
        l0();
        this.f1534v = true;
        try {
            u1 u1Var = this.f1525l;
            u1Var.getClass();
            Boolean bool = u1Var.p().e;
            if (bool == null) {
                a().f1540i.b("Upload data called on the client side before use of service was decided");
            } else if (bool.booleanValue()) {
                a().f.b("Upload called in the client side when service should be used");
            } else if (this.f1528o > 0) {
                N();
            } else {
                a1 a1Var = this.f1519b;
                U(a1Var);
                if (a1Var.A()) {
                    n nVar = this.f1520c;
                    U(nVar);
                    if (nVar.m(str)) {
                        n nVar2 = this.f1520c;
                        U(nVar2);
                        i0.y.d(str);
                        nVar2.g();
                        nVar2.h();
                        List listL = nVar2.l(str, o4.b(j3.GOOGLE_SIGNAL), 1);
                        x4 x4Var = listL.isEmpty() ? null : (x4) listL.get(0);
                        if (x4Var != null) {
                            com.google.android.gms.internal.measurement.i3 i3Var = x4Var.f1576b;
                            a().f1545n.e("[sgtm] Uploading data from upload queue. appId, type, url", str, x4Var.e, x4Var.f1577c);
                            byte[] bArrA = i3Var.a();
                            if (Log.isLoggable(a().q(), 2)) {
                                a1 a1Var2 = this.g;
                                U(a1Var2);
                                a().f1545n.e("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(bArrA.length), a1Var2.J(i3Var));
                            }
                            r4 r4Var = new r4(x4Var.f1577c, x4Var.f1578d, x4Var.e, null);
                            this.f1533u = true;
                            a1 a1Var3 = this.f1519b;
                            U(a1Var3);
                            a1Var3.F(str, r4Var, i3Var, new a3.x(this, str, (Object) x4Var, 8));
                        }
                    } else {
                        a().f1545n.c(str, "[sgtm] Upload queue has no batches for appId");
                    }
                } else {
                    a().f1545n.b("Network not connected, ignoring upload request");
                    N();
                }
            }
            this.f1534v = false;
            O();
        } catch (Throwable th) {
            this.f1534v = false;
            O();
            throw th;
        }
    }

    public final void u(String str, boolean z9, Long l10, Long l11) {
        n nVar = this.f1520c;
        U(nVar);
        b1 b1VarI0 = nVar.i0(str);
        if (b1VarI0 != null) {
            u1 u1Var = b1VarI0.f1035a;
            r1 r1Var = u1Var.g;
            u1.m(r1Var);
            r1Var.g();
            b1VarI0.Q |= b1VarI0.y != z9;
            b1VarI0.y = z9;
            r1 r1Var2 = u1Var.g;
            u1.m(r1Var2);
            r1Var2.g();
            b1VarI0.Q |= !Objects.equals(b1VarI0.f1054z, l10);
            b1VarI0.f1054z = l10;
            r1 r1Var3 = u1Var.g;
            u1.m(r1Var3);
            r1Var3.g();
            b1VarI0.Q |= !Objects.equals(b1VarI0.A, l11);
            b1VarI0.A = l11;
            if (b1VarI0.o()) {
                n nVar2 = this.f1520c;
                U(nVar2);
                nVar2.j0(b1VarI0, false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(com.google.android.gms.internal.measurement.j3 r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.v4.v(com.google.android.gms.internal.measurement.j3, java.lang.String):void");
    }

    public final void w(com.google.android.gms.internal.measurement.j3 j3Var, f1 f1Var) {
        String strZ;
        String strZ2;
        for (int i10 = 0; i10 < j3Var.U(); i10++) {
            com.google.android.gms.internal.measurement.b3 b3Var = (com.google.android.gms.internal.measurement.b3) ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).T1(i10).i();
            Iterator it = b3Var.g().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if ("_c".equals(((com.google.android.gms.internal.measurement.f3) it.next()).q())) {
                    if (((com.google.android.gms.internal.measurement.k3) f1Var.f1210b).G0() >= e0().o(((com.google.android.gms.internal.measurement.k3) f1Var.f1210b).p(), f0.f1185m0)) {
                        int iO = e0().o(((com.google.android.gms.internal.measurement.k3) f1Var.f1210b).p(), f0.z0);
                        LinkedList linkedList = this.f1530q;
                        a1 a1Var = this.g;
                        if (iO > 0) {
                            n nVar = this.f1520c;
                            U(nVar);
                            if (nVar.k0(g(), ((com.google.android.gms.internal.measurement.k3) f1Var.f1210b).p(), false, false, false, true).g > iO) {
                                com.google.android.gms.internal.measurement.e3 e3VarB = com.google.android.gms.internal.measurement.f3.B();
                                e3VarB.g("_tnr");
                                e3VarB.i(1L);
                                b3Var.j((com.google.android.gms.internal.measurement.f3) e3VarB.d());
                            } else {
                                if (e0().q(((com.google.android.gms.internal.measurement.k3) f1Var.f1210b).p(), f0.S0)) {
                                    strZ2 = k0().Z();
                                    com.google.android.gms.internal.measurement.e3 e3VarB2 = com.google.android.gms.internal.measurement.f3.B();
                                    e3VarB2.g("_tu");
                                    e3VarB2.h(strZ2);
                                    b3Var.j((com.google.android.gms.internal.measurement.f3) e3VarB2.d());
                                } else {
                                    strZ2 = null;
                                }
                                com.google.android.gms.internal.measurement.e3 e3VarB3 = com.google.android.gms.internal.measurement.f3.B();
                                e3VarB3.g("_tr");
                                e3VarB3.i(1L);
                                b3Var.j((com.google.android.gms.internal.measurement.f3) e3VarB3.d());
                                U(a1Var);
                                k4 k4VarH = a1Var.H(((com.google.android.gms.internal.measurement.k3) f1Var.f1210b).p(), j3Var, b3Var, strZ2);
                                if (k4VarH != null) {
                                    a().f1545n.d(((com.google.android.gms.internal.measurement.k3) f1Var.f1210b).p(), "Generated trigger URI. appId, uri", k4VarH.f1308a);
                                    n nVar2 = this.f1520c;
                                    U(nVar2);
                                    nVar2.A(((com.google.android.gms.internal.measurement.k3) f1Var.f1210b).p(), k4VarH);
                                    if (!linkedList.contains(((com.google.android.gms.internal.measurement.k3) f1Var.f1210b).p())) {
                                        linkedList.add(((com.google.android.gms.internal.measurement.k3) f1Var.f1210b).p());
                                    }
                                }
                            }
                        } else {
                            if (e0().q(((com.google.android.gms.internal.measurement.k3) f1Var.f1210b).p(), f0.S0)) {
                                strZ = k0().Z();
                                com.google.android.gms.internal.measurement.e3 e3VarB4 = com.google.android.gms.internal.measurement.f3.B();
                                e3VarB4.g("_tu");
                                e3VarB4.h(strZ);
                                b3Var.j((com.google.android.gms.internal.measurement.f3) e3VarB4.d());
                            } else {
                                strZ = null;
                            }
                            com.google.android.gms.internal.measurement.e3 e3VarB5 = com.google.android.gms.internal.measurement.f3.B();
                            e3VarB5.g("_tr");
                            e3VarB5.i(1L);
                            b3Var.j((com.google.android.gms.internal.measurement.f3) e3VarB5.d());
                            U(a1Var);
                            k4 k4VarH2 = a1Var.H(((com.google.android.gms.internal.measurement.k3) f1Var.f1210b).p(), j3Var, b3Var, strZ);
                            if (k4VarH2 != null) {
                                a().f1545n.d(((com.google.android.gms.internal.measurement.k3) f1Var.f1210b).p(), "Generated trigger URI. appId, uri", k4VarH2.f1308a);
                                n nVar3 = this.f1520c;
                                U(nVar3);
                                nVar3.A(((com.google.android.gms.internal.measurement.k3) f1Var.f1210b).p(), k4VarH2);
                                if (!linkedList.contains(((com.google.android.gms.internal.measurement.k3) f1Var.f1210b).p())) {
                                    linkedList.add(((com.google.android.gms.internal.measurement.k3) f1Var.f1210b).p());
                                }
                            }
                        }
                    }
                    com.google.android.gms.internal.measurement.c3 c3Var = (com.google.android.gms.internal.measurement.c3) b3Var.d();
                    j3Var.b();
                    ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).X(i10, c3Var);
                }
            }
        }
    }

    public final void x(String str, com.google.android.gms.internal.measurement.e3 e3Var, Bundle bundle, String str2) {
        int iMax;
        List listUnmodifiableList = DesugarCollections.unmodifiableList(Arrays.asList("_o", "_sn", "_sc", "_si"));
        if (b5.F(((com.google.android.gms.internal.measurement.f3) e3Var.f2102b).q()) || b5.F(str)) {
            g gVarE0 = e0();
            gVarE0.getClass();
            iMax = Math.max(Math.max(Math.min(gVarE0.o(str2, f0.f1174i0), 500), 100), 256);
        } else {
            g gVarE02 = e0();
            gVarE02.getClass();
            iMax = Math.max(Math.min(gVarE02.o(str2, f0.f1174i0), 500), 100);
        }
        long j10 = iMax;
        long jCodePointCount = ((com.google.android.gms.internal.measurement.f3) e3Var.f2102b).s().codePointCount(0, ((com.google.android.gms.internal.measurement.f3) e3Var.f2102b).s().length());
        k0();
        String strQ = ((com.google.android.gms.internal.measurement.f3) e3Var.f2102b).q();
        e0();
        String strL = b5.l(40, strQ, true);
        if (jCodePointCount <= j10 || listUnmodifiableList.contains(((com.google.android.gms.internal.measurement.f3) e3Var.f2102b).q())) {
            return;
        }
        if ("_ev".equals(((com.google.android.gms.internal.measurement.f3) e3Var.f2102b).q())) {
            k0();
            String strS = ((com.google.android.gms.internal.measurement.f3) e3Var.f2102b).s();
            g gVarE03 = e0();
            gVarE03.getClass();
            bundle.putString("_ev", b5.l(Math.max(Math.max(Math.min(gVarE03.o(str2, f0.f1174i0), 500), 100), 256), strS, true));
            return;
        }
        a().f1542k.d(strL, "Param value is too long; discarded. Name, value length", Long.valueOf(jCodePointCount));
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", strL);
                bundle.putLong("_el", jCodePointCount);
            }
        }
        bundle.remove(((com.google.android.gms.internal.measurement.f3) e3Var.f2102b).q());
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0153 A[EDGE_INSN: B:105:0x0153->B:52:0x0153 BREAK  A[LOOP:0: B:33:0x00f5->B:107:0x00f5], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070 A[Catch: all -> 0x0018, TryCatch #3 {all -> 0x0018, blocks: (B:4:0x0015, B:8:0x001d, B:16:0x0032, B:21:0x0082, B:20:0x0070, B:22:0x008f, B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:80:0x021d, B:82:0x0230, B:84:0x023b, B:92:0x025a, B:86:0x0241, B:88:0x024a, B:90:0x0250, B:91:0x0254, B:93:0x025d, B:94:0x0265, B:30:0x00d9, B:95:0x0266), top: B:104:0x0015, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008f A[Catch: all -> 0x0018, PHI: r0
      0x008f: PHI (r0v2 int) = (r0v0 int), (r0v36 int) binds: [B:9:0x0025, B:15:0x0030] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #3 {all -> 0x0018, blocks: (B:4:0x0015, B:8:0x001d, B:16:0x0032, B:21:0x0082, B:20:0x0070, B:22:0x008f, B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:80:0x021d, B:82:0x0230, B:84:0x023b, B:92:0x025a, B:86:0x0241, B:88:0x024a, B:90:0x0250, B:91:0x0254, B:93:0x025d, B:94:0x0265, B:30:0x00d9, B:95:0x0266), top: B:104:0x0015, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c8 A[Catch: all -> 0x0018, SQLiteException -> 0x00b7, TryCatch #2 {SQLiteException -> 0x00b7, blocks: (B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:80:0x021d, B:82:0x0230, B:84:0x023b, B:92:0x025a, B:86:0x0241, B:88:0x024a, B:90:0x0250, B:91:0x0254, B:93:0x025d, B:94:0x0265, B:30:0x00d9), top: B:103:0x00a4, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d9 A[Catch: all -> 0x0018, SQLiteException -> 0x00b7, TryCatch #2 {SQLiteException -> 0x00b7, blocks: (B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:80:0x021d, B:82:0x0230, B:84:0x023b, B:92:0x025a, B:86:0x0241, B:88:0x024a, B:90:0x0250, B:91:0x0254, B:93:0x025d, B:94:0x0265, B:30:0x00d9), top: B:103:0x00a4, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ff A[Catch: all -> 0x0150, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0150, blocks: (B:32:0x00ec, B:33:0x00f5, B:36:0x00ff, B:39:0x0113, B:41:0x011f, B:42:0x0121, B:46:0x0138, B:48:0x0142, B:52:0x0153, B:53:0x0158, B:55:0x015e, B:57:0x0171, B:59:0x0188, B:60:0x018a, B:62:0x019c, B:64:0x01b8, B:66:0x01dc, B:67:0x01eb, B:69:0x01f2, B:70:0x01fa, B:73:0x0209, B:75:0x020d, B:78:0x0214, B:79:0x0215), top: B:102:0x00ec, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015e A[Catch: all -> 0x0150, TryCatch #1 {all -> 0x0150, blocks: (B:32:0x00ec, B:33:0x00f5, B:36:0x00ff, B:39:0x0113, B:41:0x011f, B:42:0x0121, B:46:0x0138, B:48:0x0142, B:52:0x0153, B:53:0x0158, B:55:0x015e, B:57:0x0171, B:59:0x0188, B:60:0x018a, B:62:0x019c, B:64:0x01b8, B:66:0x01dc, B:67:0x01eb, B:69:0x01f2, B:70:0x01fa, B:73:0x0209, B:75:0x020d, B:78:0x0214, B:79:0x0215), top: B:102:0x00ec, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b8 A[Catch: all -> 0x0150, TryCatch #1 {all -> 0x0150, blocks: (B:32:0x00ec, B:33:0x00f5, B:36:0x00ff, B:39:0x0113, B:41:0x011f, B:42:0x0121, B:46:0x0138, B:48:0x0142, B:52:0x0153, B:53:0x0158, B:55:0x015e, B:57:0x0171, B:59:0x0188, B:60:0x018a, B:62:0x019c, B:64:0x01b8, B:66:0x01dc, B:67:0x01eb, B:69:0x01f2, B:70:0x01fa, B:73:0x0209, B:75:0x020d, B:78:0x0214, B:79:0x0215), top: B:102:0x00ec, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f2 A[Catch: all -> 0x0150, TRY_LEAVE, TryCatch #1 {all -> 0x0150, blocks: (B:32:0x00ec, B:33:0x00f5, B:36:0x00ff, B:39:0x0113, B:41:0x011f, B:42:0x0121, B:46:0x0138, B:48:0x0142, B:52:0x0153, B:53:0x0158, B:55:0x015e, B:57:0x0171, B:59:0x0188, B:60:0x018a, B:62:0x019c, B:64:0x01b8, B:66:0x01dc, B:67:0x01eb, B:69:0x01f2, B:70:0x01fa, B:73:0x0209, B:75:0x020d, B:78:0x0214, B:79:0x0215), top: B:102:0x00ec, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0230 A[Catch: all -> 0x0018, SQLiteException -> 0x00b7, TryCatch #2 {SQLiteException -> 0x00b7, blocks: (B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:80:0x021d, B:82:0x0230, B:84:0x023b, B:92:0x025a, B:86:0x0241, B:88:0x024a, B:90:0x0250, B:91:0x0254, B:93:0x025d, B:94:0x0265, B:30:0x00d9), top: B:103:0x00a4, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0241 A[Catch: all -> 0x0018, SQLiteException -> 0x00b7, TryCatch #2 {SQLiteException -> 0x00b7, blocks: (B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:80:0x021d, B:82:0x0230, B:84:0x023b, B:92:0x025a, B:86:0x0241, B:88:0x024a, B:90:0x0250, B:91:0x0254, B:93:0x025d, B:94:0x0265, B:30:0x00d9), top: B:103:0x00a4, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(boolean r18, int r19, java.lang.Throwable r20, byte[] r21, java.lang.String r22, java.util.List r23) {
        /*
            Method dump skipped, instructions count: 667
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.v4.y(boolean, int, java.lang.Throwable, byte[], java.lang.String, java.util.List):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z(b1 b1Var) throws MalformedURLException {
        ArrayMap arrayMap;
        ArrayMap arrayMap2;
        b().g();
        if (TextUtils.isEmpty(b1Var.G())) {
            String strD = b1Var.D();
            i0.y.g(strD);
            A(strD, 204, null, null, null);
            return;
        }
        String strD2 = b1Var.D();
        i0.y.g(strD2);
        a().f1545n.c(strD2, "Fetching remote configuration");
        n1 n1Var = this.f1518a;
        U(n1Var);
        com.google.android.gms.internal.measurement.g2 g2VarS = n1Var.s(strD2);
        U(n1Var);
        n1Var.g();
        String str = (String) n1Var.f1361m.get(strD2);
        if (g2VarS != null) {
            if (TextUtils.isEmpty(str)) {
                arrayMap2 = null;
            } else {
                arrayMap2 = new ArrayMap();
                arrayMap2.put("If-Modified-Since", str);
            }
            U(n1Var);
            n1Var.g();
            String str2 = (String) n1Var.f1362n.get(strD2);
            if (!TextUtils.isEmpty(str2)) {
                if (arrayMap2 == null) {
                    arrayMap2 = new ArrayMap();
                }
                arrayMap2.put("If-None-Match", str2);
            }
            arrayMap = arrayMap2;
        } else {
            arrayMap = null;
        }
        this.t = true;
        a1 a1Var = this.f1519b;
        U(a1Var);
        y2.c cVar = new y2.c(this, 8);
        u1 u1Var = a1Var.f1149a;
        a1Var.g();
        a1Var.h();
        s4 s4Var = a1Var.f1335b.f1523j;
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder builderAppendQueryParameter = builder.scheme((String) f0.f.a(null)).encodedAuthority((String) f0.g.a(null)).path("config/app/".concat(String.valueOf(b1Var.G()))).appendQueryParameter("platform", "android");
        s4Var.f1149a.f1478d.l();
        builderAppendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(133005L)).appendQueryParameter("runtime_version", "0");
        String string = builder.build().toString();
        try {
            URL url = new URI(string).toURL();
            r1 r1Var = u1Var.g;
            u1.m(r1Var);
            r1Var.s(new z0(a1Var, b1Var.D(), url, (byte[]) null, arrayMap, cVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.d(w0.o(b1Var.D()), "Failed to parse config URL. Not fetching. appId", string);
        }
    }
}
