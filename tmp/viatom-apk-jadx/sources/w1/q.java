package w1;

import android.content.Context;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import z1.s0;
import z1.t0;
import z1.u0;
import z1.w0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q {
    public static final HashMap f;
    public static final String g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f13383a;

    /* renamed from: b, reason: collision with root package name */
    public final w f13384b;

    /* renamed from: c, reason: collision with root package name */
    public final a f13385c;

    /* renamed from: d, reason: collision with root package name */
    public final a4.f f13386d;
    public final d5.n e;

    static {
        HashMap map = new HashMap();
        f = map;
        map.put("armeabi", 5);
        map.put("armeabi-v7a", 6);
        map.put("arm64-v8a", 9);
        map.put("x86", 0);
        map.put("x86_64", 1);
        Locale locale = Locale.US;
        g = "Crashlytics Android SDK/20.0.3";
    }

    public q(Context context, w wVar, a aVar, a4.f fVar, d5.n nVar) {
        this.f13383a = context;
        this.f13384b = wVar;
        this.f13385c = aVar;
        this.f13386d = fVar;
        this.e = nVar;
    }

    public static t0 c(w2.r rVar, int i10) {
        String str = (String) rVar.f13463c;
        String str2 = (String) rVar.f13462b;
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) rVar.f13464d;
        int i11 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        w2.r rVar2 = (w2.r) rVar.e;
        if (i10 >= 8) {
            w2.r rVar3 = rVar2;
            while (rVar3 != null) {
                rVar3 = (w2.r) rVar3.e;
                i11++;
            }
        }
        int i12 = i11;
        List listD = d(stackTraceElementArr, 4);
        if (listD == null) {
            androidx.window.layout.c.k("Null frames");
            return null;
        }
        byte b10 = (byte) (0 | 1);
        t0 t0VarC = null;
        if (rVar2 != null && i12 == 0) {
            t0VarC = c(rVar2, i10 + 1);
        }
        if (b10 == 1) {
            return new t0(str, str2, listD, t0VarC, i12);
        }
        StringBuilder sb = new StringBuilder();
        if ((b10 & 1) == 0) {
            sb.append(" overflowCount");
        }
        androidx.window.layout.c.g(r1.i.e(sb, "Missing required properties:"));
        return null;
    }

    public static List d(StackTraceElement[] stackTraceElementArr, int i10) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            w0 w0Var = new w0();
            w0Var.e = i10;
            w0Var.f = (byte) (w0Var.f | 4);
            long lineNumber = 0;
            long jMax = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
            String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
            String fileName = stackTraceElement.getFileName();
            if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
                lineNumber = stackTraceElement.getLineNumber();
            }
            w0Var.f14377a = jMax;
            byte b10 = (byte) (w0Var.f | 1);
            w0Var.f14378b = str;
            w0Var.f14379c = fileName;
            w0Var.f14380d = lineNumber;
            w0Var.f = (byte) (b10 | 2);
            arrayList.add(w0Var.a());
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    public static u0 e() {
        byte b10 = (byte) 1;
        if (b10 == 1) {
            return new u0("0", "0", 0L);
        }
        StringBuilder sb = new StringBuilder();
        if (b10 == 0) {
            sb.append(" address");
        }
        androidx.window.layout.c.g(r1.i.e(sb, "Missing required properties:"));
        return null;
    }

    public final List a() {
        byte b10 = (byte) (((byte) (0 | 1)) | 2);
        a aVar = this.f13385c;
        String str = aVar.e;
        if (str == null) {
            androidx.window.layout.c.k("Null name");
            return null;
        }
        String str2 = aVar.f13318b;
        if (b10 == 3) {
            return Collections.singletonList(new s0(0L, 0L, str, str2));
        }
        StringBuilder sb = new StringBuilder();
        if ((b10 & 1) == 0) {
            sb.append(" baseAddress");
        }
        if ((b10 & 2) == 0) {
            sb.append(" size");
        }
        androidx.window.layout.c.g(r1.i.e(sb, "Missing required properties:"));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final z1.b1 b(int r17) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.q.b(int):z1.b1");
    }
}
