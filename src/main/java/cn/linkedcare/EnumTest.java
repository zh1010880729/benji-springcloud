package cn.linkedcare;

/**
 * Created by Benji on 2018/4/10.
 */
public enum EnumTest {
    RED("red"),
    BLACK("black"),
    GREEN("green"),
    YELLOW("yellow");

    private String key;

    private EnumTest(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
