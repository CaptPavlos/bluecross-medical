package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.internal.g;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends i {

    /* renamed from: c, reason: collision with root package name */
    public static final j f2482c = new j() { // from class: com.google.gson.internal.bind.DefaultDateTypeAdapter.1
        @Override // com.google.gson.j
        public final i a(com.google.gson.b bVar, TypeToken typeToken) {
            if (typeToken.f2599a == Date.class) {
                return new DefaultDateTypeAdapter();
            }
            return null;
        }

        public final String toString() {
            return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final a f2483a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2484b;

    public DefaultDateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.f2484b = arrayList;
        this.f2483a = b.f2526a;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (g.f2561a >= 9) {
            arrayList.add(new SimpleDateFormat(a3.a.j("MMM d, yyyy", " ", "h:mm:ss a"), locale));
        }
    }

    @Override // com.google.gson.i
    public final Object b(i3.a aVar) throws IOException {
        Date dateB;
        if (aVar.x() == 9) {
            aVar.t();
            return null;
        }
        String strV = aVar.v();
        synchronized (this.f2484b) {
            try {
                ArrayList arrayList = this.f2484b;
                int size = arrayList.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        try {
                            dateB = g3.a.b(strV, new ParsePosition(0));
                            break;
                        } catch (ParseException e) {
                            StringBuilder sbY = a3.a.y("Failed parsing '", strV, "' as Date; at path ");
                            sbY.append(aVar.j(true));
                            throw new com.google.gson.e(sbY.toString(), e);
                        }
                    }
                    Object obj = arrayList.get(i10);
                    i10++;
                    DateFormat dateFormat = (DateFormat) obj;
                    TimeZone timeZone = dateFormat.getTimeZone();
                    try {
                        try {
                            dateB = dateFormat.parse(strV);
                            break;
                        } finally {
                            dateFormat.setTimeZone(timeZone);
                        }
                    } catch (ParseException unused) {
                        dateFormat.setTimeZone(timeZone);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f2483a.getClass();
        return dateB;
    }

    @Override // com.google.gson.i
    public final void c(i3.b bVar, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            bVar.k();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f2484b.get(0);
        synchronized (this.f2484b) {
            str = dateFormat.format(date);
        }
        bVar.s(str);
    }

    public final String toString() {
        DateFormat dateFormat = (DateFormat) this.f2484b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
