package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.text.Char;

/* compiled from: characters.scm */
public class characters extends ModuleBody {
    public static final characters $instance = new characters();
    static final SimpleSymbol Lit0 = ((SimpleSymbol) new SimpleSymbol("char?").readResolve());
    static final SimpleSymbol Lit1 = ((SimpleSymbol) new SimpleSymbol("char->integer").readResolve());
    static final SimpleSymbol Lit2 = ((SimpleSymbol) new SimpleSymbol("integer->char").readResolve());
    static final SimpleSymbol Lit3 = ((SimpleSymbol) new SimpleSymbol("char=?").readResolve());
    static final SimpleSymbol Lit4 = ((SimpleSymbol) new SimpleSymbol("char<?").readResolve());
    static final SimpleSymbol Lit5 = ((SimpleSymbol) new SimpleSymbol("char>?").readResolve());
    static final SimpleSymbol Lit6 = ((SimpleSymbol) new SimpleSymbol("char<=?").readResolve());
    static final SimpleSymbol Lit7 = ((SimpleSymbol) new SimpleSymbol("char>=?").readResolve());
    public static final ModuleMethod char$Eq$Qu;
    public static final ModuleMethod char$Gr$Eq$Qu;
    public static final ModuleMethod char$Gr$Qu;
    public static final ModuleMethod char$Ls$Eq$Qu;
    public static final ModuleMethod char$Ls$Qu;
    public static final ModuleMethod char$Mn$Grinteger;
    public static final ModuleMethod char$Qu;
    public static final ModuleMethod integer$Mn$Grchar;

    static {
        characters characters = $instance;
        char$Qu = new ModuleMethod(characters, 1, Lit0, 4097);
        char$Mn$Grinteger = new ModuleMethod(characters, 2, Lit1, 4097);
        integer$Mn$Grchar = new ModuleMethod(characters, 3, Lit2, 4097);
        char$Eq$Qu = new ModuleMethod(characters, 4, Lit3, 8194);
        char$Ls$Qu = new ModuleMethod(characters, 5, Lit4, 8194);
        char$Gr$Qu = new ModuleMethod(characters, 6, Lit5, 8194);
        char$Ls$Eq$Qu = new ModuleMethod(characters, 7, Lit6, 8194);
        char$Gr$Eq$Qu = new ModuleMethod(characters, 8, Lit7, 8194);
        $instance.run();
    }

    public characters() {
        ModuleInfo.register(this);
    }

    public final void run(CallContext $ctx) {
        Consumer consumer = $ctx.consumer;
    }

    public static boolean isChar(Object x) {
        return x instanceof Char;
    }

    public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 1:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 2:
                if (!(obj instanceof Char)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 3:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            default:
                return super.match1(moduleMethod, obj, callContext);
        }
    }

    public static int char$To$Integer(Char charR) {
        return charR.intValue();
    }

    public static Char integer$To$Char(int n) {
        return Char.make(n);
    }

    public Object apply1(ModuleMethod moduleMethod, Object obj) {
        switch (moduleMethod.selector) {
            case 1:
                return isChar(obj) ? Boolean.TRUE : Boolean.FALSE;
            case 2:
                try {
                    return Integer.valueOf(char$To$Integer((Char) obj));
                } catch (ClassCastException e) {
                    throw new WrongType(e, "char->integer", 1, obj);
                }
            case 3:
                try {
                    return integer$To$Char(((Number) obj).intValue());
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "integer->char", 1, obj);
                }
            default:
                return super.apply1(moduleMethod, obj);
        }
    }

    public static boolean isChar$Eq(Char c1, Char c2) {
        return c1.intValue() == c2.intValue();
    }

    public int match2(ModuleMethod moduleMethod, Object obj, Object obj2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 4:
                if (!(obj instanceof Char)) {
                    return -786431;
                }
                callContext.value1 = obj;
                if (!(obj2 instanceof Char)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 5:
                if (!(obj instanceof Char)) {
                    return -786431;
                }
                callContext.value1 = obj;
                if (!(obj2 instanceof Char)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 6:
                if (!(obj instanceof Char)) {
                    return -786431;
                }
                callContext.value1 = obj;
                if (!(obj2 instanceof Char)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 7:
                if (!(obj instanceof Char)) {
                    return -786431;
                }
                callContext.value1 = obj;
                if (!(obj2 instanceof Char)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 8:
                if (!(obj instanceof Char)) {
                    return -786431;
                }
                callContext.value1 = obj;
                if (!(obj2 instanceof Char)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            default:
                return super.match2(moduleMethod, obj, obj2, callContext);
        }
    }

    public static boolean isChar$Ls(Char c1, Char c2) {
        return c1.intValue() < c2.intValue();
    }

    public static boolean isChar$Gr(Char c1, Char c2) {
        return c1.intValue() > c2.intValue();
    }

    public static boolean isChar$Ls$Eq(Char c1, Char c2) {
        return c1.intValue() <= c2.intValue();
    }

    public static boolean isChar$Gr$Eq(Char c1, Char c2) {
        return c1.intValue() >= c2.intValue();
    }

    public Object apply2(ModuleMethod moduleMethod, Object obj, Object obj2) {
        switch (moduleMethod.selector) {
            case 4:
                try {
                    try {
                        return isChar$Eq((Char) obj, (Char) obj2) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "char=?", 2, obj2);
                    }
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "char=?", 1, obj);
                }
            case 5:
                try {
                    try {
                        return isChar$Ls((Char) obj, (Char) obj2) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "char<?", 2, obj2);
                    }
                } catch (ClassCastException e4) {
                    throw new WrongType(e4, "char<?", 1, obj);
                }
            case 6:
                try {
                    try {
                        return isChar$Gr((Char) obj, (Char) obj2) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (ClassCastException e5) {
                        throw new WrongType(e5, "char>?", 2, obj2);
                    }
                } catch (ClassCastException e6) {
                    throw new WrongType(e6, "char>?", 1, obj);
                }
            case 7:
                try {
                    try {
                        return isChar$Ls$Eq((Char) obj, (Char) obj2) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (ClassCastException e7) {
                        throw new WrongType(e7, "char<=?", 2, obj2);
                    }
                } catch (ClassCastException e8) {
                    throw new WrongType(e8, "char<=?", 1, obj);
                }
            case 8:
                try {
                    try {
                        return isChar$Gr$Eq((Char) obj, (Char) obj2) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (ClassCastException e9) {
                        throw new WrongType(e9, "char>=?", 2, obj2);
                    }
                } catch (ClassCastException e10) {
                    throw new WrongType(e10, "char>=?", 1, obj);
                }
            default:
                return super.apply2(moduleMethod, obj, obj2);
        }
    }
}
