package androidx.room.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.ColumnInfo;
import androidx.room.util.TableInfo;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.google.android.gms.internal.measurement.a4;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import l1.b;
import o7.m;
import r0.f;
import t6.l;
import t6.n;
import t6.u;
import u6.c;
import u6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SchemaInfoUtilKt {
    private static final String[] FTS_OPTIONS = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};

    @ColumnInfo.SQLiteTypeAffinity
    public static final int findAffinity(String str) {
        if (str == null) {
            return 5;
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        upperCase.getClass();
        if (m.d0(upperCase, "INT", false)) {
            return 3;
        }
        if (m.d0(upperCase, "CHAR", false) || m.d0(upperCase, "CLOB", false) || m.d0(upperCase, "TEXT", false)) {
            return 2;
        }
        if (m.d0(upperCase, "BLOB", false)) {
            return 5;
        }
        return (m.d0(upperCase, "REAL", false) || m.d0(upperCase, "FLOA", false) || m.d0(upperCase, "DOUB", false)) ? 4 : 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.Set<java.lang.String> parseFtsOptions(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.SchemaInfoUtilKt.parseFtsOptions(java.lang.String):java.util.Set");
    }

    private static final Map<String, TableInfo.Column> readColumns(SQLiteConnection sQLiteConnection, String str) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("PRAGMA table_info(`" + str + "`)");
        try {
            if (!sQLiteStatementPrepare.step()) {
                u uVar = u.f12809a;
                f.p(sQLiteStatementPrepare, null);
                return uVar;
            }
            int iColumnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, RewardPlus.NAME);
            int iColumnIndexOf2 = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            int iColumnIndexOf3 = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, "notnull");
            int iColumnIndexOf4 = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, "pk");
            int iColumnIndexOf5 = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, "dflt_value");
            u6.f fVar = new u6.f();
            do {
                String text = sQLiteStatementPrepare.getText(iColumnIndexOf);
                fVar.put(text, new TableInfo.Column(text, sQLiteStatementPrepare.getText(iColumnIndexOf2), sQLiteStatementPrepare.getLong(iColumnIndexOf3) != 0, (int) sQLiteStatementPrepare.getLong(iColumnIndexOf4), sQLiteStatementPrepare.isNull(iColumnIndexOf5) ? null : sQLiteStatementPrepare.getText(iColumnIndexOf5), 2));
            } while (sQLiteStatementPrepare.step());
            u6.f fVarC = fVar.c();
            f.p(sQLiteStatementPrepare, null);
            return fVarC;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                f.p(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    private static final List<ForeignKeyWithSequence> readForeignKeyFieldMappings(SQLiteStatement sQLiteStatement) {
        int iColumnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "id");
        int iColumnIndexOf2 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "seq");
        int iColumnIndexOf3 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, TypedValues.TransitionType.S_FROM);
        int iColumnIndexOf4 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, TypedValues.TransitionType.S_TO);
        c cVarL = a4.l();
        while (sQLiteStatement.step()) {
            cVarL.add(new ForeignKeyWithSequence((int) sQLiteStatement.getLong(iColumnIndexOf), (int) sQLiteStatement.getLong(iColumnIndexOf2), sQLiteStatement.getText(iColumnIndexOf3), sQLiteStatement.getText(iColumnIndexOf4)));
        }
        return l.m0(a4.h(cVarL));
    }

    private static final Set<TableInfo.ForeignKey> readForeignKeys(SQLiteConnection sQLiteConnection, String str) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int iColumnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, "id");
            int iColumnIndexOf2 = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, "seq");
            int iColumnIndexOf3 = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, "table");
            int iColumnIndexOf4 = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, "on_delete");
            int iColumnIndexOf5 = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, "on_update");
            List<ForeignKeyWithSequence> foreignKeyFieldMappings = readForeignKeyFieldMappings(sQLiteStatementPrepare);
            sQLiteStatementPrepare.reset();
            i iVar = new i();
            while (sQLiteStatementPrepare.step()) {
                if (sQLiteStatementPrepare.getLong(iColumnIndexOf2) == 0) {
                    int i10 = (int) sQLiteStatementPrepare.getLong(iColumnIndexOf);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : foreignKeyFieldMappings) {
                        if (((ForeignKeyWithSequence) obj).getId() == i10) {
                            arrayList3.add(obj);
                        }
                    }
                    int size = arrayList3.size();
                    int i11 = 0;
                    while (i11 < size) {
                        Object obj2 = arrayList3.get(i11);
                        i11++;
                        ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence) obj2;
                        arrayList.add(foreignKeyWithSequence.getFrom());
                        arrayList2.add(foreignKeyWithSequence.getTo());
                    }
                    iVar.add(new TableInfo.ForeignKey(sQLiteStatementPrepare.getText(iColumnIndexOf3), sQLiteStatementPrepare.getText(iColumnIndexOf4), sQLiteStatementPrepare.getText(iColumnIndexOf5), arrayList, arrayList2));
                }
            }
            i iVarO = b.o(iVar);
            f.p(sQLiteStatementPrepare, null);
            return iVarO;
        } finally {
        }
    }

    public static final Set<String> readFtsColumns(SQLiteConnection sQLiteConnection, String str) {
        sQLiteConnection.getClass();
        str.getClass();
        i iVar = new i();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("PRAGMA table_info(`" + str + "`)");
        try {
            if (sQLiteStatementPrepare.step()) {
                int iColumnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, RewardPlus.NAME);
                do {
                    iVar.add(sQLiteStatementPrepare.getText(iColumnIndexOf));
                } while (sQLiteStatementPrepare.step());
            }
            f.p(sQLiteStatementPrepare, null);
            return b.o(iVar);
        } finally {
        }
    }

    public static final Set<String> readFtsOptions(SQLiteConnection sQLiteConnection, String str) {
        sQLiteConnection.getClass();
        str.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM sqlite_master WHERE `name` = '" + str + '\'');
        try {
            String text = sQLiteStatementPrepare.step() ? sQLiteStatementPrepare.getText(SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, "sql")) : "";
            f.p(sQLiteStatementPrepare, null);
            return parseFtsOptions(text);
        } finally {
        }
    }

    private static final TableInfo.Index readIndex(SQLiteConnection sQLiteConnection, String str, boolean z9) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int iColumnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, "seqno");
            int iColumnIndexOf2 = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, "cid");
            int iColumnIndexOf3 = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, RewardPlus.NAME);
            int iColumnIndexOf4 = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, CampaignEx.JSON_KEY_DESC);
            if (iColumnIndexOf != -1 && iColumnIndexOf2 != -1 && iColumnIndexOf3 != -1 && iColumnIndexOf4 != -1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                while (sQLiteStatementPrepare.step()) {
                    if (((int) sQLiteStatementPrepare.getLong(iColumnIndexOf2)) >= 0) {
                        int i10 = (int) sQLiteStatementPrepare.getLong(iColumnIndexOf);
                        String text = sQLiteStatementPrepare.getText(iColumnIndexOf3);
                        String str2 = sQLiteStatementPrepare.getLong(iColumnIndexOf4) > 0 ? "DESC" : "ASC";
                        linkedHashMap.put(Integer.valueOf(i10), text);
                        linkedHashMap2.put(Integer.valueOf(i10), str2);
                    }
                }
                List listN0 = l.n0(linkedHashMap.entrySet(), new Comparator() { // from class: androidx.room.util.SchemaInfoUtilKt$readIndex$lambda$13$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t9) {
                        return b.u((Integer) ((Map.Entry) t).getKey(), (Integer) ((Map.Entry) t9).getKey());
                    }
                });
                ArrayList arrayList = new ArrayList(n.V(listN0, 10));
                Iterator it = listN0.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Map.Entry) it.next()).getValue());
                }
                List listR0 = l.r0(arrayList);
                List listN02 = l.n0(linkedHashMap2.entrySet(), new Comparator() { // from class: androidx.room.util.SchemaInfoUtilKt$readIndex$lambda$13$$inlined$sortedBy$2
                    @Override // java.util.Comparator
                    public final int compare(T t, T t9) {
                        return b.u((Integer) ((Map.Entry) t).getKey(), (Integer) ((Map.Entry) t9).getKey());
                    }
                });
                ArrayList arrayList2 = new ArrayList(n.V(listN02, 10));
                Iterator it2 = listN02.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((String) ((Map.Entry) it2.next()).getValue());
                }
                TableInfo.Index index = new TableInfo.Index(str, z9, listR0, l.r0(arrayList2));
                f.p(sQLiteStatementPrepare, null);
                return index;
            }
            f.p(sQLiteStatementPrepare, null);
            return null;
        } finally {
        }
    }

    private static final Set<TableInfo.Index> readIndices(SQLiteConnection sQLiteConnection, String str) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("PRAGMA index_list(`" + str + "`)");
        try {
            int iColumnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, RewardPlus.NAME);
            int iColumnIndexOf2 = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, TtmlNode.ATTR_TTS_ORIGIN);
            int iColumnIndexOf3 = SQLiteStatementUtil.columnIndexOf(sQLiteStatementPrepare, "unique");
            if (iColumnIndexOf != -1 && iColumnIndexOf2 != -1 && iColumnIndexOf3 != -1) {
                i iVar = new i();
                while (sQLiteStatementPrepare.step()) {
                    if ("c".equals(sQLiteStatementPrepare.getText(iColumnIndexOf2))) {
                        TableInfo.Index index = readIndex(sQLiteConnection, sQLiteStatementPrepare.getText(iColumnIndexOf), sQLiteStatementPrepare.getLong(iColumnIndexOf3) == 1);
                        if (index == null) {
                            f.p(sQLiteStatementPrepare, null);
                            return null;
                        }
                        iVar.add(index);
                    }
                }
                i iVarO = b.o(iVar);
                f.p(sQLiteStatementPrepare, null);
                return iVarO;
            }
            f.p(sQLiteStatementPrepare, null);
            return null;
        } finally {
        }
    }

    public static final TableInfo readTableInfo(SQLiteConnection sQLiteConnection, String str) {
        sQLiteConnection.getClass();
        str.getClass();
        return new TableInfo(str, readColumns(sQLiteConnection, str), readForeignKeys(sQLiteConnection, str), readIndices(sQLiteConnection, str));
    }

    public static final ViewInfo readViewInfo(SQLiteConnection sQLiteConnection, String str) {
        sQLiteConnection.getClass();
        str.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + str + '\'');
        try {
            ViewInfo viewInfo = sQLiteStatementPrepare.step() ? new ViewInfo(sQLiteStatementPrepare.getText(0), sQLiteStatementPrepare.getText(1)) : new ViewInfo(str, null);
            f.p(sQLiteStatementPrepare, null);
            return viewInfo;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                f.p(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }
}
