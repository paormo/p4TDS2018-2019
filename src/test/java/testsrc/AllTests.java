package testsrc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PruebaSecuenciaTests.class, AsignaturaSecuenciaTests.class,AsignaturaTestNoValidos.class, AsignaturaTestsTDD.class, PruebaTestNoValidos.class })
public class AllTests {

}
