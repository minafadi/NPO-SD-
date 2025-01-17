package Models;

public class UserFactory {

    public static User createUser(Object... Args) {
        try {
            // Ensure there are arguments and the first argument is a string representing the user type
            if (Args.length < 2 || !(Args[0] instanceof String)) {
                throw new IllegalArgumentException("The first argument must be a String representing the user type (e.g., 'Doctor' or 'Patient').");
            }

            // Get the user type as a string (e.g., "Doctor" or "Patient")
            String userType = (String) Args[0];

            // Remove the first argument (user type) and store the rest in a new array
            Object[] remainingArgs = new Object[Args.length - 1];
            System.arraycopy(Args, 1, remainingArgs, 0, remainingArgs.length);

            // Handle Doctor logic
            if (userType.equalsIgnoreCase("Doctor")) {
                if (remainingArgs.length == 1 && remainingArgs[0] instanceof Integer) {
                    return new Doctor((Integer) remainingArgs[0]);
                } else if (remainingArgs.length == 6 && remainingArgs[0] instanceof Integer &&
                        remainingArgs[1] instanceof String && remainingArgs[2] instanceof String &&
                        remainingArgs[3] instanceof String && remainingArgs[4] instanceof String &&
                        remainingArgs[5] instanceof Integer && remainingArgs[6] instanceof Double) {
                    return new Doctor((Integer) remainingArgs[0], (String) remainingArgs[1], (String) remainingArgs[2],
                            (String) remainingArgs[3], (String) remainingArgs[4], (Integer) remainingArgs[5], (Double) remainingArgs[6]);
                }
                else if(remainingArgs.length == 7){
                    return new Doctor((String)remainingArgs[0], (String)remainingArgs[1],(String)remainingArgs[2],(String)remainingArgs[3],(int)remainingArgs[4],(double)remainingArgs[5],(String)remainingArgs[6]);
                }
                throw new IllegalArgumentException("Invalid arguments for creating a Doctor.");
            }

            // Handle Patient logic
            else if (userType.equalsIgnoreCase("Patient")) {
                if (remainingArgs.length == 2 && remainingArgs[0] instanceof String && remainingArgs[1] instanceof String) {
                    return new Patient((String) remainingArgs[0], (String) remainingArgs[1]);
                } else if (remainingArgs.length == 4 && remainingArgs[0] instanceof String && remainingArgs[1] instanceof String &&
                        remainingArgs[2] instanceof Integer && remainingArgs[3] instanceof Boolean) {
                    return new Patient((String) remainingArgs[0], (String) remainingArgs[1], (Integer) remainingArgs[2], (Boolean) remainingArgs[3], "");
                } else if (remainingArgs.length == 5 && remainingArgs[0] instanceof String && remainingArgs[1] instanceof String &&
                        remainingArgs[2] instanceof Integer && remainingArgs[3] instanceof Boolean && remainingArgs[4] instanceof String) {
                    return new Patient((String) remainingArgs[0], (String) remainingArgs[1], (Integer) remainingArgs[2], (Boolean) remainingArgs[3], (String) remainingArgs[4]);
                } else if (remainingArgs.length == 7 && remainingArgs[0] instanceof Integer && remainingArgs[1] instanceof String &&
                        remainingArgs[2] instanceof String && remainingArgs[3] instanceof Illness && remainingArgs[4] instanceof Integer &&
                        remainingArgs[5] instanceof Boolean && remainingArgs[6] instanceof String) {
                    return new Patient((Integer) remainingArgs[0], (String) remainingArgs[1], (String) remainingArgs[2], (Illness) remainingArgs[3], (Integer) remainingArgs[4], (Boolean) remainingArgs[5], (String) remainingArgs[6]);
                }
                throw new IllegalArgumentException("Invalid arguments for creating a Patient.");
            } else {
                throw new IllegalArgumentException("Unknown user type: " + userType);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create user object: " + e.getMessage(), e);
        }
    }
}
