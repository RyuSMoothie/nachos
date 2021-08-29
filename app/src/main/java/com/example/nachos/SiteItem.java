package com.example.nachos;


import android.view.View;

public class SiteItem {
    String site;
    String category;
    int resId;
    View.OnClickListener gotosite;

    //생성
    public SiteItem(String site, String category, int resId) {
        this.site = site;
        this.category = category;
        this.resId = resId;
    }

    //변수에 접근할 때 .OO 접근하기보다는 안전하게 getter, setter를 이용합니다.
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getResId() {
        return resId;
    }

    public View.OnClickListener getGotosite() {
        return gotosite;
    }

    public void setGotosite(View.OnClickListener gotosite) {
        this.gotosite = gotosite;
    }

    @Override
    public String toString() {
        return "SiteItem{" +
                "site='" + site + '\'' +
                ", category='" + category + '\'' +
                ", url='" + gotosite + '\''+
                '}';
    }

}
