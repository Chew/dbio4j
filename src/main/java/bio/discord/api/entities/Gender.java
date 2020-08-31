package bio.discord.api.entities;

public enum Gender {
    MALE(0),

    FEMALE(1),

    NON_BINARY(2),

    UNDISCLOSED(3);

    public final int num;

    Gender(int i) {
        num = i;
    }

    public static Gender fromInt(int input) {
        switch (input) {
            case 0:
                return MALE;
            case 1:
                return FEMALE;
            case 2:
                return NON_BINARY;
            case 3:
                return UNDISCLOSED;
        }
        return null;
    }
}
