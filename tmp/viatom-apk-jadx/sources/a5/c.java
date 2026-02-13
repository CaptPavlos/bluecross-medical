package a5;

import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public int f225a;

    /* renamed from: b, reason: collision with root package name */
    public d f226b;

    public final void a() throws NoSuchFieldException, SecurityException, IOException {
        Field declaredField;
        d dVar = this.f226b;
        try {
            Class<?> cls = dVar.e.getClass();
            try {
                declaredField = cls.getDeclaredField("pid");
            } catch (NoSuchFieldException unused) {
                declaredField = cls.getDeclaredField("id");
            }
            declaredField.setAccessible(true);
            int iIntValue = ((Integer) declaredField.get(dVar.e)).intValue();
            dVar.h.write("(echo -17 > /proc/" + iIntValue + "/oom_adj) &> /dev/null\n");
            dVar.h.write("(echo -17 > /proc/$$/oom_adj) &> /dev/null\n");
            dVar.h.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws NoSuchFieldException, IOException, SecurityException {
        d dVar = this.f226b;
        try {
            dVar.h.write("echo Started\n");
            dVar.h.flush();
            while (true) {
                String line = dVar.f.readLine();
                if (line == null) {
                    throw new EOFException();
                }
                if (!"".equals(line)) {
                    if ("Started".equals(line)) {
                        this.f225a = 1;
                        a();
                        return;
                    }
                    dVar.f231d = "unknown error occurred.";
                }
            }
        } catch (IOException e) {
            this.f225a = -42;
            if (e.getMessage() != null) {
                dVar.f231d = e.getMessage();
            } else {
                dVar.f231d = "RootAccess denied?.";
            }
        }
    }
}
