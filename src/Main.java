import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Задание 1.
        Predicate<Integer> isPositiveInt = i -> i > 0;
        Predicate<Float> isPositiveFloat = f -> f > 0;

        Integer i = 12;
        Float f = -0.2f;

        System.out.println(i + " : " + (isPositiveInt.test(i) ? "положительное число" :
                "не положительное число"));
        System.out.println(f + " : " + (isPositiveFloat.test(f) ? "положительное число" :
                "не положительное число"));

        Long l = 256L;
        Double d = -10_000.036;

        Predicate<Long> isPositiveLong = new Predicate<Long>() {
            @Override
            public boolean test(Long aLong) {
                return aLong > 0;
            }
        };

        Predicate<Double> isPositiveDouble = new Predicate<Double>() {
            @Override
            public boolean test(Double aDouble) {
                return aDouble > 0;
            }
        };

        System.out.println();
        System.out.println(l + " : " + (isPositiveLong.test(l) ? "положительное число" :
                "не положительное число"));
        System.out.println(d + " : " + (isPositiveDouble.test(d) ? "положительное число" :
                "не положительное число"));

        // Задание 2.
        Consumer<String> consumerLambda = s -> System.out.println("Hello " + s);
        Consumer<String> consumerAnon = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hi " + s);
            }
        };

        System.out.println();
        consumerLambda.accept("Mary");
        consumerAnon.accept("Juan");

        // Задание 3.
        Function<Double, Long> functionLambda = aDouble ->  aDouble.longValue();
        Function<Double, Long> functionAnon = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };

        System.out.println();
        System.out.println(functionLambda.apply(13.923654));
        System.out.println(functionAnon.apply(-2.0001));

        // Задание 4.
        Supplier<Integer> supplierLambda = () -> {
            Random random = new Random();
            return random.nextInt(101);
        };
        Supplier<Integer> supplierAnon = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random random = new Random();
                return random.nextInt(101);
            }
        };

        System.out.println();
        System.out.println(supplierLambda.get());
        System.out.println(supplierAnon.get());

        // Задание 5.
        Predicate<Integer> isNegativeInt = integer -> integer < 0;
        Function<Integer, Integer> cubeInt = integer -> integer * integer * integer;
        Function<Integer, Integer> squareInt = integer -> integer * integer;

        Predicate<Float> isNegativeFloat = fl -> fl < 0;
        Function<Float, Float> cubeFloat = fl -> fl * fl * fl;
        Function<Float, Float> squareFloat = fl -> fl * fl;

        Integer nn = -20;
        Float ff = 203.654f;

        System.out.println();
        System.out.println(ternaryOperator(isNegativeInt, cubeInt, squareInt).apply(nn));
        System.out.println(ternaryOperator(isNegativeFloat, cubeFloat, squareFloat).apply(ff));


    } //

    // Задание 5.
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        //return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);

        return t -> {
            if (condition.test(t)) {
                return ifTrue.apply(t);
            } else {
                return ifFalse.apply(t);
            }
        };
    }
}