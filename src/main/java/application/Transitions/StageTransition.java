package application.Transitions;
import application.Gaming;
import java.io.IOException;

public class StageTransition {
    Gaming gaming = new Gaming();
    public void setGaming(Gaming gaming){
        this.gaming = gaming;
    }

    public void handleYesButton() throws IOException {
        gaming.createShopStage();
        gaming.closeTransitionStage();
    }
    public void handleNoButton() throws IOException {
        switch (gaming.wizard.getLevel()) {
            case 2 -> gaming.createBasilicStage();
            case 3 -> gaming.createDementorStage();
            case 4 -> gaming.createHangletonStage();
            case 5 -> gaming.createDoloresStage();
            case 6 ->
            {
                if (gaming.joinEnemy()) {
                    gaming.createJoinSlytherinStage();
                } else {
                    gaming.createDeatheaterStage();
                }
            }
            case 7 -> gaming.createVoldemortStage();
            default -> {
            }
            case 8 -> gaming.createFinishedGame();
        }
        gaming.closeTransitionStage();
    }

}
