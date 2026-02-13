package a9;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import e5.b2;
import e5.j0;
import e5.m1;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import o7.u;
import z8.b0;
import z8.k0;
import z8.p;
import z8.v;
import z8.w;
import z8.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends m implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f340a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f341b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(Object obj, int i10) {
        super(0);
        this.f340a = i10;
        this.f341b = obj;
    }

    /* JADX WARN: Finally extract failed */
    @Override // g7.a
    public final Object invoke() throws IOException {
        int iM0;
        int i10;
        ArrayList arrayList;
        int i11;
        s6.i iVar;
        s6.i iVar2;
        int i12 = this.f340a;
        Object obj = this.f341b;
        switch (i12) {
            case 0:
                z zVar = g.f342c;
                ClassLoader classLoader = (ClassLoader) obj;
                Enumeration<URL> resources = classLoader.getResources("");
                resources.getClass();
                ArrayList list = Collections.list(resources);
                list.getClass();
                ArrayList arrayList2 = new ArrayList();
                int size = list.size();
                boolean z9 = false;
                int i13 = 0;
                while (i13 < size) {
                    Object obj2 = list.get(i13);
                    i13++;
                    URL url = (URL) obj2;
                    z zVar2 = g.f342c;
                    url.getClass();
                    if (l.a(url.getProtocol(), "file")) {
                        w wVar = p.f14501a;
                        String str = z.f14517b;
                        String string = new File(url.toURI()).toString();
                        string.getClass();
                        iVar2 = new s6.i(wVar, t3.h.i(string, false));
                    } else {
                        iVar2 = null;
                    }
                    if (iVar2 != null) {
                        arrayList2.add(iVar2);
                    }
                }
                Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
                resources2.getClass();
                ArrayList list2 = Collections.list(resources2);
                list2.getClass();
                ArrayList arrayList3 = new ArrayList();
                int size2 = list2.size();
                int i14 = 0;
                while (i14 < size2) {
                    Object obj3 = list2.get(i14);
                    int i15 = i14 + 1;
                    URL url2 = (URL) obj3;
                    z zVar3 = g.f342c;
                    url2.getClass();
                    String string2 = url2.toString();
                    string2.getClass();
                    if (u.c0(string2, "jar:file:", z9) && (iM0 = o7.m.m0("!", string2, 6)) != -1) {
                        String str2 = z.f14517b;
                        String string3 = new File(URI.create(string2.substring(4, iM0))).toString();
                        string3.getClass();
                        z zVarI = t3.h.i(string3, z9);
                        w wVar2 = p.f14501a;
                        wVar2.getClass();
                        v vVarF = wVar2.f(zVarI);
                        try {
                            long size3 = vVarF.size() - 22;
                            long j10 = 0;
                            if (size3 < 0) {
                                throw new IOException("not a zip: size=" + vVarF.size());
                            }
                            i10 = i15;
                            long jMax = Math.max(size3 - 65536, 0L);
                            while (true) {
                                b0 b0Var = new b0(vVarF.b(size3));
                                try {
                                    long j11 = j10;
                                    if (b0Var.readIntLe() == 101010256) {
                                        int shortLe = b0Var.readShortLe() & 65535;
                                        int shortLe2 = b0Var.readShortLe() & 65535;
                                        long shortLe3 = b0Var.readShortLe() & 65535;
                                        arrayList = list2;
                                        if (shortLe3 != (b0Var.readShortLe() & 65535) || shortLe != 0 || shortLe2 != 0) {
                                            throw new IOException("unsupported zip: spanned");
                                        }
                                        b0Var.skip(4L);
                                        int shortLe4 = b0Var.readShortLe() & 65535;
                                        d dVar = new d(shortLe3, b0Var.readIntLe() & 4294967295L, shortLe4);
                                        b0Var.readUtf8(shortLe4);
                                        b0Var.close();
                                        long j12 = size3 - 20;
                                        if (j12 > j11) {
                                            b0Var = new b0(vVarF.b(j12));
                                            try {
                                                if (b0Var.readIntLe() == 117853008) {
                                                    int intLe = b0Var.readIntLe();
                                                    long longLe = b0Var.readLongLe();
                                                    if (b0Var.readIntLe() != 1 || intLe != 0) {
                                                        throw new IOException("unsupported zip: spanned");
                                                    }
                                                    b0Var = new b0(vVarF.b(longLe));
                                                    try {
                                                        int intLe2 = b0Var.readIntLe();
                                                        if (intLe2 != 101075792) {
                                                            throw new IOException("bad zip: expected " + b.c(101075792) + " but was " + b.c(intLe2));
                                                        }
                                                        b0Var.skip(12L);
                                                        int intLe3 = b0Var.readIntLe();
                                                        int intLe4 = b0Var.readIntLe();
                                                        long longLe2 = b0Var.readLongLe();
                                                        if (longLe2 != b0Var.readLongLe() || intLe3 != 0 || intLe4 != 0) {
                                                            throw new IOException("unsupported zip: spanned");
                                                        }
                                                        b0Var.skip(8L);
                                                        dVar = new d(longLe2, b0Var.readLongLe(), shortLe4);
                                                    } finally {
                                                    }
                                                }
                                            } finally {
                                            }
                                        }
                                        d dVar2 = dVar;
                                        long j13 = dVar2.f336b;
                                        ArrayList arrayList4 = new ArrayList();
                                        b0Var = new b0(vVarF.b(j13));
                                        try {
                                            long j14 = dVar2.f335a;
                                            long j15 = j11;
                                            while (j15 < j14) {
                                                h hVarD = b.d(b0Var);
                                                int i16 = size2;
                                                long j16 = j13;
                                                if (hVarD.g >= j16) {
                                                    throw new IOException("bad zip: local file header offset >= central directory offset");
                                                }
                                                z zVar4 = g.f342c;
                                                if (o2.e.b(hVarD.f344a)) {
                                                    arrayList4.add(hVarD);
                                                }
                                                j15++;
                                                size2 = i16;
                                                j13 = j16;
                                            }
                                            i11 = size2;
                                            b0Var.close();
                                            k0 k0Var = new k0(zVarI, wVar2, b.b(arrayList4));
                                            vVarF.close();
                                            iVar = new s6.i(k0Var, g.f342c);
                                        } catch (Throwable th) {
                                            try {
                                                throw th;
                                            } finally {
                                            }
                                        }
                                    } else {
                                        ArrayList arrayList5 = list2;
                                        int i17 = size2;
                                        b0Var.close();
                                        size3--;
                                        if (size3 < jMax) {
                                            throw new IOException("not a zip: end of central directory signature not found");
                                        }
                                        list2 = arrayList5;
                                        j10 = j11;
                                        size2 = i17;
                                    }
                                } finally {
                                    b0Var.close();
                                }
                            }
                        } finally {
                        }
                    } else {
                        arrayList = list2;
                        i11 = size2;
                        i10 = i15;
                        iVar = null;
                    }
                    if (iVar != null) {
                        arrayList3.add(iVar);
                    }
                    list2 = arrayList;
                    i14 = i10;
                    size2 = i11;
                    z9 = false;
                }
                return t6.l.l0(arrayList3, arrayList2);
            case 1:
                return (j0) obj;
            case 2:
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) ((f) obj).invoke()).getViewModelStore();
                viewModelStore.getClass();
                return viewModelStore;
            case 3:
                return (m1) obj;
            case 4:
                ViewModelStore viewModelStore2 = ((ViewModelStoreOwner) ((f) obj).invoke()).getViewModelStore();
                viewModelStore2.getClass();
                return viewModelStore2;
            case 5:
                return (b2) obj;
            default:
                ViewModelStore viewModelStore3 = ((ViewModelStoreOwner) ((f) obj).invoke()).getViewModelStore();
                viewModelStore3.getClass();
                return viewModelStore3;
        }
    }
}
