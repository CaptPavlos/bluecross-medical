package s5;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.leanback.app.BackgroundManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.uptodown.R;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import h5.u0;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12626a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TvAppDetailFragment f12627b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(TvAppDetailFragment tvAppDetailFragment, w6.c cVar, int i10) {
        super(2, cVar);
        this.f12626a = i10;
        this.f12627b = tvAppDetailFragment;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12626a) {
            case 0:
                return new f(this.f12627b, cVar, 0);
            case 1:
                return new f(this.f12627b, cVar, 1);
            default:
                return new f(this.f12627b, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12626a) {
            case 0:
                f fVar = (f) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                fVar.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                return ((f) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            default:
                f fVar2 = (f) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                fVar2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f12626a) {
            case 0:
                s6.a.e(obj);
                TvAppDetailFragment tvAppDetailFragment = this.f12627b;
                if (tvAppDetailFragment.getContext() != null) {
                    q5.b bVar = tvAppDetailFragment.f6699k;
                    bVar.getClass();
                    Context contextRequireContext = tvAppDetailFragment.requireContext();
                    contextRequireContext.getClass();
                    h5.h hVar = tvAppDetailFragment.f6693a;
                    u5.b bVar2 = bVar.f12259b;
                    if (bVar2 != null) {
                        LinearLayout linearLayout = bVar2.h;
                        if ((hVar != null ? hVar.O : null) != null && linearLayout != null) {
                            if (linearLayout.getChildCount() > 0) {
                                linearLayout.removeAllViews();
                            }
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                            layoutParams.setMargins(12, 12, 12, 12);
                            ArrayList arrayList = hVar.O;
                            arrayList.getClass();
                            int size = arrayList.size();
                            for (int i10 = 0; i10 < size; i10++) {
                                t5.a aVar = new t5.a(contextRequireContext);
                                j4.y yVarD = j4.y.d();
                                ArrayList arrayList2 = hVar.O;
                                arrayList2.getClass();
                                yVarD.e(((u0) arrayList2.get(i10)).a()).e(aVar, null);
                                aVar.setPadding(4, 4, 4, 4);
                                aVar.setLayoutParams(layoutParams);
                                aVar.setFocusable(true);
                                aVar.setTag(Integer.valueOf(i10));
                                aVar.setOnClickListener(new e5.s(hVar, 25));
                                aVar.setOnFocusChangeListener(new u5.a());
                                linearLayout.addView(aVar);
                            }
                        }
                    }
                }
                tvAppDetailFragment.u();
                return s6.w.f12711a;
            case 1:
                s6.w wVar = s6.w.f12711a;
                TvAppDetailFragment tvAppDetailFragment2 = this.f12627b;
                s6.a.e(obj);
                try {
                    h5.h hVar2 = tvAppDetailFragment2.f6693a;
                    if ((hVar2 != null ? hVar2.e() : null) != null) {
                        BackgroundManager backgroundManager = tvAppDetailFragment2.e;
                        if (backgroundManager != null) {
                            j4.y yVarD2 = j4.y.d();
                            h5.h hVar3 = tvAppDetailFragment2.f6693a;
                            hVar3.getClass();
                            backgroundManager.setBitmap(yVarD2.e(hVar3.e()).c());
                            return wVar;
                        }
                    } else {
                        Drawable drawable = ContextCompat.getDrawable(tvAppDetailFragment2.requireContext(), R.drawable.feature_tv);
                        BackgroundManager backgroundManager2 = tvAppDetailFragment2.e;
                        if (backgroundManager2 != null) {
                            backgroundManager2.setDrawable(drawable);
                            return wVar;
                        }
                    }
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return wVar;
                }
            default:
                s6.a.e(obj);
                this.f12627b.startEntranceTransition();
                return s6.w.f12711a;
        }
    }
}
