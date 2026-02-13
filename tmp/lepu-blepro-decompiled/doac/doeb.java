/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package doac;

import com.lepu.blepro.utils.StringUtilsKt;
import doac.dobm;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class doeb {
    public static int doa = 3;
    public static int doab = 4;
    public static int doac = 5;
    public static int doad = 7;
    public static int doae = 8;
    public static int doaf = 9;
    public static int doag = 20;
    public static int doah = 21;
    public static int doai = 22;
    private static int doaj = 0;

    public static byte[] doah() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = jSONObject;
        try {
            new JSONObject().put("SetTIME", (Object)StringUtilsKt.makeTimeStr());
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        return doeb.doa(jSONObject2);
    }

    private static byte[] doa(JSONObject object) {
        char[] cArray = object.toString().toCharArray();
        object = cArray;
        int n = cArray.length;
        byte[] byArray = new byte[n + 8];
        byte[] byArray2 = byArray;
        byArray2[0] = -86;
        int n2 = doai;
        byArray2[1] = (byte)n2;
        byArray2[2] = (byte)(~n2);
        byArray2[5] = (byte)n;
        byArray[6] = (byte)(n >> 8);
        int n3 = 0;
        while (n3 < n) {
            int n4 = n3++;
            int n5 = n4 + 7;
            byArray2[n5] = (byte)object[n4];
        }
        byte[] byArray3 = byArray2;
        int n6 = n + 7;
        byArray3[n6] = dobm.doa(byArray3);
        return byArray2;
    }

    public static byte[] doab() {
        byte[] byArray = new byte[8];
        byte[] byArray2 = byArray;
        byArray[0] = -86;
        int n = doah;
        byArray2[1] = (byte)n;
        byArray[2] = (byte)(~n);
        byArray[7] = dobm.doa(byArray);
        return byArray;
    }

    public static byte[] doa() {
        byte[] byArray = new byte[8];
        byte[] byArray2 = byArray;
        byArray[0] = -86;
        int n = doag;
        byArray2[1] = (byte)n;
        byArray[2] = (byte)(~n);
        byArray[7] = dobm.doa(byArray);
        return byArray;
    }

    public static byte[] doa(String object) {
        char[] cArray = ((String)object).toCharArray();
        object = cArray;
        int n = cArray.length;
        int n2 = n + 1;
        byte[] byArray = new byte[n + 9];
        byte[] byArray2 = byArray;
        byArray2[0] = -86;
        int n3 = doa;
        byArray2[1] = (byte)n3;
        byArray2[2] = (byte)(~n3);
        byArray2[5] = (byte)n2;
        byArray[6] = (byte)(n2 >> 8);
        n2 = 0;
        while (n2 < n) {
            int n4 = n2++;
            int n5 = n4 + 7;
            byArray2[n5] = (byte)object[n4];
        }
        byte[] byArray3 = byArray2;
        int n6 = n + 8;
        byArray3[n6] = dobm.doa(byArray3);
        doaj = 0;
        return byArray2;
    }

    public static byte[] doac() {
        byte[] byArray = new byte[8];
        byte[] byArray2 = byArray;
        byArray[0] = -86;
        int n = doab;
        byArray2[1] = (byte)n;
        byArray[2] = (byte)(~n);
        int n2 = doaj++;
        byArray2[3] = (byte)n2;
        byArray[4] = (byte)(n2 >> 8);
        byArray[7] = dobm.doa(byArray);
        return byArray;
    }

    public static byte[] doad() {
        byte[] byArray = new byte[8];
        byte[] byArray2 = byArray;
        byArray[0] = -86;
        int n = doac;
        byArray2[1] = (byte)n;
        byArray[2] = (byte)(~n);
        byArray[7] = dobm.doa(byArray);
        doaj = 0;
        return byArray;
    }

    public static byte[] doag() {
        byte[] byArray = new byte[8];
        byte[] byArray2 = byArray;
        byArray[0] = -86;
        int n = doad;
        byArray2[1] = (byte)n;
        byArray[2] = (byte)(~n);
        byArray[7] = dobm.doa(byArray);
        return byArray;
    }

    public static byte[] doae() {
        byte[] byArray = new byte[8];
        byte[] byArray2 = byArray;
        byArray[0] = -86;
        int n = doae;
        byArray2[1] = (byte)n;
        byArray[2] = (byte)(~n);
        byArray[7] = dobm.doa(byArray);
        return byArray;
    }

    public static byte[] doaf() {
        byte[] byArray = new byte[8];
        byte[] byArray2 = byArray;
        byArray[0] = -86;
        int n = doaf;
        byArray2[1] = (byte)n;
        byArray[2] = (byte)(~n);
        byArray[7] = dobm.doa(byArray);
        return byArray;
    }
}
