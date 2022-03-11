package ru.alexander_kramarenko.simtest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestLauncher {
    public static void start(String className) throws InvocationTargetException, IllegalAccessException {
        int countBeforeSuite = 0;
        int countAfterSuite = 0;

        Class tst = TestsSet.class; // // получаем ссылку на класс TestsSet  с аннотациями
        Method[] tstMethods = tst.getDeclaredMethods();   // получаем все объявленные методы
        for (Method m : tstMethods) {   // перебираем массив методов
            if (m.isAnnotationPresent(BeforeSuite.class)) {  // проверяем наличие аннотации BeforeSuite
                countBeforeSuite++; // считаем сколько раз встречается BeforeSuite
            }

            if (m.isAnnotationPresent(AfterSuite.class)) {  // проверяем наличие аннотации AfterSuite
                countAfterSuite++;  // считаем сколько раз встречается AfterSuite
            }

            if (countBeforeSuite > 1 || countAfterSuite > 1) {
                throw new RuntimeException("Аннотация countBeforeSuite или countAfterSuite используется более 1 раза.");
            }
        }


        Class cl = Calculator.class;  // получаем ссылку на класс Calculator
        Method[] calcMethods = cl.getDeclaredMethods();  // получаем все объявленные методы


        for (Method m : tstMethods) {   // перебираем массив методов класса TestSet
            if (m.isAnnotationPresent(BeforeSuite.class)) {  // ищем аннотацию BeforeSuite
                m.invoke(null);  // запускаем для инициализации
            }
        }

        for (Method m : tstMethods) {   // перебираем массив методов класса TestSet
            if (m.isAnnotationPresent(TestAdd.class)) {  // ищем аннотацию TestAdd
                for (Method calc1 : calcMethods) {   // перебираем массив методов калькулятора
                    if (calc1.isAnnotationPresent(TestAdd.class)) {
                        m.invoke(null, calc1);
                    }
                }
            }

            if (m.isAnnotationPresent(TestDiv.class)) {  // ищем аннотацию TestDiv
                for (Method calc1 : calcMethods) {   // перебираем массив методов калькулятора
                    if (calc1.isAnnotationPresent(TestDiv.class)) {
                        m.invoke(null, calc1);
                    }
                }
            }

            if (m.isAnnotationPresent(TestMul.class)) {  // ищем аннотацию TestMul
                for (Method calc1 : calcMethods) {   // перебираем массив методов калькулятора
                    if (calc1.isAnnotationPresent(TestMul.class)) {
                        m.invoke(null, calc1);
                    }
                }
            }

            if (m.isAnnotationPresent(TestSub.class)) {  // ищем аннотацию TestMul
                for (Method calc1 : calcMethods) {   // перебираем массив методов калькулятора
                    if (calc1.isAnnotationPresent(TestSub.class)) {
                        m.invoke(null, calc1);
                    }
                }
            }
        }

        for (Method m : tstMethods) {   // // перебираем массив методов класса TestSet
            if (m.isAnnotationPresent(AfterSuite.class)) {  // ищем аннотацию AfterSuite
                m.invoke(null);  // запускаем для печати результатов теста
            }
        }
    }
}
