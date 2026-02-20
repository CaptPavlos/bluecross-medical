package com.google.gson.internal.sql;

import com.google.gson.e;
import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class SqlTimeTypeAdapter extends i {

    /* renamed from: b, reason: collision with root package name */
    public static final j f2590b = new j() { // from class: com.google.gson.internal.sql.SqlTimeTypeAdapter.1
        @Override // com.google.gson.j
        public final i a(com.google.gson.b bVar, TypeToken typeToken) {
            if (typeToken.f2599a == Time.class) {
                return new SqlTimeTypeAdapter(0);
            }
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f2591a;

    private SqlTimeTypeAdapter() {
        this.f2591a = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // com.google.gson.i
    public final Object b(i3.a aVar) throws IOException {
        Time time;
        if (aVar.x() == 9) {
            aVar.t();
            return null;
        }
        String strV = aVar.v();
        synchronized (this) {
            TimeZone timeZone = this.f2591a.getTimeZone();
            try {
                try {
                    time = new Time(this.f2591a.parse(strV).getTime());
                } catch (ParseException e) {
                    throw new e("Failed parsing '" + strV + "' as SQL Time; at path " + aVar.j(true), e);
                }
            } finally {
                this.f2591a.setTimeZone(timeZone);
            }
        }
        return time;
    }

    @Override // com.google.gson.i
    public final void c(i3.b bVar, Object obj) throws IOException {
        String str;
        Time time = (Time) obj;
        if (time == null) {
            bVar.k();
            return;
        }
        synchronized (this) {
            str = this.f2591a.format((Date) time);
        }
        bVar.s(str);
    }

    public /* synthetic */ SqlTimeTypeAdapter(int i10) {
        this();
    }
}
