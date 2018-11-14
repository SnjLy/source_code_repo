package com.github.wenhao.geohash;

import com.github.wenhao.geohash.domain.GeoRange;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;


@RunWith(JUnit4.class)
public class GeoSearchTest {

    @Test
    public void should_be_able_to_get_search_start_point_and_end_point_if_provider_search_range() {
        // given

        // when
        List<GeoRange> geoRanges = GeoSearch.range(30.5464140000, 104.0748220000, 3000);

        // then
        Assert.assertEquals(geoRanges.size(),9);
        Assert.assertEquals(geoRanges.get(0).getMin(),4025111615111168L);
        Assert.assertEquals(geoRanges.get(0).getMax(),4025111682220032L);
    }
}