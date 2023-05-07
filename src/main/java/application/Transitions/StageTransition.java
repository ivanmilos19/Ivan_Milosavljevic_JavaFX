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
        if (gaming.wizard.getLevel() == 2) {
            gaming.createBasilicStage();
            gaming.closeStage();
        } if (gaming.wizard.getLevel() == 3) {
            gaming.createDementorStage();
            gaming.closeStage();
        } if (gaming.wizard.getLevel() == 4) {
            gaming.createHangletonStage();
            gaming.closeStage();
        } if (gaming.wizard.getLevel() == 5) {
            gaming.createDoloresStage();
            gaming.closeStage();
        } if (gaming.wizard.getLevel() == 6) {
            gaming.createDeatheaterStage();
            gaming.closeStage();
        }
    }
}
