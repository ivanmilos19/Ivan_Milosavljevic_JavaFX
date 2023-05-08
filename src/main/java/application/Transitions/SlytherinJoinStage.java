package application.Transitions;
import application.Gaming;
import java.io.IOException;

public class SlytherinJoinStage {
    Gaming gaming = new Gaming();
    public void setGaming(Gaming gaming){
        this.gaming = gaming;
    }

    public void handleYesButtonSlytherin() throws IOException {
        gaming.createDeatheaterStage();
    }
    public void handleNoButtonSlytherin() throws IOException {
        gaming.closeStage();
    }

}
