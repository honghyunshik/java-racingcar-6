package service;

import domain.Car;
import domain.Cars;
import ui.Input;
import util.CarList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputCarNameFactory {

    public Cars createCars(){
        String[] carNameInputArray = processCarNameInput();

        ArrayList<Car> carList = (ArrayList<Car>) Arrays.stream(carNameInputArray)
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(new CarList<>(carList));
    }

    //Input 데이터 가공
    private String[] processCarNameInput() {
        return Arrays.stream(Input.input.split(","))
                .map(String::trim)
                .peek(carName -> {
                    if (!isValid(carName)) {
                        throw new IllegalArgumentException("5글자를 초과했습니다.");
                    }
                })
                .toArray(String[]::new);
    }

    private boolean isValid(String carName){
        return carName.length()<=5;
    }
}
