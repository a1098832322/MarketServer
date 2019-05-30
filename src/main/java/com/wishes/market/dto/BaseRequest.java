package com.wishes.market.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 基本请求类，定义了基本的分页标准
 *
 * @author 郑龙
 * @date 2019-01-24  16:13
 */
@Data
public class BaseRequest {
    @ApiModelProperty(hidden = true)
    private int limit = 10;
    @ApiModelProperty(hidden = true)
    private int page = 1;
}
