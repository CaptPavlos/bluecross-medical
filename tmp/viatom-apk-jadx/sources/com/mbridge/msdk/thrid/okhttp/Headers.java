package com.mbridge.msdk.thrid.okhttp;

import androidx.window.layout.c;
import com.google.gson.internal.a;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpDate;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Headers {
    private final String[] namesAndValues;

    public Headers(Builder builder) {
        List<String> list = builder.namesAndValues;
        this.namesAndValues = (String[]) list.toArray(new String[list.size()]);
    }

    public static void checkName(String str) {
        if (str == null) {
            c.k("name == null");
            return;
        }
        if (str.isEmpty()) {
            a.n("name is empty");
            return;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt <= ' ' || cCharAt >= 127) {
                a.n(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i10), str));
                return;
            }
        }
    }

    public static void checkValue(String str, String str2) {
        if (str == null) {
            c.k(androidx.constraintlayout.core.widgets.analyzer.a.x("value for name ", str2, " == null"));
            return;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                a.n(Util.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i10), str2, str));
                return;
            }
        }
    }

    private static String get(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static Headers of(Map<String, String> map) {
        if (map == null) {
            c.k("headers == null");
            return null;
        }
        String[] strArr = new String[map.size() * 2];
        int i10 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                a.n("Headers cannot be null");
                return null;
            }
            String strTrim = entry.getKey().trim();
            String strTrim2 = entry.getValue().trim();
            checkName(strTrim);
            checkValue(strTrim2, strTrim);
            strArr[i10] = strTrim;
            strArr[i10 + 1] = strTrim2;
            i10 += 2;
        }
        return new Headers(strArr);
    }

    public long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        for (int i10 = 0; i10 < strArr.length; i10++) {
            length += this.namesAndValues[i10].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).namesAndValues, this.namesAndValues);
    }

    public Date getDate(String str) {
        String str2 = get(str);
        if (str2 != null) {
            return HttpDate.parse(str2);
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public String name(int i10) {
        return this.namesAndValues[i10 * 2];
    }

    public Set<String> names() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            treeSet.add(name(i10));
        }
        return DesugarCollections.unmodifiableSet(treeSet);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        Collections.addAll(builder.namesAndValues, this.namesAndValues);
        return builder;
    }

    public int size() {
        return this.namesAndValues.length / 2;
    }

    public Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            String lowerCase = name(i10).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(value(i10));
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            sb.append(name(i10));
            sb.append(": ");
            sb.append(value(i10));
            sb.append("\n");
        }
        return sb.toString();
    }

    public String value(int i10) {
        return this.namesAndValues[(i10 * 2) + 1];
    }

    public List<String> values(String str) {
        int size = size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            if (str.equalsIgnoreCase(name(i10))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i10));
            }
        }
        return arrayList != null ? DesugarCollections.unmodifiableList(arrayList) : Collections.EMPTY_LIST;
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Builder {
        final List<String> namesAndValues = new ArrayList(20);

        public Builder add(String str) {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf != -1) {
                return add(str.substring(0, iIndexOf).trim(), str.substring(iIndexOf + 1));
            }
            a.n("Unexpected header: ".concat(str));
            return null;
        }

        public Builder addAll(Headers headers) {
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                addLenient(headers.name(i10), headers.value(i10));
            }
            return this;
        }

        public Builder addLenient(String str) {
            int iIndexOf = str.indexOf(":", 1);
            return iIndexOf != -1 ? addLenient(str.substring(0, iIndexOf), str.substring(iIndexOf + 1)) : str.startsWith(":") ? addLenient("", str.substring(1)) : addLenient("", str);
        }

        public Builder addUnsafeNonAscii(String str, String str2) {
            Headers.checkName(str);
            return addLenient(str, str2);
        }

        public Headers build() {
            return new Headers(this);
        }

        public String get(String str) {
            for (int size = this.namesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.namesAndValues.get(size))) {
                    return this.namesAndValues.get(size + 1);
                }
            }
            return null;
        }

        public Builder removeAll(String str) {
            int i10 = 0;
            while (i10 < this.namesAndValues.size()) {
                if (str.equalsIgnoreCase(this.namesAndValues.get(i10))) {
                    this.namesAndValues.remove(i10);
                    this.namesAndValues.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        public Builder set(String str, Date date) {
            if (date != null) {
                set(str, HttpDate.format(date));
                return this;
            }
            c.k(androidx.constraintlayout.core.widgets.analyzer.a.x("value for name ", str, " == null"));
            return null;
        }

        public Builder set(String str, String str2) {
            Headers.checkName(str);
            Headers.checkValue(str2, str);
            removeAll(str);
            addLenient(str, str2);
            return this;
        }

        public Builder add(String str, String str2) {
            Headers.checkName(str);
            Headers.checkValue(str2, str);
            return addLenient(str, str2);
        }

        public Builder add(String str, Date date) {
            if (date != null) {
                add(str, HttpDate.format(date));
                return this;
            }
            c.k(androidx.constraintlayout.core.widgets.analyzer.a.x("value for name ", str, " == null"));
            return null;
        }

        public Builder addLenient(String str, String str2) {
            this.namesAndValues.add(str);
            this.namesAndValues.add(str2.trim());
            return this;
        }
    }

    public String get(String str) {
        return get(this.namesAndValues, str);
    }

    public static Headers of(String... strArr) {
        if (strArr != null) {
            if (strArr.length % 2 == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                for (int i10 = 0; i10 < strArr2.length; i10++) {
                    String str = strArr2[i10];
                    if (str != null) {
                        strArr2[i10] = str.trim();
                    } else {
                        a.n("Headers cannot be null");
                        return null;
                    }
                }
                for (int i11 = 0; i11 < strArr2.length; i11 += 2) {
                    String str2 = strArr2[i11];
                    String str3 = strArr2[i11 + 1];
                    checkName(str2);
                    checkValue(str3, str2);
                }
                return new Headers(strArr2);
            }
            a.n("Expected alternating header names and values");
            return null;
        }
        c.k("namesAndValues == null");
        return null;
    }
}
