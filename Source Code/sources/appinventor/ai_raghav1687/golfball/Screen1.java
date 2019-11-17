package appinventor.ai_raghav1687.golfball;

import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.Ball;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Canvas;
import com.google.appinventor.components.runtime.Clock;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.RetValManager;
import com.google.appinventor.components.runtime.util.RuntimeErrorAlert;
import com.google.appinventor.components.runtime.util.ScreenDensityUtil;
import com.google.youngandroid.runtime;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import kawa.lang.Promise;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.require;

/* compiled from: Screen1.yail */
public class Screen1 extends Form implements Runnable {
    static final SimpleSymbol Lit0 = ((SimpleSymbol) new SimpleSymbol("Screen1").readResolve());
    static final SimpleSymbol Lit1 = ((SimpleSymbol) new SimpleSymbol("getMessage").readResolve());
    static final SimpleSymbol Lit10 = ((SimpleSymbol) new SimpleSymbol("Label1").readResolve());
    static final SimpleSymbol Lit11 = ((SimpleSymbol) new SimpleSymbol("FontBold").readResolve());
    static final SimpleSymbol Lit12 = ((SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN).readResolve());
    static final SimpleSymbol Lit13 = ((SimpleSymbol) new SimpleSymbol("FontSize").readResolve());
    static final IntNum Lit14 = IntNum.make(15);
    static final SimpleSymbol Lit15 = ((SimpleSymbol) new SimpleSymbol("Text").readResolve());
    static final SimpleSymbol Lit16 = ((SimpleSymbol) new SimpleSymbol("Visible").readResolve());
    static final FString Lit17 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit18 = new FString("com.google.appinventor.components.runtime.Canvas");
    static final SimpleSymbol Lit19 = ((SimpleSymbol) new SimpleSymbol("Canvas1").readResolve());
    static final SimpleSymbol Lit2 = ((SimpleSymbol) new SimpleSymbol("*the-null-value*").readResolve());
    static final IntNum Lit20;
    static final SimpleSymbol Lit21 = ((SimpleSymbol) new SimpleSymbol("Height").readResolve());
    static final IntNum Lit22 = IntNum.make(-2);
    static final SimpleSymbol Lit23 = ((SimpleSymbol) new SimpleSymbol("Width").readResolve());
    static final SimpleSymbol Lit24 = ((SimpleSymbol) new SimpleSymbol("PaintColor").readResolve());
    static final IntNum Lit25;
    static final FString Lit26 = new FString("com.google.appinventor.components.runtime.Canvas");
    static final FString Lit27 = new FString("com.google.appinventor.components.runtime.Ball");
    static final SimpleSymbol Lit28 = ((SimpleSymbol) new SimpleSymbol("Ball1").readResolve());
    static final SimpleSymbol Lit29 = ((SimpleSymbol) new SimpleSymbol("Radius").readResolve());
    static final SimpleSymbol Lit3 = ((SimpleSymbol) new SimpleSymbol("AppName").readResolve());
    static final IntNum Lit30 = IntNum.make(25);
    static final SimpleSymbol Lit31 = ((SimpleSymbol) new SimpleSymbol("X").readResolve());
    static final IntNum Lit32 = IntNum.make(145);
    static final SimpleSymbol Lit33 = ((SimpleSymbol) new SimpleSymbol("Y").readResolve());
    static final IntNum Lit34 = IntNum.make(14);
    static final FString Lit35 = new FString("com.google.appinventor.components.runtime.Ball");
    static final FString Lit36 = new FString("com.google.appinventor.components.runtime.Ball");
    static final SimpleSymbol Lit37 = ((SimpleSymbol) new SimpleSymbol("golfball").readResolve());
    static final IntNum Lit38;
    static final IntNum Lit39 = IntNum.make(10);
    static final SimpleSymbol Lit4 = ((SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT).readResolve());
    static final IntNum Lit40 = IntNum.make(151);
    static final IntNum Lit41 = IntNum.make((int) ScreenDensityUtil.DEFAULT_NORMAL_SHORT_DIMENSION);
    static final FString Lit42 = new FString("com.google.appinventor.components.runtime.Ball");
    static final SimpleSymbol Lit43 = ((SimpleSymbol) new SimpleSymbol("Heading").readResolve());
    static final SimpleSymbol Lit44 = ((SimpleSymbol) new SimpleSymbol("$heading").readResolve());
    static final SimpleSymbol Lit45 = ((SimpleSymbol) new SimpleSymbol("Speed").readResolve());
    static final SimpleSymbol Lit46 = ((SimpleSymbol) new SimpleSymbol("$speed").readResolve());
    static final IntNum Lit47 = IntNum.make(20);
    static final PairWithPosition Lit48 = PairWithPosition.make(Lit7, PairWithPosition.make(Lit7, LList.Empty, "C:\\Users\\Welcome\\AppData\\Local\\Temp\\1502008749855_0.2744525446274698-0\\youngandroidproject\\..\\src\\appinventor\\ai_raghav1687\\golfball\\Screen1.yail", 270542), "C:\\Users\\Welcome\\AppData\\Local\\Temp\\1502008749855_0.2744525446274698-0\\youngandroidproject\\..\\src\\appinventor\\ai_raghav1687\\golfball\\Screen1.yail", 270534);
    static final SimpleSymbol Lit49 = ((SimpleSymbol) new SimpleSymbol("golfball$Flung").readResolve());
    static final SimpleSymbol Lit5 = ((SimpleSymbol) new SimpleSymbol("BackgroundColor").readResolve());
    static final SimpleSymbol Lit50 = ((SimpleSymbol) new SimpleSymbol("Flung").readResolve());
    static final SimpleSymbol Lit51 = ((SimpleSymbol) new SimpleSymbol("Bounce").readResolve());
    static final SimpleSymbol Lit52 = ((SimpleSymbol) new SimpleSymbol("$edge").readResolve());
    static final PairWithPosition Lit53 = PairWithPosition.make(Lit7, LList.Empty, "C:\\Users\\Welcome\\AppData\\Local\\Temp\\1502008749855_0.2744525446274698-0\\youngandroidproject\\..\\src\\appinventor\\ai_raghav1687\\golfball\\Screen1.yail", 278618);
    static final SimpleSymbol Lit54 = ((SimpleSymbol) new SimpleSymbol("golfball$EdgeReached").readResolve());
    static final SimpleSymbol Lit55 = ((SimpleSymbol) new SimpleSymbol("EdgeReached").readResolve());
    static final SimpleSymbol Lit56 = ((SimpleSymbol) new SimpleSymbol("$other").readResolve());
    static final PairWithPosition Lit57 = PairWithPosition.make(Lit99, PairWithPosition.make(Lit99, LList.Empty, "C:\\Users\\Welcome\\AppData\\Local\\Temp\\1502008749855_0.2744525446274698-0\\youngandroidproject\\..\\src\\appinventor\\ai_raghav1687\\golfball\\Screen1.yail", 286834), "C:\\Users\\Welcome\\AppData\\Local\\Temp\\1502008749855_0.2744525446274698-0\\youngandroidproject\\..\\src\\appinventor\\ai_raghav1687\\golfball\\Screen1.yail", 286829);
    static final IntNum Lit58 = IntNum.make(0);
    static final SimpleSymbol Lit59 = ((SimpleSymbol) new SimpleSymbol("golfball$CollidedWith").readResolve());
    static final IntNum Lit6;
    static final SimpleSymbol Lit60 = ((SimpleSymbol) new SimpleSymbol("CollidedWith").readResolve());
    static final FString Lit61 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit62 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement1").readResolve());
    static final SimpleSymbol Lit63 = ((SimpleSymbol) new SimpleSymbol("AlignHorizontal").readResolve());
    static final IntNum Lit64 = IntNum.make(3);
    static final SimpleSymbol Lit65 = ((SimpleSymbol) new SimpleSymbol("AlignVertical").readResolve());
    static final IntNum Lit66 = IntNum.make(2);
    static final IntNum Lit67;
    static final FString Lit68 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit69 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit70 = ((SimpleSymbol) new SimpleSymbol("reset").readResolve());
    static final FString Lit71 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit72 = ((SimpleSymbol) new SimpleSymbol("MoveTo").readResolve());
    static final PairWithPosition Lit73 = PairWithPosition.make(Lit7, PairWithPosition.make(Lit7, LList.Empty, "C:\\Users\\Welcome\\AppData\\Local\\Temp\\1502008749855_0.2744525446274698-0\\youngandroidproject\\..\\src\\appinventor\\ai_raghav1687\\golfball\\Screen1.yail", 376917), "C:\\Users\\Welcome\\AppData\\Local\\Temp\\1502008749855_0.2744525446274698-0\\youngandroidproject\\..\\src\\appinventor\\ai_raghav1687\\golfball\\Screen1.yail", 376909);
    static final SimpleSymbol Lit74 = ((SimpleSymbol) new SimpleSymbol("reset$Click").readResolve());
    static final SimpleSymbol Lit75 = ((SimpleSymbol) new SimpleSymbol("Click").readResolve());
    static final FString Lit76 = new FString("com.google.appinventor.components.runtime.Clock");
    static final SimpleSymbol Lit77 = ((SimpleSymbol) new SimpleSymbol("clock").readResolve());
    static final SimpleSymbol Lit78 = ((SimpleSymbol) new SimpleSymbol("TimerInterval").readResolve());
    static final IntNum Lit79 = IntNum.make(100);
    static final SimpleSymbol Lit8 = ((SimpleSymbol) new SimpleSymbol("Title").readResolve());
    static final FString Lit80 = new FString("com.google.appinventor.components.runtime.Clock");
    static final DFloNum Lit81 = DFloNum.make(0.7d);
    static final PairWithPosition Lit82 = PairWithPosition.make(Lit7, PairWithPosition.make(Lit7, LList.Empty, "C:\\Users\\Welcome\\AppData\\Local\\Temp\\1502008749855_0.2744525446274698-0\\youngandroidproject\\..\\src\\appinventor\\ai_raghav1687\\golfball\\Screen1.yail", 413795), "C:\\Users\\Welcome\\AppData\\Local\\Temp\\1502008749855_0.2744525446274698-0\\youngandroidproject\\..\\src\\appinventor\\ai_raghav1687\\golfball\\Screen1.yail", 413787);
    static final DFloNum Lit83 = DFloNum.make(0.5d);
    static final PairWithPosition Lit84;
    static final SimpleSymbol Lit85 = ((SimpleSymbol) new SimpleSymbol("clock$Timer").readResolve());
    static final SimpleSymbol Lit86 = ((SimpleSymbol) new SimpleSymbol("Timer").readResolve());
    static final SimpleSymbol Lit87 = ((SimpleSymbol) new SimpleSymbol("android-log-form").readResolve());
    static final SimpleSymbol Lit88 = ((SimpleSymbol) new SimpleSymbol("add-to-form-environment").readResolve());
    static final SimpleSymbol Lit89 = ((SimpleSymbol) new SimpleSymbol("lookup-in-form-environment").readResolve());
    static final FString Lit9 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit90 = ((SimpleSymbol) new SimpleSymbol("is-bound-in-form-environment").readResolve());
    static final SimpleSymbol Lit91 = ((SimpleSymbol) new SimpleSymbol("add-to-global-var-environment").readResolve());
    static final SimpleSymbol Lit92 = ((SimpleSymbol) new SimpleSymbol("add-to-events").readResolve());
    static final SimpleSymbol Lit93 = ((SimpleSymbol) new SimpleSymbol("add-to-components").readResolve());
    static final SimpleSymbol Lit94 = ((SimpleSymbol) new SimpleSymbol("add-to-global-vars").readResolve());
    static final SimpleSymbol Lit95 = ((SimpleSymbol) new SimpleSymbol("add-to-form-do-after-creation").readResolve());
    static final SimpleSymbol Lit96 = ((SimpleSymbol) new SimpleSymbol("send-error").readResolve());
    static final SimpleSymbol Lit97 = ((SimpleSymbol) new SimpleSymbol("dispatchEvent").readResolve());
    static final SimpleSymbol Lit98 = ((SimpleSymbol) new SimpleSymbol("lookup-handler").readResolve());
    static final SimpleSymbol Lit99 = ((SimpleSymbol) new SimpleSymbol("any").readResolve());
    public static Screen1 Screen1;
    static final ModuleMethod lambda$Fn1 = null;
    static final ModuleMethod lambda$Fn10 = null;
    static final ModuleMethod lambda$Fn11 = null;
    static final ModuleMethod lambda$Fn12 = null;
    static final ModuleMethod lambda$Fn13 = null;
    static final ModuleMethod lambda$Fn14 = null;
    static final ModuleMethod lambda$Fn15 = null;
    static final ModuleMethod lambda$Fn16 = null;
    static final ModuleMethod lambda$Fn2 = null;
    static final ModuleMethod lambda$Fn3 = null;
    static final ModuleMethod lambda$Fn4 = null;
    static final ModuleMethod lambda$Fn5 = null;
    static final ModuleMethod lambda$Fn6 = null;
    static final ModuleMethod lambda$Fn7 = null;
    static final ModuleMethod lambda$Fn8 = null;
    static final ModuleMethod lambda$Fn9 = null;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public Ball Ball1;
    public Canvas Canvas1;
    public HorizontalArrangement HorizontalArrangement1;
    public Label Label1;
    public final ModuleMethod add$Mnto$Mncomponents;
    public final ModuleMethod add$Mnto$Mnevents;
    public final ModuleMethod add$Mnto$Mnform$Mndo$Mnafter$Mncreation;
    public final ModuleMethod add$Mnto$Mnform$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvar$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvars;
    public final ModuleMethod android$Mnlog$Mnform;
    public Clock clock;
    public final ModuleMethod clock$Timer;
    public LList components$Mnto$Mncreate;
    public final ModuleMethod dispatchEvent;
    public LList events$Mnto$Mnregister;
    public LList form$Mndo$Mnafter$Mncreation;
    public Environment form$Mnenvironment;
    public Symbol form$Mnname$Mnsymbol;
    public Environment global$Mnvar$Mnenvironment;
    public LList global$Mnvars$Mnto$Mncreate;
    public Ball golfball;
    public final ModuleMethod golfball$CollidedWith;
    public final ModuleMethod golfball$EdgeReached;
    public final ModuleMethod golfball$Flung;
    public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod lookup$Mnhandler;
    public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod process$Mnexception;
    public Button reset;
    public final ModuleMethod reset$Click;
    public final ModuleMethod send$Mnerror;

