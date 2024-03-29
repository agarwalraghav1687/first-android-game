package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class IntNum extends RatNum implements Externalizable {
    static final int maxFixNum = 1024;
    static final int minFixNum = -100;
    static final int numFixNum = 1125;
    static final IntNum[] smallFixNums = new IntNum[numFixNum];
    public int ival;
    public int[] words;

    static {
        int i = numFixNum;
        while (true) {
            i--;
            if (i >= 0) {
                smallFixNums[i] = new IntNum(i + minFixNum);
            } else {
                return;
            }
        }
    }

    public IntNum() {
    }

    public IntNum(int value) {
        this.ival = value;
    }

    public static IntNum make(int value) {
        if (value < minFixNum || value > 1024) {
            return new IntNum(value);
        }
        return smallFixNums[value + 100];
    }

    public static final IntNum zero() {
        return smallFixNums[100];
    }

    public static final IntNum one() {
        return smallFixNums[101];
    }

    public static final IntNum ten() {
        return smallFixNums[110];
    }

    public static IntNum minusOne() {
        return smallFixNums[99];
    }

    public static IntNum make(long value) {
        if (value >= -100 && value <= 1024) {
            return smallFixNums[((int) value) + 100];
        }
        int i = (int) value;
        if (((long) i) == value) {
            return new IntNum(i);
        }
        IntNum result = alloc(2);
        result.ival = 2;
        result.words[0] = i;
        result.words[1] = (int) (value >> 32);
        return result;
    }

    public static IntNum asIntNumOrNull(Object value) {
        if (value instanceof IntNum) {
            return (IntNum) value;
        }
        if (value instanceof BigInteger) {
            return valueOf(value.toString(), 10);
        }
        if (!(value instanceof Number) || (!(value instanceof Integer) && !(value instanceof Long) && !(value instanceof Short) && !(value instanceof Byte))) {
            return null;
        }
        return make(((Number) value).longValue());
    }

    public static IntNum makeU(long value) {
        if (value >= 0) {
            return make(value);
        }
        IntNum result = alloc(3);
        result.ival = 3;
        result.words[0] = (int) value;
        result.words[1] = (int) (value >> 32);
        result.words[2] = 0;
        return result;
    }

    public static IntNum make(int[] words2, int len) {
        if (words2 == null) {
            return make(len);
        }
        int len2 = wordsNeeded(words2, len);
        if (len2 <= 1) {
            return len2 == 0 ? zero() : make(words2[0]);
        }
        IntNum num = new IntNum();
        num.words = words2;
        num.ival = len2;
        return num;
    }

    public static IntNum make(int[] words2) {
        return make(words2, words2.length);
    }

    public static IntNum alloc(int nwords) {
        if (nwords <= 1) {
            return new IntNum();
        }
        IntNum result = new IntNum();
        result.words = new int[nwords];
        return result;
    }

    public void realloc(int nwords) {
        if (nwords == 0) {
            if (this.words != null) {
                if (this.ival > 0) {
                    this.ival = this.words[0];
                }
                this.words = null;
            }
        } else if (this.words == null || this.words.length < nwords || this.words.length > nwords + 2) {
            int[] new_words = new int[nwords];
            if (this.words == null) {
                new_words[0] = this.ival;
                this.ival = 1;
            } else {
                if (nwords < this.ival) {
                    this.ival = nwords;
                }
                System.arraycopy(this.words, 0, new_words, 0, this.ival);
            }
            this.words = new_words;
        }
    }

    public final IntNum numerator() {
        return this;
    }

    public final IntNum denominator() {
        return one();
    }

    public final boolean isNegative() {
        return (this.words == null ? this.ival : this.words[this.ival + -1]) < 0;
    }

    public int sign() {
        int n = this.ival;
        int[] w = this.words;
        if (w != null) {
            int n2 = n - 1;
            int i = w[n2];
            if (i > 0) {
                return 1;
            }
            if (i < 0) {
                return -1;
            }
            while (n2 != 0) {
                n2--;
                if (w[n2] != 0) {
                    return 1;
                }
            }
            return 0;
        } else if (n > 0) {
            return 1;
        } else {
            return n < 0 ? -1 : 0;
        }
    }

    public static int compare(IntNum x, IntNum y) {
        boolean z = false;
        int i = 1;
        if (x.words != null || y.words != null) {
            boolean x_negative = x.isNegative();
            if (x_negative == y.isNegative()) {
                int x_len = x.words == null ? 1 : x.ival;
                int y_len = y.words == null ? 1 : y.ival;
                if (x_len == y_len) {
                    return MPN.cmp(x.words, y.words, x_len);
                }
                if (x_len > y_len) {
                    z = true;
                }
                if (z == x_negative) {
                    i = -1;
                }
                return i;
            } else if (!x_negative) {
                return 1;
            } else {
                return -1;
            }
        } else if (x.ival < y.ival) {
            return -1;
        } else {
            return x.ival > y.ival ? 1 : 0;
        }
    }

    public static int compare(IntNum x, long y) {
        boolean y_negative;
        long x_word;
        if (x.words == null) {
            x_word = (long) x.ival;
        } else {
            boolean x_negative = x.isNegative();
            if (y < 0) {
                y_negative = true;
            } else {
                y_negative = false;
            }
            if (x_negative == y_negative) {
                int x_len = x.words == null ? 1 : x.ival;
                if (x_len == 1) {
                    x_word = (long) x.words[0];
                } else if (x_len == 2) {
                    x_word = x.longValue();
                } else if (!x_negative) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (!x_negative) {
                return 1;
            } else {
                return -1;
            }
        }
        if (x_word < y) {
            return -1;
        }
        return x_word > y ? 1 : 0;
    }

    public int compare(Object obj) {
        if (obj instanceof IntNum) {
            return compare(this, (IntNum) obj);
        }
        return ((RealNum) obj).compareReversed(this);
    }

    public final boolean isOdd() {
        if (((this.words == null ? this.ival : this.words[0]) & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isZero() {
        return this.words == null && this.ival == 0;
    }

    public final boolean isOne() {
        return this.words == null && this.ival == 1;
    }

    public final boolean isMinusOne() {
        return this.words == null && this.ival == -1;
    }

    public static int wordsNeeded(int[] words2, int len) {
        int i = len;
        if (i > 0) {
            i--;
            int word = words2[i];
            if (word != -1) {
                while (word == 0 && i > 0) {
                    word = words2[i - 1];
                    if (word < 0) {
                        break;
                    }
                    i--;
                }
            } else {
                while (i > 0) {
                    int word2 = words2[i - 1];
                    if (word2 >= 0) {
                        break;
                    }
                    i--;
                    if (word2 != -1) {
                        break;
                    }
                }
            }
        }
        return i + 1;
    }

    public IntNum canonicalize() {
        if (this.words != null) {
            int wordsNeeded = wordsNeeded(this.words, this.ival);
            this.ival = wordsNeeded;
            if (wordsNeeded <= 1) {
                if (this.ival == 1) {
                    this.ival = this.words[0];
                }
                this.words = null;
            }
        }
        if (this.words != null || this.ival < minFixNum || this.ival > 1024) {
            return this;
        }
        return smallFixNums[this.ival + 100];
    }

    public static final IntNum add(int x, int y) {
        return make(((long) x) + ((long) y));
    }

    public static IntNum add(IntNum x, int y) {
        if (x.words == null) {
            return add(x.ival, y);
        }
        IntNum result = new IntNum(0);
        result.setAdd(x, y);
        return result.canonicalize();
    }

    public void setAdd(IntNum x, int y) {
        if (x.words == null) {
            set(((long) x.ival) + ((long) y));
            return;
        }
        int len = x.ival;
        realloc(len + 1);
        long carry = (long) y;
        for (int i = 0; i < len; i++) {
            long carry2 = carry + (((long) x.words[i]) & 4294967295L);
            this.words[i] = (int) carry2;
            carry = carry2 >> 32;
        }
        if (x.words[len - 1] < 0) {
            carry--;
        }
        this.words[len] = (int) carry;
        this.ival = wordsNeeded(this.words, len + 1);
    }

    public final void setAdd(int y) {
        setAdd(this, y);
    }

    public final void set(int y) {
        this.words = null;
        this.ival = y;
    }

    public final void set(long y) {
        int i = (int) y;
        if (((long) i) == y) {
            this.ival = i;
            this.words = null;
            return;
        }
        realloc(2);
        this.words[0] = i;
        this.words[1] = (int) (y >> 32);
        this.ival = 2;
    }

    public final void set(int[] words2, int length) {
        this.ival = length;
        this.words = words2;
    }

    public final void set(IntNum y) {
        if (y.words == null) {
            set(y.ival);
        } else if (this != y) {
            realloc(y.ival);
            System.arraycopy(y.words, 0, this.words, 0, y.ival);
            this.ival = y.ival;
        }
    }

    public static IntNum add(IntNum x, IntNum y) {
        return add(x, y, 1);
    }

    public static IntNum sub(IntNum x, IntNum y) {
        return add(x, y, -1);
    }

    public static IntNum add(IntNum x, IntNum y, int k) {
        if (x.words == null && y.words == null) {
            return make((((long) k) * ((long) y.ival)) + ((long) x.ival));
        }
        if (k != 1) {
            if (k == -1) {
                y = neg(y);
            } else {
                y = times(y, make(k));
            }
        }
        if (x.words == null) {
            return add(y, x.ival);
        }
        if (y.words == null) {
            return add(x, y.ival);
        }
        if (y.ival > x.ival) {
            IntNum tmp = x;
            x = y;
            y = tmp;
        }
        IntNum result = alloc(x.ival + 1);
        int i = y.ival;
        long carry = (long) MPN.add_n(result.words, x.words, y.words, i);
        long y_ext = y.words[i + -1] < 0 ? 4294967295L : 0;
        while (i < x.ival) {
            long carry2 = carry + (((long) x.words[i]) & 4294967295L) + y_ext;
            result.words[i] = (int) carry2;
            carry = carry2 >>> 32;
            i++;
        }
        if (x.words[i - 1] < 0) {
            y_ext--;
        }
        result.words[i] = (int) (carry + y_ext);
        result.ival = i + 1;
        return result.canonicalize();
    }

    public static final IntNum times(int x, int y) {
        return make(((long) x) * ((long) y));
    }

    public static final IntNum times(IntNum x, int y) {
        boolean negative;
        boolean negative2;
        if (y == 0) {
            return zero();
        }
        if (y == 1) {
            return x;
        }
        int[] xwords = x.words;
        int xlen = x.ival;
        if (xwords == null) {
            return make(((long) xlen) * ((long) y));
        }
        IntNum result = alloc(xlen + 1);
        if (xwords[xlen - 1] < 0) {
            negative = true;
            negate(result.words, xwords, xlen);
            xwords = result.words;
        } else {
            negative = false;
        }
        if (y < 0) {
            negative2 = !negative2;
            y = -y;
        }
        result.words[xlen] = MPN.mul_1(result.words, xwords, xlen, y);
        result.ival = xlen + 1;
        if (negative2) {
            result.setNegative();
        }
        return result.canonicalize();
    }

    public static final IntNum times(IntNum x, IntNum y) {
        boolean negative;
        int[] xwords;
        boolean negative2;
        int[] ywords;
        if (y.words == null) {
            return times(x, y.ival);
        }
        if (x.words == null) {
            return times(y, x.ival);
        }
        int xlen = x.ival;
        int ylen = y.ival;
        if (x.isNegative()) {
            negative = true;
            xwords = new int[xlen];
            negate(xwords, x.words, xlen);
        } else {
            negative = false;
            xwords = x.words;
        }
        if (y.isNegative()) {
            negative2 = !negative2;
            ywords = new int[ylen];
            negate(ywords, y.words, ylen);
        } else {
            ywords = y.words;
        }
        if (xlen < ylen) {
            int[] twords = xwords;
            xwords = ywords;
            ywords = twords;
            int tlen = xlen;
            xlen = ylen;
            ylen = tlen;
        }
        IntNum result = alloc(xlen + ylen);
        MPN.mul(result.words, xwords, xlen, ywords, ylen);
        result.ival = xlen + ylen;
        if (negative2) {
            result.setNegative();
        }
        return result.canonicalize();
    }

    public static void divide(long x, long y, IntNum quotient, IntNum remainder, int rounding_mode) {
        boolean xNegative;
        boolean yNegative;
        if (rounding_mode == 5) {
            rounding_mode = y < 0 ? 2 : 1;
        }
        if (x < 0) {
            xNegative = true;
            if (x == Long.MIN_VALUE) {
                divide(make(x), make(y), quotient, remainder, rounding_mode);
                return;
            }
            x = -x;
        } else {
            xNegative = false;
        }
        if (y < 0) {
            yNegative = true;
            if (y != Long.MIN_VALUE) {
                y = -y;
            } else if (rounding_mode == 3) {
                if (quotient != null) {
                    quotient.set(0);
                }
                if (remainder != null) {
                    remainder.set(x);
                    return;
                }
                return;
            } else {
                divide(make(x), make(y), quotient, remainder, rounding_mode);
                return;
            }
        } else {
            yNegative = false;
        }
        long q = x / y;
        long r = x % y;
        boolean qNegative = xNegative ^ yNegative;
        boolean add_one = false;
        if (r != 0) {
            switch (rounding_mode) {
                case 1:
                case 2:
                    if (qNegative == (rounding_mode == 1)) {
                        add_one = true;
                        break;
                    }
                    break;
                case 4:
                    if (r <= ((y - (1 & q)) >> 1)) {
                        add_one = false;
                        break;
                    } else {
                        add_one = true;
                        break;
                    }
            }
        }
        if (quotient != null) {
            if (add_one) {
                q++;
            }
            if (qNegative) {
                q = -q;
            }
            quotient.set(q);
        }
        if (remainder != null) {
            if (add_one) {
                r = y - r;
                xNegative = !xNegative;
            }
            if (xNegative) {
                r = -r;
            }
            remainder.set(r);
        }
    }

    public static void divide(IntNum x, IntNum y, IntNum quotient, IntNum remainder, int rounding_mode) {
        int xlen;
        int rlen;
        int qlen;
        IntNum tmp;
        IntNum tmp2;
        int xlen2;
        if ((x.words == null || x.ival <= 2) && (y.words == null || y.ival <= 2)) {
            long x_l = x.longValue();
            long y_l = y.longValue();
            if (!(x_l == Long.MIN_VALUE || y_l == Long.MIN_VALUE)) {
                divide(x_l, y_l, quotient, remainder, rounding_mode);
                return;
            }
        }
        boolean xNegative = x.isNegative();
        boolean yNegative = y.isNegative();
        boolean qNegative = xNegative ^ yNegative;
        int ylen = y.words == null ? 1 : y.ival;
        int[] ywords = new int[ylen];
        y.getAbsolute(ywords);
        while (ylen > 1 && ywords[ylen - 1] == 0) {
            ylen--;
        }
        int xlen3 = x.words == null ? 1 : x.ival;
        int[] xwords = new int[(xlen3 + 2)];
        x.getAbsolute(xwords);
        while (true) {
            xlen = xlen3;
            if (xlen <= 1 || xwords[xlen - 1] != 0) {
                int cmpval = MPN.cmp(xwords, xlen, ywords, ylen);
            } else {
                xlen3 = xlen - 1;
            }
        }
        int cmpval2 = MPN.cmp(xwords, xlen, ywords, ylen);
        if (cmpval2 < 0) {
            int[] rwords = xwords;
            xwords = ywords;
            ywords = rwords;
            rlen = xlen;
            qlen = 1;
            xwords[0] = 0;
            int i = xlen;
        } else if (cmpval2 == 0) {
            xwords[0] = 1;
            qlen = 1;
            ywords[0] = 0;
            rlen = 1;
            int i2 = xlen;
        } else if (ylen == 1) {
            qlen = xlen;
            rlen = 1;
            ywords[0] = MPN.divmod_1(xwords, xwords, xlen, ywords[0]);
            int i3 = xlen;
        } else {
            int nshift = MPN.count_leading_zeros(ywords[ylen - 1]);
            if (nshift != 0) {
                MPN.lshift(ywords, 0, ywords, ylen, nshift);
                int xlen4 = xlen + 1;
                xwords[xlen] = MPN.lshift(xwords, 0, xwords, xlen, nshift);
                xlen = xlen4;
            }
            if (xlen == ylen) {
                xlen2 = xlen + 1;
                xwords[xlen] = 0;
            } else {
                xlen2 = xlen;
            }
            MPN.divide(xwords, xlen2, ywords, ylen);
            rlen = ylen;
            MPN.rshift0(ywords, xwords, 0, rlen, nshift);
            qlen = (xlen2 + 1) - ylen;
            if (quotient != null) {
                for (int i4 = 0; i4 < qlen; i4++) {
                    xwords[i4] = xwords[i4 + ylen];
                }
            }
        }
        while (rlen > 1 && ywords[rlen - 1] == 0) {
            rlen--;
        }
        if (ywords[rlen - 1] < 0) {
            ywords[rlen] = 0;
            rlen++;
        }
        boolean add_one = false;
        if (rlen > 1 || ywords[0] != 0) {
            if (rounding_mode == 5) {
                rounding_mode = yNegative ? 2 : 1;
            }
            switch (rounding_mode) {
                case 1:
                case 2:
                    if (qNegative == (rounding_mode == 1)) {
                        add_one = true;
                        break;
                    }
                    break;
                case 4:
                    if (remainder == null) {
                        tmp2 = new IntNum();
                    } else {
                        tmp2 = remainder;
                    }
                    tmp2.set(ywords, rlen);
                    IntNum tmp3 = shift(tmp2, 1);
                    if (yNegative) {
                        tmp3.setNegative();
                    }
                    int cmp = compare(tmp3, y);
                    if (yNegative) {
                        cmp = -cmp;
                    }
                    if (cmp != 1 && (cmp != 0 || (xwords[0] & 1) == 0)) {
                        add_one = false;
                        break;
                    } else {
                        add_one = true;
                        break;
                    }
            }
        }
        if (quotient != null) {
            if (xwords[qlen - 1] < 0) {
                xwords[qlen] = 0;
                qlen++;
            }
            quotient.set(xwords, qlen);
            if (qNegative) {
                if (add_one) {
                    quotient.setInvert();
                } else {
                    quotient.setNegative();
                }
            } else if (add_one) {
                quotient.setAdd(1);
            }
        }
        if (remainder != null) {
            remainder.set(ywords, rlen);
            if (add_one) {
                if (y.words == null) {
                    tmp = remainder;
                    tmp.set(yNegative ? ywords[0] + y.ival : ywords[0] - y.ival);
                } else {
                    tmp = add(remainder, y, yNegative ? 1 : -1);
                }
                if (xNegative) {
                    remainder.setNegative(tmp);
                } else {
                    remainder.set(tmp);
                }
            } else if (xNegative) {
                remainder.setNegative();
            }
        }
    }

    public static IntNum quotient(IntNum x, IntNum y, int rounding_mode) {
        IntNum quotient = new IntNum();
        divide(x, y, quotient, (IntNum) null, rounding_mode);
        return quotient.canonicalize();
    }

    public static IntNum quotient(IntNum x, IntNum y) {
        return quotient(x, y, 3);
    }

    public IntNum toExactInt(int rounding_mode) {
        return this;
    }

    public RealNum toInt(int rounding_mode) {
        return this;
    }

    public static IntNum remainder(IntNum x, IntNum y, int rounding_mode) {
        if (y.isZero()) {
            return x;
        }
        IntNum rem = new IntNum();
        divide(x, y, (IntNum) null, rem, rounding_mode);
        return rem.canonicalize();
    }

    public static IntNum remainder(IntNum x, IntNum y) {
        return remainder(x, y, 3);
    }

    public static IntNum modulo(IntNum x, IntNum y) {
        return remainder(x, y, 1);
    }

    /* Debug info: failed to restart local var, previous not found, register: 1 */
    public Numeric power(IntNum y) {
        if (isOne()) {
            return this;
        }
        if (isMinusOne()) {
            if (!y.isOdd()) {
                return one();
            }
            return this;
        } else if (y.words == null && y.ival >= 0) {
            return power(this, y.ival);
        } else {
            if (!isZero()) {
                return super.power(y);
            }
            if (y.isNegative()) {
                return RatNum.infinity(-1);
            }
            return this;
        }
    }

    public static IntNum power(IntNum x, int y) {
        boolean negative;
        if (y <= 0) {
            if (y == 0) {
                return one();
            }
            throw new Error("negative exponent");
        } else if (x.isZero()) {
            return x;
        } else {
            int plen = x.words == null ? 1 : x.ival;
            int blen = ((x.intLength() * y) >> 5) + (plen * 2);
            if (!x.isNegative() || (y & 1) == 0) {
                negative = false;
            } else {
                negative = true;
            }
            int[] pow2 = new int[blen];
            int[] rwords = new int[blen];
            int[] work = new int[blen];
            x.getAbsolute(pow2);
            int rlen = 1;
            rwords[0] = 1;
            while (true) {
                if ((y & 1) != 0) {
                    MPN.mul(work, pow2, plen, rwords, rlen);
                    int[] temp = work;
                    work = rwords;
                    rwords = temp;
                    rlen += plen;
                    while (rwords[rlen - 1] == 0) {
                        rlen--;
                    }
                }
                y >>= 1;
                if (y == 0) {
                    break;
                }
                MPN.mul(work, pow2, plen, pow2, plen);
                int[] temp2 = work;
                work = pow2;
                pow2 = temp2;
                plen *= 2;
                while (pow2[plen - 1] == 0) {
                    plen--;
                }
            }
            if (rwords[rlen - 1] < 0) {
                rlen++;
            }
            if (negative) {
                negate(rwords, rwords, rlen);
            }
            return make(rwords, rlen);
        }
    }

    public static final int gcd(int a, int b) {
        if (b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            if (b == 1) {
                return b;
            }
            int tmp2 = b;
            b = a % b;
            a = tmp2;
        }
        return a;
    }

    public static IntNum gcd(IntNum x, IntNum y) {
        int len;
        int xval = x.ival;
        int yval = y.ival;
        if (x.words == null) {
            if (xval == 0) {
                return abs(y);
            }
            if (y.words != null || xval == Integer.MIN_VALUE || yval == Integer.MIN_VALUE) {
                xval = 1;
            } else {
                if (xval < 0) {
                    xval = -xval;
                }
                if (yval < 0) {
                    yval = -yval;
                }
                return make(gcd(xval, yval));
            }
        }
        if (y.words == null) {
            if (yval == 0) {
                return abs(x);
            }
            yval = 1;
        }
        if (xval > yval) {
            len = xval;
        } else {
            len = yval;
        }
        int[] xwords = new int[len];
        int[] ywords = new int[len];
        x.getAbsolute(xwords);
        y.getAbsolute(ywords);
        int len2 = MPN.gcd(xwords, ywords, len);
        IntNum result = new IntNum(0);
        if (xwords[len2 - 1] < 0) {
            int len3 = len2 + 1;
            xwords[len2] = 0;
            len2 = len3;
        }
        result.ival = len2;
        result.words = xwords;
        return result.canonicalize();
    }

    public static IntNum lcm(IntNum x, IntNum y) {
        if (x.isZero() || y.isZero()) {
            return zero();
        }
        IntNum x2 = abs(x);
        IntNum y2 = abs(y);
        IntNum quotient = new IntNum();
        divide(times(x2, y2), gcd(x2, y2), quotient, (IntNum) null, 3);
        return quotient.canonicalize();
    }

    /* access modifiers changed from: 0000 */
    public void setInvert() {
        if (this.words == null) {
            this.ival ^= -1;
            return;
        }
        int i = this.ival;
        while (true) {
            i--;
            if (i >= 0) {
                this.words[i] = this.words[i] ^ -1;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void setShiftLeft(IntNum x, int count) {
        int[] xwords;
        int xlen;
        if (x.words != null) {
            xwords = x.words;
            xlen = x.ival;
        } else if (count < 32) {
            set(((long) x.ival) << count);
            return;
        } else {
            xwords = new int[]{x.ival};
            xlen = 1;
        }
        int word_count = count >> 5;
        int count2 = count & 31;
        int new_len = xlen + word_count;
        if (count2 == 0) {
            realloc(new_len);
            int i = xlen;
            while (true) {
                i--;
                if (i < 0) {
                    break;
                }
                this.words[i + word_count] = xwords[i];
            }
        } else {
            new_len++;
            realloc(new_len);
            int shift_out = MPN.lshift(this.words, word_count, xwords, xlen, count2);
            int count3 = 32 - count2;
            this.words[new_len - 1] = (shift_out << count3) >> count3;
        }
        this.ival = new_len;
        int i2 = word_count;
        while (true) {
            i2--;
            if (i2 >= 0) {
                this.words[i2] = 0;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void setShiftRight(IntNum x, int count) {
        int i = -1;
        if (x.words == null) {
            if (count < 32) {
                i = x.ival >> count;
            } else if (x.ival >= 0) {
                i = 0;
            }
            set(i);
        } else if (count == 0) {
            set(x);
        } else {
            boolean neg = x.isNegative();
            int word_count = count >> 5;
            int count2 = count & 31;
            int d_len = x.ival - word_count;
            if (d_len <= 0) {
                if (!neg) {
                    i = 0;
                }
                set(i);
                return;
            }
            if (this.words == null || this.words.length < d_len) {
                realloc(d_len);
            }
            MPN.rshift0(this.words, x.words, word_count, d_len, count2);
            this.ival = d_len;
            if (neg) {
                int[] iArr = this.words;
                int i2 = d_len - 1;
                iArr[i2] = iArr[i2] | (-2 << (31 - count2));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void setShift(IntNum x, int count) {
        if (count > 0) {
            setShiftLeft(x, count);
        } else {
            setShiftRight(x, -count);
        }
    }

    public static IntNum shift(IntNum x, int count) {
        int i = 0;
        if (x.words == null) {
            if (count <= 0) {
                if (count > -32) {
                    i = x.ival >> (-count);
                } else if (x.ival < 0) {
                    i = -1;
                }
                return make(i);
            } else if (count < 32) {
                return make(((long) x.ival) << count);
            }
        }
        if (count == 0) {
            return x;
        }
        IntNum result = new IntNum(0);
        result.setShift(x, count);
        return result.canonicalize();
    }

    public static int shift(int x, int count) {
        if (count >= 32) {
            return 0;
        }
        if (count >= 0) {
            return x << count;
        }
        int count2 = -count;
        if (count2 < 32) {
            return x >> count2;
        }
        if (x < 0) {
            return -1;
        }
        return 0;
    }

    public static long shift(long x, int count) {
        if (count >= 32) {
            return 0;
        }
        if (count >= 0) {
            return x << count;
        }
        int count2 = -count;
        if (count2 < 32) {
            return x >> count2;
        }
        if (x < 0) {
            return -1;
        }
        return 0;
    }

    public void format(int radix, StringBuffer buffer) {
        if (radix == 10) {
            if (this.words == null) {
                buffer.append(this.ival);
                return;
            } else if (this.ival <= 2) {
                buffer.append(longValue());
                return;
            }
        }
        buffer.append(toString(radix));
    }

    public void format(int radix, StringBuilder buffer) {
        int[] work;
        int digit;
        if (this.words == null) {
            if (radix == 10) {
                buffer.append(this.ival);
                return;
            }
            buffer.append(Integer.toString(this.ival, radix));
        } else if (this.ival <= 2) {
            long lval = longValue();
            if (radix == 10) {
                buffer.append(lval);
                return;
            }
            buffer.append(Long.toString(lval, radix));
        } else {
            boolean neg = isNegative();
            if (neg || radix != 16) {
                work = new int[this.ival];
                getAbsolute(work);
            } else {
                work = this.words;
            }
            int len = this.ival;
            if (radix == 16) {
                if (neg) {
                    buffer.append('-');
                }
                int buf_start = buffer.length();
                int i = len;
                while (true) {
                    i--;
                    if (i >= 0) {
                        int word = work[i];
                        int j = 8;
                        while (true) {
                            j--;
                            if (j >= 0) {
                                int hex_digit = (word >> (j * 4)) & 15;
                                if (hex_digit > 0 || buffer.length() > buf_start) {
                                    buffer.append(Character.forDigit(hex_digit, 16));
                                }
                            }
                        }
                    } else {
                        return;
                    }
                }
            } else {
                int chars_per_word = MPN.chars_per_word(radix);
                int wradix = radix;
                int j2 = chars_per_word;
                while (true) {
                    j2--;
                    if (j2 <= 0) {
                        break;
                    }
                    wradix *= radix;
                }
                int i2 = buffer.length();
                do {
                    int wdigit = MPN.divmod_1(work, work, len, wradix);
                    while (len > 0 && work[len - 1] == 0) {
                        len--;
                    }
                    int j3 = chars_per_word;
                    while (true) {
                        j3--;
                        if (j3 >= 0 && (len != 0 || wdigit != 0)) {
                            if (wdigit < 0) {
                                digit = (int) ((((long) wdigit) & -1) % ((long) radix));
                            } else {
                                digit = wdigit % radix;
                            }
                            wdigit /= radix;
                            buffer.append(Character.forDigit(digit, radix));
                        }
                    }
                } while (len != 0);
                if (neg) {
                    buffer.append('-');
                }
                for (int j4 = buffer.length() - 1; i2 < j4; j4--) {
                    char tmp = buffer.charAt(i2);
                    buffer.setCharAt(i2, buffer.charAt(j4));
                    buffer.setCharAt(j4, tmp);
                    i2++;
                }
            }
        }
    }

    public String toString(int radix) {
        if (this.words == null) {
            return Integer.toString(this.ival, radix);
        }
        if (this.ival <= 2) {
            return Long.toString(longValue(), radix);
        }
        StringBuilder buffer = new StringBuilder(this.ival * (MPN.chars_per_word(radix) + 1));
        format(radix, buffer);
        return buffer.toString();
    }

    public int intValue() {
        if (this.words == null) {
            return this.ival;
        }
        return this.words[0];
    }

    public static int intValue(Object obj) {
        IntNum inum = (IntNum) obj;
        if (inum.words == null) {
            return inum.ival;
        }
        throw new ClassCastException("integer too large");
    }

    public long longValue() {
        if (this.words == null) {
            return (long) this.ival;
        }
        if (this.ival == 1) {
            return (long) this.words[0];
        }
        return (((long) this.words[1]) << 32) + (((long) this.words[0]) & 4294967295L);
    }

    public int hashCode() {
        return this.words == null ? this.ival : this.words[0] + this.words[this.ival - 1];
    }

    public static boolean equals(IntNum x, IntNum y) {
        if (x.words == null && y.words == null) {
            if (x.ival == y.ival) {
                return true;
            }
            return false;
        } else if (x.words == null || y.words == null || x.ival != y.ival) {
            return false;
        } else {
            int i = x.ival;
            do {
                i--;
                if (i < 0) {
                    return true;
                }
            } while (x.words[i] == y.words[i]);
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IntNum)) {
            return false;
        }
        return equals(this, (IntNum) obj);
    }

    public static IntNum valueOf(char[] buf, int offset, int length, int radix, boolean negative) {
        int byte_len;
        byte[] bytes = new byte[length];
        int i = 0;
        int byte_len2 = 0;
        while (i < length) {
            char ch = buf[offset + i];
            if (ch == '-') {
                negative = true;
                byte_len = byte_len2;
            } else {
                if (ch != '_') {
                    if (byte_len2 == 0) {
                        if (ch != ' ') {
                            if (ch == 9) {
                                byte_len = byte_len2;
                            }
                        }
                    }
                    int digit = Character.digit(ch, radix);
                    if (digit < 0) {
                        break;
                    }
                    byte_len = byte_len2 + 1;
                    bytes[byte_len2] = (byte) digit;
                }
                byte_len = byte_len2;
            }
            i++;
            byte_len2 = byte_len;
        }
        return valueOf(bytes, byte_len2, negative, radix);
    }

    public static IntNum valueOf(String s, int radix) throws NumberFormatException {
        int byte_len;
        int len = s.length();
        if (len + radix <= 28) {
            if (len > 1 && s.charAt(0) == '+' && Character.digit(s.charAt(1), radix) >= 0) {
                s = s.substring(1);
            }
            return make(Long.parseLong(s, radix));
        }
        byte[] bytes = new byte[len];
        boolean negative = false;
        int i = 0;
        int byte_len2 = 0;
        while (i < len) {
            char ch = s.charAt(i);
            if (ch == '-' && i == 0) {
                negative = true;
                byte_len = byte_len2;
            } else if (ch == '+' && i == 0) {
                byte_len = byte_len2;
            } else {
                if (ch != '_') {
                    if (byte_len2 == 0) {
                        if (ch != ' ') {
                            if (ch == 9) {
                                byte_len = byte_len2;
                            }
                        }
                    }
                    int digit = Character.digit(ch, radix);
                    if (digit < 0) {
                        throw new NumberFormatException("For input string: \"" + s + '\"');
                    }
                    byte_len = byte_len2 + 1;
                    bytes[byte_len2] = (byte) digit;
                }
                byte_len = byte_len2;
            }
            i++;
            byte_len2 = byte_len;
        }
        return valueOf(bytes, byte_len2, negative, radix);
    }

    public static IntNum valueOf(byte[] digits, int byte_len, boolean negative, int radix) {
        int[] words2 = new int[((byte_len / MPN.chars_per_word(radix)) + 1)];
        int size = MPN.set_str(words2, digits, byte_len, radix);
        if (size == 0) {
            return zero();
        }
        if (words2[size - 1] < 0) {
            int size2 = size + 1;
            words2[size] = 0;
            size = size2;
        }
        if (negative) {
            negate(words2, words2, size);
        }
        return make(words2, size);
    }

    public static IntNum valueOf(String s) throws NumberFormatException {
        return valueOf(s, 10);
    }

    public double doubleValue() {
        if (this.words == null) {
            return (double) this.ival;
        }
        if (this.ival <= 2) {
            return (double) longValue();
        }
        if (isNegative()) {
            return neg(this).roundToDouble(0, true, false);
        }
        return roundToDouble(0, false, false);
    }

    /* access modifiers changed from: 0000 */
    public boolean checkBits(int n) {
        boolean z = true;
        if (n <= 0) {
            return false;
        }
        if (this.words != null) {
            int i = 0;
            while (i < (n >> 5)) {
                if (this.words[i] != 0) {
                    return true;
                }
                i++;
            }
            if ((n & 31) == 0 || (this.words[i] & ((1 << (n & 31)) - 1)) == 0) {
                z = false;
            }
            return z;
        } else if (n > 31 || (this.ival & ((1 << n) - 1)) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public double roundToDouble(int exp, boolean neg, boolean remainder) {
        int il = intLength();
        int exp2 = exp + (il - 1);
        if (exp2 < -1075) {
            if (neg) {
                return -0.0d;
            }
            return 0.0d;
        } else if (exp2 > 1023) {
            return neg ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        } else {
            int ml = exp2 >= -1022 ? 53 : exp2 + 53 + 1022;
            int excess_bits = il - (ml + 1);
            long m = excess_bits > 0 ? this.words == null ? (long) (this.ival >> excess_bits) : MPN.rshift_long(this.words, this.ival, excess_bits) : longValue() << (-excess_bits);
            if (exp2 == 1023 && (m >> 1) == 9007199254740991L) {
                if (!remainder) {
                    if (!checkBits(il - ml)) {
                        return neg ? -1.7976931348623157E308d : Double.MAX_VALUE;
                    }
                }
                if (neg) {
                    return Double.NEGATIVE_INFINITY;
                }
                return Double.POSITIVE_INFINITY;
            }
            if ((1 & m) == 1 && ((2 & m) == 2 || remainder || checkBits(excess_bits))) {
                m += 2;
                if ((18014398509481984L & m) != 0) {
                    exp2++;
                    m >>= 1;
                } else if (ml == 52 && (9007199254740992L & m) != 0) {
                    exp2++;
                }
            }
            int exp3 = exp2 + 1023;
            return Double.longBitsToDouble((neg ? Long.MIN_VALUE : 0) | (exp3 <= 0 ? 0 : ((long) exp3) << 52) | ((m >> 1) & -4503599627370497L));
        }
    }

    public Numeric add(Object y, int k) {
        if (y instanceof IntNum) {
            return add(this, (IntNum) y, k);
        }
        if (y instanceof Numeric) {
            return ((Numeric) y).addReversed(this, k);
        }
        throw new IllegalArgumentException();
    }

    public Numeric mul(Object y) {
        if (y instanceof IntNum) {
            return times(this, (IntNum) y);
        }
        if (y instanceof Numeric) {
            return ((Numeric) y).mulReversed(this);
        }
        throw new IllegalArgumentException();
    }

    public Numeric div(Object y) {
        if (y instanceof RatNum) {
            RatNum r = (RatNum) y;
            return RatNum.make(times(this, r.denominator()), r.numerator());
        } else if (y instanceof Numeric) {
            return ((Numeric) y).divReversed(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void getAbsolute(int[] words2) {
        int len;
        if (this.words != null) {
            len = this.ival;
            int i = len;
            while (true) {
                i--;
                if (i < 0) {
                    break;
                }
                words2[i] = this.words[i];
            }
        } else {
            len = 1;
            words2[0] = this.ival;
        }
        if (words2[len - 1] < 0) {
            negate(words2, words2, len);
        }
        int i2 = words2.length;
        while (true) {
            i2--;
            if (i2 > len) {
                words2[i2] = 0;
            } else {
                return;
            }
        }
    }

    public static boolean negate(int[] dest, int[] src, int len) {
        boolean negative;
        long carry = 1;
        if (src[len - 1] < 0) {
            negative = true;
        } else {
            negative = false;
        }
        for (int i = 0; i < len; i++) {
            long carry2 = carry + (((long) (src[i] ^ -1)) & 4294967295L);
            dest[i] = (int) carry2;
            carry = carry2 >> 32;
        }
        if (!negative || dest[len - 1] >= 0) {
            return false;
        }
        return true;
    }

    public void setNegative(IntNum x) {
        int len = x.ival;
        if (x.words != null) {
            realloc(len + 1);
            if (negate(this.words, x.words, len)) {
                int len2 = len + 1;
                this.words[len] = 0;
                len = len2;
            }
            this.ival = len;
        } else if (len == Integer.MIN_VALUE) {
            set(-((long) len));
        } else {
            set(-len);
        }
    }

    public final void setNegative() {
        setNegative(this);
    }

    public static IntNum abs(IntNum x) {
        return x.isNegative() ? neg(x) : x;
    }

    public static IntNum neg(IntNum x) {
        if (x.words == null && x.ival != Integer.MIN_VALUE) {
            return make(-x.ival);
        }
        IntNum result = new IntNum(0);
        result.setNegative(x);
        return result.canonicalize();
    }

    public Numeric neg() {
        return neg(this);
    }

    public int intLength() {
        if (this.words == null) {
            return MPN.intLength(this.ival);
        }
        return MPN.intLength(this.words, this.ival);
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        int i = 0;
        int nwords = this.words == null ? 1 : wordsNeeded(this.words, this.ival);
        if (nwords <= 1) {
            if (this.words == null) {
                i = this.ival;
            } else if (this.words.length != 0) {
                i = this.words[0];
            }
            if (i >= -1073741824) {
                out.writeInt(i);
                return;
            }
            out.writeInt(-2147483647);
            out.writeInt(i);
            return;
        }
        out.writeInt(Integer.MIN_VALUE | nwords);
        while (true) {
            nwords--;
            if (nwords >= 0) {
                out.writeInt(this.words[nwords]);
            } else {
                return;
            }
        }
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int i = in.readInt();
        if (i <= -1073741824) {
            i &= Integer.MAX_VALUE;
            if (i == 1) {
                i = in.readInt();
            } else {
                int[] w = new int[i];
                int j = i;
                while (true) {
                    j--;
                    if (j < 0) {
                        break;
                    }
                    w[j] = in.readInt();
                }
                this.words = w;
            }
        }
        this.ival = i;
    }

    public Object readResolve() throws ObjectStreamException {
        return canonicalize();
    }

    public BigInteger asBigInteger() {
        if (this.words == null || this.ival <= 2) {
            return BigInteger.valueOf(longValue());
        }
        return new BigInteger(toString());
    }

    public BigDecimal asBigDecimal() {
        if (this.words == null) {
            return new BigDecimal(this.ival);
        }
        if (this.ival <= 2) {
            return BigDecimal.valueOf(longValue());
        }
        return new BigDecimal(toString());
    }

    public boolean inRange(long lo, long hi) {
        return compare(this, lo) >= 0 && compare(this, hi) <= 0;
    }

    public boolean inIntRange() {
        return inRange(-2147483648L, 2147483647L);
    }

    public boolean inLongRange() {
        return inRange(Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
