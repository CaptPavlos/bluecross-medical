package a6;

import a3.x;
import android.content.Context;
import androidx.datastore.preferences.core.MutablePreferences;
import c5.b0;
import com.uptodown.activities.AppFilesActivity;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.ListsActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import e5.b2;
import e5.h1;
import e5.t1;
import h5.e1;
import h5.p0;
import java.io.IOException;
import java.util.ArrayList;
import l4.n5;
import l4.w;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f263a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f264b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f265c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(g7.l lVar, w6.c cVar) {
        super(2, cVar);
        this.f263a = 17;
        this.f265c = lVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f263a) {
            case 0:
                return new j((Context) this.f264b, (g5.s) this.f265c, cVar, 0);
            case 1:
                return new j((x) this.f264b, (ArrayList) this.f265c, cVar, 1);
            case 2:
                return new j((w2.r) this.f264b, (kotlin.jvm.internal.x) this.f265c, cVar, 2);
            case 3:
                return new j((e0.n) this.f264b, (ArrayList) this.f265c, cVar, 3);
            case 4:
                return new j((c1.l) this.f264b, (h5.h) this.f265c, cVar, 4);
            case 5:
                return new j((c1.l) this.f264b, (p0) this.f265c, cVar, 5);
            case 6:
                return new j((a4.f) this.f264b, (kotlin.jvm.internal.v) this.f265c, cVar, 6);
            case 7:
                return new j((g5.q) this.f264b, (e1) this.f265c, cVar, 7);
            case 8:
                return new j((n5) this.f264b, (ArrayList) this.f265c, cVar, 8);
            case 9:
                return new j((n5) this.f264b, (ArrayList) this.f265c, cVar, 9);
            case 10:
                return new j((String) this.f264b, (e5.d) this.f265c, cVar, 10);
            case 11:
                return new j((e5.d) this.f264b, (h5.h) this.f265c, cVar, 11);
            case 12:
                return new j((String) this.f264b, (h1) this.f265c, cVar, 12);
            case 13:
                return new j((String) this.f264b, (t1) this.f265c, cVar, 13);
            case 14:
                return new j((b2) this.f264b, (h5.h) this.f265c, cVar, 14);
            case 15:
                return new j((b2) this.f264b, (String) this.f265c, cVar, 15);
            case 16:
                return new j((String) this.f264b, (String) this.f265c, cVar, 16);
            case 17:
                j jVar = new j((g7.l) this.f265c, cVar);
                jVar.f264b = obj;
                return jVar;
            case 18:
                return new j((b0) this.f264b, (String) this.f265c, cVar, 18);
            case 19:
                return new j((b0) this.f264b, (JSONException) this.f265c, cVar, 19);
            case 20:
                return new j((AppFilesActivity) this.f264b, (ArrayList) this.f265c, cVar, 20);
            case 21:
                return new j((w) this.f264b, (h5.q) this.f265c, cVar, 21);
            case 22:
                return new j(this.f265c, (Context) this.f264b, cVar, 22);
            case 23:
                return new j((FreeUpSpaceActivity) this.f264b, (v5.m) this.f265c, cVar, 23);
            case 24:
                return new j((ListsActivity) this.f264b, (String) this.f265c, cVar, 24);
            case 25:
                return new j((MainActivity) this.f264b, (kotlin.jvm.internal.x) this.f265c, cVar, 25);
            case 26:
                return new j((MainActivity) this.f264b, (ArrayList) this.f265c, cVar, 26);
            case 27:
                return new j((MyApps) this.f264b, (v5.m) this.f265c, cVar, 27);
            case 28:
                return new j((MyApps) this.f264b, (ArrayList) this.f265c, cVar, 28);
            default:
                return new j(this.f265c, (Context) this.f264b, cVar, 29);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws JSONException, IOException {
        switch (this.f263a) {
            case 0:
                j jVar = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar = s6.w.f12711a;
                jVar.invokeSuspend(wVar);
                return wVar;
            case 1:
                j jVar2 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar2 = s6.w.f12711a;
                jVar2.invokeSuspend(wVar2);
                return wVar2;
            case 2:
                j jVar3 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar3 = s6.w.f12711a;
                jVar3.invokeSuspend(wVar3);
                return wVar3;
            case 3:
                j jVar4 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar4 = s6.w.f12711a;
                jVar4.invokeSuspend(wVar4);
                return wVar4;
            case 4:
                return ((j) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
            case 5:
                return ((j) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
            case 6:
                j jVar5 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar5 = s6.w.f12711a;
                jVar5.invokeSuspend(wVar5);
                return wVar5;
            case 7:
                j jVar6 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar6 = s6.w.f12711a;
                jVar6.invokeSuspend(wVar6);
                return wVar6;
            case 8:
                j jVar7 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar7 = s6.w.f12711a;
                jVar7.invokeSuspend(wVar7);
                return wVar7;
            case 9:
                j jVar8 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar8 = s6.w.f12711a;
                jVar8.invokeSuspend(wVar8);
                return wVar8;
            case 10:
                j jVar9 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar9 = s6.w.f12711a;
                jVar9.invokeSuspend(wVar9);
                return wVar9;
            case 11:
                return ((j) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
            case 12:
                j jVar10 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar10 = s6.w.f12711a;
                jVar10.invokeSuspend(wVar10);
                return wVar10;
            case 13:
                j jVar11 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar11 = s6.w.f12711a;
                jVar11.invokeSuspend(wVar11);
                return wVar11;
            case 14:
                j jVar12 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar12 = s6.w.f12711a;
                jVar12.invokeSuspend(wVar12);
                return wVar12;
            case 15:
                j jVar13 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar13 = s6.w.f12711a;
                jVar13.invokeSuspend(wVar13);
                return wVar13;
            case 16:
                return new j((String) this.f264b, (String) this.f265c, (w6.c) obj2, 16).invokeSuspend(s6.w.f12711a);
            case 17:
                j jVar14 = (j) create((MutablePreferences) obj, (w6.c) obj2);
                s6.w wVar14 = s6.w.f12711a;
                jVar14.invokeSuspend(wVar14);
                return wVar14;
            case 18:
                j jVar15 = new j((b0) this.f264b, (String) this.f265c, (w6.c) obj2, 18);
                s6.w wVar15 = s6.w.f12711a;
                jVar15.invokeSuspend(wVar15);
                return wVar15;
            case 19:
                j jVar16 = new j((b0) this.f264b, (JSONException) this.f265c, (w6.c) obj2, 19);
                s6.w wVar16 = s6.w.f12711a;
                jVar16.invokeSuspend(wVar16);
                return wVar16;
            case 20:
                j jVar17 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar17 = s6.w.f12711a;
                jVar17.invokeSuspend(wVar17);
                return wVar17;
            case 21:
                j jVar18 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar18 = s6.w.f12711a;
                jVar18.invokeSuspend(wVar18);
                return wVar18;
            case 22:
                j jVar19 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar19 = s6.w.f12711a;
                jVar19.invokeSuspend(wVar19);
                return wVar19;
            case 23:
                j jVar20 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar20 = s6.w.f12711a;
                jVar20.invokeSuspend(wVar20);
                return wVar20;
            case 24:
                j jVar21 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar21 = s6.w.f12711a;
                jVar21.invokeSuspend(wVar21);
                return wVar21;
            case 25:
                j jVar22 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar22 = s6.w.f12711a;
                jVar22.invokeSuspend(wVar22);
                return wVar22;
            case 26:
                j jVar23 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar23 = s6.w.f12711a;
                jVar23.invokeSuspend(wVar23);
                return wVar23;
            case 27:
                j jVar24 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar24 = s6.w.f12711a;
                jVar24.invokeSuspend(wVar24);
                return wVar24;
            case 28:
                j jVar25 = (j) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar25 = s6.w.f12711a;
                jVar25.invokeSuspend(wVar25);
                return wVar25;
            default:
                return ((j) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:317:0x08a0  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x08e3  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x08e6 A[SYNTHETIC] */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r28) throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 2796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.j.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(Object obj, Context context, w6.c cVar, int i10) {
        super(2, cVar);
        this.f263a = i10;
        this.f265c = obj;
        this.f264b = context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(Object obj, Object obj2, w6.c cVar, int i10) {
        super(2, cVar);
        this.f263a = i10;
        this.f264b = obj;
        this.f265c = obj2;
    }
}
