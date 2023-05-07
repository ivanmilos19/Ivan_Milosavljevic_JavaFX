package application.Transitions;

import application.Gaming;

import java.io.IOException;

public class StageTransition {
    Gaming gaming = new Gaming();
    public void setGaming(Gaming gaming){
        this.gaming = gaming;
    }

    public void handleYesButton() throws IOException {
        gaming.createShopStageBasilic();
        gaming.closeStage();
    }
    public void handleNoButton() throws IOException {
        switch(gaming.wizard.getLevel()) {
            case 2:
                gaming.createBasilicStage();
                break;
            case 3:
                gaming.createDementorStage();
                break;
            case 4:
                gaming.createHangletonStage();
                break;
            case 5:
                gaming.createDoloresStage();
                break;
            case 6:
                gaming.createDeatheaterStage();
                break;
            default:
                break;
        }
        gaming.closeStage();
    }

}
