package ru.alexander_kramarenko.simtest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public   class TestsSet {

     static int additionParam1;
     static int additionParam2;
     static int additionExpectedResult;
     static int additionPracticalResult;

     static int divisionParam1;
     static int divisionParam2;
     static int divisionExpectedResult;
     static int divisionPracticalResult;

     static int multiplicationParam1;
     static int multiplicationParam2;
     static int multiplicationExpectedResult;
     static int multiplicationPracticalResult;

     static int substractionParam1;
     static int substractionParam2;
     static int substractionExpectedResult;
     static int substractionPracticalResult;

     @BeforeSuite
     public static void initTestParams(){
          additionParam1 = 2;
          additionParam2 = 2;
          additionExpectedResult = 4;
//          additionExpectedResult = 5;


          divisionParam1 = 10;
          divisionParam2 = 5;
          divisionExpectedResult =2;
//          divisionExpectedResult =3;


          multiplicationParam1 = 4;
          multiplicationParam2 = 4;
          multiplicationExpectedResult =16;
//          multiplicationExpectedResult =17;


          substractionParam1 = 10;
          substractionParam2 = 2;
          substractionExpectedResult =8;
//          substractionExpectedResult =12;

     }


     @TestAdd
     public static  void testAddition(Method add) throws InvocationTargetException, IllegalAccessException {

          additionPracticalResult = (int) add.invoke(null, additionParam1, additionParam2);

     }

     @TestDiv
     public static void testDivision(Method div) throws InvocationTargetException, IllegalAccessException {

          divisionPracticalResult = (int) div.invoke(null, divisionParam1, divisionParam2);


     }

     @TestMul
     public static void testMultiplication(Method mult) throws InvocationTargetException, IllegalAccessException {
          multiplicationPracticalResult = (int) mult.invoke(null, multiplicationParam1, multiplicationParam2);

     }


     @TestSub
     public static  void testSubtraction(Method sub) throws InvocationTargetException, IllegalAccessException {
          substractionPracticalResult = (int) sub.invoke(null, substractionParam1, substractionParam2);

     }


     @AfterSuite
     public static  void reportResults(){

          if (additionExpectedResult == additionPracticalResult){
               System.out.println("Тестирование функции суммирования прошло успешно");
          }
          else {
               System.out.println("Тестирование функции суммирования дало  неверный результат");
               throw new ArithmeticException("Тестирование функции суммирования дало  неверный результат");
          }

          if (divisionExpectedResult == divisionPracticalResult){
               System.out.println("Тестирование функции деления прошло успешно");
          }
          else {
               System.out.println("Тестирование функции деления дало неверный результат");
               throw new ArithmeticException("Тестирование функции деления дало неверный результат");
          }

          if (multiplicationExpectedResult == multiplicationPracticalResult){
               System.out.println("Тестирование функции умножения прошло успешно");
          }
          else {
               System.out.println("Тестирование функции умножения дало неверный результат");
               throw new ArithmeticException("Тестирование функции умножения дало неверный результат");
          }

          if (substractionExpectedResult == substractionPracticalResult){
               System.out.println("Тестирование функции вычитания прошло успешно");
          }
          else {
               System.out.println("Тестирование функции вычитания дало неверный результат");
               throw new ArithmeticException("Тестирование функции вычитания дало неверный результат");
          }
     }
}


