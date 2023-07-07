//package com.soul.soulhwapp.DataBase;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//
//
//public class DBHelper {
//    public static int DB_VERSION = 1;
//    private static String DB_NAME = "hitpa.db";
//    SQLiteDatabase mSQLiteDatabase;
//
//    /**
//     * Quick Connect Table to store the details  that is downloaded from the service
//     */
//    public static String QUICK_CONNECT = "quickconnect";
//    public static String CONNECTIONID = "id";
//    public static String EMAILID = "emailid";
//    public static String ADDRESS = "address";
//    public static String USERID = "userid";
//    public static String TOLLFREENO = "tollfreeno";
//
//    private static String CREATE_QUICK_CONNECT = "Create table " + QUICK_CONNECT + " ( " +
//            CONNECTIONID + " integer primary key autoincrement, " + EMAILID + " text, " +
//            ADDRESS + " text, " + USERID + " text, " + TOLLFREENO + " text);";
//
//
//
//
//
//    /**
//     * My Policy Details Table to store the details  that is downloaded from the service
//     */
//    public static String MY_POLICY_DETAILS = "mypolicydetails";
//    public static String POLICY_ID = "id";
//    public static String POLICY_NUMBER = "policyNumber";
//    public static String FROM_DATE = "fromDate";
//    public static String TO_DATE = "toDate";
//    public static String MEMBER_ID = "memberId";
//    public static String MEMBER_NAME = "memberName";
//    public static String MEMBER_AGE = "memberAge";
//    public static String GENDER = "gender";
//    public static String EMPLOYEE_ID = "employeeId";
//    public static String COMPANY = "company";
//    public static String MEMBER_SPOUSE_NAME = "memberSpouseName";
//    public static String PRODUCT_NAME = "productname";
//
//    private static String CREATE_MY_POLICY_DETAILS = "Create table " + MY_POLICY_DETAILS + " ( " +
//            MEMBER_ID + " text primary key, "
//            + POLICY_NUMBER + " text, "
//            + FROM_DATE + " text, "
//            + TO_DATE + " text, "
//            + MEMBER_NAME + " text,"
//            + MEMBER_AGE + " text,"
//            + GENDER + " text,"
//            + EMPLOYEE_ID + " text,"
//            + COMPANY + " text,"
//            + PRODUCT_NAME + " text,"
//            + MEMBER_SPOUSE_NAME + " text);";
//
//
//
//    /**
//     * MCard Details Table to store the details  that is downloaded from the service
//     */
//    public static String MCARD_DETAILS = "mcarddetails";
//    public static String MCARD_ID = "id";
//    public static String MCARD_MAINUHID = "mainuhid";
//    public static String MCARD_NAME = "name";
//    public static String MCARD_RELATIONSHIP = "relationship";
//    public static String MCARD_AGE = "age";
//    public static String MCARD_GENDER = "gender";
//    public static String MCARD_DEPENDENTUHID = "dependentuhid";
//    public static String MCARD_POLICY_NO = "policyno";
//    public static String MCARD_VALIDFROM = "validfrom";
//    public static String MCARD_COMPANY = "company";
//
//
//    private static String CREATE_MCARD_DETAILS = "Create table " + MCARD_DETAILS + " ( " +
//            MCARD_ID + " integer primary key autoincrement,  "
//            +  MCARD_MAINUHID  + " text, "
//            +  MCARD_NAME  + " text, "
//            +  MCARD_RELATIONSHIP + " text, "
//            + MCARD_AGE  + " integer, "
//            + MCARD_GENDER+ " text, "
//            + MCARD_DEPENDENTUHID + " text,"
//            +  MCARD_POLICY_NO  + " text,"
//            + MCARD_COMPANY + " text,"
//            +  MCARD_VALIDFROM+ " text);";
//
//
//    /**
//     * Quick Connect Table to store the details  that is downloaded from the service
//     */
//    public static String HOSPITAL_SEARCH = "hospitalsearch";
//    public static String HOSPITALID = "id";
//    public static String HOSPITAL_NAME = "hospitalname";
//    public static String HOSPITAL_GENERIC = "hospitalgeneric";
//    public static String HOSPITAL_LOCATION = "hospitallocation";
//    public static String HOSPITAL_PHONENO = "hospitalphoneno";
//
//    private static String CREATE_HOSPITAL_SEARCH = "Create table " + HOSPITAL_SEARCH + " ( " +
//            HOSPITALID + " integer primary key autoincrement, " + HOSPITAL_NAME + " text, " +
//            HOSPITAL_GENERIC + " text, " + HOSPITAL_LOCATION + " text, " + HOSPITAL_PHONENO + " text);";
//
//
//
//    /**
//     * My Policy History Details Table to store the details  that is downloaded from the service
//     */
//    public static String POLICY_HISTORY_DETAILS = "policyhistorydetails";
//    public static String POLICY_HISTORY_ID = "id";
//    public static String CLAIM_ID = "claimID";
//    public static String PATIENT_NAME = "patientName";
//    public static String CLAIM_TYPE = "claimType";
//    public static String CLAIM_SUBTYPE = "claimSubType";
//    public static String PREAUTH_ID = "preauthID";
//    public static String CLAIM_STATUS = "claimStatus";
//    public static String DATE_OF_INTIMATION = "dateOfIntimation";
//    public static String DIAGNOSIS = "diagnosis";
//    public static String CLAIM_NO = "claimNo";
//    public static String DATE_OF_ADMISSION = "dateOfAdmission";
//    public static String DATE_OF_DISCHARGE = "dateOfDischarge";
//    public static String HOSPITALNAME = "hospitalName";
//    public static String REQUEST_AMOUNT = "requestedAmount";
//    public static String APPROVE_AMOUNT = "approvedAmount";
//    public static String REJECT_AMOUNT = "rejectedAmount";
//    public static String TOTAL_REQUEST_AMOUNT = "totalRequestedAmount";
//    public static String TOTAL_APPROVE_AMOUNT = "totalApprovedAmount";
//    public static String TOTAL_REJECT_AMOUNT = "totalRejectedAmount";
//    public static String MEMBER_UHID = "memberId";
//    public static String POLICY_PRODUCT_NAME = "productname";
//
//
//    private static String CREATE_POLICY_HISTORY_DETAILS = "Create table " + POLICY_HISTORY_DETAILS + " ( " +
//            POLICY_HISTORY_ID + " integer primary key autoincrement, "
//            + CLAIM_ID + " text, "
//            + PATIENT_NAME + " text, "
//            + CLAIM_TYPE + " text, "
//            + CLAIM_SUBTYPE + " text,"
//            + PREAUTH_ID + " text,"
//            + CLAIM_STATUS + " text,"
//            + DATE_OF_INTIMATION + " text,"
//            + DIAGNOSIS + " text,"
//            + CLAIM_NO + " text,"
//            + DATE_OF_ADMISSION + " text,"
//            + DATE_OF_DISCHARGE + " text,"
//            + HOSPITALNAME + " text,"
//            + REQUEST_AMOUNT + " text,"
//            + APPROVE_AMOUNT + " text,"
//            + REJECT_AMOUNT + " text,"
//            + TOTAL_REQUEST_AMOUNT + " text,"
//            + TOTAL_APPROVE_AMOUNT + " text,"
//            + MEMBER_UHID + " text,"
//            + POLICY_PRODUCT_NAME + " text,"
//            + TOTAL_REJECT_AMOUNT + " text);";
//
//
//
//
//    /**
//     * POLICY_MEMBER_DETAILS Table to store the details  that is downloaded from the service
//     */
//    public static String POLICY_MEMBER_DETAILS = "policymemberdetails";
//    public static String POLICY_MEMBER_DETAILS_ID = "id";
//    public static String POLICY_MEMBER_NAME = "MemberName";
//    public static String POLICY_MEMBER_RELATIONSHIP = "MemberRelationship";
//    public static String POLICY_MEMBER_AGE = "MemberAge";
//    public static String POLICY_MEMBER_GENDER = "MemberGender";
//    public static String MEMBER_POLICY_NUMBER = "MemberPolicyNumber";
//    public static String UHID = "UHID";
//    public static String VALID_TILL = "ValidTill";
//
//
//    private static String CREATE_POLICY_MEMBER_DETAILS = "Create table " + POLICY_MEMBER_DETAILS + " ( " +
//            POLICY_MEMBER_DETAILS_ID + " integer primary key autoincrement, "
//            + POLICY_MEMBER_NAME + " text, "
//            + POLICY_MEMBER_RELATIONSHIP + " text, "
//            + POLICY_MEMBER_AGE + " text, "
//            + POLICY_MEMBER_GENDER + " text,"
//            + MEMBER_POLICY_NUMBER + " text,"
//            + UHID + " text,"
//            + VALID_TILL + " text);";
//
//    /**
//     * {@link java.lang.reflect.Constructor}
//     *
//     * @param context {@link Context}
//     */
//
//    public DBHelper(Context context) {
//        DBHelperManager.setDBName(DB_NAME);
//        DBHelperManager.setDBVersion(DB_VERSION);
//        mSQLiteDatabase = DBHelperManager.getDBInstance(context,
//                new DBHelperManager.TableCreatorInterface(){
//                    @Override
//                    public void TableCreator() {
//                        DBHelperManager
//                                .addTableCreateStatement(CREATE_QUICK_CONNECT);
//                        DBHelperManager
//                                .addTableCreateStatement(CREATE_MY_POLICY_DETAILS);
//                        DBHelperManager
//                                .addTableCreateStatement(CREATE_HOSPITAL_SEARCH);
//                        DBHelperManager
//                                .addTableCreateStatement(CREATE_POLICY_HISTORY_DETAILS);
//                        DBHelperManager
//                                .addTableCreateStatement(CREATE_MCARD_DETAILS);
//                        DBHelperManager
//                                .addTableCreateStatement(CREATE_POLICY_MEMBER_DETAILS);
//
//                    }
//                });
//    }
//}
