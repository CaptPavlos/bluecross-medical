package com.mbridge.msdk.newreward.function.h;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.mbridge.msdk.MBridgeConstans;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.h.a$a, reason: collision with other inner class name */
    public interface InterfaceC0048a {
        void blurFailCallBack();

        void blurSuccessCallBack(Bitmap bitmap);
    }

    public static void a(final Bitmap bitmap, final InterfaceC0048a interfaceC0048a) {
        try {
            com.mbridge.msdk.foundation.same.f.a.d().execute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.h.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (interfaceC0048a == null) {
                        return;
                    }
                    try {
                        Bitmap bitmapB = a.b(bitmap);
                        if (bitmapB == null || bitmapB.isRecycled()) {
                            interfaceC0048a.blurFailCallBack();
                        } else {
                            interfaceC0048a.blurSuccessCallBack(bitmapB);
                        }
                    } catch (Exception unused) {
                        interfaceC0048a.blurFailCallBack();
                    }
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(17)
    public static Bitmap b(Bitmap bitmap) {
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
            RenderScript renderScriptCreate = RenderScript.create(com.mbridge.msdk.foundation.controller.c.m().c());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap);
            Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
            scriptIntrinsicBlurCreate.setRadius(25.0f);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
            renderScriptCreate.destroy();
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }
}
