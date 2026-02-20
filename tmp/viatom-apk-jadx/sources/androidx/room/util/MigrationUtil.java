package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.room.DatabaseConfiguration;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import s6.i;
import t6.t;
import t6.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class MigrationUtil {
    public static final boolean contains(RoomDatabase.MigrationContainer migrationContainer, int i10, int i11) {
        migrationContainer.getClass();
        Map<Integer, Map<Integer, Migration>> migrations = migrationContainer.getMigrations();
        if (!migrations.containsKey(Integer.valueOf(i10))) {
            return false;
        }
        Map<Integer, Migration> map = migrations.get(Integer.valueOf(i10));
        if (map == null) {
            map = u.f12809a;
        }
        return map.containsKey(Integer.valueOf(i11));
    }

    public static final List<Migration> findMigrationPath(RoomDatabase.MigrationContainer migrationContainer, int i10, int i11) {
        migrationContainer.getClass();
        if (i10 == i11) {
            return t.f12808a;
        }
        return findUpMigrationPath(migrationContainer, new ArrayList(), i11 > i10, i10, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final List<Migration> findUpMigrationPath(RoomDatabase.MigrationContainer migrationContainer, List<Migration> list, boolean z9, int i10, int i11) {
        int iIntValue;
        boolean z10;
        while (true) {
            if (z9) {
                if (i10 >= i11) {
                    return list;
                }
            } else if (i10 <= i11) {
                return list;
            }
            i sortedDescendingNodes$room_runtime_release = z9 ? migrationContainer.getSortedDescendingNodes$room_runtime_release(i10) : migrationContainer.getSortedNodes$room_runtime_release(i10);
            if (sortedDescendingNodes$room_runtime_release == null) {
                return null;
            }
            Map map = (Map) sortedDescendingNodes$room_runtime_release.f12693a;
            Iterator it = ((Iterable) sortedDescendingNodes$room_runtime_release.f12694b).iterator();
            while (it.hasNext()) {
                iIntValue = ((Number) it.next()).intValue();
                if (!z9) {
                    if (i11 <= iIntValue && iIntValue < i10) {
                        Object obj = map.get(Integer.valueOf(iIntValue));
                        obj.getClass();
                        list.add(obj);
                        z10 = true;
                        break;
                    }
                } else if (i10 + 1 <= iIntValue && iIntValue <= i11) {
                    Object obj2 = map.get(Integer.valueOf(iIntValue));
                    obj2.getClass();
                    list.add(obj2);
                    z10 = true;
                    break;
                }
            }
            iIntValue = i10;
            z10 = false;
            if (!z10) {
                return null;
            }
            i10 = iIntValue;
        }
    }

    public static final boolean isMigrationRequired(DatabaseConfiguration databaseConfiguration, int i10, int i11) {
        databaseConfiguration.getClass();
        if (i10 > i11 && databaseConfiguration.allowDestructiveMigrationOnDowngrade) {
            return false;
        }
        Set<Integer> migrationNotRequiredFrom$room_runtime_release = databaseConfiguration.getMigrationNotRequiredFrom$room_runtime_release();
        return databaseConfiguration.requireMigration && (migrationNotRequiredFrom$room_runtime_release == null || !migrationNotRequiredFrom$room_runtime_release.contains(Integer.valueOf(i10)));
    }
}
