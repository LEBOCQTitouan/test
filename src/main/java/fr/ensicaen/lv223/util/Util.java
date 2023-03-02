package fr.ensicaen.lv223.util;

import fr.ensicaen.lv223.model.agent.command.Command;
import fr.ensicaen.lv223.model.agent.command.CommandFactory;
import fr.ensicaen.lv223.model.agent.command.CommandType;
import fr.ensicaen.lv223.model.agent.robot.Robot;
import fr.ensicaen.lv223.model.environment.cells.Cell;
import fr.ensicaen.lv223.model.logic.localisation.Coordinate;
import fr.ensicaen.lv223.model.logic.localisation.RobotMapper;
import fr.ensicaen.lv223.teams.ProjectTeam;
import fr.ensicaen.lv223.teams.jamesbond.command.MoveCommandJB;
import fr.ensicaen.lv223.teams.jamesbond.robots.RobotInterfaceJB;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.logging.Logger;

public class Util {
    public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static List<Coordinate> getNeighbors(Coordinate coord, int width, int height) {
        ArrayList<Coordinate> neighbors = new ArrayList<>();
        int x = coord.x;
        int y = coord.y;
        if (x > 0) {
            neighbors.add(new Coordinate(x - 1, y));
            if (y > 0) {
                neighbors.add(new Coordinate(x - 1, y - 1));
            }
            if (y < width - 1) {
                neighbors.add(new Coordinate(x - 1, y + 1));
            }
        }
        if (x < height - 1) {
            neighbors.add(new Coordinate(x + 1, y));
            if (y > 0) {
                neighbors.add(new Coordinate(x + 1, y - 1));
            }
            if (y < width - 1) {
                neighbors.add(new Coordinate(x + 1, y + 1));
            }
        }
        if (y > 0) {
            neighbors.add(new Coordinate(x, y - 1));
        }
        if (y < width - 1) {
            neighbors.add(new Coordinate(x, y + 1));
        }
        return neighbors;
    }


    public static PriorityQueue<Command> cellListToCommandList(ArrayList<Cell> AStarPath, ProjectTeam team, Robot rob) {
        PriorityQueue<Command> commandList = new PriorityQueue<>();
        for (int i = 0; i < AStarPath.size() - 1; i++) {
            Cell current = AStarPath.get(i);
            Cell next = AStarPath.get(i + 1);
            if(team==ProjectTeam.JAMES_BOND){
                commandList.add(rob.getCommandFactory().createCommand(rob, CommandType.MOVEJB, current.getDirectionTo(next)));
            }
            else{
                //todo
            }
        }
        return commandList;
    }
}
