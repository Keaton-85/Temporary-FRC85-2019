/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lift;

import frc.robot.subsystems.LiftVertical;

import edu.wpi.first.wpilibj.command.Command;

public class VerticalShift extends Command {

    private int _speed, _targetPosition; //positive means going up, negative means going down
    private double _liftTolerance = 10; //the motors have to be within 10 encoder ticks in order for the command to stop

    public VerticalShift(int position, int speed) {
        requires(LiftVertical.getInstance());
        _targetPosition = position;
        _speed = speed;
    }

    @Override
    protected void initialize() {
        super.initialize();
        LiftVertical.getInstance().verticalShift(_targetPosition, _speed);
    }

    @Override
    protected void execute() {
        super.execute();
    }

    @Override
    protected boolean isFinished() {
        return (Math.abs(LiftVertical.getInstance().getVerticalPosition() - _targetPosition) <= _liftTolerance);
    }

    @Override
    protected void end() {
        super.end();
        LiftVertical.getInstance().verticalShift(0,0);
    }

}