package com.example.gameboi.BonusSpinner;

class SpinnerCalc {

    /**
     * This is a string of the sections of the spinning wheel, representing the multiplier that the
     * User gets
     * It follows the order of the wheel, @drawable/spinningwheel.png
     */
    private final String[] sections = {"1", "3", "1", "2"};


    /**
     * Calculates the multiplier that the User gets after spinning the wheel, by taking the degree
     * of where it landed on and giving which section 1, 2, 3x of what the User gets
     *
     * @param degrees The degree of the wheel that the spinner landed on
     * @return The multiplier String of which section of the wheel it is on
     */
    String getWheelSection(int degrees) {

        //Divide the 360 degree wheel into angles for each sector on the Spinner
        float HALF_SECTOR = 360f / 4f / 2f;

        int i = 0;
        String text = null;

        do {
            // Get the angles of each section of the spinner wheel
            float start = HALF_SECTOR * (i * 2);
            float end = HALF_SECTOR * (i * 2 + 2);

            // if degrees is in this section of the wheel, set text to that section
            if (degrees >= start && degrees < end) {
                text = sections[i];
            }
            i++;
        } while (text == null && i < sections.length);

        return text;
    }
}
