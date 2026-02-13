package a3;

import android.content.Context;
import androidx.datastore.DataStoreFile;
import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class r implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f156a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f157b;

    public /* synthetic */ r(Context context, int i10) {
        this.f156a = i10;
        this.f157b = context;
    }

    @Override // g7.a
    public final Object invoke() throws IOException {
        switch (this.f156a) {
            case 0:
                File fileDataStoreFile = DataStoreFile.dataStoreFile(this.f157b, "firebaseSessions/sessionConfigsDataStore.data");
                t.a(fileDataStoreFile);
                return fileDataStoreFile;
            default:
                File fileDataStoreFile2 = DataStoreFile.dataStoreFile(this.f157b, "firebaseSessions/sessionDataStore.data");
                t.a(fileDataStoreFile2);
                return fileDataStoreFile2;
        }
    }
}
