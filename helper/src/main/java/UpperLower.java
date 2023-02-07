import java.util.Locale;

public class UpperLower {

    public static void main(String[] args) {
        String line = "CREATE TABLE OUTSIDE_DEALER_SALES_DATA (\n" + "\tSERIAL_NUMBER VARCHAR2(200) NULL,\n" + "\tCHANNEL VARCHAR2(200) NULL,\n" + "\tDEALER_CODE VARCHAR2(200) NULL,\n" + "\tCOMPANY_NAME VARCHAR2(200) NULL,\n" + "\tUNIFY_SOCIAL_CREDIT_CODE VARCHAR2(200) NULL,\n" + "\tBUSINESS_LICENSE_CODE VARCHAR2(200) NULL,\n" + "\tORGANIZATION_CODE VARCHAR2(200) NULL,\n" + "\tTAXPAYER_IDENTIFICATION_CODE VARCHAR2(200) NULL,\n" + "\tSMONTH VARCHAR2(200) NULL,\n" + "\tSMONTH_AMT VARCHAR2(200) NULL,\n" + "\tRETURN_AMOUNT VARCHAR2(200) NULL,\n" + "\tSMONTH_FREQUENCY VARCHAR2(200) NULL,\n" + "\tETL_DATE DATE\n" + ");";
        System.out.println(line.toLowerCase(Locale.ROOT));
    }
}