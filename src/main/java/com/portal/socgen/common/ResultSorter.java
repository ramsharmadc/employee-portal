package com.portal.socgen.common;

import org.springframework.data.domain.Sort;

public class ResultSorter {

    public static Sort firstNameAscendingOrder() {
        return Sort.by(Sort.Order.asc("firstName"));
    }
}
