package com.daruo.firstweb.dto;

import java.util.Date;

public class UserQueryParams {

    private Integer limit;
    private Integer offset = 0;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
