package j4;

import java.io.PrintWriter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f9967a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9968b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9969c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9970d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;

    /* renamed from: i, reason: collision with root package name */
    public final long f9971i;

    /* renamed from: j, reason: collision with root package name */
    public final long f9972j;

    /* renamed from: k, reason: collision with root package name */
    public final int f9973k;

    /* renamed from: l, reason: collision with root package name */
    public final int f9974l;

    /* renamed from: m, reason: collision with root package name */
    public final int f9975m;

    /* renamed from: n, reason: collision with root package name */
    public final long f9976n;

    public h0(int i10, int i11, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, int i12, int i13, int i14, long j18) {
        this.f9967a = i10;
        this.f9968b = i11;
        this.f9969c = j10;
        this.f9970d = j11;
        this.e = j12;
        this.f = j13;
        this.g = j14;
        this.h = j15;
        this.f9971i = j16;
        this.f9972j = j17;
        this.f9973k = i12;
        this.f9974l = i13;
        this.f9975m = i14;
        this.f9976n = j18;
    }

    public final void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f9967a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f9968b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((r1 / r0) * 100.0f));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f9969c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f9970d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f9973k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f9974l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f9975m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f9971i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f9972j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public final String toString() {
        return "StatsSnapshot{maxSize=" + this.f9967a + ", size=" + this.f9968b + ", cacheHits=" + this.f9969c + ", cacheMisses=" + this.f9970d + ", downloadCount=" + this.f9973k + ", totalDownloadSize=" + this.e + ", averageDownloadSize=" + this.h + ", totalOriginalBitmapSize=" + this.f + ", totalTransformedBitmapSize=" + this.g + ", averageOriginalBitmapSize=" + this.f9971i + ", averageTransformedBitmapSize=" + this.f9972j + ", originalBitmapCount=" + this.f9974l + ", transformedBitmapCount=" + this.f9975m + ", timeStamp=" + this.f9976n + '}';
    }
}
