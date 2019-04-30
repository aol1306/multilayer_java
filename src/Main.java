import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static final int MAX_LEARNING_EPOCH = 100000;

    public static void main(String[] args) {
        Network network = new Network(0.3, new ArrayList<>(Arrays.asList(15,10)), 24);
        ArrayList<TrainingData> trainingData = TrainingData.generateForNumbers();
        network.startLearning(trainingData, 0.1);

        ArrayList<TrainingData> verificationData = TrainingData.generateForNumbers();
        for (TrainingData example : verificationData) {
            System.out.println(network.calculateNetworkOutput(example.inputs));
            System.out.println();
        }
    }
}