    /* compiled from: Screen1.yail */
    public class frame extends ModuleBody {
        Screen1 $main = this;

        public Object applyN(ModuleMethod moduleMethod, Object[] objArr) {
            return moduleMethod.selector == 26 ? this.$main.golfball$Flung(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]) : super.applyN(moduleMethod, objArr);
        }

        public int matchN(ModuleMethod moduleMethod, Object[] objArr, CallContext callContext) {
            if (moduleMethod.selector != 26) {
                return super.matchN(moduleMethod, objArr, callContext);
            }
            callContext.values = objArr;
            callContext.proc = moduleMethod;
            callContext.pc = 5;
            return 0;
        }

        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 1:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 3:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 5:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 10:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 11:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 12:
                    if (!(obj instanceof Screen1)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 27:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 28:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                default:
                    return super.match1(moduleMethod, obj, callContext);
            }
        }

        public int match2(ModuleMethod moduleMethod, Object obj, Object obj2, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 2:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 3:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 6:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 7:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 9:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 14:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                default:
                    return super.match2(moduleMethod, obj, obj2, callContext);
            }
        }

        public int match4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 8:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.value3 = obj3;
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                case 13:
                    if (!(obj instanceof Screen1)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    if (!(obj2 instanceof Component)) {
                        return -786430;
                    }
                    callContext.value2 = obj2;
                    if (!(obj3 instanceof String)) {
                        return -786429;
                    }
                    callContext.value3 = obj3;
                    if (!(obj4 instanceof String)) {
                        return -786428;
                    }
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                default:
                    return super.match4(moduleMethod, obj, obj2, obj3, obj4, callContext);
            }
        }

        public Object apply1(ModuleMethod moduleMethod, Object obj) {
            switch (moduleMethod.selector) {
                case 1:
                    this.$main.androidLogForm(obj);
                    return Values.empty;
                case 3:
                    try {
                        return this.$main.lookupInFormEnvironment((Symbol) obj);
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "lookup-in-form-environment", 1, obj);
                    }
                case 5:
                    try {
                        return this.$main.isBoundInFormEnvironment((Symbol) obj) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "is-bound-in-form-environment", 1, obj);
                    }
                case 10:
                    this.$main.addToFormDoAfterCreation(obj);
                    return Values.empty;
                case 11:
                    this.$main.sendError(obj);
                    return Values.empty;
                case 12:
                    this.$main.processException(obj);
                    return Values.empty;
                case 27:
                    return this.$main.golfball$EdgeReached(obj);
                case 28:
                    return this.$main.golfball$CollidedWith(obj);
                default:
                    return super.apply1(moduleMethod, obj);
            }
        }

        public Object apply4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4) {
            switch (moduleMethod.selector) {
                case 8:
                    this.$main.addToComponents(obj, obj2, obj3, obj4);
                    return Values.empty;
                case 13:
                    try {
                        try {
                            try {
                                try {
                                    return this.$main.dispatchEvent((Component) obj, (String) obj2, (String) obj3, (Object[]) obj4) ? Boolean.TRUE : Boolean.FALSE;
                                } catch (ClassCastException e) {
                                    throw new WrongType(e, "dispatchEvent", 4, obj4);
                                }
                            } catch (ClassCastException e2) {
                                throw new WrongType(e2, "dispatchEvent", 3, obj3);
                            }
                        } catch (ClassCastException e3) {
                            throw new WrongType(e3, "dispatchEvent", 2, obj2);
                        }
                    } catch (ClassCastException e4) {
                        throw new WrongType(e4, "dispatchEvent", 1, obj);
                    }
                default:
                    return super.apply4(moduleMethod, obj, obj2, obj3, obj4);
            }
        }

        public Object apply2(ModuleMethod moduleMethod, Object obj, Object obj2) {
            switch (moduleMethod.selector) {
                case 2:
                    try {
                        this.$main.addToFormEnvironment((Symbol) obj, obj2);
                        return Values.empty;
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "add-to-form-environment", 1, obj);
                    }
                case 3:
                    try {
                        return this.$main.lookupInFormEnvironment((Symbol) obj, obj2);
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "lookup-in-form-environment", 1, obj);
                    }
                case 6:
                    try {
                        this.$main.addToGlobalVarEnvironment((Symbol) obj, obj2);
                        return Values.empty;
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "add-to-global-var-environment", 1, obj);
                    }
                case 7:
                    this.$main.addToEvents(obj, obj2);
                    return Values.empty;
                case 9:
                    this.$main.addToGlobalVars(obj, obj2);
                    return Values.empty;
                case 14:
                    return this.$main.lookupHandler(obj, obj2);
                default:
                    return super.apply2(moduleMethod, obj, obj2);
            }
        }

        public Object apply0(ModuleMethod moduleMethod) {
            switch (moduleMethod.selector) {
                case 15:
                    return Screen1.lambda2();
                case 16:
                    this.$main.$define();
                    return Values.empty;
                case 17:
                    return Screen1.lambda3();
                case 18:
                    return Screen1.lambda4();
                case 19:
                    return Screen1.lambda5();
                case 20:
                    return Screen1.lambda6();
                case 21:
                    return Screen1.lambda7();
                case 22:
                    return Screen1.lambda8();
                case 23:
                    return Screen1.lambda9();
                case 24:
                    return Screen1.lambda10();
                case 25:
                    return Screen1.lambda11();
                case 29:
                    return Screen1.lambda12();
                case 30:
                    return Screen1.lambda13();
                case 31:
                    return Screen1.lambda14();
                case 32:
                    return Screen1.lambda15();
                case 33:
                    return this.$main.reset$Click();
                case 34:
                    return Screen1.lambda16();
                case 35:
                    return Screen1.lambda17();
                case 36:
                    return this.$main.clock$Timer();
                default:
                    return super.apply0(moduleMethod);
            }
        }

        public int match0(ModuleMethod moduleMethod, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 15:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 16:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 17:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 18:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 19:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 20:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 21:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 22:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 23:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 24:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 25:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 29:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 30:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 31:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 32:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 33:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 34:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 35:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 36:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                default:
                    return super.match0(moduleMethod, callContext);
            }
        }
    }

    static {
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol("number").readResolve();
        Lit7 = simpleSymbol;
        Lit84 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(Lit7, LList.Empty, "C:\\Users\\Welcome\\AppData\\Local\\Temp\\1502008749855_0.2744525446274698-0\\youngandroidproject\\..\\src\\appinventor\\ai_raghav1687\\golfball\\Screen1.yail", 413950), "C:\\Users\\Welcome\\AppData\\Local\\Temp\\1502008749855_0.2744525446274698-0\\youngandroidproject\\..\\src\\appinventor\\ai_raghav1687\\golfball\\Screen1.yail", 413942);
        int[] iArr = new int[2];
        iArr[0] = -16711936;
        Lit67 = IntNum.make(iArr);
        int[] iArr2 = new int[2];
        iArr2[0] = -1;
        Lit38 = IntNum.make(iArr2);
        int[] iArr3 = new int[2];
        iArr3[0] = -16711936;
        Lit25 = IntNum.make(iArr3);
        int[] iArr4 = new int[2];
        iArr4[0] = -16711936;
        Lit20 = IntNum.make(iArr4);
        int[] iArr5 = new int[2];
        iArr5[0] = -16711936;
        Lit6 = IntNum.make(iArr5);
    }

    public Screen1() {
        ModuleInfo.register(this);
        frame frame2 = new frame();
        this.android$Mnlog$Mnform = new ModuleMethod(frame2, 1, Lit87, 4097);
        this.add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frame2, 2, Lit88, 8194);
        this.lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 3, Lit89, 8193);
        this.is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 5, Lit90, 4097);
        this.add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frame2, 6, Lit91, 8194);
        this.add$Mnto$Mnevents = new ModuleMethod(frame2, 7, Lit92, 8194);
        this.add$Mnto$Mncomponents = new ModuleMethod(frame2, 8, Lit93, 16388);
        this.add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frame2, 9, Lit94, 8194);
        this.add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frame2, 10, Lit95, 4097);
        this.send$Mnerror = new ModuleMethod(frame2, 11, Lit96, 4097);
        this.process$Mnexception = new ModuleMethod(frame2, 12, "process-exception", 4097);
        this.dispatchEvent = new ModuleMethod(frame2, 13, Lit97, 16388);
        this.lookup$Mnhandler = new ModuleMethod(frame2, 14, Lit98, 8194);
        ModuleMethod moduleMethod = new ModuleMethod(frame2, 15, null, 0);
        moduleMethod.setProperty("source-location", "C:\\Users\\Welcome\\AppData\\Local\\Temp\\runtime4458448524167429231.scm:552");
        lambda$Fn1 = moduleMethod;
        this.$define = new ModuleMethod(frame2, 16, "$define", 0);
        lambda$Fn2 = new ModuleMethod(frame2, 17, null, 0);
        lambda$Fn3 = new ModuleMethod(frame2, 18, null, 0);
        lambda$Fn4 = new ModuleMethod(frame2, 19, null, 0);
        lambda$Fn5 = new ModuleMethod(frame2, 20, null, 0);
        lambda$Fn6 = new ModuleMethod(frame2, 21, null, 0);
        lambda$Fn7 = new ModuleMethod(frame2, 22, null, 0);
        lambda$Fn8 = new ModuleMethod(frame2, 23, null, 0);
        lambda$Fn9 = new ModuleMethod(frame2, 24, null, 0);
        lambda$Fn10 = new ModuleMethod(frame2, 25, null, 0);
        this.golfball$Flung = new ModuleMethod(frame2, 26, Lit49, 24582);
        this.golfball$EdgeReached = new ModuleMethod(frame2, 27, Lit54, 4097);
        this.golfball$CollidedWith = new ModuleMethod(frame2, 28, Lit59, 4097);
        lambda$Fn11 = new ModuleMethod(frame2, 29, null, 0);
        lambda$Fn12 = new ModuleMethod(frame2, 30, null, 0);
        lambda$Fn13 = new ModuleMethod(frame2, 31, null, 0);
        lambda$Fn14 = new ModuleMethod(frame2, 32, null, 0);
        this.reset$Click = new ModuleMethod(frame2, 33, Lit74, 0);
        lambda$Fn15 = new ModuleMethod(frame2, 34, null, 0);
        lambda$Fn16 = new ModuleMethod(frame2, 35, null, 0);
        this.clock$Timer = new ModuleMethod(frame2, 36, Lit85, 0);
    }

    public Object lookupInFormEnvironment(Symbol symbol) {
        return lookupInFormEnvironment(symbol, Boolean.FALSE);
    }

    public void run() {
        CallContext instance = CallContext.getInstance();
        Consumer consumer = instance.consumer;
        instance.consumer = VoidConsumer.instance;
        try {
            run(instance);
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        ModuleBody.runCleanup(instance, th, consumer);
    }

    public final void run(CallContext $ctx) {
        String obj;
        Consumer $result = $ctx.consumer;
        Object find = require.find("com.google.youngandroid.runtime");
        try {
            ((Runnable) find).run();
            this.$Stdebug$Mnform$St = Boolean.FALSE;
            this.form$Mnenvironment = Environment.make(misc.symbol$To$String(Lit0));
            FString stringAppend = strings.stringAppend(misc.symbol$To$String(Lit0), "-global-vars");
            if (stringAppend == null) {
                obj = null;
            } else {
                obj = stringAppend.toString();
            }
            this.global$Mnvar$Mnenvironment = Environment.make(obj);
            Screen1 = null;
            this.form$Mnname$Mnsymbol = Lit0;
            this.events$Mnto$Mnregister = LList.Empty;
            this.components$Mnto$Mncreate = LList.Empty;
            this.global$Mnvars$Mnto$Mncreate = LList.Empty;
            this.form$Mndo$Mnafter$Mncreation = LList.Empty;
            Object find2 = require.find("com.google.youngandroid.runtime");
            try {
                ((Runnable) find2).run();
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit3, "golfball", Lit4);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit5, Lit6, Lit7);
                    Values.writeValues(runtime.setAndCoerceProperty$Ex(Lit0, Lit8, "Screen1", Lit4), $result);
                } else {
                    addToFormDoAfterCreation(new Promise(lambda$Fn2));
                }
                this.Label1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit9, Lit10, lambda$Fn3), $result);
                } else {
                    addToComponents(Lit0, Lit17, Lit10, lambda$Fn4);
                }
                this.Canvas1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit18, Lit19, lambda$Fn5), $result);
                } else {
                    addToComponents(Lit0, Lit26, Lit19, lambda$Fn6);
                }
                this.Ball1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit19, Lit27, Lit28, lambda$Fn7), $result);
                } else {
                    addToComponents(Lit19, Lit35, Lit28, lambda$Fn8);
                }
                this.golfball = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit19, Lit36, Lit37, lambda$Fn9), $result);
                } else {
                    addToComponents(Lit19, Lit42, Lit37, lambda$Fn10);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit49, this.golfball$Flung);
                } else {
                    addToFormEnvironment(Lit49, this.golfball$Flung);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "golfball", "Flung");
                } else {
                    addToEvents(Lit37, Lit50);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit54, this.golfball$EdgeReached);
                } else {
                    addToFormEnvironment(Lit54, this.golfball$EdgeReached);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "golfball", "EdgeReached");
                } else {
                    addToEvents(Lit37, Lit55);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit59, this.golfball$CollidedWith);
                } else {
                    addToFormEnvironment(Lit59, this.golfball$CollidedWith);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "golfball", "CollidedWith");
                } else {
                    addToEvents(Lit37, Lit60);
                }
                this.HorizontalArrangement1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit61, Lit62, lambda$Fn11), $result);
                } else {
                    addToComponents(Lit0, Lit68, Lit62, lambda$Fn12);
                }
                this.reset = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit62, Lit69, Lit70, lambda$Fn13), $result);
                } else {
                    addToComponents(Lit62, Lit71, Lit70, lambda$Fn14);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit74, this.reset$Click);
                } else {
                    addToFormEnvironment(Lit74, this.reset$Click);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "reset", "Click");
                } else {
                    addToEvents(Lit70, Lit75);
                }
                this.clock = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit76, Lit77, lambda$Fn15), $result);
                } else {
                    addToComponents(Lit0, Lit80, Lit77, lambda$Fn16);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit85, this.clock$Timer);
                } else {
                    addToFormEnvironment(Lit85, this.clock$Timer);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "clock", "Timer");
                } else {
                    addToEvents(Lit77, Lit86);
                }
                runtime.initRuntime();
            } catch (ClassCastException e) {
                throw new WrongType(e, "java.lang.Runnable.run()", 1, find2);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "java.lang.Runnable.run()", 1, find);
        }
    }

    static Object lambda3() {
        runtime.setAndCoerceProperty$Ex(Lit0, Lit3, "golfball", Lit4);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit5, Lit6, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit0, Lit8, "Screen1", Lit4);
    }

    static Object lambda4() {
        runtime.setAndCoerceProperty$Ex(Lit10, Lit11, Boolean.TRUE, Lit12);
        runtime.setAndCoerceProperty$Ex(Lit10, Lit13, Lit14, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit10, Lit15, "Good job", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit10, Lit16, Boolean.FALSE, Lit12);
    }

    static Object lambda5() {
        runtime.setAndCoerceProperty$Ex(Lit10, Lit11, Boolean.TRUE, Lit12);
        runtime.setAndCoerceProperty$Ex(Lit10, Lit13, Lit14, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit10, Lit15, "Good job", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit10, Lit16, Boolean.FALSE, Lit12);
    }

    static Object lambda6() {
        runtime.setAndCoerceProperty$Ex(Lit19, Lit5, Lit20, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit21, Lit22, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit23, Lit22, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit19, Lit24, Lit25, Lit7);
    }

    static Object lambda7() {
        runtime.setAndCoerceProperty$Ex(Lit19, Lit5, Lit20, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit21, Lit22, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit23, Lit22, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit19, Lit24, Lit25, Lit7);
    }

    static Object lambda8() {
        runtime.setAndCoerceProperty$Ex(Lit28, Lit29, Lit30, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit28, Lit31, Lit32, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit28, Lit33, Lit34, Lit7);
    }

    static Object lambda9() {
        runtime.setAndCoerceProperty$Ex(Lit28, Lit29, Lit30, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit28, Lit31, Lit32, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit28, Lit33, Lit34, Lit7);
    }

    static Object lambda10() {
        runtime.setAndCoerceProperty$Ex(Lit37, Lit24, Lit38, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit37, Lit29, Lit39, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit37, Lit31, Lit40, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit37, Lit33, Lit41, Lit7);
    }

    static Object lambda11() {
        runtime.setAndCoerceProperty$Ex(Lit37, Lit24, Lit38, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit37, Lit29, Lit39, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit37, Lit31, Lit40, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit37, Lit33, Lit41, Lit7);
    }

    public Object golfball$Flung(Object $x, Object $y, Object $speed, Object $heading, Object $xvel, Object $yvel) {
        runtime.sanitizeComponentData($x);
        runtime.sanitizeComponentData($y);
        Object $speed2 = runtime.sanitizeComponentData($speed);
        Object $heading2 = runtime.sanitizeComponentData($heading);
        runtime.sanitizeComponentData($xvel);
        runtime.sanitizeComponentData($yvel);
        runtime.setThisForm();
        SimpleSymbol simpleSymbol = Lit37;
        SimpleSymbol simpleSymbol2 = Lit43;
        if ($heading2 instanceof Package) {
            $heading2 = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit44), " is not bound in the current context"), "Unbound Variable");
        }
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, $heading2, Lit7);
        SimpleSymbol simpleSymbol3 = Lit37;
        SimpleSymbol simpleSymbol4 = Lit45;
        AddOp addOp = AddOp.$Pl;
        if ($speed2 instanceof Package) {
            $speed2 = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit46), " is not bound in the current context"), "Unbound Variable");
        }
        return runtime.setAndCoerceProperty$Ex(simpleSymbol3, simpleSymbol4, runtime.callYailPrimitive(addOp, LList.list2($speed2, Lit47), Lit48, "+"), Lit7);
    }

    public Object golfball$EdgeReached(Object $edge) {
        Object $edge2 = runtime.sanitizeComponentData($edge);
        runtime.setThisForm();
        SimpleSymbol simpleSymbol = Lit37;
        SimpleSymbol simpleSymbol2 = Lit51;
        if ($edge2 instanceof Package) {
            $edge2 = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit52), " is not bound in the current context"), "Unbound Variable");
        }
        return runtime.callComponentMethod(simpleSymbol, simpleSymbol2, LList.list1($edge2), Lit53);
    }

    public Object golfball$CollidedWith(Object $other) {
        Object $other2 = runtime.sanitizeComponentData($other);
        runtime.setThisForm();
        ModuleMethod moduleMethod = runtime.yail$Mnequal$Qu;
        if ($other2 instanceof Package) {
            $other2 = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit56), " is not bound in the current context"), "Unbound Variable");
        }
        if (runtime.callYailPrimitive(moduleMethod, LList.list2($other2, runtime.lookupInCurrentFormEnvironment(Lit28)), Lit57, "=") == Boolean.FALSE) {
            return Values.empty;
        }
        runtime.setAndCoerceProperty$Ex(Lit37, Lit45, Lit58, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit37, Lit16, Boolean.FALSE, Lit12);
        return runtime.setAndCoerceProperty$Ex(Lit10, Lit16, Boolean.TRUE, Lit12);
    }

    static Object lambda12() {
        runtime.setAndCoerceProperty$Ex(Lit62, Lit63, Lit64, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit62, Lit65, Lit66, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit62, Lit5, Lit67, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit62, Lit23, Lit22, Lit7);
    }

    static Object lambda13() {
        runtime.setAndCoerceProperty$Ex(Lit62, Lit63, Lit64, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit62, Lit65, Lit66, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit62, Lit5, Lit67, Lit7);
        return runtime.setAndCoerceProperty$Ex(Lit62, Lit23, Lit22, Lit7);
    }

    static Object lambda14() {
        return runtime.setAndCoerceProperty$Ex(Lit70, Lit15, "Reset", Lit4);
    }

    static Object lambda15() {
        return runtime.setAndCoerceProperty$Ex(Lit70, Lit15, "Reset", Lit4);
    }

    public Object reset$Click() {
        runtime.setThisForm();
        runtime.callComponentMethod(Lit37, Lit72, LList.list2(Lit40, Lit41), Lit73);
        runtime.setAndCoerceProperty$Ex(Lit37, Lit45, Lit58, Lit7);
        runtime.setAndCoerceProperty$Ex(Lit37, Lit16, Boolean.TRUE, Lit12);
        return runtime.setAndCoerceProperty$Ex(Lit10, Lit16, Boolean.FALSE, Lit12);
    }

    static Object lambda16() {
        return runtime.setAndCoerceProperty$Ex(Lit77, Lit78, Lit79, Lit7);
    }

    static Object lambda17() {
        return runtime.setAndCoerceProperty$Ex(Lit77, Lit78, Lit79, Lit7);
    }

    public Object clock$Timer() {
        runtime.setThisForm();
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.getProperty$1(Lit37, Lit45), Lit81), Lit82, ">=") != Boolean.FALSE ? runtime.setAndCoerceProperty$Ex(Lit37, Lit45, runtime.callYailPrimitive(AddOp.$Mn, LList.list2(runtime.getProperty$1(Lit37, Lit45), Lit83), Lit84, "-"), Lit7) : runtime.setAndCoerceProperty$Ex(Lit37, Lit45, Lit58, Lit7);
    }

    public void androidLogForm(Object message) {
    }

    public void addToFormEnvironment(Symbol name, Object object) {
        androidLogForm(Format.formatToString(0, "Adding ~A to env ~A with value ~A", name, this.form$Mnenvironment, object));
        this.form$Mnenvironment.put(name, object);
    }

    public Object lookupInFormEnvironment(Symbol name, Object default$Mnvalue) {
        boolean x = ((this.form$Mnenvironment == null ? 1 : 0) + 1) & true;
        if (x) {
            if (!this.form$Mnenvironment.isBound(name)) {
                return default$Mnvalue;
            }
        } else if (!x) {
            return default$Mnvalue;
        }
        return this.form$Mnenvironment.get(name);
    }

    public boolean isBoundInFormEnvironment(Symbol name) {
        return this.form$Mnenvironment.isBound(name);
    }

    public void addToGlobalVarEnvironment(Symbol name, Object object) {
        androidLogForm(Format.formatToString(0, "Adding ~A to env ~A with value ~A", name, this.global$Mnvar$Mnenvironment, object));
        this.global$Mnvar$Mnenvironment.put(name, object);
    }

    public void addToEvents(Object component$Mnname, Object event$Mnname) {
        this.events$Mnto$Mnregister = lists.cons(lists.cons(component$Mnname, event$Mnname), this.events$Mnto$Mnregister);
    }

    public void addToComponents(Object container$Mnname, Object component$Mntype, Object component$Mnname, Object init$Mnthunk) {
        this.components$Mnto$Mncreate = lists.cons(LList.list4(container$Mnname, component$Mntype, component$Mnname, init$Mnthunk), this.components$Mnto$Mncreate);
    }

    public void addToGlobalVars(Object var, Object val$Mnthunk) {
        this.global$Mnvars$Mnto$Mncreate = lists.cons(LList.list2(var, val$Mnthunk), this.global$Mnvars$Mnto$Mncreate);
    }

    public void addToFormDoAfterCreation(Object thunk) {
        this.form$Mndo$Mnafter$Mncreation = lists.cons(thunk, this.form$Mndo$Mnafter$Mncreation);
    }

    public void sendError(Object error) {
        RetValManager.sendError(error == null ? null : error.toString());
    }

    public void processException(Object ex) {
        Object apply1 = Scheme.applyToArgs.apply1(GetNamedPart.getNamedPart.apply2(ex, Lit1));
        RuntimeErrorAlert.alert(this, apply1 == null ? null : apply1.toString(), ex instanceof YailRuntimeError ? ((YailRuntimeError) ex).getErrorType() : "Runtime Error", "End Application");
    }

    public boolean dispatchEvent(Component componentObject, String registeredComponentName, String eventName, Object[] args) {
        SimpleSymbol registeredObject = misc.string$To$Symbol(registeredComponentName);
        if (!isBoundInFormEnvironment(registeredObject)) {
            EventDispatcher.unregisterEventForDelegation(this, registeredComponentName, eventName);
            return false;
        } else if (lookupInFormEnvironment(registeredObject) != componentObject) {
            return false;
        } else {
            try {
                Scheme.apply.apply2(lookupHandler(registeredComponentName, eventName), LList.makeList(args, 0));
                return true;
            } catch (Throwable exception) {
                androidLogForm(exception.getMessage());
                exception.printStackTrace();
                processException(exception);
                return false;
            }
        }
    }

    public Object lookupHandler(Object componentName, Object eventName) {
        String str = null;
        String obj = componentName == null ? null : componentName.toString();
        if (eventName != null) {
            str = eventName.toString();
        }
        return lookupInFormEnvironment(misc.string$To$Symbol(EventDispatcher.makeFullEventName(obj, str)));
    }

    public void $define() {
        Object reverse;
        Object reverse2;
        Object obj;
        Object obj2;
        Object obj3;
        Object component$Mnname;
        Object obj4;
        Object var;
        Language.setDefaults(Scheme.getInstance());
        try {
            run();
        } catch (Exception exception) {
            androidLogForm(exception.getMessage());
            processException(exception);
        }
        Screen1 = this;
        addToFormEnvironment(Lit0, this);
        Object obj5 = this.events$Mnto$Mnregister;
        while (obj5 != LList.Empty) {
            try {
                Pair arg0 = (Pair) obj5;
                Object event$Mninfo = arg0.getCar();
                Object apply1 = lists.car.apply1(event$Mninfo);
                String obj6 = apply1 == null ? null : apply1.toString();
                Object apply12 = lists.cdr.apply1(event$Mninfo);
                EventDispatcher.registerEventForDelegation(this, obj6, apply12 == null ? null : apply12.toString());
                obj5 = arg0.getCdr();
            } catch (ClassCastException e) {
                WrongType wrongType = new WrongType(e, "arg0", -2, obj5);
                throw wrongType;
            }
        }
        try {
            addToGlobalVars(Lit2, lambda$Fn1);
            reverse = lists.reverse(this.global$Mnvars$Mnto$Mncreate);
            while (reverse != LList.Empty) {
                Pair arg02 = (Pair) reverse;
                Object var$Mnval = arg02.getCar();
                var = lists.car.apply1(var$Mnval);
                addToGlobalVarEnvironment((Symbol) var, Scheme.applyToArgs.apply1(lists.cadr.apply1(var$Mnval)));
                reverse = arg02.getCdr();
            }
            reverse2 = lists.reverse(this.form$Mndo$Mnafter$Mncreation);
            while (reverse2 != LList.Empty) {
                Pair arg03 = (Pair) reverse2;
                misc.force(arg03.getCar());
                reverse2 = arg03.getCdr();
            }
            Object reverse3 = lists.reverse(this.components$Mnto$Mncreate);
            obj = reverse3;
            while (obj != LList.Empty) {
                Pair arg04 = (Pair) obj;
                Object component$Mninfo = arg04.getCar();
                component$Mnname = lists.caddr.apply1(component$Mninfo);
                lists.cadddr.apply1(component$Mninfo);
                Object component$Mnobject = Invoke.make.apply2(lists.cadr.apply1(component$Mninfo), lookupInFormEnvironment((Symbol) lists.car.apply1(component$Mninfo)));
                SlotSet.set$Mnfield$Ex.apply3(this, component$Mnname, component$Mnobject);
                addToFormEnvironment((Symbol) component$Mnname, component$Mnobject);
                obj = arg04.getCdr();
            }
            obj2 = reverse3;
            while (obj2 != LList.Empty) {
                Pair arg05 = (Pair) obj2;
                Object component$Mninfo2 = arg05.getCar();
                lists.caddr.apply1(component$Mninfo2);
                Object init$Mnthunk = lists.cadddr.apply1(component$Mninfo2);
                if (init$Mnthunk != Boolean.FALSE) {
                    Scheme.applyToArgs.apply1(init$Mnthunk);
                }
                obj2 = arg05.getCdr();
            }
            obj3 = reverse3;
            while (obj3 != LList.Empty) {
                Pair arg06 = (Pair) obj3;
                Object component$Mninfo3 = arg06.getCar();
                Object component$Mnname2 = lists.caddr.apply1(component$Mninfo3);
                lists.cadddr.apply1(component$Mninfo3);
                callInitialize(SlotGet.field.apply2(this, component$Mnname2));
                obj3 = arg06.getCdr();
            }
        } catch (ClassCastException e2) {
            WrongType wrongType2 = new WrongType(e2, "arg0", -2, obj3);
            throw wrongType2;
        } catch (ClassCastException e3) {
            WrongType wrongType3 = new WrongType(e3, "arg0", -2, obj2);
            throw wrongType3;
        } catch (ClassCastException e4) {
            WrongType wrongType4 = new WrongType(e4, "add-to-form-environment", 0, component$Mnname);
            throw wrongType4;
        } catch (ClassCastException e5) {
            WrongType wrongType5 = new WrongType(e5, "lookup-in-form-environment", 0, obj4);
            throw wrongType5;
        } catch (ClassCastException e6) {
            WrongType wrongType6 = new WrongType(e6, "arg0", -2, obj);
            throw wrongType6;
        } catch (ClassCastException e7) {
            WrongType wrongType7 = new WrongType(e7, "arg0", -2, reverse2);
            throw wrongType7;
        } catch (ClassCastException e8) {
            WrongType wrongType8 = new WrongType(e8, "add-to-global-var-environment", 0, var);
            throw wrongType8;
        } catch (ClassCastException e9) {
            WrongType wrongType9 = new WrongType(e9, "arg0", -2, reverse);
            throw wrongType9;
        } catch (YailRuntimeError exception2) {
            processException(exception2);
        }
    }

    public static SimpleSymbol lambda1symbolAppend$V(Object[] argsArray) {
        LList symbols = LList.makeList(argsArray, 0);
        Apply apply = Scheme.apply;
        ModuleMethod moduleMethod = strings.string$Mnappend;
        Object obj = LList.Empty;
        Object obj2 = symbols;
        while (obj2 != LList.Empty) {
            try {
                Pair arg0 = (Pair) obj2;
                Object arg02 = arg0.getCdr();
                Object car = arg0.getCar();
                try {
                    obj = Pair.make(misc.symbol$To$String((Symbol) car), obj);
                    obj2 = arg02;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "symbol->string", 1, car);
                }
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "arg0", -2, obj2);
            }
        }
        Object apply2 = apply.apply2(moduleMethod, LList.reverseInPlace(obj));
        try {
            return misc.string$To$Symbol((CharSequence) apply2);
        } catch (ClassCastException e3) {
            throw new WrongType(e3, "string->symbol", 1, apply2);
        }
    }

    static Object lambda2() {
        return null;
    }
}
