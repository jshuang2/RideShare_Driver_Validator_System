package rideshareSystem;

/**
 * Enum NonMovingViolationType represents the types of non-moving violations.
 */
public enum NonMovingViolationType {
    PARKING_VIOLATION,
    PAPERWORK_ISSUE,
    VEHICLE_PROBLEM;

    /**
     * toString() override needed to allow formatted printing of non-moving violations.
     * @return formatted string of the non-moving violation.
     */
    @Override
    public String toString() {
        switch (this) {
            case PARKING_VIOLATION:
                return "Parking Violation";
            case PAPERWORK_ISSUE:
                return "Paperwork Issue";
            case VEHICLE_PROBLEM:
                return "Vehicle Problem";
            default:
                return null;
        }
    }
}
