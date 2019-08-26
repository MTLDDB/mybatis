package com.mybatis.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ant
 * @Date: 2018/11/29 14:10
 * @Description:
 */
public class PageModel<T> {
    private int total;
    private List<T> rows=new ArrayList<T>();

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
