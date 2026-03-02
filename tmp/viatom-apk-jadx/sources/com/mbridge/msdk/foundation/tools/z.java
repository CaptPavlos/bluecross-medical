package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4043a = "z";

    /* renamed from: b, reason: collision with root package name */
    private static Map<Character, Character> f4044b;

    /* renamed from: c, reason: collision with root package name */
    private static Map<Character, Character> f4045c;

    /* renamed from: d, reason: collision with root package name */
    private static byte[] f4046d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    private static char[] e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    static {
        HashMap map = new HashMap();
        f4044b = map;
        map.put('v', 'A');
        f4044b.put('S', 'B');
        f4044b.put('o', 'C');
        f4044b.put('a', 'D');
        f4044b.put('j', 'E');
        f4044b.put('c', 'F');
        f4044b.put('7', 'G');
        f4044b.put('d', 'H');
        f4044b.put('R', 'I');
        f4044b.put('z', 'J');
        f4044b.put('p', 'K');
        f4044b.put('W', 'L');
        f4044b.put('i', 'M');
        f4044b.put('f', 'N');
        f4044b.put('G', 'O');
        f4044b.put('y', 'P');
        f4044b.put('N', 'Q');
        f4044b.put('x', 'R');
        f4044b.put('Z', 'S');
        f4044b.put('n', 'T');
        f4044b.put('V', 'U');
        f4044b.put('5', 'V');
        f4044b.put('k', 'W');
        f4044b.put('+', 'X');
        f4044b.put('D', 'Y');
        f4044b.put('H', 'Z');
        f4044b.put('L', 'a');
        f4044b.put('Y', 'b');
        f4044b.put('h', 'c');
        f4044b.put('J', 'd');
        f4044b.put('4', 'e');
        f4044b.put('6', 'f');
        f4044b.put('l', 'g');
        f4044b.put('t', 'h');
        f4044b.put('0', 'i');
        f4044b.put('U', 'j');
        f4044b.put('3', 'k');
        f4044b.put('Q', 'l');
        f4044b.put('r', 'm');
        f4044b.put('g', 'n');
        f4044b.put('E', 'o');
        f4044b.put('u', 'p');
        f4044b.put('q', 'q');
        f4044b.put('8', 'r');
        f4044b.put('s', 's');
        f4044b.put('w', 't');
        f4044b.put('/', 'u');
        f4044b.put('X', 'v');
        f4044b.put('M', 'w');
        f4044b.put('e', 'x');
        f4044b.put('B', 'y');
        f4044b.put('A', 'z');
        f4044b.put('T', '0');
        f4044b.put('2', '1');
        f4044b.put('F', '2');
        f4044b.put('b', '3');
        f4044b.put('9', '4');
        f4044b.put('P', '5');
        f4044b.put('1', '6');
        f4044b.put('O', '7');
        f4044b.put('I', '8');
        f4044b.put('K', '9');
        f4044b.put('m', '+');
        f4044b.put('C', '/');
        HashMap map2 = new HashMap();
        f4045c = map2;
        map2.put('A', 'v');
        f4045c.put('B', 'S');
        f4045c.put('C', 'o');
        f4045c.put('D', 'a');
        f4045c.put('E', 'j');
        f4045c.put('F', 'c');
        f4045c.put('G', '7');
        f4045c.put('H', 'd');
        f4045c.put('I', 'R');
        f4045c.put('J', 'z');
        f4045c.put('K', 'p');
        f4045c.put('L', 'W');
        f4045c.put('M', 'i');
        f4045c.put('N', 'f');
        f4045c.put('O', 'G');
        f4045c.put('P', 'y');
        f4045c.put('Q', 'N');
        f4045c.put('R', 'x');
        f4045c.put('S', 'Z');
        f4045c.put('T', 'n');
        f4045c.put('U', 'V');
        f4045c.put('V', '5');
        f4045c.put('W', 'k');
        f4045c.put('X', '+');
        f4045c.put('Y', 'D');
        f4045c.put('Z', 'H');
        f4045c.put('a', 'L');
        f4045c.put('b', 'Y');
        f4045c.put('c', 'h');
        f4045c.put('d', 'J');
        f4045c.put('e', '4');
        f4045c.put('f', '6');
        f4045c.put('g', 'l');
        f4045c.put('h', 't');
        f4045c.put('i', '0');
        f4045c.put('j', 'U');
        f4045c.put('k', '3');
        f4045c.put('l', 'Q');
        f4045c.put('m', 'r');
        f4045c.put('n', 'g');
        f4045c.put('o', 'E');
        f4045c.put('p', 'u');
        f4045c.put('q', 'q');
        f4045c.put('r', '8');
        f4045c.put('s', 's');
        f4045c.put('t', 'w');
        f4045c.put('u', '/');
        f4045c.put('v', 'X');
        f4045c.put('w', 'M');
        f4045c.put('x', 'e');
        f4045c.put('y', 'B');
        f4045c.put('z', 'A');
        f4045c.put('0', 'T');
        f4045c.put('1', '2');
        f4045c.put('2', 'F');
        f4045c.put('3', 'b');
        f4045c.put('4', '9');
        f4045c.put('5', 'P');
        f4045c.put('6', '1');
        f4045c.put('7', 'O');
        f4045c.put('8', 'I');
        f4045c.put('9', 'K');
        f4045c.put('+', 'm');
        f4045c.put('/', 'C');
    }

    private z() {
    }

    public static String a(String str) {
        return ag.a(str);
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : ag.b(str);
    }
}
