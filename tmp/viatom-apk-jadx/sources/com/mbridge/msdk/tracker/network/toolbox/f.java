package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.tracker.network.ae;
import com.mbridge.msdk.tracker.network.b;
import com.mbridge.msdk.tracker.network.r;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f {
    public static b.a a(r rVar) throws NumberFormatException {
        long j10;
        boolean z9;
        long j11;
        long j12;
        long j13;
        long j14;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = rVar.f5445c;
        if (map == null) {
            return null;
        }
        String str = map.get("Date");
        long jA = str != null ? a(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i10 = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            z9 = false;
            j11 = 0;
            j12 = 0;
            while (i10 < strArrSplit.length) {
                String strTrim = strArrSplit[i10].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j11 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j12 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z9 = true;
                }
                i10++;
            }
            j10 = 0;
            i10 = 1;
        } else {
            j10 = 0;
            z9 = false;
            j11 = 0;
            j12 = 0;
        }
        String str3 = map.get("Expires");
        long jA2 = str3 != null ? a(str3) : j10;
        String str4 = map.get("Last-Modified");
        long jA3 = str4 != null ? a(str4) : j10;
        String str5 = map.get(Command.HTTP_HEADER_ETAG);
        if (i10 != 0) {
            long j15 = (j11 * 1000) + jCurrentTimeMillis;
            if (z9) {
                j14 = j15;
            } else {
                Long.signum(j12);
                j14 = (j12 * 1000) + j15;
            }
            j13 = j15;
        } else {
            j13 = (jA <= j10 || jA2 < jA) ? j10 : (jA2 - jA) + jCurrentTimeMillis;
            j14 = j13;
        }
        b.a aVar = new b.a();
        aVar.f5394a = rVar.f5444b;
        aVar.f5395b = str5;
        aVar.f = j13;
        aVar.e = j14;
        aVar.f5396c = jA;
        aVar.f5397d = jA3;
        aVar.g = map;
        aVar.h = rVar.f5446d;
        return aVar;
    }

    private static SimpleDateFormat b(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    private static long a(String str) throws ParseException {
        try {
            Date date = b("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str);
            if (date != null) {
                return date.getTime();
            }
            return 0L;
        } catch (ParseException e) {
            if (!"0".equals(str) && !"-1".equals(str)) {
                ae.a(e, "Unable to parse dateStr: %s, falling back to 0", str);
            } else {
                ae.a("Unable to parse dateStr: %s, falling back to 0", str);
            }
            return 0L;
        }
    }

    public static String a(long j10) {
        return b("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j10));
    }

    public static List<com.mbridge.msdk.tracker.network.h> a(List<com.mbridge.msdk.tracker.network.h> list, b.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<com.mbridge.msdk.tracker.network.h> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<com.mbridge.msdk.tracker.network.h> list2 = aVar.h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (com.mbridge.msdk.tracker.network.h hVar : aVar.h) {
                    if (!treeSet.contains(hVar.a())) {
                        arrayList.add(hVar);
                    }
                }
            }
        } else if (!aVar.g.isEmpty()) {
            for (Map.Entry<String, String> entry : aVar.g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new com.mbridge.msdk.tracker.network.h(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    public static String a(Map<String, String> map) {
        String str;
        if (map != null && (str = map.get("Content-Type")) != null) {
            String[] strArrSplit = str.split(";", 0);
            for (int i10 = 1; i10 < strArrSplit.length; i10++) {
                String[] strArrSplit2 = strArrSplit[i10].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
            return "ISO-8859-1";
        }
        return "ISO-8859-1";
    }
}
