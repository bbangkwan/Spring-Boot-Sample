package com.playnd.sbsample.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Bae B K on 2018. 8. 27.
 */
@Data
@Builder
public class ApiStatusModel {
    private int code;
    private String codeType;
    private String message;
}
