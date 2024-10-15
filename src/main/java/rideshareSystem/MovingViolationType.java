package rideshareSystem;

/**
 * Enum MovingViolationType represents the types of moving violations.
 */
public enum MovingViolationType {
    DISTRACTED_DRIVING,
    RECKLESS_DRIVING,
    SPEEDING,
    DUI,
    FAILURE_TO_RESPECT_SIGNS,
    DRIVING_WITHOUT_VALID_LICENSE;

    /**
     * toString() override needed for the formatted printing of moving violations.
     * @return formatted string of the moving violation.
     */
    @Override
    public String toString() {
        switch (this) {
            case DISTRACTED_DRIVING:
                return "Distracted Driving";
            case RECKLESS_DRIVING:
                return "Reckless Driving";
            case SPEEDING:
                return "Speeding";
            case DUI:
                return "DUI";
            case FAILURE_TO_RESPECT_SIGNS:
                return "Failure to respect signs";
            case DRIVING_WITHOUT_VALID_LICENSE:
                return "Driving without a valid license";
            default:
                return null;
        }
    }

}
