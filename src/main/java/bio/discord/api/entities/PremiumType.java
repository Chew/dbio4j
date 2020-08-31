package bio.discord.api.entities;

public enum  PremiumType {
    NONE(0),

    NITRO_CLASSIC(1),

    NITRO(2);

    public final int num;

    PremiumType(int i) {
        num = i;
    }

    public static PremiumType fromInt(int input) {
        switch (input) {
            case 0:
                return NONE;
            case 1:
                return NITRO_CLASSIC;
            case 2:
                return NITRO;
        }
        return null;
    }
}
