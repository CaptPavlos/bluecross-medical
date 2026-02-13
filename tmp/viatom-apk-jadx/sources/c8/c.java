package c8;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends f {

    /* renamed from: a, reason: collision with root package name */
    public final List f1815a;

    /* JADX WARN: Illegal instructions before constructor call */
    public c(String str, ArrayList arrayList) {
        String str2;
        str.getClass();
        if (arrayList.size() == 1) {
            str2 = "Field '" + ((String) arrayList.get(0)) + "' is required for type with serial name '" + str + "', but it was missing";
        } else {
            str2 = "Fields " + arrayList + " are required for type with serial name '" + str + "', but they were missing";
        }
        super(str2, null);
        this.f1815a = arrayList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(List list, String str, c cVar) {
        super(str, cVar);
        list.getClass();
        this.f1815a = list;
    }
}
