package a6;

import androidx.constraintlayout.core.utils.GridCore;
import java.io.File;
import java.util.Comparator;
import z1.f0;
import z1.q1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f259a;

    public /* synthetic */ h(int i10) {
        this.f259a = i10;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f259a) {
            case 0:
                h5.f fVar = (h5.f) obj;
                h5.f fVar2 = (h5.f) obj2;
                fVar.getClass();
                fVar2.getClass();
                String str = fVar.f8525b;
                if (str == null) {
                    return 1;
                }
                String str2 = fVar2.f8525b;
                if (str2 == null) {
                    return -1;
                }
                return str.compareToIgnoreCase(str2);
            case 1:
                return GridCore.lambda$parseSpans$0((String) obj, (String) obj2);
            case 2:
                return ((File) obj2).getName().compareTo(((File) obj).getName());
            case 3:
                String name = ((File) obj).getName();
                int i10 = c2.b.f;
                return name.substring(0, i10).compareTo(((File) obj2).getName().substring(0, i10));
            case 4:
                return ((Double) obj).compareTo((Double) obj2);
            case 5:
                h5.f fVar3 = (h5.f) obj;
                h5.f fVar4 = (h5.f) obj2;
                fVar3.getClass();
                fVar4.getClass();
                String str3 = fVar3.f8525b;
                if (str3 == null) {
                    return 1;
                }
                String str4 = fVar4.f8525b;
                if (str4 == null) {
                    return -1;
                }
                return str3.compareToIgnoreCase(str4);
            case 6:
                h5.f fVar5 = (h5.f) obj;
                h5.f fVar6 = (h5.f) obj2;
                fVar5.getClass();
                fVar6.getClass();
                String str5 = fVar5.f8525b;
                if (str5 == null) {
                    return 1;
                }
                String str6 = fVar6.f8525b;
                if (str6 == null) {
                    return -1;
                }
                return str5.compareToIgnoreCase(str6);
            case 7:
                return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
            case 8:
                return ((f0) ((q1) obj)).f14214a.compareTo(((f0) ((q1) obj2)).f14214a);
            case 9:
                u4.e eVar = (u4.e) obj;
                u4.e eVar2 = (u4.e) obj2;
                eVar.getClass();
                eVar2.getClass();
                File file = eVar.f12904a;
                if (file == null) {
                    return 1;
                }
                if (eVar2.f12904a == null) {
                    return -1;
                }
                String name2 = file.getName();
                name2.getClass();
                File file2 = eVar2.f12904a;
                file2.getClass();
                String name3 = file2.getName();
                name3.getClass();
                return name2.compareToIgnoreCase(name3);
            case 10:
                u4.e eVar3 = (u4.e) obj;
                u4.e eVar4 = (u4.e) obj2;
                eVar3.getClass();
                eVar4.getClass();
                if (eVar3.f12904a == null) {
                    return 1;
                }
                if (eVar4.f12904a == null) {
                    return -1;
                }
                return Boolean.compare(!eVar3.f12905b, !eVar4.f12905b);
            case 11:
                u4.e eVar5 = (u4.e) obj;
                u4.e eVar6 = (u4.e) obj2;
                eVar5.getClass();
                eVar6.getClass();
                File file3 = eVar5.f12904a;
                if (file3 == null) {
                    return 1;
                }
                if (eVar6.f12904a == null) {
                    return -1;
                }
                String name4 = file3.getName();
                name4.getClass();
                File file4 = eVar6.f12904a;
                file4.getClass();
                String name5 = file4.getName();
                name5.getClass();
                return name4.compareToIgnoreCase(name5);
            case 12:
                u4.e eVar7 = (u4.e) obj;
                u4.e eVar8 = (u4.e) obj2;
                eVar7.getClass();
                eVar8.getClass();
                File file5 = eVar7.f12904a;
                if (file5 == null) {
                    return 1;
                }
                if (eVar8.f12904a == null) {
                    return -1;
                }
                String name6 = file5.getName();
                name6.getClass();
                File file6 = eVar8.f12904a;
                file6.getClass();
                String name7 = file6.getName();
                name7.getClass();
                return name6.compareToIgnoreCase(name7);
            default:
                u4.e eVar9 = (u4.e) obj;
                u4.e eVar10 = (u4.e) obj2;
                eVar9.getClass();
                eVar10.getClass();
                File file7 = eVar9.f12904a;
                if (file7 == null) {
                    return 1;
                }
                if (eVar10.f12904a == null) {
                    return -1;
                }
                String name8 = file7.getName();
                name8.getClass();
                File file8 = eVar10.f12904a;
                file8.getClass();
                String name9 = file8.getName();
                name9.getClass();
                return name8.compareToIgnoreCase(name9);
        }
    }
}
