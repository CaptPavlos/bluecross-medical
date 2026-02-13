package androidx.work.impl;

import androidx.work.Logger;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WorkDatabasePathHelperKt {
    private static final String[] DATABASE_EXTRA_FILES;
    private static final String TAG;
    public static final String WORK_DATABASE_NAME = "androidx.work.workdb";

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("WrkDbPathHelper");
        strTagWithPrefix.getClass();
        TAG = strTagWithPrefix;
        DATABASE_EXTRA_FILES = new String[]{"-journal", "-shm", "-wal"};
    }
}
