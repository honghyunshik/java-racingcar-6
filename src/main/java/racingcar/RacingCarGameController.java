package racingcar;

import com.sun.jdi.InvalidTypeException;
import domain.Cars;
import dto.UserInputCarMoveCountDto;
import service.CarMoveService;
import service.CarRacingWinnerService;
import service.UserInputCarMoveCountFactory;
import service.UserInputCarNameFactory;
import ui.Input;

public class RacingCarGameController {

    private UserInputCarNameFactory userInputCarNameFactory;
    private UserInputCarMoveCountFactory userInputCarMoveCountFactory;
    private CarMoveService carMoveService;
    private CarRacingWinnerService carRacingWinnerService;

    public RacingCarGameController(UserInputCarNameFactory userInputCarNameFactory,
                                   UserInputCarMoveCountFactory userInputCarMoveCountFactory,
                                   CarMoveService carMoveService,
                                   CarRacingWinnerService carRacingWinnerService){
        this.userInputCarNameFactory = userInputCarNameFactory;
        this.userInputCarMoveCountFactory = userInputCarMoveCountFactory;
        this.carMoveService = carMoveService;
        this.carRacingWinnerService = carRacingWinnerService;
    }
    public void play() throws InvalidTypeException {

        //1. 차 이름사용자 입력
        Input.carNameReadLine();

        //2. Cars 객체 생성
        Cars cars = userInputCarNameFactory.createCars();

        //3. 이동 횟수 사용자 입력
        UserInputCarMoveCountDto userInputCarMoveCountDto = userInputCarMoveCountFactory.createUserInputCarMoveCountDto();

        //4. 자동차 전진
        carMoveService.move(cars,userInputCarMoveCountDto);

        //5. 우승자 판별
        carRacingWinnerService.selectWinner(cars);

        //6. 우승자 출력
    }
}
