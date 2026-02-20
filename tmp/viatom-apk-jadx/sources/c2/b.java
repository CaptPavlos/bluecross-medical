package c2;

import a6.h;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import d5.n;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import w1.i;
import z1.j2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {
    public static final Charset e = Charset.forName(C.UTF8_NAME);
    public static final int f = 15;
    public static final a2.b g = new a2.b();
    public static final h h = new h(2);

    /* renamed from: i, reason: collision with root package name */
    public static final a f1634i = new a(0);

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f1635a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public final d f1636b;

    /* renamed from: c, reason: collision with root package name */
    public final n f1637c;

    /* renamed from: d, reason: collision with root package name */
    public final i f1638d;

    public b(d dVar, n nVar, i iVar) {
        this.f1636b = dVar;
        this.f1637c = nVar;
        this.f1638d = iVar;
    }

    public static void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public static String e(File file) {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i10 = fileInputStream.read(bArr);
                if (i10 <= 0) {
                    String str = new String(byteArrayOutputStream.toByteArray(), e);
                    fileInputStream.close();
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, i10);
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public static void f(File file, String str) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), e);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        d dVar = this.f1636b;
        arrayList.addAll(d.m(((File) dVar.g).listFiles()));
        arrayList.addAll(d.m(((File) dVar.h).listFiles()));
        h hVar = h;
        Collections.sort(arrayList, hVar);
        List listM = d.m(((File) dVar.f).listFiles());
        Collections.sort(listM, hVar);
        arrayList.addAll(listM);
        return arrayList;
    }

    public final NavigableSet c() {
        return new TreeSet(d.m(((File) this.f1636b.e).list())).descendingSet();
    }

    public final void d(j2 j2Var, String str, boolean z9) {
        d dVar = this.f1636b;
        int i10 = this.f1637c.k().f7631a.f7630a;
        g.getClass();
        try {
            f(dVar.h(str, androidx.constraintlayout.core.widgets.analyzer.a.x(NotificationCompat.CATEGORY_EVENT, String.format(Locale.US, "%010d", Integer.valueOf(this.f1635a.getAndIncrement())), z9 ? "_" : "")), a2.b.f21a.w(j2Var));
        } catch (IOException e3) {
            Log.w("FirebaseCrashlytics", "Could not persist event for session " + str, e3);
        }
        a aVar = new a(1);
        dVar.getClass();
        File file = new File((File) dVar.e, str);
        file.mkdirs();
        List<File> listM = d.m(file.listFiles(aVar));
        Collections.sort(listM, new h(3));
        int size = listM.size();
        for (File file2 : listM) {
            if (size <= i10) {
                return;
            }
            d.l(file2);
            size--;
        }
    }
}
