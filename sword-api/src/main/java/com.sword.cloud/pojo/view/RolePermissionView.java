package com.sword.cloud.pojo.view;

import com.sword.cloud.base.BaseView;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class RolePermissionView extends BaseView implements Serializable {

    private static final long serialVersionUID = -2783081162690878303L;

}
