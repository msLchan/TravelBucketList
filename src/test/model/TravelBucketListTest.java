package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TravelBucketListTest {
    public TravelBucketList testTravelBucketList;
    TravelBucketList tbl1;
    TravelBucketList tbl2;
    TravelBucketList tbl3;

    @BeforeEach
    void runBefore() {
        tbl1 = new TravelBucketList("Paris, London");
        tbl2 = new TravelBucketList("Melbourne, Victoria, Hong Kong");
        tbl3 = new TravelBucketList("Tokyo, Seoul, Montreal, Florence");
    }

    @Test
    void testConstructor() {
        
    }

    @Test
    void sampleTest() {
        assertTrue(true);
    }
}
