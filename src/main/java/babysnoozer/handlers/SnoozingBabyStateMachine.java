package babysnoozer.handlers;

import babysnoozer.handlers.commands.CycleQueue;

import java.util.concurrent.TimeUnit;

public enum SnoozingBabyStateMachine {

    SnoozingBabyStateMachine;

    public enum State {
        Null, SetCycleCount, Snooze, ShutDown
    }

    private State state = State.Null;

    private RopeDistance ropeDistance;
    private int cycleCount = 1;
    private CycleQueue cycles;
    private long releaseWaitTime = TimeUnit.SECONDS.toMillis(5l);
    private long drawWaitTime = TimeUnit.MILLISECONDS.toMillis(500l);

    public void setReleaseWaitTime(long releaseWaitTime) {
        this.releaseWaitTime = releaseWaitTime;
    }

    public long getReleaseWaitTime() {
        return releaseWaitTime;
    }

    public void setDrawWaitTime(long drawWaitTime) {
        this.drawWaitTime = drawWaitTime;
    }

    public long getDrawWaitTime() {
        return drawWaitTime;
    }

    public State getState() {
        return state;
    }

    public int getCycleCount() {
        return cycleCount;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCycleCount(int cycleCount) {
        this.cycleCount = cycleCount;
    }

    public int getStartPos() {
        return getRopeDistance().getStartPos();
    }

    public RopeDistance getRopeDistance() {
        if (ropeDistance == null) {
            ropeDistance = new RopeDistance();
        }
        return ropeDistance;
    }

    public CycleQueue getCycles() {
        return cycles;
    }

    public void setCycles(CycleQueue cycles) {
        this.cycles = cycles;
    }

    public void setStartPos(int startPos) {
        getRopeDistance().setStartPos(startPos);
    }

    public int getEndPos() {
        return getRopeDistance().getEndPos();
    }

    public void setEndPos(int endPos) {
        getRopeDistance().setEndPos(endPos);
    }
}
