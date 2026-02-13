package androidx.room.util;

import androidx.constraintlayout.core.widgets.analyzer.a;
import androidx.room.util.TableInfo;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import kotlin.jvm.internal.l;
import l1.b;
import o7.m;
import o7.n;
import o7.u;
import s6.w;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class TableInfoKt {
    private static final boolean containsSurroundingParenthesis(String str) {
        if (str.length() == 0) {
            return false;
        }
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            int i13 = i12 + 1;
            if (i12 == 0 && cCharAt != '(') {
                return false;
            }
            if (cCharAt == '(') {
                i11++;
            } else if (cCharAt == ')' && i11 - 1 == 0 && i12 != str.length() - 1) {
                return false;
            }
            i10++;
            i12 = i13;
        }
        return i11 == 0;
    }

    public static final boolean defaultValueEqualsCommon(String str, String str2) {
        str.getClass();
        if (str.equals(str2)) {
            return true;
        }
        if (containsSurroundingParenthesis(str)) {
            return l.a(m.v0(str.substring(1, str.length() - 1)).toString(), str2);
        }
        return false;
    }

    public static final boolean equalsCommon(TableInfo.Column column, Object obj) {
        column.getClass();
        if (column == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.Column)) {
            return false;
        }
        TableInfo.Column column2 = (TableInfo.Column) obj;
        if (column.isPrimaryKey() != column2.isPrimaryKey() || !l.a(column.name, column2.name) || column.notNull != column2.notNull) {
            return false;
        }
        String str = column.defaultValue;
        String str2 = column2.defaultValue;
        if (column.createdFrom == 1 && column2.createdFrom == 2 && str != null && !defaultValueEqualsCommon(str, str2)) {
            return false;
        }
        if (column.createdFrom == 2 && column2.createdFrom == 1 && str2 != null && !defaultValueEqualsCommon(str2, str)) {
            return false;
        }
        int i10 = column.createdFrom;
        return (i10 == 0 || i10 != column2.createdFrom || (str == null ? str2 == null : defaultValueEqualsCommon(str, str2))) && column.affinity == column2.affinity;
    }

    public static final String formatString(Collection<?> collection) {
        collection.getClass();
        return !collection.isEmpty() ? n.P(t6.l.h0(collection, ",\n", "\n", "\n", null, 56)).concat("},") : " }";
    }

    public static final int hashCodeCommon(TableInfo.Index index) {
        index.getClass();
        return index.orders.hashCode() + ((index.columns.hashCode() + ((((u.c0(index.name, TableInfo.Index.DEFAULT_PREFIX, false) ? -1184239155 : index.name.hashCode()) * 31) + (index.unique ? 1 : 0)) * 31)) * 31);
    }

    private static final void joinToStringEndWithIndent(Collection<?> collection) {
        n.P(t6.l.h0(collection, ",", null, null, null, 62));
        n.P(" }");
    }

    private static final void joinToStringMiddleWithIndent(Collection<?> collection) {
        n.P(t6.l.h0(collection, ",", null, null, null, 62));
        n.P("},");
    }

    public static final String toStringCommon(TableInfo tableInfo) {
        tableInfo.getClass();
        StringBuilder sb = new StringBuilder("\n            |TableInfo {\n            |    name = '");
        sb.append(tableInfo.name);
        sb.append("',\n            |    columns = {");
        sb.append(formatString(t6.l.n0(tableInfo.columns.values(), new Comparator() { // from class: androidx.room.util.TableInfoKt$toStringCommon$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t9) {
                return b.u(((TableInfo.Column) t).name, ((TableInfo.Column) t9).name);
            }
        })));
        sb.append("\n            |    foreignKeys = {");
        sb.append(formatString(tableInfo.foreignKeys));
        sb.append("\n            |    indices = {");
        Set<TableInfo.Index> set = tableInfo.indices;
        sb.append(formatString(set != null ? t6.l.n0(set, new Comparator() { // from class: androidx.room.util.TableInfoKt$toStringCommon$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t9) {
                return b.u(((TableInfo.Index) t).name, ((TableInfo.Index) t9).name);
            }
        }) : t.f12808a));
        sb.append("\n            |}\n        ");
        return n.R(sb.toString());
    }

    public static final int hashCodeCommon(TableInfo.Column column) {
        column.getClass();
        return (((((column.name.hashCode() * 31) + column.affinity) * 31) + (column.notNull ? 1231 : 1237)) * 31) + column.primaryKeyPosition;
    }

    public static final int hashCodeCommon(TableInfo.ForeignKey foreignKey) {
        foreignKey.getClass();
        return foreignKey.referenceColumnNames.hashCode() + ((foreignKey.columnNames.hashCode() + a.o(a.o(foreignKey.referenceTable.hashCode() * 31, 31, foreignKey.onDelete), 31, foreignKey.onUpdate)) * 31);
    }

    public static final int hashCodeCommon(TableInfo tableInfo) {
        tableInfo.getClass();
        return tableInfo.foreignKeys.hashCode() + ((tableInfo.columns.hashCode() + (tableInfo.name.hashCode() * 31)) * 31);
    }

    public static final String toStringCommon(TableInfo.Column column) {
        column.getClass();
        StringBuilder sb = new StringBuilder("\n            |Column {\n            |   name = '");
        sb.append(column.name);
        sb.append("',\n            |   type = '");
        sb.append(column.type);
        sb.append("',\n            |   affinity = '");
        sb.append(column.affinity);
        sb.append("',\n            |   notNull = '");
        sb.append(column.notNull);
        sb.append("',\n            |   primaryKeyPosition = '");
        sb.append(column.primaryKeyPosition);
        sb.append("',\n            |   defaultValue = '");
        String str = column.defaultValue;
        if (str == null) {
            str = "undefined";
        }
        sb.append(str);
        sb.append("'\n            |}\n        ");
        return n.P(n.R(sb.toString()));
    }

    public static final boolean equalsCommon(TableInfo tableInfo, Object obj) {
        Set<TableInfo.Index> set;
        tableInfo.getClass();
        if (tableInfo == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo2 = (TableInfo) obj;
        if (!l.a(tableInfo.name, tableInfo2.name) || !l.a(tableInfo.columns, tableInfo2.columns) || !l.a(tableInfo.foreignKeys, tableInfo2.foreignKeys)) {
            return false;
        }
        Set<TableInfo.Index> set2 = tableInfo.indices;
        if (set2 == null || (set = tableInfo2.indices) == null) {
            return true;
        }
        return l.a(set2, set);
    }

    public static final boolean equalsCommon(TableInfo.ForeignKey foreignKey, Object obj) {
        foreignKey.getClass();
        if (foreignKey == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.ForeignKey)) {
            return false;
        }
        TableInfo.ForeignKey foreignKey2 = (TableInfo.ForeignKey) obj;
        if (l.a(foreignKey.referenceTable, foreignKey2.referenceTable) && l.a(foreignKey.onDelete, foreignKey2.onDelete) && l.a(foreignKey.onUpdate, foreignKey2.onUpdate) && l.a(foreignKey.columnNames, foreignKey2.columnNames)) {
            return l.a(foreignKey.referenceColumnNames, foreignKey2.referenceColumnNames);
        }
        return false;
    }

    public static final boolean equalsCommon(TableInfo.Index index, Object obj) {
        index.getClass();
        if (index == obj) {
            return true;
        }
        if (obj instanceof TableInfo.Index) {
            TableInfo.Index index2 = (TableInfo.Index) obj;
            if (index.unique == index2.unique && l.a(index.columns, index2.columns) && l.a(index.orders, index2.orders)) {
                if (u.c0(index.name, TableInfo.Index.DEFAULT_PREFIX, false)) {
                    return u.c0(index2.name, TableInfo.Index.DEFAULT_PREFIX, false);
                }
                return l.a(index.name, index2.name);
            }
        }
        return false;
    }

    public static final String toStringCommon(TableInfo.ForeignKey foreignKey) {
        foreignKey.getClass();
        StringBuilder sb = new StringBuilder("\n            |ForeignKey {\n            |   referenceTable = '");
        sb.append(foreignKey.referenceTable);
        sb.append("',\n            |   onDelete = '");
        sb.append(foreignKey.onDelete);
        sb.append("',\n            |   onUpdate = '");
        sb.append(foreignKey.onUpdate);
        sb.append("',\n            |   columnNames = {");
        joinToStringMiddleWithIndent(t6.l.m0(foreignKey.columnNames));
        w wVar = w.f12711a;
        sb.append(wVar);
        sb.append("\n            |   referenceColumnNames = {");
        joinToStringEndWithIndent(t6.l.m0(foreignKey.referenceColumnNames));
        sb.append(wVar);
        sb.append("\n            |}\n        ");
        return n.P(n.R(sb.toString()));
    }

    public static final String toStringCommon(TableInfo.Index index) {
        index.getClass();
        StringBuilder sb = new StringBuilder("\n            |Index {\n            |   name = '");
        sb.append(index.name);
        sb.append("',\n            |   unique = '");
        sb.append(index.unique);
        sb.append("',\n            |   columns = {");
        joinToStringMiddleWithIndent(index.columns);
        w wVar = w.f12711a;
        sb.append(wVar);
        sb.append("\n            |   orders = {");
        joinToStringEndWithIndent(index.orders);
        sb.append(wVar);
        sb.append("\n            |}\n        ");
        return n.P(n.R(sb.toString()));
    }
}
