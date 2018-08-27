package com.playnd.sbsample.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Bae B K on 2018. 8. 27.
 */
@Data
@Builder
public class ResponseModel {
    private ApiStatusModel apiStatus;
    private String message;
    private Object data;
    
}
