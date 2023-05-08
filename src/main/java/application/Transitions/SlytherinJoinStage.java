package application.Transitions;
import application.Gaming;
import java.io.IOException;

public class SlytherinJoinStage {
    Gaming gaming;
    public SlytherinJoinStage(Gaming gaming) {
        this.gaming = gaming;
    }

    public void handleYesButtonSlytherin() {
        gaming.closeSlytherinJoinStage();
    }
    public void handleNoButtonSlytherin() throws IOException {
        gaming.createDeatheaterStage();
        gaming.closeSlytherinJoinStage();
    }

}
