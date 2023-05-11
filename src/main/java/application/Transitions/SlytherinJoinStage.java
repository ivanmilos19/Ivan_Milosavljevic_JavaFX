package application.Transitions;
import application.Gaming;
import java.io.IOException;

public class SlytherinJoinStage {
    Gaming gaming;
    public SlytherinJoinStage(Gaming gaming) {
        this.gaming = gaming;
    }

    public void handleYesButtonSlytherin() throws IOException {
        gaming.closeSlytherinJoinStage();
        gaming.createJoinedSlytherinStage();
    }
    public void handleNoButtonSlytherin() throws IOException {
        gaming.createDeatheaterStage();
        gaming.closeSlytherinJoinStage();
    }

}
