package com.github.wenhao.geohash;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.Serializable;

@RunWith(JUnit4.class)
public class GeoHashTest implements Serializable {

    @Test
    public void should_be_able_to_convert_coordinate_to_bits() {
        // given

        // when
        GeoHash geoHash = GeoHash.fromCoordinate(30.5451620000, 104.0620180000);

        // then
        Assert.assertEquals(geoHash.toLong(), 4024745045182841L);
    }

    @Test
    public void should_be_able_to_convert_bits_to_coordinate() {
        // given

        // when
        GeoHash geoHash = GeoHash.fromLong(4024745045182841L);

        // then
        Assert.assertEquals(geoHash.toLong(), 4024745045182841L);
        Assert.assertNotNull(geoHash.coordinate());
    }

    @Test
    public void should_be_able_to_get_adjacent_coordinates() {
        // given

        // when
        GeoHash geoHash = GeoHash.fromCoordinate(30.5451620000, 104.0620180000);

        // then
        Assert.assertEquals(geoHash.getAdjacent().size(),9);
        Assert.assertNotNull(geoHash.getAdjacent().get(0).coordinate());
    }

    @Test
    public void should_be_able_to_get_distance() {
        // given

        // when
        GeoHash geoHash = GeoHash.fromCoordinate(30.5451620000, 104.0620180000);
        double distance = geoHash.distance(30.5665420000, 104.0754680000);

        // then
        Assert.assertEquals(distance, 2704.544654847537D);
    }

    @Test
    public void should_be_able_to_get_bin_string() {
        // given

        // when
        GeoHash geoHash = GeoHash.fromCoordinate(30.5328140000, 104.0761330000);

        // then
        Assert.assertEquals(geoHash.toString(),"1110010011001101000101000101100001101110110010100110");
    }
}
