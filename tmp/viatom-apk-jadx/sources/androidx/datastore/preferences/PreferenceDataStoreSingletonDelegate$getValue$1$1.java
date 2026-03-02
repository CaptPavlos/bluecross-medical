package androidx.datastore.preferences;

import android.content.Context;
import g7.a;
import java.io.File;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PreferenceDataStoreSingletonDelegate$getValue$1$1 extends m implements a {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ PreferenceDataStoreSingletonDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferenceDataStoreSingletonDelegate$getValue$1$1(Context context, PreferenceDataStoreSingletonDelegate preferenceDataStoreSingletonDelegate) {
        super(0);
        this.$applicationContext = context;
        this.this$0 = preferenceDataStoreSingletonDelegate;
    }

    @Override // g7.a
    public final File invoke() {
        Context context = this.$applicationContext;
        context.getClass();
        return PreferenceDataStoreFile.preferencesDataStoreFile(context, this.this$0.name);
    }
}
