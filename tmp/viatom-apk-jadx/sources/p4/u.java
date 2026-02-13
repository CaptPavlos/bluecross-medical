package p4;

import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import java.util.Comparator;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12019a;

    public /* synthetic */ u(int i10) {
        this.f12019a = i10;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        String upperCase;
        switch (this.f12019a) {
            case 0:
                return l1.b.u(Boolean.valueOf(((File) obj).isFile()), Boolean.valueOf(((File) obj2).isFile()));
            case 1:
                String name = ((DocumentFile) obj2).getName();
                String upperCase2 = null;
                if (name != null) {
                    upperCase = name.toUpperCase(Locale.ROOT);
                    upperCase.getClass();
                } else {
                    upperCase = null;
                }
                String name2 = ((DocumentFile) obj).getName();
                if (name2 != null) {
                    upperCase2 = name2.toUpperCase(Locale.ROOT);
                    upperCase2.getClass();
                }
                return l1.b.u(upperCase, upperCase2);
            case 2:
                return l1.b.u(Boolean.valueOf(((DocumentFile) obj2).isDirectory()), Boolean.valueOf(((DocumentFile) obj).isDirectory()));
            case 3:
                String name3 = ((File) obj2).getName();
                name3.getClass();
                Locale locale = Locale.ROOT;
                String upperCase3 = name3.toUpperCase(locale);
                upperCase3.getClass();
                String name4 = ((File) obj).getName();
                name4.getClass();
                String upperCase4 = name4.toUpperCase(locale);
                upperCase4.getClass();
                return l1.b.u(upperCase3, upperCase4);
            case 4:
                return l1.b.u(Boolean.valueOf(((File) obj2).isDirectory()), Boolean.valueOf(((File) obj).isDirectory()));
            case 5:
                return l1.b.u(Long.valueOf(((DocumentFile) obj).length()), Long.valueOf(((DocumentFile) obj2).length()));
            case 6:
                return l1.b.u(Boolean.valueOf(((DocumentFile) obj).isFile()), Boolean.valueOf(((DocumentFile) obj2).isFile()));
            case 7:
                return l1.b.u(Long.valueOf(((File) obj).length()), Long.valueOf(((File) obj2).length()));
            case 8:
                return l1.b.u(Boolean.valueOf(((File) obj).isFile()), Boolean.valueOf(((File) obj2).isFile()));
            case 9:
                return l1.b.u(Long.valueOf(((DocumentFile) obj2).length()), Long.valueOf(((DocumentFile) obj).length()));
            case 10:
                return l1.b.u(Boolean.valueOf(((DocumentFile) obj2).isDirectory()), Boolean.valueOf(((DocumentFile) obj).isDirectory()));
            case 11:
                return l1.b.u(Long.valueOf(((File) obj2).length()), Long.valueOf(((File) obj).length()));
            case 12:
                return l1.b.u(Boolean.valueOf(((File) obj2).isDirectory()), Boolean.valueOf(((File) obj).isDirectory()));
            case 13:
                return ((String) obj).compareTo((String) obj2);
            case 14:
                h5.e eVar = ((h5.f) obj).g;
                h5.e eVar2 = h5.e.f8506a;
                return l1.b.u(Boolean.valueOf(eVar != eVar2), Boolean.valueOf(((h5.f) obj2).g != eVar2));
            default:
                return l1.b.u(Long.valueOf(((File) obj2).lastModified()), Long.valueOf(((File) obj).lastModified()));
        }
    }
}
