import java.util.ArrayList;
import java.util.Arrays;

public class TrainingData {
    public ArrayList<Double> inputs;
    public ArrayList<Double> expected;

    public static ArrayList<TrainingData> generateForNumbers() {
        ArrayList<TrainingData> ret = new ArrayList<>();

        TrainingData zero = new TrainingData();
        zero.inputs = new ArrayList<>(Arrays.asList(
                0.0, 1.0, 1.0, 0.0,
                1.0, 0.0, 0.0, 1.0,
                1.0, 0.0, 0.0, 1.0,
                1.0, 0.0, 0.0, 1.0,
                1.0, 0.0, 0.0, 1.0,
                0.0, 1.0, 1.0, 0.0));
        zero.expected = new ArrayList<>(Arrays.asList(
                1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
        ));
        ret.add(zero);

        TrainingData one = new TrainingData();
        one.inputs = new ArrayList<>(Arrays.asList(
                0.0, 0.0, 1.0, 0.0,
                0.0, 0.0, 1.0, 0.0,
                0.0, 0.0, 1.0, 0.0,
                0.0, 0.0, 1.0, 0.0,
                0.0, 0.0, 1.0, 0.0,
                0.0, 0.0, 1.0, 0.0));
        one.expected = new ArrayList<>(Arrays.asList(
                0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
        ));
        ret.add(one);

        TrainingData two = new TrainingData();
        two.inputs = new ArrayList<>(Arrays.asList(
                0.0, 1.0, 1.0, 0.0,
                1.0, 0.0, 0.0, 1.0,
                0.0, 0.0, 0.0, 1.0,
                0.0, 0.0, 1.0, 0.0,
                0.0, 1.0, 0.0, 0.0,
                1.0, 1.0, 1.0, 1.0));
        two.expected = new ArrayList<>(Arrays.asList(
                0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
        ));
        ret.add(two);

        TrainingData three = new TrainingData();
        three.inputs = new ArrayList<>(Arrays.asList(
                1.0, 1.0, 1.0, 0.0,
                0.0, 0.0, 0.0, 1.0,
                0.0, 1.0, 1.0, 1.0,
                0.0, 0.0, 0.0, 1.0,
                0.0, 0.0, 0.0, 1.0,
                1.0, 1.0, 1.0, 1.0));
        three.expected = new ArrayList<>(Arrays.asList(
                0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
        ));
        ret.add(three);

        TrainingData four = new TrainingData();
        four.inputs = new ArrayList<>(Arrays.asList(
                1.0, 0.0, 1.0, 0.0,
                1.0, 0.0, 1.0, 0.0,
                1.0, 0.0, 1.0, 0.0,
                1.0, 1.0, 1.0, 1.0,
                0.0, 0.0, 1.0, 0.0,
                0.0, 0.0, 1.0, 0.0));
        four.expected = new ArrayList<>(Arrays.asList(
                0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0
        ));
        ret.add(four);

        TrainingData five = new TrainingData();
        five.inputs = new ArrayList<>(Arrays.asList(
                1.0, 1.0, 1.0, 1.0,
                1.0, 0.0, 0.0, 0.0,
                1.0, 1.0, 1.0, 0.0,
                0.0, 0.0, 0.0, 1.0,
                0.0, 0.0, 0.0, 1.0,
                1.0, 1.0, 1.0, 0.0));
        five.expected = new ArrayList<>(Arrays.asList(
                0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0
        ));
        ret.add(five);

        TrainingData six = new TrainingData();
        six.inputs = new ArrayList<>(Arrays.asList(
                0.0, 1.0, 1.0, 0.0,
                1.0, 0.0, 0.0, 0.0,
                1.0, 1.0, 1.0, 0.0,
                1.0, 0.0, 0.0, 1.0,
                1.0, 0.0, 0.0, 1.0,
                1.0, 1.0, 1.0, 1.0));
        six.expected = new ArrayList<>(Arrays.asList(
                0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0
        ));
        ret.add(six);

        TrainingData seven = new TrainingData();
        seven.inputs = new ArrayList<>(Arrays.asList(
                1.0, 1.0, 1.0, 1.0,
                0.0, 0.0, 0.0, 1.0,
                0.0, 0.0, 0.0, 1.0,
                0.0, 0.0, 1.0, 0.0,
                0.0, 1.0, 0.0, 0.0,
                1.0, 0.0, 0.0, 0.0));
        seven.expected = new ArrayList<>(Arrays.asList(
                0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0
        ));
        ret.add(seven);

        TrainingData eight = new TrainingData();
        eight.inputs = new ArrayList<>(Arrays.asList(
                0.0, 1.0, 1.0, 0.0,
                1.0, 0.0, 0.0, 1.0,
                0.0, 1.0, 1.0, 0.0,
                1.0, 0.0, 0.0, 1.0,
                1.0, 0.0, 0.0, 1.0,
                0.0, 1.0, 1.0, 0.0));
        eight.expected = new ArrayList<>(Arrays.asList(
                0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0
        ));
        ret.add(eight);

        TrainingData nine = new TrainingData();
        nine.inputs = new ArrayList<>(Arrays.asList(
                0.0, 1.0, 1.0, 0.0,
                1.0, 0.0, 0.0, 1.0,
                0.0, 1.0, 1.0, 1.0,
                0.0, 0.0, 0.0, 1.0,
                0.0, 0.0, 1.0, 0.0,
                1.0, 1.0, 0.0, 0.0));
        nine.expected = new ArrayList<>(Arrays.asList(
                0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0
        ));
        ret.add(nine);

        return ret;
    }
}
