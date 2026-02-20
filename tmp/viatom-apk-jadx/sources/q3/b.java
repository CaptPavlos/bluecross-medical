package q3;

import j$.util.Collection;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final List f12256a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f12257b;

    static {
        HashMap map = new HashMap();
        f12257b = map;
        map.put(2, "tcfeuv2");
        map.put(5, "tcfcav1");
        map.put(6, "uspv1");
        map.put(7, "usnat");
        map.put(8, "usca");
        map.put(9, "usva");
        map.put(10, "usco");
        map.put(11, "usut");
        map.put(12, "usct");
        map.put(13, "usfl");
        map.put(14, "usmt");
        map.put(15, "usor");
        map.put(16, "ustx");
        map.put(17, "usde");
        map.put(18, "usia");
        map.put(19, "usne");
        map.put(20, "usnh");
        map.put(21, "usnj");
        map.put(22, "ustn");
        f12256a = (List) Collection.EL.stream(new ArrayList(map.keySet())).sorted().map(new k3.a(2)).collect(Collectors.toList());
    }
}
