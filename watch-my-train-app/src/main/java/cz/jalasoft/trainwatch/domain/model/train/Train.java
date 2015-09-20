package cz.jalasoft.trainwatch.domain.model.train;

/**
 * @author Honza Lastovicka
 * @since 16.8.15
 */
public class Train {

    private TrainNumber number;
    private TrainOnlineInfoService trainInfoService;

    Train(TrainNumber number, TrainOnlineInfoService trainInfoService) {
       setNumber(number);
       this.trainInfoService = trainInfoService;
    }

    private void setNumber(TrainNumber number) {
        if (number == null) {
            throw new IllegalArgumentException("Train number must not be null.");
        }
        this.number = number;
    }

    public TrainNumber number() {
        return number;
    }

    public String fullName() {
        return number.fullName();
    }
}
