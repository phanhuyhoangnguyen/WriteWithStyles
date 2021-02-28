package enumclass;

import java.util.Arrays;

/**
 *
 * @author 101042618
 */
public enum FormStageType {
    Undefined(0),
    Processing(1),
    Success(2),
    Error(3);

    private final int value;

    private FormStageType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static FormStageType valueOf(int value) {
        return Arrays.stream(values())
                .filter(stage -> stage.value == value)
                .findFirst().orElse(Undefined);
    }
}
