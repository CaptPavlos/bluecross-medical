package com.uptodown.workers;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import h5.p;
import h5.p0;
import h5.y0;
import java.util.ArrayList;
import java.util.Iterator;
import o4.b;
import o7.u;
import r0.f;
import t1.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class TrackingWorker extends CoroutineWorker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6751a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6752b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6753c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6754d;
    public final c e;
    public boolean f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f6751a = context;
        this.f6752b = workerParameters.getInputData().getBoolean("isCompressed", true);
        this.e = new c(context, 4);
        Activity activity = b.g;
        this.f6751a = f.h(context);
        for (String str : getTags()) {
            if (str.equals("TrackingWorkerPeriodic") || str.equals("TrackingWorkerSingle")) {
                this.f6754d = str;
            }
        }
    }

    public static String c(String str) {
        return u.Z(str, "TrackingWorkerPeriodic", true) ? "periodic" : "oneTime";
    }

    public final void b(p0 p0Var) {
        int i10 = p0Var.f8697b;
        if (i10 == 401) {
            this.f6753c = true;
        } else if (i10 == 0) {
            this.f6753c = true;
        }
    }

    public final void d(y0 y0Var) {
        ArrayList arrayList = y0Var.f8799j;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = y0Var.f8799j;
        arrayList2.getClass();
        ArrayList arrayListC = p.c(arrayList2, this.f6751a);
        if (arrayListC.isEmpty()) {
            return;
        }
        Iterator it = arrayListC.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            Bundle bundle = new Bundle();
            bundle.putInt("update", 1);
            bundle.putString("feature", (String) next);
            this.e.e(bundle, "required_features_not_supported");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:11)(2:12|13))(2:14|(2:16|17)(2:18|(4:20|(2:22|(2:28|29))(2:30|(2:32|(2:38|39)))|40|(9:53|87|54|(3:56|57|(5:60|85|61|(1:63)(1:65)|(2:67|(1:69))))(0)|74|89|75|79|80)(2:51|52))(2:81|82)))|70|(2:72|73)|74|89|75|79|80) */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0159, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x015a, code lost:
    
        r12.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doWork(w6.c r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.TrackingWorker.doWork(w6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x026d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(org.json.JSONObject r17) throws org.json.JSONException, android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 751
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.TrackingWorker.e(org.json.JSONObject):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x025a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList f(org.json.JSONArray r20, v5.g r21, android.content.Context r22, boolean r23) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 609
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.TrackingWorker.f(org.json.JSONArray, v5.g, android.content.Context, boolean):java.util.ArrayList");
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0287 A[Catch: Exception -> 0x0059, TryCatch #0 {Exception -> 0x0059, blocks: (B:20:0x0055, B:27:0x0066, B:172:0x03f0, B:30:0x0070, B:166:0x03be, B:168:0x03d6, B:33:0x007a, B:158:0x0392, B:160:0x039c, B:162:0x03a4, B:36:0x0088, B:84:0x01e4, B:85:0x01f4, B:87:0x01fa, B:89:0x0207, B:91:0x020b, B:92:0x020f, B:94:0x0218, B:96:0x023e, B:99:0x024f, B:101:0x0253, B:104:0x025a, B:106:0x026b, B:108:0x0271, B:110:0x0279, B:115:0x0287, B:118:0x028f, B:127:0x02c8, B:129:0x02d8, B:131:0x030c, B:133:0x0312, B:135:0x0316, B:138:0x031d, B:140:0x032e, B:142:0x0334, B:150:0x035e, B:152:0x0364, B:144:0x033b, B:146:0x0341, B:148:0x0354, B:149:0x0357, B:179:0x041f, B:130:0x02f3, B:120:0x0295, B:122:0x02b2, B:124:0x02b6, B:181:0x0423, B:183:0x0429, B:185:0x0439, B:111:0x027e, B:187:0x043d, B:189:0x0441, B:190:0x0446, B:191:0x0447, B:193:0x045f, B:195:0x0468, B:196:0x046c, B:39:0x00a2, B:41:0x00b3, B:59:0x0157, B:61:0x0177, B:63:0x0182, B:65:0x0192, B:67:0x0196, B:70:0x019d, B:72:0x01ae, B:74:0x01b8, B:80:0x01cd, B:75:0x01c2, B:62:0x017c, B:79:0x01ca, B:44:0x00fb, B:46:0x011f, B:48:0x0125, B:50:0x012c, B:51:0x0136, B:52:0x0144, B:54:0x014a, B:56:0x0151, B:197:0x046d, B:199:0x0471, B:200:0x0476), top: B:203:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02c8 A[Catch: Exception -> 0x0059, TryCatch #0 {Exception -> 0x0059, blocks: (B:20:0x0055, B:27:0x0066, B:172:0x03f0, B:30:0x0070, B:166:0x03be, B:168:0x03d6, B:33:0x007a, B:158:0x0392, B:160:0x039c, B:162:0x03a4, B:36:0x0088, B:84:0x01e4, B:85:0x01f4, B:87:0x01fa, B:89:0x0207, B:91:0x020b, B:92:0x020f, B:94:0x0218, B:96:0x023e, B:99:0x024f, B:101:0x0253, B:104:0x025a, B:106:0x026b, B:108:0x0271, B:110:0x0279, B:115:0x0287, B:118:0x028f, B:127:0x02c8, B:129:0x02d8, B:131:0x030c, B:133:0x0312, B:135:0x0316, B:138:0x031d, B:140:0x032e, B:142:0x0334, B:150:0x035e, B:152:0x0364, B:144:0x033b, B:146:0x0341, B:148:0x0354, B:149:0x0357, B:179:0x041f, B:130:0x02f3, B:120:0x0295, B:122:0x02b2, B:124:0x02b6, B:181:0x0423, B:183:0x0429, B:185:0x0439, B:111:0x027e, B:187:0x043d, B:189:0x0441, B:190:0x0446, B:191:0x0447, B:193:0x045f, B:195:0x0468, B:196:0x046c, B:39:0x00a2, B:41:0x00b3, B:59:0x0157, B:61:0x0177, B:63:0x0182, B:65:0x0192, B:67:0x0196, B:70:0x019d, B:72:0x01ae, B:74:0x01b8, B:80:0x01cd, B:75:0x01c2, B:62:0x017c, B:79:0x01ca, B:44:0x00fb, B:46:0x011f, B:48:0x0125, B:50:0x012c, B:51:0x0136, B:52:0x0144, B:54:0x014a, B:56:0x0151, B:197:0x046d, B:199:0x0471, B:200:0x0476), top: B:203:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0392 A[Catch: Exception -> 0x0059, PHI: r2 r3 r5 r6
      0x0392: PHI (r2v22 int) = (r2v15 int), (r2v15 int), (r2v31 int) binds: [B:151:0x0362, B:156:0x038e, B:34:0x007d] A[DONT_GENERATE, DONT_INLINE]
      0x0392: PHI (r3v21 h5.p) = (r3v18 h5.p), (r3v18 h5.p), (r3v28 h5.p) binds: [B:151:0x0362, B:156:0x038e, B:34:0x007d] A[DONT_GENERATE, DONT_INLINE]
      0x0392: PHI (r5v5 x6.a) = (r5v4 x6.a), (r5v4 x6.a), (r5v13 x6.a) binds: [B:151:0x0362, B:156:0x038e, B:34:0x007d] A[DONT_GENERATE, DONT_INLINE]
      0x0392: PHI (r6v38 java.lang.String) = (r6v28 java.lang.String), (r6v28 java.lang.String), (r6v0 java.lang.String) binds: [B:151:0x0362, B:156:0x038e, B:34:0x007d] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x0059, blocks: (B:20:0x0055, B:27:0x0066, B:172:0x03f0, B:30:0x0070, B:166:0x03be, B:168:0x03d6, B:33:0x007a, B:158:0x0392, B:160:0x039c, B:162:0x03a4, B:36:0x0088, B:84:0x01e4, B:85:0x01f4, B:87:0x01fa, B:89:0x0207, B:91:0x020b, B:92:0x020f, B:94:0x0218, B:96:0x023e, B:99:0x024f, B:101:0x0253, B:104:0x025a, B:106:0x026b, B:108:0x0271, B:110:0x0279, B:115:0x0287, B:118:0x028f, B:127:0x02c8, B:129:0x02d8, B:131:0x030c, B:133:0x0312, B:135:0x0316, B:138:0x031d, B:140:0x032e, B:142:0x0334, B:150:0x035e, B:152:0x0364, B:144:0x033b, B:146:0x0341, B:148:0x0354, B:149:0x0357, B:179:0x041f, B:130:0x02f3, B:120:0x0295, B:122:0x02b2, B:124:0x02b6, B:181:0x0423, B:183:0x0429, B:185:0x0439, B:111:0x027e, B:187:0x043d, B:189:0x0441, B:190:0x0446, B:191:0x0447, B:193:0x045f, B:195:0x0468, B:196:0x046c, B:39:0x00a2, B:41:0x00b3, B:59:0x0157, B:61:0x0177, B:63:0x0182, B:65:0x0192, B:67:0x0196, B:70:0x019d, B:72:0x01ae, B:74:0x01b8, B:80:0x01cd, B:75:0x01c2, B:62:0x017c, B:79:0x01ca, B:44:0x00fb, B:46:0x011f, B:48:0x0125, B:50:0x012c, B:51:0x0136, B:52:0x0144, B:54:0x014a, B:56:0x0151, B:197:0x046d, B:199:0x0471, B:200:0x0476), top: B:203:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x039c A[Catch: Exception -> 0x0059, TryCatch #0 {Exception -> 0x0059, blocks: (B:20:0x0055, B:27:0x0066, B:172:0x03f0, B:30:0x0070, B:166:0x03be, B:168:0x03d6, B:33:0x007a, B:158:0x0392, B:160:0x039c, B:162:0x03a4, B:36:0x0088, B:84:0x01e4, B:85:0x01f4, B:87:0x01fa, B:89:0x0207, B:91:0x020b, B:92:0x020f, B:94:0x0218, B:96:0x023e, B:99:0x024f, B:101:0x0253, B:104:0x025a, B:106:0x026b, B:108:0x0271, B:110:0x0279, B:115:0x0287, B:118:0x028f, B:127:0x02c8, B:129:0x02d8, B:131:0x030c, B:133:0x0312, B:135:0x0316, B:138:0x031d, B:140:0x032e, B:142:0x0334, B:150:0x035e, B:152:0x0364, B:144:0x033b, B:146:0x0341, B:148:0x0354, B:149:0x0357, B:179:0x041f, B:130:0x02f3, B:120:0x0295, B:122:0x02b2, B:124:0x02b6, B:181:0x0423, B:183:0x0429, B:185:0x0439, B:111:0x027e, B:187:0x043d, B:189:0x0441, B:190:0x0446, B:191:0x0447, B:193:0x045f, B:195:0x0468, B:196:0x046c, B:39:0x00a2, B:41:0x00b3, B:59:0x0157, B:61:0x0177, B:63:0x0182, B:65:0x0192, B:67:0x0196, B:70:0x019d, B:72:0x01ae, B:74:0x01b8, B:80:0x01cd, B:75:0x01c2, B:62:0x017c, B:79:0x01ca, B:44:0x00fb, B:46:0x011f, B:48:0x0125, B:50:0x012c, B:51:0x0136, B:52:0x0144, B:54:0x014a, B:56:0x0151, B:197:0x046d, B:199:0x0471, B:200:0x0476), top: B:203:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03d6 A[Catch: Exception -> 0x0059, TryCatch #0 {Exception -> 0x0059, blocks: (B:20:0x0055, B:27:0x0066, B:172:0x03f0, B:30:0x0070, B:166:0x03be, B:168:0x03d6, B:33:0x007a, B:158:0x0392, B:160:0x039c, B:162:0x03a4, B:36:0x0088, B:84:0x01e4, B:85:0x01f4, B:87:0x01fa, B:89:0x0207, B:91:0x020b, B:92:0x020f, B:94:0x0218, B:96:0x023e, B:99:0x024f, B:101:0x0253, B:104:0x025a, B:106:0x026b, B:108:0x0271, B:110:0x0279, B:115:0x0287, B:118:0x028f, B:127:0x02c8, B:129:0x02d8, B:131:0x030c, B:133:0x0312, B:135:0x0316, B:138:0x031d, B:140:0x032e, B:142:0x0334, B:150:0x035e, B:152:0x0364, B:144:0x033b, B:146:0x0341, B:148:0x0354, B:149:0x0357, B:179:0x041f, B:130:0x02f3, B:120:0x0295, B:122:0x02b2, B:124:0x02b6, B:181:0x0423, B:183:0x0429, B:185:0x0439, B:111:0x027e, B:187:0x043d, B:189:0x0441, B:190:0x0446, B:191:0x0447, B:193:0x045f, B:195:0x0468, B:196:0x046c, B:39:0x00a2, B:41:0x00b3, B:59:0x0157, B:61:0x0177, B:63:0x0182, B:65:0x0192, B:67:0x0196, B:70:0x019d, B:72:0x01ae, B:74:0x01b8, B:80:0x01cd, B:75:0x01c2, B:62:0x017c, B:79:0x01ca, B:44:0x00fb, B:46:0x011f, B:48:0x0125, B:50:0x012c, B:51:0x0136, B:52:0x0144, B:54:0x014a, B:56:0x0151, B:197:0x046d, B:199:0x0471, B:200:0x0476), top: B:203:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x041d A[PHI: r5
      0x041d: PHI (r5v7 x6.a) = (r5v3 x6.a), (r5v4 x6.a), (r5v5 x6.a), (r5v6 x6.a), (r5v8 x6.a) binds: [B:82:0x01e0, B:157:0x0390, B:164:0x03bb, B:170:0x03ed, B:176:0x041b] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x041e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0429 A[Catch: Exception -> 0x0059, TryCatch #0 {Exception -> 0x0059, blocks: (B:20:0x0055, B:27:0x0066, B:172:0x03f0, B:30:0x0070, B:166:0x03be, B:168:0x03d6, B:33:0x007a, B:158:0x0392, B:160:0x039c, B:162:0x03a4, B:36:0x0088, B:84:0x01e4, B:85:0x01f4, B:87:0x01fa, B:89:0x0207, B:91:0x020b, B:92:0x020f, B:94:0x0218, B:96:0x023e, B:99:0x024f, B:101:0x0253, B:104:0x025a, B:106:0x026b, B:108:0x0271, B:110:0x0279, B:115:0x0287, B:118:0x028f, B:127:0x02c8, B:129:0x02d8, B:131:0x030c, B:133:0x0312, B:135:0x0316, B:138:0x031d, B:140:0x032e, B:142:0x0334, B:150:0x035e, B:152:0x0364, B:144:0x033b, B:146:0x0341, B:148:0x0354, B:149:0x0357, B:179:0x041f, B:130:0x02f3, B:120:0x0295, B:122:0x02b2, B:124:0x02b6, B:181:0x0423, B:183:0x0429, B:185:0x0439, B:111:0x027e, B:187:0x043d, B:189:0x0441, B:190:0x0446, B:191:0x0447, B:193:0x045f, B:195:0x0468, B:196:0x046c, B:39:0x00a2, B:41:0x00b3, B:59:0x0157, B:61:0x0177, B:63:0x0182, B:65:0x0192, B:67:0x0196, B:70:0x019d, B:72:0x01ae, B:74:0x01b8, B:80:0x01cd, B:75:0x01c2, B:62:0x017c, B:79:0x01ca, B:44:0x00fb, B:46:0x011f, B:48:0x0125, B:50:0x012c, B:51:0x0136, B:52:0x0144, B:54:0x014a, B:56:0x0151, B:197:0x046d, B:199:0x0471, B:200:0x0476), top: B:203:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0439 A[Catch: Exception -> 0x0059, TryCatch #0 {Exception -> 0x0059, blocks: (B:20:0x0055, B:27:0x0066, B:172:0x03f0, B:30:0x0070, B:166:0x03be, B:168:0x03d6, B:33:0x007a, B:158:0x0392, B:160:0x039c, B:162:0x03a4, B:36:0x0088, B:84:0x01e4, B:85:0x01f4, B:87:0x01fa, B:89:0x0207, B:91:0x020b, B:92:0x020f, B:94:0x0218, B:96:0x023e, B:99:0x024f, B:101:0x0253, B:104:0x025a, B:106:0x026b, B:108:0x0271, B:110:0x0279, B:115:0x0287, B:118:0x028f, B:127:0x02c8, B:129:0x02d8, B:131:0x030c, B:133:0x0312, B:135:0x0316, B:138:0x031d, B:140:0x032e, B:142:0x0334, B:150:0x035e, B:152:0x0364, B:144:0x033b, B:146:0x0341, B:148:0x0354, B:149:0x0357, B:179:0x041f, B:130:0x02f3, B:120:0x0295, B:122:0x02b2, B:124:0x02b6, B:181:0x0423, B:183:0x0429, B:185:0x0439, B:111:0x027e, B:187:0x043d, B:189:0x0441, B:190:0x0446, B:191:0x0447, B:193:0x045f, B:195:0x0468, B:196:0x046c, B:39:0x00a2, B:41:0x00b3, B:59:0x0157, B:61:0x0177, B:63:0x0182, B:65:0x0192, B:67:0x0196, B:70:0x019d, B:72:0x01ae, B:74:0x01b8, B:80:0x01cd, B:75:0x01c2, B:62:0x017c, B:79:0x01ca, B:44:0x00fb, B:46:0x011f, B:48:0x0125, B:50:0x012c, B:51:0x0136, B:52:0x0144, B:54:0x014a, B:56:0x0151, B:197:0x046d, B:199:0x0471, B:200:0x0476), top: B:203:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(y6.c r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1147
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.TrackingWorker.g(y6.c):java.lang.Object");
    }
}
