package calculadoraTrig;

public class CalculadoraImpl implements Calculadora{

    @Override
    public double cos(double number) {
         return (double) Math.cos(number);
    }

    @Override
    public double sin(double number) {
        return (double) Math.sin(number);
    }

    @Override
    public double tan(double number) {
        return (double) Math.tan(number);
    }
}
