import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Network {

    public ArrayList<ArrayList<Neuron>> layers;
    public Double alpha;

    public Network(Double alpha, List<Integer> layout, Integer inputs) {
        // initialize object
        layers = new ArrayList<>();
        this.alpha = alpha;

        // create neurons
        // input layer
        layers.add(new ArrayList<>());
        for (int i=0; i<layout.get(0); i++) {
            layers.get(0).add(new Neuron(inputs));
        }
        // other layers
        if (layout.size() > 1) {
            for (int i=1; i<layout.size(); i++) {
                layers.add(new ArrayList<>());
                for (int j=0; j<layout.get(i); j++) {
                    layers.get(i).add(new Neuron(layout.get(i-1)));
                }
            }
        }
    }

    public ArrayList<Double> calculateLayerResult(ArrayList<Double> x, Integer layer) {
        ArrayList<Double> result = new ArrayList<>();
        for (Neuron neuron : this.layers.get(layer)) {
            result.add(neuron.calculateOutput(x));
        }
        return result;
    }

    public ArrayList<Double> calculateNetworkOutput(ArrayList<Double> x) {
        ArrayList<Double> lastLayerResult = this.calculateLayerResult(x, 0);
        if (this.layers.size() > 1) {
            for (int i=1; i<this.layers.size(); i++) {
                lastLayerResult = this.calculateLayerResult(lastLayerResult, i);
            }
        }
        return lastLayerResult;
    }

    public ArrayList<ArrayList<Double>> calculateNetworkOutputFull(ArrayList<Double> x) {
        ArrayList<ArrayList<Double>> ret = new ArrayList<>();
        ret.add(this.calculateLayerResult(x, 0));

        for (int i=1; i<this.layers.size(); i++) {
            ret.add(this.calculateLayerResult(ret.get(i-1), i));
        }

        return ret;
    }

    public void recalculateWeights(ArrayList<Double> input, ArrayList<Double> received, ArrayList<Double> expected, ArrayList<ArrayList<Double>> allNeuronOuts) {
        ArrayList<ArrayList<Double>> errors = new ArrayList<>();

        // output layer
        errors.add(new ArrayList<>());
        for (int i=0; i<this.layers.get(this.layers.size()-1).size(); i++) {
            // neuron error
            Double e = (expected.get(i) - received.get(i)) * Neuron.derivedActivation(received.get(i));
            errors.get(0).add(e);
        }

        // other layers
        if (this.layers.size() > 1) {
            for (int i=this.layers.size()-2; i>=0; i--) { // i is layer number
                // from last layer to input
                errors.add(new ArrayList<>());
                for (int j=0; j<this.layers.get(i).size(); j++) { // j is neuron number
                    Double e = 0.0;
                    int errors_last = errors.size() - 1;
                    for (int k=0; k<this.layers.get(i+1).size(); k++) { // k is neuron from next layer number
                        // for every neuron in next layer
                        e += this.layers.get(i+1).get(k).weights.get(j) *
                                errors.get(errors_last - 1)
                                        .get(k);

                    }
                    e *= Neuron.derivedActivation(allNeuronOuts.get(i).get(j));
                    errors.get(errors_last).add(e);
                }
            }
        }

        Collections.reverse(errors); // we put in backwards, so now reverse

        // recalculate weights for first layer
        for (int i=0; i<this.layers.get(0).size(); i++) { // i is neuron number
            for (int j=0; j<this.layers.get(0).get(i).weights.size(); j++) { // j is weight number
                Double w = this.layers.get(0).get(i).weights.get(j);
                Double new_w = w + this.alpha * errors.get(0).get(i) * input.get(j);
                // update weight
                this.layers.get(0).get(i).weights.set(j, new_w);
            }
            Double b = this.layers.get(0).get(i).bias;
            Double new_b = b + this.alpha * errors.get(0).get(i);
            // update bias
            this.layers.get(0).get(i).bias = new_b;
        }

        // recalculate weights for all other layers
        for (int i=1; i<this.layers.size(); i++) { // i is layer number
            for (int j=0; j<this.layers.get(i).size(); j++) { // j is neuron number
                for (int k = 0; k < this.layers.get(i).get(j).weights.size(); k++) { // k is weight number
                    Double w = this.layers.get(i).get(j).weights.get(k);
                    Double new_w = w + this.alpha * errors.get(i).get(j) * allNeuronOuts.get(i-1).get(k);
                    // update weight
                    this.layers.get(i).get(j).weights.set(k, new_w);
                }
                Double b = this.layers.get(i).get(j).bias;
                Double new_b = b + this.alpha * errors.get(i).get(j);
                // update bias
                this.layers.get(i).get(j).bias = new_b;
            }
        }
    }

    public Double calculateNetworkError(ArrayList<Double> expected, ArrayList<Double> received) {
        Double netError = 0.0;
        for (int i=0; i<expected.size(); i++) {
            netError += Math.pow(expected.get(i) - received.get(i), 2);
        }
        return netError / 2.0;
    }

    public void startLearning(ArrayList<TrainingData> trainingData, Double stopError) {
        for (int i=0; i<Main.MAX_LEARNING_EPOCH; i++) {
            System.out.println("Epoch "+i);
            Double epochError = 0.0;
            for (TrainingData training : trainingData) {
                ArrayList<ArrayList<Double>> out = this.calculateNetworkOutputFull(training.inputs);
                this.recalculateWeights(training.inputs, out.get(out.size()-1), training.expected, out);
                epochError += calculateNetworkError(training.expected, out.get(out.size()-1));
            }
            Collections.shuffle(trainingData);
            System.out.println("Epoch error: "+epochError);
            if (epochError < stopError) {
                break;
            }
        }
        System.out.println("Learning completed");
    }

}
