/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumclass;

import java.util.Arrays;

/**
 *
 * @author 101042618
 */
public enum ProductCategoryType {
    Undefined(0),
    FountainPen(1),
    RollerballPen(2),
    BallpointPen(3),
    Accessories(4);

    private final int value;

    private ProductCategoryType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ProductCategoryType valueOf(int value) {
        return Arrays.stream(values())
            .filter(category -> category.value == value)
            .findFirst().orElse(Undefined);
    }
}
