package com.google.gson.internal.sql;

import com.google.gson.e;
import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class SqlDateTypeAdapter extends i {

    /* renamed from: b, reason: collision with root package name */
    public static final j f2588b = new j() { // from class: com.google.gson.internal.sql.SqlDateTypeAdapter.1
        @Override // com.google.gson.j
        public final i a(com.google.gson.b bVar, TypeToken typeToken) {
            if (typeToken.f2599a == Date.class) {
                return new SqlDateTypeAdapter(0);
            }
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f2589a;

    private SqlDateTypeAdapter() {
        this.f2589a = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // com.google.gson.i
    public final Object b(i3.a aVar) throws IOException {
        Date date;
        if (aVar.x() == 9) {
            aVar.t();
            return null;
        }
        String strV = aVar.v();
        synchronized (this) {
            TimeZone timeZone = this.f2589a.getTimeZone();
            try {
                try {
                    date = new Date(this.f2589a.parse(strV).getTime());
                } catch (ParseException e) {
                    throw new e("Failed parsing '" + strV + "' as SQL Date; at path " + aVar.j(true), e);
                }
            } finally {
                this.f2589a.setTimeZone(timeZone);
            }
        }
        return date;
    }

    @Override // com.google.gson.i
    public final void c(i3.b bVar, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            bVar.k();
            return;
        }
        synchronized (this) {
            str = this.f2589a.format((java.util.Date) date);
        }
        bVar.s(str);
    }

    public /* synthetic */ SqlDateTypeAdapter(int i10) {
        this();
    }
}
