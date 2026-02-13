package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;
import kotlin.jvm.internal.l;
import o7.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Room {
    public static final Room INSTANCE = new Room();
    public static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    private Room() {
    }

    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context context, Class<T> cls, String str) {
        context.getClass();
        cls.getClass();
        if (str == null || m.l0(str)) {
            com.google.gson.internal.a.n("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
            return null;
        }
        if (!l.a(str, ":memory:")) {
            return new RoomDatabase.Builder<>(context, cls, str);
        }
        com.google.gson.internal.a.n("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        return null;
    }

    public static RoomDatabase.Builder databaseBuilder$default(Room room, Context context, String str, g7.a aVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            l.h();
            throw null;
        }
        context.getClass();
        str.getClass();
        aVar.getClass();
        if (m.l0(str)) {
            throw new IllegalArgumentException("Cannot build a database with empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
        }
        if (str.equals(":memory:")) {
            throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
        }
        l.h();
        throw null;
    }

    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context context, Class<T> cls) {
        context.getClass();
        cls.getClass();
        return new RoomDatabase.Builder<>(context, cls, null);
    }

    public static RoomDatabase.Builder inMemoryDatabaseBuilder$default(Room room, Context context, g7.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l.h();
            throw null;
        }
        context.getClass();
        aVar.getClass();
        l.h();
        throw null;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.room.Room$databaseBuilder$3, reason: invalid class name */
    public static final class AnonymousClass3 implements g7.a {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            l.h();
            throw null;
        }

        @Override // g7.a
        public final RoomDatabase invoke() {
            l.h();
            throw null;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.room.Room$inMemoryDatabaseBuilder$1, reason: invalid class name */
    public static final class AnonymousClass1 implements g7.a {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            l.h();
            throw null;
        }

        @Override // g7.a
        public final RoomDatabase invoke() {
            l.h();
            throw null;
        }
    }

    public final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context context, g7.a aVar) {
        context.getClass();
        aVar.getClass();
        l.h();
        throw null;
    }

    public final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context context, String str, g7.a aVar) {
        context.getClass();
        str.getClass();
        aVar.getClass();
        if (!m.l0(str)) {
            if (str.equals(":memory:")) {
                throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
            }
            l.h();
            throw null;
        }
        throw new IllegalArgumentException("Cannot build a database with empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
    }
}
