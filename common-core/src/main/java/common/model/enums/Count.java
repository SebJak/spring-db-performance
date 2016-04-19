package common.model.enums;

/**
 * Created by sjakowski on 2016-03-22.
 */
public enum Count {
    ZERO(0),
    ONE(1);

    int count;

    Count(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
