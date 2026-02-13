package s4;

import c1.g1;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.zip.ZipOutputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public g1 f12552a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f12553b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f12554c;

    /* renamed from: d, reason: collision with root package name */
    public ZipOutputStream f12555d;
    public byte[] e;
    public BufferedInputStream f;
    public long g;
    public long h;

    /* renamed from: i, reason: collision with root package name */
    public int f12556i;

    /* renamed from: j, reason: collision with root package name */
    public int f12557j;

    /* renamed from: k, reason: collision with root package name */
    public int f12558k;

    /* renamed from: l, reason: collision with root package name */
    public int f12559l;

    /* renamed from: m, reason: collision with root package name */
    public int f12560m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object f12561n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ g1 f12562o;

    /* renamed from: p, reason: collision with root package name */
    public int f12563p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g1 g1Var, y6.c cVar) {
        super(cVar);
        this.f12562o = g1Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f12561n = obj;
        this.f12563p |= Integer.MIN_VALUE;
        return this.f12562o.m(null, null, null, 0L, this);
    }
}
