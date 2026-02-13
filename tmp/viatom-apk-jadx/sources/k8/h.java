package k8;

import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends d {

    /* renamed from: c, reason: collision with root package name */
    public final String f10094c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f10095d;
    public final Set e;
    public final Set f;
    public final Set g;
    public final Set h;

    /* renamed from: i, reason: collision with root package name */
    public final Set f10096i;

    /* renamed from: j, reason: collision with root package name */
    public final String f10097j;

    /* renamed from: k, reason: collision with root package name */
    public final String f10098k;

    /* renamed from: l, reason: collision with root package name */
    public final int f10099l;

    /* renamed from: m, reason: collision with root package name */
    public final Boolean f10100m;

    /* renamed from: n, reason: collision with root package name */
    public final Set f10101n;

    /* renamed from: o, reason: collision with root package name */
    public final e2.c f10102o;

    /* renamed from: p, reason: collision with root package name */
    public final String f10103p;

    public h(int i10, String str, String str2, Set set, Set set2, Set set3, Set set4, Set set5, Set set6, String str3, String str4, int i11, Boolean bool, Set set7, e2.c cVar, LinkedHashSet linkedHashSet, String str5, int i12) {
        String str6 = (i12 & 4) != 0 ? null : str2;
        Set linkedHashSet2 = (i12 & 8) != 0 ? new LinkedHashSet() : set;
        Set linkedHashSet3 = (i12 & 16) != 0 ? new LinkedHashSet() : set2;
        Set linkedHashSet4 = (i12 & 32) != 0 ? new LinkedHashSet() : set3;
        Set linkedHashSet5 = (i12 & 64) != 0 ? new LinkedHashSet() : set4;
        Set linkedHashSet6 = (i12 & 128) != 0 ? new LinkedHashSet() : set5;
        Set linkedHashSet7 = (i12 & 256) != 0 ? new LinkedHashSet() : set6;
        String str7 = (i12 & 512) != 0 ? "" : str3;
        String str8 = (i12 & 1024) != 0 ? null : str4;
        int i13 = (i12 & 4096) != 0 ? -1 : i11;
        Boolean bool2 = (32768 & i12) == 0 ? bool : null;
        Set linkedHashSet8 = (65536 & i12) != 0 ? new LinkedHashSet() : set7;
        if ((262144 & i12) != 0) {
            new LinkedHashSet();
        }
        String str9 = (i12 & 524288) == 0 ? str5 : "";
        super(i10, str);
        this.f10094c = str6;
        this.f10095d = linkedHashSet2;
        this.e = linkedHashSet3;
        this.f = linkedHashSet4;
        this.g = linkedHashSet5;
        this.h = linkedHashSet6;
        this.f10096i = linkedHashSet7;
        this.f10097j = str7;
        this.f10098k = str8;
        this.f10099l = i13;
        this.f10100m = bool2;
        this.f10101n = linkedHashSet8;
        this.f10102o = cVar;
        this.f10103p = str9;
    }
}
