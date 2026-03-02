package d7;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements Iterator, h7.a {

    /* renamed from: a, reason: collision with root package name */
    public String f7456a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7457b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f7458c;

    public a(b bVar) {
        this.f7458c = bVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() throws IOException {
        if (this.f7456a == null && !this.f7457b) {
            String line = ((BufferedReader) this.f7458c.f7460b).readLine();
            this.f7456a = line;
            if (line == null) {
                this.f7457b = true;
            }
        }
        return this.f7456a != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            com.google.gson.internal.a.b();
            return null;
        }
        String str = this.f7456a;
        this.f7456a = null;
        str.getClass();
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
