package com.google.gson.internal.sql;

import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
class SqlTimestampTypeAdapter extends i {

    /* renamed from: b, reason: collision with root package name */
    public static final j f2592b = new j() { // from class: com.google.gson.internal.sql.SqlTimestampTypeAdapter.1
        @Override // com.google.gson.j
        public final i a(com.google.gson.b bVar, TypeToken typeToken) {
            if (typeToken.f2599a != Timestamp.class) {
                return null;
            }
            bVar.getClass();
            return new SqlTimestampTypeAdapter(bVar.c(new TypeToken(Date.class)));
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final i f2593a;

    public SqlTimestampTypeAdapter(i iVar) {
        this.f2593a = iVar;
    }

    @Override // com.google.gson.i
    public final Object b(i3.a aVar) {
        Date date = (Date) this.f2593a.b(aVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // com.google.gson.i
    public final void c(i3.b bVar, Object obj) {
        this.f2593a.c(bVar, (Timestamp) obj);
    }
}
