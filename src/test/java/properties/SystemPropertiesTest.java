package properties;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;


public class SystemPropertiesTest {


    @Test
    void simplePropertyTest() {
        String browserName = System.getProperty( "browser" );
        System.out.println(browserName); //null
    }

    @Test
   void simplePropertyTest1() {
        System.setProperty( "browser", "opera" );
        String browserName = System.getProperty( "browser" );
        System.out.println(browserName); //opera
    }

    @Test
   void simplePropertyTest2() {
        String browserName = System.getProperty( "browser", "mozilla" );
        System.out.println(browserName); //mozilla
    }

    @Test
   void simplePropertyTest3() {
        System.setProperty( "browser", "opera" );
        String browserName = System.getProperty( "browser", "mozilla" );
        System.out.println(browserName); //opera
    }

    @Test
    @Tag("oneproperty")
    void simplePropertyTest4() {
        String browserName = System.getProperty( "browser", "mozilla" );
        System.out.println(browserName);
        // ./gradlew clean oneproperty
        // ./gradlew clean oneproperty -Dbrowser=safari
    }

    @Test
    @Tag("manyproperties")
    void simplePropertyTest5() {
        String browserName = System.getProperty( "browser", "mozilla" );
        String browserVersion = System.getProperty( "version", "99.0" );
        System.out.println("browser: " + browserName + "\n" + "version " + browserVersion);
        // ./gradlew clean manyproperties
        // ./gradlew clean manyproperties -Dbrowser=safari -Dversion=100.1
    }

    @Test
    @Tag("hello")
    void simplePropertyTest6() {
        System.out.println(format("Hello, %s!", System.getProperty( "username", "unknown" )));
        // ./gradlew clean hello
        // ./gradlew clean hello -Dusername=vasya
    }


}


