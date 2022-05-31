package starter.implementation;

import com.google.gson.Gson;
import starter.utils.jsondata.Building;
import starter.utils.jsondata.Office;
import starter.utils.jsondata.Workplace;

import java.io.FileReader;
import java.util.List;

import static starter.utils.ConstXpath.*;

public class Navigation extends BasePageObject {

    public void navigateToOffice(String officeId) {
        try {
            Gson gson = new Gson();
            FileReader fileReader = new FileReader("src/test/resources/navigation/workplace.json");
            Workplace workplace = gson.fromJson(fileReader, Workplace.class);
            System.out.println(workplace);


            String[] xpaths = new String[2];
            List<Building> buildings = workplace.buildings;

            for (Building build : buildings) {
                for (Office off : build.offices) {
                    if (off.officeId.equals(officeId)) {
                        xpaths[0] = build.xpath;
                        xpaths[1] = off.xpath;
                    }
                }
            }
            gotoHome();
            gotoBooking();
            gotoWorkplace();
            gotoBuildings(xpaths[0]);
            gotoOffice(xpaths[1]);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void gotoHome() {
        click(LOGO_XP);
    }

    public void gotoBooking() {
        click(EXPAND_NAVBAR_XP);
        click(MENU_ICON_MAP_XP);
    }

    public void gotoWorkplace() {
        click(WORKPLACE_XP);
    }

    public void gotoBuildings(String buildXpath) {
        click(buildXpath);
    }

    public void gotoOffice(String offXpath) {
        click(offXpath);
    }

    public void sleep(int sec) {
       super.sleep(sec);
    }

}
