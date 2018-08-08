package com.playnd.sbsample.model.test.param;

import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * Created by Bae B K on 2018. 8. 8.
 */
@Data
public class TestParamModel {
    @NotNull(message = "first null")
    private String first;
    private int second;
}
