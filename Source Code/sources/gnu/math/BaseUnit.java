package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class BaseUnit extends NamedUnit implements Externalizable {
    static int base_count = 0;
    private static final String unitName = "(name)";
    String dimension;
    int index;

    public String getDimension() {
        return this.dimension;
    }

    public BaseUnit() {
        this.name = unitName;
        this.index = Integer.MAX_VALUE;
        this.dims = Dimensions.Empty;
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.base = this;
        this.scale = 1.0d;
        this.dims = new Dimensions(this);
        super.init();
        int i = base_count;
        base_count = i + 1;
        this.index = i;
    }

    public BaseUnit(String name) {
        this.name = name;
        init();
    }

    public BaseUnit(String name, String dimension2) {
        this.name = name;
        this.dimension = dimension2;
        init();
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public Unit unit() {
        return this;
    }

    public static BaseUnit lookup(String name, String dimension2) {
        String name2 = name.intern();
        if (name2 == unitName && dimension2 == null) {
            return Unit.Empty;
        }
        for (NamedUnit unit = table[(Integer.MAX_VALUE & name2.hashCode()) % table.length]; unit != null; unit = unit.chain) {
            if (unit.name == name2 && (unit instanceof BaseUnit)) {
                BaseUnit bunit = (BaseUnit) unit;
                if (bunit.dimension == dimension2) {
                    return bunit;
                }
            }
        }
        return null;
    }

    public static BaseUnit make(String name, String dimension2) {
        BaseUnit old = lookup(name, dimension2);
        return old == null ? new BaseUnit(name, dimension2) : old;
    }

    public static int compare(BaseUnit unit1, BaseUnit unit2) {
        int code = unit1.name.compareTo(unit2.name);
        if (code != 0) {
            return code;
        }
        String dim1 = unit1.dimension;
        String dim2 = unit2.dimension;
        if (dim1 == dim2) {
            return 0;
        }
        if (dim1 == null) {
            return -1;
        }
        if (dim2 == null) {
            return 1;
        }
        return dim1.compareTo(dim2);
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
        out.writeObject(this.dimension);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.dimension = (String) in.readObject();
    }

    public Object readResolve() throws ObjectStreamException {
        BaseUnit unit = lookup(this.name, this.dimension);
        if (unit != null) {
            return unit;
        }
        init();
        return this;
    }
}
