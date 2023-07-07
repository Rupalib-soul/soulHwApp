//package com.soul.soulhwapp.DataBase;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.SQLException;
//import android.util.Log;
//
//
//
///**
// * Created by rupali on 01/06/2015.
// */
//public class DBTransactions {
//
//    /**
//     * Database Symbols
//     */
//    public final static String STRING_EQUALS_START = " = '";
//    public final static String STRING_EQUALS_END = "' ";
//    private final static String TAG = "Database Transaction";
//    /**
//     * Select, Update String
//     */
//    private final static String SELECTION = "SELECT * FROM ";
//    private final static String SELECT = "SELECT ";
//
//    /**
//     * Database Attributes
//     */
//    private final static String WHERE = " WHERE ";
//    private final static String FROM = " FROM ";
//    private final static String AND = " AND ";
//    private final static String OR = " OR ";
//    private final static String IS_NOT_NULL = " IS NOT NULL ";
//    private final static String ORDER_BY = " ORDER BY ";
//    private final static String GROUP_BY = " GROUP BY ";
//    private final static String ASC = " ASC ";
//    private final static String DESC = " DESC ";
//    private final static String DISTINCT_START = " DISTINCT( ";
//    private final static String DISTINCT_END = ") ";
//    private final static String LEFT_JOIN = " LEFT JOIN ";
//    private final static String EQUALS = " = ";
//    private final static String NOT_EQUALS = "<>";
//    private final static String NOT_IN_START = " NOT IN (";
//    private final static String NOT_IN_END = ") ";
//    private final static String IN_START = " IN (";
//    private final static String IN_END = ") ";
//    private final static String COMMA = ", ";
//    private final static String DOT = ".";
//    private final static String A = " a";
//    private final static String B = " b";
//    /**
//     * Boolean Attributes
//     */
//    private final static String TRUE = "true";
//    private final static String FALSE = "false";
//    Context context;
//    private String errorMessage = "";
//
//    /**
//     * @param context
//     */
//    public DBTransactions(Context context) {
//        this.context = context;
//    }
//
//    /**
//     * used to insert values int  specific table
//     *
//     * @param contentValues
//     * @param tableName
//     * @return isInserted
//     */
//    public boolean insertContentValuesIntoTable(ContentValues contentValues, String tableName, Context context) {
//        boolean isInserted = true;
//        try {
//            long insertSuccess = DBHelperManager.InsertQuery(tableName, contentValues, context);
//
//            if (insertSuccess != -1)
////                isInserted = false;
//                isInserted = true;
//            Log.i("Row Inserted", tableName + "----------->Row id--------->" + insertSuccess);
//
//        } catch (SQLException e) {
//            isInserted = false;
//            e.printStackTrace();
//            Log.e("Error", "DBTransactions  --->" + e.getMessage());
//        } catch (WrongQueryException e) {
//            isInserted = false;
//            e.printStackTrace();
//            Log.e("Error", "DBTransactions---->" + e.getMessage());
//        } catch (Exception e) {
//            isInserted = false;
//            e.printStackTrace();
//            Log.e("Error", "DBTransactions----->" + e.getMessage());
//        }
//        return isInserted;
//    }
//
//    //getQuickConnectDetails():start
////    public List<QuickConnectModel> getQuickConnectDetails() {
////        List<QuickConnectModel> quickConnectList = null;
////        String selectQuery = SELECTION + DBHelper.QUICK_CONNECT;
////        try {
////            quickConnectList = QuickConnectParser.getRecordsList(DBHelperManager
////                    .SelectQuery(selectQuery));
////        } catch (SQLException e) {
////            e.printStackTrace();
////        } catch (WrongQueryException e) {
////            e.printStackTrace();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return quickConnectList;
////    }
//
////getQuickConnectDetails():end
//
//    //getMyPolicyDetails():start
////    public ArrayList<MyPolicyDetailsModel> getMyPolicyDetails(String userUHID) {
////        ArrayList<MyPolicyDetailsModel> myPolicyDetailsModelList = null;
////        String selectQuery = SELECTION + DBHelper.MY_POLICY_DETAILS + WHERE + DBHelper.MEMBER_ID
////                + EQUALS + userUHID;
////        try {
////            myPolicyDetailsModelList = MyPolicyParser.getPolicyRecordsList(DBHelperManager
////                    .SelectQuery(selectQuery));
////        } catch (SQLException e) {
////            e.printStackTrace();
////        } catch (WrongQueryException e) {
////            e.printStackTrace();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return myPolicyDetailsModelList;
////    }
//    //getMyPolicyDetails():end
//
//
//    //getMCard():start
////    public List<MCardSearchModel> getNameRelationshipMCardDetails(String userUHID) {
////        List<MCardSearchModel> mcardModelList = null;
////        String selectQuery = SELECT + DBHelper.MCARD_NAME + COMMA + DBHelper.MCARD_RELATIONSHIP + FROM +
////                DBHelper.MCARD_DETAILS + WHERE + DBHelper.MCARD_MAINUHID
////                + STRING_EQUALS_START + userUHID + STRING_EQUALS_END + AND + DBHelper.MCARD_RELATIONSHIP + " != " + " 'Self' " + ";";
////        try {
////            mcardModelList = MCardParser.getMCardRecordsList(DBHelperManager
////                    .SelectQuery(selectQuery));
////        } catch (SQLException e) {
////            e.printStackTrace();
////        } catch (WrongQueryException e) {
////            e.printStackTrace();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return mcardModelList;
////    }
//    //getMCard():end
//
//    //getMCard():start
////    public ArrayList<MCardSearchModel> getMCardDetails(String userUHID) {
////        ArrayList<MCardSearchModel> mcardModelList = null;
////        String selectQuery = SELECTION + DBHelper.MCARD_DETAILS + WHERE + DBHelper.MCARD_MAINUHID
////                + STRING_EQUALS_START + userUHID + STRING_EQUALS_END;
////        try {
////            mcardModelList = MCardParser.getMCardRecordsList(DBHelperManager
////                    .SelectQuery(selectQuery));
////        } catch (SQLException e) {
////            e.printStackTrace();
////        } catch (WrongQueryException e) {
////            e.printStackTrace();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////
////        return mcardModelList;
////    }
//    //getMCard():end
//
//
//
//    //getMCard():start
////    public ArrayList<MCardSearchModel> getPatientNameList(String userUHID) {
////        ArrayList<MCardSearchModel> mcardModelList = null;
////        String selectQuery = SELECT + DBHelper.MCARD_NAME + FROM +
////                DBHelper.MCARD_DETAILS + WHERE + DBHelper.MCARD_MAINUHID
////                + STRING_EQUALS_START + userUHID + STRING_EQUALS_END ;
////
////        try {
////            mcardModelList = MCardParser.getMCardRecordsList(DBHelperManager
////                    .SelectQuery(selectQuery));
////        } catch (SQLException e) {
////            e.printStackTrace();
////        } catch (WrongQueryException e) {
////            e.printStackTrace();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////
////        return mcardModelList;
////    }
//    //getMCard():end
//
//
///*
//    public List<UpdatesDetailsModel> getUpdatesDetails) {
//        List<UpdatesDetailsModel> myUpdatesDetailsModelList = null;
//        String selectQuery = SELECTION + DBHelper.POLICY_HISTORY_DETAILS;
//        try {
//            myUpdatesDetailsModelList = MyPolicyParser.getPolicyRecordsList(DBHelperManager
//                    .SelectQuery(selectQuery));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (WrongQueryException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return myUpdatesDetailsModelList;
//    }*/
//
//
//    //getHospitalSearchDetails():start
////    public List<HospitalSearchModel> getHospitalSearchDetails() {
////        List<HospitalSearchModel> hospitalSearchModelList = null;
////        String selectQuery = SELECTION + DBHelper.HOSPITAL_SEARCH;
////        try {
////            hospitalSearchModelList = HospitalSearchParser.getHospitalSearchRecordsList(DBHelperManager
////                    .SelectQuery(selectQuery));
////        } catch (SQLException e) {
////            e.printStackTrace();
////        } catch (WrongQueryException e) {
////            e.printStackTrace();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return hospitalSearchModelList;
////    }
//    //getHospitalSearchDetails():end
//
//
//    //getPolicyHistoryDetails():start
////    public ArrayList<PolicyHistoryModel> getPolicyHistoryDetails(String userUHID) {
////        ArrayList<PolicyHistoryModel> policyHistoryModelList = null;
////
////        String selectQuery = SELECTION + DBHelper.POLICY_HISTORY_DETAILS + WHERE +  DBHelper.MEMBER_UHID
////                             + EQUALS + userUHID;
////
////        try {
////            policyHistoryModelList = PolicyHistoryParser.getPolicyHistoryRecordsList(DBHelperManager
////                    .SelectQuery(selectQuery));
////        } catch (SQLException e) {
////            e.printStackTrace();
////        } catch (WrongQueryException e) {
////            e.printStackTrace();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return policyHistoryModelList;
////    }
//    //getPolicyHistoryDetails():end
//
//
//    //getMyPolicyDetails():start
////    public ArrayList<MyPolicyDetailsModel> getMyPolicyNumberDetails(String userUHID) {
////        ArrayList<MyPolicyDetailsModel> myPolicyDetailsModelList = null;
////        String selectQuery = SELECT + DBHelper.POLICY_NUMBER + FROM + DBHelper.MY_POLICY_DETAILS + WHERE + DBHelper.MEMBER_ID
////                + EQUALS + userUHID;
////        try {
////            myPolicyDetailsModelList = MyPolicyParser.getPolicyRecordsList(DBHelperManager
////                    .SelectQuery(selectQuery));
////        } catch (SQLException e) {
////            e.printStackTrace();
////        } catch (WrongQueryException e) {
////            e.printStackTrace();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return myPolicyDetailsModelList;
////    }
//    //getMyPolicyDetails():end
//
//
//    //getUppdateDetails():start
////    public List<UpdatesDetailsModel> getUpdateDetails(String Claim_Id) {
////        List<UpdatesDetailsModel> updatesDetailsModelList = null;
////        String selectQuery = SELECTION + DBHelper.POLICY_HISTORY_DETAILS + WHERE + DBHelper.CLAIM_ID + EQUALS + Claim_Id;
////        try {
////            updatesDetailsModelList = UpdateDetailsParser.getUpdateDetailsRecordsList(DBHelperManager
////                    .SelectQuery(selectQuery));
////        } catch (SQLException e) {
////            e.printStackTrace();
////        } catch (WrongQueryException e) {
////            e.printStackTrace();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return updatesDetailsModelList;
////    }
//    //getUpdateDetails():end
//
//
//    public boolean upDateRecord(ContentValues contentValues, String Table, String id) {
//        boolean update = DBHelperManager.upDateRecord(contentValues, Table, id);
//        return update;
//    }
//
//    public boolean upDateOrderRecord(ContentValues values, String Table, String id) {
//        boolean update = DBHelperManager.upDateOrderRecord(values, Table, id);
//        return update;
//    }
//
//    public boolean upDateTableRecord(ContentValues values, String Table, String id) {
//        boolean update = DBHelperManager.upDateTableRecord(values, Table, id);
//        return update;
//    }
//
//
//    public boolean checkFor_UnSentRecords(ContentValues values, String Table, String id) {
//        boolean update = DBHelperManager.upDateOrderRecord(values, Table, id);
//        return update;
//    }
//
//
//}
//
