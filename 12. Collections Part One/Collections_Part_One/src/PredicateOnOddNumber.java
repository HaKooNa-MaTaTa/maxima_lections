import java.util.function.Predicate;

public class PredicateOnOddNumber implements Predicate<java.lang.Integer> {


    @Override
    public boolean test(java.lang.Integer integer) {
        //[УСЛОВИЕ ? РЕЗУЛЬТАТ, ЕСЛИ УСЛОВИЕ ВЕРНО : РЕЗУЛЬТАТ, ЕСЛИ УСЛОВИЕ ЛОЖНО]
       //integer % 2 == 0 && integer > 0 ? true : false;

//       if (integer % 2 == 0) {
//           return true;
//       } else {
//           return false;
//       }
       return integer % 2 == 0;
    }
}
