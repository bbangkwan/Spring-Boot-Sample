package com.playnd.sbsample.model.user.param;

import com.playnd.sbsample.model.test.TestModel;
import lombok.Data;

/**
 * Created by Bae B K on 2018. 8. 9.
 */
@Data
public class UserParam {
    private String _id;
    private String id;
    private String type;
    private int age;
    
    private TestModel detail;
}
