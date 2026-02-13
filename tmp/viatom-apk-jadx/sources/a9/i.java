package a9;

import androidx.documentfile.provider.DocumentFile;
import h5.g0;
import h5.g1;
import h5.j1;
import h5.o;
import h5.q;
import h5.r;
import java.io.File;
import java.util.Comparator;
import java.util.Locale;
import n4.u0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i implements Comparator {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ i f348b = new i(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f349a;

    public /* synthetic */ i(int i10) {
        this.f349a = i10;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        String upperCase;
        switch (this.f349a) {
            case 0:
                return l1.b.u(((h) obj).f344a, ((h) obj2).f344a);
            case 1:
                return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
            case 2:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            case 3:
                return l1.b.u(Integer.valueOf(((j1) obj2).f8630c), Integer.valueOf(((j1) obj).f8630c));
            case 4:
                return l1.b.u(Integer.valueOf(((o) obj).f8671a), Integer.valueOf(((o) obj2).f8671a));
            case 5:
                return l1.b.u(Long.valueOf(((g1) obj2).f8564c), Long.valueOf(((g1) obj).f8564c));
            case 6:
                return l1.b.u(Long.valueOf(((g1) obj2).f8564c), Long.valueOf(((g1) obj).f8564c));
            case 7:
                q qVar = (q) obj2;
                if (!qVar.f8716v.isEmpty() && ((r) qVar.f8716v.get(0)).h != null) {
                    String str = ((r) qVar.f8716v.get(0)).h;
                    str.getClass();
                    File file = new File(str);
                    if (file.exists()) {
                        file.lastModified();
                    }
                }
                q qVar2 = (q) obj;
                if (!qVar2.f8716v.isEmpty() && ((r) qVar2.f8716v.get(0)).h != null) {
                    String str2 = ((r) qVar2.f8716v.get(0)).h;
                    str2.getClass();
                    File file2 = new File(str2);
                    if (file2.exists()) {
                        file2.lastModified();
                    }
                }
                return l1.b.u(0L, 0L);
            case 8:
                return l1.b.u(((q) obj).f8709n, ((q) obj2).f8709n);
            case 9:
                return l1.b.u(Long.valueOf(((q) obj).k()), Long.valueOf(((q) obj2).k()));
            case 10:
                return l1.b.u(((g0) obj).f8559b, ((g0) obj2).f8559b);
            case 11:
                return l1.b.u(((h5.f) obj).f8525b, ((h5.f) obj2).f8525b);
            case 12:
                return l1.b.u(((u0) obj).f11493a.f8525b, ((u0) obj2).f11493a.f8525b);
            case 13:
                return l1.b.u(Long.valueOf(((g1) obj).f8564c), Long.valueOf(((g1) obj2).f8564c));
            case 14:
                return l1.b.u(Long.valueOf(((g1) obj).f8564c), Long.valueOf(((g1) obj2).f8564c));
            case 15:
                return l1.b.u(Long.valueOf(((g1) obj2).f8564c), Long.valueOf(((g1) obj).f8564c));
            case 16:
                return l1.b.u(Long.valueOf(((g1) obj2).f8564c), Long.valueOf(((g1) obj).f8564c));
            case 17:
                return l1.b.u(Long.valueOf(((g1) obj).f8564c), Long.valueOf(((g1) obj2).f8564c));
            case 18:
                return l1.b.u(Long.valueOf(((g1) obj2).f8564c), Long.valueOf(((g1) obj).f8564c));
            case 19:
                return l1.b.u(Long.valueOf(((DocumentFile) obj).lastModified()), Long.valueOf(((DocumentFile) obj2).lastModified()));
            case 20:
                return l1.b.u(Boolean.valueOf(((DocumentFile) obj).isFile()), Boolean.valueOf(((DocumentFile) obj2).isFile()));
            case 21:
                return l1.b.u(Long.valueOf(((File) obj).lastModified()), Long.valueOf(((File) obj2).lastModified()));
            case 22:
                return l1.b.u(Boolean.valueOf(((File) obj).isFile()), Boolean.valueOf(((File) obj2).isFile()));
            case 23:
                return l1.b.u(Long.valueOf(((DocumentFile) obj2).lastModified()), Long.valueOf(((DocumentFile) obj).lastModified()));
            case 24:
                return l1.b.u(Boolean.valueOf(((DocumentFile) obj2).isDirectory()), Boolean.valueOf(((DocumentFile) obj).isDirectory()));
            case 25:
                return l1.b.u(Long.valueOf(((File) obj2).lastModified()), Long.valueOf(((File) obj).lastModified()));
            case 26:
                return l1.b.u(Boolean.valueOf(((File) obj2).isDirectory()), Boolean.valueOf(((File) obj).isDirectory()));
            case 27:
                String name = ((DocumentFile) obj).getName();
                String upperCase2 = null;
                if (name != null) {
                    upperCase = name.toUpperCase(Locale.ROOT);
                    upperCase.getClass();
                } else {
                    upperCase = null;
                }
                String name2 = ((DocumentFile) obj2).getName();
                if (name2 != null) {
                    upperCase2 = name2.toUpperCase(Locale.ROOT);
                    upperCase2.getClass();
                }
                return l1.b.u(upperCase, upperCase2);
            case 28:
                return l1.b.u(Boolean.valueOf(((DocumentFile) obj).isFile()), Boolean.valueOf(((DocumentFile) obj2).isFile()));
            default:
                String name3 = ((File) obj).getName();
                name3.getClass();
                Locale locale = Locale.ROOT;
                String upperCase3 = name3.toUpperCase(locale);
                upperCase3.getClass();
                String name4 = ((File) obj2).getName();
                name4.getClass();
                String upperCase4 = name4.toUpperCase(locale);
                upperCase4.getClass();
                return l1.b.u(upperCase3, upperCase4);
        }
    }
}
