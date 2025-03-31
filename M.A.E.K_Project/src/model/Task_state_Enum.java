package model;

/**
 * The TaskStateEnum class represents the state of a task.
 * It provides methods to get the state value.
 */
public enum Task_state_Enum {
    PENDING, COMPLETED;

    /**
     * Returns the name of the state.
     *
     * @return the state name
     */
    public String value() {
        return this.name();
    }
}
