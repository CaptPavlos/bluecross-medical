package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ShaderKt {
    public static final void transform(Shader shader, l lVar) {
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        lVar.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
