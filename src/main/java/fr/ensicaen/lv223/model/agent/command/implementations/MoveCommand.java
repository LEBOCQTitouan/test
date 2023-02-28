package fr.ensicaen.lv223.model.agent.command.implementations;

import fr.ensicaen.lv223.model.agent.command.Command;
import fr.ensicaen.lv223.model.agent.robot.Robot;
import fr.ensicaen.lv223.model.logic.localisation.Direction;
import fr.ensicaen.lv223.model.logic.localisation.RobotMapper;

import java.util.Random;

public class MoveCommand extends Command {
    public Direction direction;

    public MoveCommand(Robot robot, RobotMapper robotMapper, Direction dir) {
        super(robot, robotMapper, 1);
        Random random = new Random();
        this.direction = dir;
    }

    @Override
    public void apply() {
        robotMapper.moveRobot(robot, direction.getDirection_x(), direction.getDirection_y());
    }

    @Override
    public void unapply() {
        robotMapper.moveRobot(robot, -direction.getDirection_x(), -direction.getDirection_y());    }
}
