package androidx.constraintlayout.core.parser;

import androidx.annotation.NonNull;
import androidx.constraintlayout.core.widgets.analyzer.a;
import j$.util.Objects;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class CLContainer extends CLElement {
    ArrayList<CLElement> mElements;

    public CLContainer(char[] cArr) {
        super(cArr);
        this.mElements = new ArrayList<>();
    }

    public static CLElement allocate(char[] cArr) {
        return new CLContainer(cArr);
    }

    public void add(CLElement cLElement) {
        this.mElements.add(cLElement);
        if (CLParser.sDebug) {
            System.out.println("added element " + cLElement + " to " + this);
        }
    }

    public void clear() {
        this.mElements.clear();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CLContainer mo34clone() {
        CLContainer cLContainer = (CLContainer) super.mo34clone();
        ArrayList<CLElement> arrayList = new ArrayList<>(this.mElements.size());
        ArrayList<CLElement> arrayList2 = this.mElements;
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            CLElement cLElement = arrayList2.get(i10);
            i10++;
            CLElement cLElementMo34clone = cLElement.mo34clone();
            cLElementMo34clone.setContainer(cLContainer);
            arrayList.add(cLElementMo34clone);
        }
        cLContainer.mElements = arrayList;
        return cLContainer;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLContainer) {
            return this.mElements.equals(((CLContainer) obj).mElements);
        }
        return false;
    }

    public CLElement get(String str) throws CLParsingException {
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            CLElement cLElement = arrayList.get(i10);
            i10++;
            CLKey cLKey = (CLKey) cLElement;
            if (cLKey.content().equals(str)) {
                return cLKey.getValue();
            }
        }
        throw new CLParsingException(a.x("no element for key <", str, ">"), this);
    }

    public CLArray getArray(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLArray) {
            return (CLArray) cLElement;
        }
        StringBuilder sbY = a3.a.y("no array found for key <", str, ">, found [");
        sbY.append(cLElement.getStrClass());
        sbY.append("] : ");
        sbY.append(cLElement);
        throw new CLParsingException(sbY.toString(), this);
    }

    public CLArray getArrayOrCreate(String str) {
        CLArray arrayOrNull = getArrayOrNull(str);
        if (arrayOrNull != null) {
            return arrayOrNull;
        }
        CLArray cLArray = new CLArray(new char[0]);
        put(str, cLArray);
        return cLArray;
    }

    public CLArray getArrayOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLArray) {
            return (CLArray) orNull;
        }
        return null;
    }

    public boolean getBoolean(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLToken) {
            return ((CLToken) cLElement).getBoolean();
        }
        StringBuilder sbY = a3.a.y("no boolean found for key <", str, ">, found [");
        sbY.append(cLElement.getStrClass());
        sbY.append("] : ");
        sbY.append(cLElement);
        throw new CLParsingException(sbY.toString(), this);
    }

    public float getFloat(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement != null) {
            return cLElement.getFloat();
        }
        StringBuilder sbY = a3.a.y("no float found for key <", str, ">, found [");
        sbY.append(cLElement.getStrClass());
        sbY.append("] : ");
        sbY.append(cLElement);
        throw new CLParsingException(sbY.toString(), this);
    }

    public float getFloatOrNaN(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLNumber) {
            return orNull.getFloat();
        }
        return Float.NaN;
    }

    public int getInt(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement != null) {
            return cLElement.getInt();
        }
        StringBuilder sbY = a3.a.y("no int found for key <", str, ">, found [");
        sbY.append(cLElement.getStrClass());
        sbY.append("] : ");
        sbY.append(cLElement);
        throw new CLParsingException(sbY.toString(), this);
    }

    public CLObject getObject(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLObject) {
            return (CLObject) cLElement;
        }
        StringBuilder sbY = a3.a.y("no object found for key <", str, ">, found [");
        sbY.append(cLElement.getStrClass());
        sbY.append("] : ");
        sbY.append(cLElement);
        throw new CLParsingException(sbY.toString(), this);
    }

    public CLObject getObjectOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLObject) {
            return (CLObject) orNull;
        }
        return null;
    }

    public CLElement getOrNull(String str) {
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            CLElement cLElement = arrayList.get(i10);
            i10++;
            CLKey cLKey = (CLKey) cLElement;
            if (cLKey.content().equals(str)) {
                return cLKey.getValue();
            }
        }
        return null;
    }

    public String getString(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLString) {
            return cLElement.content();
        }
        throw new CLParsingException("no string found for key <" + str + ">, found [" + (cLElement != null ? cLElement.getStrClass() : null) + "] : " + cLElement, this);
    }

    public String getStringOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLString) {
            return orNull.content();
        }
        return null;
    }

    public boolean has(String str) {
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            CLElement cLElement = arrayList.get(i10);
            i10++;
            CLElement cLElement2 = cLElement;
            if ((cLElement2 instanceof CLKey) && ((CLKey) cLElement2).content().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        return Objects.hash(this.mElements, Integer.valueOf(super.hashCode()));
    }

    public ArrayList<String> names() {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<CLElement> arrayList2 = this.mElements;
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            CLElement cLElement = arrayList2.get(i10);
            i10++;
            CLElement cLElement2 = cLElement;
            if (cLElement2 instanceof CLKey) {
                arrayList.add(((CLKey) cLElement2).content());
            }
        }
        return arrayList;
    }

    public void put(String str, CLElement cLElement) {
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            CLElement cLElement2 = arrayList.get(i10);
            i10++;
            CLKey cLKey = (CLKey) cLElement2;
            if (cLKey.content().equals(str)) {
                cLKey.set(cLElement);
                return;
            }
        }
        this.mElements.add((CLKey) CLKey.allocate(str, cLElement));
    }

    public void putNumber(String str, float f) {
        put(str, new CLNumber(f));
    }

    public void putString(String str, String str2) {
        CLString cLString = new CLString(str2.toCharArray());
        cLString.setStart(0L);
        cLString.setEnd(str2.length() - 1);
        put(str, cLString);
    }

    public void remove(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList<CLElement> arrayList2 = this.mElements;
        int size = arrayList2.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            CLElement cLElement = arrayList2.get(i11);
            i11++;
            CLElement cLElement2 = cLElement;
            if (((CLKey) cLElement2).content().equals(str)) {
                arrayList.add(cLElement2);
            }
        }
        int size2 = arrayList.size();
        while (i10 < size2) {
            Object obj = arrayList.get(i10);
            i10++;
            this.mElements.remove((CLElement) obj);
        }
    }

    public int size() {
        return this.mElements.size();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            CLElement cLElement = arrayList.get(i10);
            i10++;
            CLElement cLElement2 = cLElement;
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append(cLElement2);
        }
        return super.toString() + " = <" + ((Object) sb) + " >";
    }

    public String getStringOrNull(int i10) {
        CLElement orNull = getOrNull(i10);
        if (orNull instanceof CLString) {
            return orNull.content();
        }
        return null;
    }

    public CLElement getOrNull(int i10) {
        if (i10 < 0 || i10 >= this.mElements.size()) {
            return null;
        }
        return this.mElements.get(i10);
    }

    public CLArray getArray(int i10) throws CLParsingException {
        CLElement cLElement = get(i10);
        if (cLElement instanceof CLArray) {
            return (CLArray) cLElement;
        }
        throw new CLParsingException(a3.a.f(i10, "no array at index "), this);
    }

    public float getFloat(int i10) throws CLParsingException {
        CLElement cLElement = get(i10);
        if (cLElement != null) {
            return cLElement.getFloat();
        }
        throw new CLParsingException(a3.a.f(i10, "no float at index "), this);
    }

    public int getInt(int i10) throws CLParsingException {
        CLElement cLElement = get(i10);
        if (cLElement != null) {
            return cLElement.getInt();
        }
        throw new CLParsingException(a3.a.f(i10, "no int at index "), this);
    }

    public CLObject getObject(int i10) throws CLParsingException {
        CLElement cLElement = get(i10);
        if (cLElement instanceof CLObject) {
            return (CLObject) cLElement;
        }
        throw new CLParsingException(a3.a.f(i10, "no object at index "), this);
    }

    public CLElement get(int i10) throws CLParsingException {
        if (i10 >= 0 && i10 < this.mElements.size()) {
            return this.mElements.get(i10);
        }
        throw new CLParsingException(a3.a.f(i10, "no element at index "), this);
    }

    public boolean getBoolean(int i10) throws CLParsingException {
        CLElement cLElement = get(i10);
        if (cLElement instanceof CLToken) {
            return ((CLToken) cLElement).getBoolean();
        }
        throw new CLParsingException(a3.a.f(i10, "no boolean at index "), this);
    }

    public String getString(int i10) throws CLParsingException {
        CLElement cLElement = get(i10);
        if (cLElement instanceof CLString) {
            return cLElement.content();
        }
        throw new CLParsingException(a3.a.f(i10, "no string at index "), this);
    }
}
