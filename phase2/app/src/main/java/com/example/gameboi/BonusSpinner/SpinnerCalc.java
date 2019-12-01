package com.example.gameboi.BonusSpinner;

/**
 * This class is responsible for calculating where the wheel landed and the User's multiplier
 */
class SpinnerCalc {

    /**
     * This is a string of the sections of the spinning wheel, representing the multiplier that the
     * User gets
     * It follows the order of the wheel, @drawable/spinningwheel.png
     */
    private final int[] SECTIONS = {1, 3, 1, 2};


    /**
     * Gets the User;s new multiplier after spinning the bonus wheel
     * degree is
     *
     * @param multiplier The User's multiplier before getting the bonus multiplier
     * @param degree     The degree of the wheel of where it landed
     * @return the User's new multiplier including the bonus
     */
    int getNewMultiplier(int multiplier, int degree) {
        return multiplier * getWheelSection(360 - (degree % 360));
    }

    /**
     * Calculates the multiplier that the User gets after spinning the wheel, by taking the degree
     * of where it landed on and giving which section 1, 2, 3x of what the User gets
     *
     * @param degrees The degree of the wheel that the spinner landed on
     * @return The multiplier String of which section of the wheel it is on
     */
    private int getWheelSection(int degrees) {

        //Divide the 360 degree wheel into angles for each sector on the Spinner
        float halfSector = 360f / 4f;

        int i = 0;
        int multiplyNum = 0;

        do {
            // Get the angles of each section of the spinner wheel
            float start = halfSector * (i);
            float end = halfSector * (i + 1);

            // if degrees is in this section of the wheel, set text to that section
            if (degrees >= start && degrees < end) {
                multiplyNum = SECTIONS[i];
            }
            i++;
        } while (multiplyNum == 0 && i < SECTIONS.length);

        return multiplyNum;
    }

}
