package com.mbridge.msdk.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.R;
import com.davemorrissey.labs.subscaleview.BuildConfig;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f2645a = 1500;
    private long G;
    private ArrayList<Integer> I;
    private d J;
    private C0019b K;
    private HashMap<String, String> P;
    private String Q;
    private int V;
    private String Y;
    private Map<String, String> Z;
    private boolean aE;
    private JSONArray aG;
    private JSONObject aH;
    private long aJ;
    private long aO;
    private boolean aP;
    private String aV;
    private int ai;
    private String al;
    private String am;
    private int ap;
    private int aq;
    private int ar;
    private int as;
    private long av;
    private long aw;
    private int bb;
    private String bc;

    /* renamed from: m, reason: collision with root package name */
    private int f2653m;

    /* renamed from: o, reason: collision with root package name */
    private List<com.mbridge.msdk.foundation.entity.a> f2655o;

    /* renamed from: q, reason: collision with root package name */
    private long f2657q;

    /* renamed from: r, reason: collision with root package name */
    private com.mbridge.msdk.c.a f2658r;

    /* renamed from: s, reason: collision with root package name */
    private String f2659s;
    private Map<String, a> t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f2660u;

    /* renamed from: v, reason: collision with root package name */
    private int f2661v;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2646b = false;

    /* renamed from: c, reason: collision with root package name */
    private JSONArray f2647c = new JSONArray();

    /* renamed from: d, reason: collision with root package name */
    private JSONArray f2648d = new JSONArray();
    private String e = "";
    private int f = 0;
    private int g = 0;
    private int h = 2;

    /* renamed from: i, reason: collision with root package name */
    private int f2649i = 0;

    /* renamed from: j, reason: collision with root package name */
    private String f2650j = "";

    /* renamed from: k, reason: collision with root package name */
    private String f2651k = "";

    /* renamed from: l, reason: collision with root package name */
    private String f2652l = "";

    /* renamed from: n, reason: collision with root package name */
    private int f2654n = 0;

    /* renamed from: p, reason: collision with root package name */
    private int f2656p = 0;

    /* renamed from: w, reason: collision with root package name */
    private int f2662w = 1;

    /* renamed from: x, reason: collision with root package name */
    private boolean f2663x = false;
    private String y = "";

    /* renamed from: z, reason: collision with root package name */
    private String f2664z = "";
    private String A = "";
    private String B = "";
    private String C = "";
    private int D = R.styleable.ConstraintSet_stateLabels;
    private String E = com.mbridge.msdk.foundation.same.net.e.d.f().h;
    private String F = com.mbridge.msdk.foundation.same.net.e.d.f().f3741l;
    private int H = f2645a;
    private int L = 0;
    private long M = 86400;
    private int N = 0;
    private int O = 3;
    private boolean R = true;
    private int S = 0;
    private boolean T = false;
    private boolean U = false;
    private int W = 0;
    private int X = 0;
    private String aa = BuildConfig.VERSION_NAME;
    private int ab = 30;
    private int ac = 9377;
    private int ad = 0;
    private int ae = 5;
    private int af = 1;
    private int ag = 8000;
    private String ah = "";
    private int aj = 10;
    private int ak = R.styleable.ConstraintSet_stateLabels;
    private String an = "";
    private String ao = "";
    private String at = "";
    private String au = "";
    private List<Integer> ax = new ArrayList();
    private int ay = 3;
    private int az = 0;
    private int aA = 3;
    private int aB = 0;
    private int aC = 10;
    private int aD = 600;
    private int aF = 0;
    private String aI = "";
    private int aK = 8000;
    private int aL = 1;
    private long aM = 10;
    private int aN = 3;
    private int aQ = 1;
    private int aR = 1;
    private int aS = 1;
    private int aT = 1;
    private String aU = "";
    private int aW = 1300;
    private int aX = 0;
    private int aY = 0;
    private long aZ = 3600;
    private String ba = "";

    /* JADX WARN: Removed duplicated region for block: B:111:0x03d8 A[Catch: Exception -> 0x045a, TryCatch #14 {Exception -> 0x045a, blocks: (B:109:0x03ad, B:111:0x03d8, B:112:0x03e2, B:114:0x03ec, B:115:0x0405, B:119:0x044c), top: B:269:0x03ad }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03ec A[Catch: Exception -> 0x045a, TryCatch #14 {Exception -> 0x045a, blocks: (B:109:0x03ad, B:111:0x03d8, B:112:0x03e2, B:114:0x03ec, B:115:0x0405, B:119:0x044c), top: B:269:0x03ad }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04d5 A[Catch: Exception -> 0x0538, TryCatch #4 {Exception -> 0x0538, blocks: (B:134:0x04b3, B:136:0x04d5, B:137:0x04d7, B:139:0x04db, B:140:0x04dd, B:142:0x04e1, B:143:0x04e3, B:145:0x04e7, B:146:0x04e9, B:149:0x04f4), top: B:249:0x04b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04db A[Catch: Exception -> 0x0538, TryCatch #4 {Exception -> 0x0538, blocks: (B:134:0x04b3, B:136:0x04d5, B:137:0x04d7, B:139:0x04db, B:140:0x04dd, B:142:0x04e1, B:143:0x04e3, B:145:0x04e7, B:146:0x04e9, B:149:0x04f4), top: B:249:0x04b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x04e1 A[Catch: Exception -> 0x0538, TryCatch #4 {Exception -> 0x0538, blocks: (B:134:0x04b3, B:136:0x04d5, B:137:0x04d7, B:139:0x04db, B:140:0x04dd, B:142:0x04e1, B:143:0x04e3, B:145:0x04e7, B:146:0x04e9, B:149:0x04f4), top: B:249:0x04b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04e7 A[Catch: Exception -> 0x0538, TryCatch #4 {Exception -> 0x0538, blocks: (B:134:0x04b3, B:136:0x04d5, B:137:0x04d7, B:139:0x04db, B:140:0x04dd, B:142:0x04e1, B:143:0x04e3, B:145:0x04e7, B:146:0x04e9, B:149:0x04f4), top: B:249:0x04b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x055a  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x056e A[Catch: Exception -> 0x0249, TryCatch #2 {Exception -> 0x0249, blocks: (B:5:0x0017, B:9:0x0064, B:14:0x00b0, B:37:0x0158, B:38:0x015b, B:40:0x023d, B:43:0x024d, B:45:0x0263, B:55:0x029c, B:59:0x02b8, B:61:0x02d2, B:63:0x02d8, B:64:0x02de, B:66:0x02e4, B:68:0x02ea, B:69:0x02f1, B:70:0x02f4, B:72:0x02fa, B:73:0x0303, B:92:0x0367, B:94:0x036f, B:97:0x0376, B:99:0x037c, B:100:0x0384, B:102:0x038a, B:104:0x0396, B:106:0x039c, B:120:0x045a, B:133:0x049f, B:151:0x0540, B:159:0x0560, B:161:0x056e, B:163:0x057e, B:164:0x0587, B:225:0x06b2, B:227:0x06be, B:228:0x06c8, B:230:0x06d4, B:224:0x06af, B:174:0x05a8, B:167:0x0598, B:158:0x055e, B:132:0x0496, B:91:0x035e, B:46:0x0268, B:48:0x0272, B:50:0x0278, B:51:0x027e, B:53:0x0284, B:54:0x029a, B:13:0x00ab, B:8:0x0060, B:175:0x05aa, B:199:0x0627, B:222:0x06ab, B:203:0x062f, B:205:0x0639, B:207:0x0643, B:209:0x064b, B:211:0x0660, B:214:0x0673, B:216:0x067d, B:218:0x0685, B:220:0x069a, B:181:0x05cc, B:183:0x05d6, B:185:0x05e0, B:187:0x05e8, B:192:0x05ff, B:194:0x0609, B:196:0x0611, B:165:0x058f, B:121:0x0472, B:125:0x0483, B:129:0x048e, B:75:0x030f, B:76:0x0321, B:78:0x0327, B:80:0x0333, B:82:0x033d, B:84:0x034b, B:87:0x0355, B:89:0x035b, B:152:0x0550, B:156:0x055b, B:168:0x059a, B:172:0x05a5), top: B:245:0x0017, inners: #0, #3, #5, #6, #12, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x06be A[Catch: Exception -> 0x0249, TryCatch #2 {Exception -> 0x0249, blocks: (B:5:0x0017, B:9:0x0064, B:14:0x00b0, B:37:0x0158, B:38:0x015b, B:40:0x023d, B:43:0x024d, B:45:0x0263, B:55:0x029c, B:59:0x02b8, B:61:0x02d2, B:63:0x02d8, B:64:0x02de, B:66:0x02e4, B:68:0x02ea, B:69:0x02f1, B:70:0x02f4, B:72:0x02fa, B:73:0x0303, B:92:0x0367, B:94:0x036f, B:97:0x0376, B:99:0x037c, B:100:0x0384, B:102:0x038a, B:104:0x0396, B:106:0x039c, B:120:0x045a, B:133:0x049f, B:151:0x0540, B:159:0x0560, B:161:0x056e, B:163:0x057e, B:164:0x0587, B:225:0x06b2, B:227:0x06be, B:228:0x06c8, B:230:0x06d4, B:224:0x06af, B:174:0x05a8, B:167:0x0598, B:158:0x055e, B:132:0x0496, B:91:0x035e, B:46:0x0268, B:48:0x0272, B:50:0x0278, B:51:0x027e, B:53:0x0284, B:54:0x029a, B:13:0x00ab, B:8:0x0060, B:175:0x05aa, B:199:0x0627, B:222:0x06ab, B:203:0x062f, B:205:0x0639, B:207:0x0643, B:209:0x064b, B:211:0x0660, B:214:0x0673, B:216:0x067d, B:218:0x0685, B:220:0x069a, B:181:0x05cc, B:183:0x05d6, B:185:0x05e0, B:187:0x05e8, B:192:0x05ff, B:194:0x0609, B:196:0x0611, B:165:0x058f, B:121:0x0472, B:125:0x0483, B:129:0x048e, B:75:0x030f, B:76:0x0321, B:78:0x0327, B:80:0x0333, B:82:0x033d, B:84:0x034b, B:87:0x0355, B:89:0x035b, B:152:0x0550, B:156:0x055b, B:168:0x059a, B:172:0x05a5), top: B:245:0x0017, inners: #0, #3, #5, #6, #12, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x06d4 A[Catch: Exception -> 0x0249, TRY_LEAVE, TryCatch #2 {Exception -> 0x0249, blocks: (B:5:0x0017, B:9:0x0064, B:14:0x00b0, B:37:0x0158, B:38:0x015b, B:40:0x023d, B:43:0x024d, B:45:0x0263, B:55:0x029c, B:59:0x02b8, B:61:0x02d2, B:63:0x02d8, B:64:0x02de, B:66:0x02e4, B:68:0x02ea, B:69:0x02f1, B:70:0x02f4, B:72:0x02fa, B:73:0x0303, B:92:0x0367, B:94:0x036f, B:97:0x0376, B:99:0x037c, B:100:0x0384, B:102:0x038a, B:104:0x0396, B:106:0x039c, B:120:0x045a, B:133:0x049f, B:151:0x0540, B:159:0x0560, B:161:0x056e, B:163:0x057e, B:164:0x0587, B:225:0x06b2, B:227:0x06be, B:228:0x06c8, B:230:0x06d4, B:224:0x06af, B:174:0x05a8, B:167:0x0598, B:158:0x055e, B:132:0x0496, B:91:0x035e, B:46:0x0268, B:48:0x0272, B:50:0x0278, B:51:0x027e, B:53:0x0284, B:54:0x029a, B:13:0x00ab, B:8:0x0060, B:175:0x05aa, B:199:0x0627, B:222:0x06ab, B:203:0x062f, B:205:0x0639, B:207:0x0643, B:209:0x064b, B:211:0x0660, B:214:0x0673, B:216:0x067d, B:218:0x0685, B:220:0x069a, B:181:0x05cc, B:183:0x05d6, B:185:0x05e0, B:187:0x05e8, B:192:0x05ff, B:194:0x0609, B:196:0x0611, B:165:0x058f, B:121:0x0472, B:125:0x0483, B:129:0x048e, B:75:0x030f, B:76:0x0321, B:78:0x0327, B:80:0x0333, B:82:0x033d, B:84:0x034b, B:87:0x0355, B:89:0x035b, B:152:0x0550, B:156:0x055b, B:168:0x059a, B:172:0x05a5), top: B:245:0x0017, inners: #0, #3, #5, #6, #12, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x030f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x062f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x05cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x023d A[Catch: Exception -> 0x0249, TryCatch #2 {Exception -> 0x0249, blocks: (B:5:0x0017, B:9:0x0064, B:14:0x00b0, B:37:0x0158, B:38:0x015b, B:40:0x023d, B:43:0x024d, B:45:0x0263, B:55:0x029c, B:59:0x02b8, B:61:0x02d2, B:63:0x02d8, B:64:0x02de, B:66:0x02e4, B:68:0x02ea, B:69:0x02f1, B:70:0x02f4, B:72:0x02fa, B:73:0x0303, B:92:0x0367, B:94:0x036f, B:97:0x0376, B:99:0x037c, B:100:0x0384, B:102:0x038a, B:104:0x0396, B:106:0x039c, B:120:0x045a, B:133:0x049f, B:151:0x0540, B:159:0x0560, B:161:0x056e, B:163:0x057e, B:164:0x0587, B:225:0x06b2, B:227:0x06be, B:228:0x06c8, B:230:0x06d4, B:224:0x06af, B:174:0x05a8, B:167:0x0598, B:158:0x055e, B:132:0x0496, B:91:0x035e, B:46:0x0268, B:48:0x0272, B:50:0x0278, B:51:0x027e, B:53:0x0284, B:54:0x029a, B:13:0x00ab, B:8:0x0060, B:175:0x05aa, B:199:0x0627, B:222:0x06ab, B:203:0x062f, B:205:0x0639, B:207:0x0643, B:209:0x064b, B:211:0x0660, B:214:0x0673, B:216:0x067d, B:218:0x0685, B:220:0x069a, B:181:0x05cc, B:183:0x05d6, B:185:0x05e0, B:187:0x05e8, B:192:0x05ff, B:194:0x0609, B:196:0x0611, B:165:0x058f, B:121:0x0472, B:125:0x0483, B:129:0x048e, B:75:0x030f, B:76:0x0321, B:78:0x0327, B:80:0x0333, B:82:0x033d, B:84:0x034b, B:87:0x0355, B:89:0x035b, B:152:0x0550, B:156:0x055b, B:168:0x059a, B:172:0x05a5), top: B:245:0x0017, inners: #0, #3, #5, #6, #12, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0263 A[Catch: Exception -> 0x0249, TryCatch #2 {Exception -> 0x0249, blocks: (B:5:0x0017, B:9:0x0064, B:14:0x00b0, B:37:0x0158, B:38:0x015b, B:40:0x023d, B:43:0x024d, B:45:0x0263, B:55:0x029c, B:59:0x02b8, B:61:0x02d2, B:63:0x02d8, B:64:0x02de, B:66:0x02e4, B:68:0x02ea, B:69:0x02f1, B:70:0x02f4, B:72:0x02fa, B:73:0x0303, B:92:0x0367, B:94:0x036f, B:97:0x0376, B:99:0x037c, B:100:0x0384, B:102:0x038a, B:104:0x0396, B:106:0x039c, B:120:0x045a, B:133:0x049f, B:151:0x0540, B:159:0x0560, B:161:0x056e, B:163:0x057e, B:164:0x0587, B:225:0x06b2, B:227:0x06be, B:228:0x06c8, B:230:0x06d4, B:224:0x06af, B:174:0x05a8, B:167:0x0598, B:158:0x055e, B:132:0x0496, B:91:0x035e, B:46:0x0268, B:48:0x0272, B:50:0x0278, B:51:0x027e, B:53:0x0284, B:54:0x029a, B:13:0x00ab, B:8:0x0060, B:175:0x05aa, B:199:0x0627, B:222:0x06ab, B:203:0x062f, B:205:0x0639, B:207:0x0643, B:209:0x064b, B:211:0x0660, B:214:0x0673, B:216:0x067d, B:218:0x0685, B:220:0x069a, B:181:0x05cc, B:183:0x05d6, B:185:0x05e0, B:187:0x05e8, B:192:0x05ff, B:194:0x0609, B:196:0x0611, B:165:0x058f, B:121:0x0472, B:125:0x0483, B:129:0x048e, B:75:0x030f, B:76:0x0321, B:78:0x0327, B:80:0x0333, B:82:0x033d, B:84:0x034b, B:87:0x0355, B:89:0x035b, B:152:0x0550, B:156:0x055b, B:168:0x059a, B:172:0x05a5), top: B:245:0x0017, inners: #0, #3, #5, #6, #12, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0268 A[Catch: Exception -> 0x0249, TryCatch #2 {Exception -> 0x0249, blocks: (B:5:0x0017, B:9:0x0064, B:14:0x00b0, B:37:0x0158, B:38:0x015b, B:40:0x023d, B:43:0x024d, B:45:0x0263, B:55:0x029c, B:59:0x02b8, B:61:0x02d2, B:63:0x02d8, B:64:0x02de, B:66:0x02e4, B:68:0x02ea, B:69:0x02f1, B:70:0x02f4, B:72:0x02fa, B:73:0x0303, B:92:0x0367, B:94:0x036f, B:97:0x0376, B:99:0x037c, B:100:0x0384, B:102:0x038a, B:104:0x0396, B:106:0x039c, B:120:0x045a, B:133:0x049f, B:151:0x0540, B:159:0x0560, B:161:0x056e, B:163:0x057e, B:164:0x0587, B:225:0x06b2, B:227:0x06be, B:228:0x06c8, B:230:0x06d4, B:224:0x06af, B:174:0x05a8, B:167:0x0598, B:158:0x055e, B:132:0x0496, B:91:0x035e, B:46:0x0268, B:48:0x0272, B:50:0x0278, B:51:0x027e, B:53:0x0284, B:54:0x029a, B:13:0x00ab, B:8:0x0060, B:175:0x05aa, B:199:0x0627, B:222:0x06ab, B:203:0x062f, B:205:0x0639, B:207:0x0643, B:209:0x064b, B:211:0x0660, B:214:0x0673, B:216:0x067d, B:218:0x0685, B:220:0x069a, B:181:0x05cc, B:183:0x05d6, B:185:0x05e0, B:187:0x05e8, B:192:0x05ff, B:194:0x0609, B:196:0x0611, B:165:0x058f, B:121:0x0472, B:125:0x0483, B:129:0x048e, B:75:0x030f, B:76:0x0321, B:78:0x0327, B:80:0x0333, B:82:0x033d, B:84:0x034b, B:87:0x0355, B:89:0x035b, B:152:0x0550, B:156:0x055b, B:168:0x059a, B:172:0x05a5), top: B:245:0x0017, inners: #0, #3, #5, #6, #12, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02e4 A[Catch: Exception -> 0x0249, TryCatch #2 {Exception -> 0x0249, blocks: (B:5:0x0017, B:9:0x0064, B:14:0x00b0, B:37:0x0158, B:38:0x015b, B:40:0x023d, B:43:0x024d, B:45:0x0263, B:55:0x029c, B:59:0x02b8, B:61:0x02d2, B:63:0x02d8, B:64:0x02de, B:66:0x02e4, B:68:0x02ea, B:69:0x02f1, B:70:0x02f4, B:72:0x02fa, B:73:0x0303, B:92:0x0367, B:94:0x036f, B:97:0x0376, B:99:0x037c, B:100:0x0384, B:102:0x038a, B:104:0x0396, B:106:0x039c, B:120:0x045a, B:133:0x049f, B:151:0x0540, B:159:0x0560, B:161:0x056e, B:163:0x057e, B:164:0x0587, B:225:0x06b2, B:227:0x06be, B:228:0x06c8, B:230:0x06d4, B:224:0x06af, B:174:0x05a8, B:167:0x0598, B:158:0x055e, B:132:0x0496, B:91:0x035e, B:46:0x0268, B:48:0x0272, B:50:0x0278, B:51:0x027e, B:53:0x0284, B:54:0x029a, B:13:0x00ab, B:8:0x0060, B:175:0x05aa, B:199:0x0627, B:222:0x06ab, B:203:0x062f, B:205:0x0639, B:207:0x0643, B:209:0x064b, B:211:0x0660, B:214:0x0673, B:216:0x067d, B:218:0x0685, B:220:0x069a, B:181:0x05cc, B:183:0x05d6, B:185:0x05e0, B:187:0x05e8, B:192:0x05ff, B:194:0x0609, B:196:0x0611, B:165:0x058f, B:121:0x0472, B:125:0x0483, B:129:0x048e, B:75:0x030f, B:76:0x0321, B:78:0x0327, B:80:0x0333, B:82:0x033d, B:84:0x034b, B:87:0x0355, B:89:0x035b, B:152:0x0550, B:156:0x055b, B:168:0x059a, B:172:0x05a5), top: B:245:0x0017, inners: #0, #3, #5, #6, #12, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02fa A[Catch: Exception -> 0x0249, TryCatch #2 {Exception -> 0x0249, blocks: (B:5:0x0017, B:9:0x0064, B:14:0x00b0, B:37:0x0158, B:38:0x015b, B:40:0x023d, B:43:0x024d, B:45:0x0263, B:55:0x029c, B:59:0x02b8, B:61:0x02d2, B:63:0x02d8, B:64:0x02de, B:66:0x02e4, B:68:0x02ea, B:69:0x02f1, B:70:0x02f4, B:72:0x02fa, B:73:0x0303, B:92:0x0367, B:94:0x036f, B:97:0x0376, B:99:0x037c, B:100:0x0384, B:102:0x038a, B:104:0x0396, B:106:0x039c, B:120:0x045a, B:133:0x049f, B:151:0x0540, B:159:0x0560, B:161:0x056e, B:163:0x057e, B:164:0x0587, B:225:0x06b2, B:227:0x06be, B:228:0x06c8, B:230:0x06d4, B:224:0x06af, B:174:0x05a8, B:167:0x0598, B:158:0x055e, B:132:0x0496, B:91:0x035e, B:46:0x0268, B:48:0x0272, B:50:0x0278, B:51:0x027e, B:53:0x0284, B:54:0x029a, B:13:0x00ab, B:8:0x0060, B:175:0x05aa, B:199:0x0627, B:222:0x06ab, B:203:0x062f, B:205:0x0639, B:207:0x0643, B:209:0x064b, B:211:0x0660, B:214:0x0673, B:216:0x067d, B:218:0x0685, B:220:0x069a, B:181:0x05cc, B:183:0x05d6, B:185:0x05e0, B:187:0x05e8, B:192:0x05ff, B:194:0x0609, B:196:0x0611, B:165:0x058f, B:121:0x0472, B:125:0x0483, B:129:0x048e, B:75:0x030f, B:76:0x0321, B:78:0x0327, B:80:0x0333, B:82:0x033d, B:84:0x034b, B:87:0x0355, B:89:0x035b, B:152:0x0550, B:156:0x055b, B:168:0x059a, B:172:0x05a5), top: B:245:0x0017, inners: #0, #3, #5, #6, #12, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x037c A[Catch: Exception -> 0x0249, TryCatch #2 {Exception -> 0x0249, blocks: (B:5:0x0017, B:9:0x0064, B:14:0x00b0, B:37:0x0158, B:38:0x015b, B:40:0x023d, B:43:0x024d, B:45:0x0263, B:55:0x029c, B:59:0x02b8, B:61:0x02d2, B:63:0x02d8, B:64:0x02de, B:66:0x02e4, B:68:0x02ea, B:69:0x02f1, B:70:0x02f4, B:72:0x02fa, B:73:0x0303, B:92:0x0367, B:94:0x036f, B:97:0x0376, B:99:0x037c, B:100:0x0384, B:102:0x038a, B:104:0x0396, B:106:0x039c, B:120:0x045a, B:133:0x049f, B:151:0x0540, B:159:0x0560, B:161:0x056e, B:163:0x057e, B:164:0x0587, B:225:0x06b2, B:227:0x06be, B:228:0x06c8, B:230:0x06d4, B:224:0x06af, B:174:0x05a8, B:167:0x0598, B:158:0x055e, B:132:0x0496, B:91:0x035e, B:46:0x0268, B:48:0x0272, B:50:0x0278, B:51:0x027e, B:53:0x0284, B:54:0x029a, B:13:0x00ab, B:8:0x0060, B:175:0x05aa, B:199:0x0627, B:222:0x06ab, B:203:0x062f, B:205:0x0639, B:207:0x0643, B:209:0x064b, B:211:0x0660, B:214:0x0673, B:216:0x067d, B:218:0x0685, B:220:0x069a, B:181:0x05cc, B:183:0x05d6, B:185:0x05e0, B:187:0x05e8, B:192:0x05ff, B:194:0x0609, B:196:0x0611, B:165:0x058f, B:121:0x0472, B:125:0x0483, B:129:0x048e, B:75:0x030f, B:76:0x0321, B:78:0x0327, B:80:0x0333, B:82:0x033d, B:84:0x034b, B:87:0x0355, B:89:0x035b, B:152:0x0550, B:156:0x055b, B:168:0x059a, B:172:0x05a5), top: B:245:0x0017, inners: #0, #3, #5, #6, #12, #15 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.mbridge.msdk.c.g a(org.json.JSONObject r19) throws org.json.JSONException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1768
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.c.b.a(org.json.JSONObject):com.mbridge.msdk.c.g");
    }

    private static Map<String, a> e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap map = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                a aVar = new a();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    aVar.a(jSONObjectOptJSONObject);
                }
                map.put(next, aVar);
            }
            return map;
        } catch (JSONException e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return null;
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
            return null;
        }
    }

    public final int A() {
        return this.D;
    }

    public final String B() {
        return this.E;
    }

    public final String C() {
        return this.F;
    }

    public final long D() {
        return this.G;
    }

    public final ArrayList<Integer> E() {
        return this.I;
    }

    public final d F() {
        return this.J;
    }

    public final C0019b G() {
        return this.K;
    }

    public final long H() {
        return this.M;
    }

    public final int I() {
        return this.O;
    }

    public final HashMap<String, String> J() {
        return this.P;
    }

    public final int K() {
        return this.S;
    }

    public final int L() {
        return this.V;
    }

    public final int M() {
        return this.W;
    }

    public final JSONArray N() {
        return this.f2647c;
    }

    public final JSONArray O() {
        return this.f2648d;
    }

    public final String P() {
        return this.aa;
    }

    public final int Q() {
        return this.af;
    }

    public final int R() {
        return this.ag;
    }

    public final int S() {
        return this.ai;
    }

    public final int T() {
        return this.ak;
    }

    public final String U() {
        return this.al;
    }

    public final String V() {
        return this.am;
    }

    public final String W() {
        return this.an;
    }

    public final String X() {
        return this.ao;
    }

    public final int Y() {
        return this.ap;
    }

    public final int Z() {
        return this.aq;
    }

    public final int aA() {
        return this.aW;
    }

    public final int aB() {
        return this.aX;
    }

    public final int aC() {
        return this.aY;
    }

    public final boolean aD() {
        return this.R;
    }

    public final boolean aE() {
        return this.f2660u;
    }

    public final boolean aF() {
        return this.f2663x;
    }

    public final boolean aG() {
        return this.T;
    }

    public final boolean aH() {
        return this.f2646b;
    }

    public final boolean aI() {
        return this.U;
    }

    public final boolean aJ() {
        return this.aE;
    }

    public final boolean aK() {
        return this.aP;
    }

    public final void aL() {
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(this.C) || TextUtils.isEmpty(this.A) || TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.f2664z)) {
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.C = "Confirm to close? ";
                this.A = "You will not be rewarded after closing the window";
                this.B = "Close it";
                this.f2664z = "Continue";
            } else {
                this.C = "确认关闭？";
                this.A = "关闭后您将不会获得任何奖励噢~ ";
                this.B = "确认关闭";
                this.f2664z = "继续观看";
            }
        }
        if (TextUtils.isEmpty(this.C) || TextUtils.isEmpty(this.A) || TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.y)) {
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.C = "Confirm to close? ";
                this.A = "You will not be rewarded after closing the window";
                this.B = "Close it";
                this.y = "Continue";
                return;
            }
            this.C = "确认关闭？";
            this.A = "关闭后您将不会获得任何奖励噢~ ";
            this.B = "确认关闭";
            this.y = "继续试玩";
        }
    }

    public final int aa() {
        return this.ar;
    }

    public final int ab() {
        return this.as;
    }

    public final long ac() {
        return this.av;
    }

    public final long ad() {
        if (this.aw <= 0) {
            this.aw = 7200L;
        }
        return this.aw;
    }

    public final int ae() {
        return this.ay;
    }

    public final int af() {
        return this.az;
    }

    public final int ag() {
        return this.aA;
    }

    public final int ah() {
        return this.aB;
    }

    public final int ai() {
        return this.aC;
    }

    public final int aj() {
        return this.aD;
    }

    public final int ak() {
        return this.aF;
    }

    public final JSONArray al() {
        return this.aG;
    }

    public final JSONObject am() {
        return this.aH;
    }

    public final String an() {
        return this.aI;
    }

    public final long ao() {
        return this.aJ;
    }

    public final int ap() {
        return this.aK;
    }

    public final int aq() {
        return this.aL;
    }

    public final long ar() {
        return this.aM * 1000;
    }

    public final int as() {
        return this.aN;
    }

    public final long at() {
        return this.aO;
    }

    public final int au() {
        return this.aQ;
    }

    public final int av() {
        return this.aR;
    }

    public final int aw() {
        return this.aS;
    }

    public final int ax() {
        return this.aT;
    }

    public final String ay() {
        return this.aU;
    }

    public final String az() {
        return this.aV;
    }

    public final String b() {
        return this.ba;
    }

    public final long c() {
        return this.aZ;
    }

    public final String d() {
        return this.e;
    }

    public final int f() {
        return this.g;
    }

    public final int g() {
        return this.h;
    }

    public final int h() {
        return this.f2649i;
    }

    public final String i() {
        return this.f2650j;
    }

    public final String j() {
        return this.f2651k;
    }

    public final String k() {
        return this.f2652l;
    }

    public final int l() {
        return this.f2653m;
    }

    public final int m() {
        return this.f2654n;
    }

    public final List<com.mbridge.msdk.foundation.entity.a> n() {
        return this.f2655o;
    }

    public final int o() {
        return this.f2656p;
    }

    public final void p(int i10) {
        if (i10 > 0) {
            this.aj = i10;
        }
    }

    public final com.mbridge.msdk.c.a q() {
        return this.f2658r;
    }

    public final String r() {
        return this.f2659s;
    }

    public final Map<String, a> s() {
        return this.t;
    }

    public final int t() {
        return this.f2661v;
    }

    public String toString() {
        return " cfc=" + this.f2661v + " getpf=" + this.M + " rurl=" + this.aE;
    }

    public final int u() {
        return this.f2662w;
    }

    public final String v() {
        return this.y;
    }

    public final String w() {
        return this.f2664z;
    }

    public final String x() {
        return this.A;
    }

    public final String y() {
        return this.B;
    }

    public final boolean z(int i10) {
        return this.ax.contains(Integer.valueOf(i10));
    }

    public final void b(int i10) {
        this.f = i10;
    }

    public final void c(int i10) {
        this.g = i10;
    }

    public final void d(int i10) {
        this.h = i10;
    }

    public final void f(int i10) {
        this.f2653m = i10;
    }

    public final void g(int i10) {
        this.f2654n = i10;
    }

    public final void h(int i10) {
        this.f2656p = i10;
    }

    public final void i(int i10) {
        this.f2661v = i10;
    }

    public final void j(int i10) {
        this.f2662w = i10;
    }

    public final void k(int i10) {
        this.D = i10;
    }

    public final void l(int i10) {
        this.O = i10;
    }

    public final void m(int i10) {
        this.S = i10;
    }

    public final void n(int i10) {
        this.V = i10;
    }

    public final void o(int i10) {
        this.W = i10;
    }

    public final void q(int i10) {
        this.ai = i10;
    }

    public final void r(int i10) {
        this.ak = i10;
    }

    public final void s(int i10) {
        this.aF = i10;
    }

    public final void t(int i10) {
        this.aL = i10;
    }

    public final void u(int i10) {
        this.aN = i10;
    }

    public final void v(int i10) {
        this.aQ = i10;
    }

    public final void w(int i10) {
        this.aR = i10;
    }

    public final void x(int i10) {
        this.aS = i10;
    }

    public final void y(int i10) {
        this.aT = i10;
    }

    public final void b(long j10) {
        this.f2657q = j10;
    }

    public final void c(String str) {
        this.an = str;
    }

    public final void d(String str) {
        this.ao = str;
    }

    public final void f(long j10) {
        this.aM = j10;
    }

    public final void b(String str) {
        this.am = str;
    }

    public final void c(long j10) {
        this.av = j10;
    }

    public final void d(long j10) {
        this.aw = j10;
    }

    public final void f(boolean z9) {
        this.aP = z9;
    }

    public final long p() {
        return this.f2657q;
    }

    public final void b(boolean z9) {
        this.f2663x = z9;
    }

    public final void c(boolean z9) {
        this.T = z9;
    }

    public final void d(boolean z9) {
        this.f2646b = z9;
    }

    public final String z() {
        return this.C;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private List<String> f2668a;

        /* renamed from: b, reason: collision with root package name */
        private List<String> f2669b;

        /* renamed from: c, reason: collision with root package name */
        private List<String> f2670c;

        /* renamed from: d, reason: collision with root package name */
        private List<String> f2671d;

        public final void a(JSONObject jSONObject) {
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("x");
                if (jSONArrayOptJSONArray != null) {
                    this.f2670c = s.a(jSONArrayOptJSONArray);
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("y");
                if (jSONArrayOptJSONArray2 != null) {
                    this.f2671d = s.a(jSONArrayOptJSONArray2);
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("width");
                if (jSONArrayOptJSONArray3 != null) {
                    this.f2669b = s.a(jSONArrayOptJSONArray3);
                }
                JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("height");
                if (jSONArrayOptJSONArray4 != null) {
                    this.f2668a = s.a(jSONArrayOptJSONArray4);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }

        public final List<String> b() {
            return this.f2669b;
        }

        public final List<String> c() {
            return this.f2670c;
        }

        public final List<String> d() {
            return this.f2671d;
        }

        public final List<String> a() {
            return this.f2668a;
        }
    }

    public final int e() {
        return this.f;
    }

    public final void e(int i10) {
        this.f2649i = i10;
    }

    public final void e(long j10) {
        this.aJ = j10;
    }

    public final void e(boolean z9) {
        this.aE = z9;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.c.b$b, reason: collision with other inner class name */
    public static class C0019b {

        /* renamed from: a, reason: collision with root package name */
        private String f2680a;

        /* renamed from: b, reason: collision with root package name */
        private JSONArray f2681b;

        /* renamed from: c, reason: collision with root package name */
        private String f2682c;

        /* renamed from: d, reason: collision with root package name */
        private String f2683d;
        private String e;
        private String f;

        public static C0019b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            C0019b c0019b = new C0019b();
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            c0019b.f = jSONObject.optString(CampaignEx.JSON_KEY_TITLE, contextC.getString(x.a(contextC, "mbridge_cm_feedback_dialog_title", TypedValues.Custom.S_STRING)));
            c0019b.f2680a = jSONObject.optString("cancel", contextC.getString(x.a(contextC, "mbridge_cm_feedback_dialog_close_close", TypedValues.Custom.S_STRING)));
            c0019b.f2683d = jSONObject.optString("submit", contextC.getString(x.a(contextC, "mbridge_cm_feedback_dialog_close_submit", TypedValues.Custom.S_STRING)));
            c0019b.e = jSONObject.optString("submit_notice", contextC.getString(x.a(contextC, "mbridge_cm_feedback_dialog_submit_notice", TypedValues.Custom.S_STRING)));
            c0019b.f2682c = jSONObject.optString("privacy", contextC.getString(x.a(contextC, "mbridge_cm_feedback_dialog_privacy_des", TypedValues.Custom.S_STRING)));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("content");
            c0019b.f2681b = jSONArrayOptJSONArray;
            if (jSONArrayOptJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                c0019b.f2681b = jSONArray;
                jSONArray.put(contextC.getString(x.a(contextC, "mbridge_cm_feedback_dialog_content_not_play", TypedValues.Custom.S_STRING)));
                c0019b.f2681b.put(contextC.getString(x.a(contextC, "mbridge_cm_feedback_dialog_content_sound_problems", TypedValues.Custom.S_STRING)));
                c0019b.f2681b.put(contextC.getString(x.a(contextC, "mbridge_cm_feedback_dialog_content_misleading", TypedValues.Custom.S_STRING)));
                c0019b.f2681b.put(contextC.getString(x.a(contextC, "mbridge_cm_feedback_dialog_content_fraud", TypedValues.Custom.S_STRING)));
                c0019b.f2681b.put(contextC.getString(x.a(contextC, "mbridge_cm_feedback_dialog_content_por_violence", TypedValues.Custom.S_STRING)));
                c0019b.f2681b.put(contextC.getString(x.a(contextC, "mbridge_cm_feedback_dialog_content_other", TypedValues.Custom.S_STRING)));
            }
            return c0019b;
        }

        public final JSONArray b() {
            return this.f2681b;
        }

        public final String c() {
            return this.f2682c;
        }

        public final String d() {
            return this.f2683d;
        }

        public final String e() {
            return this.e;
        }

        public final String f() {
            return this.f;
        }

        public final String a() {
            return this.f2680a;
        }
    }

    public final void a(int i10) {
        this.bb = i10;
    }

    public final void a(long j10) {
        this.aZ = j10;
    }

    public static String a(Context context, String str) {
        try {
            g gVarB = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB != null && ((b) gVarB).Z != null) {
                String host = Uri.parse(str).getHost();
                Iterator<Map.Entry<String, String>> it = ((b) gVarB).Z.entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    if (!TextUtils.isEmpty(host) && host.contains(key)) {
                        String str2 = ((b) gVarB).Z.get(key);
                        if (TextUtils.isEmpty(str2)) {
                            return "";
                        }
                        return str2.replace("{gaid}", com.mbridge.msdk.foundation.tools.f.c());
                    }
                }
                return "";
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public final int a() {
        return this.bb;
    }

    public final void a(String str) {
        this.Q = str;
    }

    public final void a(boolean z9) {
        this.f2660u = z9;
    }
}
