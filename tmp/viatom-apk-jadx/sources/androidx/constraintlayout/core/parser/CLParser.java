package androidx.constraintlayout.core.parser;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class CLParser {
    static boolean sDebug = false;
    private String mContent;
    private boolean mHasComment = false;
    private int mLineNumber;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public CLParser(String str) {
        this.mContent = str;
    }

    private CLElement createElement(CLElement cLElement, int i10, TYPE type, boolean z9, char[] cArr) {
        CLElement cLElementAllocate;
        if (sDebug) {
            System.out.println("CREATE " + type + " at " + cArr[i10]);
        }
        switch (type.ordinal()) {
            case 1:
                cLElementAllocate = CLObject.allocate(cArr);
                i10++;
                break;
            case 2:
                cLElementAllocate = CLArray.allocate(cArr);
                i10++;
                break;
            case 3:
                cLElementAllocate = CLNumber.allocate(cArr);
                break;
            case 4:
                cLElementAllocate = CLString.allocate(cArr);
                break;
            case 5:
                cLElementAllocate = CLKey.allocate(cArr);
                break;
            case 6:
                cLElementAllocate = CLToken.allocate(cArr);
                break;
            default:
                cLElementAllocate = null;
                break;
        }
        if (cLElementAllocate == null) {
            return null;
        }
        cLElementAllocate.setLine(this.mLineNumber);
        if (z9) {
            cLElementAllocate.setStart(i10);
        }
        if (cLElement instanceof CLContainer) {
            cLElementAllocate.setContainer((CLContainer) cLElement);
        }
        return cLElementAllocate;
    }

    private CLElement getNextJsonElement(int i10, char c10, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c10 != '\t' && c10 != '\n' && c10 != '\r' && c10 != ' ') {
            if (c10 == '\"' || c10 == '\'') {
                return cLElement instanceof CLObject ? createElement(cLElement, i10, TYPE.KEY, true, cArr) : createElement(cLElement, i10, TYPE.STRING, true, cArr);
            }
            if (c10 == '[') {
                return createElement(cLElement, i10, TYPE.ARRAY, true, cArr);
            }
            if (c10 != ']') {
                if (c10 == '{') {
                    return createElement(cLElement, i10, TYPE.OBJECT, true, cArr);
                }
                if (c10 != '}') {
                    switch (c10) {
                        case '+':
                        case '-':
                        case '.':
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            return createElement(cLElement, i10, TYPE.NUMBER, true, cArr);
                        case ',':
                        case ':':
                            break;
                        case '/':
                            int i11 = i10 + 1;
                            if (i11 >= cArr.length || cArr[i11] != '/') {
                                return cLElement;
                            }
                            this.mHasComment = true;
                            return cLElement;
                        default:
                            if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                                return createElement(cLElement, i10, TYPE.KEY, true, cArr);
                            }
                            CLElement cLElementCreateElement = createElement(cLElement, i10, TYPE.TOKEN, true, cArr);
                            CLToken cLToken = (CLToken) cLElementCreateElement;
                            if (cLToken.validate(c10, i10)) {
                                return cLElementCreateElement;
                            }
                            throw new CLParsingException("incorrect token <" + c10 + "> at line " + this.mLineNumber, cLToken);
                    }
                }
            }
            cLElement.setEnd(i10 - 1);
            CLElement container = cLElement.getContainer();
            container.setEnd(i10);
            return container;
        }
        return cLElement;
    }

    public CLObject parse() throws CLParsingException {
        int i10;
        char[] charArray = this.mContent.toCharArray();
        int length = charArray.length;
        int i11 = 1;
        this.mLineNumber = 1;
        boolean z9 = false;
        int i12 = 0;
        while (true) {
            if (i12 >= length) {
                i12 = -1;
                break;
            }
            char c10 = charArray[i12];
            if (c10 == '{') {
                break;
            }
            if (c10 == '\n') {
                this.mLineNumber++;
            }
            i12++;
        }
        if (i12 == -1) {
            throw new CLParsingException("invalid json content", null);
        }
        CLObject cLObjectAllocate = CLObject.allocate(charArray);
        cLObjectAllocate.setLine(this.mLineNumber);
        cLObjectAllocate.setStart(i12);
        int i13 = i12 + 1;
        CLElement container = cLObjectAllocate;
        while (i13 < length) {
            char c11 = charArray[i13];
            if (c11 == '\n') {
                this.mLineNumber += i11;
            }
            if (this.mHasComment) {
                if (c11 == '\n') {
                    this.mHasComment = z9;
                } else {
                    i10 = i11;
                    i13++;
                    i11 = i10;
                    z9 = false;
                }
            }
            if (container == null) {
                break;
            }
            if (container.isDone()) {
                container = getNextJsonElement(i13, c11, container, charArray);
            } else if (container instanceof CLObject) {
                if (c11 == '}') {
                    container.setEnd(i13 - 1);
                } else {
                    container = getNextJsonElement(i13, c11, container, charArray);
                }
            } else if (!(container instanceof CLArray)) {
                boolean z10 = container instanceof CLString;
                if (z10) {
                    long j10 = container.mStart;
                    if (charArray[(int) j10] == c11) {
                        container.setStart(j10 + 1);
                        container.setEnd(i13 - 1);
                    }
                } else {
                    if (container instanceof CLToken) {
                        CLToken cLToken = (CLToken) container;
                        i10 = i11;
                        if (!cLToken.validate(c11, i13)) {
                            throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.mLineNumber, cLToken);
                        }
                    } else {
                        i10 = i11;
                    }
                    if ((container instanceof CLKey) || z10) {
                        long j11 = container.mStart;
                        char c12 = charArray[(int) j11];
                        if ((c12 == '\'' || c12 == '\"') && c12 == c11) {
                            container.setStart(j11 + 1);
                            container.setEnd(i13 - 1);
                        }
                    }
                    if (!container.isDone() && (c11 == '}' || c11 == ']' || c11 == ',' || c11 == ' ' || c11 == '\t' || c11 == '\r' || c11 == '\n' || c11 == ':')) {
                        long j12 = i13 - 1;
                        container.setEnd(j12);
                        if (c11 == '}' || c11 == ']') {
                            container = container.getContainer();
                            container.setEnd(j12);
                            if (container instanceof CLKey) {
                                container = container.getContainer();
                                container.setEnd(j12);
                            }
                        }
                    }
                    if (!container.isDone() && (!(container instanceof CLKey) || ((CLKey) container).mElements.size() > 0)) {
                        container = container.getContainer();
                    }
                    i13++;
                    i11 = i10;
                    z9 = false;
                }
            } else if (c11 == ']') {
                container.setEnd(i13 - 1);
            } else {
                container = getNextJsonElement(i13, c11, container, charArray);
            }
            i10 = i11;
            if (!container.isDone()) {
            }
            i13++;
            i11 = i10;
            z9 = false;
        }
        while (container != null && !container.isDone()) {
            if (container instanceof CLString) {
                container.setStart(((int) container.mStart) + 1);
            }
            container.setEnd(length - 1);
            container = container.getContainer();
        }
        if (sDebug) {
            System.out.println("Root: " + cLObjectAllocate.toJSON());
        }
        return cLObjectAllocate;
    }

    public static CLObject parse(String str) throws CLParsingException {
        return new CLParser(str).parse();
    }
}
