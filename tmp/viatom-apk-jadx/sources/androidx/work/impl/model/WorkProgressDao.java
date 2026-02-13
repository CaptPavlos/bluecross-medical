package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.work.Data;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Dao
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public interface WorkProgressDao {
    @Query("DELETE from WorkProgress where work_spec_id=:workSpecId")
    void delete(String str);

    @Query("DELETE FROM WorkProgress")
    void deleteAll();

    @Query("SELECT progress FROM WorkProgress WHERE work_spec_id=:workSpecId")
    Data getProgressForWorkSpecId(String str);

    @Insert(onConflict = 1)
    void insert(WorkProgress workProgress);
}
