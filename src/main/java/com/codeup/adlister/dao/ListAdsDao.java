package com.codeup.adlister.dao;


import com.codeup.adlister.models.Ad;

import java.util.ArrayList;
import java.util.List;

public class ListAdsDao implements Ads {
    private List<Ad> ads;

    public List<Ad> all() {
        return ads;
    }


    public Long insert(Ad ad) {
        ad.setId((long) ads.size());
        ads.add(ad);
        return ad.getId();
    }

    @Override
    public Ad individualAd(long adID) {
        return null;
    }

    @Override
    public List<Ad> searchedAds(String s, String c) {
        return null;
    }

    @Override
    public void editTitle(String title, String adId) {

    }

    @Override
    public void editDescription(String description, String adId) {

    }

    @Override
    public void deleteAd(String adId) {

    }

    @Override
    public Ad findById(long id) {
        return ads.get((int) id - 1);
    }


    @Override
    public List<Ad> getAdsByUser(long user_id) {
        return null;
    }

}
