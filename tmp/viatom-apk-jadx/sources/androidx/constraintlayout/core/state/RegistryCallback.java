package androidx.constraintlayout.core.state;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface RegistryCallback {
    String currentLayoutInformation();

    String currentMotionScene();

    long getLastModified();

    void onDimensions(int i10, int i11);

    void onNewMotionScene(String str);

    void onProgress(float f);

    void setDrawDebug(int i10);

    void setLayoutInformationMode(int i10);
}
