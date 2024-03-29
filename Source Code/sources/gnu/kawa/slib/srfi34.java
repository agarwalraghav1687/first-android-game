package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.standard.Scheme;

/* compiled from: srfi34.scm */
public class srfi34 extends ModuleBody {
    public static final Class $Prvt$$Lsraise$Mnobject$Mnexception$Gr = raise$Mnobject$Mnexception.class;
    public static final Macro $Prvt$guard$Mnaux = Macro.make(Lit4, Lit5, $instance);
    public static final srfi34 $instance = new srfi34();
    static final SimpleSymbol Lit0 = ((SimpleSymbol) new SimpleSymbol("with-exception-handler").readResolve());
    static final SimpleSymbol Lit1 = ((SimpleSymbol) new SimpleSymbol("raise").readResolve());
    static final SimpleSymbol Lit10 = ((SimpleSymbol) new SimpleSymbol("if").readResolve());
    static final SimpleSymbol Lit11 = ((SimpleSymbol) new SimpleSymbol("begin").readResolve());
    static final SimpleSymbol Lit12 = ((SimpleSymbol) new SimpleSymbol("ex").readResolve());
    static final SimpleSymbol Lit13 = ((SimpleSymbol) new SimpleSymbol("<raise-object-exception>").readResolve());
    static final SimpleSymbol Lit2;
    static final SyntaxRules Lit3;
    static final SimpleSymbol Lit4;
    static final SyntaxRules Lit5;
    static final SimpleSymbol Lit6 = ((SimpleSymbol) new SimpleSymbol("else").readResolve());
    static final SimpleSymbol Lit7 = ((SimpleSymbol) new SimpleSymbol("=>").readResolve());
    static final SimpleSymbol Lit8 = ((SimpleSymbol) new SimpleSymbol("temp").readResolve());
    static final SimpleSymbol Lit9 = ((SimpleSymbol) new SimpleSymbol("let").readResolve());
    public static final Macro guard = Macro.make(Lit2, Lit3, $instance);
    public static final ModuleMethod raise;
    public static final ModuleMethod with$Mnexception$Mnhandler;

    public srfi34() {
        ModuleInfo.register(this);
    }

    public final void run(CallContext $ctx) {
        Consumer consumer = $ctx.consumer;
    }

