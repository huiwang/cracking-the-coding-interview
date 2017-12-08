package mathlogic;

/**
 * You have 20 bottles of pills. 19 bottles have 1.0 gram pills, but one has pills of weight 1.1 grams.
 * Given a scale that provides an exact measurement, how would you find the heavy bottle?
 * You can only use the scale once.
 */
public class _06_01_TheHeavyPill {

    /**
     * pick one pill form the #1 bottle and two pills from #2 bottle and n pills from #n bottle
     * according the extra contribution, we can't identify the bottle with heavy pills
     * weight = normalWeight + extraWeight where normalWeight = (1 + 2 + ... + 20) = 20 * ( 1 + 20)/2 = 210
     * #bottle = (weight - 210) / 0.1
     * <p>
     * note that we need to assume there are enough pills in the bottles
     */
    void solution() {
    }

}
