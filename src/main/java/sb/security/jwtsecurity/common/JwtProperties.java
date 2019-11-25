package sb.security.jwtsecurity.common;

public class JwtProperties {
    public static final String SECRET = "SomeSecretForJWTGeneration";
    public static final int EXPIRATION_TIME =   60000; //for 1 min  //864_000_000; for  10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String  URI="/auth/**";
}
