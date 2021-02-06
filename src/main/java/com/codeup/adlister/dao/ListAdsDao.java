package com.codeup.adlister.dao;


import com.codeup.adlister.models.Ad;

import java.util.ArrayList;
import java.util.List;

public class ListAdsDao implements Ads {
    private List<Ad> ads;

    public List<Ad> all() {
//        Need to delete the below code at some point
//        if (ads == null) {
//            ads = generateAds();
//        }
        return ads;
    }


    public Long insert(Ad ad) {
        // make sure we have ads
        //        Need to delete the below code at some point
//        if (ads == null) {
//            ads = generateAds();
//        }
        // we'll assign an "id" here based on the size of the ads list
        // really the dao would handle this
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