    static {
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol("guard-aux").readResolve();
        Lit4 = simpleSymbol;
        Object[] objArr = {Lit11};
        Object[] objArr2 = {Lit9, Lit8, Lit10, PairWithPosition.make(Lit8, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 274452)};
        Object[] objArr3 = {Lit9, Lit8, Lit10, PairWithPosition.make(Lit8, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 294932), Lit4};
        Lit5 = new SyntaxRules(new Object[]{simpleSymbol, Lit6, Lit7}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L\f\u0002\f\u000f\r\u0017\u0010\b\b\b", new Object[]{Lit6}, 3), "\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000b\b\u0015\u0013", objArr, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\f\u0002\f\u0017\b\b", new Object[]{Lit7}, 3), "\u0001\u0001\u0001", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u000b\b\u0011\u0018\u0014\u0011\u0018\f!\t\u0013\u0018\u001c\b\u0003", objArr2, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\f\u0002\f\u0017\b\f\u001f\r' \b\b", new Object[]{Lit7}, 5), "\u0001\u0001\u0001\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u000b\b\u0011\u0018\u0014\u0011\u0018\f!\t\u0013\u0018\u001c\b\u0011\u0018$\t\u0003\t\u001b\b%#", objArr3, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u001c\f\u000f\b\b", new Object[0], 2), "\u0001\u0001", "\u000b", new Object[0], 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u001c\f\u000f\b\f\u0017\r\u001f\u0018\b\b", new Object[0], 4), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u000b\b\u0011\u0018\u0014\u0011\u0018\f\u0011\u0018\f\b\u0011\u0018\u001c\t\u0003\t\u0013\b\u001d\u001b", new Object[]{Lit9, Lit8, Lit10, Lit4}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L\f\u000f\f\u0017\r\u001f\u0018\b\b\b", new Object[0], 4), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000bA\u0011\u0018\f\t\u0013\b\u001d\u001b\b\u0003", new Object[]{Lit10, Lit11}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L\f\u000f\f\u0017\r\u001f\u0018\b\b\f'\r/(\b\b", new Object[0], 6), "\u0001\u0001\u0001\u0003\u0001\u0003", "\u0011\u0018\u0004\t\u000bA\u0011\u0018\f\t\u0013\b\u001d\u001b\b\u0011\u0018\u0014\t\u0003\t#\b-+", new Object[]{Lit10, Lit11, Lit4}, 1)}, 6);
        SimpleSymbol simpleSymbol2 = (SimpleSymbol) new SimpleSymbol("guard").readResolve();
        Lit2 = simpleSymbol2;
        Object[] objArr4 = {simpleSymbol2};
        SimpleSymbol simpleSymbol3 = Lit10;
        PairWithPosition make = PairWithPosition.make((SimpleSymbol) new SimpleSymbol(GetNamedPart.INSTANCEOF_METHOD_NAME).readResolve(), PairWithPosition.make(Lit12, PairWithPosition.make(Lit13, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 110614), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 110611), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 110600);
        PairWithPosition pairWithPosition = make;
        SimpleSymbol simpleSymbol4 = simpleSymbol3;
        Lit3 = new SyntaxRules(objArr4, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", new Object[0], 3), "\u0001\u0000\u0000", "\u0011\u0018\u0004!\u0011\u0018\f\u0012\b\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$)\b\t\u0003\u0018,\b\u0011\u00184\u0011\u0018<\n", new Object[]{(SimpleSymbol) new SimpleSymbol("try-catch").readResolve(), Lit11, Lit12, (SimpleSymbol) new SimpleSymbol("<java.lang.Throwable>").readResolve(), Lit9, PairWithPosition.make(PairWithPosition.make(simpleSymbol4, PairWithPosition.make(pairWithPosition, PairWithPosition.make(PairWithPosition.make((SimpleSymbol) new SimpleSymbol("field").readResolve(), PairWithPosition.make(PairWithPosition.make((SimpleSymbol) new SimpleSymbol("as").readResolve(), PairWithPosition.make(Lit13, PairWithPosition.make(Lit12, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 114732), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 114707), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 114703), PairWithPosition.make(PairWithPosition.make((SimpleSymbol) new SimpleSymbol(LispLanguage.quote_sym).readResolve(), PairWithPosition.make((SimpleSymbol) new SimpleSymbol("value").readResolve(), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 114737), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 114737), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 114736), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 114703), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 114696), PairWithPosition.make(Lit12, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 118792), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 114696), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 110600), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 110596), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 110596), Lit4, PairWithPosition.make((SimpleSymbol) new SimpleSymbol("primitive-throw").readResolve(), PairWithPosition.make(Lit12, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 122914), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi34.scm", 122897)}, 0)}, 3);
        srfi34 srfi34 = $instance;
        with$Mnexception$Mnhandler = new ModuleMethod(srfi34, 1, Lit0, 8194);
        raise = new ModuleMethod(srfi34, 2, Lit1, 4097);
        $instance.run();
    }

    public static Object withExceptionHandler(Object handler, Object thunk) {
        try {
            return Scheme.applyToArgs.apply1(thunk);
        } catch (raise$Mnobject$Mnexception ex) {
            return Scheme.applyToArgs.apply2(handler, ex.value);
        } catch (Throwable ex2) {
            return Scheme.applyToArgs.apply2(handler, ex2);
        }
    }

    public Object apply2(ModuleMethod moduleMethod, Object obj, Object obj2) {
        return moduleMethod.selector == 1 ? withExceptionHandler(obj, obj2) : super.apply2(moduleMethod, obj, obj2);
    }

    public int match2(ModuleMethod moduleMethod, Object obj, Object obj2, CallContext callContext) {
        if (moduleMethod.selector != 1) {
            return super.match2(moduleMethod, obj, obj2, callContext);
        }
        callContext.value1 = obj;
        callContext.value2 = obj2;
        callContext.proc = moduleMethod;
        callContext.pc = 2;
        return 0;
    }

    public static void raise(Object obj) {
        throw new raise$Mnobject$Mnexception(obj);
    }

    public Object apply1(ModuleMethod moduleMethod, Object obj) {
        if (moduleMethod.selector != 2) {
            return super.apply1(moduleMethod, obj);
        }
        raise(obj);
        return Values.empty;
    }

    public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
        if (moduleMethod.selector != 2) {
            return super.match1(moduleMethod, obj, callContext);
        }
        callContext.value1 = obj;
        callContext.proc = moduleMethod;
        callContext.pc = 1;
        return 0;
    }
}
