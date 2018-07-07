package modules;

import static supports.CommonFunctions.*;

public class DebugTest {

    public static void main(String[] args) {
        launchBrowser("chrome");
        visit("http://the-internet.herokuapp.com/nested_frames");
        handleAlertPopup();
    }
}
