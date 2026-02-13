package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class CanvasKt {
    public static final void withClip(Canvas canvas, Rect rect, l lVar) {
        int iSave = canvas.save();
        canvas.clipRect(rect);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withMatrix(Canvas canvas, Matrix matrix, l lVar) {
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            matrix = new Matrix();
        }
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withRotation(Canvas canvas, float f, float f10, float f11, l lVar) {
        int iSave = canvas.save();
        canvas.rotate(f, f10, f11);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f, float f10, float f11, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            f11 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.rotate(f, f10, f11);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withSave(Canvas canvas, l lVar) {
        int iSave = canvas.save();
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withScale(Canvas canvas, float f, float f10, float f11, float f12, l lVar) {
        int iSave = canvas.save();
        canvas.scale(f, f10, f11, f12);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f, float f10, float f11, float f12, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f = 1.0f;
        }
        if ((i10 & 2) != 0) {
            f10 = 1.0f;
        }
        if ((i10 & 4) != 0) {
            f11 = 0.0f;
        }
        if ((i10 & 8) != 0) {
            f12 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.scale(f, f10, f11, f12);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withSkew(Canvas canvas, float f, float f10, l lVar) {
        int iSave = canvas.save();
        canvas.skew(f, f10);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f, float f10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f10 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.skew(f, f10);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withTranslation(Canvas canvas, float f, float f10, l lVar) {
        int iSave = canvas.save();
        canvas.translate(f, f10);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f, float f10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f10 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.translate(f, f10);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withClip(Canvas canvas, RectF rectF, l lVar) {
        int iSave = canvas.save();
        canvas.clipRect(rectF);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withClip(Canvas canvas, int i10, int i11, int i12, int i13, l lVar) {
        int iSave = canvas.save();
        canvas.clipRect(i10, i11, i12, i13);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withClip(Canvas canvas, float f, float f10, float f11, float f12, l lVar) {
        int iSave = canvas.save();
        canvas.clipRect(f, f10, f11, f12);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withClip(Canvas canvas, Path path, l lVar) {
        int iSave = canvas.save();
        canvas.clipPath(path);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }
}
