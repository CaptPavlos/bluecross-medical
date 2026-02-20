package a6;

import android.content.Context;
import android.util.Log;
import com.uptodown.UptodownApp;
import com.uptodown.workers.PreRegisterWorker;
import h5.g0;
import j4.y;
import java.net.ProtocolException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import p8.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o implements g5.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f276a;

    /* renamed from: b, reason: collision with root package name */
    public int f277b;

    /* renamed from: c, reason: collision with root package name */
    public Object f278c;

    /* renamed from: d, reason: collision with root package name */
    public Object f279d;

    public o(String str, String[] strArr) {
        String string;
        this.f276a = 3;
        if (strArr.length == 0) {
            string = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str2 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str2);
            }
            sb.append("] ");
            string = sb.toString();
        }
        this.f279d = string;
        this.f278c = str;
        int i10 = 2;
        Object[] objArr = {str, 23};
        if (!(str.length() <= 23)) {
            throw new IllegalArgumentException(String.format("tag \"%s\" is longer than the %d character maximum", objArr));
        }
        while (i10 <= 7 && !Log.isLoggable((String) this.f278c, i10)) {
            i10++;
        }
        this.f277b = i10;
    }

    public static o d(String str) throws ProtocolException, NumberFormatException {
        int i10;
        String strSubstring;
        boolean zStartsWith = str.startsWith("HTTP/1.");
        x xVar = x.HTTP_1_0;
        if (zStartsWith) {
            i10 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                xVar = x.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            i10 = 4;
        }
        int i11 = i10 + 3;
        if (str.length() < i11) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        try {
            int i12 = Integer.parseInt(str.substring(i10, i11));
            if (str.length() <= i11) {
                strSubstring = "";
            } else {
                if (str.charAt(i11) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                strSubstring = str.substring(i10 + 4);
            }
            return new o(xVar, i12, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
    }

    public j1.n a() {
        j1.e eVar = (j1.e) this.f279d;
        if (eVar != null) {
            throw eVar.a();
        }
        j1.n nVarA = j1.n.a(this.f277b, (Object[]) this.f278c, this);
        j1.e eVar2 = (j1.e) this.f279d;
        if (eVar2 == null) {
            return nVarA;
        }
        throw eVar2.a();
    }

    public void b(String str, Object... objArr) {
        if (this.f277b <= 3) {
            String str2 = (String) this.f278c;
            if (objArr.length > 0) {
                str = String.format(Locale.US, str, objArr);
            }
            Log.d(str2, ((String) this.f279d).concat(str));
        }
    }

    public String c() {
        StringBuilder sb = new StringBuilder("$");
        int i10 = this.f277b + 1;
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = ((Object[]) this.f278c)[i11];
            if (obj instanceof e8.e) {
                e8.e eVar = (e8.e) obj;
                boolean zA = kotlin.jvm.internal.l.a(eVar.getKind(), e8.i.f7974d);
                int[] iArr = (int[]) this.f279d;
                if (!zA) {
                    int i12 = iArr[i11];
                    if (i12 >= 0) {
                        sb.append(".");
                        sb.append(eVar.f(i12));
                    }
                } else if (iArr[i11] != -1) {
                    sb.append("[");
                    sb.append(((int[]) this.f279d)[i11]);
                    sb.append("]");
                }
            } else if (obj != i8.m.f9076a) {
                sb.append("['");
                sb.append(obj);
                sb.append("']");
            }
        }
        return sb.toString();
    }

    public void e(Object obj, Object obj2) {
        int i10 = (this.f277b + 1) * 2;
        Object[] objArr = (Object[]) this.f278c;
        if (i10 > objArr.length) {
            this.f278c = Arrays.copyOf(objArr, r0.f.v(objArr.length, i10));
        }
        if (obj == null) {
            String strValueOf = String.valueOf(obj2);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
            sb.append("null key in entry: null=");
            sb.append(strValueOf);
            throw new NullPointerException(sb.toString());
        }
        if (obj2 == null) {
            String strValueOf2 = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 26);
            sb2.append("null value in entry: ");
            sb2.append(strValueOf2);
            sb2.append("=null");
            throw new NullPointerException(sb2.toString());
        }
        Object[] objArr2 = (Object[]) this.f278c;
        int i11 = this.f277b;
        int i12 = i11 * 2;
        objArr2[i12] = obj;
        objArr2[i12 + 1] = obj2;
        this.f277b = i11 + 1;
    }

    public void g(Collection collection) {
        if (collection instanceof Collection) {
            int size = (collection.size() + this.f277b) * 2;
            Object[] objArr = (Object[]) this.f278c;
            if (size > objArr.length) {
                this.f278c = Arrays.copyOf(objArr, r0.f.v(objArr.length, size));
            }
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            e(entry.getKey(), entry.getValue());
        }
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        h5.h hVar2;
        PreRegisterWorker preRegisterWorker = (PreRegisterWorker) this.f278c;
        Context context = preRegisterWorker.f6748a;
        g0 g0Var = (g0) this.f279d;
        int i10 = this.f277b;
        String strH = hVar.h();
        if (strH != null) {
            hVar2 = hVar;
            y.d().e(strH).b(new f(preRegisterWorker, strH, g0Var, hVar2, i10, 1));
        } else {
            hVar2 = hVar;
            v5.i.e(context, hVar2, i10, null, g0Var);
        }
        if (g0Var.e == 1 && hVar2.j()) {
            float f = UptodownApp.E;
            k4.c.u(hVar2, context);
        }
    }

    public String toString() {
        switch (this.f276a) {
            case 1:
                return c();
            case 4:
                String str = (String) this.f279d;
                StringBuilder sb = new StringBuilder();
                sb.append(((x) this.f278c) == x.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
                sb.append(' ');
                sb.append(this.f277b);
                sb.append(' ');
                sb.append(str);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    @Override // g5.i
    public void f(int i10) {
    }

    public /* synthetic */ o() {
        this.f276a = 1;
    }

    public o(x xVar, int i10, String str) {
        this.f276a = 4;
        this.f278c = xVar;
        this.f277b = i10;
        this.f279d = str;
    }

    public o(PreRegisterWorker preRegisterWorker, g0 g0Var, int i10) {
        this.f276a = 0;
        this.f278c = preRegisterWorker;
        this.f279d = g0Var;
        this.f277b = i10;
    }

    public o(int i10) {
        this.f276a = 2;
        this.f278c = new Object[i10 * 2];
        this.f277b = 0;
    }
}
