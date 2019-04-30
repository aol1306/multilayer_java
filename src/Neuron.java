import java.util.ArrayList;
import java.util.Random;

public class Neuron {
    public static final Double LAMBDA = 1.0;

    public ArrayList<Double> weights;
    public Double bias;

    public Neuron(Integer inputs) {
        // random init
        this.weights = new ArrayList<>();
        this.bias = getRandom();
        for (int i=0; i<inputs; i++) {
            this.weights.add(getRandom());
        }
    }

    public static Double activation(Double x) {
        return 1.0 / (1.0 + Math.pow(Math.E, -LAMBDA*x));
    }

    public static Double derivedActivation(Double x) {
        Double actX = activation(x);
        return LAMBDA * actX * (1.0 - actX);
    }

    public Double calculateOutput(ArrayList<Double> x) {
        assert x.size() == this.weights.size();
        Double out = 0.0;
        for (int i=0; i<x.size(); i++) {
            out += x.get(i) * weights.get(i);
        }
        out += this.bias;
        return activation(out);
    }

    private Double getRandom() {
        Random r = new Random();
        return -10.0 + (10.0 - -10.0) * r.nextDouble();
    }
}
