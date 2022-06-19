package librarykargah;

import java.io.Serializable;

public abstract class person extends MyFile implements Serializable, tostring {
    private String name;
    private int national_code;

    public person(String name, int national_code) {
        this.name = name;
        this.national_code = national_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  int getNational_code() {
        return national_code;
    }

    public void setNational_code(int national_code) {
        this.national_code = national_code;
    }

}
