package l2;

import android.util.Base64;
import android.util.JsonWriter;
import j2.g;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements j2.e, g {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10198a = true;

    /* renamed from: b, reason: collision with root package name */
    public final JsonWriter f10199b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f10200c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f10201d;
    public final j2.d e;
    public final boolean f;

    public e(Writer writer, HashMap map, HashMap map2, a aVar, boolean z9) {
        this.f10199b = new JsonWriter(writer);
        this.f10200c = map;
        this.f10201d = map2;
        this.e = aVar;
        this.f = z9;
    }

    @Override // j2.e
    public final j2.e a(j2.c cVar, Object obj) throws IOException {
        i(obj, cVar.f9909a);
        return this;
    }

    @Override // j2.g
    public final g b(String str) throws IOException {
        j();
        this.f10199b.value(str);
        return this;
    }

    @Override // j2.g
    public final g c(boolean z9) throws IOException {
        j();
        this.f10199b.value(z9);
        return this;
    }

    @Override // j2.e
    public final j2.e d(j2.c cVar, int i10) throws IOException {
        String str = cVar.f9909a;
        j();
        JsonWriter jsonWriter = this.f10199b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(i10);
        return this;
    }

    @Override // j2.e
    public final j2.e e(j2.c cVar, long j10) throws IOException {
        String str = cVar.f9909a;
        j();
        JsonWriter jsonWriter = this.f10199b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(j10);
        return this;
    }

    @Override // j2.e
    public final j2.e f(j2.c cVar, double d8) throws IOException {
        String str = cVar.f9909a;
        j();
        JsonWriter jsonWriter = this.f10199b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(d8);
        return this;
    }

    @Override // j2.e
    public final j2.e g(j2.c cVar, boolean z9) throws IOException {
        String str = cVar.f9909a;
        j();
        JsonWriter jsonWriter = this.f10199b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(z9);
        return this;
    }

    public final e h(Object obj) throws IOException {
        JsonWriter jsonWriter = this.f10199b;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        }
        int i10 = 0;
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                jsonWriter.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    h(it.next());
                }
                jsonWriter.endArray();
                return this;
            }
            if (obj instanceof Map) {
                jsonWriter.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        i(entry.getValue(), (String) key);
                    } catch (ClassCastException e) {
                        throw new j2.b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e);
                    }
                }
                jsonWriter.endObject();
                return this;
            }
            j2.d dVar = (j2.d) this.f10200c.get(obj.getClass());
            if (dVar != null) {
                jsonWriter.beginObject();
                dVar.a(obj, this);
                jsonWriter.endObject();
                return this;
            }
            j2.f fVar = (j2.f) this.f10201d.get(obj.getClass());
            if (fVar != null) {
                fVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                jsonWriter.beginObject();
                this.e.a(obj, this);
                jsonWriter.endObject();
                return this;
            }
            if (obj instanceof f) {
                int number = ((f) obj).getNumber();
                j();
                jsonWriter.value(number);
                return this;
            }
            String strName = ((Enum) obj).name();
            j();
            jsonWriter.value(strName);
            return this;
        }
        if (obj instanceof byte[]) {
            j();
            jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
            return this;
        }
        jsonWriter.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i10 < length) {
                jsonWriter.value(r7[i10]);
                i10++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i10 < length2) {
                long j10 = jArr[i10];
                j();
                jsonWriter.value(j10);
                i10++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i10 < length3) {
                jsonWriter.value(dArr[i10]);
                i10++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i10 < length4) {
                jsonWriter.value(zArr[i10]);
                i10++;
            }
        } else if (obj instanceof Number[]) {
            Number[] numberArr = (Number[]) obj;
            int length5 = numberArr.length;
            while (i10 < length5) {
                h(numberArr[i10]);
                i10++;
            }
        } else {
            Object[] objArr = (Object[]) obj;
            int length6 = objArr.length;
            while (i10 < length6) {
                h(objArr[i10]);
                i10++;
            }
        }
        jsonWriter.endArray();
        return this;
    }

    public final e i(Object obj, String str) throws IOException {
        boolean z9 = this.f;
        JsonWriter jsonWriter = this.f10199b;
        if (z9) {
            if (obj == null) {
                return this;
            }
            j();
            jsonWriter.name(str);
            h(obj);
            return this;
        }
        j();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        h(obj);
        return this;
    }

    public final void j() {
        if (this.f10198a) {
            return;
        }
        androidx.window.layout.c.g("Parent context used since this context was created. Cannot use this context anymore.");
    }
}
